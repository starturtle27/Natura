package mods.natura.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockPressurePlate.Sensitivity;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.natura.Natura;
import mods.natura.blocks.CloudBlock;
import mods.natura.blocks.GrassBlock;
import mods.natura.blocks.GrassSlab;
import mods.natura.blocks.NButton;
import mods.natura.blocks.NFenceGate;
import mods.natura.blocks.NPressurePlate;
import mods.natura.blocks.NStairs;
import mods.natura.blocks.NTrapdoor;
import mods.natura.blocks.PlankSlab1;
import mods.natura.blocks.PlankSlab2;
import mods.natura.blocks.crops.BerryBush;
import mods.natura.blocks.crops.CropBlock;
import mods.natura.blocks.crops.FlowerBlock;
import mods.natura.blocks.crops.Glowshroom;
import mods.natura.blocks.crops.LargeGlowshroom;
import mods.natura.blocks.crops.NetherBerryBush;
import mods.natura.blocks.crops.ThornVines;
import mods.natura.blocks.nether.HeatSand;
import mods.natura.blocks.nether.NetherGlass;
import mods.natura.blocks.overrides.AlternateBookshelf;
import mods.natura.blocks.overrides.AlternateFence;
import mods.natura.blocks.overrides.AlternatePressurePlate;
import mods.natura.blocks.overrides.AlternateWorkbench;
import mods.natura.blocks.overrides.NetherLever;
import mods.natura.blocks.overrides.NetherrackButton;
import mods.natura.blocks.tech.BlazeHopper;
import mods.natura.blocks.tech.BlazeRail;
import mods.natura.blocks.tech.BlazeRailDetector;
import mods.natura.blocks.tech.BlazeRailPowered;
import mods.natura.blocks.tech.NetherPistonBase;
import mods.natura.blocks.tech.NetherPistonExtension;
import mods.natura.blocks.tech.NetherrackFurnaceBlock;
import mods.natura.blocks.tech.NetherrackFurnaceLogic;
import mods.natura.blocks.tech.RespawnObelisk;
import mods.natura.blocks.trees.DarkTreeBlock;
import mods.natura.blocks.trees.LogTwoxTwo;
import mods.natura.blocks.trees.NDoor;
import mods.natura.blocks.trees.NLeaves;
import mods.natura.blocks.trees.NLeavesDark;
import mods.natura.blocks.trees.NLeavesNocolor;
import mods.natura.blocks.trees.NSaplingBlock;
import mods.natura.blocks.trees.OverworldLeaves;
import mods.natura.blocks.trees.OverworldSapling;
import mods.natura.blocks.trees.OverworldTreeBlock;
import mods.natura.blocks.trees.Planks;
import mods.natura.blocks.trees.SaguaroBlock;
import mods.natura.blocks.trees.SimpleLog;
import mods.natura.blocks.trees.TreeBlock;
import mods.natura.blocks.trees.WillowBlock;
import mods.natura.entity.BabyHeatscarSpider;
import mods.natura.entity.FusewoodArrow;
import mods.natura.entity.HeatscarSpider;
import mods.natura.entity.ImpEntity;
import mods.natura.entity.NitroCreeper;
import mods.natura.items.BerryItem;
import mods.natura.items.BerryMedley;
import mods.natura.items.BoneBag;
import mods.natura.items.BowlEmpty;
import mods.natura.items.BowlStew;
import mods.natura.items.CactusJuice;
import mods.natura.items.ImpMeat;
import mods.natura.items.NaturaSeeds;
import mods.natura.items.NetherBerryItem;
import mods.natura.items.NetherFoodItem;
import mods.natura.items.PlantItem;
import mods.natura.items.SeedBag;
import mods.natura.items.SeedFood;
import mods.natura.items.SpawnEgg;
import mods.natura.items.StickItem;
import mods.natura.items.blocks.BerryBushItem;
import mods.natura.items.blocks.CloudItem;
import mods.natura.items.blocks.DarkTreeItem;
import mods.natura.items.blocks.FenceItem;
import mods.natura.items.blocks.GlowshroomItem;
import mods.natura.items.blocks.GrassBlockItem;
import mods.natura.items.blocks.GrassSlabItem;
import mods.natura.items.blocks.LogTwoxTwoItem;
import mods.natura.items.blocks.NAlternateItem;
import mods.natura.items.blocks.NDoorItem;
import mods.natura.items.blocks.NLeavesDarkItem;
import mods.natura.items.blocks.NLeavesItem;
import mods.natura.items.blocks.NSaplingItem;
import mods.natura.items.blocks.NetherBerryBushItem;
import mods.natura.items.blocks.NetherGlassItem;
import mods.natura.items.blocks.NoColorLeavesItem;
import mods.natura.items.blocks.OverworldLeavesItem;
import mods.natura.items.blocks.OverworldSaplingItem;
import mods.natura.items.blocks.OverworldTreeItem;
import mods.natura.items.blocks.PlankSlab1Item;
import mods.natura.items.blocks.PlankSlab2Item;
import mods.natura.items.blocks.PlanksItem;
import mods.natura.items.blocks.RedwoodItem;
import mods.natura.items.blocks.SaguaroItem;
import mods.natura.items.blocks.TreeItem;
import mods.natura.items.blocks.WillowItem;
import mods.natura.items.tools.FlintAndBlaze;
import mods.natura.items.tools.NaturaArmor;
import mods.natura.items.tools.NaturaBow;
import mods.natura.items.tools.NaturaHatchet;
import mods.natura.items.tools.NaturaKama;
import mods.natura.items.tools.NaturaPickaxe;
import mods.natura.items.tools.NaturaShovel;
import mods.natura.items.tools.NaturaSword;
import mods.natura.util.DispenserBehaviorSpawnEgg;
import tconstruct.library.crafting.PatternBuilder;

public class NContent implements IFuelHandler {

    public void preInit() {
        // Vanilla
        Blocks.netherrack.setResistance(4f);

        // Nether blocks
        /*
         * infernalStone = new NBlock(PHNatura.infernalStone, Material.rock, 1.5f, new String[] { "infernal_stone"
         * }).setBlockName("infernalStone"); GameRegistry.registerBlock(infernalStone, "infernalStone");
         */
        heatSand = new HeatSand().setBlockName("HeatSand"); // .setLightLevel(0.375f);
        heatSand.setHarvestLevel("shovel", 0);
        GameRegistry.registerBlock(heatSand, "heatsand");
        if (PHNatura.enableNetherFurnaces) {
            netherrackFurnace = new NetherrackFurnaceBlock().setHardness(3.5F).setCreativeTab(NaturaTab.tab)
                    .setBlockName("furnace.netherrack");
            GameRegistry.registerBlock(netherrackFurnace, "NetherFurnace");
            GameRegistry.registerTileEntity(NetherrackFurnaceLogic.class, "netherrackFurnace");
        }
        if (PHNatura.enableObelisks) {
            respawnObelisk = new RespawnObelisk(Material.wood).setHardness(1.0F).setResistance(1000000F)
                    .setCreativeTab(NaturaTab.tab).setBlockName("nether.obelisk");
            GameRegistry.registerBlock(respawnObelisk, "Obelisk");
        }
        if (PHNatura.enableNetherGlass) {
            netherGlass = (NetherGlass) new NetherGlass().setHardness(1.0F).setResistance(3000F)
                    .setStepSound(Block.soundTypeGlass).setCreativeTab(NaturaTab.tab).setBlockName("nether.glass");
            GameRegistry.registerBlock(netherGlass, NetherGlassItem.class, "NetherGlass");
        }

        // Blaze Rails
        if (PHNatura.enableBlazeRails) {
            brailPowered = new BlazeRailPowered(false).setHardness(0.7F).setBlockName("blazerail.powered")
                    .setBlockTextureName("natura:brail_golden");
            GameRegistry.registerBlock(brailPowered, "BrailPowered");
            brailDetector = new BlazeRailDetector().setHardness(0.7F).setBlockName("blazerail.detector")
                    .setBlockTextureName("natura:brail_detector");
            GameRegistry.registerBlock(brailDetector, "BrailDetector");
            brail = new BlazeRail().setHardness(0.7F).setBlockName("blazerail")
                    .setBlockTextureName("natura:brail_normal");
            GameRegistry.registerBlock(brail, "Blazerail");
            brailActivator = new BlazeRailPowered(true).setHardness(0.7F).setBlockName("blazerail.activator")
                    .setBlockTextureName("natura:brail_activator");
            GameRegistry.registerBlock(brailActivator, "BrailActivator");
        }

        /*
         * piston = (NetherPistonBase) new NetherPistonBase(PHNatura.piston, false).setBlockName("nether.piston");
         * GameRegistry.registerBlock(piston, "natura.piston"); pistonSticky = (NetherPistonBase) new
         * NetherPistonBase(PHNatura.pistonSticky, true).setBlockName("nether.piston.sticky");
         * GameRegistry.registerBlock(pistonSticky, "natura.piston.sticky"); pistonExtension = new
         * NetherPistonExtension(PHNatura.pistonExtension); GameRegistry.registerBlock(pistonExtension,
         * "natura.piston.extension");
         */
        if (PHNatura.enableBlazeHoppers) {
            netherHopper = (BlazeHopper) new BlazeHopper().setHardness(3.0F).setResistance(8.0F)
                    .setCreativeTab(NaturaTab.tab).setBlockName("nether.hopper");
            GameRegistry.registerBlock(netherHopper, "NetherHopper");
        }
        if (PHNatura.enableNetherPressurePlates) {
            netherPressurePlate = new AlternatePressurePlate("netherrack", Material.rock, Sensitivity.mobs)
                    .setHardness(0.5F).setStepSound(Block.soundTypeStone).setBlockName("pressurePlate");
            GameRegistry.registerBlock(netherPressurePlate, "NetherPressurePlate");
        }
        if (PHNatura.enableNetherButtons) {
            netherButton = new NetherrackButton().setHardness(0.5F).setStepSound(Block.soundTypeStone)
                    .setBlockName("button");
            GameRegistry.registerBlock(netherButton, "NetherButton");
        }
        if (PHNatura.enableNetherLevers) {
            netherLever = new NetherLever().setHardness(0.5F).setStepSound(Block.soundTypeWood).setBlockName("lever")
                    .setBlockTextureName("natura:nlever");
            GameRegistry.registerBlock(netherLever, "NetherLever");
        }

        // Nether plants
        thornVines = new ThornVines().setBlockName("Thornvines").setLightLevel(0.625f);
        GameRegistry.registerBlock(thornVines, "Thornvines");
        Blocks.fire.setFireInfo(thornVines, 5, 100);
        glowshroom = (Glowshroom) new Glowshroom().setBlockName("Glowshroom").setLightLevel(0.625f);
        GameRegistry.registerBlock(glowshroom, GlowshroomItem.class, "Glowshroom");
        glowshroomGreen = new LargeGlowshroom(Material.wood, "green").setBlockName("greenGlowshroom")
                .setLightLevel(0.5f);
        GameRegistry.registerBlock(glowshroomGreen, "greenGlowshroom");
        glowshroomPurple = new LargeGlowshroom(Material.wood, "purple").setBlockName("purpleGlowshroom")
                .setLightLevel(0.5f);
        GameRegistry.registerBlock(glowshroomPurple, "purpleGlowshroom");
        glowshroomBlue = new LargeGlowshroom(Material.wood, "blue").setBlockName("blueGlowshroom")
                .setLightLevel(0.625f);
        GameRegistry.registerBlock(glowshroomBlue, "blueGlowshroom");

        // Berry bushes
        if (PHNatura.enableNetherBerryBushes) {
            netherBerryBush = new NetherBerryBush();
            GameRegistry.registerBlock(netherBerryBush, NetherBerryBushItem.class, "NetherBerryBush");
        }
        if (PHNatura.enableBerryBushes) {
            berryBush = new BerryBush();
            GameRegistry.registerBlock(berryBush, BerryBushItem.class, "BerryBush");
            Blocks.fire.setFireInfo(berryBush, 60, 100);
        }

        // Overworld plants
        crops = (CropBlock) new CropBlock().setBlockName("natura.crops");
        GameRegistry.registerBlock(crops, "N Crops"); // TODO 1.8 RENAME
        saguaro = new SaguaroBlock().setBlockName("saguaro.block");
        GameRegistry.registerBlock(saguaro, SaguaroItem.class, "Saguaro");
        bluebells = (FlowerBlock) new FlowerBlock().setBlockName("bluebells");
        GameRegistry.registerBlock(bluebells, "Bluebells");
        Blocks.fire.setFireInfo(bluebells, 60, 100);
        // TODO 1.7 apparently this isn't so simple anymore
        // MinecraftForge.addGrassPlant(bluebells, 0, 18);

        // Full grass blocks and slabs
        grassBlock = new GrassBlock().setBlockName("GrassBlock");
        grassBlock.stepSound = Block.soundTypeGrass;
        GameRegistry.registerBlock(grassBlock, GrassBlockItem.class, "GrassBlock");
        GrassSlab sGSlab = (GrassSlab) new GrassSlab(false).setBlockName("GrassSlab");
        GrassSlab dGSlab = (GrassSlab) new GrassSlab(true).setBlockName("GrassSlabDouble");
        grassSlab = GameRegistry.registerBlock(sGSlab, GrassSlabItem.class, "GrassSlab", sGSlab, dGSlab);
        grassSlabDouble = GameRegistry.registerBlock(dGSlab, GrassSlabItem.class, "GrassSlabDouble", sGSlab, dGSlab);

        // Clouds
        cloud = new CloudBlock();
        GameRegistry.registerBlock(cloud, CloudItem.class, "Cloud");

        // Saplings
        rareSapling = (OverworldSapling) new OverworldSapling().setBlockName("RareSapling");
        GameRegistry.registerBlock(rareSapling, OverworldSaplingItem.class, "Rare Sapling");
        floraSapling = (NSaplingBlock) new NSaplingBlock().setBlockName("natura.sapling");
        GameRegistry.registerBlock(floraSapling, NSaplingItem.class, "florasapling");

        // Logs
        tree = new TreeBlock().setBlockName("natura.treeblock");
        GameRegistry.registerBlock(tree, TreeItem.class, "tree");
        Blocks.fire.setFireInfo(tree, 5, 5);
        redwood = new SimpleLog().setBlockName("natura.redwood");
        GameRegistry.registerBlock(redwood, RedwoodItem.class, "redwood");
        // Redwood just a bit more flammable, because it is massive
        Blocks.fire.setFireInfo(redwood, 40, 10);
        willow = new WillowBlock().setBlockName("willow");
        GameRegistry.registerBlock(willow, WillowItem.class, "willow");
        Blocks.fire.setFireInfo(willow, 5, 5);
        bloodwood = new LogTwoxTwo(8f, Material.wood).setBlockName("bloodwood");
        GameRegistry.registerBlock(bloodwood, LogTwoxTwoItem.class, "bloodwood");
        rareTree = new OverworldTreeBlock().setBlockName("RareTree");
        GameRegistry.registerBlock(rareTree, OverworldTreeItem.class, "Rare Tree");
        Blocks.fire.setFireInfo(rareTree, 5, 5);
        darkTree = new DarkTreeBlock().setBlockName("Darktree");
        GameRegistry.registerBlock(darkTree, DarkTreeItem.class, "Dark Tree");
        // Nether trees shouldn't be burnable
        tree.setHarvestLevel("axe", -1);
        redwood.setHarvestLevel("axe", -1);
        bloodwood.setHarvestLevel("axe", 2);
        darkTree.setHarvestLevel("axe", 1, 1);
        darkTree.setHarvestLevel("axe", -1, 0);

        // Leaves
        floraLeaves = (NLeaves) new NLeaves().setBlockName("natura.leaves");
        GameRegistry.registerBlock(floraLeaves, NLeavesItem.class, "floraleaves");
        Blocks.fire.setFireInfo(floraLeaves, 30, 60);
        floraLeavesNoColor = (NLeaves) new NLeavesNocolor().setBlockName("natura.leavesnocolor");
        GameRegistry.registerBlock(floraLeavesNoColor, NoColorLeavesItem.class, "floraleavesnocolor");
        Blocks.fire.setFireInfo(floraLeavesNoColor, 30, 60);
        rareLeaves = (NLeaves) new OverworldLeaves().setBlockName("RareLeaves");
        GameRegistry.registerBlock(rareLeaves, OverworldLeavesItem.class, "Rare Leaves");
        Blocks.fire.setFireInfo(rareLeaves, 30, 60);
        darkLeaves = (NLeaves) new NLeavesDark().setBlockName("Darkleaves");
        GameRegistry.registerBlock(darkLeaves, NLeavesDarkItem.class, "Dark Leaves");
        // Nether trees shouldn't be burnable

        // Wooden Planks
        planks = new Planks().setBlockName("natura.planks");
        GameRegistry.registerBlock(planks, PlanksItem.class, "planks");
        Blocks.fire.setFireInfo(planks, 5, 20);

        // Wooden Workbenches
        if (PHNatura.enableWoodenWorkbenches) {
            alternateWorkbench = new AlternateWorkbench().setHardness(2.5F).setStepSound(Block.soundTypeWood)
                    .setBlockName("workbench").setCreativeTab(NaturaTab.tab);
            GameRegistry.registerBlock(alternateWorkbench, NAlternateItem.class, "Natura.workbench");
        }

        // Wooden Bookshelves
        if (PHNatura.enableWoodenBookshelves) {
            alternateBookshelf = new AlternateBookshelf().setHardness(1.5F).setStepSound(Block.soundTypeWood)
                    .setBlockName("bookshelf").setCreativeTab(NaturaTab.tab);
            GameRegistry.registerBlock(alternateBookshelf, NAlternateItem.class, "Natura.bookshelf");
            Blocks.fire.setFireInfo(alternateBookshelf, 30, 20);
        }

        // Wooden Stairs
        if (PHNatura.enableWoodenStairs) {
            // Eucalyptus
            stairEucalyptus = new NStairs(planks, 0).setBlockName("stair.eucalyptus");
            stairEucalyptus.stepSound = Block.soundTypeWood;
            GameRegistry.registerBlock(stairEucalyptus, "stair.eucalyptus");
            Blocks.fire.setFireInfo(stairEucalyptus, 5, 20);
            // Sakura
            stairSakura = new NStairs(planks, 1).setBlockName("stair.sakura");
            stairSakura.stepSound = Block.soundTypeWood;
            GameRegistry.registerBlock(stairSakura, "stair.sakura");
            Blocks.fire.setFireInfo(stairSakura, 5, 20);
            // Ghostwood
            stairGhostwood = new NStairs(planks, 2).setBlockName("stair.ghostwood");
            stairGhostwood.stepSound = Block.soundTypeWood;
            GameRegistry.registerBlock(stairGhostwood, "stair.ghostwood");
            // Redwood
            stairRedwood = new NStairs(planks, 3).setBlockName("stair.redwood");
            stairRedwood.stepSound = Block.soundTypeWood;
            GameRegistry.registerBlock(stairRedwood, "stair.redwood");
            Blocks.fire.setFireInfo(stairRedwood, 5, 20);
            // Bloodwood
            stairBloodwood = new NStairs(planks, 4).setBlockName("stair.bloodwood");
            stairBloodwood.stepSound = Block.soundTypeWood;
            GameRegistry.registerBlock(stairBloodwood, "stair.bloodwood");
            // Hopseed
            stairHopseed = new NStairs(planks, 5).setBlockName("stair.hopseed");
            stairHopseed.stepSound = Block.soundTypeWood;
            GameRegistry.registerBlock(stairHopseed, "stair.hopseed");
            Blocks.fire.setFireInfo(stairHopseed, 5, 20);
            // Maple
            stairMaple = new NStairs(planks, 6).setBlockName("stair.maple");
            stairMaple.stepSound = Block.soundTypeWood;
            GameRegistry.registerBlock(stairMaple, "stair.maple");
            Blocks.fire.setFireInfo(stairMaple, 5, 20);
            // Silverbell
            stairSilverbell = new NStairs(planks, 7).setBlockName("stair.silverbell");
            stairSilverbell.stepSound = Block.soundTypeWood;
            GameRegistry.registerBlock(stairSilverbell, "stair.silverbell");
            Blocks.fire.setFireInfo(stairSilverbell, 5, 20);
            // Amaranth
            stairAmaranth = new NStairs(planks, 8).setBlockName("stair.amaranth");
            stairAmaranth.stepSound = Block.soundTypeWood;
            GameRegistry.registerBlock(stairAmaranth, "stair.amaranth");
            Blocks.fire.setFireInfo(stairAmaranth, 5, 20);
            // Tiger
            stairTiger = new NStairs(planks, 9).setBlockName("stair.tiger");
            stairTiger.stepSound = Block.soundTypeWood;
            GameRegistry.registerBlock(stairTiger, "stair.tiger");
            Blocks.fire.setFireInfo(stairTiger, 5, 20);
            // Willow
            stairWillow = new NStairs(planks, 10).setBlockName("stair.willow");
            stairWillow.stepSound = Block.soundTypeWood;
            GameRegistry.registerBlock(stairWillow, "stair.willow");
            Blocks.fire.setFireInfo(stairWillow, 5, 20);
            // Darkwood
            stairDarkwood = new NStairs(planks, 11).setBlockName("stair.darkwood");
            stairDarkwood.stepSound = Block.soundTypeWood;
            GameRegistry.registerBlock(stairDarkwood, "stair.darkwood");
            // Fusewood
            stairFusewood = new NStairs(planks, 12).setBlockName("stair.fusewood");
            stairFusewood.stepSound = Block.soundTypeWood;
            GameRegistry.registerBlock(stairFusewood, "stair.fusewood");
        }

        // Wooden Slabs
        if (PHNatura.enableWoodenSlabs) {
            PlankSlab1 dslab1 = (PlankSlab1) new PlankSlab1(true).setBlockName("plankSlab1Double");
            PlankSlab1 sSlab1 = (PlankSlab1) new PlankSlab1(false).setBlockName("plankSlab1");
            plankSlab1Double = GameRegistry
                    .registerBlock(dslab1, PlankSlab1Item.class, "plankSlab1Double", sSlab1, dslab1);
            plankSlab1 = GameRegistry.registerBlock(sSlab1, PlankSlab1Item.class, "plankSlab1", sSlab1, dslab1);
            Blocks.fire.setFireInfo(plankSlab1, 5, 20);
            Blocks.fire.setFireInfo(plankSlab1Double, 5, 20);

            PlankSlab2 dslab2 = (PlankSlab2) new PlankSlab2(true).setBlockName("plankSlab2Double");
            PlankSlab2 sSlab2 = (PlankSlab2) new PlankSlab2(false).setBlockName("plankSlab2");
            plankSlab2Double = GameRegistry
                    .registerBlock(dslab2, PlankSlab2Item.class, "plankSlab2Double", sSlab2, dslab2);
            plankSlab2 = GameRegistry.registerBlock(sSlab2, PlankSlab2Item.class, "plankSlab2", sSlab2, dslab2);
            Blocks.fire.setFireInfo(plankSlab2, 5, 20);
            Blocks.fire.setFireInfo(plankSlab2Double, 5, 20);
        }

        // Wooden Trapdoors
        if (PHNatura.enableWoodenTrapdoors) {
            // Eucalyptus
            trapdoorEucalyptus = new NTrapdoor(Material.wood, "eucalyptus_trapdoor");
            trapdoorEucalyptus.setHardness(3.0F).setStepSound(Block.soundTypeWood).setBlockName("trapdoor.eucalyptus");
            GameRegistry.registerBlock(trapdoorEucalyptus, "trapdoor.eucalyptus");
            // Sakura
            trapdoorSakura = new NTrapdoor(Material.wood, "sakura_trapdoor");
            trapdoorSakura.setHardness(3.0F).setStepSound(Block.soundTypeWood).setBlockName("trapdoor.sakura");
            GameRegistry.registerBlock(trapdoorSakura, "trapdoor.sakura");
            // Ghostwood
            trapdoorGhostwood = new NTrapdoor(Material.wood, "ghostwood_trapdoor");
            trapdoorGhostwood.setHardness(3.0F).setStepSound(Block.soundTypeWood).setBlockName("trapdoor.ghostwood");
            GameRegistry.registerBlock(trapdoorGhostwood, "trapdoor.ghostwood");
            // Redwood
            trapdoorRedwood = new NTrapdoor(Material.wood, "redwood_trapdoor");
            trapdoorRedwood.setHardness(3.0F).setStepSound(Block.soundTypeWood).setBlockName("trapdoor.redwood");
            GameRegistry.registerBlock(trapdoorRedwood, "trapdoor.redwood");
            // Bloodwood
            trapdoorBloodwood = new NTrapdoor(Material.wood, "bloodwood_trapdoor");
            trapdoorBloodwood.setHardness(3.0F).setStepSound(Block.soundTypeWood).setBlockName("trapdoor.bloodwood");
            GameRegistry.registerBlock(trapdoorBloodwood, "trapdoor.bloodwood");
            // Hopseed
            trapdoorHopseed = new NTrapdoor(Material.wood, "hopseed_trapdoor");
            trapdoorHopseed.setHardness(3.0F).setStepSound(Block.soundTypeWood).setBlockName("trapdoor.hopseed");
            GameRegistry.registerBlock(trapdoorHopseed, "trapdoor.hopseed");
            // Maple
            trapdoorMaple = new NTrapdoor(Material.wood, "maple_trapdoor");
            trapdoorMaple.setHardness(3.0F).setStepSound(Block.soundTypeWood).setBlockName("trapdoor.maple");
            GameRegistry.registerBlock(trapdoorMaple, "trapdoor.maple");
            // Amaranth
            trapdoorAmaranth = new NTrapdoor(Material.wood, "purpleheart_trapdoor");
            trapdoorAmaranth.setHardness(3.0F).setStepSound(Block.soundTypeWood).setBlockName("trapdoor.amaranth");
            GameRegistry.registerBlock(trapdoorAmaranth, "trapdoor.amaranth");
            // Silverbell
            trapdoorSilverbell = new NTrapdoor(Material.wood, "silverbell_trapdoor");
            trapdoorSilverbell.setHardness(3.0F).setStepSound(Block.soundTypeWood).setBlockName("trapdoor.silverbell");
            GameRegistry.registerBlock(trapdoorSilverbell, "trapdoor.silverbell");
            // Tigerwood
            trapdoorTiger = new NTrapdoor(Material.wood, "tiger_trapdoor");
            trapdoorTiger.setHardness(3.0F).setStepSound(Block.soundTypeWood).setBlockName("trapdoor.tiger");
            GameRegistry.registerBlock(trapdoorTiger, "trapdoor.tiger");
            // Willow
            trapdoorWillow = new NTrapdoor(Material.wood, "willow_trapdoor");
            trapdoorWillow.setHardness(3.0F).setStepSound(Block.soundTypeWood).setBlockName("trapdoor.willow");
            GameRegistry.registerBlock(trapdoorWillow, "trapdoor.willow");
            // Darkwood
            trapdoorDarkwood = new NTrapdoor(Material.wood, "darkwood_trapdoor");
            trapdoorDarkwood.setHardness(3.0F).setStepSound(Block.soundTypeWood).setBlockName("trapdoor.darkwood");
            GameRegistry.registerBlock(trapdoorDarkwood, "trapdoor.darkwood");
            // Fusewood
            trapdoorFusewood = new NTrapdoor(Material.wood, "fusewood_trapdoor");
            trapdoorFusewood.setHardness(3.0F).setStepSound(Block.soundTypeWood).setBlockName("trapdoor.fusewood");
            GameRegistry.registerBlock(trapdoorFusewood, "trapdoor.fusewood");
        }

        // Wooden Fences
        if (PHNatura.enableWoodenFences) {
            alternateFence = new AlternateFence(Material.wood).setHardness(2.0F).setResistance(5.0F)
                    .setStepSound(Block.soundTypeWood).setBlockName("fence").setCreativeTab(NaturaTab.tab);
            GameRegistry.registerBlock(alternateFence, FenceItem.class, "Natura.fence");
            Blocks.fire.setFireInfo(alternateFence, 5, 20);
        }

        // Wooden Fence Gates
        if (PHNatura.enableWoodenFenceGates) {
            // Eucalyptus
            fenceGateEucalyptus = new NFenceGate(planks, 0);
            fenceGateEucalyptus.setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood)
                    .setBlockName("fenceGate.eucalyptus");
            GameRegistry.registerBlock(fenceGateEucalyptus, "fenceGate.eucalyptus");
            Blocks.fire.setFireInfo(fenceGateEucalyptus, 5, 20);
            // Sakura
            fenceGateSakura = new NFenceGate(planks, 1);
            fenceGateSakura.setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood)
                    .setBlockName("fenceGate.sakura");
            GameRegistry.registerBlock(fenceGateSakura, "fenceGate.sakura");
            Blocks.fire.setFireInfo(fenceGateSakura, 5, 20);
            // Ghostwood
            fenceGateGhostwood = new NFenceGate(planks, 2);
            fenceGateGhostwood.setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood)
                    .setBlockName("fenceGate.ghostwood");
            GameRegistry.registerBlock(fenceGateGhostwood, "fenceGate.ghostwood");
            // Redwood
            fenceGateRedwood = new NFenceGate(planks, 3);
            fenceGateRedwood.setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood)
                    .setBlockName("fenceGate.redwood");
            GameRegistry.registerBlock(fenceGateRedwood, "fenceGate.redwood");
            Blocks.fire.setFireInfo(fenceGateRedwood, 5, 20);
            // Bloodwood
            fenceGateBloodwood = new NFenceGate(planks, 4);
            fenceGateBloodwood.setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood)
                    .setBlockName("fenceGate.bloodwood");
            GameRegistry.registerBlock(fenceGateBloodwood, "fenceGate.bloodwood");
            // Hopseed
            fenceGateHopseed = new NFenceGate(planks, 5);
            fenceGateHopseed.setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood)
                    .setBlockName("fenceGate.hopseed");
            GameRegistry.registerBlock(fenceGateHopseed, "fenceGate.hopseed");
            Blocks.fire.setFireInfo(fenceGateHopseed, 5, 20);
            // Maple
            fenceGateMaple = new NFenceGate(planks, 6);
            fenceGateMaple.setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood)
                    .setBlockName("fenceGate.maple");
            GameRegistry.registerBlock(fenceGateMaple, "fenceGate.maple");
            Blocks.fire.setFireInfo(fenceGateMaple, 5, 20);
            // Amaranth
            fenceGateAmaranth = new NFenceGate(planks, 8);
            fenceGateAmaranth.setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood)
                    .setBlockName("fenceGate.amaranth");
            GameRegistry.registerBlock(fenceGateAmaranth, "fenceGate.amaranth");
            Blocks.fire.setFireInfo(fenceGateAmaranth, 5, 20);
            // Silverbell
            fenceGateSilverbell = new NFenceGate(planks, 7);
            fenceGateSilverbell.setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood)
                    .setBlockName("fenceGate.silverbell");
            GameRegistry.registerBlock(fenceGateSilverbell, "fenceGate.silverbell");
            Blocks.fire.setFireInfo(fenceGateSilverbell, 5, 20);
            // Tigerwood
            fenceGateTiger = new NFenceGate(planks, 9);
            fenceGateTiger.setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood)
                    .setBlockName("fenceGate.tiger");
            GameRegistry.registerBlock(fenceGateTiger, "fenceGate.tiger");
            Blocks.fire.setFireInfo(fenceGateTiger, 5, 20);
            // Willow
            fenceGateWillow = new NFenceGate(planks, 10);
            fenceGateWillow.setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood)
                    .setBlockName("fenceGate.willow");
            GameRegistry.registerBlock(fenceGateWillow, "fenceGate.willow");
            Blocks.fire.setFireInfo(fenceGateWillow, 5, 20);
            // Darkwood
            fenceGateDarkwood = new NFenceGate(planks, 11);
            fenceGateDarkwood.setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood)
                    .setBlockName("fenceGate.darkwood");
            GameRegistry.registerBlock(fenceGateDarkwood, "fenceGate.darkwood");
            // Fusewood
            fenceGateFusewood = new NFenceGate(planks, 12);
            fenceGateFusewood.setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood)
                    .setBlockName("fenceGate.fusewood");
            GameRegistry.registerBlock(fenceGateFusewood, "fenceGate.fusewood");
        }

        // Wooden Pressure Plates
        if (PHNatura.enableWoodenPressurePlates) {
            // Eucalyptus
            pressurePlateEucalyptus = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 0);
            pressurePlateEucalyptus.setHardness(0.5F).setStepSound(Block.soundTypeWood)
                    .setBlockName("pressureplate.eucalyptus");
            GameRegistry.registerBlock(pressurePlateEucalyptus, "pressureplate.eucalyptus");
            // Sakura
            pressurePlateSakura = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 1);
            pressurePlateSakura.setHardness(0.5F).setStepSound(Block.soundTypeWood)
                    .setBlockName("pressureplate.sakura");
            GameRegistry.registerBlock(pressurePlateSakura, "pressureplate.sakura");
            // Ghostwood
            pressurePlateGhostwood = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 2);
            pressurePlateGhostwood.setHardness(0.5F).setStepSound(Block.soundTypeWood)
                    .setBlockName("pressureplate.ghostwood");
            GameRegistry.registerBlock(pressurePlateGhostwood, "pressureplate.ghostwood");
            // Redwood
            pressurePlateRedwood = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 3);
            pressurePlateRedwood.setHardness(0.5F).setStepSound(Block.soundTypeWood)
                    .setBlockName("pressureplate.redwood");
            GameRegistry.registerBlock(pressurePlateRedwood, "pressureplate.redwood");
            // Bloodwood
            pressurePlateBloodwood = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 4);
            pressurePlateBloodwood.setHardness(0.5F).setStepSound(Block.soundTypeWood)
                    .setBlockName("pressureplate.bloodwood");
            GameRegistry.registerBlock(pressurePlateBloodwood, "pressureplate.bloodwood");
            // Hopseed
            pressurePlateHopseed = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 5);
            pressurePlateHopseed.setHardness(0.5F).setStepSound(Block.soundTypeWood)
                    .setBlockName("pressureplate.hopseed");
            GameRegistry.registerBlock(pressurePlateHopseed, "pressureplate.hopseed");
            // Maple
            pressurePlateMaple = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 6);
            pressurePlateMaple.setHardness(0.5F).setStepSound(Block.soundTypeWood).setBlockName("pressureplate.maple");
            GameRegistry.registerBlock(pressurePlateMaple, "pressureplate.maple");
            // Amaranth
            pressurePlateAmaranth = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 8);
            pressurePlateAmaranth.setHardness(0.5F).setStepSound(Block.soundTypeWood)
                    .setBlockName("pressureplate.amaranth");
            GameRegistry.registerBlock(pressurePlateAmaranth, "pressureplate.amaranth");
            // Silverbell
            pressurePlateSilverbell = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 7);
            pressurePlateSilverbell.setHardness(0.5F).setStepSound(Block.soundTypeWood)
                    .setBlockName("pressureplate.silverbell");
            GameRegistry.registerBlock(pressurePlateSilverbell, "pressureplate.silverbell");
            // Tigerwood
            pressurePlateTiger = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 9);
            pressurePlateTiger.setHardness(0.5F).setStepSound(Block.soundTypeWood).setBlockName("pressureplate.tiger");
            GameRegistry.registerBlock(pressurePlateTiger, "pressureplate.tiger");
            // Willow
            pressurePlateWillow = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 10);
            pressurePlateWillow.setHardness(0.5F).setStepSound(Block.soundTypeWood)
                    .setBlockName("pressureplate.willow");
            GameRegistry.registerBlock(pressurePlateWillow, "pressureplate.willow");
            // Darkwood
            pressurePlateDarkwood = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 11);
            pressurePlateDarkwood.setHardness(0.5F).setStepSound(Block.soundTypeWood)
                    .setBlockName("pressureplate.darkwood");
            GameRegistry.registerBlock(pressurePlateDarkwood, "pressureplate.darkwood");
            // Fusewood
            pressurePlateFusewood = new NPressurePlate(Material.wood, Sensitivity.everything, planks, 12);
            pressurePlateFusewood.setHardness(0.5F).setStepSound(Block.soundTypeWood)
                    .setBlockName("pressureplate.fusewood");
            GameRegistry.registerBlock(pressurePlateFusewood, "pressureplate.fusewood");
        }

        // Wooden Buttons
        if (PHNatura.enableWoodenButtons) {
            // Eucalyptus
            buttonEucalyptus = new NButton(planks, 0);
            buttonEucalyptus.setHardness(0.5F).setStepSound(Block.soundTypeWood).setBlockName("button.eucalyptus");
            GameRegistry.registerBlock(buttonEucalyptus, "button.eucalyptus");
            // Sakura
            buttonSakura = new NButton(planks, 1);
            buttonSakura.setHardness(0.5F).setStepSound(Block.soundTypeWood).setBlockName("button.sakura");
            GameRegistry.registerBlock(buttonSakura, "button.sakura");
            // Ghostwood
            buttonGhostwood = new NButton(planks, 2);
            buttonGhostwood.setHardness(0.5F).setStepSound(Block.soundTypeWood).setBlockName("button.ghostwood");
            GameRegistry.registerBlock(buttonGhostwood, "button.ghostwood");
            // Redwood
            buttonRedwood = new NButton(planks, 3);
            buttonRedwood.setHardness(0.5F).setStepSound(Block.soundTypeWood).setBlockName("button.redwood");
            GameRegistry.registerBlock(buttonRedwood, "button.redwood");
            // Bloodwood
            buttonBloodwood = new NButton(planks, 4);
            buttonBloodwood.setHardness(0.5F).setStepSound(Block.soundTypeWood).setBlockName("button.bloodwood");
            GameRegistry.registerBlock(buttonBloodwood, "button.bloodwood");
            // Hopseed
            buttonHopseed = new NButton(planks, 5);
            buttonHopseed.setHardness(0.5F).setStepSound(Block.soundTypeWood).setBlockName("button.hopseed");
            GameRegistry.registerBlock(buttonHopseed, "button.hopseed");
            // Maple
            buttonMaple = new NButton(planks, 6);
            buttonMaple.setHardness(0.5F).setStepSound(Block.soundTypeWood).setBlockName("button.maple");
            GameRegistry.registerBlock(buttonMaple, "button.maple");
            // Amaranth
            buttonAmaranth = new NButton(planks, 8);
            buttonAmaranth.setHardness(0.5F).setStepSound(Block.soundTypeWood).setBlockName("button.amaranth");
            GameRegistry.registerBlock(buttonAmaranth, "button.amaranth");
            // Silverbell
            buttonSilverbell = new NButton(planks, 7);
            buttonSilverbell.setHardness(0.5F).setStepSound(Block.soundTypeWood).setBlockName("button.silverbell");
            GameRegistry.registerBlock(buttonSilverbell, "button.silverbell");
            // Tigerwood
            buttonTiger = new NButton(planks, 9);
            buttonTiger.setHardness(0.5F).setStepSound(Block.soundTypeWood).setBlockName("button.tiger");
            GameRegistry.registerBlock(buttonTiger, "button.tiger");
            // Willow
            buttonWillow = new NButton(planks, 10);
            buttonWillow.setHardness(0.5F).setStepSound(Block.soundTypeWood).setBlockName("button.willow");
            GameRegistry.registerBlock(buttonWillow, "button.willow");
            // Darkwood
            buttonDarkwood = new NButton(planks, 11);
            buttonDarkwood.setHardness(0.5F).setStepSound(Block.soundTypeWood).setBlockName("button.darkwood");
            GameRegistry.registerBlock(buttonDarkwood, "button.darkwood");
            // Fusewood
            buttonFusewood = new NButton(planks, 12);
            buttonFusewood.setHardness(0.5F).setStepSound(Block.soundTypeWood).setBlockName("button.fusewood");
            GameRegistry.registerBlock(buttonFusewood, "button.fusewood");
        }

        // Wooden Doors
        if (PHNatura.enableWoodenDoors) {
            redwoodDoor = new NDoor(Material.wood, 0, "redwood").setBlockName("door.redwood");
            GameRegistry.registerBlock(redwoodDoor, "door.redwood");
            eucalyptusDoor = new NDoor(Material.wood, 1, "eucalyptus").setBlockName("door.eucalyptus");
            GameRegistry.registerBlock(eucalyptusDoor, "door.eucalyptus");
            hopseedDoor = new NDoor(Material.wood, 2, "hopseed").setBlockName("door.hopseed");
            GameRegistry.registerBlock(hopseedDoor, "door.hopseed");
            sakuraDoor = new NDoor(Material.wood, 3, "sakura").setBlockName("door.sakura");
            GameRegistry.registerBlock(sakuraDoor, "door.sakura");
            ghostDoor = new NDoor(Material.wood, 4, "ghostwood").setBlockName("door.ghostwood");
            GameRegistry.registerBlock(ghostDoor, "door.ghostwood");
            bloodDoor = new NDoor(Material.wood, 5, "bloodwood").setBlockName("door.bloodwood");
            GameRegistry.registerBlock(bloodDoor, "door.bloodwood");
            redwoodBarkDoor = new NDoor(Material.wood, 6, "redwoodbark").setBlockName("door.redwoodbark");
            GameRegistry.registerBlock(redwoodBarkDoor, "door.redwoodbark");

            doorItem = new NDoorItem().setUnlocalizedName("redwoodDoorItem");
            GameRegistry.registerItem(doorItem, "redwoodDoorItem");
        }

        // Other items
        plantItem = new PlantItem().setUnlocalizedName("barleyFood");
        GameRegistry.registerItem(plantItem, "barleyFood");
        if (PHNatura.enableCactusJuice) {
            waterDrop = new CactusJuice(false).setUnlocalizedName("waterdrop");
            GameRegistry.registerItem(waterDrop, "waterdrop");
        }
        // floraBoat = new NBoat(PHNatura.boatItemID).setIconCoord(0, 3).setBlockName("floraBoat");

        // Seed Bags
        if (PHNatura.enableSeedBags) {
            wheatBag = new SeedBag(Blocks.wheat, 0, "wheat").setUnlocalizedName("wheatBag");
            GameRegistry.registerItem(wheatBag, "wheatBag");
            barleyBag = new SeedBag(crops, 0, "barley").setUnlocalizedName("barleyBag");
            GameRegistry.registerItem(barleyBag, "barleyBag");
            potatoBag = new SeedBag(Blocks.potatoes, 0, "potato").setUnlocalizedName("potatoBag");
            GameRegistry.registerItem(potatoBag, "potatoBag");
            carrotBag = new SeedBag(Blocks.carrots, 0, "carrot").setUnlocalizedName("carrotBag");
            GameRegistry.registerItem(carrotBag, "carrotBag");
            cottonBag = new SeedBag(crops, 4, "cotton").setUnlocalizedName("cottonBag");
            GameRegistry.registerItem(cottonBag, "cottonBag");
        }
        if (PHNatura.enableNetherWartBags) {
            netherWartBag = new SeedBag(Blocks.nether_wart, 0, "netherwart").setUnlocalizedName("wartBag");
            GameRegistry.registerItem(netherWartBag, "wartBag");
        }
        if (PHNatura.enableBonemealBags) {
            boneBag = new BoneBag("bone").setUnlocalizedName("boneBag");
            GameRegistry.registerItem(boneBag, "boneBag");
        }

        // Seeds
        seeds = new NaturaSeeds(crops, Blocks.farmland).setUnlocalizedName("barley.seed");
        GameRegistry.registerItem(seeds, "barley.seed");
        GameRegistry.registerCustomItemStack("seedBarley", new ItemStack(seeds, 1, 0));
        GameRegistry.registerCustomItemStack("seedCotton", new ItemStack(seeds, 1, 1));
        seedFood = new SeedFood(3, 0.3f, saguaro).setUnlocalizedName("saguaro.fruit");
        GameRegistry.registerItem(seedFood, "saguaro.fruit");
        if (PHNatura.dropBarley) {
            MinecraftForge.addGrassSeed(new ItemStack(seeds, 1, 0), 3);
        }
        if (PHNatura.dropCotton) {
            MinecraftForge.addGrassSeed(new ItemStack(seeds, 1, 1), 3);
        }

        // Berries
        if (PHNatura.enableBerryBushes) {
            berryItem = new BerryItem(1).setUnlocalizedName("berry");
            GameRegistry.registerItem(berryItem, "berry");
            GameRegistry.registerCustomItemStack("berryRasp", new ItemStack(berryItem, 1, 0));
            GameRegistry.registerCustomItemStack("berryBlue", new ItemStack(berryItem, 1, 1));
            GameRegistry.registerCustomItemStack("berryBlack", new ItemStack(berryItem, 1, 2));
            GameRegistry.registerCustomItemStack("berryMalo", new ItemStack(berryItem, 1, 3));
        }
        if (PHNatura.enableNetherBerryBushes) {
            netherBerryItem = new NetherBerryItem(1).setUnlocalizedName("berry.nether");
            GameRegistry.registerItem(netherBerryItem, "berry.nether");
            GameRegistry.registerCustomItemStack("berryBlight", new ItemStack(netherBerryItem, 1, 0));
            GameRegistry.registerCustomItemStack("berryDusk", new ItemStack(netherBerryItem, 1, 1));
            GameRegistry.registerCustomItemStack("berrySky", new ItemStack(netherBerryItem, 1, 2));
            GameRegistry.registerCustomItemStack("berrySting", new ItemStack(netherBerryItem, 1, 3));
        }
        if (PHNatura.enableBerryBushes) {
            berryMedley = new BerryMedley(5).setUnlocalizedName("berryMedley");
            GameRegistry.registerItem(berryMedley, "berryMedley");
        }

        // Nether items
        potashApple = new NetherFoodItem().setUnlocalizedName("Natura.netherfood");
        GameRegistry.registerItem(potashApple, "Natura.netherfood");
        bowlStew = new BowlStew().setUnlocalizedName("natura.stewbowl");
        GameRegistry.registerItem(bowlStew, "natura.stewbowl");
        bowlEmpty = new BowlEmpty().setUnlocalizedName("natura.emptybowl");
        GameRegistry.registerItem(bowlEmpty, "natura.emptybowl");
        if (PHNatura.enableFlintAndBlaze) {
            flintAndBlaze = new FlintAndBlaze().setUnlocalizedName("flintandblaze")
                    .setTextureName("natura:flint_and_blaze");
            GameRegistry.registerItem(flintAndBlaze, "natura.flintandblaze");
        }

        // Imp items
        if (PHNatura.enableImps) {
            impMeat = new ImpMeat().setUnlocalizedName("impmeat");
            GameRegistry.registerItem(impMeat, "impmeat");
            GameRegistry.registerCustomItemStack("rawImphide", new ItemStack(impMeat, 1, 0));
            GameRegistry.registerCustomItemStack("cookedImphide", new ItemStack(impMeat, 1, 1));

            ArmorMaterial Imp = EnumHelper.addArmorMaterial("Imp", 33, new int[] { 1, 3, 2, 1 }, 15);
            impHelmet = new NaturaArmor(Imp, 1, 0, "imp_helmet", "imp").setUnlocalizedName("natura.armor.imphelmet");
            GameRegistry.registerItem(impHelmet, "natura.armor.imphelmet");
            impJerkin = new NaturaArmor(Imp, 1, 1, "imp_body", "imp").setUnlocalizedName("natura.armor.impjerkin");
            GameRegistry.registerItem(impJerkin, "natura.armor.impjerkin");
            impLeggings = new NaturaArmor(Imp, 1, 2, "imp_leggings", "imp")
                    .setUnlocalizedName("natura.armor.impleggings");
            GameRegistry.registerItem(impLeggings, "natura.armor.impleggings");
            impBoots = new NaturaArmor(Imp, 1, 3, "imp_boots", "imp").setUnlocalizedName("natura.armor.impboots");
            GameRegistry.registerItem(impBoots, "natura.armor.impboots");
        }

        // Wooden Sticks
        stickItem = (new StickItem()).setFull3D().setUnlocalizedName("natura.stick").setCreativeTab(NaturaTab.tab);
        GameRegistry.registerItem(stickItem, "natura.stick");

        // Nether Tools
        if (PHNatura.enableNetherWoodTools) {
            ghostwoodSword = new NaturaSword(ToolMaterial.WOOD, "ghostwood")
                    .setUnlocalizedName("natura.sword.ghostwood");
            GameRegistry.registerItem(ghostwoodSword, "natura.sword.ghostwood");
            ghostwoodPickaxe = new NaturaPickaxe(ToolMaterial.WOOD, "ghostwood")
                    .setUnlocalizedName("natura.pickaxe.ghostwood");
            GameRegistry.registerItem(ghostwoodPickaxe, "natura.pickaxe.ghostwood");
            ghostwoodShovel = new NaturaShovel(ToolMaterial.WOOD, "ghostwood")
                    .setUnlocalizedName("natura.shovel.ghostwood");
            GameRegistry.registerItem(ghostwoodShovel, "natura.shovel.ghostwood");
            ghostwoodAxe = new NaturaHatchet(ToolMaterial.WOOD, "ghostwood").setUnlocalizedName("natura.axe.ghostwood");
            GameRegistry.registerItem(ghostwoodAxe, "natura.axe.ghostwood");
            ghostwoodKama = new NaturaKama(ToolMaterial.WOOD, "ghostwood").setUnlocalizedName("natura.kama.ghostwood");
            GameRegistry.registerItem(ghostwoodKama, "natura.kama.ghostwood");
            ghostwoodBow = new NaturaBow(384, "ghostwood").setUnlocalizedName("natura.bow.ghostwood");
            GameRegistry.registerItem(ghostwoodBow, "natura.bow.ghostwood");
            ghostwoodPickaxe.setHarvestLevel("pickaxe", 0);
            ghostwoodShovel.setHarvestLevel("shovel", 0);
            ghostwoodAxe.setHarvestLevel("axe", 0);

            ToolMaterial Bloodwood = EnumHelper.addToolMaterial("Bloodwood", 3, 350, 7f, 3, 24);
            bloodwoodSword = new NaturaSword(Bloodwood, "bloodwood").setUnlocalizedName("natura.sword.bloodwood");
            GameRegistry.registerItem(bloodwoodSword, "natura.sword.bloodwood");
            bloodwoodPickaxe = new NaturaPickaxe(Bloodwood, "bloodwood").setUnlocalizedName("natura.pickaxe.bloodwood");
            GameRegistry.registerItem(bloodwoodPickaxe, "natura.pickaxe.bloodwood");
            bloodwoodShovel = new NaturaShovel(Bloodwood, "bloodwood").setUnlocalizedName("natura.shovel.bloodwood");
            GameRegistry.registerItem(bloodwoodShovel, "natura.shovel.bloodwood");
            bloodwoodAxe = new NaturaHatchet(Bloodwood, "bloodwood").setUnlocalizedName("natura.axe.bloodwood");
            GameRegistry.registerItem(bloodwoodAxe, "natura.axe.bloodwood");
            bloodwoodKama = new NaturaKama(Bloodwood, "bloodwood").setUnlocalizedName("natura.kama.bloodwood");
            GameRegistry.registerItem(bloodwoodKama, "natura.kama.bloodwood");
            bloodwoodBow = new NaturaBow(1501, "bloodwood").setUnlocalizedName("natura.bow.bloodwood");
            GameRegistry.registerItem(bloodwoodBow, "natura.bow.bloodwood");
            bloodwoodPickaxe.setHarvestLevel("pickaxe", 2);
            bloodwoodShovel.setHarvestLevel("shovel", 2);
            bloodwoodAxe.setHarvestLevel("axe", 2);

            darkwoodSword = new NaturaSword(ToolMaterial.STONE, "darkwood").setUnlocalizedName("natura.sword.darkwood");
            GameRegistry.registerItem(darkwoodSword, "natura.sword.darkwood");
            darkwoodPickaxe = new NaturaPickaxe(ToolMaterial.STONE, "darkwood")
                    .setUnlocalizedName("natura.pickaxe.darkwood");
            GameRegistry.registerItem(darkwoodPickaxe, "natura.pickaxe.darkwood");
            darkwoodShovel = new NaturaShovel(ToolMaterial.STONE, "darkwood")
                    .setUnlocalizedName("natura.shovel.darkwood");
            GameRegistry.registerItem(darkwoodShovel, "natura.shovel.darkwood");
            darkwoodAxe = new NaturaHatchet(ToolMaterial.STONE, "darkwood").setUnlocalizedName("natura.axe.darkwood");
            GameRegistry.registerItem(darkwoodAxe, "natura.axe.darkwood");
            darkwoodKama = new NaturaKama(ToolMaterial.STONE, "darkwood").setUnlocalizedName("natura.kama.darkwood");
            GameRegistry.registerItem(darkwoodKama, "natura.kama.darkwood");
            darkwoodBow = new NaturaBow(162, "darkwood").setUnlocalizedName("natura.bow.darkwood");
            GameRegistry.registerItem(darkwoodBow, "natura.bow.darkwood");
            darkwoodPickaxe.setHarvestLevel("pickaxe", 1);
            darkwoodShovel.setHarvestLevel("shovel", 1);
            darkwoodAxe.setHarvestLevel("axe", 1);

            fusewoodSword = new NaturaSword(ToolMaterial.IRON, "fusewood").setUnlocalizedName("natura.sword.fusewood");
            GameRegistry.registerItem(fusewoodSword, "natura.sword.fusewood");
            fusewoodPickaxe = new NaturaPickaxe(ToolMaterial.IRON, "fusewood")
                    .setUnlocalizedName("natura.pickaxe.fusewood");
            GameRegistry.registerItem(fusewoodPickaxe, "natura.pickaxe.fusewood");
            fusewoodShovel = new NaturaShovel(ToolMaterial.IRON, "fusewood")
                    .setUnlocalizedName("natura.shovel.fusewood");
            GameRegistry.registerItem(fusewoodShovel, "natura.shovel.fusewood");
            fusewoodAxe = new NaturaHatchet(ToolMaterial.IRON, "fusewood").setUnlocalizedName("natura.axe.fusewood");
            GameRegistry.registerItem(fusewoodAxe, "natura.axe.fusewood");
            fusewoodKama = new NaturaKama(ToolMaterial.IRON, "fusewood").setUnlocalizedName("natura.kama.fusewood");
            GameRegistry.registerItem(fusewoodKama, "natura.kama.fusewood");
            fusewoodBow = new NaturaBow(28, "fusewood").setUnlocalizedName("natura.bow.fusewood");
            GameRegistry.registerItem(fusewoodBow, "natura.bow.fusewood");
            fusewoodPickaxe.setHarvestLevel("pickaxe", 2);
            fusewoodShovel.setHarvestLevel("shovel", 2);
            fusewoodAxe.setHarvestLevel("axe", 2);
        }

        if (PHNatura.enableQuartzTools) {
            netherquartzSword = new NaturaSword(ToolMaterial.STONE, "netherquartz")
                    .setUnlocalizedName("natura.sword.netherquartz");
            GameRegistry.registerItem(netherquartzSword, "natura.sword.netherquartz");
            netherquartzPickaxe = new NaturaPickaxe(ToolMaterial.STONE, "netherquartz")
                    .setUnlocalizedName("natura.pickaxe.netherquartz");
            GameRegistry.registerItem(netherquartzPickaxe, "natura.pickaxe.netherquartz");
            netherquartzShovel = new NaturaShovel(ToolMaterial.STONE, "netherquartz")
                    .setUnlocalizedName("natura.shovel.netherquartz");
            GameRegistry.registerItem(netherquartzShovel, "natura.shovel.netherquartz");
            netherquartzAxe = new NaturaHatchet(ToolMaterial.STONE, "netherquartz")
                    .setUnlocalizedName("natura.axe.netherquartz");
            GameRegistry.registerItem(netherquartzAxe, "natura.axe.netherquartz");
            netherquartzKama = new NaturaKama(ToolMaterial.STONE, "netherquartz")
                    .setUnlocalizedName("natura.kama.netherquartz");
            GameRegistry.registerItem(netherquartzKama, "natura.kama.netherquartz");
            netherquartzPickaxe.setHarvestLevel("pickaxe", 1);
            netherquartzShovel.setHarvestLevel("shovel", 1);
            netherquartzAxe.setHarvestLevel("axe", 1);
        }

        // Spawn eggs
        if (PHNatura.anyMobsEnabled) {
            spawnEgg = new SpawnEgg().setUnlocalizedName("natura.spawnegg");
            GameRegistry.registerItem(spawnEgg, "natura.spawnegg");
        }
        addRecipes();
    }

    public void addRecipes() {
        List recipes = CraftingManager.getInstance().getRecipeList();

        ItemStack stackSingleCharcoal = new ItemStack(Items.coal, 1, 1);
        ItemStack stackSingleNetherrack = new ItemStack(Blocks.netherrack);
        ItemStack stackSingleTopiaryGrass = new ItemStack(grassBlock, 1, 0);
        ItemStack stackSingleBluegrass = new ItemStack(grassBlock, 1, 1);
        ItemStack stackSingleAutumnalGrass = new ItemStack(grassBlock, 1, 2);

        // Nether blocks
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.soul_sand, 1, 0), heatSand, Blocks.netherrack);

        if (PHNatura.enableNetherFurnaces) {
            GameRegistry.addRecipe(new ItemStack(netherrackFurnace), "###", "# #", "###", '#', Blocks.netherrack);
        }
        if (PHNatura.enableObelisks) {
            GameRegistry.addRecipe(new ItemStack(respawnObelisk), "###", "# #", "###", '#', new ItemStack(tree, 1, 2));
        }
        if (PHNatura.enableNetherGlass) {
            FurnaceRecipes.smelting()
                    .func_151394_a(new ItemStack(Blocks.soul_sand, 1, 0), new ItemStack(netherGlass, 1, 0), 0.3f);
            FurnaceRecipes.smelting()
                    .func_151394_a(new ItemStack(heatSand, 1, 0), new ItemStack(netherGlass, 1, 1), 0.3f);
        }

        // Blaze Rails
        if (PHNatura.enableBlazeRails) {
            GameRegistry.addRecipe(
                    new ShapedOreRecipe(
                            new ItemStack(brailPowered, 6),
                            "X X",
                            "X#X",
                            "XRX",
                            'X',
                            Items.blaze_rod,
                            'R',
                            "dustRedstone",
                            '#',
                            new ItemStack(darkTree, 1, 1)));
            GameRegistry.addRecipe(
                    new ShapedOreRecipe(
                            new ItemStack(brailActivator, 6),
                            "XSX",
                            "X#X",
                            "XSX",
                            'X',
                            Items.blaze_rod,
                            '#',
                            Blocks.redstone_torch,
                            'S',
                            "stickWood"));
            GameRegistry.addRecipe(
                    new ShapedOreRecipe(
                            new ItemStack(brail, 16),
                            "X X",
                            "X#X",
                            "X X",
                            'X',
                            Items.blaze_rod,
                            '#',
                            "stickWood"));
            if (PHNatura.enableNetherPressurePlates) {
                GameRegistry.addRecipe(
                        new ShapedOreRecipe(
                                new ItemStack(brailDetector, 6),
                                "X X",
                                "X#X",
                                "XRX",
                                'X',
                                Items.blaze_rod,
                                'R',
                                "dustRedstone",
                                '#',
                                netherPressurePlate));
            } else {
                GameRegistry.addRecipe(
                        new ShapedOreRecipe(
                                new ItemStack(brailDetector, 6),
                                "X X",
                                "X#X",
                                "XRX",
                                'X',
                                Items.blaze_rod,
                                'R',
                                "dustRedstone",
                                '#',
                                Blocks.stone_pressure_plate));
            }
        }

        if (PHNatura.enableBlazeHoppers) {
            GameRegistry.addRecipe(
                    new ShapedOreRecipe(
                            new ItemStack(netherHopper),
                            "# #",
                            "#C#",
                            " # ",
                            '#',
                            new ItemStack(Items.blaze_rod),
                            'C',
                            "chestWood"));
        }
        if (PHNatura.enableFlintAndBlaze) {
            GameRegistry.addShapelessRecipe(new ItemStack(flintAndBlaze), Items.flint, Items.blaze_rod);
        }
        if (PHNatura.enableNetherPressurePlates) {
            GameRegistry.addRecipe(new ItemStack(netherPressurePlate), "##", '#', stackSingleNetherrack);
        }
        if (PHNatura.enableNetherButtons) {
            GameRegistry.addRecipe(new ItemStack(netherButton), "#", '#', stackSingleNetherrack);
        }
        if (PHNatura.enableNetherLevers) {
            GameRegistry.addRecipe(
                    new ShapedOreRecipe(
                            new ItemStack(netherLever),
                            "S",
                            "#",
                            '#',
                            stackSingleNetherrack,
                            'S',
                            "stickWood"));
        }

        // Overworld plants
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(saguaro, 1, 0), new ItemStack(Items.dye, 1, 2), 0.2F);
        GameRegistry.addRecipe(new ItemStack(plantItem, 2, 8), "X", 'X', new ItemStack(bluebells));

        // Full grass blocks and slabs
        GameRegistry.addRecipe(
                stackSingleTopiaryGrass,
                " s ",
                "s#s",
                " s ",
                's',
                new ItemStack(Items.wheat_seeds),
                '#',
                new ItemStack(Blocks.dirt));
        GameRegistry.addRecipe(new ShapelessOreRecipe(stackSingleBluegrass, stackSingleTopiaryGrass, "dyeBlue"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(stackSingleAutumnalGrass, stackSingleTopiaryGrass, "dyeRed"));
        GameRegistry.addRecipe(new ItemStack(grassSlab, 6, 0), "bbb", 'b', stackSingleTopiaryGrass);
        GameRegistry.addRecipe(new ItemStack(grassSlab, 6, 1), "bbb", 'b', stackSingleBluegrass);
        GameRegistry.addRecipe(new ItemStack(grassSlab, 6, 2), "bbb", 'b', stackSingleAutumnalGrass);

        // Clouds
        GameRegistry.addRecipe(stackSingleCharcoal, "ccc", "ccc", "ccc", 'c', new ItemStack(cloud, 1, 2));
        GameRegistry.addRecipe(new ItemStack(plantItem, 1, 4), "cc", "cc", 'c', new ItemStack(cloud, 1, 3));
        if (!Loader.isModLoaded("dreamcraft")) {
            GameRegistry.addRecipe(
                    new ShapedOreRecipe(new ItemStack(Items.gunpowder, 1, 0), "cc", "cc", 'c', "dustSulfur"));
        }
        // Logs
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(tree, 1, 0), stackSingleCharcoal, 0.15f);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(tree, 1, 1), stackSingleCharcoal, 0.15f);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(tree, 1, 2), stackSingleCharcoal, 0.15f);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(tree, 1, 3), stackSingleCharcoal, 0.15f);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(redwood, 1, 0), stackSingleCharcoal, 0.15f);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(redwood, 1, 1), stackSingleCharcoal, 0.15f);
        FurnaceRecipes.smelting().func_151394_a(new ItemStack(redwood, 1, 2), stackSingleCharcoal, 0.15f);

        // Planks
        GameRegistry.addRecipe(new ItemStack(planks, 4, 0), "w", 'w', new ItemStack(tree, 1, 0));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 1), "w", 'w', new ItemStack(tree, 1, 1));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 2), "w", 'w', new ItemStack(tree, 1, 2));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 3), "w", 'w', new ItemStack(redwood, 1, 1));
        GameRegistry.addRecipe(
                new ItemStack(planks, 4, 4),
                "w",
                'w',
                new ItemStack(bloodwood, 1, OreDictionary.WILDCARD_VALUE));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 5), "w", 'w', new ItemStack(tree, 1, 3));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 6), "w", 'w', new ItemStack(rareTree, 1, 0));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 7), "w", 'w', new ItemStack(rareTree, 1, 1));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 8), "w", 'w', new ItemStack(rareTree, 1, 2));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 9), "w", 'w', new ItemStack(rareTree, 1, 3));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 10), "w", 'w', new ItemStack(willow, 1, 0));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 11), "w", 'w', new ItemStack(darkTree, 1, 0));
        GameRegistry.addRecipe(new ItemStack(planks, 4, 12), "w", 'w', new ItemStack(darkTree, 1, 1));

        // Wooden Workbenches
        if (PHNatura.enableWoodenWorkbenches) {
            for (int i = 0; i < woodTextureNames.length; i++) {
                addShapedRecipeFirst(
                        recipes,
                        new ItemStack(alternateWorkbench, 1, i),
                        "##",
                        "##",
                        '#',
                        new ItemStack(planks, 1, i));
            }
        }

        // Wooden Bookshelves
        if (PHNatura.enableWoodenBookshelves) {
            for (int i = 0; i < woodTextureNames.length; i++) {
                addShapedRecipeFirst(
                        recipes,
                        new ItemStack(alternateBookshelf, 1, i),
                        "###",
                        "bbb",
                        "###",
                        '#',
                        new ItemStack(planks, 1, i),
                        'b',
                        Items.book);
            }
        }

        // Wooden Stairs
        if (PHNatura.enableWoodenStairs) {
            Block[] stairs = new Block[] { stairEucalyptus, stairSakura, stairGhostwood, stairRedwood, stairBloodwood,
                    stairHopseed, stairMaple, stairSilverbell, stairAmaranth, stairTiger, stairWillow, stairDarkwood,
                    stairFusewood };
            for (int i = 0; i < 13; i++) {
                addShapedRecipeFirst(
                        recipes,
                        new ItemStack(stairs[i], 4),
                        "#  ",
                        "## ",
                        "###",
                        '#',
                        new ItemStack(planks, 1, i));
            }
        }

        // Wooden Slab
        if (PHNatura.enableWoodenSlabs) {
            for (int i = 0; i < 8; i++)
                addShapedRecipeFirst(recipes, new ItemStack(plankSlab1, 6, i), "###", '#', new ItemStack(planks, 1, i));
            for (int i = 0; i < 5; i++) addShapedRecipeFirst(
                    recipes,
                    new ItemStack(plankSlab2, 6, i),
                    "###",
                    '#',
                    new ItemStack(planks, 1, 8 + i));
        }

        // Wooden Trapdoors
        if (PHNatura.enableWoodenTrapdoors) {
            Block[] trapdoors = new Block[] { trapdoorEucalyptus, trapdoorSakura, trapdoorGhostwood, trapdoorRedwood,
                    trapdoorBloodwood, trapdoorHopseed, trapdoorMaple, trapdoorSilverbell, trapdoorAmaranth,
                    trapdoorTiger, trapdoorWillow, trapdoorDarkwood, trapdoorFusewood };
            for (int i = 0; i < 13; i++) {
                addShapedRecipeFirst(
                        recipes,
                        new ItemStack(trapdoors[i], 2),
                        "###",
                        "###",
                        '#',
                        new ItemStack(planks, 1, i));
            }
        }

        // Wooden Fences
        if (PHNatura.enableWoodenFences) {
            for (int i = 0; i < woodTextureNames.length; i++) {
                addShapedRecipeFirst(
                        recipes,
                        new ItemStack(alternateFence, 2, i),
                        "###",
                        "###",
                        '#',
                        new ItemStack(stickItem, 1, i));
            }
        }

        // Wooden Fence Gates
        if (PHNatura.enableWoodenFenceGates) {

            Block[] fenceGates = new Block[] { fenceGateEucalyptus, fenceGateSakura, fenceGateGhostwood,
                    fenceGateRedwood, fenceGateBloodwood, fenceGateHopseed, fenceGateMaple, fenceGateSilverbell,
                    fenceGateAmaranth, fenceGateTiger, fenceGateWillow, fenceGateDarkwood, fenceGateFusewood };
            for (int i = 0; i < 13; i++) {
                addShapedRecipeFirst(
                        recipes,
                        new ItemStack(fenceGates[i], 1),
                        "s#s",
                        "s#s",
                        '#',
                        new ItemStack(planks, 1, i),
                        's',
                        new ItemStack(stickItem, 1, i));
            }
        }

        // Wooden Pressure Plates
        if (PHNatura.enableWoodenPressurePlates) {
            Block[] pressurePlates = new Block[] { pressurePlateEucalyptus, pressurePlateSakura, pressurePlateGhostwood,
                    pressurePlateRedwood, pressurePlateBloodwood, pressurePlateHopseed, pressurePlateMaple,
                    pressurePlateSilverbell, pressurePlateAmaranth, pressurePlateTiger, pressurePlateWillow,
                    pressurePlateDarkwood, pressurePlateFusewood };
            for (int i = 0; i < 13; i++) {
                addShapedRecipeFirst(
                        recipes,
                        new ItemStack(pressurePlates[i], 1),
                        "##",
                        '#',
                        new ItemStack(planks, 1, i));
            }
        }

        // Wooden Buttons
        if (PHNatura.enableWoodenButtons) {
            Block[] buttons = new Block[] { buttonEucalyptus, buttonSakura, buttonGhostwood, buttonRedwood,
                    buttonBloodwood, buttonHopseed, buttonMaple, buttonSilverbell, buttonAmaranth, buttonTiger,
                    buttonWillow, buttonDarkwood, buttonFusewood };
            for (int i = 0; i < 13; i++) {
                addShapedRecipeFirst(recipes, new ItemStack(buttons[i], 1), "#", '#', new ItemStack(planks, 1, i));
            }
        }

        if (PHNatura.enableWoodenDoors) {
            addShapedRecipeFirst(
                    recipes,
                    new ItemStack(doorItem, 1, 0),
                    "##",
                    "##",
                    "##",
                    '#',
                    new ItemStack(planks, 1, 3));
            addShapedRecipeFirst(
                    recipes,
                    new ItemStack(doorItem, 1, 1),
                    "##",
                    "##",
                    "##",
                    '#',
                    new ItemStack(planks, 1, 0));
            addShapedRecipeFirst(
                    recipes,
                    new ItemStack(doorItem, 1, 2),
                    "##",
                    "##",
                    "##",
                    '#',
                    new ItemStack(planks, 1, 5));
            addShapedRecipeFirst(
                    recipes,
                    new ItemStack(doorItem, 1, 3),
                    "##",
                    "##",
                    "##",
                    '#',
                    new ItemStack(planks, 1, 1));
            addShapedRecipeFirst(
                    recipes,
                    new ItemStack(doorItem, 1, 4),
                    "##",
                    "##",
                    "##",
                    '#',
                    new ItemStack(planks, 1, 2));
            addShapedRecipeFirst(
                    recipes,
                    new ItemStack(doorItem, 1, 5),
                    "##",
                    "##",
                    "##",
                    '#',
                    new ItemStack(planks, 1, 4));
            addShapedRecipeFirst(
                    recipes,
                    new ItemStack(doorItem, 1, 6),
                    "##",
                    "##",
                    "##",
                    '#',
                    new ItemStack(redwood, 1, 0));
        }

        // Other items
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.glass_bottle, 3), "# #", " # ", '#', "glass"));
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        new ItemStack(Blocks.daylight_detector),
                        "GGG",
                        "QQQ",
                        "WWW",
                        'G',
                        "glass",
                        'Q',
                        "gemQuartz",
                        'W',
                        "slabWood"));

        if (PHNatura.enableCactusJuice) {
            GameRegistry.addRecipe(new ItemStack(waterDrop, 1), "X", 'X', Blocks.cactus);
            GameRegistry.addRecipe(
                    new ItemStack(Items.water_bucket, 1),
                    "www",
                    "wBw",
                    "www",
                    'w',
                    waterDrop,
                    'B',
                    Items.bucket);
        }

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.string), "sss", 's', "cropCotton"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.wool), "sss", "sss", "sss", 's', "cropCotton"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(plantItem, 1, 1), "X", 'X', "cropBarley"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.bread), "bbb", 'b', "cropBarley"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(plantItem, 1, 1), "X", 'X', "cropBarley"));
        if (PHNatura.enableWheatRecipe)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(plantItem, 1, 2), "X", 'X', "cropWheat"));

        for (int i = 1; i <= 2; i++) {
            FurnaceRecipes.smelting()
                    .func_151394_a(new ItemStack(plantItem, 1, i), new ItemStack(Items.bread, 1), 0.5f);
            GameRegistry.addRecipe(
                    new ItemStack(Items.cake, 1),
                    "AAA",
                    "BEB",
                    " C ",
                    'A',
                    Items.milk_bucket,
                    'B',
                    Items.sugar,
                    'C',
                    new ItemStack(plantItem, 1, i),
                    'E',
                    Items.egg);
        }

        GameRegistry.addRecipe(
                new ItemStack(plantItem, 1, 5),
                " s ",
                "#s#",
                "#s#",
                's',
                new ItemStack(stickItem, 1, 2),
                '#',
                new ItemStack(floraLeavesNoColor, 1, 1));
        GameRegistry.addRecipe(
                new ItemStack(Items.arrow, 4, 0),
                " f ",
                "#s#",
                " # ",
                's',
                new ItemStack(stickItem, 1, OreDictionary.WILDCARD_VALUE),
                '#',
                new ItemStack(plantItem, 1, 5),
                'f',
                Items.flint);
        GameRegistry.addRecipe(
                new ShapedOreRecipe(
                        new ItemStack(Items.arrow, 4, 0),
                        " f ",
                        "#s#",
                        " # ",
                        's',
                        "stickWood",
                        '#',
                        new ItemStack(plantItem, 1, 5),
                        'f',
                        Items.flint));

        /*
         * GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(toolStationWood, 1, 1), "p", "w", 'p', new
         * ItemStack(blankPattern, 1, 0), 'w', "logWood")); GameRegistry.addShapelessRecipe(new ItemStack(plantItem, 1,
         * 2), new ItemStack(plantItem, 1, 1), Item.bucketWater ); GameRegistry.addShapelessRecipe(new
         * ItemStack(plantItem, 2, 2), new ItemStack(plantItem, 1, 1), Item.egg );
         */

        // Seed Bags
        if (PHNatura.enableSeedBags) {
            GameRegistry.addRecipe(new ItemStack(wheatBag, 1, 0), "sss", "sss", "sss", 's', Items.wheat_seeds);
            GameRegistry.addRecipe(
                    new ShapedOreRecipe(new ItemStack(carrotBag, 1, 0), "sss", "sss", "sss", 's', "cropCarrot"));
            GameRegistry.addRecipe(
                    new ShapedOreRecipe(new ItemStack(potatoBag, 1, 0), "sss", "sss", "sss", 's', "cropPotato"));
            GameRegistry.addRecipe(
                    new ShapedOreRecipe(new ItemStack(barleyBag, 1, 0), "sss", "sss", "sss", 's', "seedBarley"));
            GameRegistry.addRecipe(
                    new ShapedOreRecipe(new ItemStack(cottonBag, 1, 0), "sss", "sss", "sss", 's', "seedCotton"));
            GameRegistry.addRecipe(new ItemStack(Items.wheat_seeds, 9, 0), "s", 's', wheatBag);
            GameRegistry.addRecipe(new ItemStack(Items.carrot, 9, 0), "s", 's', carrotBag);
            GameRegistry.addRecipe(new ItemStack(Items.potato, 9, 0), "s", 's', potatoBag);
            GameRegistry.addRecipe(new ItemStack(seeds, 9, 0), "s", 's', barleyBag);
            GameRegistry.addRecipe(new ItemStack(seeds, 9, 1), "s", 's', cottonBag);
        }
        if (PHNatura.enableNetherWartBags) {
            GameRegistry.addRecipe(new ItemStack(netherWartBag, 1, 0), "sss", "sss", "sss", 's', Items.nether_wart);
            GameRegistry.addRecipe(new ItemStack(Items.nether_wart, 9, 0), "s", 's', netherWartBag);
        }
        if (PHNatura.enableBonemealBags) {
            GameRegistry
                    .addRecipe(new ItemStack(boneBag, 1, 0), "sss", "sss", "sss", 's', new ItemStack(Items.dye, 1, 15));
            GameRegistry.addRecipe(new ItemStack(Items.dye, 9, 15), "s", 's', boneBag);
        }

        // Berries
        if (PHNatura.enableBerryBushes) {
            String[] berryTypes = new String[] { "cropRaspberry", "cropBlueberry", "cropBlackberry", "cropMaloberry",
                    "cropStrawberry", "cropCranberry" };

            for (int iter1 = 0; iter1 < berryTypes.length - 2; iter1++)
                for (int iter2 = iter1 + 1; iter2 < berryTypes.length - 1; iter2++)
                    for (int iter3 = iter2 + 1; iter3 < berryTypes.length; iter3++) GameRegistry.addRecipe(
                            new ShapelessOreRecipe(
                                    new ItemStack(berryMedley, 1, 0),
                                    "bowlWood",
                                    berryTypes[iter1],
                                    berryTypes[iter2],
                                    berryTypes[iter3]));

            for (int iter1 = 0; iter1 < berryTypes.length - 3; iter1++)
                for (int iter2 = iter1 + 1; iter2 < berryTypes.length - 2; iter2++)
                    for (int iter3 = iter2 + 1; iter3 < berryTypes.length - 1; iter3++)
                        for (int iter4 = iter3 + 1; iter4 < berryTypes.length; iter4++) GameRegistry.addRecipe(
                                new ShapelessOreRecipe(
                                        new ItemStack(berryMedley, 2, 0),
                                        "bowlWood",
                                        "bowlWood",
                                        berryTypes[iter1],
                                        berryTypes[iter2],
                                        berryTypes[iter3],
                                        berryTypes[iter4]));

            /*
             * GameRegistry.addShapelessRecipe(new ItemStack(berryMedley, 1), new ItemStack(berryItem, 1, 0), new
             * ItemStack(berryItem, 1, 1), new ItemStack(berryItem, 1, 2), new ItemStack(Item.bowlEmpty));
             * GameRegistry.addShapelessRecipe(new ItemStack(berryMedley, 1), new ItemStack(berryItem, 1, 0), new
             * ItemStack(berryItem, 1, 1), new ItemStack(berryItem, 1, 3), new ItemStack(Item.bowlEmpty));
             * GameRegistry.addShapelessRecipe(new ItemStack(berryMedley, 1), new ItemStack(berryItem, 1, 0), new
             * ItemStack(berryItem, 1, 2), new ItemStack(berryItem, 1, 3), new ItemStack(Item.bowlEmpty));
             * GameRegistry.addShapelessRecipe(new ItemStack(berryMedley, 1), new ItemStack(berryItem, 1, 1), new
             * ItemStack(berryItem, 1, 2), new ItemStack(berryItem, 1, 3), new ItemStack(Item.bowlEmpty));
             * GameRegistry.addShapelessRecipe(new ItemStack(berryMedley, 2), new ItemStack(berryItem, 1, 0), new
             * ItemStack(berryItem, 1, 1), new ItemStack(berryItem, 1, 2), new ItemStack(berryItem, 1, 3), new
             * ItemStack(Item.bowlEmpty), new ItemStack(Item.bowlEmpty));
             */
        }

        // Nether items
        addShapelessRecipeFirst(
                recipes,
                new ItemStack(bowlStew, 1, 0),
                new ItemStack(Blocks.brown_mushroom),
                new ItemStack(Blocks.red_mushroom),
                new ItemStack(Items.bowl));
        GameRegistry.addRecipe(
                new ShapelessOreRecipe(
                        new ItemStack(bowlStew, 1, 14),
                        new ItemStack(glowshroom, 1, 0),
                        new ItemStack(glowshroom, 1, 1),
                        new ItemStack(glowshroom, 1, 2),
                        "bowlWood"));
        for (int i = 0; i < BowlEmpty.textureNames.length; i++) {
            if (!(BowlEmpty.textureNames[i].equals(""))) {
                if (FluidRegistry.isFluidRegistered("mushroomsoup")) FluidContainerRegistry.registerFluidContainer(
                        FluidRegistry.getFluid("mushroomsoup"),
                        new ItemStack(this.bowlStew, 1, i));
                addShapedRecipeFirst(
                        recipes,
                        new ItemStack(bowlEmpty, 4, i),
                        "# #",
                        " # ",
                        '#',
                        new ItemStack(planks, 1, i));
                GameRegistry.addRecipe(
                        new ShapelessOreRecipe(
                                new ItemStack(bowlStew, 1, i + 1),
                                "bowlWood",
                                new ItemStack(Blocks.brown_mushroom),
                                new ItemStack(Blocks.red_mushroom_block)));
                GameRegistry.addRecipe(
                        new ShapelessOreRecipe(
                                new ItemStack(bowlStew, 1, i + 15),
                                "bowlWood",
                                new ItemStack(glowshroom, 1, 0),
                                new ItemStack(glowshroom, 1, 1),
                                new ItemStack(glowshroom, 1, 2)));
            }
        }

        /*
         * bowlEmpty = new BowlEmpty(PHNatura.bowlEmpty).setUnlocalizedName("natura.emptybowl"); bowlStew = new
         * BowlStew(PHNatura.bowlStew).setUnlocalizedName("natura.stewbowl");
         */

        // Imp items
        if (PHNatura.enableImps) {
            ItemStack stackSingleImpLeather = new ItemStack(plantItem, 1, 6);

            FurnaceRecipes.smelting().func_151394_a(new ItemStack(impMeat, 1, 0), new ItemStack(impMeat, 1, 1), 0.2F);

            GameRegistry.addRecipe(new ItemStack(Items.leather, 2), "##", "##", '#', stackSingleImpLeather);

            impHelmetStack = new ItemStack(impHelmet);
            impHelmetStack.addEnchantment(Enchantment.protection, 1);
            impHelmetStack.addEnchantment(Enchantment.fireProtection, 1);
            GameRegistry.addRecipe(impHelmetStack.copy(), "###", "# #", '#', stackSingleImpLeather);

            impJerkinStack = new ItemStack(impJerkin);
            impJerkinStack.addEnchantment(Enchantment.blastProtection, 1);
            impJerkinStack.addEnchantment(Enchantment.fireProtection, 1);
            GameRegistry.addRecipe(impJerkinStack.copy(), "# #", "###", "###", '#', stackSingleImpLeather);

            impLeggingsStack = new ItemStack(impLeggings);
            impLeggingsStack.addEnchantment(Enchantment.projectileProtection, 1);
            impLeggingsStack.addEnchantment(Enchantment.fireProtection, 1);
            GameRegistry.addRecipe(impLeggingsStack.copy(), "###", "# #", "# #", '#', stackSingleImpLeather);

            impBootsStack = new ItemStack(impBoots);
            impBootsStack.addEnchantment(Enchantment.featherFalling, 1);
            impBootsStack.addEnchantment(Enchantment.fireProtection, 1);
            GameRegistry.addRecipe(impBootsStack.copy(), "# #", "# #", '#', stackSingleImpLeather);
        }

        // Wooden Sticks
        if (PHNatura.enableWoodenFences) {
            for (int i = 0; i < woodTextureNames.length; i++) {
                addShapedRecipeFirst(
                        recipes,
                        new ItemStack(stickItem, 4, i),
                        "#",
                        "#",
                        '#',
                        new ItemStack(planks, 1, i));
            }
        }

        // Nether Tools
        if (PHNatura.enableNetherWoodTools) {
            int[] toolMeta = { 2, 4, 11, 12 };
            Item[][] tools = {
                    { ghostwoodSword, ghostwoodPickaxe, ghostwoodShovel, ghostwoodAxe, ghostwoodKama, ghostwoodBow },
                    { bloodwoodSword, bloodwoodPickaxe, bloodwoodShovel, bloodwoodAxe, bloodwoodKama, bloodwoodBow },
                    { darkwoodSword, darkwoodPickaxe, darkwoodShovel, darkwoodAxe, darkwoodKama, darkwoodBow },
                    { fusewoodSword, fusewoodPickaxe, fusewoodShovel, fusewoodAxe, fusewoodKama, fusewoodBow } };

            for (int i = 0; i < toolMeta.length; i++) {
                addShapedRecipeFirst(
                        recipes,
                        new ItemStack(tools[i][0], 1, 0),
                        "#",
                        "#",
                        "s",
                        '#',
                        new ItemStack(planks, 1, toolMeta[i]),
                        's',
                        new ItemStack(stickItem, 1, toolMeta[i]));
                addShapedRecipeFirst(
                        recipes,
                        new ItemStack(tools[i][1], 1, 0),
                        "###",
                        " s ",
                        " s ",
                        '#',
                        new ItemStack(planks, 1, toolMeta[i]),
                        's',
                        new ItemStack(stickItem, 1, toolMeta[i]));
                addShapedRecipeFirst(
                        recipes,
                        new ItemStack(tools[i][2], 1, 0),
                        "#",
                        "s",
                        "s",
                        '#',
                        new ItemStack(planks, 1, toolMeta[i]),
                        's',
                        new ItemStack(stickItem, 1, toolMeta[i]));
                addShapedRecipeFirst(
                        recipes,
                        new ItemStack(tools[i][3], 1, 0),
                        "##",
                        "#s",
                        " s",
                        '#',
                        new ItemStack(planks, 1, toolMeta[i]),
                        's',
                        new ItemStack(stickItem, 1, toolMeta[i]));
                addShapedRecipeFirst(
                        recipes,
                        new ItemStack(tools[i][4], 1, 0),
                        "##",
                        " s",
                        " s",
                        '#',
                        new ItemStack(planks, 1, toolMeta[i]),
                        's',
                        new ItemStack(stickItem, 1, toolMeta[i]));
                addShapedRecipeFirst(
                        recipes,
                        new ItemStack(tools[i][5], 1, 0),
                        " s#",
                        "s #",
                        " s#",
                        '#',
                        new ItemStack(plantItem, 1, 7),
                        's',
                        new ItemStack(stickItem, 1, toolMeta[i]));
            }
        }

        if (PHNatura.enableQuartzTools) {
            GameRegistry.addRecipe(
                    new ItemStack(netherquartzSword, 1, 0),
                    "#",
                    "#",
                    "s",
                    '#',
                    new ItemStack(Blocks.quartz_block, 1, OreDictionary.WILDCARD_VALUE),
                    's',
                    new ItemStack(stickItem, 1, 2));
            GameRegistry.addRecipe(
                    new ItemStack(netherquartzPickaxe, 1, 0),
                    "###",
                    " s ",
                    " s ",
                    '#',
                    new ItemStack(Blocks.quartz_block, 1, OreDictionary.WILDCARD_VALUE),
                    's',
                    new ItemStack(stickItem, 1, 2));
            GameRegistry.addRecipe(
                    new ItemStack(netherquartzShovel, 1, 0),
                    "#",
                    "s",
                    "s",
                    '#',
                    new ItemStack(Blocks.quartz_block, 1, OreDictionary.WILDCARD_VALUE),
                    's',
                    new ItemStack(stickItem, 1, 2));
            GameRegistry.addRecipe(
                    new ItemStack(netherquartzAxe, 1, 0),
                    "##",
                    "#s",
                    " s",
                    '#',
                    new ItemStack(Blocks.quartz_block, 1, OreDictionary.WILDCARD_VALUE),
                    's',
                    new ItemStack(stickItem, 1, 2));
            GameRegistry.addRecipe(
                    new ItemStack(netherquartzKama, 1, 0),
                    "##",
                    " s",
                    " s",
                    '#',
                    new ItemStack(Blocks.quartz_block, 1, OreDictionary.WILDCARD_VALUE),
                    's',
                    new ItemStack(stickItem, 1, 2));
        }
    }

    public void addShapedRecipeFirst(List recipeList, ItemStack itemstack, Object... objArray) {
        String var3 = "";
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;

        if (objArray[var4] instanceof String[]) {
            String[] var7 = ((String[]) objArray[var4++]);

            for (int var8 = 0; var8 < var7.length; ++var8) {
                String var9 = var7[var8];
                ++var6;
                var5 = var9.length();
                var3 = var3 + var9;
            }
        } else {
            while (objArray[var4] instanceof String) {
                String var11 = (String) objArray[var4++];
                ++var6;
                var5 = var11.length();
                var3 = var3 + var11;
            }
        }

        HashMap var12;

        for (var12 = new HashMap(); var4 < objArray.length; var4 += 2) {
            Character var13 = (Character) objArray[var4];
            ItemStack var14 = null;

            if (objArray[var4 + 1] instanceof Item) {
                var14 = new ItemStack((Item) objArray[var4 + 1]);
            } else if (objArray[var4 + 1] instanceof Block) {
                var14 = new ItemStack((Block) objArray[var4 + 1], 1, OreDictionary.WILDCARD_VALUE);
            } else if (objArray[var4 + 1] instanceof ItemStack) {
                var14 = (ItemStack) objArray[var4 + 1];
            }

            var12.put(var13, var14);
        }

        ItemStack[] var15 = new ItemStack[var5 * var6];

        for (int var16 = 0; var16 < var5 * var6; ++var16) {
            char var10 = var3.charAt(var16);

            if (var12.containsKey(Character.valueOf(var10))) {
                var15[var16] = ((ItemStack) var12.get(Character.valueOf(var10))).copy();
            } else {
                var15[var16] = null;
            }
        }

        ShapedRecipes var17 = new ShapedRecipes(var5, var6, var15, itemstack);
        recipeList.add(0, var17);
    }

    public void addShapelessRecipeFirst(List recipeList, ItemStack par1ItemStack, Object... par2ArrayOfObj) {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = par2ArrayOfObj;
        int i = par2ArrayOfObj.length;

        for (int j = 0; j < i; ++j) {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack) {
                arraylist.add(((ItemStack) object1).copy());
            } else if (object1 instanceof Item) {
                arraylist.add(new ItemStack((Item) object1));
            } else {
                if (!(object1 instanceof Block)) {
                    throw new RuntimeException("Invalid shapeless recipe!");
                }

                arraylist.add(new ItemStack((Block) object1));
            }
        }

        recipeList.add(0, new ShapelessRecipes(par1ItemStack, arraylist));
    }

    /*
     * public void addLoot () { //ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new
     * WeightedRandomChestContent(new ItemStack(VanityBlocksStorage.StorageBlock,0,0),3,5,6)); }
     */

    public void addOredictSupport() {
        // Vanilla
        OreDictionary.registerOre("chestWood", new ItemStack(Blocks.chest, 1));
        OreDictionary.registerOre("bowlWood", new ItemStack(Items.bowl, 1));

        // Nether blocks
        if (PHNatura.enableNetherGlass) {
            OreDictionary.registerOre("glassSoul", new ItemStack(netherGlass, 1, 0));
            OreDictionary.registerOre("glass", new ItemStack(netherGlass, 1, 0));
            OreDictionary.registerOre("glass", new ItemStack(netherGlass, 1, 1));
        }

        // Saplings
        for (int i = 0; i < 5; i++) OreDictionary.registerOre("treeSapling", new ItemStack(rareSapling, 1, i));
        for (int i = 0; i < 8; i++) OreDictionary.registerOre("treeSapling", new ItemStack(floraSapling, 1, i));

        // Logs
        OreDictionary.registerOre("logWood", new ItemStack(tree, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("logWood", new ItemStack(redwood, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("logWood", new ItemStack(willow, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("logWood", new ItemStack(bloodwood, 1, 0));
        OreDictionary.registerOre("logWood", new ItemStack(bloodwood, 1, 15));
        OreDictionary.registerOre("logWood", new ItemStack(rareTree, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("logWood", new ItemStack(darkTree, 1, OreDictionary.WILDCARD_VALUE));

        // Leaves
        OreDictionary.registerOre("treeLeaves", new ItemStack(floraLeaves, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("treeLeaves", new ItemStack(floraLeavesNoColor, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("treeLeaves", new ItemStack(rareLeaves, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("treeLeaves", new ItemStack(darkLeaves, 1, OreDictionary.WILDCARD_VALUE));

        // Wooden Planks

        if (!Loader.isModLoaded("ExtraTiC")) {
            // Wooden Planks
            for (int i = 0; i < Planks.textureNames.length; i++) {
                OreDictionary.registerOre("plankWood", new ItemStack(planks, 1, i));
            }

            // Wooden Sticks
            for (int i = 0; i < StickItem.textureNames.length; i++) {
                OreDictionary.registerOre("stickWood", new ItemStack(stickItem, 1, i));
            }
        } else {
            int[] toRegister = { 0, 1, 3, 5, 6, 7, 8, 9, 10 };
            for (int i : toRegister) {
                OreDictionary.registerOre("plankWood", new ItemStack(planks, 1, i));
                OreDictionary.registerOre("stickWood", new ItemStack(stickItem, 1, i));
            }
        }

        // Wooden Workbenches
        if (PHNatura.enableWoodenWorkbenches) {
            OreDictionary
                    .registerOre("crafterWood", new ItemStack(alternateWorkbench, 1, OreDictionary.WILDCARD_VALUE));
            OreDictionary.registerOre(
                    "craftingTableWood",
                    new ItemStack(alternateWorkbench, 1, OreDictionary.WILDCARD_VALUE));
        }

        // Wooden Bookshelves
        if (PHNatura.enableWoodenBookshelves) {
            OreDictionary
                    .registerOre("bookshelfWood", new ItemStack(alternateBookshelf, 1, OreDictionary.WILDCARD_VALUE));
        }

        // Wooden Stairs
        if (PHNatura.enableWoodenStairs) {
            OreDictionary.registerOre("stairWood", new ItemStack(stairEucalyptus, 1));
            OreDictionary.registerOre("stairWood", new ItemStack(stairSakura, 1));
            OreDictionary.registerOre("stairWood", new ItemStack(stairGhostwood, 1));
            OreDictionary.registerOre("stairWood", new ItemStack(stairRedwood, 1));
            OreDictionary.registerOre("stairWood", new ItemStack(stairBloodwood, 1));
            OreDictionary.registerOre("stairWood", new ItemStack(stairHopseed, 1));
            OreDictionary.registerOre("stairWood", new ItemStack(stairMaple, 1));
            OreDictionary.registerOre("stairWood", new ItemStack(stairSilverbell, 1));
            OreDictionary.registerOre("stairWood", new ItemStack(stairAmaranth, 1));
            OreDictionary.registerOre("stairWood", new ItemStack(stairTiger, 1));
            OreDictionary.registerOre("stairWood", new ItemStack(stairWillow, 1));
            OreDictionary.registerOre("stairWood", new ItemStack(stairDarkwood, 1));
            OreDictionary.registerOre("stairWood", new ItemStack(stairFusewood, 1));
        }

        // Wooden Slabs
        if (PHNatura.enableWoodenSlabs) {
            OreDictionary.registerOre("slabWood", new ItemStack(plankSlab1, 1, OreDictionary.WILDCARD_VALUE));
            OreDictionary.registerOre("slabWood", new ItemStack(plankSlab2, 1, OreDictionary.WILDCARD_VALUE));
        }

        // Wooden Trapdoors
        if (PHNatura.enableWoodenTrapdoors) {
            OreDictionary.registerOre("trapdoorWood", new ItemStack(trapdoorEucalyptus, 1));
            OreDictionary.registerOre("trapdoorWood", new ItemStack(trapdoorSakura, 1));
            OreDictionary.registerOre("trapdoorWood", new ItemStack(trapdoorGhostwood, 1));
            OreDictionary.registerOre("trapdoorWood", new ItemStack(trapdoorRedwood, 1));
            OreDictionary.registerOre("trapdoorWood", new ItemStack(trapdoorBloodwood, 1));
            OreDictionary.registerOre("trapdoorWood", new ItemStack(trapdoorHopseed, 1));
            OreDictionary.registerOre("trapdoorWood", new ItemStack(trapdoorMaple, 1));
            OreDictionary.registerOre("trapdoorWood", new ItemStack(trapdoorSilverbell, 1));
            OreDictionary.registerOre("trapdoorWood", new ItemStack(trapdoorAmaranth, 1));
            OreDictionary.registerOre("trapdoorWood", new ItemStack(trapdoorTiger, 1));
            OreDictionary.registerOre("trapdoorWood", new ItemStack(trapdoorWillow, 1));
            OreDictionary.registerOre("trapdoorWood", new ItemStack(trapdoorDarkwood, 1));
            OreDictionary.registerOre("trapdoorWood", new ItemStack(trapdoorFusewood, 1));
        }

        // Wooden Fences
        if (PHNatura.enableWoodenFences) {
            OreDictionary.registerOre("fenceWood", new ItemStack(alternateFence, 1, OreDictionary.WILDCARD_VALUE));
        }

        // Wooden Fence Gates
        if (PHNatura.enableWoodenFenceGates) {
            OreDictionary.registerOre("fenceGateWood", new ItemStack(fenceGateEucalyptus, 1));
            OreDictionary.registerOre("fenceGateWood", new ItemStack(fenceGateSakura, 1));
            OreDictionary.registerOre("fenceGateWood", new ItemStack(fenceGateGhostwood, 1));
            OreDictionary.registerOre("fenceGateWood", new ItemStack(fenceGateRedwood, 1));
            OreDictionary.registerOre("fenceGateWood", new ItemStack(fenceGateBloodwood, 1));
            OreDictionary.registerOre("fenceGateWood", new ItemStack(fenceGateHopseed, 1));
            OreDictionary.registerOre("fenceGateWood", new ItemStack(fenceGateMaple, 1));
            OreDictionary.registerOre("fenceGateWood", new ItemStack(fenceGateSilverbell, 1));
            OreDictionary.registerOre("fenceGateWood", new ItemStack(fenceGateAmaranth, 1));
            OreDictionary.registerOre("fenceGateWood", new ItemStack(fenceGateTiger, 1));
            OreDictionary.registerOre("fenceGateWood", new ItemStack(fenceGateWillow, 1));
            OreDictionary.registerOre("fenceGateWood", new ItemStack(fenceGateDarkwood, 1));
            OreDictionary.registerOre("fenceGateWood", new ItemStack(fenceGateFusewood, 1));
        }

        // Wooden Pressure Plates
        if (PHNatura.enableWoodenPressurePlates) {
            OreDictionary.registerOre("pressurePlateWood", new ItemStack(pressurePlateEucalyptus, 1));
            OreDictionary.registerOre("pressurePlateWood", new ItemStack(pressurePlateSakura, 1));
            OreDictionary.registerOre("pressurePlateWood", new ItemStack(pressurePlateGhostwood, 1));
            OreDictionary.registerOre("pressurePlateWood", new ItemStack(pressurePlateRedwood, 1));
            OreDictionary.registerOre("pressurePlateWood", new ItemStack(pressurePlateBloodwood, 1));
            OreDictionary.registerOre("pressurePlateWood", new ItemStack(pressurePlateHopseed, 1));
            OreDictionary.registerOre("pressurePlateWood", new ItemStack(pressurePlateMaple, 1));
            OreDictionary.registerOre("pressurePlateWood", new ItemStack(pressurePlateSilverbell, 1));
            OreDictionary.registerOre("pressurePlateWood", new ItemStack(pressurePlateAmaranth, 1));
            OreDictionary.registerOre("pressurePlateWood", new ItemStack(pressurePlateTiger, 1));
            OreDictionary.registerOre("pressurePlateWood", new ItemStack(pressurePlateWillow, 1));
            OreDictionary.registerOre("pressurePlateWood", new ItemStack(pressurePlateDarkwood, 1));
            OreDictionary.registerOre("pressurePlateWood", new ItemStack(pressurePlateFusewood, 1));
        }

        // Wooden Buttons
        if (PHNatura.enableWoodenButtons) {
            OreDictionary.registerOre("buttonWood", new ItemStack(buttonEucalyptus, 1));
            OreDictionary.registerOre("buttonWood", new ItemStack(buttonSakura, 1));
            OreDictionary.registerOre("buttonWood", new ItemStack(buttonGhostwood, 1));
            OreDictionary.registerOre("buttonWood", new ItemStack(buttonRedwood, 1));
            OreDictionary.registerOre("buttonWood", new ItemStack(buttonBloodwood, 1));
            OreDictionary.registerOre("buttonWood", new ItemStack(buttonHopseed, 1));
            OreDictionary.registerOre("buttonWood", new ItemStack(buttonMaple, 1));
            OreDictionary.registerOre("buttonWood", new ItemStack(buttonSilverbell, 1));
            OreDictionary.registerOre("buttonWood", new ItemStack(buttonAmaranth, 1));
            OreDictionary.registerOre("buttonWood", new ItemStack(buttonTiger, 1));
            OreDictionary.registerOre("buttonWood", new ItemStack(buttonWillow, 1));
            OreDictionary.registerOre("buttonWood", new ItemStack(buttonDarkwood, 1));
            OreDictionary.registerOre("buttonWood", new ItemStack(buttonFusewood, 1));
        }

        // Wooden Doors
        if (PHNatura.enableWoodenDoors) {
            OreDictionary.registerOre("doorWood", new ItemStack(doorItem, 1, OreDictionary.WILDCARD_VALUE));
        }

        // Other items
        OreDictionary.registerOre("cropBarley", new ItemStack(plantItem, 1, 0));
        OreDictionary.registerOre("cropCotton", new ItemStack(plantItem, 1, 3));

        OreDictionary.registerOre("listAllgrain", new ItemStack(plantItem, 1, 0));

        OreDictionary.registerOre("foodFlour", new ItemStack(plantItem, 1, 1));
        OreDictionary.registerOre("foodFlour", new ItemStack(plantItem, 1, 2));

        OreDictionary.registerOre("foodEqualswheat", new ItemStack(plantItem, 1, 2));

        OreDictionary.registerOre("dustSulphur", new ItemStack(plantItem, 1, 4));
        OreDictionary.registerOre("dustSulfur", new ItemStack(plantItem, 1, 4));

        OreDictionary.registerOre("dyeBlue", new ItemStack(plantItem, 1, 8));

        // Seed Bags

        // Seeds
        OreDictionary.registerOre("listAllseed", new ItemStack(seeds, 1, 0));
        OreDictionary.registerOre("listAllseed", new ItemStack(seeds, 1, 1));

        OreDictionary.registerOre("seedBarley", new ItemStack(seeds, 1, 0));
        OreDictionary.registerOre("seedCotton", new ItemStack(seeds, 1, 1));

        OreDictionary.registerOre("cropCactusfruit", new ItemStack(seedFood, 1, 0));

        // Berries
        if (PHNatura.enableBerryBushes) {
            OreDictionary.registerOre("listAllfruit", new ItemStack(berryItem, 1, OreDictionary.WILDCARD_VALUE));
            OreDictionary.registerOre("listAllberry", new ItemStack(berryItem, 1, OreDictionary.WILDCARD_VALUE));
            OreDictionary.registerOre("cropRaspberry", new ItemStack(berryItem, 1, 0));
            OreDictionary.registerOre("cropBlueberry", new ItemStack(berryItem, 1, 1));
            OreDictionary.registerOre("cropBlackberry", new ItemStack(berryItem, 1, 2));
            OreDictionary.registerOre("cropMaloberry", new ItemStack(berryItem, 1, 3));
        }

        if (PHNatura.enableNetherBerryBushes) {
            OreDictionary.registerOre("listAllfruit", new ItemStack(netherBerryItem, 1, OreDictionary.WILDCARD_VALUE));
            OreDictionary.registerOre("listAllberry", new ItemStack(netherBerryItem, 1, OreDictionary.WILDCARD_VALUE));
            OreDictionary.registerOre("cropBlightberry", new ItemStack(netherBerryItem, 1, 0));
            OreDictionary.registerOre("cropDuskberry", new ItemStack(netherBerryItem, 1, 1));
            OreDictionary.registerOre("cropSkyberry", new ItemStack(netherBerryItem, 1, 2));
            OreDictionary.registerOre("cropStingberry", new ItemStack(netherBerryItem, 1, 3));
        }

        // Nether items
        OreDictionary.registerOre("bowlWood", new ItemStack(bowlEmpty, 1, 0));
    }

    public void createEntities() {
        if (PHNatura.anyMobsEnabled) {
            BiomeGenBase[] nether = BiomeDictionary.getBiomesForType(BiomeDictionary.Type.NETHER);

            if (PHNatura.enableNitroCreepers) {
                EntityRegistry.registerModEntity(NitroCreeper.class, "NitroCreeper", 2, Natura.instance, 64, 5, true);
                EntityRegistry.addSpawn(NitroCreeper.class, 8, 4, 6, EnumCreatureType.monster, nether);
            }
            if (PHNatura.enableHeatscarSpiders) {
                EntityRegistry.registerModEntity(HeatscarSpider.class, "FlameSpider", 1, Natura.instance, 32, 5, true);
                EntityRegistry.registerModEntity(
                        BabyHeatscarSpider.class,
                        "FlameSpiderBaby",
                        4,
                        Natura.instance,
                        32,
                        5,
                        true);
                EntityRegistry.addSpawn(HeatscarSpider.class, 10, 4, 4, EnumCreatureType.monster, nether);
                EntityRegistry.addSpawn(BabyHeatscarSpider.class, 7, 4, 4, EnumCreatureType.monster, nether);
            }
            if (PHNatura.enableImps) {
                EntityRegistry.registerModEntity(ImpEntity.class, "Imp", 0, Natura.instance, 32, 5, true);
                EntityRegistry.addSpawn(ImpEntity.class, 10, 8, 12, EnumCreatureType.creature, nether);
            }

            BlockDispenser.dispenseBehaviorRegistry.putObject(spawnEgg, new DispenserBehaviorSpawnEgg());
        }

        EntityRegistry.registerModEntity(FusewoodArrow.class, "FusewoodArrow", 3, Natura.instance, 64, 3, true);
    }

    public void modIntegration() {
        try {
            Class.forName("tconstruct.TConstruct");
            PatternBuilder pb = PatternBuilder.instance;
            pb.registerMaterial(new ItemStack(saguaro), 2, "Cactus");
        } catch (Exception e) {}
    }

    public static Item spawnEgg;

    @Override
    public int getBurnTime(ItemStack fuel) {
        if (fuel.getItem() == new ItemStack(floraSapling).getItem()
                || fuel.getItem() == new ItemStack(rareSapling).getItem())
            return 100;
        return 0;
    }

    public static final String woodTextureNames[] = { "eucalyptus", "sakura", "ghostwood", "redwood", "bloodwood",
            "hopseed", "maple", "silverbell", "purpleheart", "tiger", "willow", "darkwood", "fusewood" };

    // Nether blocks
    // public static Block infernalStone;
    public static Block heatSand;

    public static Block netherrackFurnace;
    public static Block respawnObelisk;
    public static NetherGlass netherGlass;

    // Blaze Rails
    public static Block brailPowered;
    public static Block brailDetector;
    public static Block brail;
    public static Block brailActivator;

    // public static Block netherDropper;
    // public static Block netherDispenser;
    public static NetherPistonBase piston; // Not fully implemented
    public static NetherPistonBase pistonSticky; // Not fully implemented
    public static NetherPistonExtension pistonExtension; // Not fully implemented
    public static BlazeHopper netherHopper;
    public static Block netherPressurePlate;
    public static Block netherButton;
    public static Block netherLever;

    // Nether plants
    public static Block thornVines;
    public static Glowshroom glowshroom;
    public static Block glowshroomGreen;
    public static Block glowshroomPurple;
    public static Block glowshroomBlue;

    // Berry Bushes
    public static NetherBerryBush netherBerryBush;
    public static BerryBush berryBush;

    // Overworld plants
    public static CropBlock crops;
    public static Block saguaro;
    public static FlowerBlock bluebells;

    // Full grass blocks and slabs
    public static Block grassBlock;
    public static Block grassSlab;
    public static Block grassSlabDouble;

    // Clouds
    public static Block cloud;

    // Saplings
    public static OverworldSapling rareSapling;
    public static NSaplingBlock floraSapling;

    // Logs
    public static Block planks;
    public static Block tree;
    public static Block redwood;
    public static Block willow;
    public static Block bloodwood;
    public static Block rareTree;
    public static Block darkTree;

    // Leaves
    public static NLeaves floraLeaves;
    public static NLeaves floraLeavesNoColor;
    public static NLeaves rareLeaves;
    public static NLeaves darkLeaves;

    // Wooden Workbenches
    public static Block alternateWorkbench;

    // Wooden Bookshelves
    public static Block alternateBookshelf;

    // Wooden Stairs
    public static Block stairEucalyptus;
    public static Block stairSakura;
    public static Block stairGhostwood;
    public static Block stairRedwood;
    public static Block stairBloodwood;
    public static Block stairHopseed;
    public static Block stairMaple;
    public static Block stairSilverbell;
    public static Block stairAmaranth;
    public static Block stairTiger;
    public static Block stairWillow;
    public static Block stairDarkwood;
    public static Block stairFusewood;

    // Wooden Slabs
    public static Block plankSlab1;
    public static Block plankSlab2;
    public static Block plankSlab1Double;
    public static Block plankSlab2Double;

    // Wooden Trapdoors
    public static Block trapdoorEucalyptus;
    public static Block trapdoorSakura;
    public static Block trapdoorGhostwood;
    public static Block trapdoorRedwood;
    public static Block trapdoorBloodwood;
    public static Block trapdoorHopseed;
    public static Block trapdoorMaple;
    public static Block trapdoorAmaranth;
    public static Block trapdoorSilverbell;
    public static Block trapdoorTiger;
    public static Block trapdoorWillow;
    public static Block trapdoorDarkwood;
    public static Block trapdoorFusewood;

    // Wooden Fences
    public static Block alternateFence;

    // Wooden Fence Gates
    public static Block fenceGateEucalyptus;
    public static Block fenceGateSakura;
    public static Block fenceGateGhostwood;
    public static Block fenceGateRedwood;
    public static Block fenceGateBloodwood;
    public static Block fenceGateHopseed;
    public static Block fenceGateMaple;
    public static Block fenceGateAmaranth;
    public static Block fenceGateSilverbell;
    public static Block fenceGateTiger;
    public static Block fenceGateWillow;
    public static Block fenceGateDarkwood;
    public static Block fenceGateFusewood;

    // Wooden Pressure Plates
    public static Block pressurePlateEucalyptus;
    public static Block pressurePlateSakura;
    public static Block pressurePlateGhostwood;
    public static Block pressurePlateRedwood;
    public static Block pressurePlateBloodwood;
    public static Block pressurePlateHopseed;
    public static Block pressurePlateMaple;
    public static Block pressurePlateAmaranth;
    public static Block pressurePlateSilverbell;
    public static Block pressurePlateTiger;
    public static Block pressurePlateWillow;
    public static Block pressurePlateDarkwood;
    public static Block pressurePlateFusewood;

    // Wooden buttons
    public static Block buttonEucalyptus;
    public static Block buttonSakura;
    public static Block buttonGhostwood;
    public static Block buttonRedwood;
    public static Block buttonBloodwood;
    public static Block buttonHopseed;
    public static Block buttonMaple;
    public static Block buttonAmaranth;
    public static Block buttonSilverbell;
    public static Block buttonTiger;
    public static Block buttonWillow;
    public static Block buttonDarkwood;
    public static Block buttonFusewood;

    // Wooden Doors
    public static Block redwoodDoor;
    public static Block eucalyptusDoor;
    public static Block hopseedDoor;
    public static Block sakuraDoor;
    public static Block ghostDoor;
    public static Block bloodDoor;
    public static Block redwoodBarkDoor;

    public static Item doorItem;

    // Other items
    public static Item plantItem;
    public static Item waterDrop;
    // public static Item floraBoat;

    // Seed Bags
    public static Item wheatBag;
    public static Item carrotBag;
    public static Item potatoBag;
    public static Item barleyBag;
    public static Item cottonBag;
    public static Item netherWartBag;
    public static Item boneBag;

    // Seeds
    public static Item seeds;
    public static Item seedFood;

    // Berries
    public static Item berryItem;
    public static Item netherBerryItem;
    public static Item berryMedley;

    // Nether items
    public static Item potashApple;
    public static Item bowlStew;
    public static Item bowlEmpty;
    public static Item flintAndBlaze;

    // Imp Items
    public static Item impMeat;

    public static Item impHelmet;
    public static Item impJerkin;
    public static Item impLeggings;
    public static Item impBoots;

    public static ItemStack impHelmetStack;
    public static ItemStack impJerkinStack;
    public static ItemStack impLeggingsStack;
    public static ItemStack impBootsStack;

    // Wooden Sticks
    public static Item stickItem;

    // Nether tools
    public static Item ghostwoodSword;
    public static Item ghostwoodPickaxe;
    public static Item ghostwoodShovel;
    public static Item ghostwoodAxe;
    public static Item ghostwoodKama;
    public static Item ghostwoodBow;

    public static Item bloodwoodSword;
    public static Item bloodwoodPickaxe;
    public static Item bloodwoodShovel;
    public static Item bloodwoodAxe;
    public static Item bloodwoodKama;
    public static Item bloodwoodBow;

    public static Item darkwoodSword;
    public static Item darkwoodPickaxe;
    public static Item darkwoodShovel;
    public static Item darkwoodAxe;
    public static Item darkwoodKama;
    public static Item darkwoodBow;

    public static Item fusewoodSword;
    public static Item fusewoodPickaxe;
    public static Item fusewoodShovel;
    public static Item fusewoodAxe;
    public static Item fusewoodKama;
    public static Item fusewoodBow;

    public static Item netherquartzSword;
    public static Item netherquartzPickaxe;
    public static Item netherquartzShovel;
    public static Item netherquartzAxe;
    public static Item netherquartzKama;
}
