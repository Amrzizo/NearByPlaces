package com.codes.amr.nearbyplaces.data.model;

public class BeenHere{
	private boolean marked;
	private int count;
	private int lastCheckinExpiredAt;
	private int unconfirmedCount;

	public void setMarked(boolean marked){
		this.marked = marked;
	}

	public boolean isMarked(){
		return marked;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setLastCheckinExpiredAt(int lastCheckinExpiredAt){
		this.lastCheckinExpiredAt = lastCheckinExpiredAt;
	}

	public int getLastCheckinExpiredAt(){
		return lastCheckinExpiredAt;
	}

	public void setUnconfirmedCount(int unconfirmedCount){
		this.unconfirmedCount = unconfirmedCount;
	}

	public int getUnconfirmedCount(){
		return unconfirmedCount;
	}

	@Override
 	public String toString(){
		return 
			"BeenHere{" + 
			"marked = '" + marked + '\'' + 
			",count = '" + count + '\'' + 
			",lastCheckinExpiredAt = '" + lastCheckinExpiredAt + '\'' + 
			",unconfirmedCount = '" + unconfirmedCount + '\'' + 
			"}";
		}
}
