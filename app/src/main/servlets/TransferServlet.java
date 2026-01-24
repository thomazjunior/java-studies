package servlets;

import com.ibm.mq.jms.MQConnectionFactory;
import com.ibm.mq.jms.MQQueue;
import com.ibm.msg.client.wmq.WMQConstants;

import javax.jms.DeliveryMode;
import javax.jms.JMSContext;
import javax.jms.Queue;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * # 1. Enter MQ command interface
 * docker exec -it ibmmq runmqsc QM_BANK
 *
 * # 2. Check if queue exists
 * DISPLAY QLOCAL(BANK.TRANSFER.REQUEST)
 *
 * # 3. Grant permissions
 * SET AUTHREC PROFILE(BANK.TRANSFER.REQUEST) OBJTYPE(QUEUE) PRINCIPAL(app) AUTHADD(PUT,GET,INQ)
 * REFRESH SECURITY TYPE(AUTHSERV)
 *
 * # 4. Exit
 * end
 */


@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {

    private MQConnectionFactory createConnectionFactory() throws Exception {
        MQConnectionFactory cf = new MQConnectionFactory();

        cf.setHostName("localhost");               // MQ host
        cf.setPort(1414);                          // MQ listener port
        cf.setStringProperty(WMQConstants.USERID, "");
        cf.setStringProperty(WMQConstants.PASSWORD, "");
        cf.setQueueManager("QM_BANK");             // Queue Manager
        cf.setChannel("DEV.APP.SVRCONN");          // Server-conn channel
        cf.setTransportType(WMQConstants.WMQ_CM_CLIENT);

        // Optional but recommended
        cf.setClientReconnectOptions(
                WMQConstants.WMQ_CLIENT_RECONNECT);
        cf.setClientReconnectTimeout(30);

        return cf;
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String message = """
            {
              "fromAccount": "FR7612345678",
              "toAccount": "FR7698765432",
              "amount": 500,
              "currency": "EUR"
            }
            """;

        try {
            MQConnectionFactory cf = createConnectionFactory();

            Queue queue = new MQQueue("queue:///BANK.TRANSFER.REQUEST");

            try (JMSContext context = cf.createContext(JMSContext.AUTO_ACKNOWLEDGE)) {

                context.createProducer()
                        .setDeliveryMode(DeliveryMode.PERSISTENT) // 💰 money = persistent
                        .send(queue, message);

                resp.getWriter().println("Message envoyé avec succès !");
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Erreur lors de l'envoi du message : " + e.getMessage()
            );
        }
    }
}
