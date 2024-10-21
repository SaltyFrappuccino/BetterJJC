package net.mcreator.betterjjc.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.betterjjc.init.BetterjjcModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BreakConcentrationGojoProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 2) {
			if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 7) {
				if (world.getLevelData().getGameRules().getBoolean(BetterjjcModGameRules.BREAK_CONCENTRATION_GOJO_RED)) {
					entity.getPersistentData().putDouble("skill", 0);
					entity.getPersistentData().putDouble("cnt1", 0);
					entity.getPersistentData().putDouble("cnt5", 0);
					entity.getPersistentData().putDouble("cnt6", 0);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
				}
			} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 15) {
				if (world.getLevelData().getGameRules().getBoolean(BetterjjcModGameRules.BREAK_CONCENCTRATION_GOJO_HOLLOW_PURPLE)) {
					entity.getPersistentData().putDouble("skill", 0);
					entity.getPersistentData().putDouble("cnt1", 0);
					entity.getPersistentData().putDouble("cnt5", 0);
					entity.getPersistentData().putDouble("cnt6", 0);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
				}
			}
		}
	}
}
