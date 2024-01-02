package com.bahadir;

public class User {
	
	private String username;
	private String password;
	private String telefon;
	private Profile profile;
	private EStatus status;
	
	
	
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.profile = new Profile();
		this.status = EStatus.UNBANNED;
	}
	public User(String username, String password, String telefon) {
		super();
		this.username = username;
		this.password = password;
		this.telefon = telefon;
		this.profile = new Profile();
		this.status = EStatus.UNBANNED;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public EStatus getStatus() {
		return status;
	}
	public void setStatus(EStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", telefon=" + telefon + ", profile=" + profile
				+ "]";
	}
	
	
}
