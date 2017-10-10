package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author TrollerX
 */
public class Reference {

    private RatingRegister register;

    public Reference(RatingRegister register) {
        this.register = register;
    }

    public Film recommendFilm(Person person) {
//        System.out.println("XXXXXXXX New Person: " + person + " XXXXXXXXX");
        Map<Film, Rating> personFilms = new HashMap<Film, Rating>();

        try {
            personFilms = new HashMap<Film, Rating>(register.getPersonalRatings(person));
        } catch (Exception e) {
        }

        if (personFilms.isEmpty()) {
            return getBestFilm();
//            Map<Film, List<Rating>> filmRatings = ratingRegister.filmRatings();
////            System.out.println("Film ratings: " + filmRatings);
//            List<Film> films = new ArrayList<Film>();
//            for (Film film : filmRatings.keySet()) {
//                films.add(film);
//            }
////            System.out.println("Films before sorting: " + films);
//            Collections.sort(films, new FilmComparator(filmRatings));
////            System.out.println("Films after sorting: " + films);
//            return films.get(0);
        }
//        System.out.println("Person's films: " + personFilms);
        List<Person> reviewers = register.reviewers();
//        System.out.println("reviewers after initialisation: " + reviewers);
        Map<Person, Integer> similarities = new HashMap<Person, Integer>();

        for (Person reviewer : reviewers) {
//            System.out.println("**********loop***********");
            if (reviewer.equals(person)) {
                continue;
            }
            Map<Film, Rating> reviewerFilms = new HashMap<Film, Rating>(register.getPersonalRatings(reviewer));
//            System.out.println("reviewer: " + reviewer + "\nreviewerFilms: " + reviewerFilms);
            Iterator<Film> iterator = reviewerFilms.keySet().iterator();
            while (iterator.hasNext()) {
                if (!personFilms.containsKey(iterator.next())) {
                    iterator.remove();
                }
            }
//            System.out.println("reviewerFilms after matching: " + reviewerFilms);
            if (reviewerFilms.isEmpty()) {
                continue;
            }
            int reviewerRating;
            int personRating;
            int similarity = 0;

            for (Film film : reviewerFilms.keySet()) {
                reviewerRating = reviewerFilms.get(film).getValue();
//                System.out.println("reviewer rating of " + film + ": " + reviewerRating);
                personRating = personFilms.get(film).getValue();
//                System.out.println("person's rating of " + film + ": " + personRating);
//                System.out.println("similarity: " + reviewerRating * personRating);
                similarities.put(reviewer, similarity += reviewerRating * personRating);

            }
        }
//        System.out.println("++++ End loop ++++");
//        System.out.println("similarities: " + similarities);
        Iterator<Person> it = reviewers.iterator();
//        System.out.println("reviewers before remove " + reviewers);
        while (it.hasNext()) {
            if (!similarities.keySet().contains(it.next())) {
                it.remove();
            }
        }
//        System.out.println("similarities: " + similarities);
//        System.out.println("reviewers after remove and before sorting: " + reviewers);
        Collections.sort(reviewers, new PersonComparator(similarities));
//        System.out.println("reviewers after sorting: " + reviewers);
        Map<Film, Rating> similarReviewerFilms = new HashMap<Film, Rating>(register.getPersonalRatings(reviewers.get(0)));
//        System.out.println("similarReviewerFilms: (" + reviewers.get(0) + ") " + similarReviewerFilms);
        Iterator<Film> iterator = similarReviewerFilms.keySet().iterator();

        while (iterator.hasNext()) {
            if (personFilms.containsKey(iterator.next())) {
                iterator.remove();
            }
        }

//        System.out.println("similarReviewerFilms (" + reviewers.get(0) + ") after cleaning:  " + similarReviewerFilms);
//        System.out.println("Iterating through similarReviewerFilms:");
        int highestRating = 1;
        for (Film film : similarReviewerFilms.keySet()) {
            int rating = similarReviewerFilms.get(film).getValue();
//            System.out.println("Film: " + film + " Rating: " + rating);
            if (rating > highestRating) {
                highestRating = rating;
            }
        }
//        System.out.println("highest rating: " + highestRating);
        if (!(highestRating > 1)) {
            return null;
        }

        return getFilmByValue(similarReviewerFilms, highestRating);
    }

    public Film getBestFilm() {
        Map<Film, List<Rating>> filmRatings = register.filmRatings();
//            System.out.println("Film ratings: " + filmRatings);
        List<Film> films = new ArrayList<Film>();
        for (Film film : filmRatings.keySet()) {
            films.add(film);
        }
//            System.out.println("Films before sorting: " + films);
        Collections.sort(films, new FilmComparator(filmRatings));
//            System.out.println("Films after sorting: " + films);
        return films.get(0);
    }

    public static Film getFilmByValue(Map<Film, Rating> ratings, int rating) {
        for (Entry<Film, Rating> entry : ratings.entrySet()) {
//            System.out.println("Entry: " + entry);
            if (Objects.equals(rating, entry.getValue().getValue())) {
//                System.out.println("Film match: " + entry.getKey());
                return entry.getKey();
            }
        }
        return null;
    }

}
