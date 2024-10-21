package net.mcreator.betterjjc.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

public class ToggleCombatModeKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 3) {
			if (entity.getPersistentData().getBoolean("CombatMode") == true) {
				entity.getPersistentData().putBoolean("CombatMode", false);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7lCombat Mode Disabled"), false);
			} else if (entity.getPersistentData().getBoolean("CombatMode") == false) {
				entity.getPersistentData().putBoolean("CombatMode", true);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7lCombat Mode Enabled"), false);
			}
		}
	}
}
