public class MovieManager {
    private String[] movies;
    private int limit;

    public MovieManager() {
        limit = 5;
        movies = new String[0];
    }

    public MovieManager(int limit) {
        this.limit = limit;
        movies = new String[0];
    }

    public void add(String name) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[movies.length] = name;
        movies = tmp;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] findLast() {
        int resultLength;
        if (limit < movies.length) {
            resultLength = limit;
        } else {
            resultLength = movies.length;
        }
        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}