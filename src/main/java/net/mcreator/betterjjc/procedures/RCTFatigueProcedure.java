package net.mcreator.betterjjc.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.betterjjc.init.BetterjjcModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RCTFatigueProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.OVERWORLD);
			if (world != null) {
				if (world.getLevelData().getGameRules().getBoolean(BetterjjcModGameRules.BETTER_JJCRCT_FATIGUE) == false) {
					if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.FATIGUE.get())) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(JujutsucraftModMobEffects.FATIGUE.get());
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.basalt_deltas.loop")), SoundSource.NEUTRAL, 0, 0);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.basalt_deltas.loop")), SoundSource.NEUTRAL, 0, 0, false);
					}
				}
			}
			world = _worldorig;
		}
	}
}
