package com.codes.amr.nearbyplaces.data.model;

import java.util.List;

public class Response{
	private Meta meta;
	private Response response;
	private SuggestedFilters suggestedFilters;
	private int totalResults;
	private int suggestedRadius;
	private String headerFullLocation;
	private String headerLocationGranularity;
	private List<GroupsItem> groups;
	private SuggestedBounds suggestedBounds;
	private String headerLocation;

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setResponse(Response response){
		this.response = response;
	}

	public Response getResponse(){
		return response;
	}

	public void setSuggestedFilters(SuggestedFilters suggestedFilters){
		this.suggestedFilters = suggestedFilters;
	}

	public SuggestedFilters getSuggestedFilters(){
		return suggestedFilters;
	}

	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}

	public int getTotalResults(){
		return totalResults;
	}

	public void setSuggestedRadius(int suggestedRadius){
		this.suggestedRadius = suggestedRadius;
	}

	public int getSuggestedRadius(){
		return suggestedRadius;
	}

	public void setHeaderFullLocation(String headerFullLocation){
		this.headerFullLocation = headerFullLocation;
	}

	public String getHeaderFullLocation(){
		return headerFullLocation;
	}

	public void setHeaderLocationGranularity(String headerLocationGranularity){
		this.headerLocationGranularity = headerLocationGranularity;
	}

	public String getHeaderLocationGranularity(){
		return headerLocationGranularity;
	}

	public void setGroups(List<GroupsItem> groups){
		this.groups = groups;
	}

	public List<GroupsItem> getGroups(){
		return groups;
	}

	public void setSuggestedBounds(SuggestedBounds suggestedBounds){
		this.suggestedBounds = suggestedBounds;
	}

	public SuggestedBounds getSuggestedBounds(){
		return suggestedBounds;
	}

	public void setHeaderLocation(String headerLocation){
		this.headerLocation = headerLocation;
	}

	public String getHeaderLocation(){
		return headerLocation;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"meta = '" + meta + '\'' + 
			",response = '" + response + '\'' + 
			",suggestedFilters = '" + suggestedFilters + '\'' + 
			",totalResults = '" + totalResults + '\'' + 
			",suggestedRadius = '" + suggestedRadius + '\'' + 
			",headerFullLocation = '" + headerFullLocation + '\'' + 
			",headerLocationGranularity = '" + headerLocationGranularity + '\'' + 
			",groups = '" + groups + '\'' + 
			",suggestedBounds = '" + suggestedBounds + '\'' + 
			",headerLocation = '" + headerLocation + '\'' + 
			"}";
		}
}
