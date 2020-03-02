package io.qkits.todoandroid.dagger.ui;


import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.qkits.todoandroid.bean.User;
import io.qkits.todoandroid.dagger.base.scope.ActivityScope;
import io.qkits.todoandroid.mvp.base.BaseMVPPresenter;
import io.qkits.todoandroid.mvp.ui.LoginMvpView;
import io.qkits.todoandroid.net.GithubApi;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


@ActivityScope
public class LoginDaggerPresenter extends BaseMVPPresenter<LoginMvpView> {

    private GithubApi mApi;

    @Inject
    public LoginDaggerPresenter(GithubApi mApi) {
        this.mApi = mApi;
    }

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public void getIdentify() {
        // interval隔一秒发一次，到120结束
        Disposable mDisposable = Observable
                .interval(1, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .take(120)
                .subscribeWith(new DisposableObserver<Long>() {
                    @Override
                    public void onComplete() {
                        mMvpView.countdownComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mMvpView.showToast("倒计时出现错误！");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        mMvpView.countdownNext(String.valueOf(Math.abs(aLong - 120)));
                    }
                });
        mCompositeDisposable.add(mDisposable);
    }

    public void login(String mobile, String code) {
        if (mobile.length() != 11) {
            mMvpView.showToast("手机号码不正确");
            return;
        }
        if (code.length() != 6) {
            mMvpView.showToast("验证码不正确");
            return;
        }

        mApi.getUser("simplezhli")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        if (isViewAttached()) {
                            mMvpView.showProgress();
                        }

                    }
                })
                .doAfterTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        if (isViewAttached()) {
                            mMvpView.closeProgress();
                        }
                    }
                })
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(User user) {
                        mMvpView.showToast("登录成功");
                        mMvpView.loginSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mMvpView.showToast("登录失败");
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public void detachView() {
        super.detachView();
        mCompositeDisposable.clear();
    }
}
