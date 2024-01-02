package com.bahadir;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Yorum {
	private String icerik;
	private LocalDate yorumTarihi;
	private int begeniSayisi;
	private List<User> yorumBegenenler;
	public Yorum(String icerik) {
		super();
		this.icerik = icerik;
		this.yorumTarihi = LocalDate.now();
		this.yorumBegenenler = new ArrayList<User>();
	}
	public String getIcerik() {
		return icerik;
	}
	public void setIcerik(String icerik) {
		this.icerik = icerik;
	}
	public LocalDate getYorumTarihi() {
		return yorumTarihi;
	}
	public void setYorumTarihi(LocalDate yorumTarihi) {
		this.yorumTarihi = yorumTarihi;
	}
	public int getBegeniSayisi() {
		return begeniSayisi;
	}
	public void setBegeniSayisi(int begeniSayisi) {
		this.begeniSayisi = begeniSayisi;
	}
	public List<User> getYorumBegenenler() {
		return yorumBegenenler;
	}
	public void setYorumBegenenler(List<User> yorumBegenenler) {
		this.yorumBegenenler = yorumBegenenler;
	}
	@Override
	public String toString() {
		return "Yorum [icerik=" + icerik + ", yorumTarihi=" + yorumTarihi + ", begeniSayisi=" + begeniSayisi
				+ ", yorumBegenenler=" + yorumBegenenler + "]";
	}
	
	
	
	
}
