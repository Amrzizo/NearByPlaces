package com.codes.amr.nearbyplaces.data.model.VenueModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EntitiesItem{

	@SerializedName("indices")
	private List<Integer> indices;

	@SerializedName("type")
	private String type;

	public void setIndices(List<Integer> indices){
		this.indices = indices;
	}

	public List<Integer> getIndices(){
		return indices;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"EntitiesItem{" + 
			"indices = '" + indices + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}