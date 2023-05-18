import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void shouldReturnLastMoviesWhenThereAreLessMoviesThanLimit() {
        MovieManager manager = new MovieManager(5);
        manager.add("Бладшот");
        manager.add("Вперед");
        manager.add("Джентельмены");
        String[] result = manager.findLast();

        Assertions.assertArrayEquals(new String[]{"Джентельмены", "Вперед", "Бладшот"}, result);
    }

    @Test
    public void shouldReturnLastMoviesWhenThereAreMoreMoviesThanLimit() {
        MovieManager manager = new MovieManager(2);
        manager.add("Бладшот");
        manager.add("Вперед");
        manager.add("Джентельмены");
        manager.add("Человек-невидимка");
        manager.add("Тролли. Мировой тур");
        String[] result = manager.findLast();

        Assertions.assertArrayEquals(new String[]{"Тролли. Мировой тур", "Человек-невидимка"}, result);
    }

    @Test
    public void shouldReturnAllMoviesWhenLimitEqualsNumberOfMovies() {
        MovieManager manager = new MovieManager(3);
        manager.add("Бладшот");
        manager.add("Вперед");
        manager.add("Джентельмены");
        String[] result = manager.findLast();

        Assertions.assertArrayEquals(new String[]{"Джентельмены", "Вперед", "Бладшот"}, result);
    }
}