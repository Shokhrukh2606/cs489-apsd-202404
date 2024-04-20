import org.example.ArrayFlattener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ArrayFlattenerTest {
    private ArrayFlattener arrayFlattener=null;

    @BeforeEach
    public void setUp() throws Exception{
        this.arrayFlattener=new ArrayFlattener();
    }
    @AfterEach
    public void tearDown() throws Exception{
        this.arrayFlattener=null;
    }
    @Test
    public final void testIfFlattenedArrayIsCorrect(){
        int a_in[][]=new int [][]{{1,3}, {0}, {4,5,9}};
        int actual[] = new int[a_in.length*a_in[0].length];
        actual=arrayFlattener.flattenArray(a_in);
        int[] expected=new int []{1,3,0,4,5,9};
        assertArrayEquals(expected, actual);
    }
    @Test
    public final void testIfFlattenedArrayNull(){
        int[] expected=null;
        int[] actual=arrayFlattener.flattenArray(null);
        assertArrayEquals(expected, actual);
    }
}
