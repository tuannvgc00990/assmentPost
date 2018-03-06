/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.util.Random;

/**
 *
 * @author tuan5
 */
public class Post {
    private int idPost;
    private int idUser;
    private String title;
    private String content;
    private Date datePost;
    private String imgPath;
    private String author;

    public Post() {
    }

    public Post(int idPost, int idUser, String title, String content, Date datePost, String imgPath, String author) {
        this.idPost = idPost;
        this.idUser = idUser;
        this.title = title;
        this.content = content;
        this.datePost = datePost;
        this.imgPath = imgPath;
        this.author = author;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public int createID(){
     String SALTCHARS = "1234567890";
     StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        int saltStr =Integer.parseInt(salt.toString()) ;
        return saltStr;
    }
    public Date createDatePost(){
    Date d=new Date(new java.util.Date().getTime());
    return d;
    }
}
