package com.codes.amr.nearbyplaces.data.model;

public class Stats{
	private int visitsCount;
	private int checkinsCount;
	private int usersCount;
	private int tipCount;

	public void setVisitsCount(int visitsCount){
		this.visitsCount = visitsCount;
	}

	public int getVisitsCount(){
		return visitsCount;
	}

	public void setCheckinsCount(int checkinsCount){
		this.checkinsCount = checkinsCount;
	}

	public int getCheckinsCount(){
		return checkinsCount;
	}

	public void setUsersCount(int usersCount){
		this.usersCount = usersCount;
	}

	public int getUsersCount(){
		return usersCount;
	}

	public void setTipCount(int tipCount){
		this.tipCount = tipCount;
	}

	public int getTipCount(){
		return tipCount;
	}

	@Override
 	public String toString(){
		return 
			"Stats{" + 
			"visitsCount = '" + visitsCount + '\'' + 
			",checkinsCount = '" + checkinsCount + '\'' + 
			",usersCount = '" + usersCount + '\'' + 
			",tipCount = '" + tipCount + '\'' + 
			"}";
		}
}
