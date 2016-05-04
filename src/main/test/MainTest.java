import lombok.extern.log4j.Log4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Log4j
public class MainTest {

    private int number;

    @Before
    public void before() {
        log.info("Before testing");
        number = 1;
    }

    @Test
    public void testEquals() {
        log.info("Testing is in progress equals");
        assertEquals(1, number);
    }

    @Test
    public void nullCheck() {
        log.info("Testing is in progress null check");
        assertNotNull("Object cannot be null", new Object());
    }

    @After
    public void after() {
        log.info("After testing");
    }
}