package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author TrollerX
 */
public class FilmComparator implements Comparator<Film> {

    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    public double averageRating(Film film) {
//        System.out.println("Film: " + film);
        int sum = 0;
        for (Rating rating : ratings.get(film)) {
            sum += rating.getValue();
        }

        return sum * 1.0 / ratings.get(film).size();
    }

    @Override
    public int compare(Film o1, Film o2) {
        if(averageRating(o2) < averageRating(o1)) return -1;
        if(averageRating(o2) > averageRating(o1)) return 1;
        return 0;
    }
}
