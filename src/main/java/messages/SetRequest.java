package messages;

/**
 * Created by aleks on 7.2.2017..
 */
public class SetRequest {
    private final String key;
    private final Object value;

    public SetRequest(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey(){
        return key;
    }

    public Object getValue(){
        return value;
    }
}
