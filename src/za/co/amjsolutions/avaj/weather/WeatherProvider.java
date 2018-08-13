package za.co.amjsolutions.avaj.weather;

import za.co.amjsolutions.avaj.simulator.aircrafts.Coordinates;

/**
 *
 * @author jmsimang
 */
public class WeatherProvider {
    private final String weather[];
    private static WeatherProvider weatherProvider;

    private WeatherProvider() {
        this.weather = new String[]{"RAIN", "FOG", "SUN", "SNOW"};
    }

    public static WeatherProvider getProvider() {
        weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        if ((coordinates.getLongitude() < 15) && (coordinates.getLatitude() < 25) &&
                (coordinates.getHeight() <= 30))
            return weather[0];
        else if ((coordinates.getLongitude() <= 40) && (coordinates.getLatitude() > 56) &&
                (coordinates.getHeight() <= 60))
            return weather[1];
        else if ((coordinates.getLongitude() > 40) && (coordinates.getLatitude() < 55) &&
                (coordinates.getHeight() <= 90))
            return weather[2];
        else
            return weather[3];
    }
}
