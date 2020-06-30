package cst438;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Hello { //localhost:8080/hello?name=carlos
	
	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping("/hello")
	public String hello(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("time", new java.util.Date().toString());
      return "index";
   }   
   
   @GetMapping("/movies/new")
   public String createMovie(Model model) {
	   Movie movie = new Movie();
	   model.addAttribute("movie", movie);
	   return "movie_form";
   }
   
   @PostMapping("/movies")
   public String processMovieForm(@Valid Movie movie, BindingResult result, Model model) {
	   if (result.hasErrors()) {
		   return "movie_form";
	   }
	   movieRepository.save(movie);
	   return "movie_show";
   }
   
   @GetMapping("/movies")
   public String getAllPeople(Model model) {
	   Iterable<Movie> movies = movieRepository.findAllMovieOrderByMovieTitle();
	   model.addAttribute("movies", movies);
	   return "movie_list";
   }
    
}
