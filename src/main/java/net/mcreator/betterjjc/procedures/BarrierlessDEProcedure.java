package net.mcreator.betterjjc.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.betterjjc.init.BetterjjcModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BarrierlessDEProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(BetterjjcModGameRules.BETTER_JJC_BARRIERLESS_DOMAIN_EXPANSION) == true) {
			if (entity.getPersistentData().getDouble("cnt1") >= 1 && entity.getPersistentData().getDouble("cnt3") == 20 && entity instanceof ServerPlayer _plr4 && _plr4.level() instanceof ServerLevel
					&& _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:mastery_domain_expansion"))).isDone() && entity.isShiftKeyDown() == false) {
				entity.getPersistentData().putDouble("cnt2", 1);
				entity.getPersistentData().putDouble("betterJJC_Range", 198);
				if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 41
						&& (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 18
						&& (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 1) {
					JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 40;
					JujutsucraftModVariables.MapVariables.get(world).syncData(world);
				}
			} else if (entity.getPersistentData().getDouble("cnt1") == 1 && entity.getPersistentData().getDouble("cnt3") == 20) {
				entity.getPersistentData().putDouble("betterJJC_Range", 0);
				JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 22;
				JujutsucraftModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
