package com.balugaq.netex.api.helpers;

import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;

public final class ItemStackHelper {
    private static final String NULL_ITEMSTACK_MESSAGE = "物品不能为空";

    @Nonnull
    public static String getDisplayName(@Nonnull ItemStack item) {
        Preconditions.checkArgument(item != null, NULL_ITEMSTACK_MESSAGE);
        return item.hasItemMeta() && item.getItemMeta().hasDisplayName() ? item.getItemMeta().getDisplayName() : getName(item);
    }

    @Nonnull
    public static String getName(@Nonnull ItemStack item) {
        Preconditions.checkArgument(item != null, NULL_ITEMSTACK_MESSAGE);
        if (MinecraftTag.POTION_WITH_TIPPED_ARROW.isTagged(item)) {
            String potion = ((PotionMeta)item.getItemMeta()).getBasePotionData().getType().toString().toLowerCase();
            String material = MaterialHelper.getKey(item.getType());
            return LanguageHelper.getLangOrKey(material + ".effect." + potion);
        } else {
            return item.getType() != Material.PLAYER_HEAD && item.getType() != Material.PLAYER_WALL_HEAD ? MaterialHelper.getName(item.getType()) : getPlayerSkullName(item);
        }
    }

    @Nonnull
    private static String getPlayerSkullName(@Nonnull ItemStack skull) {
        Preconditions.checkArgument(skull != null, "物品不能为空");
        SkullMeta meta = (SkullMeta)skull.getItemMeta();
        return meta != null && meta.hasOwner() ? String.format(LanguageHelper.getLangOrKey("block.minecraft.player_head.named"), meta.getOwningPlayer().getName()) : LanguageHelper.getLangOrKey("block.minecraft.player_head");
    }

    private ItemStackHelper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
