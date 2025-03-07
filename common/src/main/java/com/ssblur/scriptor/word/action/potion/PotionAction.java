package com.ssblur.scriptor.word.action.potion;

import com.ssblur.scriptor.helpers.targetable.EntityTargetable;
import com.ssblur.scriptor.helpers.targetable.Targetable;
import com.ssblur.scriptor.word.action.Action;
import com.ssblur.scriptor.word.descriptor.Descriptor;
import com.ssblur.scriptor.word.descriptor.duration.DurationDescriptor;
import com.ssblur.scriptor.word.descriptor.power.StrengthDescriptor;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public abstract class PotionAction extends Action {
  MobEffect mobEffect;
  double durationScale;
  double strengthScale;
  PotionAction(MobEffect mobEffect, double durationScale, double strengthScale) {
    this.mobEffect = mobEffect;
    this.durationScale = durationScale;
    this.strengthScale = strengthScale;
  }

  @Override
  public void apply(Targetable caster, Targetable targetable, Descriptor[] descriptors) {
    double strength = 4;
    double duration = 2;
    for(var d: descriptors) {
      if(d instanceof StrengthDescriptor strengthDescriptor)
        strength += strengthDescriptor.strengthModifier();
      if(d instanceof DurationDescriptor durationDescriptor)
        duration += durationDescriptor.durationModifier();
    }

    strength = Math.max(strength, 0);
    strength *= strengthScale;
    duration *= durationScale;

    // Maybe add poison-tipped enchant?

    if(targetable instanceof EntityTargetable entityTargetable && entityTargetable.getTargetEntity() instanceof LivingEntity living)
      living.addEffect(new MobEffectInstance(mobEffect, (int) duration, (int) Math.floor(strength)));
  }
}
