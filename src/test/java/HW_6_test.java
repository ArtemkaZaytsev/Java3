import Lesson_6.HW_6;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class HW_6_test {




    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{

                {6, 7, 8, 4, 5, 3, 2}, {5, 3, 2},
                {6, 7, 8, 5, 4, 7, 9}, {7, 9},
                {7, 6, 4, 8, 9, 5, 3}, {8, 9, 5, 3},
                {5, 4, 9, 1, 22, 4, 6}, {9, 1, 22, 4, 6},

        });

    }

    private int  a [];
    private int  b [];

    public HW_6_test(int[] a, int [] b) {
        this.a = a;
        this.b = b;
    }


    HW_6 checker;
    @Before
    public void init(){
        checker = new HW_6();
    }

    @Test
    public void massTestAdd (){
        Assert.assertArrayEquals(a, HW_6.checkArray1(b));
    }
}