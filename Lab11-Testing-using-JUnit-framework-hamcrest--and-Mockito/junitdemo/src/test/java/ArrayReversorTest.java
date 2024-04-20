import org.example.ArrayFlattener;
import org.example.ArrayFlattenerService;
import org.example.ArrayReversor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class ArrayReversorTest {
    @Mock
    ArrayFlattenerService arrayFlattenerService;
    ArrayReversor arrayReversor;
    @BeforeEach
    public void setUp() throws Exception{
        this.arrayReversor=new ArrayReversor();
        this.arrayFlattenerService= Mockito.mock(ArrayFlattener.class);
    }
    @AfterEach
    public void tearDown() throws Exception{
        this.arrayReversor=null;
        this.arrayFlattenerService=null;
    }
    @Test
    public void testIfReverseArrayIsCorrect(){
        arrayFlattenerService= Mockito.mock(ArrayFlattener.class);
        int[] expected=new int[]{9, 5, 4, 0, 3, 1};
        Mockito.when(arrayFlattenerService.flattenArray(Mockito.any())).thenReturn(new int[]{1,3,0,4,5,9});
        int[] actual=arrayReversor.reverseArray(new int [][]{{1,3}, {0}, {4,5,9}}, arrayFlattenerService);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testIfReverseArrayIsCorrectForNull(){
        int[] expected=null;
        int[] actual=arrayReversor.reverseArray(null, arrayFlattenerService);
        assertArrayEquals(expected, actual);
    }
}
