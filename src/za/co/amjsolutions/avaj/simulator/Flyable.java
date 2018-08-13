package za.co.amjsolutions.avaj.simulator;

/**
 *
 * @author jmsimang
 */
public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}
