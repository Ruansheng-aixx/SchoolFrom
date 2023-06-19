package com.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "postreplies")
public class PostReplies implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id", insertable = false)
    private Integer id;

    @Column(name = "forumpostid")
    private Integer forumpostid;

    @Column(name = "postnumber")
    private String postnumber;

    @Column(name = "categorization")
    private String categorization;

    @Column(name = "postname")
    private String postname;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "replytime")
    private String replytime;

    @Column(name = "replycontent")
    private String replycontent;

    @Column(name = "replypeople")
    private String replypeople;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getforumpostid() {
        return forumpostid;
    }

    public void setforumpostid(Integer forumpostid) {
        this.forumpostid = forumpostid;
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

    public String getpublisher() {
        return publisher;
    }

    public void setpublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getreplytime() {
        return replytime;
    }

    public void setreplytime(String replytime) {
        this.replytime = replytime;
    }

    public String getreplycontent() {
        return replycontent;
    }

    public void setreplycontent(String replycontent) {
        this.replycontent = replycontent;
    }

    public String getreplypeople() {
        return replypeople;
    }

    public void setreplypeople(String replypeople) {
        this.replypeople = replypeople;
    }
}
