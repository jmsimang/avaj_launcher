package za.co.amjsolutions.avaj.simulator;

import za.co.amjsolutions.avaj.simulator.aircrafts.Coordinates;
import static za.co.amjsolutions.avaj.weather.WeatherProvider.*;

/**
 *
 * @author jmsimang
 */
public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionsChanged();
    }
}
