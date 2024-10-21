package net.mcreator.betterjjc.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class SaveFastSkill1KeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double ticks = 0;
		if (entity.getPersistentData().getBoolean("SaveFastSkill_PRESSED")) {
			if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique != 20) {
				entity.getPersistentData().putDouble("FastSkill1_CurseTechnique", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique);
				entity.getPersistentData().putDouble("FastSkill1_SelectCurseTechnique",
						(entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique);
				entity.getPersistentData().putDouble("FastSkill1_SelectCurseTechniqueCost",
						(entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Saved the current skill in the \u00A7lfirst slot"), false);
			}
		} else if (entity.getPersistentData().getBoolean("CombatMode")) {
			if (entity.getPersistentData().getDouble("FastSkill1_CurseTechnique") == (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique
					&& entity.getPersistentData().getDouble("FastSkill1_SelectCurseTechnique") != 0 && entity.getPersistentData().getDouble("FastSkill1_SelectCurseTechnique") != 20) {
				if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.UNSTABLE.get()) == false && entity instanceof LivingEntity
						&& ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) == false) {
					if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower >= entity.getPersistentData()
							.getDouble("FastSkill1_SelectCurseTechniqueCost")) {
						if (entity.getPersistentData().getDouble("FastSkill1_SelectCurseTechnique") < 10) {
							entity.getPersistentData().putDouble("skill", new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(Math.round(entity.getPersistentData().getDouble("FastSkill1_CurseTechnique")) + "" + Math.round(0) + Math.round(entity.getPersistentData().getDouble("FastSkill1_SelectCurseTechnique"))));
						} else if (entity.getPersistentData().getDouble("FastSkill1_SelectCurseTechnique") < 10) {
							entity.getPersistentData().putDouble("skill", new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(Math.round(entity.getPersistentData().getDouble("FastSkill1_CurseTechnique")) + "" + Math.round(entity.getPersistentData().getDouble("FastSkill1_SelectCurseTechnique"))));
						}
						{
							double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower
									- entity.getPersistentData().getDouble("FastSkill1_SelectCurseTechniqueCost"));
							entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.PlayerCursePower = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique infinite 1 true");
							}
						}
						entity.getPersistentData().putBoolean("PRESS_Z", true);
						ticks = Math.round(entity.getPersistentData().getDouble("FastSkill1_SelectCurseTechniqueCost") / 35);
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("execute as @s run effect give @s jujutsucraft:cooldown_time " + Math.round(ticks) + " 1 true"));
							}
						}
					}
				}
			}
		}
	}
}
