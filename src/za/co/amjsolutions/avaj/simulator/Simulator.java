package za.co.amjsolutions.avaj.simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import za.co.amjsolutions.avaj.simulator.aircrafts.AircraftException;
import za.co.amjsolutions.avaj.simulator.aircrafts.AircraftFactory;

/**
 *
 * @author jmsimang
 */
public class Simulator {
    private static final ArrayList<Flyable> flyables = new ArrayList<>();
    private static WeatherTower weatherTower;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java za.co.amjsolutions.avaj.simulator.Simulator scenario.txt");
            System.exit(1);
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (line != null) {
                int sims = Integer.parseInt(line.split(" ")[0]);
                weatherTower = new WeatherTower();
                if (sims <= 0) {
                    throw new SimulatorException("Invalid simulation count provided");
                }
                while ((line = reader.readLine()) != null) {
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0],
                            line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]),
                            Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));
                    if (flyable != null)
                        flyables.add(flyable);
                }
                for (Flyable observer : flyables) observer.registerTower(weatherTower);
                for (int i = 1; i <= sims; i++) weatherTower.changeWeather();
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage() + "\nFile ("+args[0]+")not found!");
        } catch (IOException e) {
            System.err.println(e.getMessage() + "\nInvalid file read operation!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage() + "\nSpecify simulation file!");
        } catch (SimulatorException e) {
            System.err.println(e.getMessage() + "\nSimulations need to be more than zero!");
        } catch (AircraftException e) {
            System.err.println(e.getMessage() + "\nEnter a valid aircraft type!");
        } catch (ConcurrentModificationException e) {

        } finally {
            Logger.getLogger().close();
        }
    }
}
