package org.resinanzz.adversaries.event;


import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.resinanzz.adversaries.Adversaries;
import org.resinanzz.adversaries.component.AdversariesModAttachments;
import org.resinanzz.adversaries.component.events.ConsumeRegenItemEvent;
import org.resinanzz.adversaries.entity.PunchProjectileEntity;
import org.resinanzz.adversaries.init.AdversariesModItems;
import org.resinanzz.adversaries.component.EnergyHandler;

@EventBusSubscriber(modid = Adversaries.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvent {
    @SubscribeEvent
    public static void tick(PlayerTickEvent.Pre event){
        if(event.getEntity().level().isClientSide)return;

        Player player = event.getEntity();
        /*
        if(player.getMainHandItem().is(AdversariesModItems.GAUNTLET_OF_RAGE)){
            EnergyHandler.addEnergy(player, 1, AdversariesModAttachments.BLOOD_ENERGY, AdversariesModAttachments.BLOOD_ENERGY_LIMIT);
        }

         */
    }
    @SubscribeEvent
    public static void onEntityEat(LivingEntityUseItemEvent.Finish event){
        if(event.getEntity().level().isClientSide) return;
        ConsumeRegenItemEvent.Food(event);
    }
    @SubscribeEvent
    static void gamemodeEvent(PlayerEvent.PlayerChangeGameModeEvent event){
        if(event.getEntity().level().isClientSide){return;}
        Player player = event.getEntity();
        player.getPersistentData().putBoolean("isPlayerCreative", player.isCreative());
    }

    @SubscribeEvent
    public static void ItemRightClicked(PlayerInteractEvent.RightClickItem event){
        Player player = event.getEntity();
        Level level = event.getLevel();

        if(level.isClientSide){return;}

        if(event.getItemStack().is(AdversariesModItems.REACTIVE_STRIP)){
            player.displayClientMessage(Component.literal(player.getData(AdversariesModAttachments.BLOOD_ENERGY).toString()), false);
        }

    }


    @SubscribeEvent
    public static void entityJoins(EntityJoinLevelEvent event) {

        if (event.getLevel().isClientSide) {
            Entity entity = event.getEntity();
            if (entity instanceof PunchProjectileEntity) {
                RandomSource random = entity.getRandom();
                double randomY = -0.2d + random.nextDouble();
                double randomX = -0.6d + random.nextDouble();

                entity.getPersistentData().putDouble("randomY", randomY);
                entity.getPersistentData().putDouble("randomX", randomX);

            }
            if (entity instanceof Player _player) {
                EnergyHandler.setEnergy(_player, 0, AdversariesModAttachments.BLOOD_ENERGY, AdversariesModAttachments.BLOOD_ENERGY_LIMIT);
                _player.getPersistentData().putBoolean("isEnergyInfinite", false);
            }
        }
    }
}

