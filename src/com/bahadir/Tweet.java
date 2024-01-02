package com.bahadir;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tweet {
	static Random rnd = new Random();
	private int id;
	private String icerik;
	private LocalDate olusturulmaDate;
	private int begeniSayisi;
	private int yorumSayisi;
	private EHashtag hashtag;
	private List<User> begenenlerList;
	private List<Yorum> yorumlarList;
	
	public Tweet(String icerik) {
		super();
		this.icerik = icerik;
		this.olusturulmaDate = LocalDate.now();
		this.begenenlerList = new ArrayList<User>();
		this.yorumlarList = new ArrayList<Yorum>();
		this.id = rnd.nextInt(10000);
	}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Yorum> getYorumlarList() {
		return yorumlarList;
	}

	public void setYorumlarList(List<Yorum> yorumlarList) {
		this.yorumlarList = yorumlarList;
	}

	public String getIcerik() {
		return icerik;
	}
	public void setIcerik(String icerik) {
		this.icerik = icerik;
	}
	public LocalDate getOlusturulmaDate() {
		return olusturulmaDate;
	}
	public void setOlusturulmaDate(LocalDate olusturulmaDate) {
		this.olusturulmaDate = olusturulmaDate;
	}
	public int getBegeniSayisi() {
		return begeniSayisi;
	}
	public void setBegeniSayisi(int begeniSayisi) {
		this.begeniSayisi = begeniSayisi;
	}
	public int getYorumSayisi() {
		return yorumSayisi;
	}
	public void setYorumSayisi(int yorumSayisi) {
		this.yorumSayisi = yorumSayisi;
	}
	public EHashtag getHashtag() {
		return hashtag;
	}
	public void setHashtag(EHashtag hashtag) {
		this.hashtag = hashtag;
	}
	public List<User> getBegenenlerList() {
		return begenenlerList;
	}
	public void setBegenenlerList(List<User> begenenlerList) {
		this.begenenlerList = begenenlerList;
	}

	@Override
	public String toString() {
		return "\nTweet [id=" + id + ", icerik=" + icerik + ", olusturulmaDate=" + olusturulmaDate + ", yorumSayisi="
				+ yorumSayisi + ", yorumlarList=" + yorumlarList + "]";
	}

	

	
	
	
	
}
