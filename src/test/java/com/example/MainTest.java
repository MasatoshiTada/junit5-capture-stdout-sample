package com.example;

import org.junit.jupiter.api.Test;

/**
 * JUnit 5のテストクラス
 */
public class MainTest {

    @Test
    public void testMain1() {
        Main.main(null);
    }

    @Test
    public void testMain2() {
        Main.main(new String[0]);
    }

    @Test
    public void testMain3() {
        Main.main(new String[]{"Alice"});
    }

}
