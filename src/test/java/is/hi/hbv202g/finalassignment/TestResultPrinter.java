package is.hi.hbv202g.finalassignment;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestResultPrinter extends TestWatcher {

    ResultStorageSingleton resultStorageSingleton = ResultStorageSingleton.getInstance();

    @Override
    protected void succeeded(Description description) {
        resultStorageSingleton.addResult(description.getMethodName(), true);
    }

    @Override
    protected void failed(Throwable e, Description description) {
        resultStorageSingleton.addResult(description.getMethodName(), false);
    }
}
