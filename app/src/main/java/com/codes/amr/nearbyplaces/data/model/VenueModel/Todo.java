package com.codes.amr.nearbyplaces.data.model.VenueModel;

import com.google.gson.annotations.SerializedName;

public class Todo{

	@SerializedName("count")
	private int count;

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	@Override
 	public String toString(){
		return 
			"Todo{" + 
			"count = '" + count + '\'' + 
			"}";
		}
}