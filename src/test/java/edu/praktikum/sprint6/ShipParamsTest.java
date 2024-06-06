package edu.praktikum.sprint6;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ShipParamsTest {

    @Mock
    private Sail sail;

    @Parameter
    public int power;
    @Parameter(1)
    public int expectedResult;

    @Parameters
    public static Object[][] data() {
        return new Object[][] {
                { 4, 16 },
                { 2, 8 }
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getMaxSpeedTest() {
        Ship ship = new Ship(sail);

        Mockito.when(sail.getMaxPower()).thenReturn(power);
        int actual = ship.getMaxSpeed();

        assertEquals(expectedResult, actual);
    }
}
