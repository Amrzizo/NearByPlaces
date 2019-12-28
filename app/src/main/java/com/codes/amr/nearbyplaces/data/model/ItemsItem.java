package com.codes.amr.nearbyplaces.data.model;

public class ItemsItem{
	private Venue venue;
	private Reasons reasons;
	private String referralId;
	private String summary;
	private String reasonName;
	private String type;

	public void setVenue(Venue venue){
		this.venue = venue;
	}

	public Venue getVenue(){
		return venue;
	}

	public void setReasons(Reasons reasons){
		this.reasons = reasons;
	}

	public Reasons getReasons(){
		return reasons;
	}

	public void setReferralId(String referralId){
		this.referralId = referralId;
	}

	public String getReferralId(){
		return referralId;
	}

	public void setSummary(String summary){
		this.summary = summary;
	}

	public String getSummary(){
		return summary;
	}

	public void setReasonName(String reasonName){
		this.reasonName = reasonName;
	}

	public String getReasonName(){
		return reasonName;
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
			"ItemsItem{" + 
			"venue = '" + venue + '\'' + 
			",reasons = '" + reasons + '\'' + 
			",referralId = '" + referralId + '\'' + 
			",summary = '" + summary + '\'' + 
			",reasonName = '" + reasonName + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}
