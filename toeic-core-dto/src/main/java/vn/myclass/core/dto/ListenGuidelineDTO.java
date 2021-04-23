package vn.myclass.core.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ListenGuidelineDTO implements Serializable {

    private Integer listenGuidlineId;
    private String title;
    private String image;
    private String content;
    private Timestamp createdDate;
    private Timestamp modifiedDate;

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
