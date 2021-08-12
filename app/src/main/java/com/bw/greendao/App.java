package com.bw.greendao;

import android.app.Application;
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

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDao();
    }

    private void initGreenDao() {
        //开启数据库
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "user.db");
        //获取读写库对象
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        //new一个Dao控制 传值读写库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取增删改查库对象

        daoSession = daoMaster.newSession();

    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
