package com.ytdd9527.networksexpansion.implementation.machines.networks.advanced;

import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.github.sefiraat.networks.NetworkStorage;
import io.github.sefiraat.networks.network.NodeDefinition;
import io.github.sefiraat.networks.network.NodeType;
import io.github.sefiraat.networks.slimefun.network.NetworkDirectional;
import io.github.sefiraat.networks.utils.StackUtils;
import io.github.sefiraat.networks.utils.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BetterGrabber extends NetworkDirectional {
    public static final CustomItemStack TEMPLATE_BACKGROUND_STACK = new CustomItemStack(
            Material.BLUE_STAINED_GLASS_PANE, Theme.PASSIVE + "指定需要抓取的物品"
    );
    private static final int NORTH_SLOT = 11;
    private static final int SOUTH_SLOT = 29;
    private static final int EAST_SLOT = 21;
    private static final int WEST_SLOT = 19;
    private static final int UP_SLOT = 14;
    private static final int DOWN_SLOT = 32;

    private static final int[] BACKGROUND_SLOTS = new int[]{
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 15, 17, 18, 20, 22, 23, 27, 28, 30, 31, 33, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44
    };
    private static final int[] TEMPLATE_BACKGROUND = new int[]{16};
    private static final int[] TEMPLATE_SLOTS = new int[]{24, 25, 26, 34};

    public BetterGrabber(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe, NodeType.GRABBER);
        for (int slot : getItemSlots()) {
            this.getSlotsToDrop().add(slot);
        }
    }

    @Override
    protected void onTick(@Nullable BlockMenu blockMenu, @Nonnull Block block) {
        super.onTick(blockMenu, block);
        if (blockMenu != null) {
            tryGrabItem(blockMenu);
        }
    }

    private void tryGrabItem(@Nonnull BlockMenu blockMenu) {
        final NodeDefinition definition = NetworkStorage.getNode(blockMenu.getLocation());

        if (definition == null || definition.getNode() == null) {
            return;
        }

        final BlockFace direction = this.getCurrentDirection(blockMenu);
        final BlockMenu targetMenu = StorageCacheUtils.getMenu(blockMenu.getBlock().getRelative(direction).getLocation());

        if (targetMenu == null) {
            return;
        }

        int[] slots = targetMenu.getPreset().getSlotsAccessedByItemTransport(targetMenu, ItemTransportFlow.WITHDRAW, null);

        for (int templateSlot : getItemSlots()) {
            final ItemStack template = blockMenu.getItemInSlot(templateSlot);

            if (template != null && template.getType() != Material.AIR) {
                for (int slot : slots) {
                    final ItemStack itemStack = targetMenu.getItemInSlot(slot);
                    if (itemStack != null && itemStack.getType() != Material.AIR) {
                        if (StackUtils.itemsMatch(template, itemStack)) {
                            int before = itemStack.getAmount();
                            definition.getNode().getRoot().addItemStack(itemStack);
                            if (definition.getNode().getRoot().isDisplayParticles() && itemStack.getAmount() < before) {
                                showParticle(blockMenu.getLocation(), direction);
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public int getNorthSlot() {
        return NORTH_SLOT;
    }

    @Override
    public int getSouthSlot() {
        return SOUTH_SLOT;
    }

    @Override
    public int getEastSlot() {
        return EAST_SLOT;
    }

    @Override
    public int getWestSlot() {
        return WEST_SLOT;
    }

    @Override
    public int getUpSlot() {
        return UP_SLOT;
    }

    @Override
    public int getDownSlot() {
        return DOWN_SLOT;
    }

    @Override
    protected Particle.DustOptions getDustOptions() {
        return new Particle.DustOptions(Color.FUCHSIA, 1);
    }

    @Nullable
    @Override
    protected CustomItemStack getOtherBackgroundStack() {
        return TEMPLATE_BACKGROUND_STACK;
    }

    @Override
    @Nonnull
    public int[] getBackgroundSlots() {
        return BACKGROUND_SLOTS;
    }

    @Nonnull
    @Override
    public int[] getOtherBackgroundSlots() {
        return TEMPLATE_BACKGROUND;
    }

    @Nonnull
    @Override
    public int[] getItemSlots() {
        return TEMPLATE_SLOTS;
    }
}
