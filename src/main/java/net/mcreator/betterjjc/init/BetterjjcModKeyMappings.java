
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.betterjjc.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.betterjjc.network.ToggleCombatModeMessage;
import net.mcreator.betterjjc.network.SpecialMoveMessage;
import net.mcreator.betterjjc.network.SaveFastSkillMessage;
import net.mcreator.betterjjc.network.SaveFastSkill4Message;
import net.mcreator.betterjjc.network.SaveFastSkill3Message;
import net.mcreator.betterjjc.network.SaveFastSkill2Message;
import net.mcreator.betterjjc.network.SaveFastSkill1Message;
import net.mcreator.betterjjc.network.PassiveSkillMessage;
import net.mcreator.betterjjc.network.FastKnockbackAttackMessage;
import net.mcreator.betterjjc.network.FastDEHotkeyMessage;
import net.mcreator.betterjjc.network.FastBarrageAttackMessage;
import net.mcreator.betterjjc.network.FastAttackMessage;
import net.mcreator.betterjjc.network.DebugMessage;
import net.mcreator.betterjjc.BetterjjcMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class BetterjjcModKeyMappings {
	public static final KeyMapping FAST_DE_HOTKEY = new KeyMapping("key.betterjjc.fast_de_hotkey", GLFW.GLFW_KEY_V, "key.categories.betterjjc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				BetterjjcMod.PACKET_HANDLER.sendToServer(new FastDEHotkeyMessage(0, 0));
				FastDEHotkeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping PASSIVE_SKILL = new KeyMapping("key.betterjjc.passive_skill", GLFW.GLFW_KEY_C, "key.categories.betterjjc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				BetterjjcMod.PACKET_HANDLER.sendToServer(new PassiveSkillMessage(0, 0));
				PassiveSkillMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FAST_ATTACK = new KeyMapping("key.betterjjc.fast_attack", GLFW.GLFW_KEY_H, "key.categories.betterjjc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				BetterjjcMod.PACKET_HANDLER.sendToServer(new FastAttackMessage(0, 0));
				FastAttackMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FAST_KNOCKBACK_ATTACK = new KeyMapping("key.betterjjc.fast_knockback_attack", GLFW.GLFW_KEY_K, "key.categories.betterjjc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				BetterjjcMod.PACKET_HANDLER.sendToServer(new FastKnockbackAttackMessage(0, 0));
				FastKnockbackAttackMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FAST_BARRAGE_ATTACK = new KeyMapping("key.betterjjc.fast_barrage_attack", GLFW.GLFW_KEY_L, "key.categories.betterjjc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				BetterjjcMod.PACKET_HANDLER.sendToServer(new FastBarrageAttackMessage(0, 0));
				FastBarrageAttackMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SAVE_FAST_SKILL = new KeyMapping("key.betterjjc.save_fast_skill", GLFW.GLFW_KEY_I, "key.categories.betterjjc_fastskills") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				BetterjjcMod.PACKET_HANDLER.sendToServer(new SaveFastSkillMessage(0, 0));
				SaveFastSkillMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				SAVE_FAST_SKILL_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - SAVE_FAST_SKILL_LASTPRESS);
				BetterjjcMod.PACKET_HANDLER.sendToServer(new SaveFastSkillMessage(1, dt));
				SaveFastSkillMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping TOGGLE_COMBAT_MODE = new KeyMapping("key.betterjjc.toggle_combat_mode", GLFW.GLFW_KEY_O, "key.categories.betterjjc_fastskills") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				BetterjjcMod.PACKET_HANDLER.sendToServer(new ToggleCombatModeMessage(0, 0));
				ToggleCombatModeMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SAVE_FAST_SKILL_1 = new KeyMapping("key.betterjjc.save_fast_skill_1", GLFW.GLFW_KEY_1, "key.categories.betterjjc_fastskills") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				BetterjjcMod.PACKET_HANDLER.sendToServer(new SaveFastSkill1Message(0, 0));
				SaveFastSkill1Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SAVE_FAST_SKILL_2 = new KeyMapping("key.betterjjc.save_fast_skill_2", GLFW.GLFW_KEY_2, "key.categories.betterjjc_fastskills") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				BetterjjcMod.PACKET_HANDLER.sendToServer(new SaveFastSkill2Message(0, 0));
				SaveFastSkill2Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SAVE_FAST_SKILL_3 = new KeyMapping("key.betterjjc.save_fast_skill_3", GLFW.GLFW_KEY_3, "key.categories.betterjjc_fastskills") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				BetterjjcMod.PACKET_HANDLER.sendToServer(new SaveFastSkill3Message(0, 0));
				SaveFastSkill3Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SAVE_FAST_SKILL_4 = new KeyMapping("key.betterjjc.save_fast_skill_4", GLFW.GLFW_KEY_4, "key.categories.betterjjc_fastskills") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				BetterjjcMod.PACKET_HANDLER.sendToServer(new SaveFastSkill4Message(0, 0));
				SaveFastSkill4Message.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SPECIAL_MOVE = new KeyMapping("key.betterjjc.special_move", GLFW.GLFW_KEY_T, "key.categories.betterjjc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				BetterjjcMod.PACKET_HANDLER.sendToServer(new SpecialMoveMessage(0, 0));
				SpecialMoveMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping DEBUG = new KeyMapping("key.betterjjc.debug", GLFW.GLFW_KEY_F4, "key.categories.betterjjc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				BetterjjcMod.PACKET_HANDLER.sendToServer(new DebugMessage(0, 0));
				DebugMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	private static long SAVE_FAST_SKILL_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(FAST_DE_HOTKEY);
		event.register(PASSIVE_SKILL);
		event.register(FAST_ATTACK);
		event.register(FAST_KNOCKBACK_ATTACK);
		event.register(FAST_BARRAGE_ATTACK);
		event.register(SAVE_FAST_SKILL);
		event.register(TOGGLE_COMBAT_MODE);
		event.register(SAVE_FAST_SKILL_1);
		event.register(SAVE_FAST_SKILL_2);
		event.register(SAVE_FAST_SKILL_3);
		event.register(SAVE_FAST_SKILL_4);
		event.register(SPECIAL_MOVE);
		event.register(DEBUG);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				FAST_DE_HOTKEY.consumeClick();
				PASSIVE_SKILL.consumeClick();
				FAST_ATTACK.consumeClick();
				FAST_KNOCKBACK_ATTACK.consumeClick();
				FAST_BARRAGE_ATTACK.consumeClick();
				SAVE_FAST_SKILL.consumeClick();
				TOGGLE_COMBAT_MODE.consumeClick();
				SAVE_FAST_SKILL_1.consumeClick();
				SAVE_FAST_SKILL_2.consumeClick();
				SAVE_FAST_SKILL_3.consumeClick();
				SAVE_FAST_SKILL_4.consumeClick();
				SPECIAL_MOVE.consumeClick();
				DEBUG.consumeClick();
			}
		}
	}
}
