package com.cybertek.steps;
import com.cybertek.pages.MainPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.ExcelUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;


public class ExportingXLSSteps  {

    String file = "./src/test/resources/test_data/table_07-02_1 (39).xlsx";
//    String sheet = "7-2";
    String sheet = "Sayfa1";
    MainPage mainPage =new MainPage();
    ExcelUtil energy = new ExcelUtil(file, sheet);
    String fileDownloaded =ConfigurationReader.getProperty("filePath");





    @Given("user goes to the main page {string}")
    public void user_goes_to_the_main_page(String string) {
        string = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(string);
    }

    @When("the correct page loads")
    public void the_correct_page_loads() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = ConfigurationReader.getProperty("pageTitle");
        BrowserUtils.wait(5);
        Assert.assertEquals("page title is wrong",actualTitle,expectedTitle);
    }

    @Then("user clicks on the link to download the table")
    public void user_clicks_on_the_link_to_download_the_table() {
        mainPage.tableLink.click();
    }



    @Then("user controls if the excel table is downloaded")
    public void user_controls_if_the_excel_table_downloaded() {

        Assert.assertTrue("file is not downloaded", Files.exists(Paths.get(fileDownloaded)));
    }

    @Then("controls if the column A contains the following {string}")
    public void controls_if_the_column_A_contains_the_following(String string)  {
//        System.out.println(energy.rowCount());
//        System.out.println(energy.getColumnsNames());
//        System.out.println(energy.columnCount());
        List<Map<String, String>> myListe = energy.getDataList();

//        System.out.println(myListe.get(15).get("State"));
        boolean exist=false;
        for (Map<String,String > row:myListe) {

            if(row.get("State").equals(string)){
//                System.out.println(row.get("State"));
//                System.out.println(string);
                exist=true;
               break;
            }

        }
        Assert.assertTrue("this state does not exist ",exist);
        }



    @Then("user verifies the summation of the energy consumed by all states is equal to {double}")
    public void user_verifies_the_summation_of_the_energy_consumed_by_all_states_is_equal_to(Double sumExpected) {

    }

    @Then("user records the most energy consuming state in transportation")
    public String user_records_the_most_energy_consuming_state_in_transportation() {


            return null;

    }



    @Then("user records the least energy consuming state in residential")
    public String user_records_the_least_energy_consuming_state_in_residential() {




        return null;

    }

    @Then("user records the most energy consuming state in commercial")
    public String  user_records_the_most_energy_consuming_state_in_commercial() {

        return null;

}

    @Then("user records the least energy consuming state in industrial")
    public String user_records_the_least_energy_consuming_state_in_industrial() {




        return null;

    }

}
