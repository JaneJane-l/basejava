package com.urise.webapp.util;

import java.util.HashMap;
import java.util.Map;

public class LazySingleton {



    int i;
     private static volatile LazySingleton INSTANCE;

    private LazySingleton() {


    }

  /*  public static LazySingleton getInstance(){
        if (INSTANCE==null){
            synchronized (LazySingleton.class){
                if (INSTANCE==null){
                    int i= 13;
                    INSTANCE= new LazySingleton();
                }
            }
        }
        return INSTANCE;
    }*/


    private static class LasySingletonHolder{
        private static final LazySingleton INSTANCE = new LazySingleton();
    }
    public static LazySingleton getInstance(){
        return LasySingletonHolder.INSTANCE;
    }
}
