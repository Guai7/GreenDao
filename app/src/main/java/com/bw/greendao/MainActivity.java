package com.bw.greendao;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.bw.greendao.db.DaoSession;
import com.bw.greendao.db.StudentDao;
import com.bw.greendao.db.UserDao;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private UserDao userDao;
    private StudentDao studentDao;
    private Button add;
    private Button del;
    private Button upData;
    private Button query;

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUserDao();

        initView();
    }

    private void initUserDao() {
        DaoSession daoSession = DaoManger.getInstance().getDaoSession();
        //获取指定增删改查库对象
        userDao = daoSession.getUserDao();
        studentDao = daoSession.getStudentDao();
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

//                //查询所有
                List<User> users = userDao.loadAll();
//                Toast.makeText(this, users.toString(), Toast.LENGTH_SHORT).show();
//
//                //分页查询
//                List<User> list = userDao.queryBuilder().offset(i*20).limit(20).list();
//                i++;
//
//                //唯一查询
//                User unique = userDao.queryBuilder().where(UserDao.Properties.Id.eq(1)).unique();
//                Toast.makeText(this, unique.toString(), Toast.LENGTH_SHORT).show();
//
//                //多个查询
//                List<User> list1 = userDao.queryBuilder().where(UserDao.Properties.Username.eq("666666")).list();
//                for (User user1 : list1) {
//                    Log.i(TAG, user1.toString());
//                }

                //模糊查询
                List<User> list2 = userDao.queryBuilder().where(UserDao.Properties.Username.like("6")).list();
                for (User user1 : list2) {
                    Log.i(TAG, user1.toString());
                }
                break;
        }
    }
}