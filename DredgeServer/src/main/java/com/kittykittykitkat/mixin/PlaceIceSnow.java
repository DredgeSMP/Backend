package com.kittykittykitkat.mixin;

//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.LightType;
//import net.minecraft.world.WorldView;
//import net.minecraft.world.biome.Biome;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Redirect;
//
//import static java.lang.Math.max;
//
//@Mixin(Biome.class)
//public class PlaceIceSnow {
//    @Redirect(method = "canSetSnow", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/WorldView;getLightLevel(Lnet/minecraft/world/LightType;Lnet/minecraft/util/math/BlockPos;)I"))
//    public int lightLevelCheckSnow(WorldView instance, LightType lightType, BlockPos blockPos) {
////        return instance.getLightLevel(lightType, blockPos);
//        return 0;
//    }
//
//    @Redirect(method = "canSetIce(Lnet/minecraft/world/WorldView;Lnet/minecraft/util/math/BlockPos;Z)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/WorldView;getLightLevel(Lnet/minecraft/world/LightType;Lnet/minecraft/util/math/BlockPos;)I"))
//    public int lightLevelCheckIce(WorldView instance, LightType lightType, BlockPos blockPos) {
//        return max(instance.getLightLevel(LightType.BLOCK, blockPos), instance.getLightLevel(LightType.SKY, blockPos)) - 2;
//    }
//}
