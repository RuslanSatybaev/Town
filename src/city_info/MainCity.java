package city_info;

import java.io.IOException;

import static city_info.service.CityService.printList;

public class MainCity {
    public static void main(String[] args) throws IOException {
        //Press firstCondition or secondCondition
        String condition = "secondCondition";
        printList(condition);
    }
}
