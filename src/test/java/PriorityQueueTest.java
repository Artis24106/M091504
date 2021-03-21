import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.PriorityQueue;
import java.util.stream.Stream;

class PriorityQueueTest {
    static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{-4, -8, 7, 6, 4}, new int[]{-8, -4, 4, 6, 7}),
                Arguments.of(new int[]{4, 8, 7, 6, 3}, new int[]{3, 4, 6, 7, 8}),
                Arguments.of(new int[]{48763, -48763, 8763, -8763}, new int[]{-48763, -8763, 8763, 48763}),
                Arguments.of(new int[]{1, 0, -1}, new int[]{-1, 0, 1})
        );
    }

    @ParameterizedTest(name = "#{index} - Test with Argument={0},{1}")
    @MethodSource("stringIntAndListProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array) {
        PriorityQueue<Integer> test = new PriorityQueue<>();
        int[] result = new int[random_array.length];

        for (int i : random_array) test.add(i);

        for (int i = 0; i < result.length; ++i) result[i] = test.poll();

        assertArrayEquals(correct_array, result);
    }

    @Test
    public void AddNullTest() {
        assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().add(null);
        });
    }

    @Test
    public void InitialCapacityTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(-1, null);
        });
    }

    @Test
    public void ForEachTest() {
        assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().forEach(null);
        });
    }
}