package com.cybertek.steps;

import com.cybertek.pages.MainPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.cybertek.utilities.BrowserUtils.waitForPageToLoad;

public class ExportingXLSSteps {

    MainPage mainPage =new MainPage();
    String myPath= ConfigurationReader.getProperty("filePath");
    FileInputStream inputStream = new FileInputStream(myPath);
    XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
    XSSFSheet workSheet = workBook.getSheetAt(0);

    public ExportingXLSSteps() throws IOException {



}

    @Given("user goes to the main page {string}")
    public void user_goes_to_the_main_page(String string) {
        string = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(string);
    }

    @When("the correct page loads")
    public void the_correct_page_loads() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = ConfigurationReader.getProperty("pageTitle");
        waitForPageToLoad(3);
        Assert.assertEquals("page title is wrong",actualTitle,expectedTitle);
    }

    @Then("user clicks on the link to download the table")
    public void user_clicks_on_the_link_to_download_the_table() {
        mainPage.tableLink.click();
    }

    @Then("user controls if the excel table is downloaded")
    public void user_controls_if_the_excel_table_downloaded() {

        Assert.assertTrue("file is not downloaded", Files.exists(Paths.get(myPath)));
    }

    @Then("controls if the column A contains the following {string}")
    public void controls_if_the_column_A_contains_the_following(String string) throws IOException {

//        System.out.println( workSheet.getRow(15).getCell(0).toString());
        workBook.close();
        inputStream.close();

        boolean exist=false;
        for (int i = 5; i <=55 ; i++) {
            if (workSheet.getRow(i).getCell(0).toString().equals(string)){
//                System.out.println(workSheet.getRow(i).getCell(0).toString());
                exist=true;  break; }
        }
//        System.out.println(exist);
        Assert.assertTrue("all states exist",exist);

    }

    @Then("user verifies the summation of the energy consumed by all states is equal to {double}")
    public void user_verifies_the_summation_of_the_energy_consumed_by_all_states_is_equal_to(Double sumExpected) {

        double sumActual=0.0;
        sumExpected = 97162.3;

        for (int i = 5; i <=55 ; i++) {
            sumActual = sumActual+ Double.valueOf(workSheet.getRow(i).getCell(1).toString());
        }
        System.out.println(sumActual);
        System.out.println(sumExpected);
        Assert.assertTrue("sum is not correct",sumExpected==sumActual);// actually there is a bug here 97162.3 is a wrong value it was 97144.7 on the table

    }
    @Then("user records the most energy consuming state in transportation")
    public void user_records_the_most_energy_consuming_state_in_transportation() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

//    @Then("user records the least energy consuming state in residential")
//    public void user_records_the_least_energy_consuming_state_in_residential() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new cucumber.api.PendingException();
//    }
//
//    @Then("user records the most energy consuming state in commercial")
//    public void user_records_the_most_energy_consuming_state_in_commercial() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new cucumber.api.PendingException();
//    }
//
//    @Then("user records the least energy consuming state in industrial")
//    public void user_records_the_least_energy_consuming_state_in_industrial() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new cucumber.api.PendingException();
//    }
//
//    @Then("user verifies the summation of the cells B{int} to B{int} are written correctly at the cell B{int} as {double}")
//    public void user_verifies_the_summation_of_the_cells_B_to_B_are_written_correctly_at_the_cell_B_as(Integer int1, Integer int2, Integer int3, Double double1) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new cucumber.api.PendingException();
//    }
//
//    @Then("user verifies that total industrial consumtion is greater than total residential consumtion")
//    public void user_verifies_that_total_industrial_consumtion_is_greater_than_total_residential_consumtion() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new cucumber.api.PendingException();
//    }
//
//    @Then("user updates the the values as below")
//    public void user_updates_the_the_values_as_below(io.cucumber.datatable.DataTable dataTable) {
//        // Write code here that turns the phrase above into concrete actions
//        // For automatic transformation, change DataTable to one of
//        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//        // Double, Byte, Short, Long, BigInteger or BigDecimal.
//        //
//        // For other transformations you can register a DataTableType.
//        throw new cucumber.api.PendingException();
//    }

}
