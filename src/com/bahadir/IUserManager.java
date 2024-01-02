package com.bahadir;

public interface IUserManager {
	void register();
	User login();
	void tweetAt(User user);
	void tweeteYorumYap();
	void tweetiSil(User user);
	void kendiTweetlerimiGoster(User user);
	void profiliGoruntule(String username);
	void mesajGonder(String username,String message);
	void mesajlariGoruntule(User user);
	void kullaniciEngelle(String username);
	
	
}
