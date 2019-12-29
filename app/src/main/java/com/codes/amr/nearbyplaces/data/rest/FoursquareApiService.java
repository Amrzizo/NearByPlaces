package com.codes.amr.nearbyplaces.data.rest;

import com.codes.amr.nearbyplaces.data.model.Image.ImageResponse;
import com.codes.amr.nearbyplaces.data.model.Response;
import com.codes.amr.nearbyplaces.data.model.VenueModel.VenueResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FoursquareApiService {

    public static final String CLIENT_ID = "GNSPORJV5J1WVC1IEKZI3LSOC1IQN1EIHBHHVJTED01P3OQR";
    public static final String CLIENT_SECRET = "UILRHS3JV3XP0H1Q0LJWVOIIA3CP1EHVYMPRA52ITOVF1WI4";
    public static final String CONTENT_TYPE_KEY = "Content-Type";
    public static final String CONTENT_TYPE_VALUE = "application/json";
    public static final String API_VERSION = "20180323";
    public static final int PHOTOS_LIMIT = 5;
    public static final int RADIUS = 1000;


    @GET("explore")
    Single<Response> getLocations(@Query("ll") String location, @Query("radius") int radius, @Query("v") String versionDate);

//    @GET("{VENUE_ID}/photos")
//    Observable<retrofit2.Response<ImageResponse>> getPhotos(@Path("VENUE_ID") String locationId, @Query("limit") int limit, @Query("v") String date);
//
//    @GET("{id}/")
//    Observable<retrofit2.Response<VenueResponse>> getVenue(@Path("id") String id, @Query("v") String v);
}
