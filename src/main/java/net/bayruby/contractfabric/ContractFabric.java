package net.bayruby.contractfabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.bayruby.contractfabric.entity.PlayerLikeNPC;
import net.bayruby.contractfabric.item.MerchantContractItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContractFabric implements ModInitializer {
	public static final String MOD_ID = "contractfabric";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static EntityType<PlayerLikeNPC> PLAYER_LIKE_NPC;
	public static Item MERCHANT_CONTRACT;

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Contract Fabric!");
		
		// Register entity type
		PLAYER_LIKE_NPC = Registry.register(
			BuiltInRegistries.ENTITY_TYPE,
			id("player_like_npc"),
			FabricEntityTypeBuilder.create(MobCategory.MISC, PlayerLikeNPC::new)
				.dimensions(0.6f, 1.8f)
				.trackRangeBlocks(8)
				.trackedUpdateRate(20)
				.build()
		);
		
		// Register merchant contract item
		MERCHANT_CONTRACT = Registry.register(
			BuiltInRegistries.ITEM,
			id("merchant_contract"),
			new MerchantContractItem(new Item.Properties().maxStackSize(1))
		);
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}
