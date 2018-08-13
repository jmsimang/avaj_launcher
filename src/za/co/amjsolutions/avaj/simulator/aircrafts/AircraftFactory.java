package za.co.amjsolutions.avaj.simulator.aircrafts;

import za.co.amjsolutions.avaj.simulator.Flyable;

/**
 *
 * @author jmsimang
 */
public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
            throws AircraftException {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        if (type.equalsIgnoreCase("Baloon"))
            return new Baloon(name, coordinates);
        else if (type.equalsIgnoreCase("Helicopter"))
            return new Helicopter(name, coordinates);
        else if (type.equalsIgnoreCase("JetPlane"))
            return new JetPlane(name, coordinates);
        else
            throw new AircraftException("Invalid Aircraft Type Specified");
    }
}
