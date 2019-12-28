package com.codes.amr.nearbyplaces.data.model.VenueModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Attributes{

	@SerializedName("groups")
	private List<GroupsItem> groups;

	public void setGroups(List<GroupsItem> groups){
		this.groups = groups;
	}

	public List<GroupsItem> getGroups(){
		return groups;
	}

	@Override
 	public String toString(){
		return 
			"Attributes{" + 
			"groups = '" + groups + '\'' + 
			"}";
		}
}