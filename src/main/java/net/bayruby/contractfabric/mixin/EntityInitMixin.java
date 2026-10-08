package net.bayruby.contractfabric.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.bayruby.contractfabric.entity.ModEntityTypes;

@Mixin(MinecraftServer.class)
public class EntityInitMixin {
    @Inject(at = @At("HEAD"), method = "<init>")
    private void init(CallbackInfo ci) {
        // This ensures entity attributes are registered early
        ModEntityTypes.registerEntityAttributes();
    }
}
