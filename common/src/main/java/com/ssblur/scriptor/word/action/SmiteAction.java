package com.ssblur.scriptor.word.action;

import com.ssblur.scriptor.helpers.targetable.EntityTargetable;
import com.ssblur.scriptor.helpers.targetable.Targetable;
import com.ssblur.scriptor.word.descriptor.Descriptor;
import com.ssblur.scriptor.word.descriptor.DurationDescriptor;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SmiteAction extends Action {
  @Override
  public void apply(Entity caster, Targetable targetable, Descriptor[] descriptors) {
    if(caster.level.isClientSide) return;

    ServerLevel level = (ServerLevel) caster.level;
    LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
    if(caster instanceof ServerPlayer player)
      bolt.setCause(player);
    bolt.setPos(targetable.getTargetPos());
    level.addFreshEntity(bolt);
  }

  @Override
  public Cost cost() { return new Cost(12, COSTTYPE.ADDITIVE); }

}
