package io.qkits.todoandroid.dagger.base.component;


import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import io.qkits.todoandroid.ToDoApp;
import io.qkits.todoandroid.dagger.base.module.AppModule;
import io.qkits.todoandroid.dagger.base.module.ClientModule;
import io.qkits.todoandroid.dagger.ui.BuildersModule;


@Singleton
@Component(modules = {
        AppModule.class,
        ClientModule.class,
        BuildersModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<ToDoApp> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<ToDoApp> {
    }

}
