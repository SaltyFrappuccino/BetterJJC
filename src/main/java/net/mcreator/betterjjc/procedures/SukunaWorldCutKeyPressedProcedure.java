package net.mcreator.betterjjc.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.betterjjc.init.BetterjjcModGameRules;

import java.util.List;
import java.util.Comparator;

public class SukunaWorldCutKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("cnt6") == 5 && entity.getPersistentData().getDouble("skill") == 105) {
			if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower >= 3000) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if ((entityiterator instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects.NEUTRALIZATION.get())) == false) {
							{
								Entity _ent = entityiterator;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:neutralization 3 255 true");
								}
							}
						}
					}
				}
				{
					double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 1000);
					entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerCursePower = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				entity.getPersistentData().putDouble("cnt6", (world.getLevelData().getGameRules().getInt(BetterjjcModGameRules.WORLD_CUT_POWER)));
			}
		}
	}
}
