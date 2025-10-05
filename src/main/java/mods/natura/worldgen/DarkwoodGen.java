package mods.natura.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.ForgeDirection;

import mods.natura.blocks.trees.NSaplingBlock;
import mods.natura.common.NContent;

public class DarkwoodGen extends WorldGenerator {

    /** The minimum height of a generated tree. */
    private final int minTreeHeight;

    /** The metadata value of the wood to use in tree generation. */
    private final int metaWood;

    private final boolean seekGround;

    public DarkwoodGen(boolean notify) {
        this(notify, 4, 0);
    }

    public DarkwoodGen(boolean notify, int minTreeHeight, int logMetadata) {
        super(notify);
        this.minTreeHeight = minTreeHeight;
        this.metaWood = logMetadata;
        seekGround = !notify;
    }

    int findGround(World world, int x, int y, int z) {
        boolean foundGround = false;
        int height = y;
        do {
            height--;
            Block blockBelow = world.getBlock(x, height, z);
            if (blockBelow == Blocks.netherrack || blockBelow == Blocks.soul_sand || height < 0) {
                foundGround = true;
            }
        } while (!foundGround);
        return height + 1;
    }

    public boolean generate(World world, Random random, int xPos, int yPos, int zPos) {
        int treeHeight = random.nextInt(3) + this.minTreeHeight;
        if (treeHeight < 4) {
            treeHeight = 4;
        }
        boolean flag = true;

        if (seekGround) {
            yPos = findGround(world, xPos, yPos, zPos);
        }

        if (yPos >= 1 && yPos + treeHeight + 1 <= 256) {
            int i1;
            byte b0;
            int j1;
            int k1;

            for (i1 = yPos; i1 <= yPos + 1 + treeHeight; ++i1) {
                b0 = 1;

                if (i1 == yPos) {
                    b0 = 0;
                }

                if (i1 >= yPos + 1 + treeHeight - 2) {
                    b0 = 2;
                }

                for (int l1 = xPos - b0; l1 <= xPos + b0 && flag; ++l1) {
                    for (j1 = zPos - b0; j1 <= zPos + b0 && flag; ++j1) {
                        if (i1 >= 0 && i1 < 256) {

                            Block block = world.getBlock(l1, i1, j1);

                            if (block != Blocks.air && !block.isLeaves(world, l1, i1, j1)
                                    && block != Blocks.netherrack
                                    && block != Blocks.soul_sand
                                    && !block.isWood(world, l1, i1, j1)) {
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag) {
                return false;
            } else {
                Block soil = world.getBlock(xPos, yPos - 1, zPos);
                boolean isSoil = (soil.canSustainPlant(
                        world,
                        xPos,
                        yPos - 1,
                        zPos,
                        ForgeDirection.UP,
                        (NSaplingBlock) NContent.floraSapling)) || soil == Blocks.netherrack;

                if (isSoil && yPos < 256 - treeHeight - 1) {
                    soil.onPlantGrow(world, xPos, yPos - 1, zPos, xPos, yPos, zPos);
                    b0 = 3;
                    byte b1 = 0;
                    int i2;
                    int j2;
                    int k2;

                    for (j1 = yPos - b0 + treeHeight; j1 <= yPos + treeHeight; ++j1) {
                        k1 = j1 - (yPos + treeHeight);
                        i2 = b1 + 1 - k1 / 2;

                        for (j2 = xPos - i2; j2 <= xPos + i2; ++j2) {
                            k2 = j2 - xPos;

                            for (int l2 = zPos - i2; l2 <= zPos + i2; ++l2) {
                                int i3 = l2 - zPos;

                                if (Math.abs(k2) != i2 || Math.abs(i3) != i2 || random.nextInt(2) != 0 && k1 != 0) {
                                    Block block = world.getBlock(j2, j1, l2);

                                    if (block.canBeReplacedByLeaves(world, j2, j1, l2)) {
                                        this.setBlockAndNotifyAdequately(
                                                world,
                                                j2,
                                                j1,
                                                l2,
                                                NContent.darkLeaves,
                                                random.nextInt(25) == 0 ? 2 : random.nextInt(15) == 0 ? 1 : 0);
                                    }
                                }
                            }
                        }
                    }

                    for (j1 = 0; j1 < treeHeight; ++j1) {
                        Block block = world.getBlock(xPos, yPos + j1, zPos);

                        if (block == Blocks.air || block.isLeaves(world, xPos, yPos + j1, zPos)
                                || block.canBeReplacedByLeaves(world, xPos, yPos + j1, zPos)) {
                            this.setBlockAndNotifyAdequately(
                                    world,
                                    xPos,
                                    yPos + j1,
                                    zPos,
                                    NContent.darkTree,
                                    this.metaWood);
                        }
                    }

                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}
