package myfirstproject;

import org.junit.*;

public class Day02_FirstJUnitClass {
/*
     no more main method
     @Test annotation is used to create test cases

     JUnit is a type of testing framework
     it is one of the oldest Java testing framework
     developers also use JUnit for Unit Testing
     TESTERS ALSO USE UNIT TESTING TO CREATE JUNIT TEST FRAMEWORK
     JUnit has 7 major annotations
     1. @Test annotation is used to create test cases
     NOTE: all test methods will be void
     because test methods are used for assertions
     2. @Before  :runs before each @Test annotation(before each test)
        this is a support method
     3. @After : runs after each @Test annotation (after each test)
     4. @BeforeClass : only runs once before each class
     5. @AfterClass : only runs once after each class
     6. @Ignore : to skip a test case

     **********JUNIT ASSERTIONS
     we use JUnit assertion to check if expected and actual  are equal
     instead of if else statemenet , we will use junit assertions
     it will come from Assert class

     1. Assert.assertEquals("expected", "actual");
     2. Assert.assertTrue("ACTUAL".contains("EXPECTED"));
     3. Assert.assertFalse("ACTUAL".contains("EXPECTED"));



*/
    @Before
    public void setUp(){
        System.out.println("This is Before method");
    }
    @Test
    public void test1(){
        System.out.println("This is Test 1");
    }
    @Test
    public void test2(){
        System.out.println("This is Test 2");
    }
    @Ignore
    public void test3(){
        System.out.println("This is Test 3");
    }
    @Test
    public void test4(){
        System.out.println("This is Test 4");
    }
    @After
    public void tearDown(){
        System.out.println("This is TEARDOWN method");
    }

    // ASSERTION
    // If fexpected == actual

    @Test
    public void assertions(){
        // Assert.assertEquals("ACTUAL", "EXPECTED);
            Assert.assertEquals("java","java");
       // if assertion fails, we see an error message on the console
        // if assertion pass, we see a green checkbox

        //    2. Assert.assertTrue(BOOLEAN);
        Assert.assertTrue("Selenium".contains("e")); // the condition should be true to pass

        // 3. Assert.assertFalse(BOOLEAN);
        Assert.assertFalse("Selenium".contains("a")); // the condition should be false to pass

        Assert.assertEquals("Ohh no","java","java");
        // when there is 3 parameters, first one is message written on the console
        // message will be only displayed when assertion fails

    }






}
