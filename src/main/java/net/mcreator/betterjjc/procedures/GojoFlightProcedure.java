package net.mcreator.betterjjc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.betterjjc.init.BetterjjcModGameRules;

public class GojoFlightProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(BetterjjcModGameRules.BETTER_JJC_GOJO_FLIGHT)) {
			if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 2
					&& (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
							&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_1"))).isDone()) == true
					&& entity instanceof LivingEntity _livEnt0 && (_livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.FLY_EFFECT.get()) == false)) {
				if (entity.onGround()) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "effect give @s jujutsucraft:fly_effect 3 1 true");
						}
					}
				}
			}
		}
	}
}
