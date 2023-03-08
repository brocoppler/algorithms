import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KaratsubaTest {
    @Test
    void multiply() {
        int x = 56789;
        int y = 1234;
        long product = Karatsuba.karatsuba(x, y);
        assertEquals(x * y, product);
    }

}