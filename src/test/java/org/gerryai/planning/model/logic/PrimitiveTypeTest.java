package org.gerryai.planning.model.logic;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimitiveTypeTest {

    @Test
    public void getConstantNameReturnsSameName() {
        PrimitiveType primitiveType = new PrimitiveType("test");
        assertEquals("test", primitiveType.getName());
    }

    @Test
    public void testEquals() {
        new EqualsTester()
                .addEqualityGroup(new PrimitiveType("test"), new PrimitiveType("test"))
                .addEqualityGroup(new PrimitiveType("example"), new PrimitiveType("example"))
                .testEquals();
    }
}
