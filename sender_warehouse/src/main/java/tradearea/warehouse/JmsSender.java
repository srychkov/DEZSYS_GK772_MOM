package tradearea.warehouse;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Serializable;

public class JmsSender {

    private static String user = ActiveMQConnection.DEFAULT_USER;
    private static String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String subject = "warehouse";


    Session session = null;
    Connection connection = null;
    MessageProducer producer = null;
    Destination destination = null;


    public JmsSender(String subject) {

        System.out.println( "Sender started." );

        try {

            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory( user, password, url );
            connection = connectionFactory.createConnection();
            connection.start();

            // Create the session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue( subject );

            // Create the producer.
            producer = session.createProducer(destination);
            producer.setDeliveryMode( DeliveryMode.NON_PERSISTENT );     //IF you restart activemq/stop all messages will be lost


        } catch (Exception e) {

            System.out.println("[MessageProducer] Caught: " + e);
            e.printStackTrace();

        }
        System.out.println( "Sender finished." );

    } // end main

    public void stop() {
        try {
            producer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            System.err.println("Failed while closing " + e);
        }
    }

    public void sendMessage(Serializable obj) {
        try {
            ObjectMessage message = session.createObjectMessage(obj);
            producer.send(message);
            System.out.println("Send data: " + obj.toString());
        } catch (JMSException e) {
            System.err.println("Error while sending Message: " + e);
        }
    }

}