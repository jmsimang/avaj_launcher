package za.co.amjsolutions.avaj.simulator.aircrafts;

import za.co.amjsolutions.avaj.simulator.Flyable;
import za.co.amjsolutions.avaj.simulator.Logger;
import za.co.amjsolutions.avaj.simulator.WeatherTower;

/**
 *
 * @author jmsimang
 */
public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private String weather;

    public Baloon(String name, Coordinates coordinates) {
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
                this.coordinates = new Coordinates(lon, lat, height - 5);
                Logger.getLogger().runLogger("Baloon#" + this.name + "("+this.id+"): Damn you rain. You messed up my baloon.\n");
                break;
            case "FOG":
                this.coordinates = new Coordinates(lon, lat, height - 3);
                Logger.getLogger().runLogger("Baloon#" + this.name + "("+this.id+"): OMG! I cannot see a thing!.\n");
                break;
            case "SUN":
                if (height >= 100)
                    this.coordinates = new Coordinates(lon + 2, lat, 100);
                else
                    this.coordinates = new Coordinates(lon + 2, lat, height + 4);
                Logger.getLogger().runLogger("Baloon#" + this.name + "("+this.id+"): Let's enjoy the good weather and take some pics.\n");
                break;
            case "SNOW":
                if (height - 15 <= 0)
                    break;
                this.coordinates = new Coordinates(lon, lat, height - 15);
                Logger.getLogger().runLogger("Baloon#" + this.name + "("+this.id+"): It's snowing. We're going to crash!\n");
                break;
            default:
                Logger.getLogger().runLogger("Baloon#" + this.name + "("+this.id+"): I cannot contact the Weather Tower!\n");
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            Logger.getLogger().runLogger("Baloon#" + this.name + "("+this.id+") landing.\n");
            this.weatherTower.unregister(this);
            Logger.getLogger().runLogger("Baloon#" + this.name + "("+this.id+") unregistered from weather tower.\n");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        Logger.getLogger().runLogger("Tower says: Baloon#" + this.name + "("+this.id+") registered to weather tower.\n");
        weatherTower.register(this);
    }

}
