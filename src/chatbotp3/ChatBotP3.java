package chatbotp3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatBotP3 extends JFrame {

    private GroupLayout layout;
    private GroupLayout.ParallelGroup parallel;
    private GroupLayout.SequentialGroup sequential;
    public boolean flagQuiereSeguro = false;

    private JPanel create() {
        JPanel panel = new JPanel();
        layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        parallel = layout.createParallelGroup();
        layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(parallel));
        sequential = layout.createSequentialGroup();
        layout.setVerticalGroup(sequential);
        //sendBotMessage(conv.tree.root.instruccion);
        return panel;

    }

    public ChatBotP3() {

    }

    public void sendUsuario(String mensajeChat) {

        JLabel user_icon = new JLabel();
        user_icon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/user.png")));

        JLabel user_msg = new JLabel();
        user_msg.setText("<html><body style='width:350px;'>" + mensajeChat + "</body></html>");

        JPanel user_bubble = new RightArrowBubble();
        GroupLayout user_final_msg = new GroupLayout(user_bubble);

        user_final_msg.setHorizontalGroup(
                user_final_msg.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(user_final_msg.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(user_msg)
                                .addContainerGap(162, Short.MAX_VALUE))
        );
        user_final_msg.setVerticalGroup(
                user_final_msg.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(user_final_msg.createSequentialGroup()
                                .addComponent(user_msg)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, 1))
        );

        user_bubble.setLayout(user_final_msg);

        parallel.addGroup(layout.createSequentialGroup().addComponent(user_bubble).addComponent(user_icon));
        sequential.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(user_bubble).addComponent(user_icon));

        if (mensajeChat.toLowerCase().contains("hola")) {
            sendBot("hola como estas?");
        } else if (mensajeChat.toLowerCase().contains("bien gracias y tu") || mensajeChat.toLowerCase().contains("bien y tu") || mensajeChat.toLowerCase().contains("como te encuentras") || mensajeChat.toLowerCase().contains("como estas") || mensajeChat.toLowerCase().contains("que tal estas")) {
            sendBot("Estoy bien. En que te puedo ayudar?");
        } else if (mensajeChat.toLowerCase().contains("como te llamas") || mensajeChat.toLowerCase().contains("cual es tu nombre") || mensajeChat.toLowerCase().contains("tu nombre es")) {
            sendBot("Mucho gusto me llamo Jam. En que te puedo ayudar?");
        } else if (mensajeChat.toLowerCase().contains("bien gracias") || mensajeChat.toLowerCase().contains("estoy bien") || mensajeChat.toLowerCase().contains("bien")) {
            sendBot("Me alegro que estes bien. En que te puedo ayudar?");
        } else if (mensajeChat.toLowerCase().contains("quien eres")) {
            int decision = (int) (Math.random() * 2 + 1);
            if (decision == 1) {
                sendBot("Soy una inteligencia superior, estoy para ayudarte.");
            } else if (decision == 2) {
                sendBot("Soy la solución a tus problemas, estoy para ayudarte");
            }
        } else if (mensajeChat.toLowerCase().contains("quien eres") || mensajeChat.toLowerCase().contains("que eres")) {
            int decision = (int) (Math.random() * 2 + 1);
            if (decision == 1) {
                sendBot("Soy una inteligencia superior, estoy para ayudarte.");
            } else if (decision == 2) {
                sendBot("Soy la solución a tus problemas, estoy para ayudarte");
            }
        } else if (mensajeChat.toLowerCase().contains("que sabes hacer") || mensajeChat.toLowerCase().contains("ayudar") || mensajeChat.toLowerCase().contains("que haces") || mensajeChat.toLowerCase().contains("que puedes ayudarme") || mensajeChat.toLowerCase().contains("que conoces") || mensajeChat.toLowerCase().contains("que puedes ayudarme") || mensajeChat.toLowerCase().contains("me ayudas") || mensajeChat.toLowerCase().contains("ayudame")) {
            int decision = (int) (Math.random() * 2 + 1);
            flagQuiereSeguro = true;
            if (decision == 1) {
                sendBot("Estoy entrenado para ofrecerte el seguro de vida. Gustas que te brinde información?");

            } else if (decision == 2) {
                sendBot("Quieres conocer nuestro seguro de vida?");
            }
        } else if (mensajeChat.toLowerCase().contains("si") || mensajeChat.toLowerCase().contains("si por favor") || mensajeChat.toLowerCase().contains("si porfavor") || mensajeChat.toLowerCase().contains("ok")) {

            if (flagQuiereSeguro == true) {
                sendBot("Tenemos nuestro seguro de vida que le cubre nacional e internacionalmente");

            } else {

                int decision = (int) (Math.random() * 2 + 1);
                if (decision == 1) {
                    sendBot("Bueno");

                } else if (decision == 2) {
                    sendBot("Entendido");
                }
            }
        }else if (mensajeChat.toLowerCase().contains("seguro") ) {

                sendBot("Tenemos nuestro seguro de vida que le cubre nacional e internacionalmente");

            
        }  else if (mensajeChat.toLowerCase().contains("no")) {

            if (flagQuiereSeguro == true) {
                sendBot("Es una lastima. Esperemos que mas adelante le pueda interesar.");

            } else {

                int decision = (int) (Math.random() * 2 + 1);
                if (decision == 1) {
                    sendBot("Bueno");

                } else if (decision == 2) {
                    sendBot("Entendido");
                }
            }
        } else if (mensajeChat.toLowerCase().contains("cobertura") || mensajeChat.toLowerCase().contains("cubre")) {
            sendBot("Nuestro compromiso asumido contigo es cubrir a tu familia por una cantidad de cien mil(Q100,000.00) exactos.");

        } else if (mensajeChat.toLowerCase().contains("poliza")) {
            sendBot("a) TOMADOR DEL SEGURO\n"
                    + "\n"
                    + "La persona física o jurídica que suscribe el contrato con el ASEGURADOR, asumiendo las obligaciones del mismo -salvo aquéllas que por su naturaleza deban ser cumplidas por el ASEGURADO-.\n"
                    + "\n"
                    + "b) ASEGURADO\n"
                    + "\n"
                    + "La persona física sobre cuya vida se estipula el seguro.\n"
                    + "\n"
                    + "c) BENEFICIARIO\n"
                    + "\n"
                    + "La persona física o jurídica que es titular del derecho a la indemnización en el momento en que se produzca el evento que es objeto de cobertura por este contrato.\n"
                    + "\n"
                    + "d) PÓLIZA\n"
                    + "\n"
                    + "El documento, soporte del contrato, que contiene las condiciones que regulan el seguro. Forman parte de la PÓLIZA, estas Condiciones Generales, las Condiciones Especiales, las Particulares y los anexos, suplementos o apéndices que pudieran emitirse para completarla o modificarla. También forman parte del contrato la solicitud cumplimentada por el tomador del seguro y las declaraciones formuladas por tomador del seguro y asegurado a requerimiento del asegurador.\n"
                    + "\n"
                    + "e) PRIMA\n"
                    + "\n"
                    + "El precio del seguro. El recibo contendrá además los recargos e impuestos que sean de legal aplicación.");

        } else {
            int decision = (int) (Math.random() * 3 + 1);
            if (decision == 1) {
                sendBot("Aún no estoy preparado para este tema, investigare al respecto.");
            } else if (decision == 2) {
                sendBot("prueba de nuevo con otra petición");
            } else if (decision == 3) {
                sendBot("No tengo la respuesta para esta petición");
            }
        }
    }

    public void sendBot(String mensajeChat) {
        JLabel bot_icon = new JLabel();
        bot_icon.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/robot.png")));

        JLabel bot_msg = new JLabel();
        bot_msg.setText("<html><body style='width:360px;'>" + mensajeChat + "</body></html>");

        JPanel bot_bubble = new LeftArrowBubble();
        GroupLayout bot_final_msg = new GroupLayout(bot_bubble);

        bot_final_msg.setHorizontalGroup(
                bot_final_msg.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(bot_final_msg.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(bot_msg)
                                .addContainerGap(162, Short.MAX_VALUE))
        );
        bot_final_msg.setVerticalGroup(
                bot_final_msg.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(bot_final_msg.createSequentialGroup()
                                .addComponent(bot_msg)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, 1))
        );

        bot_bubble.setLayout(bot_final_msg);

        parallel.addGroup(layout.createSequentialGroup().addComponent(bot_icon).addComponent(bot_bubble));
        sequential.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(bot_icon).addComponent(bot_bubble));

        //txtConversacionMensaje.append("AI: "+s+"\n");
    }

    public static void main(String[] args) {
        // new ChatBotP3();

        EventQueue.invokeLater(() -> {

            JFrame f = new JFrame("Chatbot");
            f.setPreferredSize(new Dimension(750, 500));
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            final ChatBotP3 dgl = new ChatBotP3();
            final JPanel panel = dgl.create();

            JScrollPane jsp = new JScrollPane(panel);
//            Dimension d = new Dimension(panel.getComponent(0).getPreferredSize());
//            jsp.getVerticalScrollBar().setUnitIncrement(d.height);
//            d.height *= 600;
//            jsp.getViewport().setPreferredSize(d);
//            jsp.getViewport().setViewPosition(new Point(0, d.height));
            jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            JPanel controls = new JPanel();
            JTextField txtEntrada = new JTextField();
            txtEntrada.setPreferredSize(new Dimension(480, 27));

            Action action = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String mensaje = txtEntrada.getText();

                    if (!"".equals(mensaje)) {

                        dgl.sendUsuario(mensaje);
                        panel.validate();
                        txtEntrada.setText("");

                        //conv.tree.containsNode(conv.tree.root, mensaje, dgl, actionFlag, subActionFlag);
                        f.revalidate();
                        JScrollBar vertical = jsp.getVerticalScrollBar();
                        vertical.setValue(vertical.getMaximum());
                        f.pack();

                    }
                }
            };

            txtEntrada.addActionListener(action);
            controls.add(txtEntrada);

            controls.add(new JButton(new AbstractAction("Enviar") {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String mensaje = txtEntrada.getText();

                    if (!"".equals(mensaje)) {

                        dgl.sendUsuario(mensaje);
                        panel.validate();
                        txtEntrada.setText("");

                        // conv.tree.containsNode(conv.tree.root, mensaje, dgl, actionFlag, subActionFlag);
                        f.revalidate();
                        JScrollBar vertical = jsp.getVerticalScrollBar();
                        vertical.setValue(vertical.getMaximum());
                        f.pack();

                    }

                }
            }));
            f.add(jsp, BorderLayout.CENTER);
            f.add(controls, BorderLayout.SOUTH);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }

}
