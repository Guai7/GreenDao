package com.bw.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public
/**
 *GreenDao
 *file name is : Sutdent
 *created by Ender on 2021/8/13 11:01.
 *author : 王益德
 *Describe:
 */
class Student {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String classCode;
    @Generated(hash = 1822641195)
    public Student(Long id, String name, String classCode) {
        this.id = id;
        this.name = name;
        this.classCode = classCode;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getClassCode() {
        return this.classCode;
    }
    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }
    
}
