package net.mcreator.betterjjc.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.betterjjc.BetterjjcMod;

public class MegumiSpecialMoveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BetterjjcMod.queueServerWork(1, () -> {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.basalt_deltas.loop")), SoundSource.NEUTRAL, 0, 0);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.basalt_deltas.loop")), SoundSource.NEUTRAL, 0, 0, false);
				}
			}
		});
		if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 8) {
			SacrificeShikigamiesForAgitoProcedure.execute(world, x, y, z, entity);
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 5
				|| (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 6) {
			SacrificeShikigamiesForTotalityProcedure.execute(world, x, y, z, entity);
		}
	}
}
