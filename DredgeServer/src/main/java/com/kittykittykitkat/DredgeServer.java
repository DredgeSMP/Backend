package com.kittykittykitkat;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DredgeServer implements ModInitializer {
	public static final String MOD_ID = "dredgeserver";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

//	public static final GameRules.Key<GameRules.BooleanRule> ANY_LIGHT_MELTS = GameRuleRegistry
//			.register(
//					"anyLightMelts",
//					GameRules.Category.UPDATES,
//					GameRuleFactory.createBooleanRule(true)
//			);

//	public static final GameRules.Key<GameRules.BooleanRule> SKY_LIGHT_MELTS = GameRuleRegistry
//			.register(
//					"skyLightMelts",
//					GameRules.Category.UPDATES,
//					GameRuleFactory.createBooleanRule(true)
//			);

	@Override
	public void onInitialize() {

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			HealthCommand.register(dispatcher);
			FoodbarCommand.register(dispatcher);
		});
	}
}