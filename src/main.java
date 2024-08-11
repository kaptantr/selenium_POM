
public class main {

	public static void main(String[] args) {
		// Setup Webdriver
		POM.setup();
		POM.wait(1000);
		
		// Actions
		POM.openLoginPage();
		POM.inputDatasInLoginPage();
		
		// Quit Webdriver
		POM.wait(1000);
		POM.tear();
	}

}
