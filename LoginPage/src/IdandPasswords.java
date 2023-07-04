import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class IdandPasswords
{
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	// make it so they are updated on a file.
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
	
	// Add login info
	void addUser(String userID, String userPassword)
	{
		loginInfo.put(userID, userPassword);
	}
	
	
	// write a dic entry to file
	public void addToFile(String userID, String password)
	{
		// make a hashmap entry with userID:password
		//Map.Entry<String, String> entry = new Map.Entry<String, String>();
		//map.put(userID, password);
			
		// open the file and append to it
		File file = new File("text.txt");
		BufferedWriter bf = null;
			
		try
		{
			// the true states that the file exists and causes it to append, instead of re-writing the file
			bf = new BufferedWriter(new FileWriter(file, true));
				
			bf.write(userID + ":" + password);
			bf.newLine();
				
			System.out.println("Done");
				
			bf.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				bf.close();
				System.out.println("Done all of it");
			}
			catch (Exception e)
			{
					
			}
		}
		
	}
		
	// read the file
	public void readFile() throws FileNotFoundException
	{
			
		ArrayList<String> lst = new ArrayList<String>();
		File file = new File("text.txt");
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine())
		{
			lst.add(scan.nextLine());
		}
			
		scan.close();
			
		System.out.println(lst);
		System.out.println(file.getAbsolutePath());
	}
		
	// check userID and password combo
	public void check(String userID, String password) throws FileNotFoundException
	{
		File file = new File("text.txt");
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine())
		{
			String data = scan.nextLine();
			String[] parts = data.split(":");
				
			if (userID.equals(parts[0]) && password.equals(parts[1]))
			{
				System.out.println("Correct");
				return;
			}

		}
			
		System.out.println("Incorrect");
		return;
	}
		
}
