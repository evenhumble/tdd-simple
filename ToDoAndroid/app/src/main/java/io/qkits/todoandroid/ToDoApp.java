package io.qkits.todoandroid;


import com.elvishew.xlog.BuildConfig;
import com.elvishew.xlog.LogConfiguration;
import com.elvishew.xlog.LogLevel;
import com.elvishew.xlog.XLog;

import javax.inject.Inject;

import dagger.android.AndroidInjector;

import dagger.android.support.DaggerApplication;
import io.qkits.todoandroid.dagger.base.component.DaggerAppComponent;
import io.qkits.todoandroid.net.GithubApi;

public class ToDoApp extends DaggerApplication {

    private static ToDoApp instance;

    @Inject
    GithubApi mGithubApi;


    @Override
    public void onCreate() {
        super.onCreate();

        if (instance == null){
            instance = this;
        }

        LogConfiguration config = new LogConfiguration.Builder()
                .logLevel(BuildConfig.DEBUG ? LogLevel.ALL : LogLevel.NONE)
                .build();
        XLog.init(config);
    }


    public static ToDoApp getInstance() {
        return instance;
    }

    public GithubApi getGithubApi() {
        return mGithubApi;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }

}
