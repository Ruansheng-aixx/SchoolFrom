package com.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "announcement")
public class Announcement implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id", insertable = false)
    private Integer id;

    @Column(name = "announcementnumber")
    private String announcementnumber;

    @Column(name = "announcementtitle")
    private String announcementtitle;

    @Column(name = "announcementcontent")
    private String announcementcontent;

    @Column(name = "releasedate")
    private String releasedate;

    @Column(name = "publisher")
    private String publisher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getannouncementnumber() {
        return announcementnumber;
    }

    public void setannouncementnumber(String announcementnumber) {
        this.announcementnumber = announcementnumber;
    }

    public String getannouncementtitle() {
        return announcementtitle;
    }

    public void setannouncementtitle(String announcementtitle) {
        this.announcementtitle = announcementtitle;
    }

    public String getannouncementcontent() {
        return announcementcontent;
    }

    public void setannouncementcontent(String announcementcontent) {
        this.announcementcontent = announcementcontent;
    }

    public String getreleasedate() {
        return releasedate;
    }

    public void setreleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getpublisher() {
        return publisher;
    }

    public void setpublisher(String publisher) {
        this.publisher = publisher;
    }
}
