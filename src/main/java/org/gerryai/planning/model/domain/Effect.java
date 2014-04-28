/*
 * Gerry AI - Open framework for automated planning
 * Copyright (c) 2014 David Edwards <david@more.fool.me.uk>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gerryai.planning.model.domain;

import com.google.common.base.Optional;
import org.gerryai.planning.model.logic.Formula;

import java.util.Objects;

/**
 * Class encapsulating the effect of an action.
 */
public class Effect {

    private final Optional<Formula> effect;

    private static final Effect EMPTY = new Effect();

    /**
     * Returns an empty {@link Effect}.
     * @return an empty {@link Effect}
     */
    public static Effect empty() {
        return EMPTY;
    }

    /**
     * Private constructor to create an empty effect.
     */
    private Effect() {
        effect = Optional.absent();
    }

    /**
     * Constructor.
     * @param effect the formula describing the effect
     */
    public Effect(final Formula effect) {
        this.effect = Optional.fromNullable(effect);
    }

    /**
     * Get the formula describing this effect.
     * @return the formula
     */
    public Optional<Formula> getEffect() {
        return effect;
    }

    @Override
    public int hashCode() {
        return Objects.hash(effect);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Effect other = (Effect) obj;
        return Objects.equals(this.effect, other.effect);
    }
}
