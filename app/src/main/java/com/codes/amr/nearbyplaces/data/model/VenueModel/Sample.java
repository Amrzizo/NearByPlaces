package com.codes.amr.nearbyplaces.data.model.VenueModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sample{

	@SerializedName("entities")
	private List<EntitiesItem> entities;

	@SerializedName("text")
	private String text;

	public void setEntities(List<EntitiesItem> entities){
		this.entities = entities;
	}

	public List<EntitiesItem> getEntities(){
		return entities;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"Sample{" + 
			"entities = '" + entities + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}