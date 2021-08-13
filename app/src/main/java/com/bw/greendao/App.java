package com.bw.greendao;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bw.greendao.db.DaoMaster;
import com.bw.greendao.db.DaoSession;

public
/**
 *GreenDao
 *file name is : App
 *created by Ender on 2021/8/12 16:37.
 *author : 王益德
 *Describe:
 */
class App extends Application {

    public static Context context;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

}
