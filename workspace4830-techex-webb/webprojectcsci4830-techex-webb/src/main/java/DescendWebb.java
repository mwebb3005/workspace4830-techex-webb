import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.AlbumWebb;
import util.Info;
import util.UtilDBWebb;

@WebServlet("/DescendWebb")
public class DescendWebb extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public DescendWebb() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");

      List<AlbumWebb> listAlbums = null;
      listAlbums = UtilDBWebb.sortAlbumsDescend();
      display(listAlbums, out);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + insertWebName + ">Input Data</a> <br>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   void display(List<AlbumWebb> listAlbums, PrintWriter out) {
      for (AlbumWebb album : listAlbums) {
         System.out.println("[DBG] " + album.getId() + ", " //
               + album.getTitle() + ", " //
               + album.getArtist() + ", " //
               + album.getGenre() + ", " //
               + album.getYear());

         out.println("<li>" + album.getId() + ", " //
               + album.getTitle() + ", " //
               + album.getArtist() + ", " //
               + album.getGenre() + ", " //
         	   + album.getYear() + "</li>");
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
