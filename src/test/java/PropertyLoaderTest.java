import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


@SuppressWarnings("ALL")
public class PropertyLoaderTest {

    Injector injector;
    ResHolder resHolder1;
    ResHolder resHolder2;
    @Before
    public void init() {
        injector = Guice.createInjector(new AppInjector());
    }

    @Test
    public void dwaWatki() throws InterruptedException {
        Thread thread1 = new Thread(getRunnable1());
        Thread thread2 = new Thread(getRunnable2());
        resHolder1 = injector.getInstance(ResHolder.class);
        resHolder2 = injector.getInstance(ResHolder.class);
        Assert.assertEquals(resHolder1, resHolder2);
        thread1.start();
        thread2.start();


    }

    Runnable getRunnable1() {
        return new Runnable() {
            public void run() {

                Assert.assertEquals(resHolder1.getCharproperty(), 'm');
                Assert.assertEquals(resHolder1.getCzyMichalJestMistrzem(), true);
                Assert.assertEquals(resHolder1.getNumber(), 23123123);
                Assert.assertEquals(resHolder1.getProperty(), "mistrz");
            }
        };
    }
    Runnable getRunnable2() {
        return new Runnable() {
            public void run() {

                Assert.assertEquals(resHolder2.getCharproperty(), 'm');
                Assert.assertEquals(resHolder2.getCzyMichalJestMistrzem(), true);
                Assert.assertEquals(resHolder2.getNumber(), 23123123);
                Assert.assertEquals(resHolder2.getProperty(), "mistrz");
            }
        };
    }
}
