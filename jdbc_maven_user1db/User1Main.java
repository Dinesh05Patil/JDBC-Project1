package jdbc_maven_user1db;

import java.util.Scanner;

import jdbc_maven_user1db.User1;

public class User1Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		User1 user1 = new User1();
		User1CRUD crud1 = new User1CRUD();
		
		
		int ch=0;
		boolean condition=true;
		do {
			System.out.println("Enter your choice \n 1.signup  \n 2.login  \n 3.exit ");
			 ch = sc.nextInt();
		switch (ch) {
		case 1: {
			System.out.println("Enter the id");
			int id = sc.nextInt();
			System.out.println("Enter the user name");
			String name = sc.next();
			System.out.println("Enter the email id");
			String email = sc.next();
			System.out.println("Enter the password ");
			String password = sc.next();
			System.out.println("Enter the address");
			String address = sc.next();
			System.out.println("Enter the facebook password");
			String facebookpwd = sc.next();
			System.out.println("Enter the insta password");
			String instapwd = sc.next();
			System.out.println("Enter the snapchat password");
			String snapchatkpwd = sc.next();
			System.out.println("Enter the whatsapp password");
			String whatsapppwd = sc.next();
			System.out.println("Enter the twitter password");
			String twitterpwd = sc.next();

			user1.setId(id);
			user1.setName(name);
			user1.setEmail(email);
			user1.setPassword(password);
			user1.setAddress(address);
			user1.setFacebookpwd(facebookpwd);
			user1.setInstapwd(instapwd);
			user1.setSnapchatpwd(snapchatkpwd);
			user1.setWhatsapppwd(whatsapppwd);
			user1.setTwiiterpwd(twitterpwd);

			try {
				crud1.signupUser(user1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

			break;
		case 2: {
			System.out.println("Enter the user name");
			String name = sc.next();
			System.out.println("Enter the password ");
			String password = sc.next();

			user1.setName(name);
			user1.setPassword(password);

			boolean result = crud1.loginUser(user1);
			if (result == true) {
				System.out.println("Logged in successfully");
			} else {
				System.out.println("invalid password");
			}

		 
		}break;
		
		case 3: {
			condition=false;
			System.out.println("exitted from app");
			break;
			
		}
		default:
			break;
		}
		}while(ch!=3);

	}

}
