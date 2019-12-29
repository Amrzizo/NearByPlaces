package com.codes.amr.nearbyplaces.data.model;

import java.util.List;

public class Location{
	private String cc;
	private String country;
	private String address;
	private List<LabeledLatLngsItem> labeledLatLngs;
	private double lng;
	private int distance;
	private List<String> formattedAddress;
	private String city;
	private String state;
	private double lat;
	private String crossStreet;

	public void setCc(String cc){
		this.cc = cc;
	}

	public String getCc(){
		return cc;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setLabeledLatLngs(List<LabeledLatLngsItem> labeledLatLngs){
		this.labeledLatLngs = labeledLatLngs;
	}

	public List<LabeledLatLngsItem> getLabeledLatLngs(){
		return labeledLatLngs;
	}

	public void setLng(double lng){
		this.lng = lng;
	}

	public double getLng(){
		return lng;
	}

	public void setDistance(int distance){
		this.distance = distance;
	}

	public int getDistance(){
		return distance;
	}

	public void setFormattedAddress(List<String> formattedAddress){
		this.formattedAddress = formattedAddress;
	}

	public List<String> getFormattedAddress(){
		return formattedAddress;
	}
	public String getFormattedAddressString(){
		String address = "";
		if(formattedAddress.size()>0){
			for (String addressLine:formattedAddress) {
				if(addressLine != null)
				address = address+addressLine+" ";

			}
		}

		return address;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setLat(double lat){
		this.lat = lat;
	}

	public double getLat(){
		return lat;
	}

	public void setCrossStreet(String crossStreet){
		this.crossStreet = crossStreet;
	}

	public String getCrossStreet(){
		return crossStreet;
	}

	@Override
 	public String toString(){
		return 
			"Location{" + 
			"cc = '" + cc + '\'' + 
			",country = '" + country + '\'' + 
			",address = '" + address + '\'' + 
			",labeledLatLngs = '" + labeledLatLngs + '\'' + 
			",lng = '" + lng + '\'' + 
			",distance = '" + distance + '\'' + 
			",formattedAddress = '" + formattedAddress + '\'' + 
			",city = '" + city + '\'' + 
			",state = '" + state + '\'' + 
			",lat = '" + lat + '\'' + 
			",crossStreet = '" + crossStreet + '\'' + 
			"}";
		}
}