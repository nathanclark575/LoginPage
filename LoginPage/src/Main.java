import java.io.FileNotFoundException;

// Token : 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

public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("Hello World");
		
		IdandPasswords idandPasswords = new IdandPasswords();
		
		//idandPasswords.addToFile("grace", "123");
		//idandPasswords.check("Nathan", "123");

		
		//LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
		
		LoginPage loginPage = new LoginPage();

	}
}