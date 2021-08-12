package com.bw.greendao;

import androidx.core.widget.TextViewCompat;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public
/**
 *GreenDao
 *file name is : User
 *created by Ender on 2021/8/12 15:59.
 *author : 王益德
 *Describe:
 */
class User {

//    @Id：对象的Id，使用Long类型作为EntityId，否则会报错。(autoincrement = true)表示主键会自增，如果false就会使用旧值
//    @Entity：告诉GreenDao该对象为实体，只有被@Entity注释的类才能被dao类操作
//    @Property：表示该属性将作为表的一个字段
//    @Transient：表示该属性不会被存入数据库的字段中
//    @Unique：表示该属性值在数据库中是唯一值
//    @NotNull：表示该属性不能为空
//    @Generated：编译后自动生成的构造函数、方法等的注释，提示构造函数、方法等不能被修改

    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "username")
    private String username;
    @Property(nameInDb = "password")
    private String password;
    @Generated(hash = 1681958521)
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
