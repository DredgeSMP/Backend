package com.kittykittykitkat.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.IceBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LightType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.kittykittykitkat.DredgeServer.ANY_LIGHT_MELTS;
import static com.kittykittykitkat.DredgeServer.SKY_LIGHT_MELTS;
import static net.minecraft.block.IceBlock.getMeltedState;

@Mixin(IceBlock.class)
public class NoIceMelt {
    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    public void noMelt(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        if (!world.getGameRules().getBoolean(ANY_LIGHT_MELTS)) {
            ci.cancel();
        }
        if (
                world.getGameRules().getBoolean(SKY_LIGHT_MELTS)
                        && world.getLightLevel(LightType.SKY, pos) > 12
                        && world.isDay()
                        && world.getBiome(pos).value().getTemperature() == -100.0f   // Obviously non-vanilla cold value
                                                                                    // Idea here is that this stuff only
                                                                                   // fires on biomes that were made
                                                                                  // into cold and snowy ones
        ) {
            if (world.getDimension().ultrawarm()) {
                world.removeBlock(pos, false);
            } else {
                world.setBlockState(pos, getMeltedState());
                world.updateNeighbor(pos, getMeltedState().getBlock(), pos);
            }
        }
    }
}
