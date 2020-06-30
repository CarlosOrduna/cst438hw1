package cst438;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
//import java.sql.Date;
//import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Movie {
	

	@Id
	@GeneratedValue
	private long id;
	
   @NotNull
   @Size(min=3, max=25)
   private String user;
   
   @NotNull
   @Size(min=3, max=25)
   private String movieTitle;
   
   @NotNull
   @Size(min=3, max=25)
   private String movieReview;
   
   @NotNull
   @Min(1)
   @Max(5)
   private int movieRating;
   
   private String timeAndDate;
   
   public Movie( ) {
	   /*
	      Date date = Calendar.getInstance().getTime();  
	      DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	      this.timeAndDate = dateFormat.format(date);  
	      */
	    Date dt = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.timeAndDate = sdf.format(dt);
   }
   
   public Movie(long id, String user, String movieTitle, String movieReview, int movieRating)
   {
      super();
      this.id = id;
      this.user = user;
      this.movieTitle = movieTitle;
      this.movieReview = movieReview;
      this.movieRating = movieRating;

      
      //this.timeAndDate = Date.from(Instant.parse("2000-01-01T00:00:00.000Z"));
   }

   public long getId()
   {
      return id;
   }
   
   public String getTimeAndDate()
   {
      return timeAndDate;
   }
   
   public void setTimeAndDate(String timeAndDate)
   {
      this.timeAndDate = timeAndDate;
   }
   
   public String getUser()
   {
      return user;
   }

   public void setUser(String user)
   {
      this.user = user;
   }

   public String getMovieTitle()
   {
      return movieTitle;
   }

   public void seId(long id)
   {
      this.id = id;
   }
   
   public void setMovieTitle(String movieTitle)
   {
      this.movieTitle = movieTitle;
   }

   public String getMovieReview()
   {
      return movieReview;
   }

   public void setMovieReview(String movieReview)
   {
      this.movieReview = movieReview;
   }
   
   public int getMovieRating()
   {
      return movieRating;
   }

   public void setMovieRating(int movieRating)
   {
      this.movieRating = movieRating;
   }
   
}