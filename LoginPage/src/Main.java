import java.io.FileNotFoundException;

public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("Hello World");
		
		IdandPasswords idandPasswords = new IdandPasswords();
		
		//idandPasswords.addToFile("Nathan", "123");
		idandPasswords.check("Nathan", "123");

		
		LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());

	}
}