package net.bayruby.contractfabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.bayruby.contractfabric.client.PlayerLikeNPCRenderer;

public class ContractFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ContractFabric.LOGGER.info("Initializing Contract Fabric Client!");
		try {
			EntityRendererRegistry.register(
				ContractFabric.PLAYER_LIKE_NPC,
				PlayerLikeNPCRenderer::new
			);
			ContractFabric.LOGGER.info("Entity renderer registered successfully!");
		} catch (Exception e) {
			ContractFabric.LOGGER.error("Failed to register entity renderer", e);
		}
	}
}
