package com.bahadir;

import java.util.Scanner;

public class TwitterRunner {
	static Scanner scanner = new Scanner(System.in);
	static UserManagerImpl userManagerImpl = new UserManagerImpl();
	static AdminManagerImpl adminManagerImpl = new AdminManagerImpl();
	public static final String COLOR_BLUE = "\u001B[36m";
	public static final String COLOR_RESET = "\u001B[0m";
	public static final String COLOR_YELLOW = "\u001B[33m";
	public static final String COLOR_ERROR = "\u001B[31m";
	
	
	public static void main(String[] args) {
		User u1 = new User("admin", "123");
		User u2 = new User("bahadır", "123");
		User u3 = new User("muhittin", "123");
		User u4 = new User("volkan", "123");
		
		UserManagerImpl.userList.add(u1);
		UserManagerImpl.userList.add(u2);
		UserManagerImpl.userList.add(u3);
		UserManagerImpl.userList.add(u4);
	
		
		systemMenu();
		
	}
	
	public static void systemMenu() {
		int secim; 
		while(true) {
			System.out.println(COLOR_BLUE + " /////////=\\\\\\\\\\\\\\\\");
			System.out.println("| 1-User işlemleri |");
			System.out.println("| 2-Admin işlemleri|");
			System.out.println("| 0-Cikis          |");
			System.out.println(" \\\\\\\\\\\\\\\\=/////////" +COLOR_RESET);
			
			System.out.print(COLOR_YELLOW + "Seçiminiz: " + COLOR_RESET);
			secim = scanner.nextInt();scanner.nextLine();
			
			switch (secim) {
			case 1:
				mainMenu();
				break;	
			case 2:
				adminMenu();
				break;
			case 0:
				System.out.println(COLOR_ERROR + "Sistemden çıkılıyor..." + COLOR_RESET);
				System.exit(0);
				break;
			default:
				System.out.println(COLOR_ERROR + "Geçersiz işlem..." + COLOR_RESET);
				break;
			}
		}
		
		
		
	}


	private static void mainMenu() {
		int secim; 
		while(true) {
			System.out.println(COLOR_BLUE + " /////////=\\\\\\\\\\\\\\\\");
			System.out.println("| 1-Register       |");
			System.out.println("| 2-Login          |");
			System.out.println("| 0-Geri gel       |");
			System.out.println(" \\\\\\\\\\\\\\\\=/////////" + COLOR_RESET);
			
			System.out.print(COLOR_YELLOW + "Seçiminiz: " + COLOR_RESET);
			secim = scanner.nextInt();scanner.nextLine();
			
			switch (secim) {
			case 1:
				userManagerImpl.register();
				break;	
			case 2:
				User user =userManagerImpl.login();		
				
				if (!user.equals(null)) {
					if (user.getUsername().equals("admin")) {
						adminMenu();
					}
					else {
						userMenu(user);
					}
				}else {
					System.out.println(COLOR_ERROR + "Kullanıcı bulunamadı!" + COLOR_RESET);
				}
				break;
			case 0:
				systemMenu();
				break;
			default:
				System.out.println(COLOR_ERROR + "Geçersiz işlem..." + COLOR_RESET);
				break;
			}
		}
	}

	private static void userMenu(User user) {
		
		
		int secim; 
		while(true) {
			System.out.println(COLOR_BLUE + " ////////////=\\\\\\\\\\\\\\\\\\\\");
			System.out.println("| 1-Tweet At            |");
			System.out.println("| 2-Tweete Yorum Yap    |");
			System.out.println("| 3-Tweeti Sil          |");
			System.out.println("| 4-Tweetlerimi Göster  |");
			System.out.println("| 5-Profili görüntüle   |");
			System.out.println("| 6-Mesaj Gönder        |");
			System.out.println("| 7-Mesajları Görüntüle |");
			System.out.println("| 8-Kullanıcı engelle   |");
			System.out.println("| 0-Geri Gel            |");
			System.out.println(" \\\\\\\\\\\\\\\\\\\\\\=///////////" + COLOR_RESET);
			
			System.out.print(COLOR_YELLOW + "Seçiminiz: " + COLOR_RESET);
			secim = scanner.nextInt();scanner.nextLine();
			String username;
			String message;
			
			switch (secim) {
			case 1:
				userManagerImpl.tweetAt(user);
				break;	
			case 2:
				userManagerImpl.tweeteYorumYap();
				break;
			case 3:
				userManagerImpl.tweetiSil(user);
				break;
			case 4:
				userManagerImpl.kendiTweetlerimiGoster(user);
				break;
			case 5:
				System.out.println(COLOR_YELLOW + "Hangi userin profilini görüntülemek istiyorsunuz?" + COLOR_RESET);
				username = scanner.nextLine();
				userManagerImpl.profiliGoruntule(username);
				break;
			case 6:
				System.out.println(COLOR_YELLOW + "Hangi kullanıcıya mesaj atmak istiyorsunuz?" + COLOR_RESET);
				username = scanner.nextLine();
				System.out.println(COLOR_YELLOW + "Mesajınızı yazın" + COLOR_RESET);
				message = scanner.nextLine();
				userManagerImpl.mesajGonder(username,message);
				break;
			case 7:
				userManagerImpl.mesajlariGoruntule(user);
				break;
			case 8:
				System.out.println(COLOR_YELLOW + "Hangi kullanıcıyı engellemek istiyorsunuz?" + COLOR_RESET);
				username = scanner.nextLine();
				userManagerImpl.kullaniciEngelle(username);
				break;
			case 0:
				mainMenu();
				break;
			default:
				System.out.println(COLOR_ERROR + "Geçersiz işlem..." + COLOR_RESET);
				break;
			}
		}
		
	}
	
	private static void adminMenu() {
		int secim; 
		while(true) {
			System.out.println(COLOR_BLUE + " /////////////=\\\\\\\\\\\\\\\\\\\\\\");
			System.out.println("| 1-Kullanıcıları Listele |");
			System.out.println("| 2-Profilleri Listele    |");
			System.out.println("| 0-Geri gel              |");
			System.out.println(" \\\\\\\\\\\\\\\\\\\\\\\\=////////////" + COLOR_RESET);
			
			System.out.print(COLOR_YELLOW + "Seçiminiz: " + COLOR_RESET);
			secim = scanner.nextInt();scanner.nextLine();
			
			switch (secim) {
			case 1:
				adminManagerImpl.userListele();
				break;	
			case 2:
				adminManagerImpl.profilleriListele();
				break;
			case 0:
				systemMenu();
				break;
			default:
				System.out.println(COLOR_ERROR + "Geçersiz işlem..." + COLOR_RESET);
				break;
			}
		}
	}
	
}
