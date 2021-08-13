package com.bw.greendao;

import android.database.sqlite.SQLiteDatabase;

import com.bw.greendao.db.DaoMaster;
import com.bw.greendao.db.DaoSession;

public
/**
 *GreenDao
 *file name is : DaoManger
 *created by Ender on 2021/8/13 11:04.
 *author : 王益德
 *Describe:
 */
class DaoManger {

    private static DaoManger daoManger;
    private DaoSession daoSession;

    private DaoManger() {
        //开启数据库
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(App.context, "user.db");
        //获取读写库对象
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        //更新数据库（添加Student表时使用）
        devOpenHelper.onUpgrade(db,1,2);
        //new一个Dao控制 传值读写库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取增删改查库对象

        daoSession = daoMaster.newSession();
    }

    public static DaoManger getInstance() {
        if (daoManger==null){
            synchronized (DaoManger.class){
                if (daoManger==null){
                    daoManger = new DaoManger();
                }
            }
        }
        return daoManger;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
