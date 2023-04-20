package is.hi.hbv202g.finalassignment;

import java.util.HashMap;

public class ResultStorageSingleton {
    private static ResultStorageSingleton INSTANCE = null;

    private HashMap<String, Boolean> resultsHashmap = new HashMap<>();

    public static ResultStorageSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ResultStorageSingleton();
        }
        return INSTANCE;
    }
    protected ResultStorageSingleton() {
    }

    public void addResult(String testName, boolean result) {
        resultsHashmap.put(testName, result);
    }

    @Override
    public String toString() {
        StringBuilder results = new StringBuilder("The results of the tests are: \n");
        for (String key : resultsHashmap.keySet()) {
            results.append(key).append(": ").append(resultsHashmap.get(key)).append("\n");
        }
        return results.toString();
    }
}
