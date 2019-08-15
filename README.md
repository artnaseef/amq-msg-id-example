# ActiveMQ Message ID Example

Simple ActiveMQ example that demonstrates allocation of the Message ID on send.

Note the Javadoc for `javax.jms.Message.getJMSMessageID()` states the following, which holds true for ActiveMQ and this example:

    When a message is sent, JMSMessageID can be ignored. When the send or publish method returns, it contains a provider-assigned value.

# To Use

**NOTE** this example spins up a temporary ActiveMQ broker in-memory listening on port 61616.  If port 61616 is not available, the
application will fail.  Feel free to modify the code to use another port as desired.

    mvn clean package
    mvn exec:java -Dexec.mainClass=com.artnaseef.sandbox.MessageIdExample

# Sample Output

    2019-08-15 09:27:29,853 WARN  [com.artnaseef.sandbox.MessageIdExample.main()] org.apache.activemq.broker.BrokerService - Memory Usage for the Broker (1024mb) is more than the maximum available for the JVM: 910 mb - resetting to 70% of maximum available: 637 mb
    2019-08-15 09:27:29,928 INFO  [com.artnaseef.sandbox.MessageIdExample.main()] org.apache.activemq.broker.BrokerService - Using Persistence Adapter: MemoryPersistenceAdapter
    2019-08-15 09:27:29,948 INFO  [JMX connector] org.apache.activemq.broker.jmx.ManagementContext - JMX consoles can connect to service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi
    2019-08-15 09:27:30,084 INFO  [com.artnaseef.sandbox.MessageIdExample.main()] org.apache.activemq.broker.BrokerService - Apache ActiveMQ 5.15.9 (localhost, ID:AMLINV.local-49204-1565886449951-0:1) is starting
    2019-08-15 09:27:30,090 INFO  [com.artnaseef.sandbox.MessageIdExample.main()] org.apache.activemq.transport.TransportServerThreadSupport - Listening for connections at: tcp://localhost:61616
    2019-08-15 09:27:30,090 INFO  [com.artnaseef.sandbox.MessageIdExample.main()] org.apache.activemq.broker.TransportConnector - Connector tcp://localhost:61616 started
    2019-08-15 09:27:30,090 INFO  [com.artnaseef.sandbox.MessageIdExample.main()] org.apache.activemq.broker.BrokerService - Apache ActiveMQ 5.15.9 (localhost, ID:AMLINV.local-49204-1565886449951-0:1) started
    2019-08-15 09:27:30,090 INFO  [com.artnaseef.sandbox.MessageIdExample.main()] org.apache.activemq.broker.BrokerService - For help or more information please see: http://activemq.apache.org
    Message ID on message creation: null
    Message ID after message send: ID:AMLINV.local-49204-1565886449951-4:1:1:1:1
    2019-08-15 09:27:30,277 INFO  [com.artnaseef.sandbox.MessageIdExample.main()] org.apache.activemq.broker.BrokerService - Apache ActiveMQ 5.15.9 (localhost, ID:AMLINV.local-49204-1565886449951-0:1) is shutting down
    2019-08-15 09:27:30,278 INFO  [com.artnaseef.sandbox.MessageIdExample.main()] org.apache.activemq.broker.TransportConnector - Connector tcp://localhost:61616 stopped
    2019-08-15 09:27:30,284 INFO  [com.artnaseef.sandbox.MessageIdExample.main()] org.apache.activemq.broker.BrokerService - Apache ActiveMQ 5.15.9 (localhost, ID:AMLINV.local-49204-1565886449951-0:1) uptime 0.437 seconds
    2019-08-15 09:27:30,284 INFO  [com.artnaseef.sandbox.MessageIdExample.main()] org.apache.activemq.broker.BrokerService - Apache ActiveMQ 5.15.9 (localhost, ID:AMLINV.local-49204-1565886449951-0:1) is shutdown
