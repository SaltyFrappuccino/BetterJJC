
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.betterjjc.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BetterjjcModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> BETTER_JJC_WATER_WALKING = GameRules.register("betterJJCWaterWalking", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> BETTER_JJCRCT_FATIGUE = GameRules.register("betterJJCRCTFatigue", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.IntegerValue> WORLD_CUT_POWER = GameRules.register("worldCutPower", GameRules.Category.PLAYER, GameRules.IntegerValue.create(20));
	public static final GameRules.Key<GameRules.BooleanValue> BETTER_JJC_AIR_COMBAT = GameRules.register("betterJJCAirCombat", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> BETTER_JJC_GOJO_FLIGHT = GameRules.register("betterJJCGojoFlight", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> BREAK_CONCENTRATION_SUKUNA_DISMANTLE = GameRules.register("breakConcentrationSukunaDismantle", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> BREAK_CONCENTRATION_SUKUNA_FUUGA = GameRules.register("breakConcentrationSukunaFuuga", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> BETTER_JJC_SHOW_DAMAGE = GameRules.register("betterJJCShowDamage", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> BREAK_CONCENTRATION_GOJO_RED = GameRules.register("breakConcentrationGojoRed", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
	public static final GameRules.Key<GameRules.BooleanValue> BREAK_CONCENCTRATION_GOJO_HOLLOW_PURPLE = GameRules.register("breakConcenctrationGojoHollowPurple", GameRules.Category.PLAYER, GameRules.BooleanValue.create(true));
}