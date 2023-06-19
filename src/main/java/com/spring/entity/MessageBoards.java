package com.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "messageboards")
public class MessageBoards implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id", insertable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "contactnumber")
    private String contactnumber;

    @Column(name = "messagecontent")
    private String messagecontent;

    @Column(name = "messageperson")
    private String messageperson;

    @Column(name = "replycontent")
    private String replycontent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getcontactnumber() {
        return contactnumber;
    }

    public void setcontactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getmessagecontent() {
        return messagecontent;
    }

    public void setmessagecontent(String messagecontent) {
        this.messagecontent = messagecontent;
    }

    public String getmessageperson() {
        return messageperson;
    }

    public void setmessageperson(String messageperson) {
        this.messageperson = messageperson;
    }

    public String getreplycontent() {
        return replycontent;
    }

    public void setreplycontent(String replycontent) {
        this.replycontent = replycontent;
    }
}
