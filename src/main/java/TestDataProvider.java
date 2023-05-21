import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.Iterator;

public class TestDataProvider {

    @DataProvider(name = "create")
    public Iterator<Object[]> createDataByIterator() {
        return Arrays.asList(
                new Object[]{"Alice", "Summers"},
                new Object[]{"David", "Johnson"}
        ).iterator();
    }
}
