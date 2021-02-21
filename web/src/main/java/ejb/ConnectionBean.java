package ejb;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ConnectionBean {

    @Inject
    @Push(channel = "connection")
    private PushContext connection;

    public void pushUpdate() {
        connection.send("Update schedule");
    }
}
