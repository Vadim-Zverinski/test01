package org.example.jd2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet(name = "Servlet0", urlPatterns = "/playlist")
public class session extends HttpServlet {

    //Playlist playlist = new Playlist();

    ArrayList<String> playlist = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();


        String mail = "";
        mail = req.getParameter("mail");
        String addSong = "";
        addSong = req.getParameter("addSong");
        String deleteSong = "";
        deleteSong = req.getParameter("delSong");
        String show = "";
        show = req.getParameter("show");


        if (mail != null) {
            session.setAttribute("mail", mail);
        } else {
            String email = (String) session.getAttribute("mail");
        }

        if (addSong(addSong)) {
            writer.write("Песня добавлена");
        }
        if (deleteSong(deleteSong)) {
            writer.write("Песня " + deleteSong + " удалена");
        }
        if (show !=null){
            for (String str : playlist){
                writer.write(str);

            }
        }
    }

    public boolean addSong(String song) {
        if (song != null) {
            playlist.add(song);
            Song song1 = new Song(song);
            return true;

        }
        return false;
    }

    public boolean deleteSong(String song) {
        for (String str : playlist) {
            if (str.equals(song)) {
                playlist.remove(song);
                return true;
            }
        }
        return false;
    }

}
