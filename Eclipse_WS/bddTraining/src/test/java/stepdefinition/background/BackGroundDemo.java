/*
 * package stepdefinition.background;
 * 
 * import java.util.List; import java.util.Map; import
 * java.util.concurrent.TimeUnit;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.interactions.Actions; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait; import org.testng.Assert;
 * 
 * import io.cucumber.datatable.DataTable; import io.cucumber.java.en.Given;
 * import io.cucumber.java.en.Then; import io.cucumber.java.en.When; import
 * io.github.bonigarcia.wdm.WebDriverManager;
 * 
 * public class BackGroundDemo {
 * 
 * WebDriver driver = null;
 * 
 * @Given("user create a browser instance") public void
 * user_create_a_browser_instance() { // Write code here that turns the phrase
 * above into concrete actions WebDriverManager.chromedriver().setup(); driver =
 * new ChromeDriver(); driver.manage().timeouts().implicitlyWait(30,
 * TimeUnit.SECONDS); driver.manage().window().maximize(); }
 * 
 * @Given("launch actitime application") public void
 * launch_actitime_application() { // Write code here that turns the phrase
 * above into concrete actions driver.get("http://localhost/login.do"); }
 * 
 * @When("user enters valid {string} and {string}") public void
 * user_enters_valid_and(String string, String string2) { // Write code here
 * that turns the phrase above into concrete actions
 * driver.findElement(By.id("username")).sendKeys(string);
 * driver.findElement(By.name("pwd")).sendKeys(string2);
 * 
 * }
 * 
 * @When("click on login button") public void click_on_login_button() { // Write
 * code here that turns the phrase above into concrete actions
 * driver.findElement(By.id("loginButton")).click(); try { Thread.sleep(5000); }
 * catch (InterruptedException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } }
 * 
 * @Then("User should be on dashboard page") public void
 * user_should_be_on_dashboard_page() { // Write code here that turns the phrase
 * above into concrete actions Assert.assertEquals(driver.getTitle(),
 * "actiTIME - Enter Time-Track"); }
 * 
 * @Given("(u/U)ser is on dashboard page") public void
 * user_is_on_dashboard_page() { Assert.assertEquals(driver.getTitle(),
 * "actiTIME - Enter Time-Track"); }
 * 
 * @Given("User is loggedin to the actitime application using {string} and {string}"
 * ) public void user_is_loggedin_to_the_actitime_application_using_and(String
 * un, String pwd) throws InterruptedException {
 * 
 * }
 * 
 * @When("User click on tasks tab") public void user_click_on_tasks_tab() {
 * driver.findElement(By.xpath("//div[text()='TASKS']/parent::a")).click(); }
 * 
 * @Then("User is navigated to tasks page") public void
 * user_is_navigated_to_tasks_page() { Assert.assertEquals(driver.getTitle(),
 * "actiTIME - Task List");
 * 
 * }
 * 
 * @When("User click on Add new customer button") public void
 * user_click_on_add_new_customer_button() throws InterruptedException {
 * driver.findElement(By.xpath("//div[@class='addNewContainer']")).click();
 * driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click(
 * ); Thread.sleep(2000); }
 * 
 * @Then("Create customer page is displayed") public void
 * create_customer_page_is_displayed() {
 * Assert.assertEquals(driver.findElement(By.id(
 * "customerLightBox_titlePlaceholder")).getText(), "Create New Customer");
 * 
 * }
 * 
 * @When("User enters {string} and  {string} and click on create cutomer button"
 * ) public void user_enters_and_and_click_on_create_cutomer_button(String cn,
 * String cd) {
 * driver.findElement(By.id("customerLightBox_nameField")).sendKeys(cn);
 * driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(cd);
 * driver.findElement(By.id("customerLightBox_commitBtn")).click();
 * 
 * }
 * 
 * @Then("success message should be displayed and disappeared") public void
 * success_message_should_be_displayed_and_disappeared() {
 * 
 * }
 * 
 * @Then("user validates the message") public void user_validates_the_message()
 * {
 * 
 * WebDriverWait wait = new WebDriverWait(driver, 20); WebElement successMsg =
 * wait .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
 * "//div[@class='toast']")))); System.out.println(successMsg.getText());
 * wait.until(ExpectedConditions.invisibilityOf(successMsg));
 * 
 * }
 * 
 * @Then("logout from the application") public void
 * logout_from_the_application() {
 * driver.findElement(By.id("logoutLink")).click(); driver.close(); }
 * 
 * @When("User enters customername and customerdescription repeatedly to create mulitple customer"
 * ) public void
 * user_enters_customername_and_customerdescription_repeatedly_to_create_mulitple_customer(
 * DataTable dataTable) throws InterruptedException { List<Map<String, String>>
 * data = dataTable.asMaps(); String cn, cd; for (int i = 0; i < data.size();
 * i++) {
 * 
 * cn = data.get(i).get("customername"); cd = data.get(i).get("customerdesc");
 * driver.findElement(By.xpath("//div[@class='addNewContainer']")).click();
 * driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click(
 * ); WebDriverWait wait = new WebDriverWait(driver, 20);
 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(
 * "customerLightBox_nameField"))));
 * driver.findElement(By.id("customerLightBox_nameField")).sendKeys(cn);
 * driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(cd);
 * driver.findElement(By.id("customerLightBox_commitBtn")).click();
 * 
 * WebElement successMsg = wait
 * .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
 * "//div[@class='toast']")))); System.out.println(successMsg.getText());
 * wait.until(ExpectedConditions.invisibilityOf(successMsg));
 * 
 * }
 * 
 * }
 * 
 * @When("User enters customername and customerdescription repeatedly as list to create mulitple customer"
 * ) public void
 * user_enters_customername_and_customerdescription_repeatedly_as_list_to_create_mulitple_customer(
 * DataTable dataTable) throws InterruptedException { List<List<String>> data =
 * dataTable.asLists(); String cn, cd; for (int i = 0; i < data.size(); i++) {
 * cn = data.get(i).get(0); cd = data.get(i).get(1);
 * driver.findElement(By.xpath("//div[@class='addNewContainer']")).click();
 * driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click(
 * ); WebDriverWait wait = new WebDriverWait(driver, 20);
 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(
 * "customerLightBox_nameField"))));
 * driver.findElement(By.id("customerLightBox_nameField")).sendKeys(cn);
 * driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(cd);
 * driver.findElement(By.id("customerLightBox_commitBtn")).click();
 * 
 * WebElement successMsg = wait
 * .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
 * "//div[@class='toast']")))); System.out.println(successMsg.getText());
 * wait.until(ExpectedConditions.invisibilityOf(successMsg));
 * 
 * }
 * 
 * }
 * 
 * @When("User enters customername and customerdescription as mapdata") public
 * void user_enters_customername_and_customerdescription_as_mapdata(DataTable
 * dataTable) throws InterruptedException { Map<String, String> data =
 * dataTable.asMap(String.class, String.class);
 * 
 * System.out.println(data.keySet()); String cn = data.get("customerName");
 * String cd = data.get("customerDesc");
 * 
 * driver.findElement(By.xpath("//div[@class='addNewContainer']")).click();
 * driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click(
 * ); WebDriverWait wait = new WebDriverWait(driver, 20);
 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(
 * "customerLightBox_nameField"))));
 * driver.findElement(By.id("customerLightBox_nameField")).sendKeys(cn);
 * driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(cd);
 * driver.findElement(By.id("customerLightBox_commitBtn")).click();
 * 
 * WebElement successMsg = wait
 * .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
 * "//div[@class='toast']")))); System.out.println(successMsg.getText());
 * wait.until(ExpectedConditions.invisibilityOf(successMsg));
 * 
 * }
 * 
 * @When("User enters customername and customerdescription as listdata") public
 * void user_enters_customername_and_customerdescription_as_listdata(DataTable
 * dataTable) throws InterruptedException { List<String> data =
 * dataTable.asList();
 * 
 * String cn = data.get(0); String cd = data.get(1);
 * driver.findElement(By.xpath("//div[@class='addNewContainer']")).click();
 * driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click(
 * ); WebDriverWait wait = new WebDriverWait(driver, 20);
 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(
 * "customerLightBox_nameField"))));
 * driver.findElement(By.id("customerLightBox_nameField")).sendKeys(cn);
 * driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(cd);
 * driver.findElement(By.id("customerLightBox_commitBtn")).click();
 * 
 * WebElement successMsg = wait
 * .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
 * "//div[@class='toast']")))); System.out.println(successMsg.getText());
 * wait.until(ExpectedConditions.invisibilityOf(successMsg));
 * 
 * }
 * 
 * /// --------------------------Delete customer --------------------
 * 
 * @When("user search for the customer {string}") public void
 * user_search_for_the_customer(String string) { driver.findElement( By.
 * xpath("//div[@class='customersProjectsPanel']//input[@placeholder='Start typing name ...']"
 * )) .sendKeys(string); }
 * 
 * @Then("customer with {string} should be displayed") public void
 * customer_with_usersearch_should_be_displayed(String cn) {
 * 
 * int serachCount = driver .findElements(By
 * .xpath("//div[@class='itemsContainer']//div[@class='title' and contains(text(),'"
 * + cn + "')]")) .size();
 * 
 * if (serachCount >= 1) { Assert.assertTrue(true); } else {
 * Assert.assertFalse(true); }
 * 
 * }
 * 
 * @When("user moves the mouse on the gear icon next to {string} and click on it"
 * ) public void
 * user_moves_the_mouse_on_the_gear_icon_next_to_and_click_on_it(String string)
 * { Actions act = new Actions(driver); act.moveToElement(driver.findElement(
 * By.
 * xpath("//div[@class='itemsContainer']//div[@class='title' and contains(text(),'"
 * + string + "')]"))) .perform();
 * 
 * act.click(driver.findElement(By.
 * xpath("//div[@class='itemsContainer']//div[@class='title' and contains(text(),'"
 * + string + "')]/following-sibling::div"))).perform(); WebDriverWait wait =
 * new WebDriverWait(driver, 10);
 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
 * "//div[@class='customerNamePlaceHolder']/following-sibling::div/div[@class='actionButtonWrapper']"
 * ))));
 * 
 * }
 * 
 * @When("user click on Action and delete") public void
 * user_click_on_action_and_delete() throws InterruptedException { //
 * WebDriverWait wait = new WebDriverWait(driver, 20); // WebElement ele =
 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
 * "//div[@class='customerNamePlaceHolder']/following-sibling::div/div[@class='actionButtonWrapper']"
 * )))); // ele.click(); Thread.sleep(3000); driver.findElement(By.xpath(
 * "//div[@class='customerNamePlaceHolder']/following-sibling::div")).click(); ;
 * 
 * driver.findElement(By.xpath(
 * "//div[div[@class='customerNamePlaceHolder']]/following-sibling::div[@class='dropdownContainer actionsMenu']//div[text()='Delete']"
 * )) .click();
 * 
 * }
 * 
 * @When("click on delete permanently") public void
 * click_on_delete_permanently() {
 * driver.findElement(By.id("customerPanel_deleteConfirm_submitTitle")).click();
 * 
 * }
 * 
 * @Then("user validates the customer deletion") public void
 * user_validates_the_customer_deletion() { WebDriverWait wait = new
 * WebDriverWait(driver, 20);
 * 
 * WebElement deletionMsg = wait
 * .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
 * "//div[@class='toast']")))); System.out.println(deletionMsg.getText());
 * wait.until(ExpectedConditions.invisibilityOf(deletionMsg)); }
 * 
 * }
 */