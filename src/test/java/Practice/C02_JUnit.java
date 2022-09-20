package Practice;

import org.junit.*;

public class C02_JUnit {

    @Before
    public void setUp() {
        System.out.println("Before");
    }

    @After
    public void tearDown() {
        System.out.println("After");
    }

    @BeforeClass
    public static void setUp01() {
        System.out.println("Before Class");
    }

    @AfterClass
    public static void tearDown01() {
        System.out.println("After Class");
    }


    @Test
    public void test01() {
        System.out.println("Test 01");

    }

    @Test
    public void test02() {
        System.out.println("Test 02");

    }

    @Test
    public void test03() {
        System.out.println("Test 03");

    }
}
