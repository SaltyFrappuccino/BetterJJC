package net.mcreator.betterjjc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.betterjjc.init.BetterjjcModGameRules;

public class IncreaseOutputKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(BetterjjcModGameRules.BETTER_JJC_INCREASE_OUTPUT) == true) {
			if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower >= (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost * ((world.getLevelData().getGameRules().getInt(BetterjjcModGameRules.BETTER_JJC_INCREASE_OUTPUT_COST)) / 100)
					&& (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost > 10) {
				if (entity.getPersistentData().getDouble("cnt6") >= 5 && entity.getPersistentData().getDouble("BetterJJC_IncreaseOutputVar") <= (world.getLevelData().getGameRules().getInt(BetterjjcModGameRules.BETTER_JJC_INCREASE_OUTPUT_MAX))) {
					if (entity.getPersistentData().getDouble("cnt6") == 5) {
						entity.getPersistentData().putDouble("BetterJJC_IncreaseOutputVar", (entity.getPersistentData().getDouble("cnt6")));
					}
					entity.getPersistentData().putDouble("BetterJJC_IncreaseOutputVar", (entity.getPersistentData().getDouble("BetterJJC_IncreaseOutputVar") + 1));
					entity.getPersistentData().putBoolean("BetterJJC_IncreaseOutput", true);
					{
						double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower
								- (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost
										* ((world.getLevelData().getGameRules().getInt(BetterjjcModGameRules.BETTER_JJC_INCREASE_OUTPUT_COST)) / 100));
						entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.PlayerCursePower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
