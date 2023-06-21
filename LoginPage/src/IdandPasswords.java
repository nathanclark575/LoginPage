import java.util.HashMap;

public class IdandPasswords
{
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	IdandPasswords()
	{
		loginInfo.put("Grace", "Grace");
		loginInfo.put("brometheus", "PASSWORD");
		loginInfo.put("brocode", "abc123");
	}
	
	// My change to the code is to have <String, String> for the HashMap Type
	protected HashMap<String, String> getLoginInfo()
	{
		return loginInfo;
	}
}
