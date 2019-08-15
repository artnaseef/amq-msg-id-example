package com.artnaseef.sandbox;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;

public class MessageIdExample {
	public static void	main(String[] args) {
		BrokerService brokerService = null;
		Connection connection = null;

		try {
			brokerService = startBroker();

			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

			connection = connectionFactory.createConnection();
			connection.start();

			Session session          = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue dest               = session.createQueue("sandbox.test.queue");
			MessageProducer producer = session.createProducer(dest);

			TextMessage textMessage  = session.createTextMessage("Hello World");
			System.out.println("Message ID on message creation: " + textMessage.getJMSMessageID());

			producer.send(dest, textMessage);

			System.out.println("Message ID after message send: " + textMessage.getJMSMessageID());
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}

			if (brokerService != null) {
				try {
					brokerService.stop();
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		}
	}

	public static BrokerService	startBroker() throws Exception {
		BrokerService brokerService = new BrokerService();

		brokerService.addConnector("tcp://localhost:61616");
		brokerService.setPersistent(false);
		brokerService.start();

		return brokerService;
	}
}
