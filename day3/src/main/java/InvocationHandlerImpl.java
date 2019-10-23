import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerImpl implements InvocationHandler {
    private final Object targetobject;

    public InvocationHandlerImpl(Object targetobject) {
        this.targetobject = targetobject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Calling method = " + method + "on " + targetobject);
        final long startTime = System.nanoTime();
        Object result =method.invoke(targetobject, args);
        if(method.getName().startsWith("get")){
           ((StringBuffer) result).delete(0,12);
        }
        final long finishTime = System.nanoTime();
        System.out.println("method execution time: "+(finishTime-startTime));
        return result;
    }
}
