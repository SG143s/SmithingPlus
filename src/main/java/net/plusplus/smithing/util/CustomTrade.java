package net.plusplus.smithing.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.plusplus.smithing.item.ModItems;

public class CustomTrade {
    public static void registerTrade() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(ModItems.AXE_TEMPLATE),
                            7, 3, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(ModItems.SHOVEL_TEMPLATE),
                            7, 3, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(ModItems.PICK_TEMPLATE),
                            7, 3, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(ModItems.HOE_TEMPLATE),
                            7, 3, 0.05f)));
                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(ModItems.AXE_TEMPLATE),
                            7, 3, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(ModItems.SWORD_TEMPLATE),
                            7, 3, 0.05f)));
                });
    }
}
