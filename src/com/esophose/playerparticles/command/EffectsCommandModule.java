package com.esophose.playerparticles.command;

import java.util.List;

import org.bukkit.entity.Player;

import com.esophose.playerparticles.manager.LangManager;
import com.esophose.playerparticles.manager.PermissionManager;
import com.esophose.playerparticles.manager.LangManager.Lang;
import com.esophose.playerparticles.particles.PPlayer;
import com.esophose.playerparticles.particles.ParticleEffect;

public class EffectsCommandModule implements CommandModule {

    public void onCommandExecute(PPlayer pplayer, String[] args) {
        Player p = pplayer.getPlayer();

        if (PermissionManager.getEffectsUserHasPermissionFor(p).size() == 1) {
            LangManager.sendMessage(p, Lang.NO_PARTICLES);
            return;
        }

        String toSend = Lang.USE.get() + " ";
        for (ParticleEffect effect : ParticleEffect.getSupportedEffects()) {
            if (PermissionManager.hasEffectPermission(p, effect)) {
                toSend += effect.getName() + ", ";
                continue;
            }
        }
        if (toSend.endsWith(", ")) {
            toSend = toSend.substring(0, toSend.length() - 2);
        }

        LangManager.sendCustomMessage(p, toSend);
        LangManager.sendCustomMessage(p, Lang.USAGE.get() + " " + Lang.PARTICLE_USAGE.get());
    }

    public List<String> onTabComplete(PPlayer pplayer, String[] args) {
        return null;
    }

    public String getName() {
        return "effects";
    }

    public String getDescription() {
        return Lang.EFFECTS_COMMAND_DESCRIPTION.get();
    }

    public String getArguments() {
        return "";
    }

    public boolean requiresEffects() {
        return false;
    }

}