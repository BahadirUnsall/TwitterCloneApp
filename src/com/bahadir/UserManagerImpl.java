package com.bahadir;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManagerImpl implements IUserManager{
	static Scanner scanner = new Scanner(System.in);
	static List<User> userList = new ArrayList<User>();
	
	public static final String COLOR_YELLOW = "\u001B[33m";
	public static final String COLOR_RESET = "\u001B[0m";
	public static final String COLOR_ERROR = "\u001B[31m";
	public static final String COLOR_SUCCESS = "\u001B[32m";
	public static final String COLOR_BLUE = "\u001B[36m";

	
	@Override
	public void register() {
		
		System.out.print(COLOR_YELLOW+"username: " + COLOR_RESET);
		String username = scanner.nextLine();
		System.out.print(COLOR_YELLOW + "Password: "+ COLOR_RESET);
		String password = scanner.nextLine();
		System.out.print(COLOR_YELLOW + "Repassword: " + COLOR_RESET);
		String repassword = scanner.nextLine();
		if (!password.equals(repassword)) {
			System.out.println(COLOR_ERROR + "Şifreler uyumsuz!" + COLOR_RESET);
			return;
		}
		System.out.print(COLOR_YELLOW + "Telefon: " + COLOR_RESET);
		String telefon = scanner.nextLine();
		
		userList.add(new User(username, repassword, telefon));
		System.out.println(COLOR_SUCCESS + "Başarıyla kayıt olundu." + COLOR_RESET);
		
	}
	
	@Override
	public User login() {
		
		System.out.print(COLOR_YELLOW + "username: " + COLOR_RESET);
		String username = scanner.nextLine();
		System.out.print(COLOR_YELLOW + "Password: " + COLOR_RESET);
		String password = scanner.nextLine();
		
		for (User user : userList) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				System.out.println(COLOR_SUCCESS + "Hoşgeldiniz " + COLOR_RESET + user.getUsername());
				return user;
			}
		}
		return null;
	}

	@Override
	public void tweetAt(User user) {
		System.out.print(COLOR_YELLOW + "Tweetinizi girin : "+COLOR_RESET);
		String icerik = scanner.nextLine();
		
		user.getProfile().getTweets().add(new Tweet(icerik));
		
		System.out.println(COLOR_SUCCESS + "Tweeetiniz -> " +COLOR_RESET + icerik);
	}
	
	@Override
	public void tweeteYorumYap() {
			
		for (User item : userList) {
			if (!item.getUsername().equals("admin")) {
				System.out.println(COLOR_YELLOW + "username : " + item.getUsername() + " = " + COLOR_RESET + item.getProfile().getTweets());
			}
		}
		
		System.out.println(COLOR_YELLOW + "Hangi userın tweetine yorum yapıcaksınız?" + COLOR_RESET);
		String username = scanner.nextLine();
		
		System.out.println(COLOR_YELLOW + "Hangi tweete yorum yapıcaksınız? (ID)" + COLOR_RESET);
		int id = scanner.nextInt();scanner.nextLine();
		
		System.out.print( COLOR_YELLOW + "Yorum yap : " + COLOR_RESET);
		String icerik = scanner.nextLine();
		
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUsername().equals(username)) {
				for (int j = 0; j < userList.get(i).getProfile().getTweets().size(); j++) {
					if (userList.get(i).getProfile().getTweets().get(j).getId() == id) {
						userList.get(i).getProfile().getTweets().get(j).getYorumlarList().add(new Yorum(icerik));
						System.out.println(userList.get(i).getProfile().getTweets().get(j).getIcerik() + COLOR_SUCCESS + " tweetine " + "'" + COLOR_RESET + icerik + COLOR_SUCCESS+"'" + " yorumu yapıldı." + COLOR_RESET);
						userList.get(i).getProfile().getTweets().get(j).setYorumSayisi(userList.get(i).getProfile().getTweets().get(j).getYorumSayisi()+1);
						return;
					}
				}
			}
		}
		System.out.println(COLOR_ERROR + "Yorum yapılamadı!" + COLOR_RESET);
		
	}

	@Override
	public void tweetiSil(User user) {
		
		for (User item : userList) {
			System.out.println(COLOR_YELLOW + "Tweetleriniz: " + COLOR_RESET);
			System.out.println(COLOR_BLUE + user.getProfile().getTweets() + COLOR_RESET);
			break;
		}
		
		System.out.println(COLOR_YELLOW + "Hangi tweeti silmek istiyorsunuz ?  (ID)" + COLOR_RESET);
		int id =scanner.nextInt();scanner.nextLine();
		
		for (int i = 0; i < user.getProfile().getTweets().size() + 1; i++) {
			if (user.getProfile().getTweets().get(i).getId() == id) {
				System.out.println(user.getProfile().getTweets().get(i).getIcerik() + COLOR_SUCCESS + " tweeti silindi.." + COLOR_RESET);
				user.getProfile().getTweets().remove(i);
				return;
			}
		}
		
	}

	@Override
	public void kendiTweetlerimiGoster(User user) {
		
		for (User item : userList) {
			if (user.getProfile().getTweets().size() != 0) {
				if (userList.contains(user)) {
					for (int i = 0; i < user.getProfile().getTweets().size(); i++) {
						System.out.println((i+1)+ ". " +  user.getProfile().getTweets().get(i).getIcerik());
					}
					return;
				}
			}else {
				System.out.println(COLOR_ERROR + "Tweetiniz bulunmuyor!" + COLOR_RESET);
				return;
			}
			
		}
		
	}

	@Override
	public void profiliGoruntule(String username) {
		
		for (User user : userList) {
			if (user.getUsername().equals(username) && user.getStatus().ordinal() == 1) {
				System.out.println(user.getUsername()+ COLOR_YELLOW + " adlı kullanıcının profili -> " + COLOR_RESET + COLOR_BLUE + user.getProfile() + COLOR_RESET);
				return;
				}
			}
		System.out.println(COLOR_ERROR + "Böyle bir kullanıcı bulunamadı." + COLOR_RESET);
		}

	@Override
	public void mesajGonder(String username,String message) {
		for (User user : userList) {
			if (user.getUsername().equals(username)) {
				user.getProfile().getDmKutusu().put(username, message);
				System.out.println(username + COLOR_YELLOW + " Adlı Kullanıcıya Mesajınız -> " + COLOR_RESET + message);
				return;
			}
		}
		System.out.println(COLOR_ERROR + "Böyle bir kullanıcı yok." + COLOR_RESET);
	}

	@Override
	public void mesajlariGoruntule(User user) {
		System.out.println(user.getProfile().getDmKutusu().values());
		
	}

	@Override
	public void kullaniciEngelle(String username) {
		for (User user : userList) {
			if (user.getUsername().equals(username)) {
				user.setStatus(EStatus.BANNED);
				return;
			}
		}
		System.out.println(COLOR_ERROR + "Böyle bir kullanıcı bulunamadı!" + COLOR_RESET);
	}
}
