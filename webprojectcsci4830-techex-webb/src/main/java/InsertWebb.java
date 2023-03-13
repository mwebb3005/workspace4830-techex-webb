import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Info;
import util.UtilDBWebb;

@WebServlet("/InsertWebb")
public class InsertWebb extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public InsertWebb() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String title = request.getParameter("title").trim();
      String artist = request.getParameter("artist").trim();
      String genre = request.getParameter("genre").trim();
      String year = request.getParameter("year").trim();
      
      UtilDBWebb.createAlbum(title, artist, genre, year);

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String titleDB = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + titleDB + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + titleDB + "</h1>\n");
      out.println("<ul>");
      out.println("<li> Title: " + title);
      out.println("<li> Artist: " + artist);
      out.println("<li> Genre: " + genre);
      out.println("<li> Year: " + year);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
