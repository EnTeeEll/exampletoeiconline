package vn.myclass.core.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "listenguidline")
public class ListenGuidlineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer listenGuidlineId;
    @Column(name = "title")
    private String title;
    @Column(name = "image")
    private String image;
    @Column(name = "content")
    private String content;
    @Column(name = "createddate")
    private Timestamp createdDate;
    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @OneToMany(mappedBy = "listenGuidline", fetch = FetchType.LAZY)
    List<CommentEntity> commentGuidelineList;

    public Integer getListenGuidlineId() {
        return listenGuidlineId;
    }

    public void setListenGuidlineId(Integer listenGuidlineId) {
        this.listenGuidlineId = listenGuidlineId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
