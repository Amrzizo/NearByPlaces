package com.codes.amr.nearbyplaces.data.model;

public class SuggestedBounds{
	private Sw sw;
	private Ne ne;

	public void setSw(Sw sw){
		this.sw = sw;
	}

	public Sw getSw(){
		return sw;
	}

	public void setNe(Ne ne){
		this.ne = ne;
	}

	public Ne getNe(){
		return ne;
	}

	@Override
 	public String toString(){
		return 
			"SuggestedBounds{" + 
			"sw = '" + sw + '\'' + 
			",ne = '" + ne + '\'' + 
			"}";
		}
}
