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

    public static Map<Integer, Integer> calculateIndexNumberMax() {
        Map<Integer, Integer> map = new HashMap<>();
        int indexOfMax = 0;
        int maxNumber;
        int[] array = listToArray();
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[indexOfMax]) {
                indexOfMax = i;
            }
        }
        Arrays.sort(array);
        maxNumber = Arrays.stream(array).max().getAsInt();
        map.put(indexOfMax, maxNumber);
        return map;
    }

    public static int[] listToArray() {
        int[] array = new int[readFile().size()];
        for (int i = 0; i < array.length; i++) {
            int arrays = readFile().get(i).getPopulation();
            array[i] = arrays;
        }
        return array;
    }

    private static CityModel parse(String line) {
        Scanner scanner = new Scanner(line);
        scanner.skip("\\d+\\s*;\\s.+\\s*;\\s.+\\s*;\\s[А-я\\-]+\\s*;\\s*");
        int population = Integer.parseInt(scanner.next().trim());
        scanner.close();
        return new CityModel(population);
    }

    public static void printList() {
        calculateIndexNumberMax().forEach((key, value) -> System.out.println("[" + key + "]=" + value));
    }
}
