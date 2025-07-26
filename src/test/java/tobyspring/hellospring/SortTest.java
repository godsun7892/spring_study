package tobyspring.hellospring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SortTest {
    Sort sort;

    @BeforeEach
    void beforeEach() {
        // 준비
        sort = new Sort();
    }

    @Test
    void sort() {

        // 실행
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));

        // 검증
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa"));
    }

    @Test
    void sort3Items() {
        // 준비
        Sort sort = new Sort();

        // 실행
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b", "CCcc"));

        // 검증
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa", "CCcc"));
    }
}
