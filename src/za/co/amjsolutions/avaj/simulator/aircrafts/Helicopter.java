package za.co.amjsolutions.avaj.simulator.aircrafts;

import za.co.amjsolutions.avaj.simulator.Flyable;
import za.co.amjsolutions.avaj.simulator.Logger;
import za.co.amjsolutions.avaj.simulator.WeatherTower;

/**
 *
 * @author jmsimang
 */
public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private String weather;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        this.weather = this.weatherTower.getWeather(this.coordinates);
        int lon = this.coordinates.getLongitude();
        int lat = this.coordinates.getLatitude();
        int height = this.coordinates.getHeight();
        switch(this.weather) {
            case "RAIN":
                this.coordinates = new Coordinates(lon, lat + 5, height);
                Logger.getLogger().runLogger("Helicopter#" + this.name + "("+this.id+"): What's a little drizzle going to do?\n");
                break;
            case "FOG":
                this.coordinates = new Coordinates(lon + 1, lat, height);
                Logger.getLogger().runLogger("Helicopter#" + this.name + "("+this.id+"): I think I may be lost.\n");
                break;
            case "SUN":
                if (height + 2 >= 100)
                    this.coordinates = new Coordinates(lon + 10, lat, 100);
                else
                    this.coordinates = new Coordinates(lon + 10, lat, height + 2);
                Logger.getLogger().runLogger("Helicopter#" + this.name + "("+this.id+"): This is hot.\n");
                break;
            case "SNOW":
                if (height - 12 <= 0)
                    break;
                this.coordinates = new Coordinates(lon, lat, height - 12);
                Logger.getLogger().runLogger("Helicopter#" + this.name + "("+this.id+"): My rotor is going to freeze.\n");
                break;
            default:
                Logger.getLogger().runLogger("Helicopter#" + this.name + "("+this.id+"): I cannot contact the Weather Tower!\n");
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            Logger.getLogger().runLogger("Helicopter#" + this.name + "("+this.id+") landing.\n");
            this.weatherTower.unregister(this);
            Logger.getLogger().runLogger("Helicopter#" + this.name + "("+this.id+") unregistered from weather tower.\n");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        Logger.getLogger().runLogger("Tower says: Helicopter#" + this.name + "("+this.id+") registered to weather tower.\n");
    }

}
