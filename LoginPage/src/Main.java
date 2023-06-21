
public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Hello World");
		
		IdandPasswords idandPasswords = new IdandPasswords();

		
		LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());
	}
}