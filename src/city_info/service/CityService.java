package city_info.service;

import city_info.model.CityModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CityService {

    public static List<CityModel> readFile() {
        File file = new File("src/info_city_list/city_ru.csv");
        List<CityModel> cityModelList = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            cityModelList = new ArrayList<>();
            while (reader.ready()) {
                cityModelList.add(parse(reader.readLine()));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityModelList;
    }

    private static Map<String, Integer> regionCityCalculate() {
        List<CityModel> regionCityList = readFile();
        Map<String, Integer> counter = new HashMap<>();
        for (CityModel cityModel : regionCityList) {
            String region = cityModel.getRegion();
            int newValue = counter.getOrDefault(region, 0) + 1;
            counter.put(region, newValue);
        }
        return counter;
    }

    private static CityModel parse(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        scanner.skip("\\d+\\s*;");
        String name = scanner.next().trim();
        String region = scanner.next().trim();
        scanner.close();
        return new CityModel(name, region);
    }

    public static void printCountList() {
        regionCityCalculate().forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
