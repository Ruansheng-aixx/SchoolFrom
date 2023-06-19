package com.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "postcategorization")
public class PostCategorization implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id", insertable = false)
    private Integer id;

    @Column(name = "categorizationname")
    private String categorizationname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcategorizationname() {
        return categorizationname;
    }

    public void setcategorizationname(String categorizationname) {
        this.categorizationname = categorizationname;
    }
}
