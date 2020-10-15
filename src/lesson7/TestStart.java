package lesson7;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotation;

import javax.swing.plaf.synth.SynthStyle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestStart {

    public static void start(Class c) throws InvocationTargetException, IllegalAccessException {
        int counterBeforeSuite = 0;
        int counterAfterSuite = 0;
        ArrayList<Method> list = new ArrayList<>();
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)){
                list.add(m);
            }
        }
        list.sort(Comparator.comparingInt((Method i) -> i.getAnnotation(Test.class).priority()).reversed());

        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)){
                counterBeforeSuite++;
                if ( counterBeforeSuite > 1){
                    throw new RuntimeException(" Аннотаций @BeforeSuite > 1");
                }
            } list.add(0,m);
        }
        for (Method m : methods) {
            if (m.isAnnotationPresent(AfterSuite.class)){
                counterAfterSuite++;
                if (counterAfterSuite > 1){
                    throw new RuntimeException(" Аннотаций @AfterSuite > 1");
                }
            } list.add(m);
        }

        for (Method m : methods) {
            m.invoke(null);
        }
    }
}


