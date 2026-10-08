package net.bayruby.contractfabric.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.bayruby.contractfabric.ContractFabric;

public class ModEntityTypes {
    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(
            ContractFabric.PLAYER_LIKE_NPC,
            PlayerLikeNPC.createAttributes()
        );
    }
}
