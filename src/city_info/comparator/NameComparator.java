package city_info.comparator;

import city_info.model.CityModel;

import java.util.Comparator;

public class NameComparator implements Comparator<CityModel> {
    @Override
    public int compare(CityModel cityModel, CityModel cityModel2) {
        return cityModel.getName().compareToIgnoreCase(cityModel2.getName());
    }
}