package com.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "forumposts")
public class ForumPosts implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id", insertable = false)
    private Integer id;

    @Column(name = "postnumber")
    private String postnumber;

    @Column(name = "categorization")
    private String categorization;

    @Column(name = "postname")
    private String postname;

    @Column(name = "picture")
    private String picture;

    @Column(name = "postcontent")
    private String postcontent;

    @Column(name = "releasetime")
    private String releasetime;

    @Column(name = "postviews")
    private Integer postviews;

    @Column(name = "publisher")
    private String publisher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getpostnumber() {
        return postnumber;
    }

    public void setpostnumber(String postnumber) {
        this.postnumber = postnumber;
    }

    public String getcategorization() {
        return categorization;
    }

    public void setcategorization(String categorization) {
        this.categorization = categorization;
    }

    public String getpostname() {
        return postname;
    }

    public void setpostname(String postname) {
        this.postname = postname;
    }

    public String getpicture() {
        return picture;
    }

    public void setpicture(String picture) {
        this.picture = picture;
    }

    public String getpostcontent() {
        return postcontent;
    }

    public void setpostcontent(String postcontent) {
        this.postcontent = postcontent;
    }

    public String getreleasetime() {
        return releasetime;
    }

    public void setreleasetime(String releasetime) {
        this.releasetime = releasetime;
    }

    public Integer getpostviews() {
        return postviews;
    }

    public void setpostviews(Integer postviews) {
        this.postviews = postviews;
    }

    public String getpublisher() {
        return publisher;
    }

    public void setpublisher(String publisher) {
        this.publisher = publisher;
    }
}
