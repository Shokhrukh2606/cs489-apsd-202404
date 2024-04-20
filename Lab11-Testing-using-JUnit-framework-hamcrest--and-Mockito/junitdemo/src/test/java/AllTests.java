import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ArrayFlattenerTest.class, ArrayReversorTest.class})
public class AllTests {
}
