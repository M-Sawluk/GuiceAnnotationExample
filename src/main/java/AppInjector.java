import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

public class AppInjector extends AbstractModule {
    protected void configure() {
        bindListener(Matchers.any(), new MichalResourceLoader());

    }
}
