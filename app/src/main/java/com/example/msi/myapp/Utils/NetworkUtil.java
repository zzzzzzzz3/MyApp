package com.example.msi.myapp.Utils;

import com.example.msi.myapp.Interface.API.MeiziApi;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 文 件 名: NetworkUtil
 * 创 建 人: ZhangRonghua
 * 创建日期: 2016/7/4 17:17
 * 邮   箱: qq798435167@gmail.com
 * 博   客: http://zzzzzzzz3.github.io
 * 修改时间：
 * 修改备注：
 */
public class NetworkUtil {
    private static MeiziApi meiziApi;
    private static final String GAMKIO = "http://gank.io/api/";
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    public static MeiziApi getMeiziApi() {
        if (null == meiziApi) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://gank.io/api/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            meiziApi = retrofit.create(MeiziApi.class);
        }
        return meiziApi;
    }

}
