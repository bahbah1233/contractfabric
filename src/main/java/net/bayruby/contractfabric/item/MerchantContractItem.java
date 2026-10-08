package net.bayruby.contractfabric.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.bayruby.contractfabric.ContractFabric;
import net.bayruby.contractfabric.entity.PlayerLikeNPC;

public class MerchantContractItem extends Item {
    public MerchantContractItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (level.isClientSide) {
            return InteractionResultHolder.success(stack);
        }

        Vec3 spawnPos = player.getEyePosition().add(player.getLookAngle().scale(2.0D));
        PlayerLikeNPC npc = new PlayerLikeNPC(ContractFabric.PLAYER_LIKE_NPC, level);

        npc.setPos(spawnPos.x, spawnPos.y, spawnPos.z);
        npc.setYRot(player.getYRot());
        npc.setCustomName(net.minecraft.network.chat.Component.literal("Merchant"));
        npc.setCustomNameVisible(true);

        if (!level.addFreshEntity(npc)) {
            return InteractionResultHolder.fail(stack);
        }

        player.swing(hand, true);
        return InteractionResultHolder.success(stack);
    }
}
