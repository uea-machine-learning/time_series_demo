package iterators.movies;

import java.util.Iterator;

public class MovieIterator implements Iterator<Movie> {
    MovieDatabase m;
    int pos;
    MovieIterator(MovieDatabase m){
        this.m=m;
        pos=m.size()-1;
    }



    @Override
    public boolean hasNext() {
        if(pos>=0)
            return true;
        return false;
    }

    @Override
    public Movie next() {
        Movie movie=m.getMovie(pos);
        pos--;
        return movie;
    }
}
