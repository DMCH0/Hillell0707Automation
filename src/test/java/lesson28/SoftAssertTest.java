package lesson28;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

    @Test
    public void testCaseOne() {
        org.testng.asserts.SoftAssert softAssert = new SoftAssert();
        System.out.println("test one started");
        softAssert.assertEquals(5, 5);
        System.out.println("hard assert success...");
        softAssert.assertTrue("Hello".equals("hello"));
        System.out.println("test case execute successfully");
        softAssert.assertAll();
    }
}

