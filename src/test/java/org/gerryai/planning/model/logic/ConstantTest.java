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
package org.gerryai.planning.model.logic;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConstantTest {

    @Test
    public void getConstantNameReturnsSameName() {
        Constant constant = new Constant("test");
        assertEquals("test", constant.getName());
    }

    @Test
    public void testEquals() {
        new EqualsTester()
                .addEqualityGroup(new Constant("test"), new Constant("test"))
                .addEqualityGroup(new Constant("example"), new Constant("example"))
                .testEquals();
    }
}
