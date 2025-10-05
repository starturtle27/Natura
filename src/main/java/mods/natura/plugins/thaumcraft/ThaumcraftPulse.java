package mods.natura.plugins.thaumcraft;

import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import mantle.pulsar.pulse.Handler;
import mantle.pulsar.pulse.Pulse;
import mods.natura.Natura;
import mods.natura.common.NContent;
import mods.natura.common.PHNatura;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

@Pulse(id = "Natura Thaumcraft Compatibility", modsRequired = ThaumcraftPulse.modId)
public class ThaumcraftPulse {

    public static final String modId = "Thaumcraft";

    @Handler
    public void init(FMLInitializationEvent evt) {
        if (PHNatura.enableBerryBushes) {
            FMLInterModComms
                    .sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(NContent.berryBush, 1, 12));
            FMLInterModComms
                    .sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(NContent.berryBush, 1, 13));
            FMLInterModComms
                    .sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(NContent.berryBush, 1, 14));
            FMLInterModComms
                    .sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(NContent.berryBush, 1, 15));
        }
        if (PHNatura.enableNetherBerryBushes) {
            FMLInterModComms
                    .sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(NContent.netherBerryBush, 1, 12));
            FMLInterModComms
                    .sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(NContent.netherBerryBush, 1, 13));
            FMLInterModComms
                    .sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(NContent.netherBerryBush, 1, 14));
            FMLInterModComms
                    .sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(NContent.netherBerryBush, 1, 15));
        }
        FMLInterModComms.sendMessage("Thaumcraft", "harvestClickableCrop", new ItemStack(NContent.crops, 1, 8));
        FMLInterModComms.sendMessage("Thaumcraft", "harvestStandardCrop", new ItemStack(NContent.crops, 1, 3));
    }

    @Handler
    public void postInit(FMLPostInitializationEvent evt) {
        try {
            Class.forName("thaumcraft.api.ThaumcraftApi");

            // Register seeds
            AspectList seedTags = new AspectList();
            seedTags.add(Aspect.PLANT, 1);
            seedTags.add(Aspect.EXCHANGE, 1);
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.seeds, 1, 0), seedTags);
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.seeds, 1, 1), seedTags);

            // Register plants
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.plantItem, 0, 0),
                    new AspectList().add(Aspect.LIFE, 2).add(Aspect.CROP, 2));
            ThaumcraftApi
                    .registerObjectTag(new ItemStack(NContent.plantItem, 0, 3), new AspectList().add(Aspect.CLOTH, 1));
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.plantItem, 0, 4),
                    new AspectList().add(Aspect.ENTROPY, 1).add(Aspect.FIRE, 1));
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.plantItem, 0, 5),
                    new AspectList().add(Aspect.AIR, 1).add(Aspect.FLIGHT, 1));
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.plantItem, 0, 6),
                    new AspectList().add(Aspect.BEAST, 1).add(Aspect.FLESH, 1).add(Aspect.CLOTH, 1).add(Aspect.ARMOR, 1)
                            .add(Aspect.FIRE, 1));
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.plantItem, 0, 7),
                    new AspectList().add(Aspect.BEAST, 1).add(Aspect.CLOTH, 1).add(Aspect.TRAP, 1).add(Aspect.FIRE, 1));

            // Register wood
            AspectList logTags = new AspectList();
            logTags.add(Aspect.TREE, 4);
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.tree, 0, 0), logTags);
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.tree, 0, 1), logTags);
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.tree, 0, 3), logTags);
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.willow, 0, 0), logTags);
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.willow, 0, 1), logTags);
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.redwood, 0, 0),
                    new AspectList().add(Aspect.ARMOR, 1).add(Aspect.TREE, 3));
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.redwood, 0, 1), logTags);
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.redwood, 0, 2),
                    new AspectList().add(Aspect.EARTH, 1).add(Aspect.TREE, 3));

            // Register Leaves
            AspectList leafTags = new AspectList();
            leafTags.add(Aspect.PLANT, 2);
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.floraLeavesNoColor, 0, 0), leafTags);
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.floraLeavesNoColor, 0, 1), leafTags);
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.floraLeavesNoColor, 0, 2),
                    new AspectList().add(Aspect.TREE, 2).add(Aspect.METAL, 1));
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.floraLeaves, 0, 0), leafTags);
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.floraLeaves, 0, 1), leafTags);
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.floraLeaves, 0, 2), leafTags);
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.floraLeaves, 0, 3), leafTags);

            // Register rare trees
            for (int i = 0; i < 4; i++) {
                ThaumcraftApi.registerObjectTag(new ItemStack(NContent.rareTree, 0, i), logTags);
                ThaumcraftApi.registerObjectTag(new ItemStack(NContent.rareLeaves, 0, i), leafTags);
            }

            // Register mushrooms
            AspectList shroomTag = new AspectList();
            shroomTag.add(Aspect.PLANT, 4);
            shroomTag.add(Aspect.LIGHT, 1);
            shroomTag.add(Aspect.SOUL, 1);
            for (int i = 0; i < 3; i++) {
                ThaumcraftApi.registerObjectTag(new ItemStack(NContent.glowshroom, 0, i), shroomTag);
            }

            // Register berries and berry bushes
            if (PHNatura.enableBerryBushes) {
                AspectList berryTag = new AspectList();
                berryTag.add(Aspect.LIFE, 1);
                AspectList berryBushTag = new AspectList();
                berryBushTag.add(Aspect.PLANT, 1);
                berryTag.add(Aspect.CROP, 1);
                for (int i = 0; i < 4; i++) {
                    ThaumcraftApi.registerObjectTag(new ItemStack(NContent.berryItem, 0, i), berryTag);
                    ThaumcraftApi.registerObjectTag(new ItemStack(NContent.berryBush, 0, i), berryBushTag);
                }
            }

            // Register bowls, bowls of stew, and other bowl-based things
            AspectList bowlEmptyTag = new AspectList();
            bowlEmptyTag.add(Aspect.VOID, 1);
            AspectList bowlStewTag = new AspectList();
            bowlStewTag.add(Aspect.PLANT, 6);
            bowlStewTag.add(Aspect.AIR, 1);
            bowlStewTag.add(Aspect.LIFE, 4);
            AspectList glowStewTag = new AspectList();
            glowStewTag.add(Aspect.PLANT, 8);
            glowStewTag.add(Aspect.AIR, 1);
            glowStewTag.add(Aspect.LIFE, 4);
            glowStewTag.add(Aspect.LIGHT, 4);

            for (int i = 0; i < 13; i++) {
                ThaumcraftApi.registerObjectTag(new ItemStack(NContent.bowlEmpty, 0, i), bowlEmptyTag);
                ThaumcraftApi.registerObjectTag(new ItemStack(NContent.bowlStew, 0, i), bowlStewTag);
                ThaumcraftApi.registerObjectTag(new ItemStack(NContent.bowlStew, 0, i + 13), glowStewTag);
            }

            // Register other overworld saplings
            AspectList saplingTag = new AspectList();
            saplingTag.add(Aspect.TREE, 2);
            saplingTag.add(Aspect.PLANT, 2);
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.rareSapling, 0, 4), saplingTag);
            for (int i = 0; i < 4; i++) {
                ThaumcraftApi.registerObjectTag(new ItemStack(NContent.floraSapling, 0, i), saplingTag);
                ThaumcraftApi.registerObjectTag(new ItemStack(NContent.rareSapling, 0, i), saplingTag);
            }

            // Register cactus stuff
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.saguaro, 0, 0),
                    new AspectList().add(Aspect.WATER, 1).add(Aspect.PLANT, 2).add(Aspect.WEAPON, 1)
                            .add(Aspect.TREE, 2));
            if (PHNatura.enableCactusJuice) {
                ThaumcraftApi.registerObjectTag(
                        new ItemStack(NContent.waterDrop, 0, 0),
                        new AspectList().add(Aspect.WATER, 1));
            }
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.seedFood, 0, 0),
                    new AspectList().add(Aspect.CROP, 2).add(Aspect.PLANT, 1).add(Aspect.WATER, 1));

            // Register overworld clouds
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.cloud, 0, 0),
                    new AspectList().add(Aspect.AIR, 1).add(Aspect.FLIGHT, 1).add(Aspect.WATER, 1)
                            .add(Aspect.WEATHER, 1));

            // Register Nether saplings
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.floraSapling, 0, 4),
                    new AspectList().add(Aspect.SOUL, 1).add(Aspect.PLANT, 2).add(Aspect.TREE, 2));
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.floraSapling, 0, 5),
                    new AspectList().add(Aspect.TREE, 2).add(Aspect.PLANT, 2));
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.floraSapling, 0, 6),
                    new AspectList().add(Aspect.TREE, 2).add(Aspect.PLANT, 2));
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.floraSapling, 0, 7),
                    new AspectList().add(Aspect.TREE, 2).add(Aspect.PLANT, 2).add(Aspect.ENTROPY, 2));

            // Register Nether blocks
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.heatSand, 0, 0),
                    new AspectList().add(Aspect.FIRE, 2).add(Aspect.EARTH, 1));

            // Register Nether trees and leaves
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.tree, 0, 2),
                    new AspectList().add(Aspect.TREE, 3).add(Aspect.SOUL, 1));
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.planks, 0, 2), new AspectList().add(Aspect.TREE, 1));
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.planks, 0, 4),
                    new AspectList().add(Aspect.TREE, 1).add(Aspect.METAL, 1));
            ThaumcraftApi
                    .registerObjectTag(new ItemStack(NContent.darkTree, 0, 0), new AspectList().add(Aspect.TREE, 4));
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.darkTree, 0, 1),
                    new AspectList().add(Aspect.TREE, 4).add(Aspect.ENTROPY, 2));
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.bloodwood, 0, 0),
                    new AspectList().add(Aspect.TREE, 2).add(Aspect.ENERGY, 2).add(Aspect.METAL, 1));
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.bloodwood, 0, 15),
                    new AspectList().add(Aspect.TREE, 2).add(Aspect.ENERGY, 2).add(Aspect.METAL, 1));
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.darkLeaves, 0, 0), leafTags);
            ThaumcraftApi.registerObjectTag(new ItemStack(NContent.darkLeaves, 0, 1), leafTags);
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.darkLeaves, 0, 2),
                    new AspectList().add(Aspect.PLANT, 2).add(Aspect.CROP, 2));
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.darkLeaves, 0, 3),
                    new AspectList().add(Aspect.PLANT, 2).add(Aspect.ENTROPY, 1));

            // Register Nether vines
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.thornVines, 0, 0),
                    new AspectList().add(Aspect.FIRE, 1).add(Aspect.PLANT, 1));

            // Register Nether berries and berry bushes
            if (PHNatura.enableNetherBerryBushes) {
                ThaumcraftApi.registerObjectTag(
                        new ItemStack(NContent.netherBerryBush, 0, 0),
                        new AspectList().add(Aspect.ENTROPY, 4).add(Aspect.POISON, 4).add(Aspect.PLANT, 1));
                ThaumcraftApi.registerObjectTag(
                        new ItemStack(NContent.netherBerryBush, 0, 1),
                        new AspectList().add(Aspect.ENTROPY, 4).add(Aspect.DARKNESS, 4).add(Aspect.PLANT, 1));
                ThaumcraftApi.registerObjectTag(
                        new ItemStack(NContent.netherBerryBush, 0, 2),
                        new AspectList().add(Aspect.ENTROPY, 4).add(Aspect.FLIGHT, 4).add(Aspect.PLANT, 1));
                ThaumcraftApi.registerObjectTag(
                        new ItemStack(NContent.netherBerryBush, 0, 3),
                        new AspectList().add(Aspect.ENTROPY, 8).add(Aspect.PLANT, 1));
                ThaumcraftApi.registerObjectTag(
                        new ItemStack(NContent.netherBerryItem, 0, 0),
                        new AspectList().add(Aspect.ENTROPY, 4).add(Aspect.POISON, 4).add(Aspect.LIFE, 1)
                                .add(Aspect.CROP, 1));
                ThaumcraftApi.registerObjectTag(
                        new ItemStack(NContent.netherBerryItem, 0, 1),
                        new AspectList().add(Aspect.ENTROPY, 4).add(Aspect.DARKNESS, 4).add(Aspect.LIFE, 1)
                                .add(Aspect.CROP, 1));
                ThaumcraftApi.registerObjectTag(
                        new ItemStack(NContent.netherBerryItem, 0, 2),
                        new AspectList().add(Aspect.ENTROPY, 4).add(Aspect.FLIGHT, 4).add(Aspect.LIFE, 1)
                                .add(Aspect.CROP, 1));
                ThaumcraftApi.registerObjectTag(
                        new ItemStack(NContent.netherBerryItem, 0, 3),
                        new AspectList().add(Aspect.ENTROPY, 8).add(Aspect.LIFE, 1).add(Aspect.CROP, 1));
            }

            // Register Nether and End clouds
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.cloud, 0, 2),
                    new AspectList().add(Aspect.AIR, 1).add(Aspect.FLIGHT, 1).add(Aspect.FIRE, 1)
                            .add(Aspect.WEATHER, 1));
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.cloud, 0, 3),
                    new AspectList().add(Aspect.AIR, 1).add(Aspect.FLIGHT, 1).add(Aspect.POISON, 1)
                            .add(Aspect.WEATHER, 1));
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.cloud, 0, 1),
                    new AspectList().add(Aspect.AIR, 1).add(Aspect.FLIGHT, 1).add(Aspect.ELDRITCH, 1)
                            .add(Aspect.WEATHER, 1));

            // Register other Nether items/plants
            ThaumcraftApi.registerObjectTag(
                    new ItemStack(NContent.potashApple, 0, 0),
                    new AspectList().add(Aspect.CROP, 2).add(Aspect.POISON, 2));

        } catch (Exception e) {
            Natura.logger.warn("ThaumCraft integration failed.", e);
        }
    }
}
