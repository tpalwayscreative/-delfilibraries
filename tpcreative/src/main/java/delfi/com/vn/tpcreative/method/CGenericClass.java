package delfi.com.vn.tpcreative.method;

/**
 * Created by PC on 8/2/2017.
 */

public class CGenericClass <T>{
    private final Class<T> type;

    public CGenericClass(Class<T> type) {
        this.type = type;
    }

    public Class<T> getMyType() {
        return this.type;
    }
}
