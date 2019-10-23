import java.lang.reflect.InvocationHandler;
import java.util.*;

public class Main {
    private static void fill(Collection<StringBuffer>collection, int elementCount){
        if(collection==null||elementCount<=0)
            return;
        for (int i=0;i<= elementCount; i++){
            collection.add(new StringBuffer("tempElement#"+i));
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
//        final Integer profiledObject = new Integer(3);
//        final InvocationHandler invocationHandler = new InvocationHandlerImpl(profiledObject);
//        final Profiler profiler = new Profiler(new Class[]{Comparable.class},invocationHandler);
//        System.out.println(((Comparable)profiler.getProxyInstance()).compareTo(profiledObject));
//        ----------------------------

        final int initialCapacity = 100;
        final Collection<StringBuffer> profiledObject1 = new ArrayList<>(initialCapacity);
        fill(profiledObject1,initialCapacity);
        final InvocationHandler invocationHandler = new InvocationHandlerImpl(profiledObject1);

        final Profiler profiler = new Profiler(new Class[]{Comparable.class, List.class},invocationHandler);
        for (int i =0; i<= initialCapacity;i++){
            System.out.println(((List)profiler.getProxyInstance()).get(i));
        }

//        Collections.fill();
    }
}
