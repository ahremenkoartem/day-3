import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Profiler {
    private final Class[] interfaces;
    private final Object proxy;
    private final InvocationHandler invocationHandler;

    public Profiler(Class[] interfaces, InvocationHandler invocationHandler) {
        this.interfaces = interfaces;
        this.invocationHandler = invocationHandler;
        this.proxy = Proxy.newProxyInstance(null, this.interfaces, this.invocationHandler);
    }

    public Object getProxyInstance() {
        return proxy;
    }
}
