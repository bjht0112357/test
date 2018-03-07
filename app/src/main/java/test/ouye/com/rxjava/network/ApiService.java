package test.ouye.com.rxjava.network;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import test.ouye.com.rxjava.bean.User;

/**
 * Class Des:
 * Created by bjh on 2018/3/6.
 */

public interface ApiService {
    //POST请求
    @FormUrlEncoded
    @POST("bjws/app.user/login")
    Observable<User> getUserInfo(@Field("tel") String tel, @Field("password") String pass);
}
