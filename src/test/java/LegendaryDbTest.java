import db.LegendaryDb;
import messages.SetRequest;
import org.junit.AfterClass;
import scala.concurrent.duration.Duration;
import akka.actor.*;
import akka.testkit.JavaTestKit;
import akka.testkit.TestActorRef;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LegendaryDbTest {
    ActorSystem system = ActorSystem.create();

    @Test
    public void itShouldPlaceKeyValueFromSetMessageIntoMap(){
        TestActorRef<LegendaryDb> actorRef = TestActorRef.create(system, Props.create(LegendaryDb.class));
        actorRef.tell(new SetRequest("key", "value"), ActorRef.noSender());
        LegendaryDb legendaryDb = actorRef.underlyingActor();
        assertEquals(legendaryDb.get("key"), "value");
    }

}
