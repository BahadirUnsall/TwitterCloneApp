package com.bahadir;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Message {
	private User gonderen;
	private LocalDate gondermeZamani;
	private String icerik;
	public Message(User gonderen,String icerik) {
		super();
		this.gonderen = gonderen;
		this.icerik = icerik;
		this.gondermeZamani = LocalDate.now();
	}
	public User getGonderen() {
		return gonderen;
	}
	public void setGonderen(User gonderen) {
		this.gonderen = gonderen;
	}
	public LocalDate getGondermeZamani() {
		return gondermeZamani;
	}
	public void setGondermeZamani(LocalDate gondermeZamani) {
		this.gondermeZamani = gondermeZamani;
	}
	@Override
	public String toString() {
		return "Message [gonderen=" + gonderen + ", gondermeZamani=" + gondermeZamani + "]";
	}
	
	
	
	
}
