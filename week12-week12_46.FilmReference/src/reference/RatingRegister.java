package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author TrollerX
 */
public class RatingRegister {

    private Map<Person, Map<Film, Rating>> personalRatings;
    private Map<Film, List<Rating>> filmRatings;

    public RatingRegister() {
        this.personalRatings = new HashMap<Person, Map<Film, Rating>>();
        this.filmRatings = new HashMap<Film, List<Rating>>();
    }

    public void addRating(Film film, Rating rating) {
        if (!filmRatings.containsKey(film)) {
            filmRatings.put(film, new ArrayList<Rating>());
        }
        filmRatings.get(film).add(rating);
    }

    public List<Rating> getRatings(Film film) {
        return filmRatings.get(film);
    }

    public Map<Film, List<Rating>> filmRatings() {
        return filmRatings;
    }

    public void addRating(Person person, Film film, Rating rating) {
        if (!personalRatings.containsKey(person)) {
            personalRatings.put(person, new HashMap<Film, Rating>());
        }
        personalRatings.get(person).put(film, rating);
        addRating(film, rating);
    }

    public Rating getRating(Person person, Film film) {
        if (!personalRatings.get(person).containsKey(film)) {
            return Rating.NOT_WATCHED;
        }
        return personalRatings.get(person).get(film);
    }

    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (!personalRatings.containsKey(person)) {
//            personalRatings.put(person, new HashMap<Film, Rating>());
//            return personalRatings.get(person);
            return new HashMap();
        }
        return personalRatings.get(person);
    }

    public List<Person> reviewers() {
        return new ArrayList<Person>(personalRatings.keySet());
//        List<Person> reviewers = new ArrayList<Person>();
//        Iterator<Person> iterator = personalRatings.keySet().iterator();
//        while (iterator.hasNext()) {
//            Person person = iterator.next();
//            reviewers.add(person);
//        }
//        return reviewers;
    }
}
