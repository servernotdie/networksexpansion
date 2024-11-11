package com.ytdd9527.networksexpansion.utils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

import java.lang.reflect.Field;

public class WorldUtils {
    protected static Class<?> CraftBlockStateClass;
    protected static Field IBlockDataField;
    protected static Field BlockPositionField;
    protected static Field WorldField;
    protected static Field WeakWorldField;
    protected static boolean invokeBlockStateSuccess = false;

    static {
        try {
            World sampleWorld = Bukkit.getWorlds().get(0);
            BlockState blockstate = sampleWorld.getBlockAt(0, 0, 0).getState();
            var result = ReflectionUtil.getDeclaredFieldsRecursively(blockstate.getClass(), "data");
            IBlockDataField = result.getFirstValue();
            IBlockDataField.setAccessible(true);
            CraftBlockStateClass = result.getSecondValue();
            BlockPositionField = ReflectionUtil.getDeclaredFieldsRecursively(CraftBlockStateClass, "position").getFirstValue();
            BlockPositionField.setAccessible(true);
            WorldField = ReflectionUtil.getDeclaredFieldsRecursively(CraftBlockStateClass, "world").getFirstValue();
            WorldField.setAccessible(true);
            WeakWorldField = ReflectionUtil.getDeclaredFieldsRecursively(CraftBlockStateClass, "weakWorld").getFirstValue();
            WeakWorldField.setAccessible(true);
            invokeBlockStateSuccess = true;
        } catch (Throwable ignored) {

        }
    }

    public static boolean copyBlockState(BlockState stateToSet, Block toBlock) {
        if (!invokeBlockStateSuccess) {
            return false;
        }

        BlockState originalState = toBlock.getState();
        if (!CraftBlockStateClass.isInstance(originalState) || !CraftBlockStateClass.isInstance(stateToSet)) {
            return false;
        }

        try {
            BlockPositionField.set(stateToSet, BlockPositionField.get(originalState));
            WorldField.set(stateToSet, WorldField.get(originalState));
            WeakWorldField.set(stateToSet, WeakWorldField.get(originalState));
            stateToSet.update(true, false);
            return true;
        } catch (Throwable ignored) {
            return false;
        }
    }
}