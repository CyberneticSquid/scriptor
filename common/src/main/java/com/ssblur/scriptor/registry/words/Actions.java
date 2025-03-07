package com.ssblur.scriptor.registry.words;

import com.ssblur.scriptor.word.action.*;
import com.ssblur.scriptor.word.action.potion.PoisonAction;
import com.ssblur.scriptor.word.action.potion.SlowAction;
import com.ssblur.scriptor.word.action.teleport.BringAction;
import com.ssblur.scriptor.word.action.teleport.GotoAction;
import com.ssblur.scriptor.word.action.teleport.SwapAction;

public class Actions {
  private static final WordRegistry INSTANCE = WordRegistry.INSTANCE;

  public final Action INFLAME = INSTANCE.register("inflame", new InflameAction());
  public final Action LIGHT = INSTANCE.register("light", new LightAction());
  public final Action HEAL = INSTANCE.register("heal", new HealAction());
  public final Action SMITE = INSTANCE.register("smite", new SmiteAction());
  public final Action EXPLOSION = INSTANCE.register("explosion", new ExplosionAction());
  public final Action GOTO = INSTANCE.register("goto", new GotoAction());
  public final Action SWAP = INSTANCE.register("swap", new SwapAction());
  public final Action BRING = INSTANCE.register("bring", new BringAction());
  public final Action BREAK = INSTANCE.register("break", new BreakBlockAction());
  public final Action HARM = INSTANCE.register("harm", new HarmAction());
  public final Action COLOR = INSTANCE.register("color", new ColorAction());

  public final Action POISON_POTION = INSTANCE.register("poison", new PoisonAction());
  public final Action SLOW_POTION = INSTANCE.register("slow", new SlowAction());
}
