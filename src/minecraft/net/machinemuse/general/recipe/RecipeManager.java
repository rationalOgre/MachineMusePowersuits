package net.machinemuse.general.recipe;

import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.recipe.Recipes;
import net.machinemuse.numina.general.MuseLogger;
import net.machinemuse.numina.recipe.JSONRecipeList;
import net.machinemuse.powersuits.common.CommonProxy;
import net.machinemuse.powersuits.common.ModCompatability;
import net.machinemuse.powersuits.common.ModularPowersuits;
import net.machinemuse.powersuits.item.ItemComponent;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipeManager {

    public static ItemStack copyAndResize(ItemStack stack, int number) {
        ItemStack copy = stack.copy();
        copy.stackSize = number;
        return copy;
    }

    public static void addRecipes() {
        // Recipe
        ItemStack iron = new ItemStack(Item.ingotIron);
        ItemStack circuit = ItemComponent.wiring;
        ItemStack goldNugget = new ItemStack(Item.goldNugget);
        ItemStack ingotGold = new ItemStack(Item.ingotGold);
        ItemStack redstone = new ItemStack(Item.redstone);
        ItemStack wool = new ItemStack(Block.cloth);
        ItemStack string = new ItemStack(Item.silk);
        ItemStack paper = new ItemStack(Item.paper);
        ItemStack glass = new ItemStack(Block.glass);
        ItemStack glassPane = new ItemStack(Block.thinGlass);
        ItemStack glowstone = new ItemStack(Item.glowstone);
        ItemStack emerald = new ItemStack(Item.emerald);
        ItemStack diamond = new ItemStack(Item.diamond);
        ItemStack lapis = new ItemStack(Item.dyePowder, 1, 4);
        ItemStack rosered = new ItemStack(Item.dyePowder, 1, 1);
        ItemStack cactusgreen = new ItemStack(Item.dyePowder, 1, 2);
        ItemStack enderPearl = new ItemStack(Item.enderPearl);
        ItemStack stone = new ItemStack(Block.stone);

        if (ModCompatability.vanillaRecipesEnabled()) {
            JSONRecipeList.loadRecipesFromResource(CommonProxy.getResource("/assets/powersuits/recipes/vanilla.recipes"));
//            JSONRecipeList.loadRecipesFromDir(Numina.configDir() + "/machinemuse/recipes/vanilla.recipes");

        }
        if (ModCompatability.UERecipesEnabled()) {
            String basicCircuit = "circuitBasic";
            String advancedCircuit = "circuitAdvanced";
            String eliteCircuit = "circuitElite";
            ItemStack lapisBlock = new ItemStack(Block.blockLapis);

            try {
                ItemStack steelIngot = OreDictionary.getOres("ingotSteel").get(0);
                GameRegistry.addRecipe(new ShapedOreRecipe(copyAndResize(steelIngot, 5), true, "P", 'P', ItemComponent.basicPlating));
            } catch (Exception e) {
                MuseLogger.logError("Unable to load steel plate");
            }

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.controlCircuit, true, "WC ", "RGC", " RW", 'W', ItemComponent.wiring, 'C',
                    basicCircuit, 'G', glowstone, 'R', redstone));
            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.laserHologram, true, "YTG", "TWT", "BTR", 'W', ItemComponent.wiring, 'T', glass,
                    'Y', glowstone, 'G', cactusgreen, 'B', lapis, 'R', rosered));
            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.basicPlating, true, "II", "CI", "II", 'C', ItemComponent.wiring, 'I',
                    "ingotSteel"));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.advancedPlating, true, "II", "CI", "II", 'C', basicCircuit, 'I', diamond));

            GameRegistry.addRecipe(new ShapedOreRecipe(copyAndResize(diamond, 5), true, "P", 'P', ItemComponent.advancedPlating));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.tinkerTable), true, "ILI", "LEL", "ILI", 'I', "plateSteel",
                    'L', lapisBlock, 'E', emerald));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerArmorHead), true, "III", "C C", 'I', "plateSteel", 'C',
                    basicCircuit));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerArmorTorso), true, "I I", "CIC", "III", 'I',
                    "plateSteel", 'C', basicCircuit));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerArmorLegs), true, "III", "C C", "I I", 'I', "plateSteel",
                    'C', basicCircuit));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerArmorFeet), true, "C C", "I I", 'I', "plateSteel", 'C',
                    basicCircuit));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerTool), true, " C ", "CI ", " IC", 'I', "plateSteel", 'C',
                    basicCircuit));

            GameRegistry.addRecipe(new ShapedOreRecipe(copyAndResize(ItemComponent.wiring, 4), true, "GWG", 'G', goldNugget, 'W', "calclavia:WIRE"));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.parachute, true, "WWW", "S S", 'W', wool, 'S', string));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.lvcapacitor, "WBW", 'W', ItemComponent.wiring, 'B', "battery"));
            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.mvcapacitor, "WBW", 'W', ItemComponent.wiring, 'B', "advancedBattery"));
            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.hvcapacitor, "WBW", 'W', ItemComponent.wiring, 'B', "eliteBattery"));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.solenoid, true, "WIW", "WIW", "WIW", 'W', ItemComponent.wiring, 'I', iron));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.gliderWing, true, " SI", "SI ", "S  ", 'I', iron, 'S', "plateSteel"));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.servoMotor, true, " C ", "EIE", 'I', iron, 'E', ItemComponent.solenoid, 'C',
                    basicCircuit));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.fieldEmitter, true, "SES", "ECE", "SES", 'S', ItemComponent.solenoid, 'E',
                    enderPearl, 'C', advancedCircuit));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.ionThruster, true, " FE", "CG ", "IFE", 'I', "plateSteel", 'E',
                    ItemComponent.solenoid, 'G', glowstone, 'C', advancedCircuit, 'F', ItemComponent.fieldEmitter));

        }
        if (ModCompatability.IC2RecipesEnabled() && ModCompatability.isIndustrialCraftLoaded()) {
            circuit = ModCompatability.getIC2Item("electronicCircuit");
            ItemStack advCircuit = ModCompatability.getIC2Item("advancedCircuit");
            goldNugget = ModCompatability.getIC2Item("goldCableItem");
            String refIron = "ingotRefinedIron";
            String tin = "ingotTin";
            String copper = "ingotCopper";
            ItemStack reBattery = ModCompatability.getIC2Item("reBattery");
            ItemStack fullBattery = ModCompatability.getIC2Item("chargedReBattery");
            ItemStack energyCrystal = ModCompatability.getIC2Item("energyCrystal");
            ItemStack lapotronCrystal = ModCompatability.getIC2Item("lapotronCrystal");
            ItemStack iridiumOre = ModCompatability.getIC2Item("iridiumOre");
            ItemStack carbonPlate = ModCompatability.getIC2Item("carbonPlate");
            ItemStack machine = ModCompatability.getIC2Item("machine");
            ItemStack advMachine = ModCompatability.getIC2Item("advancedMachine");
            ItemStack gen = ModCompatability.getIC2Item("generator");

            try {
                ItemStack refinedIron = OreDictionary.getOres("ingotRefinedIron").get(0);
                GameRegistry.addRecipe(new ShapedOreRecipe(copyAndResize(refinedIron, 5), true, "P", 'P', ItemComponent.basicPlating));
            } catch (Exception e) {
                MuseLogger.logError("Unable to load Refined Iron");
                GameRegistry.addRecipe(new ShapedOreRecipe(copyAndResize(iron, 5), true, "P", 'P', ItemComponent.basicPlating));
            }
            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.controlCircuit, true, "WC ", "RGC", " RW", 'W', ItemComponent.wiring, 'C',
                    circuit, 'G', glowstone, 'R', redstone));
            GameRegistry.addRecipe(new ShapedOreRecipe(copyAndResize(diamond, 5), true, "P", 'P', ItemComponent.advancedPlating));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.laserHologram, true, "YTG", "TWT", "BTR", 'W', ItemComponent.wiring, 'T', glass,
                    'Y', glowstone, 'G', cactusgreen, 'B', lapis, 'R', rosered));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.basicPlating, true, "II", "CI", "II", 'C', circuit, 'I', "ingotRefinedIron"));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.advancedPlating, true, "II", "CI", "II", 'C', advCircuit, 'I', diamond));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.tinkerTable), true, "E", "C", "M", 'E', emerald, 'C', circuit
                    .copy(), 'M', machine));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerArmorHead), true, "III", "C C", 'I', refIron, 'C',
                    circuit.copy()));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerArmorTorso), true, "I I", "CIC", "III", 'I', refIron,
                    'C', circuit.copy()));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerArmorLegs), true, "III", "C C", "I I", 'I', refIron, 'C',
                    circuit.copy()));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerArmorFeet), true, "C C", "I I", 'I', refIron, 'C',
                    circuit.copy()));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerTool), true, " C ", "CI ", " IC", 'I', refIron, 'C',
                    circuit.copy()));

            GameRegistry.addRecipe(new ShapedOreRecipe(copyAndResize(ItemComponent.wiring, 2), true, "GRG", 'G', goldNugget.copy(), 'R', redstone));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.parachute, true, "WWW", "S S", 'W', wool, 'S', string));

            Recipes.advRecipes.addRecipe(ItemComponent.lvcapacitor, "WBW", 'W', ItemComponent.wiring.copy(), 'B', reBattery);

            Recipes.advRecipes.addRecipe(ItemComponent.lvcapacitor, "WBW", 'W', ItemComponent.wiring.copy(), 'B', fullBattery);

            Recipes.advRecipes.addRecipe(ItemComponent.mvcapacitor, "WBW", 'W', ItemComponent.wiring.copy(), 'B', energyCrystal);

            Recipes.advRecipes.addRecipe(ItemComponent.hvcapacitor, "WBW", 'W', ItemComponent.wiring.copy(), 'B', lapotronCrystal);

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.solenoid, true, " W ", "WIW", " W ", 'W', ItemComponent.wiring, 'I', machine));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.gliderWing, true, " CC", "CCI", "C  ", 'C', carbonPlate.copy(), 'I',
                    ItemComponent.solenoid));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.servoMotor, true, " W ", "EME", 'M', machine.copy(), 'E',
                    ItemComponent.solenoid, 'W', circuit.copy()));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.fieldEmitter, true, "SES", "ECE", "SES", 'S', ItemComponent.solenoid, 'E',
                    enderPearl, 'C', advCircuit));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.ionThruster, true, " FE", "MG ", "CFE", 'I', iron, 'E', ItemComponent.solenoid,
                    'F', ItemComponent.fieldEmitter, 'G', glowstone, 'C', advCircuit.copy(), 'M', advMachine.copy()));

        }
        if (ModCompatability.GregTechRecipesEnabled() && ModCompatability.isIndustrialCraftLoaded() && ModCompatability.isGregTechLoaded()) {
            // This means Gregtech is installed, and GregoriusT in his infinite
            // wisdom has registered literally everything in the universe with
            // the ore dictionary, so we can just use strings here :D ...once we
            // decide what to put.
            String computerMonitor = "craftingMonitorTier02";

            String basicCircuit = "craftingCircuitTier02";
            String advancedCircuit = "craftingCircuitTier04";
            String dataStorageCircuit = "craftingCircuitTier05";
            String energyFlowCircuit = "craftingCircuitTier07";

            String machineParts = "craftingMachineParts";
            String advancedMachine = "craftingRawMachineTier02";

            String nitrogen = "molecule_1n";

            String refinedIron = "ingotRefinedIron";

            ItemStack neutronReflector = ModCompatability.getGregtechItem(40, 1, 0);
            String advancedHeatVent = "item.reactorVentDiamond";
            ItemStack carbonPlate = ModCompatability.getIC2Item("carbonPlate");
            ItemStack uninsulatedCopper = ModCompatability.getIC2Item("copperCableItem");
            ItemStack luminator = ModCompatability.getIC2Item("luminator");
            ItemStack reinforcedGlass = ModCompatability.getIC2Item("reinforcedGlass");

            try {
                ItemStack titanium = OreDictionary.getOres("ingotSteel").get(0);
                GameRegistry.addRecipe(new ShapedOreRecipe(copyAndResize(titanium, 5), true, "P", 'P', ItemComponent.basicPlating));
            } catch (Exception e) {
                MuseLogger.logError("Unable to load ingotSteel");
            }
            try {
                ItemStack iridium = OreDictionary.getOres("ingotTitanium").get(0);
                GameRegistry.addRecipe(new ShapedOreRecipe(copyAndResize(iridium, 5), true, "P", 'P', ItemComponent.advancedPlating));
            } catch (Exception e) {
                MuseLogger.logError("Unable to load ingotTitanium");
            }

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.controlCircuit, true, "WCI", "RGC", "IRW", 'W', ItemComponent.wiring, 'C',
                    advancedCircuit, 'G', energyFlowCircuit, 'R', dataStorageCircuit, 'I', "ingotElectrum"));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.laserHologram, true, "LLL", "RGB", "LLL", 'L', luminator, 'R', "gemRuby", 'G',
                    "gemGreenSapphire", 'B', "gemSapphire"));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.basicPlating, true, "II", "CI", "II", 'C', basicCircuit, 'I', "ingotSteel"));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.advancedPlating, true, "II", "CI", "II", 'C', advancedCircuit, 'I',
                    "ingotTitanium"));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.tinkerTable), true, "CVC", "IEI", "IMI", 'C', advancedCircuit,
                    'E', emerald, 'V', computerMonitor, 'I', refinedIron, 'M', advancedMachine));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerArmorHead), true, "ACA", "MVM", 'A', "ingotAluminium",
                    'C', dataStorageCircuit, 'M', machineParts, 'V', computerMonitor));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerArmorTorso), true, "AMA", "ACA", "AAA", 'A',
                    "ingotAluminium", 'C', dataStorageCircuit, 'M', machineParts));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerArmorLegs), true, "MCM", "A A", "A A", 'A',
                    "ingotAluminium", 'C', dataStorageCircuit, 'M', machineParts));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerArmorFeet), true, "M M", "ACA", 'A', "ingotAluminium",
                    'C', dataStorageCircuit, 'M', machineParts));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerTool), true, "A A", "AMA", " C ", 'A', "ingotAluminium",
                    'C', dataStorageCircuit, 'M', machineParts));

            GameRegistry.addRecipe(new ShapedOreRecipe(copyAndResize(ItemComponent.wiring, 2), true, "CCC", "SSS", "CCC", 'C', uninsulatedCopper,
                    'S', "ingotSilver"));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.parachute, true, "WWW", "S S", "CNC", 'W', wool, 'S', string, 'C', carbonPlate,
                    'N', nitrogen));

            Recipes.advRecipes.addRecipe(ItemComponent.lvcapacitor,
                    "IWI",
                    "IBI",
                    "IBI",
                    'W', ItemComponent.wiring,
                    'I', "ingotSteel",
                    'B', "crafting100kEUStore"); // Lithium battery

            Recipes.advRecipes.addRecipe(ItemComponent.mvcapacitor,
                    "IWI",
                    "IBI",
                    "IBI",
                    'W', "componentWiring",
                    'I', "ingotTitanium",
                    'B', "crafting1kkEUStore"); // Lapotron crystal

            Recipes.advRecipes.addRecipe(ItemComponent.hvcapacitor,
                    "IWI",
                    "IBI",
                    "IBI",
                    'W', ItemComponent.wiring,
                    'I', "ingotChrome",
                    'B', "crafting10kkEUStore"); // Lapotronic EnergyOrb

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.solenoid, true,
                    "WSW",
                    "WSW",
                    "WSW",
                    'W', ItemComponent.wiring,
                    'S', "ingotSteel"));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.gliderWing, true,
                    " MC",
                    "MPI",
                    "M  ",
                    'P', carbonPlate,
                    'M', "plateMagnalium",
                    'I', ItemComponent.solenoid,
                    'C', advancedCircuit));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.servoMotor, true,
                    "IBI",
                    "CSC",
                    "IBI",
                    'I', "ingotSteel",
                    'B', "ingotBrass",
                    'C', advancedCircuit,
                    'S', ItemComponent.solenoid));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.fieldEmitter, true,
                    "ISI",
                    "CUC",
                    "ISI",
                    'I', "ingotTungstenSteel",
                    'S', ItemComponent.solenoid,
                    'U', energyFlowCircuit,
                    'C', "craftingSuperconductor"));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.ionThruster, true,
                    "ISI",
                    "FCF",
                    "N N",
                    'I', "plateAlloyIridium",
                    'S', "craftingSuperconductor",
                    'N', neutronReflector,
                    'C', ItemComponent.hvcapacitor,
                    'F', ItemComponent.fieldEmitter));

        }
        if (ModCompatability.ThermalExpansionRecipesEnabled() && ModCompatability.isThermalExpansionLoaded()) {
            ItemStack pneumaticServo = ModCompatability.getThermexItem("pneumaticServo", 1);
            ItemStack machineFrame = ModCompatability.getThermexItem("machineFrame", 1);
            ItemStack powerCoilGold = ModCompatability.getThermexItem("powerCoilGold", 1);
            ItemStack powerCoilSilver = ModCompatability.getThermexItem("powerCoilSilver", 1);
            ItemStack powerCoilElectrum = ModCompatability.getThermexItem("powerCoilElectrum", 1);
            String gearCopper = "gearCopper";
            String gearTin = "gearTin";
            ItemStack gearInvar = ModCompatability.getThermexItem("gearInvar", 1);
            ItemStack compressedSawdust = ModCompatability.getThermexItem("hardenedGlass", 1);
            ItemStack energyFrameFull = ModCompatability.getThermexItem("energyCellFrameFull", 1);
            ItemStack conduitEnergy = ModCompatability.getThermexItem("energyConduitEmpty", 1);
            ItemStack teleportFrameFull = ModCompatability.getThermexItem("tesseractFrameFull", 1);
            // IC2ItemTest hardenedGlass =
            // ModCompatability.getThermexItem("blockGlass", 1);
            // Unmake the armor platings
            // try {
            // IC2ItemTest titanium =
            // OreDictionary.getOres("ingotTitanium").get(0);
            // GameRegistry.addRecipe(new
            // ShapedOreRecipe(copyAndResize(titanium, 5), true,
            // "P", 'P', ItemComponent.basicPlating));
            // } catch (Exception e) {
            // MuseLogger.logError("Unable to load Titanium");
            // }

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.controlCircuit, true, "EGW", "RWG", "WRE", 'E', "ingotElectrum", 'W',
                    ItemComponent.wiring, 'G', glowstone, 'R', redstone));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.laserHologram, true, "RGB", " H ", "WLW", 'W', ItemComponent.wiring, 'L',
                    powerCoilGold, 'H', glass, 'R', rosered, 'G', cactusgreen, 'B', lapis));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.basicPlating, true, "II", "CI", "II", 'C', gearTin, 'I', iron));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.advancedPlating, true, "II", "CI", "II", 'C', gearInvar, 'I', diamond));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.tinkerTable), true, " E ", "IMI", " R ", 'R', powerCoilSilver,
                    'M', machineFrame, 'E', emerald, 'I', "ingotElectrum"));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerArmorHead), true, "III", "W W", 'I', iron, 'W',
                    ItemComponent.wiring));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerArmorTorso), true, "I I", "WIW", "III", 'I', iron, 'W',
                    ItemComponent.wiring));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerArmorLegs), true, "III", "W W", "I I", 'I', iron, 'W',
                    ItemComponent.wiring));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerArmorFeet), true, "W W", "I I", 'I', iron, 'W',
                    ItemComponent.wiring));

            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModularPowersuits.powerTool), true, " I ", "IEI", " W ", 'W',
                    ItemComponent.wiring, 'E', "ingotElectrum", 'I', iron));

            GameRegistry.addRecipe(new ShapedOreRecipe(copyAndResize(ItemComponent.wiring, 8), true, "CCC", "SSS", "CCC", 'C', "ingotCopper", 'S',
                    "ingotSilver"));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.parachute, true, "WWW", "S S", " O ", 'W', wool, 'S', string, 'O',
                    pneumaticServo));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.lvcapacitor, false, "CPT", "W W", 'W', ItemComponent.wiring, 'C', "ingotSilver",
                    'T', "ingotGold", 'P', new ItemStack(Item.paper)));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.mvcapacitor, "WRW", 'W', ItemComponent.wiring, 'R', conduitEnergy));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.hvcapacitor, "WRW", 'W', ItemComponent.wiring, 'R', energyFrameFull));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.solenoid, true, "WSW", "WSW", "WSW", 'W', ItemComponent.wiring, 'S', iron));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.gliderWing, true, " GG", "GGI", "G  ", 'G', compressedSawdust, 'I',
                    ItemComponent.solenoid));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.servoMotor, true, " O ", "WSW", " O ", 'O', ItemComponent.solenoid, 'S',
                    pneumaticServo, 'W', ItemComponent.wiring));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.fieldEmitter, true, " W ", "OUO", " W ", 'W', ItemComponent.wiring, 'O',
                    ItemComponent.solenoid, 'U', teleportFrameFull));

            GameRegistry.addRecipe(new ShapedOreRecipe(ItemComponent.ionThruster, true, " FI", "IG ", "WFI", 'I', "ingotInvar", 'G', glowstone, 'W',
                    ItemComponent.wiring, 'F', ItemComponent.fieldEmitter));

        }
    }
}
