package com.kittykittykitkat.mixin;


import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.argument.TextArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.command.TellRawCommand;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.Texts;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static com.kittykittykitkat.DredgeServer.LOGGER;

@Mixin(TellRawCommand.class)
public class LogTellRaw {
    @Inject(method = "register", at = @At("HEAD"), cancellable = true)
    private static void register(CommandDispatcher<ServerCommandSource> dispatcher, CallbackInfo ci) {
        dispatcher.register((CommandManager.literal("tellraw").requires((source) -> source.hasPermissionLevel(2))).then(CommandManager.argument("targets", EntityArgumentType.players()).then(CommandManager.argument("message", TextArgumentType.text()).executes((context) -> {
            List<String> playerNames = EntityArgumentType.getPlayers(context, "targets")
                    .stream()
                    .map(ServerPlayerEntity::getName)
                    .map(Object::toString)
                    .map(s -> s.replace("literal{", ""))
                    .map(s -> s.replace("}", ""))
                    .toList()
            ;
            LOGGER.info("{} -> {}: {}", context.getSource().getName(), String.join(", ", playerNames), Text.Serializer.toJson(TextArgumentType.getTextArgument(context, "message")));
            int i = 0;

            for (Iterator<ServerPlayerEntity> var2 = EntityArgumentType.getPlayers(context, "targets").iterator(); var2.hasNext(); ++i) {
                ServerPlayerEntity serverPlayerEntity = var2.next();
                serverPlayerEntity.sendMessageToClient(Texts.parse(context.getSource(), TextArgumentType.getTextArgument(context, "message"), serverPlayerEntity, 0), false);
            }

            return i;
        }))));
        ci.cancel();
    }
}
