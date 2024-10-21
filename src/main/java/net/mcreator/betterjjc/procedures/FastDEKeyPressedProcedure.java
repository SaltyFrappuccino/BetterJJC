package net.mcreator.betterjjc.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.jujutsucraft.procedures.KeyStartTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class FastDEKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 0, Level.ExplosionInteraction.NONE);
		if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
				&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:mastery_domain_expansion"))).isDone() && (new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(entity)) == false) {
			if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.UNSTABLE.get())) == false
					&& (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				{
					double _setval = 20;
					entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerSelectCurseTechnique = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
			} else if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == true) {
				{
					double _setval = 21;
					entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerSelectCurseTechnique = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
