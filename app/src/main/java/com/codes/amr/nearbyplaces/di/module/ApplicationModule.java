package com.codes.amr.nearbyplaces.di.module;

import com.codes.amr.nearbyplaces.data.rest.FoursquareApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class ApplicationModule {

    public static final String BASE_URL = "https://api.foursquare.com/v2/venues/";

    @Singleton
    @Provides
    static Retrofit provideRetrofit() {


        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        okHttpClientBuilder.addInterceptor(httpLoggingInterceptor);
        okHttpClientBuilder.connectTimeout(15, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(15, TimeUnit.SECONDS);
        okHttpClientBuilder.addInterceptor(chain -> {

            Request request = chain.request();

            HttpUrl originalHttpUrl = request.url();

            HttpUrl url = originalHttpUrl.newBuilder()
                    .addQueryParameter("client_id", FoursquareApiService.CLIENT_ID)
                    .addQueryParameter("client_secret", FoursquareApiService.CLIENT_SECRET)
                    .build();

            Request.Builder builder = request.newBuilder()
                    .header(FoursquareApiService.CONTENT_TYPE_KEY, FoursquareApiService.CONTENT_TYPE_VALUE)
                    .url(url);


            return chain.proceed(builder.build());
        });


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClientBuilder.build())
                .build();
    }


    @Singleton
    @Provides
    static FoursquareApiService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(FoursquareApiService.class);
    }
}
