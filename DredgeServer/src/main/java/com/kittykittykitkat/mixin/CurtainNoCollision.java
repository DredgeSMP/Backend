package com.kittykittykitkat.mixin;

import net.kikoz.mcwwindows.objects.Curtain;
import net.minecraft.block.AbstractBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;


@Mixin(Curtain.class)
public class CurtainNoCollision {
    @ModifyArg(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;<init>(Lnet/minecraft/block/AbstractBlock$Settings;)V"))
    private static AbstractBlock.Settings makeNoCollision(AbstractBlock.Settings settings) {
        return settings.noCollision();
    }
}
