/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Post;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.postBean;

/**
 *
 * @author tuan5
 */
public class adminServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String act = request.getParameter("action");
        HttpSession session = request.getSession();
        if (act.equals("login")) {
            postBean pb = new postBean();
            pb.setUsername(request.getParameter("username"));
            pb.setPassword(request.getParameter("pass"));
            if (pb.login()) {
                session.setAttribute("User", pb.getUser());
                if (pb.getUser().isAdmin()) {
                    RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
                    rd.forward(request, response);
                } else {

                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }

            } else {
                response.sendRedirect("login.jsp?mgs=Have an error! Try again pls");
            }
        }
        if (act.equals("addtopost")) {
            response.sendRedirect("addpost.jsp");
        }
        if (act.equals("addpost")) {
            User u = (User) session.getAttribute("User");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String imgpath = request.getParameter("imgpath");
            String select = request.getParameter("selectauthor");
            Post p = new Post();
            p.setIdPost(p.createID());
            p.setIdUser(u.getId());
            p.setDatePost(p.createDatePost());
            p.setImgPath(imgpath);
            p.setAuthor(select);
            p.setTitle(title);
            p.setContent(content);
            postBean pb = new postBean();
            boolean b = pb.createPost(p);
            if (b == true) {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("addpost.jsp");
                rd.forward(request, response);
            }
        }
        if (act.equals("viewpost")) {
            String id = request.getParameter("id");
            postBean pb = new postBean();
            Post p = pb.viewPost(Integer.parseInt(id));
            session.setAttribute("detail", p);
            RequestDispatcher rd = request.getRequestDispatcher("post.jsp");
            rd.forward(request, response);
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
