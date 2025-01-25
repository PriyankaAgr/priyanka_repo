import org.example.dsa.RateLimiter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

@RunWith(JUnit4ClassRunner.class)
public class TestRateLimiter {
    RateLimiter rateLimiter;

    @Before
    public void beforeTest(){
        rateLimiter= new RateLimiter(1000L, 2, 0);
       // Customer customer1 = new Customer(3, 1000L, 0);
        //Customer customer2 = new Customer(2, 1000L, 0);
        //Customer customer3 = new Customer(5, 1000L, 0);

    }

    @Test
    public void test_limitrateReturnsTrue(){
        for(int i=0;i<3;i++) {
            Assert.assertTrue(rateLimiter.allowedRequest(123));
        }

        Assert.assertFalse(rateLimiter.allowedRequest(123));


    }


}
