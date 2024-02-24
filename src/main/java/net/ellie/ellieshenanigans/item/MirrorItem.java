package net.ellie.ellieshenanigans.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;

public class MirrorItem extends Item {
    public MirrorItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient() && hand == Hand.MAIN_HAND) {
            textTest(user, world);
            user.getItemCooldownManager().set(this, 360);
        }

        return super.use(world, user, hand);
    }

    private void textTest(PlayerEntity player, World world) {
        ServerWorld serverWorld = (ServerWorld) world;
        ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
        if (world.getRegistryKey().getValue().getPath().equals("the_nether")) {
            player.sendMessage(Text.literal("A mysterious presence is stopping you from doing that here.").formatted(Formatting.DARK_PURPLE));
            serverPlayer.playSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD.value(), SoundCategory.HOSTILE, 1f, 1f);
            return;
        }

        if (world.getRegistryKey().getValue().getPath().equals("the_end")) {
            player.sendMessage(Text.literal("A mysterious presence is stopping you from doing that here.").formatted(Formatting.DARK_PURPLE));
            serverPlayer.playSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD.value(), SoundCategory.HOSTILE, 1f, 1f);
            return;
        }

        if (serverPlayer.getSpawnPointPosition() == null ||
        !serverWorld.getBlockState(serverPlayer.getSpawnPointPosition()).getBlock().equals(Blocks.RED_BED)) {
            serverPlayer.setSpawnPoint(serverWorld.getRegistryKey(), serverWorld.getSpawnPos(), 0, true, false);
            serverPlayer.teleport(serverWorld, serverWorld.getSpawnPos().getX(),
                    serverWorld.getSpawnPos().getY(),
                    serverWorld.getSpawnPos().getZ(), player.headYaw, 1);
        }
            player.teleport(serverPlayer.getSpawnPointPosition().getX(),
                    serverPlayer.getSpawnPointPosition().getY(),
                    serverPlayer.getSpawnPointPosition().getZ());

        serverPlayer.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.HOSTILE, 1f, 1f);
        serverPlayer.tiltScreen(10, 10);
        serverPlayer.swingHand(Hand.MAIN_HAND,true);
    }
}
