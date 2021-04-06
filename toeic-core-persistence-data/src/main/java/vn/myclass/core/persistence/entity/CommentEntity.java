package vn.myclass.core.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    @Column(name = "commentcontent")
    private String CommentContent;
    @Column(name = "createddate")
    private Timestamp creattedDate;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "listenguidlineid")
    private ListenGuidlineEntity listenGuidline;

    public ListenGuidlineEntity getListenGuidline() {
        return listenGuidline;
    }

    public void setListenGuidline(ListenGuidlineEntity listenGuidline) {
        this.listenGuidline = listenGuidline;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return CommentContent;
    }

    public void setCommentContent(String commentContent) {
        CommentContent = commentContent;
    }

    public Timestamp getCreattedDate() {
        return creattedDate;
    }

    public void setCreattedDate(Timestamp creattedDate) {
        this.creattedDate = creattedDate;
    }
}
