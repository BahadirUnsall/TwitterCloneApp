package com.bahadir;

public class AdminManagerImpl implements IAdminManager{
	public static final String COLOR_SUCCESS = "\u001B[32m";
	public static final String COLOR_RESET = "\u001B[0m";

	@Override
	public void userListele() {
		UserManagerImpl.userList.stream().filter(o->!o.getUsername().equals("admin")).forEach(o-> System.out.println(COLOR_SUCCESS + "Username: "+o.getUsername() + " | " + "Telefon: " +o.getTelefon() + " | " + "Durum: "+ o.getStatus()+ COLOR_RESET));
	}

	@Override
	public void profilleriListele() {
		UserManagerImpl.userList.stream().filter(o->!o.getUsername().equals("admin")).forEach(o->System.out.println(COLOR_SUCCESS + "Username: "+o.getUsername() +" | " + "Follower: " + o.getProfile().getFollower() +
											" | " + "Following: " + o.getProfile().getFollowing() + " | " + "Adress: " + o.getProfile().getAdress().getCity() +
											" | " + "Tweets: " + o.getProfile().getTweets() + " | " + "RegistDate: " + o.getProfile().getRegistDate() + COLOR_RESET));
	}

}
