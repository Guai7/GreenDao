package com.bw.greendao;

import android.annotation.SuppressLint;
import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bw.greendao.db.DaoMaster;
import com.bw.greendao.db.DaoSession;
import com.bw.greendao.db.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private UserDao userDao;
    private Button add;
    private Button del;
    private Button upData;
    private Button query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUserDao();

        initView();
    }

    private void initUserDao() {
        App application = (App) getApplication();
        DaoSession daoSession = application.getDaoSession();
        //获取指定增删改查库对象
        userDao = daoSession.getUserDao();
    }


    private void initView() {
        add = findViewById(R.id.add);
        add.setOnClickListener(this);
        del = findViewById(R.id.del);
        del.setOnClickListener(this);
        upData = findViewById(R.id.up_data);
        upData.setOnClickListener(this);
        query = findViewById(R.id.query);
        query.setOnClickListener(this);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add:
                User user = new User();
                user.setUsername("123456");
                user.setPassword("123456");
                userDao.insert(user);
                break;
            case R.id.del:
                userDao.deleteByKey((long) 1);
//                userDao.deleteAll();

//                User user1 = new User();
//                user1.setId((long) 2);
//                userDao.delete(user1);

                break;
            case R.id.up_data:
                User user2 = new User();
                user2.setId((long) 1);
                user2.setUsername("666666");
                user2.setPassword("666666");
                userDao.update(user2);
                break;
            case R.id.query:
                List<User> users = userDao.loadAll();
                Toast.makeText(this, users.toString(), Toast.LENGTH_SHORT).show();

                //分页查询
                List<User> list = userDao.queryBuilder().offset(20).limit(20).list();

                break;
        }
    }
}