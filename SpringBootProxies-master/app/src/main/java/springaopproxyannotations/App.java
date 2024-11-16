package springaopproxyannotations;

import java.lang.reflect.Proxy;


import springaopproxyannotations.classes.Man;
import springaopproxyannotations.classes.Person;
import springaopproxyannotations.classes.PersonInvocationHandler;


public class App {


    public static void main(String[] args) {
        Man mohan = new Man("Mohan", 30, "Delhi", "India");
        ClassLoader mohanClassLoader =  mohan.getClass().getClassLoader();
        Class[] interfaces = mohan.getClass().getInterfaces();
        Person proxyMohan = (Person) Proxy.newProxyInstance(mohanClassLoader, interfaces, new PersonInvocationHandler(mohan));
        proxyMohan.introduce(mohan.getName());
    }
}

