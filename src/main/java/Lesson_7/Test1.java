package Lesson_7;

public class Test1 {

    @BeforeSuite
    public void taskBefore() {
        System.out.println(getClass().getSimpleName() + " before");
    }

    @Test(10)
    public void task1() {
        System.out.println(getClass().getSimpleName() + " task1");
    }

    @Test(3)
    public void task2() {
        System.out.println(getClass().getSimpleName() + " task2");
    }

    @Test(4)
    public void task3() {
        System.out.println(getClass().getSimpleName() + " task3");
    }

    @Test(3)
    public void task4() {
        System.out.println(getClass().getSimpleName() + " task3");
    }

    @AfterSuite
    public void taskAfter() {
        System.out.println(getClass().getSimpleName() + " after");
    }

//    @BeforeSuite //exception
//    public void asdad() {}
}
