import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    private MovieManager manager;

    @BeforeEach
    void setUp() {
        manager = new MovieManager();
    }

    @Test
    void testAdd() {
        manager.add("Бладшот");
        MovieManager.Movies[] movies = manager.findAll();
        Assertions.assertEquals(1, movies.length);
        Assertions.assertEquals("Бладшот", movies[0].getName());
    }

    @Test
    void testFindAll() {
        manager.add("Бладшот");
        manager.add("Вперед");
        MovieManager.Movies[] movies = manager.findAll();
        Assertions.assertEquals(2, movies.length);
        Assertions.assertEquals("Бладшот", movies[0].getName());
        Assertions.assertEquals("Вперед", movies[1].getName());
    }

    @Test
    void testFindLastWhenNoMovies() {
        MovieManager.Movies[] movies = manager.findLast();
        Assertions.assertEquals(0, movies.length);
    }

    @Test
    void testFindLastForLessThanLimit() {
        manager.add("Бладшот");
        manager.add("Вперед");
        MovieManager.Movies[] movies = manager.findLast();
        Assertions.assertEquals(2, movies.length);
        Assertions.assertEquals("Бладшот", movies[0].getName());
        Assertions.assertEquals("Вперед", movies[1].getName());
    }

    @Test
    void testFindLastForMoreThanLimit() {
        manager.add("Бладшот");
        manager.add("Вперед");
        manager.add("Джентельмены");
        manager.add("Человек-невидимка");
        manager.add("Тролли. Мировой тур");
        manager.add("Номер один");
        MovieManager.Movies[] movies = manager.findLast();
        Assertions.assertEquals(5, movies.length);
        Assertions.assertEquals("Вперед", movies[0].getName());
        Assertions.assertEquals("Джентельмены", movies[1].getName());
        Assertions.assertEquals("Человек-невидимка", movies[2].getName());
        Assertions.assertEquals("Тролли. Мировой тур", movies[3].getName());
        Assertions.assertEquals("Номер один", movies[4].getName());
    }
}