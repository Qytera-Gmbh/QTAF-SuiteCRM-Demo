package foo;

import com.google.inject.Singleton;
import de.qytera.qtaf.core.guice.QtafModule;
import org.testng.annotations.Guice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Singleton
@Guice(
        modules = {QtafModule.class}
)
public @interface PageObject {
}
