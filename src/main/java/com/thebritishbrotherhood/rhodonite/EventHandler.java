 package com.thebritishbrotherhood.rhodonite;

 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.inventory.EntityEquipmentSlot;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;

 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
 import net.minecraftforge.fml.common.gameevent.TickEvent;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;

 import static sun.audio.AudioPlayer.player;


 public class EventHandler
 {
   @SubscribeEvent
   public void tick(TickEvent.PlayerTickEvent e)
   {
     if (!e.player.getEntityData().hasKey("wearingArmor")) {
         e.player.getEntityData().setBoolean("wearingArmor", false);
         e.player.getEntityData().setBoolean("canFly", e.player.capabilities.allowFlying);
     }

     ItemStack stack = e.player.inventory.armorItemInSlot(EntityEquipmentSlot.CHEST.getIndex());
     if ((stack != null) && ((stack.getItem() instanceof com.thebritishbrotherhood.rhodonite.armor.rhodonite.rhodonitechest))) {
       e.player.getEntityData().setBoolean("wearingArmor", true);
       e.player.capabilities.allowFlying = true;
     } else {
       e.player.getEntityData().setBoolean("wearingArmor", false);
       e.player.capabilities.allowFlying = e.player.getEntityData().getBoolean("canFly");
     }
   }
 }
