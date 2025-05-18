package junit.gradle.unit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class JUnitLifecycleTest {
	private static int counter = 0;

	@BeforeAll
    public static void suiteSetup() {
		assertEquals(0, counter);
        counter++;
    }

    public JUnitLifecycleTest() {
        assertTrue(Arrays.asList(1, 5).contains(counter)); // twice... for each test
        counter++;
    }

    @BeforeEach
    public void prepareTest() {
        assertTrue(Arrays.asList(2, 6).contains(counter));
        counter++;
    }

    @Test
    public void peformFirstTest() {
        assertTrue(Arrays.asList(3, 7).contains(counter));
        counter++;
    }

    @Test
    public void performSecondTest() {
        assertTrue(Arrays.asList(3, 7).contains(counter));
        counter++;
    }

    @AfterEach
    public void cleanupTest() {
        assertTrue(Arrays.asList(4, 8).contains(counter));
        counter++;
    }

    @AfterAll
    public static void suiteFinished() {
        assertEquals(9, counter);
    }
}
