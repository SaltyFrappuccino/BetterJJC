package net.mcreator.betterjjc.procedures;

import net.minecraft.world.entity.Entity;

public class SaveFastSkillKeyReleasedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("SaveFastSkill_PRESSED", false);
	}
}
