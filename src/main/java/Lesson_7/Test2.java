package Lesson_7;

public class Test2 {
    @AfterSuite
    public void tastAfter() {
        System.out.println(getClass().getSimpleName() + " after");
    }

    @Test
    public void task1() {
        System.out.println(getClass().getSimpleName() + " task1");
    }

    @Test(3)
    public void task2(){
        System.out.println(getClass().getSimpleName() + " task2");
    }

}