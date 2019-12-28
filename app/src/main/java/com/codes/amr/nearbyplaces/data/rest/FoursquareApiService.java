package com.codes.amr.nearbyplaces.data.rest;

import com.codes.amr.nearbyplaces.data.model.Image.ImageResponse;
import com.codes.amr.nearbyplaces.data.model.Response;
import com.codes.amr.nearbyplaces.data.model.VenueModel.VenueResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FoursquareApiService {

    public static final String CLIENT_ID = "RIXIB1FD5PEBXLTKRYLT0OC1M03MFD25AQ4IN3W5JOJNRTUB";
    public static final String CLIENT_SECRET = "OR2DZSIMSEONML14H1NYTCR5044D514MFJU1XQQHAGF0AGVW";
    public static final String CONTENT_TYPE_KEY = "Content-Type";
    public static final String CONTENT_TYPE_VALUE = "application/json";
    public static final String API_VERSION = "20180323";
    public static final int PHOTOS_LIMIT = 5;
    public static final int RADIUS = 1000;


    @GET("explore")
    Observable<retrofit2.Response<Response>> getLocations(@Query("ll") String location, @Query("radius") int radius, @Query("v") String versionDate);

    @GET("{VENUE_ID}/photos")
    Observable<retrofit2.Response<ImageResponse>> getPhotos(@Path("VENUE_ID") String locationId, @Query("limit") int limit, @Query("v") String date);

    @GET("venues/{id}/")
    Observable<retrofit2.Response<VenueResponse>> getVenue(@Path("id") String id, @Query("v") String v);
}
