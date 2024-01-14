package tradearea.warehouse;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsReciver extends WarehouseController{

    private static String user = ActiveMQConnection.DEFAULT_USER;
    private static String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String subject = "warehouse";
    public boolean correct = false;
    public String data;
    public JmsReciver() {

        System.out.println("Receiver started.");

        // Create the connection.
        Session session = null;
        Connection connection = null;
        MessageConsumer consumer = null;
        Destination destination = null;


        try {

            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
            connection = connectionFactory.createConnection();
            connection.start();
            // Create the session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue(subject);
            // Create the consumer
            consumer = session.createConsumer(destination);
            // Start receiving

            Message message = consumer.receive(); // Blocking call to receive a message

            if (message instanceof ObjectMessage) {
                ObjectMessage objectMessage = (ObjectMessage) message;
                Object receivedObject = objectMessage.getObject();
                System.out.println("Message received: " + objectMessage);

            } else {
                System.out.println("Fehler 3");
            }

            /**while (message != null) {
                System.out.println("Message received: " + objectMessage);
                data += "  " + message.getText();
                message.acknowledge();
                message = (TextMessage) consumer.receive();
            }
             */
            connection.stop();

        } catch (Exception e) {

            System.out.println("[MessageConsumer] Caught: " + e);
            e.printStackTrace();

        } finally {

            try {
                consumer.close();
            } catch (Exception e) {
            }
            try {
                session.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
            System.out.println("Fehler");
        }
        System.out.println("Receiver finished.");

    }

    }