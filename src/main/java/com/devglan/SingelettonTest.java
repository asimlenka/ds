package com.devglan;

public final class SingelettonTest {

    //may return half initialised object in case of multiple thread trying to access get instance methood
    //because java runtime publishes half initailsed object to other threads
    private volatile static SingelettonTest obj = null;

    private SingelettonTest(){
        if(obj != null){
            throw new RuntimeException("error");
        }
    }

    public static SingelettonTest getInstance(){
        if(obj == null){
            synchronized(SingelettonTest.class) {
                if (obj == null) {
                    obj = new SingelettonTest();
                }
            }
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
