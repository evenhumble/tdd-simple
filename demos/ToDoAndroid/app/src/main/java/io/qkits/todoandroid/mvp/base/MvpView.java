package io.qkits.todoandroid.mvp.base;

import android.content.Context;


public interface MvpView {

    /***
     * 获取Context
     * @return Context
     */
    Context getContext();

    /***
     * 显示Progress
     */
    void showProgress();

    /***
     * 关闭Progress
     */
    void closeProgress();

    /***
     * @param string 消息内容
     */
    void showToast(String string);
}
