package GetName;

import org.junit.Test;

import static GetName.GetNameFile.GetNameFileMethod;
import static org.junit.Assert.assertEquals;

public class GetNameFileTest {

    @Test
    public void getNameFile() {
        String test = GetNameFileMethod("213/3213");
        assertEquals("3213", test);
    }
}