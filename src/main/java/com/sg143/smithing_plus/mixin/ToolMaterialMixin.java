package com.sg143.smithing_plus.mixin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ToolMaterial.class)
public class ToolMaterialMixin {
	@Mutable
	@Shadow
	public static ToolMaterial WOOD = null;
	@Mutable
	@Shadow
	public static ToolMaterial STONE = null;

	@Inject(method = "<clinit>", at = @At("TAIL"))
	private static void modifyMaterial(CallbackInfo ci) {
		WOOD = new ToolMaterial(
				BlockTags.INCORRECT_FOR_WOODEN_TOOL,
				29,
				2.0f,
				0.0f,
				15,
				ItemTags.WOODEN_TOOL_MATERIALS
		);
		STONE = new ToolMaterial(
				BlockTags.INCORRECT_FOR_STONE_TOOL,
				59,
				4.0f,
				1.0f,
				5,
				ItemTags.STONE_TOOL_MATERIALS
		);
	}


}