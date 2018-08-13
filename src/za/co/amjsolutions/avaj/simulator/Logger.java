package za.co.amjsolutions.avaj.simulator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author jmsimang
 */
public class Logger {
    private static File file;
    private static BufferedWriter writer;
    private static Logger logger;

    private Logger() {}

    public static Logger getLogger() {
        if (logger != null) {
            return logger;
        } else {
            try {
                logger = new Logger();
                file = new File("simulation.txt");
                writer = new BufferedWriter(new FileWriter(file));
            } catch (IOException e) {
                System.err.println("Error opening file write stream" + e.getMessage());
            }
            return logger;
        }
    }

    public void runLogger(String message) {
        try {
            writer.write(message);
        } catch (IOException e) {
            System.err.println("Error logging to file!\n" + e.getMessage());
        }
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            System.err.println("Error closing file!\n" + e.getMessage());
        }
    }
}
