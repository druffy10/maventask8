public class MovieManager {
    private int limit;
    private Movies[] movie;

    public MovieManager() {
        this.limit = 5;
        this.movie = new Movies[0];
    }

    public MovieManager(int limit) {
        this.limit = limit;
        this.movie = new Movies[0];
    }

    public void add(String name) {
        Movies newMovie = new Movies(name);
        Movies[] tmp = new Movies[movie.length + 1];
        for (int i = 0; i < movie.length; i++) {
            tmp[i] = movie[i];
        }
        tmp[tmp.length - 1] = newMovie;
        movie = tmp;
    }

    public Movies[] findAll() {
        return movie;
    }

    public Movies[] findLast() {
        int resultLength;
        if (movie.length >= limit) {
            resultLength = limit;
        } else {
            resultLength = movie.length;
        }
        Movies[] result = new Movies[resultLength];
        for (int i = resultLength - 1, j = 0; i >= 0; i--, j++) {
            result[j] = movie[movie.length - resultLength + j];
        }
        return result;
    }

    public class Movies {
        private String name;
        public Movies(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }
}