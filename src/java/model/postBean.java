/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import da.dataAccess;
import entity.Post;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuan5
 */
public class postBean {

    private String username, password;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean login() {
        try {
            user = new dataAccess().loginExam(username, password);
            if (user.getUsername() == null) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(postBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public List<Post> getAllPostByUser(int id) {
        dataAccess da = new dataAccess();
        List<Post> lp = da.getAllPostUser(id);
        return lp;
    }

    public boolean createPost(Post p) {
        dataAccess da = new dataAccess();
        return da.insertPost(p);
    }

    public Post viewPost(int p) {
        dataAccess da = new dataAccess();
        return da.getPostById(p);
    }

}
