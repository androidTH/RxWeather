package com.joker.rxweather.model;


import com.joker.rxweather.model.service.HeaderInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Joker on 2015/9/1.
 */
public class OkClientInstance {

  private static volatile OkHttpClient clientSingleton;

  public static OkHttpClient getInstance() {
    if (clientSingleton == null) {
      synchronized (OkClientInstance.class) {
        if (clientSingleton == null) {
          HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
          interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
          clientSingleton = new OkHttpClient.Builder()
                  .addNetworkInterceptor(interceptor)
                  .addInterceptor(new HeaderInterceptor())
                  .connectTimeout(5000, TimeUnit.SECONDS).build();
        }
      }
    }
    return clientSingleton;
  }
}
