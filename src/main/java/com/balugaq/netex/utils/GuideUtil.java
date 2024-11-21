package com.balugaq.netex.utils;

import com.balugaq.netex.api.guide.CheatGuideImpl;
import com.balugaq.netex.api.guide.SurvivalGuideImpl;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.core.guide.GuideHistory;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideImplementation;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideMode;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Final_ROOT, balugaq
 * @since 2.0
 */
@UtilityClass
public class GuideUtil {
    @Deprecated(
            since = "2.1-Alpha-10"
    )
    private static final SurvivalGuideImpl survivalGuide = new SurvivalGuideImpl();
    @Deprecated(
            since = "2.1-Alpha-10"
    )
    private static final CheatGuideImpl cheatGuide = new CheatGuideImpl();

    @ParametersAreNonnullByDefault
    public static void openMainMenuAsync(Player player, SlimefunGuideMode mode, int selectedPage) {
        if (!PlayerProfile.get(player, profile -> Slimefun.runSync(() -> openMainMenu(player, profile, mode, selectedPage)))) {
            Slimefun.getLocalization().sendMessage(player, "messages.opening-guide");
        }
    }

    @ParametersAreNonnullByDefault
    public static void openMainMenu(Player player, PlayerProfile profile, SlimefunGuideMode mode, int selectedPage) {
        getGuide(player, mode).openMainMenu(profile, selectedPage);
    }

    @Deprecated
    public static SlimefunGuideImplementation getGuide(Player player, SlimefunGuideMode mode) {
        if (mode == SlimefunGuideMode.SURVIVAL_MODE) {
            return survivalGuide;
        }
        if (player.isOp() && mode == SlimefunGuideMode.CHEAT_MODE) {
            return cheatGuide;
        }

        return survivalGuide;
    }

    public static void removeLastEntry(@Nonnull GuideHistory guideHistory) {
        try {
            Method getLastEntry = guideHistory.getClass().getDeclaredMethod("getLastEntry", boolean.class);
            getLastEntry.setAccessible(true);
            getLastEntry.invoke(guideHistory, true);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
