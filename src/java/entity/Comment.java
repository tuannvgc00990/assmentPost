/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author tuan5
 */
public class Comment {
    private String idComment;
    private int idPost;
    private String userName;
    private String comment;
    private String idChild;

    public Comment() {
    }

    public Comment(String idComment, int idPost, String userName, String comment, String idChild) {
        this.idComment = idComment;
        this.idPost = idPost;
        this.userName = userName;
        this.comment = comment;
        this.idChild = idChild;
    }

    public Comment(String idComment, int idPost, String userName, String comment) {
        this.idComment = idComment;
        this.idPost = idPost;
        this.userName = userName;
        this.comment = comment;
    }

    public String getIdComment() {
        return idComment;
    }

    public void setIdComment(String idComment) {
        this.idComment = idComment;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIdChild() {
        return idChild;
    }

    public void setIdChild(String idChild) {
        this.idChild = idChild;
    }
    
}
