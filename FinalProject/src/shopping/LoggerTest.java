package shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoggerTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    public void setUp() {
	System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
	System.setOut(standardOut);
    }

    @Test
    void testInfoLogging() {
	Logger.getInstance().enableLogging(true);
	Logger.getInstance().info("Test info");
	assertTrue(outputStreamCaptor.toString().trim().contains("INFO] Test info"));
    }

    @Test
    void testWarnLogging() {
	Logger.getInstance().enableLogging(true);
	Logger.getInstance().warn("Test warning");
	assertTrue(outputStreamCaptor.toString().trim().contains("WARN] Test warning"));
    }

    @Test
    void testErrorLogging() {
	Logger.getInstance().enableLogging(true);
	Logger.getInstance().error("Test error");
	assertTrue(outputStreamCaptor.toString().trim().contains("ERROR] Test error"));
    }

    @Test
    void testLoggingDisabled() {
	Logger.getInstance().enableLogging(false);
	Logger.getInstance().info("Test info");
	assertEquals("", outputStreamCaptor.toString().trim());
    }
}
