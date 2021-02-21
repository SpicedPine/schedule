package ejb.mdb;

import ejb.ConnectionBean;
import ejb.client.EventsConsumer;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(
        name = "subscriber",
        activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destination",
                propertyValue = "eventsTopic"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode",
                propertyValue = "Auto-acknowledge")})
public class JMSSubscriber implements MessageListener {
    private static String ALL_DAY_PROPERTY = "all_day";

    @Inject
    ConnectionBean connectionBean;

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        System.out.println("Received message from topic");
        try {
            System.out.println("message received: " + textMessage.getText());

            if(textMessage.propertyExists(ALL_DAY_PROPERTY)){
                System.out.println("all day property: " + textMessage.getStringProperty(ALL_DAY_PROPERTY));
                connectionBean.pushUpdate();
                /*EventsConsumer eventsConsumer = new EventsConsumer();
                eventsConsumer.getEventsForDay();*/
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
