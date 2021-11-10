package iterators.movies;

import java.util.ArrayList;
import java.util.Iterator;

public class MovieDatabase implements Iterable<Movie>{
    private Movie[] movies;
    private int max=100;
    private int currentSize=0;
    public MovieDatabase(){
        movies=new Movie[max];
    }
    public void addMovie(Movie m){
        movies[currentSize]=m;
        currentSize++;
    }
    public int size(){ return currentSize;}
    Movie getMovie(int p){ return movies[p];}
    @Override
    public Iterator<Movie> iterator() {
        return new MovieIterator(this);
    }


    public static void main(String[] args) {


        MovieDatabase m= new MovieDatabase();
        m.addMovie(new Movie("Unforgiven"));
        m.addMovie(new Movie("Godfather"));
        m.addMovie(new Movie("Goodfellas"));
       // Iterator<Movie> it= m.iterator();
        ArrayList<String> arr= new ArrayList<>();
        arr.add("Up");
        arr.add("The");
        arr.add("Arsenal!");
        for(String s:arr)
            System.out.println(s);
        Iterator<String> it2=arr.iterator();

/*
        while(it.hasNext()){
            Movie x=it.next();
            System.out.println(x.name);
        }
*/


        for(Movie movie:m)
            System.out.println(movie.name);





    }


}
