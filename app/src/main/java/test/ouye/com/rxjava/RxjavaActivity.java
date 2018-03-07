package test.ouye.com.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.ouye.com.rxjava.bean.User;
import test.ouye.com.rxjava.network.ApiService;
import test.ouye.com.rxjava.util.RetrofitUtil;

public class RxjavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        ApiService apiService = RetrofitUtil.getInstance("").setCreate(ApiService.class);
        apiService.getUserInfo("18959261248", "123456").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onNext(User user) {
                    }
                });
    }
}
