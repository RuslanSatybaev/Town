package city_info.service;

import city_info.comparator.DistrictComparator;
import city_info.comparator.NameComparator;
import city_info.model.CityModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityService {

    public static List<CityModel> readFile(String condition) throws IOException {
        NameComparator nameComparator = new NameComparator();
        DistrictComparator districtComparator = new DistrictComparator();
        File file = new File("src/info_city_list/city_ru.csv");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        List<CityModel> cityModelList = new ArrayList<>();
        while (reader.ready()) {
            cityModelList.add(parse(reader.readLine()));
        }
        if (condition.equals("firstCondition")) {
            cityModelList.sort(nameComparator);
        } else if (condition.equals("secondCondition")) {
            cityModelList.sort(districtComparator);
            cityModelList.sort(nameComparator);
        }

        reader.close();
        return cityModelList;
    }

    private static CityModel parse(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        scanner.skip("\\d*");
        String name1 = scanner.next();
        String name = scanner.next().trim();
        String region = scanner.next().trim();
        String district = scanner.next().trim();
        int population = 14;
        String foundation = null;
        if (scanner.hasNext()) {
            foundation = scanner.next().trim();
        }
        scanner.close();

        return new CityModel(name, region, district, population, foundation);
    }

    public static void printList(String condition) throws IOException {
        readFile(condition).forEach(System.out::println);
    }
}
