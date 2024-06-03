package shopping;

public class Logger {
    private static final Logger INSTANCE = new Logger();
    private boolean isLoggingEnabled = true;

    private Logger() {
    }

    public static Logger getInstance() {
	return INSTANCE;
    }

    public void enableLogging(boolean enable) {
	this.isLoggingEnabled = enable;
    }

    public void info(String message) {
	if (isLoggingEnabled) {
	    log("INFO", message);
	}
    }

    public void warn(String message) {
	if (isLoggingEnabled) {
	    log("WARNING", message);
	}
    }

    public void error(String message) {
	if (isLoggingEnabled) {
	    log("ERROR", message);
	}
    }

    private void log(String level, String message) {
	String timestamp = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
	System.out.println(timestamp + " [" + level + "] " + message);
    }
}
