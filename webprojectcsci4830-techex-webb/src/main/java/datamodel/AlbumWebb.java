package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE employee (
  id INT NOT NULL AUTO_INCREMENT,    
  name VARCHAR(30) NOT NULL,   
  age INT NOT NULL,  
  phone VARCHAR(30) NOT NULL,   
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "albumTable")
public class AlbumWebb {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;

   @Column(name = "title")
   private String title;

   @Column(name = "artist")
   private String artist;
   
   @Column(name = "genre")
   private String genre;
   
   @Column(name = "year")
   private String year;

   public AlbumWebb() {
   }

   public AlbumWebb(Integer id, String title, String artist, String genre, String year) {
      this.id = id;
      this.title = title;
      this.artist = artist;
      this.year = year;
   }

   public AlbumWebb(String name, String age, String genre, String year) {
      this.title = title;
      this.artist = artist;
      this.genre = genre;
      this.year = year;
   }
   

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }
   
   public void setTitle(String title) {
	      this.title = title;
	   }
   
   public String getArtist() {
	      return artist;
	   }

   public void setArtist(String artist) {
      this.artist = artist;
   }

   public String getGenre() {
      return genre;
   }

   public void setGenre(String genre) {
      this.genre = genre;
   }
   
   public String getYear() {
	      return year;
	   }

	   public void setYear(String year) {
	      this.year = year;
	   }

   @Override
   public String toString() {
      return "Album: " + this.id + ", " + this.title + ", " + this.artist + ", " + this.genre + ", " + this.year;
   }
}