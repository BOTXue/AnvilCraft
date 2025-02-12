package dev.dubhe.anvilcraft.block.entity.fabric;

import dev.dubhe.anvilcraft.api.depository.fabric.ItemDepositoryHelperImpl;
import dev.dubhe.anvilcraft.block.entity.BatchCrafterBlockEntity;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BatchCrafterBlockEntityImpl extends BatchCrafterBlockEntity {

    public BatchCrafterBlockEntityImpl(
        BlockEntityType<? extends BlockEntity> type, BlockPos pos, BlockState blockState
    ) {
        super(type, pos, blockState);
    }

    public static @NotNull BatchCrafterBlockEntity createBlockEntity(
        BlockEntityType<?> type, BlockPos pos, BlockState blockState
    ) {
        return new BatchCrafterBlockEntityImpl(type, pos, blockState);
    }

    /**
     * 方块实体注册时执行
     *
     * @param type 方块实体类型
     */
    @SuppressWarnings("UnstableApiUsage")
    public static void onBlockEntityRegister(BlockEntityType<BatchCrafterBlockEntity> type) {
        ItemStorage.SIDED.registerForBlockEntity(
            (blockEntity, direction) -> ItemDepositoryHelperImpl.toStorage(blockEntity.getDepository()), type
        );
    }
}
