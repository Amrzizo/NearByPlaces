package com.codes.amr.nearbyplaces.data.model;

import java.util.List;

public class SuggestedFilters{
	private String header;
	private List<FiltersItem> filters;

	public void setHeader(String header){
		this.header = header;
	}

	public String getHeader(){
		return header;
	}

	public void setFilters(List<FiltersItem> filters){
		this.filters = filters;
	}

	public List<FiltersItem> getFilters(){
		return filters;
	}

	@Override
 	public String toString(){
		return 
			"SuggestedFilters{" + 
			"header = '" + header + '\'' + 
			",filters = '" + filters + '\'' + 
			"}";
		}
}