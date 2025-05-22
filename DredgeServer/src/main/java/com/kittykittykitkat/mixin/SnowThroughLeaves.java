package com.kittykittykitkat.mixin;
//
//import net.minecraft.server.world.ServerWorld;
//import net.minecraft.world.Heightmap;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.ModifyArg;
//
//import java.util.concurrent.ThreadLocalRandom;
//
//@Mixin(ServerWorld.class)
//public class SnowThroughLeaves {
//    @ModifyArg(method = "tickChunk", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerWorld;getTopPosition(Lnet/minecraft/world/Heightmap$Type;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/util/math/BlockPos;"), index = 0)
//    public Heightmap.Type randomizeHeightMap(Heightmap.Type par1) {
//        ThreadLocalRandom random = ThreadLocalRandom.current();
//        int choice = random.nextInt(2);
//        if (choice == 0) {
//            return Heightmap.Type.MOTION_BLOCKING;
//        } else {
//            return Heightmap.Type.MOTION_BLOCKING_NO_LEAVES;
//        }
//    }
//
//}
