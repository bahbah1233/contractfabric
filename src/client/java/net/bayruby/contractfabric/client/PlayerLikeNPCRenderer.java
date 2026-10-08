package net.bayruby.contractfabric.client;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.bayruby.contractfabric.entity.PlayerLikeNPC;

public class PlayerLikeNPCRenderer extends MobRenderer<PlayerLikeNPC, PlayerModel<PlayerLikeNPC>> {
    private static final ResourceLocation TEXTURE = 
        ResourceLocation.fromNamespaceAndPath("minecraft", "textures/entity/player/slim/alex.png");

    public PlayerLikeNPCRenderer(EntityRendererProvider.Context context) {
        super(context, new PlayerModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM), false), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(PlayerLikeNPC entity) {
        return TEXTURE;
    }
}
