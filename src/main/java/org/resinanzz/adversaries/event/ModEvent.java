package org.resinanzz.adversaries.event;


import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.resinanzz.adversaries.Adversaries;
import org.resinanzz.adversaries.component.EnergyHandler;
import org.resinanzz.adversaries.component.RegenEvent;
import org.resinanzz.adversaries.entity.PrisonerEntity;
import org.resinanzz.adversaries.entity.projectileEntity.PunchProjectileEntity;
import org.resinanzz.adversaries.init.AdversariesModAttachments;
import org.resinanzz.adversaries.init.AdversariesModItems;

@EventBusSubscriber(modid = Adversaries.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvent {
    @SubscribeEvent
    public static void playerTick(PlayerTickEvent.Pre event){
        if(event.getEntity().level().isClientSide)return;
        Player player = event.getEntity();

    }
//    @SubscribeEvent
//    public static void entityTick(EntityTickEvent.Pre event){
//        if(event.getEntity().level().isClientSide)return;
//        Entity entity = event.getEntity();
//        if(entity instanceof OverworldChampionEntity<?>){
//            System.out.println("s");
//        }
//
//    }
    @SubscribeEvent
    public static void onEntityEat(LivingEntityUseItemEvent.Finish event){
        if(event.getEntity().level().isClientSide) return;
        RegenEvent.Food(event);
    }
    @SubscribeEvent
    public static void onLivingHurt(LivingDamageEvent.Pre event){
        LivingEntity source = event.getEntity().getLastAttacker();
        if(source instanceof PrisonerEntity){
            source.swing(InteractionHand.MAIN_HAND);
        }
    }

    @SubscribeEvent
    public static void ItemRightClicked(PlayerInteractEvent.RightClickItem event){
        Player player = event.getEntity();
        Level level = event.getLevel();
        if(level.isClientSide){return;}

        if(event.getItemStack().is(AdversariesModItems.REACTIVE_STRIP)){
            player.displayClientMessage(Component.literal("Dark Blood: " + player.getData(AdversariesModAttachments.BLOOD_ENERGY).toString() + "/" + player.getData(AdversariesModAttachments.BLOOD_ENERGY_LIMIT)), false);
        }else if (event.getItemStack().is(AdversariesModItems.BRAIN_SCANNER)){
            player.displayClientMessage(Component.literal( "Nebula: " + player.getData(AdversariesModAttachments.NEBULOUS_ENERGY).toString() + "/" + player.getData(AdversariesModAttachments.BLOOD_ENERGY_LIMIT)), false);
        }else if (event.getItemStack().is(AdversariesModItems.GRADUATED_DREAM_CATCHER)){
            player.displayClientMessage(Component.literal("Faye: " + player.getData(AdversariesModAttachments.FAYE_ENERGY).toString() + "/" + player.getData(AdversariesModAttachments.BLOOD_ENERGY_LIMIT)), false);
        }else if (event.getItemStack().is(AdversariesModItems.ELECTROCHROMALOG)){
            player.displayClientMessage(Component.literal("Phosphenes: " + player.getData(AdversariesModAttachments.PHOSPHENE_ENERGY).toString() + "/" + player.getData(AdversariesModAttachments.BLOOD_ENERGY_LIMIT)), false);
        }
    }

    @SubscribeEvent
    public static void  entityJoins(EntityJoinLevelEvent event) {

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
            }
        }
    }
    @SubscribeEvent
    public static void entityDeathEvent(LivingDeathEvent event){
        LivingEntity entity = event.getEntity();

        if(entity.level().isClientSide || (event.getEntity() instanceof Player) || !(event.getSource().getEntity() instanceof Player))return;

        Player source = (Player)event.getSource().getEntity();
        if(source.getInventory().contains(AdversariesModItems.TOTEM_OF_FLESH.toStack())){
            if(entity instanceof LivingEntity){
                //TODO add cool audio
                EnergyHandler.addEnergy(source, 5, AdversariesModAttachments.BLOOD_ENERGY);
            } else if (entity instanceof Monster) {
                EnergyHandler.addEnergy(source, 2, AdversariesModAttachments.NEBULOUS_ENERGY);
            }
        }
    }
}

