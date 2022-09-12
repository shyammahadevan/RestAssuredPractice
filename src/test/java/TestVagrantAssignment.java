import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class TestVagrantAssignment {
    Utility utility = new Utility();
    String filePath = "src/main/java/JSONFiles/RCBTeam.json";

    @Test(description = "TC 01: Test case that validates that the team has only 4 foreign players")
    public void testCase_01() throws IOException {
        List<String> countryList = utility.getTheListOfValues(utility.getJsonFile(filePath), "player", "country");
        int countryCount = 0;
        if (!countryList.isEmpty()) {
            for (String values : countryList) {
                if (!values.contains("India")) {
                    countryCount++;
                }
            }
        }
        if (countryCount == 4) {
            System.out.println("Sufficient foreign players are available" + " \n" + "Total foreign players count = " + countryCount);
        } else
            System.out.println("No Sufficient foreign players or more foreign players ");

    }


    @Test(description = "TC 02: Test case that validates that the team has at least one wicket keeper ")
    public void testCase_02() throws IOException {
        List<String> roleList = utility.getTheListOfValues(utility.getJsonFile(filePath), "player", "role");
        boolean flag = false;
        if (!roleList.isEmpty()) {
            for (String values : roleList) {
                if (values.contains("Wicket-keeper")) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("Wicket-keeper is available ");
        } else
            System.out.println("One Wicket-keeper is mandatory ");

    }


}
