package db;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import messages.SetRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aleks on 7.2.2017..
 */
public class LegendaryDb extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
    protected final Map<String, Object> map = new HashMap<>();

    private LegendaryDb(){
        receive(ReceiveBuilder.match(SetRequest.class, message -> {
            log.info("Received set request - key: {} value: - {}", message.getKey(), message.getValue());
            map.put(message.getKey(), message.getValue());
        }).matchAny(o -> log.info("received unknown message {}", o)).build());
    }

    public Object get(String key){
        return map.get(key);
    }
}
