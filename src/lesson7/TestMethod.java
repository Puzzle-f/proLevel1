package lesson7;

public class TestMethod extends TestStart{

    @Test (priority = 8)
    public static void testMethod1(){
        System.out.println("test-1 run");
    };

    @Test
    public static void testMethod2(){
        System.out.println("test-2 run");
    };
    @Test
    public static void testMethod3(){
        System.out.println("test-3 run");
    };

    @BeforeSuite
    public static void testPriority(){
        System.out.println(" Приоритет: 10");
    }

    @AfterSuite
    public static void testPriority2(){
        System.out.println(" Приоритет: 1");
    }
}
