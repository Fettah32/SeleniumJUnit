package day_10;

import org.junit.Test;
import utilities.TestBaseBeforeAfter;

public class C01_IlkTestBaseClassBeforeAfter extends TestBaseBeforeAfter {

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
    }
}
