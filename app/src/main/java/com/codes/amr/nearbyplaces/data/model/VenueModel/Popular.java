package com.codes.amr.nearbyplaces.data.model.VenueModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Popular{

	@SerializedName("isOpen")
	private boolean isOpen;

	@SerializedName("timeframes")
	private List<TimeframesItem> timeframes;

	@SerializedName("isLocalHoliday")
	private boolean isLocalHoliday;

	@SerializedName("status")
	private String status;

	public void setIsOpen(boolean isOpen){
		this.isOpen = isOpen;
	}

	public boolean isIsOpen(){
		return isOpen;
	}

	public void setTimeframes(List<TimeframesItem> timeframes){
		this.timeframes = timeframes;
	}

	public List<TimeframesItem> getTimeframes(){
		return timeframes;
	}

	public void setIsLocalHoliday(boolean isLocalHoliday){
		this.isLocalHoliday = isLocalHoliday;
	}

	public boolean isIsLocalHoliday(){
		return isLocalHoliday;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Popular{" + 
			"isOpen = '" + isOpen + '\'' + 
			",timeframes = '" + timeframes + '\'' + 
			",isLocalHoliday = '" + isLocalHoliday + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}