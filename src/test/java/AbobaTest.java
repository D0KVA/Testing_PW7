import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class AbobaTest {
    private final Aboba aboba = new Aboba();

    @Test
    @DisplayName("Тест: Найти слово с наибольшим количеством И")
    void findWordWithMostI() {
        assertEquals("Игра", aboba.findWordWithMostI("Игра Идёт Идеально"));
        assertEquals("ПИрИвет", aboba.findWordWithMostI("ПИрИвет мир"));
        assertEquals("Искусство", aboba.findWordWithMostI("Искусство Идея Игра"));
        assertEquals("", aboba.findWordWithMostI(""));
        assertEquals("Идея", aboba.findWordWithMostI("Идея идея ИДЕЯ"));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3, 4, 5",
            "1, 0, 0, 1, 2",
            "0, 0, 0, 0, 0",
            "5, 0, 0, 5, 10"
    })
    @DisplayName("Тест: Максимальная сумма диагоналей")
    void maxDiagonalSum(int a11, int a12, int a21, int a22, int expected) {
        int[][] matrix = {
                {a11, a12},
                {a21, a22}
        };
        assertEquals(expected, aboba.maxDiagonalSum(matrix));
    }

    @Test
    @DisplayName("Тест: Получить инициалы")
    void getInitials() {
        assertEquals("ПМОJ", aboba.getInitials("Привет мир от Java"));
        assertEquals("", aboba.getInitials(""));
        assertEquals("AAA", aboba.getInitials("a a A"));
        assertEquals("ЯЛР", aboba.getInitials("я люблю россию"));
    }

    @Test
    @Disabled("Этот тест отключен")
    void disabledTest() {
        fail("Бебебе");
    }

    @Test
    @DisplayName("Тест: Проверка на ошибку")
    void testForException() {
        assertThrows(NullPointerException.class, () -> aboba.findWordWithMostI(null));
    }

    @Test
    @DisplayName("Тест: Проверка времени выполнения")
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            aboba.getInitials("Тестовая строка для проверки времени выполнения");
        });
    }
}