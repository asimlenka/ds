package com.devglan;

public final class SingelettonTest {

    private static SingelettonTest obj = null;

    private SingelettonTest(){
        if(obj != null){
            throw new RuntimeException("error");
        }
    }

    public static SingelettonTest getInstance(){
        if(obj == null){
            obj = new SingelettonTest();
        }
        return obj;
    }

    public static void main(String [] args) throws ClassNotFoundException {
        Class<?> test = Class.forName("com.devglan.SingelettonTest");
        test.getDeclaredConstructors()[0].setAccessible(true);
        SingelettonTest test1 = new SingelettonTest();
        System.out.println(SingelettonTest.getInstance());
        System.out.println(test1);
    }
}
