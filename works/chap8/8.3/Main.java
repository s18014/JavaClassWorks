import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        logger.fatal("fatal!");
        logger.error("error!");
        logger.warn("warn!");
        logger.info("info!");
        logger.debug("debug!");
        logger.trace("trace!");
    }
}
