package com.joker.rxweather.model.service;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @auther jjr
 * @date 创建时间： 2016/11/23 15:54
 * @Description
 */

public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request=chain.request().newBuilder().addHeader("Accept-Encoding","application/json").build();
        return chain.proceed(request);
    }
}
