/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import entity.Post;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuan5
 */
public class dataAccess {

    private PreparedStatement loginStatement;

    private PreparedStatement getLoginStatement() throws ClassNotFoundException, SQLException {
        if (loginStatement == null) {
            Connection connection = new DBConnection().getConnection();
            loginStatement = connection.prepareStatement("Select * from USERPOST where USERNAME=? and PASS= ?");
        }
        return loginStatement;
    }

    public User loginExam(String u, String p) throws SQLException {
        User user = new User();
        try {
            PreparedStatement sta = getLoginStatement();
            sta.setString(1, u);
            sta.setString(2, p);
            ResultSet rs = sta.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("ID"));
                user.setUsername(u);
                user.setPassword(p);
                user.setAdmin(rs.getBoolean("ISADMIN"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    private PreparedStatement viewPost;

    private PreparedStatement getViewPostStatement() throws ClassNotFoundException, SQLException {
        if (viewPost == null) {
            Connection connection = new DBConnection().getConnection();
            viewPost = connection.prepareStatement("Select * from POST where IDUSER=?");
        }
        return viewPost;
    }

    public List<Post> getAllPostUser(int id) {
        try {
            PreparedStatement sta = getViewPostStatement();
            sta.setInt(1, id);
            ResultSet rs = sta.executeQuery();
            List<Post> lp = new LinkedList<>();
            while (rs.next()) {
                lp.add(new Post(
                        rs.getInt("IDPOST"),
                        rs.getInt("IDUSER"),
                        rs.getString("TITLE"),
                        rs.getString("CONTENT"),
                        rs.getDate("DATEPOST"),
                        rs.getString("IMGPATH"),
                        rs.getString("AUTHOR")));
            }
            return lp;
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
    }
    private PreparedStatement insertPost;

    private PreparedStatement getInsertPostStatement() throws ClassNotFoundException, SQLException {
        if (insertPost == null) {
            Connection connection = new DBConnection().getConnection();
            insertPost = connection.prepareStatement("insert into POST values(?,?,?,?,?,?,?)");
        }
        return insertPost;
    }

    public boolean insertPost(Post p) {

        try {
            PreparedStatement sta = getInsertPostStatement();
            sta.setInt(1, p.getIdPost());
            sta.setInt(2, p.getIdUser());
            sta.setString(3, p.getTitle());
            sta.setString(4, p.getContent());
            sta.setDate(5, p.getDatePost());
            sta.setString(6, p.getImgPath());
            sta.setString(7, p.getAuthor());
            int rs = sta.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(dataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    private PreparedStatement getPost;

    private PreparedStatement getPostStatement() throws ClassNotFoundException, SQLException {
        if (getPost == null) {
            Connection connection = new DBConnection().getConnection();
            getPost = connection.prepareStatement("select * from POST where IDPOST=?");
        }
        return getPost;
    }

    public Post getPostById(int id) {
        Post p = new Post();
        try {
            PreparedStatement sta = getPostStatement();
            sta.setInt(1, id);
            ResultSet rs = sta.executeQuery();
            if (rs.next()) {
                p.setIdPost(rs.getInt("IDPOST"));
                p.setIdUser(rs.getInt("IDUSER"));
                p.setTitle(rs.getString("TITLE"));
                p.setDatePost(rs.getDate("DATEPOST"));
                p.setContent(rs.getString("CONTENT"));
                p.setImgPath(rs.getString("IMGPATH"));
                p.setAuthor(rs.getString("AUTHOR"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(dataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

}
