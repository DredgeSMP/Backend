package com.kittykittykitkat.mixin;

import net.mehvahdjukaar.supplementaries.common.block.tiles.CannonBlockTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;
import java.util.Set;

@Mixin(CannonBlockTile.class)
class CannonMixin {
    @Shadow private @Nullable Set<Block> breakWhitelist;

    @Inject(at = @At("TAIL"), method = "<init>")
    private void whitelistAdd(BlockPos pos, BlockState blockState, CallbackInfo ci) {
        breakWhitelist = new HashSet<>();

    }

}