package test.ouye.com.rxjava.util;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class Des:
 * Created by bjh on 2018/3/6.
 */

public class RetrofitUtil {
    private Retrofit mRetrofit;
    private String baseUrl;
    private static RetrofitUtil mRetrofitManager;
    private RetrofitUtil(String baseUrl){
        this.baseUrl=baseUrl;
        initRetrofit();
    }
    public static synchronized RetrofitUtil getInstance(String baseUrl){
        if (mRetrofitManager == null){
            mRetrofitManager = new RetrofitUtil(baseUrl);
        }
        return mRetrofitManager;
    }
    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(OkHttp3Utils.getOkHttpClient())
                .build();
    }
    public <T> T setCreate(Class<T> reqServer) {
        return mRetrofit.create(reqServer);
    }
}
