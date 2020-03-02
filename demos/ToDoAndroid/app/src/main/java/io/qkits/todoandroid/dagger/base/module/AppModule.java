package io.qkits.todoandroid.dagger.base.module;

import android.content.Context;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.qkits.todoandroid.ToDoApp;


@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(ToDoApp mApplication) {
        return mApplication.getApplicationContext();
    }
}
