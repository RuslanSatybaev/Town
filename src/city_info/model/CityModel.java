package city_info.model;

public class CityModel {

    private String name;
    private String region;
    private String district;
    private int population;
    private String foundation;

    public CityModel() {

    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public CityModel(String name, String region, String district, int population, String foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public CityModel(String name, String region) {
        this.name = name;
        this.region = region;
    }

    @Override
    public String toString() {
        return "CityModel{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
