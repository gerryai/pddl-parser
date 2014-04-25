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
