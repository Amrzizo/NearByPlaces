package com.codes.amr.nearbyplaces.data.model;

public class FiltersItem{
	private String name;
	private String key;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	@Override
 	public String toString(){
		return 
			"FiltersItem{" + 
			"name = '" + name + '\'' + 
			",key = '" + key + '\'' + 
			"}";
		}
}
