package com.codes.amr.nearbyplaces.data.model;

import java.util.List;

public class Photos{
	private int count;
	private List<Object> groups;

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setGroups(List<Object> groups){
		this.groups = groups;
	}

	public List<Object> getGroups(){
		return groups;
	}

	@Override
 	public String toString(){
		return 
			"Photos{" + 
			"count = '" + count + '\'' + 
			",groups = '" + groups + '\'' + 
			"}";
		}
}