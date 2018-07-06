
public class MyMovies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NetflixQueue myMovies = new NetflixQueue();
		
		myMovies.addMovie(new Movie("Gigli", 1));
		myMovies.addMovie(new Movie("Bloodsport", 4));
		myMovies.addMovie(new Movie("Kickboxer", 3));
		myMovies.addMovie(new Movie("Lionheart", 2));
		myMovies.addMovie(new Movie("Black Sheep", 1));
		
		myMovies.printMovies();
		
		System.out.println("");
		System.out.println(myMovies.getBestMovie() + "\n");
		
		myMovies.sortMoviesByRating();
		myMovies.printMovies();
		
		System.out.println("Ticket prices:");
		for( int eachMovie=0; eachMovie < myMovies.movies.size(); ++eachMovie) {
			Movie movie = myMovies.getMovie(eachMovie);
			System.out.println(movie.getTitle() + ": stars: " + movie.getRating() + " - " + movie.getTicketPrice());
		}
	}

}
