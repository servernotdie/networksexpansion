package com.ytdd9527.networksexpansion.implementation;


import com.balugaq.netex.api.enums.Skins;
import com.balugaq.netex.api.enums.StorageUnitType;
import com.ytdd9527.networksexpansion.utils.TextUtil;
import com.ytdd9527.networksexpansion.utils.itemstacks.ItemStackUtil;
import io.github.sefiraat.networks.slimefun.network.NetworkQuantumStorage;
import io.github.sefiraat.networks.utils.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.MessageFormat;


/**
 * @author ytdd9527
 * @noinspection SpellCheckingInspection
 * @since 2.0
 */
public class ExpansionItemStacks {
    public static final SlimefunItemStack NETWORKS_EXPANSION_SURVIVAL_GUIDE = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_SURVIVAL_GUIDE",
            new ItemStack(Material.ENCHANTED_BOOK),
            Theme.GUIDE,
            "网络拓展指南 (生存模式)",
            ""
    );
    public static final SlimefunItemStack NETWORKS_EXPANSION_CHEAT_GUIDE = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_CREATIVE_GUIDE",
            new ItemStack(Material.ENCHANTED_BOOK),
            Theme.GUIDE,
            "网络拓展指南 (作弊模式)",
            ""
    );
    // Workbench
    public static final SlimefunItemStack NETWORKS_EXPANSION_WORKBENCH = Theme.Random(
            "NTW_EXPANSION_WORKBENCH",
            new ItemStack(Material.BAMBOO_BLOCK),
            Theme.MACHINE,
            "网络拓展工作台",
            "可以合成网络拓展的各种材料和机器"
    );
    public static final SlimefunItemStack NETWORKS_EXPANSION_WORKBENCH_6X6 = Theme.Random(
            "NTW_EXPANSION_WORKBENCH_6X6",
            new ItemStack(Material.LAPIS_BLOCK),
            Theme.MACHINE,
            "网络拓展工作台 (6x6)",
            "不可以合成网络拓展的各种材料和机器"
    );
    // Tools
    public static final SlimefunItemStack WORLDEDIT_AXE = Theme.Random(
            "NTW_EXPANSION_WORLD_EDIT_AXE",
            new ItemStack(Material.DIAMOND_AXE),
            Theme.TOOL,
            "网络粘液创世神",
            "仅管理员可用",
            "右键选择第一个位置",
            "Shift + 右键选择第二个位置"
    );
    public static final SlimefunItemStack INFO_TOOL = Theme.Random(
            "NTW_EXPANSION_INFO_TOOL",
            new ItemStack(Material.FEATHER),
            Theme.TOOL,
            "网络信息工具",
            "仅管理员可用",
            "右键查看网络中物品的详细信息"
    );
    // Advanced Networks Machines
    public static final SlimefunItemStack ADVANCED_IMPORT = Theme.Random(
            "NTW_EXPANSION_ADVANCED_IMPORT",
            Enchanted(Material.RED_STAINED_GLASS),
            Theme.MACHINE,
            "高级网络入口",
            "高级网络入口会将其中的物品送入网络中",
            "每个SF tick可传输最多54组物品",
            "可接收来自货运网络的物品"
    );
    public static final SlimefunItemStack ADVANCED_EXPORT = Theme.Random(
            "NTW_EXPANSION_ADVANCED_EXPORT",
            Enchanted(Material.BLUE_STAINED_GLASS),
            Theme.MACHINE,
            "高级网络出口",
            "高级网络出口可以设置成",
            "持续将指定数量的物品送出网络",
            "可以使用货运网络从中提取物品"
    );
    public static final SlimefunItemStack ADVANCED_PURGER = Theme.Random(
            "NTW_EXPANSION_ADVANCED_PURGER",
            Enchanted(Material.YELLOW_STAINED_GLASS),
            Theme.MACHINE,
            "高级网络清除器",
            "高级网络清除器会从网络中",
            "不断地移除指定物品",
            "清除的物品会立即消失，谨慎使用!"
    );
    public static final SlimefunItemStack ADVANCED_GREEDY_BLOCK = Theme.Random(
            "NTW_EXPANSION_ADVANCED_GREEDY_BLOCK",
            Enchanted(Material.GRAY_STAINED_GLASS),
            Theme.MACHINE,
            "高级网络阻断器",
            "高级网络阻断器可以设置一个物品,",
            "然后会从网络各处输入中",
            "收集指定的物品,最多为9组.",
            "收集满后,会阻断该物品在网络中的传输,",
            "任何其他网络方块都不会收到该物品."
    );
    public static final SlimefunItemStack NETWORK_CAPACITOR_5 = Theme.Random(
            "NTW_EXPANSION_CAPACITOR_5",
            new ItemStack(Material.CYAN_GLAZED_TERRACOTTA),
            Theme.MACHINE,
            "网络电容 (5)",
            "网络电容可以接收来自",
            "能源网络的电力并存储起来",
            "以供其他网络设备使用",
            "",
            MessageFormat.format("{0}容量: {1}{2}", Theme.CLICK_INFO, Theme.PASSIVE, 100000000)
    );
    public static final SlimefunItemStack NETWORK_CAPACITOR_6 = Theme.Random(
            "NTW_EXPANSION_CAPACITOR_6",
            new ItemStack(Material.BLUE_GLAZED_TERRACOTTA),
            Theme.MACHINE,
            "网络电容 (6)",
            "网络电容可以接收来自",
            "能源网络的电力并存储起来",
            "以供其他网络设备使用",
            "",
            MessageFormat.format("{0}容量: {1}{2}", Theme.CLICK_INFO, Theme.PASSIVE, Integer.MAX_VALUE)
    );
    public static final SlimefunItemStack NETWORK_INPUT_ONLY_MONITOR = Theme.themedSlimefunItemStack(
            "NTW_INPUT_ONLY_MONITOR",
            new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS),
            Theme.MACHINE,
            "网络监视器（仅输入）",
            "网络监视器可以与附近的方块交互",
            "让指定方块可以接入网络",
            "指定的方块只能被输入",
            "",
            "目前支持:",
            "无尽科技 - 存储单元",
            "蓬松科技 - 蓬松桶",
            "网络 - 量子存储",
            TextUtil.colorPseudorandomString("网络拓展 - 网络抽屉")
    );
    public static final SlimefunItemStack NETWORK_OUTPUT_ONLY_MONITOR = Theme.themedSlimefunItemStack(
            "NTW_OUTPUT_ONLY_MONITOR",
            new ItemStack(Material.GRAY_STAINED_GLASS),
            Theme.MACHINE,
            "网络监视器（仅输出）",
            "网络监视器可以与附近的方块交互",
            "让指定方块可以接入网络",
            "指定的方块只能被输出",
            "",
            "目前支持:",
            "无尽科技 - 存储单元",
            "蓬松科技 - 蓬松桶",
            "网络 - 量子存储",
            TextUtil.colorPseudorandomString("网络拓展 - 网络抽屉")
    );
    // Transfers
    public static final SlimefunItemStack LINE_TRANSFER_PUSHER = Theme.Random(
            "NTW_EXPANSION_LINE_TRANSFER_PUSHER",
            new ItemStack(Material.OBSERVER),
            Theme.MACHINE,
            "链式传输器 [推送]",
            "&c仅支持粘液容器",
            "&6运输距离: 32 格",
            "&7默认运输模式: &6首位阻断",
            "&c不可调整运输模式",
            "&7默认运输数量: &664",
            "&c不可调整运输数量",
            "&e与乱序技艺的链式传输器不同的是，此机器&c只有连续推送的功能",
            "&c而不是连续转移物品！",
            "&7运输模式解释: ",
            "&6首位阻断&7: &e仅推送至第一个可以被推送物品的槽位"
    );
    public static final SlimefunItemStack LINE_TRANSFER_GRABBER = Theme.Random(
            "NTW_EXPANSION_LINE_TRANSFER_GRABBER",
            new ItemStack(Material.HAY_BLOCK),
            Theme.MACHINE,
            "链式传输器 [抓取]",
            "&c仅支持粘液容器",
            "&6运输距离: 32 格",
            "&7默认运输模式: &6首位阻断",
            "&c不可调整运输模式",
            "&7默认运输数量: &664",
            "&c不可调整运输数量",
            "&e与乱序技艺的链式传输器不同的是，此机器&c只有连续抓取的功能",
            "&c而不是连续转移物品！",
            "&7运输模式解释: ",
            "&6首位阻断&7: &e仅抓取第一个有物品的槽位"
    );
    public static final SlimefunItemStack LINE_TRANSFER = Theme.Random(
            "NTW_EXPANSION_LINE_TRANSFER",
            new ItemStack(Material.PISTON),
            Theme.MACHINE,
            "链式传输器",
            "&c仅支持粘液容器",
            "&6运输距离: 32 格",
            "&7默认运输模式: &6首位阻断",
            "&c不可调整运输模式",
            "&7默认运输数量: &664",
            "&c不可调整运输数量",
            "&e与乱序技艺的链式传输器不同的是，此机器&c只有连续推送和抓取的功能",
            "&c而不是连续转移物品！",
            "&7运输模式解释: ",
            "&6首位阻断&7: &e仅推送至第一个可以被推送物品的槽位 / 仅抓取第一个有物品的槽位"
    );
    public static final SlimefunItemStack LINE_TRANSFER_PLUS_PUSHER = Theme.Random(
            "NTW_EXPANSION_LINE_TRANSFER_PLUS_PUSHER",
            new ItemStack(Material.LIME_GLAZED_TERRACOTTA),
            Theme.MACHINE,
            "链式传输器Plus [推送]",
            "&c仅支持粘液容器",
            "&6运输距离: 64 格",
            "&7默认运输模式: &6首位阻断",
            "&c不可调整运输模式",
            "&7默认运输数量: &664",
            "&c不可调整运输数量",
            "&e与乱序技艺的链式传输器不同的是，此机器&c只有连续推送的功能",
            "&c而不是连续转移物品！",
            "&7运输模式解释: ",
            "&6首位阻断&7: &e仅推送至第一个可以被推送物品的槽位"
    );
    public static final SlimefunItemStack LINE_TRANSFER_PLUS_GRABBER = Theme.Random(
            "NTW_EXPANSION_LINE_TRANSFER_PLUS_GRABBER",
            new ItemStack(Material.WAXED_COPPER_BLOCK),
            Theme.MACHINE,
            "链式传输器Plus [抓取]",
            "&c仅支持粘液容器",
            "&6运输距离: 64 格",
            "&7默认运输模式: &6首位阻断",
            "&c不可调整运输模式",
            "&7默认运输数量: &664",
            "&c不可调整运输数量",
            "&e与乱序技艺的链式传输器不同的是，此机器&c只有连续抓取的功能",
            "&c而不是连续转移物品！",
            "&7运输模式解释: ",
            "&6首位阻断&7: &e仅抓取第一个有物品的槽位"
    );
    public static final SlimefunItemStack LINE_TRANSFER_PLUS = Theme.Random(
            "NTW_EXPANSION_LINE_TRANSFER_PLUS",
            new ItemStack(Material.STICKY_PISTON),
            Theme.MACHINE,
            "链式传输器Plus",
            "&c仅支持粘液容器",
            "&6运输距离: 64 格",
            "&7默认运输模式: &6首位阻断",
            "&c不可调整运输模式",
            "&7默认运输数量: &664",
            "&c不可调整运输数量",
            "&e与乱序技艺的链式传输器不同的是，此机器&c只有连续推送和抓取的功能",
            "&c而不是连续转移物品！",
            "&7运输模式解释: ",
            "&6首位阻断&7: &e仅推送至第一个可以被推送物品的槽位 / 仅抓取第一个有物品的槽位"
    );
    public static final SlimefunItemStack LINE_TRANSFER_VANILLA_PUSHER = Theme.Random(
            "NTW_EXPANSION_LINE_TRANSFER_VANILLA_PUSHER",
            new ItemStack(Material.OBSERVER),
            Theme.MACHINE,
            "链式原版传输器 [推送]",
            "&c仅支持原版容器",
            "&6运输距离: 32 格",
            "&7默认运输模式: &6首位阻断",
            "&c不可调整运输模式",
            "&7默认运输数量: &664",
            "&c不可调整运输数量",
            "&e与乱序技艺的链式传输器不同的是，此机器&c只有连续推送的功能",
            "&c而不是连续转移物品！",
            "&7运输模式解释: ",
            "&6首位阻断&7: &e仅推送至第一个可以被推送物品的槽位"
    );
    public static final SlimefunItemStack LINE_TRANSFER_VANILLA_GRABBER = Theme.Random(
            "NTW_EXPANSION_LINE_TRANSFER_VANILLA_GRABBER",
            new ItemStack(Material.HAY_BLOCK),
            Theme.MACHINE,
            "链式原版传输器 [抓取]",
            "&c仅支持原版容器",
            "&6运输距离: 32 格",
            "&7默认运输模式: &6首位阻断",
            "&c不可调整运输模式",
            "&7默认运输数量: &664",
            "&c不可调整运输数量",
            "&e与乱序技艺的链式传输器不同的是，此机器&c只有连续抓取的功能",
            "&c而不是连续转移物品！",
            "&7运输模式解释: ",
            "&6首位阻断&7: &e仅抓取第一个有物品的槽位"
    );
    public static final SlimefunItemStack ADVANCED_LINE_TRANSFER_PUSHER = Theme.Random(
            "NTW_EXPANSION_ADVANCED_LINE_TRANSFER_PUSHER",
            Enchanted(Material.OBSERVER),
            Theme.MACHINE,
            "高级链式传输 [推送]",
            "&c仅支持粘液容器",
            "&6运输距离: 32 格",
            "&7默认运输模式: &6首位阻断",
            "&a可调整运输模式",
            "&7默认运输数量: &63456",
            "&a可调整运输数量",
            "&e与乱序技艺的链式传输器不同的是，此机器&c只有连续推送的功能",
            "&c而不是连续转移物品！",
            "&7运输模式解释: ",
            "&6无限制&7: &e可推送至任何槽位",
            "&6仅空&7: &e仅推送至空槽位",
            "&6仅非空&7: &e仅推送至非空槽位",
            "&6仅首位&7: &e仅推送至第一格",
            "&6仅末位&7: &e仅推送至最后一格",
            "&6首位阻断&7: &e仅推送至第一个可以被推送物品的槽位",
            "&6懒惰模式&7: &e当第一格为空时，推送至所有槽位"
    );
    public static final SlimefunItemStack ADVANCED_LINE_TRANSFER_GRABBER = Theme.Random(
            "NTW_EXPANSION_ADVANCED_LINE_TRANSFER_GRABBER",
            Enchanted(Material.HAY_BLOCK),
            Theme.MACHINE,
            "高级链式传输 [抓取]",
            "&c仅支持粘液容器",
            "&6运输距离: 32 格",
            "&7默认运输模式: &6首位阻断",
            "&a可调整运输模式",
            "&7默认运输数量: &63456",
            "&a可调整运输数量",
            "&e与乱序技艺的链式传输器不同的是，此机器&c只有连续抓取的功能",
            "&c而不是连续转移物品！",
            "&7运输模式解释: ",
            "&6无限制&7: &e可抓取任何槽位",
            "&6仅空&7: &e仅抓取空槽位",
            "&6仅非空&7: &e仅抓取非空槽位",
            "&6仅首位&7: &e仅抓取第一格",
            "&6仅末位&7: &e仅抓取最后一格",
            "&6首位阻断&7: &e仅抓取第一个有物品的槽位",
            "&6懒惰模式&7: &e当第一格存在物品时，抓取所有槽位"
    );
    public static final SlimefunItemStack ADVANCED_LINE_TRANSFER = Theme.Random(
            "NTW_EXPANSION_ADVANCED_LINE_TRANSFER",
            Enchanted(Material.PISTON),
            Theme.MACHINE,
            "高级链式传输",
            "&c仅支持粘液容器",
            "&6运输距离: 32 格",
            "&7默认运输模式: &6首位阻断",
            "&a可调整运输模式",
            "&7默认运输数量: &63456",
            "&a可调整运输数量",
            "&e与乱序技艺的链式传输器不同的是，此机器&c只有连续推送和抓取的功能",
            "&c而不是连续转移物品！",
            "&7运输模式解释: ",
            "&6无限制&7: &e可推送至任何槽位 / 可抓取任何槽位",
            "&6仅空&7: &e仅推送至空槽位 / 仅抓取空槽位",
            "&6仅非空&7: &e仅推送至非空槽位 / 仅抓取非空槽位",
            "&6仅首位&7: &e仅推送至第一格 / 仅抓取第一格",
            "&6仅末位&7: &e仅推送至最后一格 / 仅抓取最后一格",
            "&6首位阻断&7: &e仅推送至第一个可以被推送物品的槽位 / 仅抓取第一个有物品的槽位",
            "&6懒惰模式&7: &e当第一格为空时，推送至所有槽位 / 当第一格存在物品时，抓取所有槽位"
    );
    public static final SlimefunItemStack ADVANCED_LINE_TRANSFER_PLUS_PUSHER = Theme.Random(
            "NTW_EXPANSION_ADVANCED_LINE_TRANSFER_PLUS_PUSHER",
            Enchanted(Material.LIME_GLAZED_TERRACOTTA),
            Theme.MACHINE,
            "高级链式传输Plus [推送]",
            "&c仅支持粘液容器",
            "&6运输距离: 64 格",
            "&7默认运输模式: &6首位阻断",
            "&a可调整运输模式",
            "&7默认运输数量: &63456",
            "&a可调整运输数量",
            "&e与乱序技艺的链式传输器不同的是，此机器&c只有连续推送的功能",
            "&c而不是连续转移物品！",
            "&7运输模式解释: ",
            "&6无限制&7: &e可推送至任何槽位",
            "&6仅空&7: &e仅推送至空槽位",
            "&6仅非空&7: &e仅推送至非空槽位",
            "&6仅首位&7: &e仅推送至第一格",
            "&6仅末位&7: &e仅推送至最后一格",
            "&6首位阻断&7: &e仅推送至第一个可以被推送物品的槽位",
            "&6懒惰模式&7: &e当第一格为空时，推送至所有槽位"
    );
    public static final SlimefunItemStack ADVANCED_LINE_TRANSFER_PLUS_GRABBER = Theme.Random(
            "NTW_EXPANSION_ADVANCED_LINE_TRANSFER_PLUS_GRABBER",
            Enchanted(Material.WAXED_COPPER_BLOCK),
            Theme.MACHINE,
            "高级链式传输Plus [抓取]",
            "&c仅支持粘液容器",
            "&6运输距离: 64 格",
            "&7默认运输模式: &6首位阻断",
            "&a可调整运输模式",
            "&7默认运输数量: &63456",
            "&a可调整运输数量",
            "&e与乱序技艺的链式传输器不同的是，此机器&c只有连续抓取的功能",
            "&c而不是连续转移物品！",
            "&7运输模式解释: ",
            "&6无限制&7: &e可抓取任何槽位",
            "&6仅空&7: &e仅抓取空槽位",
            "&6仅非空&7: &e仅抓取非空槽位",
            "&6仅首位&7: &e仅抓取第一格",
            "&6仅末位&7: &e仅抓取最后一格",
            "&6首位阻断&7: &e仅抓取第一个有物品的槽位",
            "&6懒惰模式&7: &e当第一格存在物品时，抓取所有槽位"
    );
    public static final SlimefunItemStack ADVANCED_LINE_TRANSFER_PLUS = Theme.Random(
            "NTW_EXPANSION_ADVANCED_LINE_TRANSFER_PLUS",
            Enchanted(Material.STICKY_PISTON),
            Theme.MACHINE,
            "高级链式传输Plus",
            "&c仅支持粘液容器",
            "&6运输距离: 64 格",
            "&7默认运输模式: &6首位阻断",
            "&a可调整运输模式",
            "&7默认运输数量: &63456",
            "&a可调整运输数量",
            "&e与乱序技艺的链式传输器不同的是，此机器&c只有连续推送和抓取的功能",
            "&c而不是连续转移物品！",
            "&7运输模式解释: ",
            "&6无限制&7: &e可推送至任何槽位 / 可抓取任何槽位",
            "&6仅空&7: &e仅推送至空槽位 / 仅抓取空槽位",
            "&6仅非空&7: &e仅推送至非空槽位 / 仅抓取非空槽位",
            "&6仅首位&7: &e仅推送至第一格 / 仅抓取第一格",
            "&6仅末位&7: &e仅推送至最后一格 / 仅抓取最后一格",
            "&6首位阻断&7: &e仅推送至第一个可以被推送物品的槽位 / 仅抓取第一个有物品的槽位",
            "&6懒惰模式&7: &e当第一格为空时，推送至所有槽位 / 当第一格存在物品时，抓取所有槽位"
    );
    public static final SlimefunItemStack TRANSFER_PUSHER = Theme.Random(
            "NTW_EXPANSION_TRANSFER_PUSHER",
            new ItemStack(Material.OBSERVER),
            Theme.MACHINE,
            "传输器 [推送]",
            "&c仅支持粘液容器",
            "&7默认运输模式: &6首位阻断",
            "&c不可调整运输模式",
            "&7默认运输数量: &664",
            "&c不可调整运输数量",
            "&7运输模式解释: ",
            "&6首位阻断&7: &e仅推送至第一个可以被推送物品的槽位"
    );
    public static final SlimefunItemStack TRANSFER_GRABBER = Theme.Random(
            "NTW_EXPANSION_TRANSFER_GRABBER",
            new ItemStack(Material.HAY_BLOCK),
            Theme.MACHINE,
            "传输器 [抓取]",
            "&c仅支持粘液容器",
            "&7默认运输模式: &6首位阻断",
            "&c不可调整运输模式",
            "&7默认运输数量: &664",
            "&c不可调整运输数量",
            "&7运输模式解释: ",
            "&6首位阻断&7: &e仅抓取第一个有物品的槽位"
    );
    public static final SlimefunItemStack TRANSFER = Theme.Random(
            "NTW_EXPANSION_TRANSFER",
            new ItemStack(Material.PISTON),
            Theme.MACHINE,
            "传输器",
            "&c仅支持粘液容器",
            "&7默认运输模式: &6首位阻断",
            "&c不可调整运输模式",
            "&7默认运输数量: &664",
            "&c不可调整运输数量",
            "&7运输模式解释: ",
            "&6首位阻断&7: &e仅推送至第一个可以被推送物品的槽位 / 仅抓取第一个有物品的槽位"
    );
    public static final SlimefunItemStack ADVANCED_TRANSFER_PUSHER = Theme.Random(
            "NTW_EXPANSION_ADVANCED_TRANSFER_PUSHER",
            new ItemStack(Material.OBSERVER),
            Theme.MACHINE,
            "高级传输器 [推送]",
            "&c仅支持粘液容器",
            "&7默认运输模式: &6首位阻断",
            "&a可调整运输模式",
            "&7默认运输数量: &63456",
            "&a可调整运输数量",
            "&7运输模式解释: ",
            "&6无限制&7: &e可推送至任何槽位",
            "&6仅空&7: &e仅推送至空槽位",
            "&6仅非空&7: &e仅推送至非空槽位",
            "&6仅首位&7: &e仅推送至第一格",
            "&6仅末位&7: &e仅推送至最后一格",
            "&6首位阻断&7: &e仅推送至第一个可以被推送物品的槽位",
            "&6懒惰模式&7: &e当第一格为空时，推送至所有槽位"
    );
    public static final SlimefunItemStack ADVANCED_TRANSFER_GRABBER = Theme.Random(
            "NTW_EXPANSION_ADVANCED_TRANSFER_GRABBER",
            new ItemStack(Material.HAY_BLOCK),
            Theme.MACHINE,
            "高级传输器 [抓取]",
            "&c仅支持粘液容器",
            "&7默认运输模式: &6首位阻断",
            "&a可调整运输模式",
            "&7默认运输数量: &63456",
            "&a可调整运输数量",
            "&7运输模式解释: ",
            "&6无限制&7: &e可抓取任何槽位",
            "&6仅空&7: &e仅抓取空槽位",
            "&6仅非空&7: &e仅抓取非空槽位",
            "&6仅首位&7: &e仅抓取第一格",
            "&6仅末位&7: &e仅抓取最后一格",
            "&6首位阻断&7: &e仅抓取第一个有物品的槽位",
            "&6懒惰模式&7: &e当第一格存在物品时，抓取所有槽位"
    );
    public static final SlimefunItemStack ADVANCED_TRANSFER = Theme.Random(
            "NTW_EXPANSION_ADVANCED_TRANSFER",
            new ItemStack(Material.STICKY_PISTON),
            Theme.MACHINE,
            "高级传输器",
            "&c仅支持粘液容器",
            "&7默认运输模式: &6首位阻断",
            "&a可调整运输模式",
            "&7默认运输数量: &63456",
            "&a可调整运输数量",
            "&7运输模式解释: ",
            "&6无限制&7: &e可推送至任何槽位 / 可抓取任何槽位",
            "&6仅空&7: &e仅推送至空槽位 / 仅抓取空槽位",
            "&6仅非空&7: &e仅推送至非空槽位 / 仅抓取非空槽位",
            "&6仅首位&7: &e仅推送至第一格 / 仅抓取第一格",
            "&6仅末位&7: &e仅推送至最后一格 / 仅抓取最后一格",
            "&6首位阻断&7: &e仅推送至第一个可以被推送物品的槽位 / 仅抓取第一个有物品的槽位",
            "&6懒惰模式&7: &e当第一格为空时，推送至所有槽位 / 当第一格存在物品时，抓取所有槽位"
    );
    public static final SlimefunItemStack SMART_GRABBER = Theme.Random(
            "NTW_EXPANSION_SMART_GRABBER",
            new ItemStack(Material.END_ROD),
            Theme.MACHINE,
            "智能抓取器",
            "即放即用"
    );
    public static final SlimefunItemStack SMART_PUSHER = Theme.Random(
            "NTW_EXPANSION_SMART_PUSHER",
            new ItemStack(Material.LIGHTNING_ROD),
            Theme.MACHINE,
            "智能推送器",
            "即放即用"
    );
    // Grid
    public static final SlimefunItemStack NETWORK_GRID_NEW_STYLE = Theme.Random(
            "NTW_EXPANSION_GRID_NEW_STYLE",
            new ItemStack(Material.NOTE_BLOCK),
            Theme.MACHINE,
            "高级网格",
            "高级网格允许你查看网络中所有的物品",
            "你也可以直接放入或取出物品",
            "排序方式: ",
            "&eAZ&7: &e按字母顺序排序",
            "&e数量&7: &e按物品数量排序",
            "&e附属&7: &e按物品所属附属字母顺序排序",
            "支持拼音搜索"
    );
    // Blueprints
    public static final SlimefunItemStack MAGIC_WORKBENCH_BLUEPRINT = Theme.Random(
            "NTW_EXPANSION_MAGIC_WORKBENCH_BLUEPRINT",
            new ItemStack(Material.RED_DYE),
            Theme.TOOL,
            "魔法工作台蓝图",
            "一张空白的蓝图",
            "可以存储一个魔法工作台配方"
    );
    public static final SlimefunItemStack ARMOR_FORGE_BLUEPRINT = Theme.Random(
            "NTW_EXPANSION_ARMOR_FORGE_BLUEPRINT",
            new ItemStack(Material.ORANGE_DYE),
            Theme.TOOL,
            "盔甲锻造台蓝图",
            "一张空白的蓝图",
            "可以存储一个盔甲锻造台配方"
    );
    public static final SlimefunItemStack SMELTERY_BLUEPRINT = Theme.Random(
            "NTW_EXPANSION_SMELTERY_BLUEPRINT",
            new ItemStack(Material.YELLOW_DYE),
            Theme.TOOL,
            "冶炼炉蓝图",
            "一张空白的蓝图",
            "可以存储一个冶炼炉配方"
    );
    public static final SlimefunItemStack QUANTUM_WORKBENCH_BLUEPRINT = Theme.Random(
            "NTW_EXPANSION_QUANTUM_WORKBENCH_BLUEPRINT",
            new ItemStack(Material.LIME_DYE),
            Theme.TOOL,
            "量子工作台蓝图",
            "一张空白的蓝图",
            "可以存储一个量子工作台配方"
    );
    public static final SlimefunItemStack ANCIENT_ALTAR_BLUEPRINT = Theme.Random(
            "NTW_EXPANSION_ANCIENT_ALTAR_BLUEPRINT",
            new ItemStack(Material.CYAN_DYE),
            Theme.TOOL,
            "古代祭坛蓝图",
            "一张空白的蓝图",
            "可以存储一个古代祭坛配方"
    );
    public static final SlimefunItemStack EXPANSION_WORKBENCH_BLUEPRINT = Theme.Random(
            "NTW_EXPANSION_EXPANSION_WORKBENCH_BLUEPRINT",
            new ItemStack(Material.BROWN_DYE),
            Theme.TOOL,
            "网络拓展工作台蓝图",
            "一张空白的蓝图",
            "可以存储一个网络拓展工作台配方"
    );
    public static final SlimefunItemStack COMPRESSOR_BLUEPRINT = Theme.Random(
            "NTW_EXPANSION_COMPRESSOR_BLUEPRINT",
            new ItemStack(Material.PINK_DYE),
            Theme.TOOL,
            "压缩机蓝图",
            "一张空白的蓝图",
            "可以存储一个压缩机配方"
    );
    public static final SlimefunItemStack GRIND_STONE_BLUEPRINT = Theme.Random(
            "NTW_EXPANSION_GRIND_STONE_BLUEPRINT",
            new ItemStack(Material.MAGENTA_DYE),
            Theme.TOOL,
            "磨石蓝图",
            "一张空白的蓝图",
            "可以存储一个磨石配方"
    );
    public static final SlimefunItemStack JUICER_BLUEPRINT = Theme.Random(
            "NTW_EXPANSION_JUICER_BLUEPRINT",
            new ItemStack(Material.LIGHT_BLUE_DYE),
            Theme.TOOL,
            "榨汁机蓝图",
            "一张空白的蓝图",
            "可以存储一个榨汁机配方"
    );
    public static final SlimefunItemStack ORE_CRUSHER_BLUEPRINT = Theme.Random(
            "NTW_EXPANSION_ORE_CRUSHER_BLUEPRINT",
            new ItemStack(Material.GRAY_DYE),
            Theme.TOOL,
            "矿石粉碎机蓝图",
            "一张空白的蓝图",
            "可以存储一个矿石粉碎机配方"
    );
    public static final SlimefunItemStack PRESSURE_CHAMBER_BLUEPRINT = Theme.Random(
            "NTW_EXPANSION_PRESSURE_CHAMBER_BLUEPRINT",
            new ItemStack(Material.LIGHT_GRAY_DYE),
            Theme.TOOL,
            "压力机蓝图",
            "一张空白的蓝图",
            "可以存储一个压力机配方"
    );
    // Encoders
    public static final SlimefunItemStack MAGIC_WORKBENCH_RECIPE_ENCODER = Theme.Random(
            "NTW_EXPANSION_MAGIC_WORKBENCH_RECIPE_ENCODER",
            new ItemStack(Material.LODESTONE),
            Theme.MACHINE,
            "网络魔法工作台配方编码器",
            "可以根据输入的物品来制作魔法工作台蓝图",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次编码", Theme.CLICK_INFO, Theme.PASSIVE, 2000)
    );
    public static final SlimefunItemStack ARMOR_FORGE_RECIPE_ENCODER = Theme.Random(
            "NTW_EXPANSION_ARMOR_FORGE_RECIPE_ENCODER",
            new ItemStack(Material.FLETCHING_TABLE),
            Theme.MACHINE,
            "网络盔甲锻造台配方编码器",
            "可以根据输入的物品来制作盔甲锻造台蓝图",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次编码", Theme.CLICK_INFO, Theme.PASSIVE, 2000)
    );
    public static final SlimefunItemStack SMELTERY_RECIPE_ENCODER = Theme.Random(
            "NTW_EXPANSION_SMELTERY_RECIPE_ENCODER",
            new ItemStack(Material.SHROOMLIGHT),
            Theme.MACHINE,
            "网络冶炼炉配方编码器",
            "可以根据输入的物品来制作冶炼炉蓝图",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次编码", Theme.CLICK_INFO, Theme.PASSIVE, 2000)
    );
    public static final SlimefunItemStack QUANTUM_WORKBENCH_RECIPE_ENCODER = Theme.Random(
            "NTW_EXPANSION_QUANTUM_WORKBENCH_RECIPE_ENCODER",
            new ItemStack(Material.WET_SPONGE),
            Theme.MACHINE,
            "网络量子工作台配方编码器",
            "可以根据输入的物品来制作量子工作台蓝图",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次编码", Theme.CLICK_INFO, Theme.PASSIVE, 2000)
    );
    public static final SlimefunItemStack ANCIENT_ALTAR_RECIPE_ENCODER = Theme.Random(
            "NTW_EXPANSION_ANCIENT_ALTAR_RECIPE_ENCODER",
            new ItemStack(Material.BEACON),
            Theme.MACHINE,
            "网络古代祭坛配方编码器",
            "可以根据输入的物品来制作古代祭坛蓝图",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次编码", Theme.CLICK_INFO, Theme.PASSIVE, 2000)
    );
    public static final SlimefunItemStack EXPANSION_WORKBENCH_RECIPE_ENCODER = Theme.Random(
            "NTW_EXPANSION_EXPANSION_WORKBENCH_RECIPE_ENCODER",
            new ItemStack(Material.SEA_LANTERN),
            Theme.MACHINE,
            "网络拓展工作台配方编码器",
            "可以根据输入的物品来制作网络拓展工作台蓝图",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次编码", Theme.CLICK_INFO, Theme.PASSIVE, 2000)
    );
    public static final SlimefunItemStack COMPRESSOR_RECIPE_ENCODER = Theme.Random(
            "NTW_EXPANSION_COMPRESSOR_RECIPE_ENCODER",
            new ItemStack(Material.PISTON),
            Theme.MACHINE,
            "网络压缩机配方编码器",
            "可以根据输入的物品来制作压缩机蓝图",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次编码", Theme.CLICK_INFO, Theme.PASSIVE, 2000)
    );
    public static final SlimefunItemStack GRIND_STONE_RECIPE_ENCODER = Theme.Random(
            "NTW_EXPANSION_GRIND_STONE_RECIPE_ENCODER",
            new ItemStack(Material.LOOM),
            Theme.MACHINE,
            "网络磨石配方编码器",
            "可以根据输入的物品来制作磨石蓝图",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次编码", Theme.CLICK_INFO, Theme.PASSIVE, 2000)
    );
    public static final SlimefunItemStack JUICER_RECIPE_ENCODER = Theme.Random(
            "NTW_EXPANSION_JUICER_RECIPE_ENCODER",
            new ItemStack(Material.VERDANT_FROGLIGHT),
            Theme.MACHINE,
            "网络榨汁机配方编码器",
            "可以根据输入的物品来制作榨汁机蓝图",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次编码", Theme.CLICK_INFO, Theme.PASSIVE, 2000)
    );
    public static final SlimefunItemStack ORE_CRUSHER_RECIPE_ENCODER = Theme.Random(
            "NTW_EXPANSION_ORE_CRUSHER_RECIPE_ENCODER",
            new ItemStack(Material.CAULDRON),
            Theme.MACHINE,
            "网络矿石粉碎机配方编码器",
            "可以根据输入的物品来制作矿石粉碎机蓝图",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次编码", Theme.CLICK_INFO, Theme.PASSIVE, 2000)
    );
    public static final SlimefunItemStack PRESSURE_CHAMBER_RECIPE_ENCODER = Theme.Random(
            "NTW_EXPANSION_PRESSURE_CHAMBER_RECIPE_ENCODER",
            new ItemStack(Material.STICKY_PISTON),
            Theme.MACHINE,
            "网络压力机配方编码器",
            "可以根据输入的物品来制作压力机蓝图",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次编码", Theme.CLICK_INFO, Theme.PASSIVE, 2000)
    );
    // Auto Crafters
    public static final SlimefunItemStack AUTO_MAGIC_WORKBENCH = Theme.Random(
            "NTW_EXPANSION_AUTO_MAGIC_WORKBENCH",
            new ItemStack(Material.BOOKSHELF),
            Theme.MACHINE,
            "网络自动魔法工作台",
            "网络自动魔法工作台需要魔法工作台蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 64)
    );
    public static final SlimefunItemStack AUTO_MAGIC_WORKBENCH_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_AUTO_MAGIC_WORKBENCH_WITHHOLDING",
            new ItemStack(Material.CHISELED_BOOKSHELF),
            Theme.MACHINE,
            "网络自动魔法工作台 (预留版)",
            "网络自动魔法工作台需要魔法工作台蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 128)
    );
    public static final SlimefunItemStack AUTO_ARMOR_FORGE = Theme.Random(
            "NTW_EXPANSION_AUTO_ARMOR_FORGE",
            new ItemStack(Material.SMITHING_TABLE),
            Theme.MACHINE,
            "网络自动盔甲锻造台",
            "网络自动盔甲锻造台需要盔甲锻造台蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 64)
    );
    public static final SlimefunItemStack AUTO_ARMOR_FORGE_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_AUTO_ARMOR_FORGE_WITHHOLDING",
            new ItemStack(Material.CARTOGRAPHY_TABLE),
            Theme.MACHINE,
            "网络自动盔甲锻造台 (预留版)",
            "网络自动盔甲锻造台需要盔甲锻造台蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 128)
    );
    public static final SlimefunItemStack AUTO_SMELTERY = Theme.Random(
            "NTW_EXPANSION_AUTO_SMELTERY",
            new ItemStack(Material.FURNACE),
            Theme.MACHINE,
            "网络自动冶炼炉",
            "网络自动冶炼炉需要冶炼炉蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 64)
    );
    public static final SlimefunItemStack AUTO_SMELTERY_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_AUTO_SMELTERY_WITHHOLDING",
            new ItemStack(Material.BLAST_FURNACE),
            Theme.MACHINE,
            "网络自动冶炼炉 (预留版)",
            "网络自动冶炼炉需要冶炼炉蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 128)
    );
    public static final SlimefunItemStack AUTO_QUANTUM_WORKBENCH = Theme.Random(
            "NTW_EXPANSION_AUTO_QUANTUM_WORKBENCH",
            new ItemStack(Material.BRAIN_CORAL_BLOCK),
            Theme.MACHINE,
            "网络自动量子工作台",
            "网络自动量子工作台需要量子工作台蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 64)
    );
    public static final SlimefunItemStack AUTO_QUANTUM_WORKBENCH_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_AUTO_QUANTUM_WORKBENCH_WITHHOLDING",
            new ItemStack(Material.DRIED_KELP_BLOCK),
            Theme.MACHINE,
            "网络自动量子工作台 (预留版)",
            "网络自动量子工作台需要量子工作台蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 128)
    );
    public static final SlimefunItemStack AUTO_ANCIENT_ALTAR = Theme.Random(
            "NTW_EXPANSION_AUTO_ANCIENT_ALTAR",
            new ItemStack(Material.ENCHANTING_TABLE),
            Theme.MACHINE,
            "网络自动古代祭坛",
            "网络自动古代祭坛需要古代祭坛蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 64)
    );
    public static final SlimefunItemStack AUTO_ANCIENT_ALTAR_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_AUTO_ANCIENT_ALTAR_WITHHOLDING",
            new ItemStack(Material.CALIBRATED_SCULK_SENSOR),
            Theme.MACHINE,
            "网络自动古代祭坛 (预留版)",
            "网络自动古代祭坛需要古代祭坛蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 128)
    );
    public static final SlimefunItemStack AUTO_EXPANSION_WORKBENCH = Theme.Random(
            "NTW_EXPANSION_AUTO_EXPANSION_WORKBENCH",
            new ItemStack(Material.FIRE_CORAL_BLOCK),
            Theme.MACHINE,
            "网络自动网络拓展工作台",
            "网络自动网络拓展工作台需要网络拓展工作台蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 64)
    );
    public static final SlimefunItemStack AUTO_EXPANSION_WORKBENCH_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_AUTO_EXPANSION_WORKBENCH_WITHHOLDING",
            new ItemStack(Material.HORN_CORAL_BLOCK),
            Theme.MACHINE,
            "网络自动网络拓展工作台 (预留版)",
            "网络自动网络拓展工作台需要网络拓展工作台蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 128)
    );
    public static final SlimefunItemStack AUTO_COMPRESSOR = Theme.Random(
            "NTW_EXPANSION_AUTO_COMPRESSOR",
            new ItemStack(Material.COMPOSTER),
            Theme.MACHINE,
            "网络自动压缩机",
            "网络自动压缩机需要压缩机蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 64)
    );
    public static final SlimefunItemStack AUTO_COMPRESSOR_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_AUTO_COMPRESSOR_WITHHOLDING",
            new ItemStack(Material.JUKEBOX),
            Theme.MACHINE,
            "网络自动压缩机 (预留版)",
            "网络自动压缩机需要压缩机蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 128)
    );
    public static final SlimefunItemStack AUTO_GRIND_STONE = Theme.Random(
            "NTW_EXPANSION_AUTO_GRIND_STONE",
            new ItemStack(Material.DROPPER),
            Theme.MACHINE,
            "网络自动磨石",
            "网络自动磨石需要磨石蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 64)
    );
    public static final SlimefunItemStack AUTO_GRIND_STONE_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_AUTO_GRIND_STONE_WITHHOLDING",
            new ItemStack(Material.DISPENSER),
            Theme.MACHINE,
            "网络自动磨石 (预留版)",
            "网络自动磨石需要磨石蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 128)
    );
    public static final SlimefunItemStack AUTO_JUICER = Theme.Random(
            "NTW_EXPANSION_AUTO_JUICER",
            new ItemStack(Material.MOSS_BLOCK),
            Theme.MACHINE,
            "网络自动榨汁机",
            "网络自动榨汁机需要榨汁机蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 64)
    );
    public static final SlimefunItemStack AUTO_JUICER_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_AUTO_JUICER_WITHHOLDING",
            new ItemStack(Material.MUD),
            Theme.MACHINE,
            "网络自动榨汁机 (预留版)",
            "网络自动榨汁机需要榨汁机蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 128)
    );
    public static final SlimefunItemStack AUTO_ORE_CRUSHER = Theme.Random(
            "NTW_EXPANSION_AUTO_ORE_CRUSHER",
            new ItemStack(Material.RAW_IRON_BLOCK),
            Theme.MACHINE,
            "网络自动矿石粉碎机",
            "网络自动矿石粉碎机需要矿石粉碎机蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 64)
    );
    public static final SlimefunItemStack AUTO_ORE_CRUSHER_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_AUTO_ORE_CRUSHER_WITHHOLDING",
            new ItemStack(Material.RAW_GOLD_BLOCK),
            Theme.MACHINE,
            "网络自动矿石粉碎机 (预留版)",
            "网络自动矿石粉碎机需要矿石粉碎机蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 128)
    );
    public static final SlimefunItemStack AUTO_PRESSURE_CHAMBER = Theme.Random(
            "NTW_EXPANSION_AUTO_PRESSURE_CHAMBER",
            new ItemStack(Material.SMOOTH_STONE),
            Theme.MACHINE,
            "网络自动压力机",
            "网络自动压力机需要压力机蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 64)
    );
    public static final SlimefunItemStack AUTO_PRESSURE_CHAMBER_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_AUTO_PRESSURE_CHAMBER_WITHHOLDING",
            new ItemStack(Material.SMOOTH_SANDSTONE),
            Theme.MACHINE,
            "网络自动压力机 (预留版)",
            "网络自动压力机需要压力机蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 128)
    );
    // Advanced Auto Crafters
    public static final SlimefunItemStack ADVANCED_AUTO_MAGIC_WORKBENCH = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_MAGIC_WORKBENCH",
            Enchanted(Material.BOOKSHELF),
            Theme.MACHINE,
            "高级网络自动魔法工作台",
            "高级网络自动魔法工作台需要魔法工作台蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 640)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_MAGIC_WORKBENCH_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_MAGIC_WORKBENCH_WITHHOLDING",
            Enchanted(Material.CHISELED_BOOKSHELF),
            Theme.MACHINE,
            "高级网络自动魔法工作台 (预留版)",
            "高级网络自动魔法工作台需要魔法工作台蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 1280)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_ARMOR_FORGE = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_ARMOR_FORGE",
            Enchanted(Material.SMITHING_TABLE),
            Theme.MACHINE,
            "高级网络自动盔甲锻造台",
            "高级网络自动盔甲锻造台需要盔甲锻造台蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 640)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_ARMOR_FORGE_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_ARMOR_FORGE_WITHHOLDING",
            Enchanted(Material.CARTOGRAPHY_TABLE),
            Theme.MACHINE,
            "高级网络自动盔甲锻造台 (预留版)",
            "高级网络自动盔甲锻造台需要盔甲锻造台蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 1280)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_SMELTERY = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_SMELTERY",
            Enchanted(Material.FURNACE),
            Theme.MACHINE,
            "高级网络自动冶炼炉",
            "高级网络自动冶炼炉需要冶炼炉蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 640)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_SMELTERY_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_SMELTERY_WITHHOLDING",
            Enchanted(Material.BLAST_FURNACE),
            Theme.MACHINE,
            "高级网络自动冶炼炉 (预留版)",
            "高级网络自动冶炼炉需要冶炼炉蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 1280)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_QUANTUM_WORKBENCH = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_QUANTUM_WORKBENCH",
            Enchanted(Material.BRAIN_CORAL_BLOCK),
            Theme.MACHINE,
            "高级网络自动量子工作台",
            "高级网络自动量子工作台需要量子工作台蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 640)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_QUANTUM_WORKBENCH_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_QUANTUM_WORKBENCH_WITHHOLDING",
            Enchanted(Material.DRIED_KELP_BLOCK),
            Theme.MACHINE,
            "高级网络自动量子工作台 (预留版)",
            "高级网络自动量子工作台需要量子工作台蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 1280)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_ANCIENT_ALTAR = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_ANCIENT_ALTAR",
            Enchanted(Material.ENCHANTING_TABLE),
            Theme.MACHINE,
            "高级网络自动古代祭坛",
            "高级网络自动古代祭坛需要古代祭坛蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 640)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_ANCIENT_ALTAR_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_ANCIENT_ALTAR_WITHHOLDING",
            Enchanted(Material.CALIBRATED_SCULK_SENSOR),
            Theme.MACHINE,
            "高级网络自动古代祭坛 (预留版)",
            "高级网络自动古代祭坛需要古代祭坛蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 1280)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_EXPANSION_WORKBENCH = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_EXPANSION_WORKBENCH",
            Enchanted(Material.FIRE_CORAL_BLOCK),
            Theme.MACHINE,
            "高级网络自动网络拓展工作台",
            "高级网络自动网络拓展工作台需要网络拓展工作台蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 640)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_EXPANSION_WORKBENCH_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_EXPANSION_WORKBENCH_WITHHOLDING",
            Enchanted(Material.HORN_CORAL_BLOCK),
            Theme.MACHINE,
            "高级网络自动网络拓展工作台 (预留版)",
            "高级网络自动网络拓展工作台需要网络拓展工作台蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 1280)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_COMPRESSOR = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_COMPRESSOR",
            Enchanted(Material.COMPOSTER),
            Theme.MACHINE,
            "高级网络自动压缩机",
            "高级网络自动压缩机需要压缩机蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 640)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_COMPRESSOR_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_COMPRESSOR_WITHHOLDING",
            Enchanted(Material.JUKEBOX),
            Theme.MACHINE,
            "高级网络自动压缩机 (预留版)",
            "高级网络自动压缩机需要压缩机蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 1280)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_GRIND_STONE = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_GRIND_STONE",
            Enchanted(Material.DROPPER),
            Theme.MACHINE,
            "高级网络自动磨石",
            "高级网络自动磨石需要磨石蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 640)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_GRIND_STONE_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_GRIND_STONE_WITHHOLDING",
            Enchanted(Material.DISPENSER),
            Theme.MACHINE,
            "高级网络自动磨石 (预留版)",
            "高级网络自动磨石需要磨石蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 1280)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_JUICER = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_JUICER",
            Enchanted(Material.MOSS_BLOCK),
            Theme.MACHINE,
            "高级网络自动榨汁机",
            "高级网络自动榨汁机需要榨汁机蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 640)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_JUICER_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_JUICER_WITHHOLDING",
            Enchanted(Material.MUD),
            Theme.MACHINE,
            "高级网络自动榨汁机 (预留版)",
            "高级网络自动榨汁机需要榨汁机蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 1280)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_ORE_CRUSHER = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_ORE_CRUSHER",
            Enchanted(Material.RAW_IRON_BLOCK),
            Theme.MACHINE,
            "高级网络自动矿石粉碎机",
            "高级网络自动矿石粉碎机需要矿石粉碎机蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 640)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_ORE_CRUSHER_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_ORE_CRUSHER_WITHHOLDING",
            Enchanted(Material.RAW_GOLD_BLOCK),
            Theme.MACHINE,
            "高级网络自动矿石粉碎机 (预留版)",
            "高级网络自动矿石粉碎机需要矿石粉碎机蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 1280)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_PRESSURE_CHAMBER = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_PRESSURE_CHAMBER",
            Enchanted(Material.SMOOTH_STONE),
            Theme.MACHINE,
            "高级网络自动压力机",
            "高级网络自动压力机需要压力机蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 640)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_PRESSURE_CHAMBER_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_PRESSURE_CHAMBER_WITHHOLDING",
            Enchanted(Material.SMOOTH_SANDSTONE),
            Theme.MACHINE,
            "高级网络自动压力机 (预留版)",
            "高级网络自动压力机需要压力机蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 1280)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_CRAFTING_TABLE = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_CRAFTING",
            Enchanted(Material.CRAFTING_TABLE),
            Theme.MACHINE,
            "高级网络自动合成机",
            "高级网络自动合成机需要合成蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 640)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_CRAFTING_TABLE_WITHHOLDING = Theme.Random(
            "NTW_EXPANSION_ADVANCED_AUTO_CRAFTING_WITHHOLDING",
            Enchanted(Material.CRAFTING_TABLE),
            Theme.MACHINE,
            "高级网络自动合成机 (预留版)",
            "高级网络自动合成机需要合成蓝图才能工作。",
            "当网络中没有蓝图的目标物品时，",
            "机器会自动从网络中选取材料进行合成",
            "允许堆叠蓝图 (不向下兼容)",
            "(需要网络中有足够的原材料)",
            "",
            "预留版的自动合成机会不断进行合成",
            "直到输出栏拥有1组物品",
            "这一组物品可以在网络中访问",
            "也可以通过货运系统取出",
            "",
            MessageFormat.format("{0}网络电力消耗: {1}{2} 每次合成", Theme.CLICK_INFO, Theme.PASSIVE, 1280)
    );
    // Bridges
    public static final SlimefunItemStack NETWORK_BRIDGE_WHITE = Theme.Random(
            "NTW_EXPANSION_BRIDGE_WHITE",
            new ItemStack(Material.WHITE_STAINED_GLASS),
            Theme.MACHINE,
            "网桥(白色)",
            "网桥用于连接不同的网络物品",
            "来形成一个完整的网络",
            "更加清晰的布局网络"
    );
    public static final SlimefunItemStack NETWORK_BRIDGE_LIGHT_GRAY = Theme.Random(
            "NTW_EXPANSION_BRIDGE_LIGHT_GRAY",
            new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS),
            Theme.MACHINE,
            "网桥(淡灰色)",
            "网桥用于连接不同的网络物品",
            "来形成一个完整的网络",
            "更加清晰的布局网络"
    );
    public static final SlimefunItemStack NETWORK_BRIDGE_GRAY = Theme.Random(
            "NTW_EXPANSION_BRIDGE_GRAY",
            new ItemStack(Material.GRAY_STAINED_GLASS),
            Theme.MACHINE,
            "网桥(灰色)",
            "网桥用于连接不同的网络物品",
            "来形成一个完整的网络",
            "更加清晰的布局网络"
    );
    public static final SlimefunItemStack NETWORK_BRIDGE_BLACK = Theme.Random(
            "NTW_EXPANSION_BRIDGE_BLACK",
            new ItemStack(Material.BLACK_STAINED_GLASS),
            Theme.MACHINE,
            "网桥(黑色)",
            "网桥用于连接不同的网络物品",
            "来形成一个完整的网络",
            "更加清晰的布局网络"
    );
    public static final SlimefunItemStack NETWORK_BRIDGE_BROWN = Theme.Random(
            "NTW_EXPANSION_BRIDGE_BROWN",
            new ItemStack(Material.BROWN_STAINED_GLASS),
            Theme.MACHINE,
            "网桥(棕色)",
            "网桥用于连接不同的网络物品",
            "来形成一个完整的网络",
            "更加清晰的布局网络"
    );
    public static final SlimefunItemStack NETWORK_BRIDGE_RED = Theme.Random(
            "NTW_EXPANSION_BRIDGE_RED",
            new ItemStack(Material.RED_STAINED_GLASS),
            Theme.MACHINE,
            "网桥(红色)",
            "网桥用于连接不同的网络物品",
            "来形成一个完整的网络",
            "更加清晰的布局网络"
    );
    public static final SlimefunItemStack NETWORK_BRIDGE_ORANGE = Theme.Random(
            "NTW_EXPANSION_BRIDGE_ORANGE",
            new ItemStack(Material.ORANGE_STAINED_GLASS),
            Theme.MACHINE,
            "网桥(橙色)",
            "网桥用于连接不同的网络物品",
            "来形成一个完整的网络",
            "更加清晰的布局网络"
    );
    public static final SlimefunItemStack NETWORK_BRIDGE_YELLOW = Theme.Random(
            "NTW_EXPANSION_BRIDGE_YELLOW",
            new ItemStack(Material.YELLOW_STAINED_GLASS),
            Theme.MACHINE,
            "网桥(黄色)",
            "网桥用于连接不同的网络物品",
            "来形成一个完整的网络",
            "更加清晰的布局网络"
    );
    public static final SlimefunItemStack NETWORK_BRIDGE_LIME = Theme.Random(
            "NTW_EXPANSION_BRIDGE_LIME",
            new ItemStack(Material.LIME_STAINED_GLASS),
            Theme.MACHINE,
            "网桥(黄绿色)",
            "网桥用于连接不同的网络物品",
            "来形成一个完整的网络",
            "更加清晰的布局网络"
    );
    public static final SlimefunItemStack NETWORK_BRIDGE_GREEN = Theme.Random(
            "NTW_EXPANSION_BRIDGE_GREEN",
            new ItemStack(Material.GREEN_STAINED_GLASS),
            Theme.MACHINE,
            "网桥(绿色)",
            "网桥用于连接不同的网络物品",
            "来形成一个完整的网络",
            "更加清晰的布局网络"
    );
    public static final SlimefunItemStack NETWORK_BRIDGE_CYAN = Theme.Random(
            "NTW_EXPANSION_BRIDGE_CYAN",
            new ItemStack(Material.CYAN_STAINED_GLASS),
            Theme.MACHINE,
            "网桥(青色)",
            "网桥用于连接不同的网络物品",
            "来形成一个完整的网络",
            "更加清晰的布局网络"
    );
    public static final SlimefunItemStack NETWORK_BRIDGE_LIGHT_BLUE = Theme.Random(
            "NTW_EXPANSION_BRIDGE_LIGHT_BLUE",
            new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS),
            Theme.MACHINE,
            "网桥(淡蓝色)",
            "网桥用于连接不同的网络物品",
            "来形成一个完整的网络",
            "更加清晰的布局网络"
    );
    public static final SlimefunItemStack NETWORK_BRIDGE_BLUE = Theme.Random(
            "NTW_EXPANSION_BRIDGE_BLUE",
            new ItemStack(Material.BLUE_STAINED_GLASS),
            Theme.MACHINE,
            "网桥(蓝色)",
            "网桥用于连接不同的网络物品",
            "来形成一个完整的网络",
            "更加清晰的布局网络"
    );
    public static final SlimefunItemStack NETWORK_BRIDGE_PURPLE = Theme.Random(
            "NTW_EXPANSION_BRIDGE_PURPLE",
            new ItemStack(Material.PURPLE_STAINED_GLASS),
            Theme.MACHINE,
            "网桥(紫色)",
            "网桥用于连接不同的网络物品",
            "来形成一个完整的网络",
            "更加清晰的布局网络"
    );
    public static final SlimefunItemStack NETWORK_BRIDGE_MAGENTA = Theme.Random(
            "NTW_EXPANSION_BRIDGE_MAGENTA",
            new ItemStack(Material.MAGENTA_STAINED_GLASS),
            Theme.MACHINE,
            "网桥(品红色)",
            "网桥用于连接不同的网络物品",
            "来形成一个完整的网络",
            "更加清晰的布局网络"
    );
    public static final SlimefunItemStack NETWORK_BRIDGE_PINK = Theme.Random(
            "NTW_EXPANSION_BRIDGE_PINK",
            new ItemStack(Material.PINK_STAINED_GLASS),
            Theme.MACHINE,
            "网桥(粉红色)",
            "网桥用于连接不同的网络物品",
            "来形成一个完整的网络",
            "更加清晰的布局网络"
    );
    // Storages
    public static final SlimefunItemStack ADVANCED_QUANTUM_STORAGE = Theme.Random(
            "NTW_EXPANSION_ADVANCED_QUANTUM_STORAGE",
            new ItemStack(Material.AMETHYST_BLOCK),
            Theme.MACHINE,
            "高级量子存储",
            "可自定义的最大存储容量",
            "请注意设置数量之后不能在设置小于之前设置的数量",
            "否则清空到当前最大容量"
    );
    public static final SlimefunItemStack LINE_POWER_OUTLET_1 = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_LINE_POWER_OUTLET_1",
            new ItemStack(Material.WHITE_WOOL),
            Theme.MACHINE,
            "链式网络插口 (1)",
            "链式网络插口可以将网络中存储的电力",
            "传输至指定的机器中.",
            "",
            MessageFormat.format("{0}可存储: {1}{2}J", Theme.CLICK_INFO, Theme.PASSIVE, NetworkQuantumStorage.getSizes()[0])
    );
    public static final SlimefunItemStack LINE_POWER_OUTLET_2 = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_LINE_POWER_OUTLET_2",
            new ItemStack(Material.LIGHT_GRAY_WOOL),
            Theme.MACHINE,
            "链式网络插口 (2)",
            "链式网络插口可以将网络中存储的电力",
            "传输至指定的机器中.",
            "",
            MessageFormat.format("{0}可存储: {1}{2}J", Theme.CLICK_INFO, Theme.PASSIVE, NetworkQuantumStorage.getSizes()[1])
    );
    public static final SlimefunItemStack LINE_POWER_OUTLET_3 = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_LINE_POWER_OUTLET_3",
            new ItemStack(Material.GRAY_WOOL),
            Theme.MACHINE,
            "链式网络插口 (3)",
            "链式网络插口可以将网络中存储的电力",
            "传输至指定的机器中.",
            "",
            MessageFormat.format("{0}可存储: {1}{2}J", Theme.CLICK_INFO, Theme.PASSIVE, NetworkQuantumStorage.getSizes()[2])
    );
    public static final SlimefunItemStack LINE_POWER_OUTLET_4 = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_LINE_POWER_OUTLET_4",
            new ItemStack(Material.BLACK_WOOL),
            Theme.MACHINE,
            "链式网络插口 (4)",
            "链式网络插口可以将网络中存储的电力",
            "传输至指定的机器中.",
            "",
            MessageFormat.format("{0}可存储: {1}{2}J", Theme.CLICK_INFO, Theme.PASSIVE, NetworkQuantumStorage.getSizes()[3])
    );
    public static final SlimefunItemStack LINE_POWER_OUTLET_5 = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_LINE_POWER_OUTLET_5",
            new ItemStack(Material.BROWN_WOOL),
            Theme.MACHINE,
            "链式网络插口 (5)",
            "链式网络插口可以将网络中存储的电力",
            "传输至指定的机器中.",
            "",
            MessageFormat.format("{0}可存储: {1}{2}J", Theme.CLICK_INFO, Theme.PASSIVE, NetworkQuantumStorage.getSizes()[4])
    );
    public static final SlimefunItemStack LINE_POWER_OUTLET_6 = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_LINE_POWER_OUTLET_6",
            new ItemStack(Material.RED_WOOL),
            Theme.MACHINE,
            "链式网络插口 (6)",
            "链式网络插口可以将网络中存储的电力",
            "传输至指定的机器中.",
            "",
            MessageFormat.format("{0}可存储: {1}{2}J", Theme.CLICK_INFO, Theme.PASSIVE, NetworkQuantumStorage.getSizes()[5])
    );
    public static final SlimefunItemStack LINE_POWER_OUTLET_7 = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_LINE_POWER_OUTLET_7",
            new ItemStack(Material.ORANGE_WOOL),
            Theme.MACHINE,
            "链式网络插口 (7)",
            "链式网络插口可以将网络中存储的电力",
            "传输至指定的机器中.",
            "",
            MessageFormat.format("{0}可存储: {1}{2}J", Theme.CLICK_INFO, Theme.PASSIVE, NetworkQuantumStorage.getSizes()[6])
    );
    public static final SlimefunItemStack LINE_POWER_OUTLET_8 = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_LINE_POWER_OUTLET_8",
            new ItemStack(Material.YELLOW_WOOL),
            Theme.MACHINE,
            "链式网络插口 (8)",
            "链式网络插口可以将网络中存储的电力",
            "传输至指定的机器中.",
            "",
            MessageFormat.format("{0}可存储: {1}{2}J", Theme.CLICK_INFO, Theme.PASSIVE, NetworkQuantumStorage.getSizes()[7])
    );
    public static final SlimefunItemStack LINE_POWER_OUTLET_9 = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_LINE_POWER_OUTLET_9",
            new ItemStack(Material.LIME_WOOL),
            Theme.MACHINE,
            "链式网络插口 (9)",
            "链式网络插口可以将网络中存储的电力",
            "传输至指定的机器中.",
            "",
            MessageFormat.format("{0}可存储: {1}{2}J", Theme.CLICK_INFO, Theme.PASSIVE, NetworkQuantumStorage.getSizes()[8])
    );
    public static final SlimefunItemStack LINE_POWER_OUTLET_10 = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_LINE_POWER_OUTLET_10",
            new ItemStack(Material.GREEN_WOOL),
            Theme.MACHINE,
            "链式网络插口 (10)",
            "链式网络插口可以将网络中存储的电力",
            "传输至指定的机器中.",
            "",
            MessageFormat.format("{0}可存储: {1}{2}J", Theme.CLICK_INFO, Theme.PASSIVE, NetworkQuantumStorage.getSizes()[9])
    );
    public static final SlimefunItemStack LINE_POWER_OUTLET_11 = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_LINE_POWER_OUTLET_11",
            new ItemStack(Material.CYAN_WOOL),
            Theme.MACHINE,
            "链式网络插口 (11)",
            "链式网络插口可以将网络中存储的电力",
            "传输至指定的机器中.",
            "",
            MessageFormat.format("{0}可存储: {1}{2}J", Theme.CLICK_INFO, Theme.PASSIVE, NetworkQuantumStorage.getSizes()[10])
    );
    private static final String thanks = "&x&c&c&8&c&f&4&l魔&x&c&b&9&7&f&5&l芋&x&c&a&a&3&f&6&l粘&x&c&9&a&e&f&7&l液&x&c&8&b&9&f&8&l科&x&c&7&c&5&f&9&l技&x&c&5&d&0&f&9&l服&x&c&4&d&b&f&a&l务&x&c&3&e&6&f&b&l器&x&c&2&f&2&f&c&l提&x&c&1&f&d&f&d&l供";
    public static final SlimefunItemStack AUTHOR_SEFIRAAT = Theme.Random(
            "NETWORKS_AUTHOR_SEFIRAAT",
            "bb2725924e09d6b0bdf5ab864e63f80eb880bfa6fe1fa17f9fdb61bc1ae110db",
            Theme.GUIDE,
            "Sefiraat",
            "Networks' author"
    );
    public static final SlimefunItemStack AUTHOR_YBW0014 = Theme.Random(
            "NETWORKS_CHINESE_LOCALIZATION_AUTHOR_YBW0014",
            "82a5c8de37d1a48f41053b8cc2abaec79ffbf0fc11464b290b057dd1d1d3837e",
            Theme.GUIDE,
            "ybw0014",
            "Networks Chinese Localization's author"
    );
   public static final SlimefunItemStack AUTHOR_YITOUDAIDAI = Theme.Random(
            "NETWORKS_EXPANSION_AUTHOR_YITOUDAIDAI",
            new ItemStack(Material.PLAYER_HEAD),
            Theme.GUIDE,
            "yitoudaidai",
            "NetworksExpansion's author"
    );
    public static final SlimefunItemStack AUTHOR_TINALNESS = Theme.Random(
            "NETWORKS_EXPANSION_AUTHOR_TINALNESS",
            "73112785f64d814103931505ace00048c087337785550c99a67449c392b39772",
            Theme.GUIDE,
            "tinalness",
            "NetworksExpansion's author"
    );
    public static SlimefunItemStack CARGO_NODE_QUICK_TOOL = Theme.Random(
            "NTW_EXPANSION_CARGO_NODE_QUICK_TOOL",
            new ItemStack(Material.BONE),
            Theme.MACHINE,
            "货运节点快配工具",
            "&a右键: 设置指向货运节点的配置",
            "&e下蹲+右键: 从指向的货运节点加载配置",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack STORAGE_UNIT_UPGRADE_TABLE = Theme.Random(
            "NTW_EXPANSION_STORAGE_UPGRADE_TABLE",
            new ItemStack(Material.CARTOGRAPHY_TABLE),
            Theme.MACHINE,
            "网络抽屉升级台",
            "&e用于升级网络抽屉",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_1 = Theme.Random(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_1",
            new ItemStack(Material.CHISELED_BOOKSHELF),
            Theme.MACHINE,
            "网络抽屉 I",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.TINY.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.TINY.getEachMaxSize() + " 个",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_2 = Theme.Random(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_2",
            new ItemStack(Material.CHISELED_BOOKSHELF),
            Theme.MACHINE,
            "网络抽屉 II",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.MINI.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.MINI.getEachMaxSize() + " 个",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_3 = Theme.Random(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_3",
            new ItemStack(Material.CHISELED_BOOKSHELF),
            Theme.MACHINE,
            "网络抽屉 III",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.SMALL.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.SMALL.getEachMaxSize() + " 个",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_4 = Theme.Random(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_4",
            new ItemStack(Material.CHISELED_BOOKSHELF),
            Theme.MACHINE,
            "网络抽屉 IV",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.MEDIUM.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.MEDIUM.getEachMaxSize() + " 个",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_5 = Theme.Random(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_5",
            new ItemStack(Material.CHISELED_BOOKSHELF),
            Theme.MACHINE,
            "网络抽屉 V",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.LARGE.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.LARGE.getEachMaxSize() + " 个",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_6 = Theme.Random(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_6",
            new ItemStack(Material.CHISELED_BOOKSHELF),
            Theme.MACHINE,
            "网络抽屉 VI",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.ENHANCED.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.ENHANCED.getEachMaxSize() + " 个",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_7 = Theme.Random(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_7",
            new ItemStack(Material.CHISELED_BOOKSHELF),
            Theme.MACHINE,
            "网络抽屉 VII",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.ADVANCED.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.ADVANCED.getEachMaxSize() + " 个",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_8 = Theme.Random(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_8",
            new ItemStack(Material.CHISELED_BOOKSHELF),
            Theme.MACHINE,
            "网络抽屉 VIII",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.EXTRA.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.EXTRA.getEachMaxSize() + " 个",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_9 = Theme.Random(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_9",
            new ItemStack(Material.CHISELED_BOOKSHELF),
            Theme.MACHINE,
            "网络抽屉 IX",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.ULTRA.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.ULTRA.getEachMaxSize() + " 个",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_10 = Theme.Random(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_10",
            new ItemStack(Material.CHISELED_BOOKSHELF),
            Theme.MACHINE,
            "网络抽屉 X",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.END_GAME_BASIC.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.END_GAME_BASIC.getEachMaxSize() + " 个",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_11 = Theme.Random(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_11",
            new ItemStack(Material.CHISELED_BOOKSHELF),
            Theme.MACHINE,
            "网络抽屉 XI",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.END_GAME_INTERMEDIATE.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.END_GAME_INTERMEDIATE.getEachMaxSize() + " 个",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_12 = Theme.Random(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_12",
            new ItemStack(Material.CHISELED_BOOKSHELF),
            Theme.MACHINE,
            "网络抽屉 XII",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.END_GAME_ADVANCED.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.END_GAME_ADVANCED.getEachMaxSize() + " 个",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_13 = Theme.Random(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_13",
            new ItemStack(Material.CHISELED_BOOKSHELF),
            Theme.MACHINE,
            "网络抽屉 XIII",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.END_GAME_MAX.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.END_GAME_MAX.getEachMaxSize() + " 个",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_1_MODEL = Theme.model(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_1",
            Skins.CARGO_STORAGE_UNIT_1_MODEL.getPlayerHead(),
            Theme.MACHINE,
            "网络抽屉 I",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.TINY_MODEL.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.TINY_MODEL.getEachMaxSize() + " 个",
            "",
            "&7⇨ &e需要网络扳手才能拆除模型方块",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_2_MODEL = Theme.model(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_2",
            Skins.CARGO_STORAGE_UNIT_2_MODEL.getPlayerHead(),
            Theme.MACHINE,
            "网络抽屉 II",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.MINI_MODEL.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.MINI_MODEL.getEachMaxSize() + " 个",
            "",
            "&7⇨ &e需要网络扳手才能拆除模型方块",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_3_MODEL = Theme.model(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_3",
            Skins.CARGO_STORAGE_UNIT_3_MODEL.getPlayerHead(),
            Theme.MACHINE,
            "网络抽屉 III",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.SMALL_MODEL.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.SMALL_MODEL.getEachMaxSize() + " 个",
            "",
            "&7⇨ &e需要网络扳手才能拆除模型方块",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_4_MODEL = Theme.model(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_4",
            Skins.CARGO_STORAGE_UNIT_4_MODEL.getPlayerHead(),
            Theme.MACHINE,
            "网络抽屉 IV",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.MEDIUM_MODEL.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.MEDIUM_MODEL.getEachMaxSize() + " 个",
            "",
            "&7⇨ &e需要网络扳手才能拆除模型方块",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_5_MODEL = Theme.model(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_5",
            Skins.CARGO_STORAGE_UNIT_5_MODEL.getPlayerHead(),
            Theme.MACHINE,
            "网络抽屉 V",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.LARGE_MODEL.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.LARGE_MODEL.getEachMaxSize() + " 个",
            "",
            "&7⇨ &e需要网络扳手才能拆除模型方块",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_6_MODEL = Theme.model(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_6",
            Skins.CARGO_STORAGE_UNIT_6_MODEL.getPlayerHead(),
            Theme.MACHINE,
            "网络抽屉 VI",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.ENHANCED_MODEL.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.ENHANCED_MODEL.getEachMaxSize() + " 个",
            "",
            "&7⇨ &e需要网络扳手才能拆除模型方块",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_7_MODEL = Theme.model(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_7",
            Skins.CARGO_STORAGE_UNIT_7_MODEL.getPlayerHead(),
            Theme.MACHINE,
            "网络抽屉 VII",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.ADVANCED_MODEL.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.ADVANCED_MODEL.getEachMaxSize() + " 个",
            "",
            "&7⇨ &e需要网络扳手才能拆除模型方块",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_8_MODEL = Theme.model(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_8",
            Skins.CARGO_STORAGE_UNIT_8_MODEL.getPlayerHead(),
            Theme.MACHINE,
            "网络抽屉 VIII",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.EXTRA_MODEL.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.EXTRA_MODEL.getEachMaxSize() + " 个",
            "",
            "&7⇨ &e需要网络扳手才能拆除模型方块",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_9_MODEL = Theme.model(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_9",
            Skins.CARGO_STORAGE_UNIT_9_MODEL.getPlayerHead(),
            Theme.MACHINE,
            "网络抽屉 IX",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.ULTRA_MODEL.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.ULTRA_MODEL.getEachMaxSize() + " 个",
            "",
            "&7⇨ &e需要网络扳手才能拆除模型方块",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_10_MODEL = Theme.model(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_10",
            Skins.CARGO_STORAGE_UNIT_10_MODEL.getPlayerHead(),
            Theme.MACHINE,
            "网络抽屉 X",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.END_GAME_BASIC_MODEL.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.END_GAME_BASIC_MODEL.getEachMaxSize() + " 个",
            "",
            "&7⇨ &e需要网络扳手才能拆除模型方块",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_11_MODEL = Theme.model(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_11",
            Skins.CARGO_STORAGE_UNIT_11_MODEL.getPlayerHead(),
            Theme.MACHINE,
            "网络抽屉 XI",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.END_GAME_INTERMEDIATE_MODEL.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.END_GAME_INTERMEDIATE_MODEL.getEachMaxSize() + " 个",
            "",
            "&7⇨ &e需要网络扳手才能拆除模型方块",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_12_MODEL = Theme.model(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_12",
            Skins.CARGO_STORAGE_UNIT_12_MODEL.getPlayerHead(),
            Theme.MACHINE,
            "网络抽屉 XII",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.END_GAME_ADVANCED_MODEL.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.END_GAME_ADVANCED_MODEL.getEachMaxSize() + " 个",
            "",
            "&7⇨ &e需要网络扳手才能拆除模型方块",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack CARGO_STORAGE_UNIT_13_MODEL = Theme.model(
            "NTW_EXPANSION_CARGO_STORAGE_UNIT_13",
            Skins.CARGO_STORAGE_UNIT_13_MODEL.getPlayerHead(),
            Theme.MACHINE,
            "网络抽屉 XIII",
            "&6支持网络快速输入/输出",
            "",
            "&7⇨ &e可储存 " + StorageUnitType.END_GAME_MAX_MODEL.getMaxItemCount() + " 种物品",
            "&7⇨ &e每种物品可容纳 " + StorageUnitType.END_GAME_MAX_MODEL.getEachMaxSize() + " 个",
            "",
            "&7⇨ &e需要网络扳手才能拆除模型方块",
            "",
            thanks,
            ""
    );
    public static SlimefunItemStack ITEM_MOVER = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_ITEM_MOVER",
            new ItemStack(Material.DEBUG_STICK),
            Theme.TOOL,
            "&6物品转移棒",
            ChatColor.GOLD + "右键以转移物品至物品转移棒",
            ChatColor.GOLD + "Shift + 右键以转移物品至指定的存储",
            ChatColor.RED + "不支持无尽存储"
    );
    public static SlimefunItemStack NETWORK_BLUEPRINT_DECODER = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_BLUEPRINT_DECODER",
            new ItemStack(Material.DEEPSLATE_TILES),
            Theme.MACHINE,
            "&6网络蓝图解码器",
            "解码网络蓝图",
            ""
    );

    public static SlimefunItemStack DUE_MACHINE = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_DUE_MACHINE",
            new ItemStack(Material.TARGET),
            Theme.MACHINE,
            "&6预期机",
            "匹配物品时，输出物品"
    );

    public static SlimefunItemStack OFFSETTER = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_OFFSETTER",
            new ItemStack(Material.GRINDSTONE),
            Theme.MACHINE,
            "&a偏移机",
            "&8顾名思义"
    );

    public static SlimefunItemStack BETTER_GRABBER = Theme.themedSlimefunItemStack(
            "NTW_EXPANSION_BETTER_GRABBER",
            new ItemStack(Material.PINK_STAINED_GLASS),
            Theme.MACHINE,
            "更好的网络抓取器",
            "更好的网络抓取器会尝试从",
            "指定的机器中抓取第一个物品"
    );

    public static ItemStack Enchanted(Material material) {
        return ItemStackUtil.getPreEnchantedItemStack(material);
    }
}
