import org.junit.Test;
import static org.junit.Assert.*;


public class TestSort {
    @Test
    public static void testSort(){
        String[] input = {"they", "changed", "the", "system"};
        String[] expected = {"changed", "system", "the", "they"};

        Sort.sort(input);
        assertArrayEquals(expected, input);

    }

    public static void main(String[] args) {
        testSort();
    }
}
