package net.bayruby.contractfabric.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.bayruby.contractfabric.ContractFabric;
import net.bayruby.contractfabric.entity.PlayerLikeNPC;

public class MerchantContractItem extends Item {
    public MerchantContractItem(Item.Settings settings) {
        super(settings.maxStackSize(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (level.isClientSide) {
            return InteractionResultHolder.success(stack);
        }

        try {
            Vec3 spawnPos = player.getEyePosition().add(player.getLookAngle().scale(2.0D));
            PlayerLikeNPC npc = new PlayerLikeNPC(ContractFabric.PLAYER_LIKE_NPC, level);

            npc.setPos(spawnPos.x, spawnPos.y, spawnPos.z);
            npc.setYRot(player.getYRot());
            npc.setHealth(20.0F);
            npc.setCustomName(Component.literal("Merchant"));
            npc.setCustomNameVisible(true);

            if (level.addFreshEntity(npc)) {
                player.swing(hand, true);
                return InteractionResultHolder.success(stack);
            } else {
                return InteractionResultHolder.fail(stack);
            }
        } catch (Exception e) {
            ContractFabric.LOGGER.error("Error spawning merchant NPC", e);
            return InteractionResultHolder.fail(stack);
        }
    }
}
