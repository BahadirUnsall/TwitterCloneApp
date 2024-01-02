package com.bahadir;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profile{
	private String photo;
	private String bio;
	private int follower;
	private int following;
	private Adress adress;
	private Map<String, String> dmKutusu;
	private List<Tweet> tweets;
	private LocalDate registDate;
	
	public Profile() {
		super();
		this.dmKutusu = new HashMap<String, String>();
		this.tweets = new ArrayList<Tweet>();
		this.registDate= LocalDate.now();
		this.adress = new Adress("Ankara", "Türkiye", "Cadde", "06564");
	}
	
	public Profile(int follower, int following, Adress adress) {
		super();
		this.follower = follower;
		this.following = following;
		this.adress = adress;
		this.dmKutusu = new HashMap<String, String>();
		this.tweets = new ArrayList<Tweet>();
		this.registDate= LocalDate.now();
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public int getFollower() {
		return follower;
	}
	public void setFollower(int follower) {
		this.follower = follower;
	}
	public int getFollowing() {
		return following;
	}
	public void setFollowing(int following) {
		this.following = following;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
	public Map<String, String> getDmKutusu() {
		return dmKutusu;
	}
	public void setDmKutusu(Map<String, String> dmKutusu) {
		this.dmKutusu = dmKutusu;
	}
	public List<Tweet> getTweets() {
		return tweets;
	}
	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
	public LocalDate getRegistDate() {
		return registDate;
	}
	public void setRegistDate(LocalDate registDate) {
		this.registDate = registDate;
	}
	@Override
	public String toString() {
		return "Profile [photo=" + photo + ", bio=" + bio + ", follower=" + follower + ", following=" + following
				+ ", adress=" + adress + ", dmKutusu=" + dmKutusu + ", tweets=" + tweets + ", registDate=" + registDate
				+ "]";
	}
	
	
	
	
	
	
	
	
}
