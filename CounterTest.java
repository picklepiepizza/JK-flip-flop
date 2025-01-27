import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class CounterTest
{

    Counter counter;

    @Before
    public void init() {
        this.counter = new Counter(3);
    }

    @Test
    public void pulseTest() {

        this.counter.pulse();
        this.counter.pulse();
        this.counter.pulse();

        Assert.assertTrue(this.counter.read() == 3);

    }

    @Test
    public void readTest() {

        Assert.assertTrue(this.counter.read() == 0);

    }

    @Test
    public void getJKsTest() {

        Assert.assertTrue(this.counter.getJKs().length == 3);

    }

}