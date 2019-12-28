package com.codes.amr.nearbyplaces.data.model.VenueModel;

import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("venue")
    private Venue venue;

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Venue getVenue() {
        return venue;
    }

    @Override
    public String toString() {
        return
                "Response{" +
                        "venue = '" + venue + '\'' +
                        "}";
    }
}