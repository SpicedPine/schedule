package ejb.client;

import javax.ejb.Startup;
import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import dto.EventDTO;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import java.util.List;

@Named
@Startup
@Stateful
@ApplicationScoped
public class EventsConsumer {
    private static String EVENTS_STORAGE_URL = "http://localhost:8081/schedule/events";

    public List<EventDTO> getEventsForDay(){
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(EVENTS_STORAGE_URL);
        Response response = target.request().get();
        System.out.println("сюда дощел 1");
        List<EventDTO> eventDTOList = response.readEntity(new GenericType<List<EventDTO>>() {
        });
        System.out.println("сюда дощел 2");
        response.close();

        return eventDTOList;
    }
}
