package de.qytera.suite_crm;

import com.google.inject.Injector;
import de.qytera.qtaf.core.context.IQtafTestContext;
import de.qytera.qtaf.core.guice.QtafInjector;
import de.qytera.qtaf.testng.context.QtafTestNGContext;

public class TestContext extends QtafTestNGContext {

    /**
     * Guice injector
     */
    protected static final Injector injector = QtafInjector.getInstance();

    /**
     * Load class instance
     * @param context   The current test context (pass 'this' for this argument)
     * @param c         The desired class you want to create an instance of
     * @return          Instance of the desired class
     */
    protected static <T> T load(IQtafTestContext context, Class<T> c) {
        IQtafTestContext pageObject = (IQtafTestContext) injector.getInstance(c);
        pageObject.setLogCollection(context.getLogCollection());
        return (T) pageObject;
    }

    /**
     * Load class instance
     * @param c         The desired class you want to create an instance of
     * @return          Instance of the desired class
     */
    protected <T> T load(Class<T> c) {
        return load(this, c);
    }
}
