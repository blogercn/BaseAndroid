package com.hxdl.coceweb.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * 应用Application类
 *
 *
 */
@SuppressWarnings("unused")
public class BaseApplication extends Application {

    private static BaseApplication mInstance;
    private List<Activity> mActivities = new ArrayList<>();

    // 单例模式中获取唯一的ExitApplication 实例
    public static BaseApplication getInstance() {
        if (null == mInstance) {
            mInstance = new BaseApplication();
        }
        return mInstance;

    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        init();
    }

    private void init() {
        // TODO Auto-generated method stub
        initImageLoader();

        // 使用腾讯BUGLY上传崩溃信息
        initCrashReport();

        initCrashHandler();
    }

    /**
     * 初始化ImageLoader
     */
    private void initImageLoader() {

    }

    /**
     * 初始化CrashHandler(保存在本地)
     */
    @SuppressWarnings("unused")
    private void initCrashHandler() {
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init();
        Thread.currentThread().setUncaughtExceptionHandler(crashHandler);
    }

    /**
     * 初始化崩溃上传(腾讯BUGLY)
     */
    private void initCrashReport() {
        //CrashReport.initCrashReport(this, "900007710", false);
    }

    /**
     * 重载系统获取缓存目录
     */
    /*
    @Override
    public File getCacheDir() {
        // TODO Auto-generated method stub
        //return new File(CacheManager.getAppCachePath(this));
    }

    @Override
    public File getDatabasePath(String name) {
        // TODO Auto-generated method stub
        //return new File(CacheManager.getAppDatabasePath(this));
    }
     */

    /**
     * 把Activity加入历史堆栈
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        mActivities.add(activity);
    }

    /**
     * 结束
     */
    @Override
    public void onTerminate() {
        super.onTerminate();

        for (Activity activity : mActivities) {
            activity.finish();
        }

        System.exit(0);
    }
}
