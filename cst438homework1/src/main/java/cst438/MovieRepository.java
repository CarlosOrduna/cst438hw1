package cst438;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.PagingAndSortingRepository;

public interface MovieRepository extends CrudRepository<Movie, Long>{
	
	//@Query("select m from Movie m order by movie_title desc")
	//List<Movie> findByOrderByUser();

	@Query("SELECT m FROM Movie m ORDER BY m.movieTitle, m.timeAndDate DESC")
	List<Movie> findAllMovieOrderByMovieTitle();
	
}
