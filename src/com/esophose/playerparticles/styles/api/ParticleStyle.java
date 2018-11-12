package com.esophose.playerparticles.styles.api;

import java.util.List;

import org.bukkit.Location;

import com.esophose.playerparticles.particles.ParticlePair;

public interface ParticleStyle {

    /**
     * Gets all the particles to display based on the style's logic
     * 
     * @param particle The ParticlePair that contains the particle's data
     * @param location The central location of the particles
     * @return A List of PParticles to spawn
     */
    public List<PParticle> getParticles(ParticlePair particle, Location location);

    /**
     * Used to update timers for animations, called once per particle tick
     */
    public void updateTimers();

    /**
     * The name of the style
     * 
     * @return The style's name
     */
    public String getName();

    /**
     * Gets if the style can be used in a FixedParticleEffect
     * 
     * @return If the style can be used in a FixedParticleEffect
     */
    public boolean canBeFixed();
    
    
    /**
     * Gets the ParticleStyle with the name given, returns null if not found
     * 
     * @param styleName The string of the style to search for
     * @return The ParticleStyle with the name requested
     */
    public static ParticleStyle fromName(String styleName) {
        for (ParticleStyle style : ParticleStyleManager.getStyles())
            if (style.getName().equals(styleName)) return style;
        return null;
    }

}
