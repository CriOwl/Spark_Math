package UserInterface.Form;

import BusinessLogic.BL_USER.JuegoBL;
import Data_Access.DTO.PuntajeDTO;
import UserInterface.Customer_control.Text_label;
import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.util.Scanner;

public class JuegoPanel extends JPanel {
    private JButton btnNum1, btnNum2;
    private Text_label lblAciertos, lblErrores;
    private Text_label lblMensaje, lblRonda;
    private int num1, num2;
    private int aciertos = 0;
    private int errores = 0;
    private int rondaActual = 1;
    private final int TOTAL_RONDAS = 10;
    private JFrame gameWindow;
    private final Integer userId;
    private final JuegoBL juegoBL = new JuegoBL();
    
    private SerialPort comPort;
    private int selectedIndex = 0; 

    public JuegoPanel(JFrame gameWindow, Integer id) {
        this.gameWindow = gameWindow;
        this.userId = id;
        customizeComponent();
        setupSerial();
    }

    private void customizeComponent() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel panelSuperior = new JPanel(new GridLayout(1, 2));
        Text_label lblTitulo = new Text_label("¿Cuál es Mayor?");
        lblRonda = new Text_label("Ronda: 1/" + TOTAL_RONDAS);
        panelSuperior.add(lblTitulo);
        panelSuperior.add(lblRonda);
        add(panelSuperior, BorderLayout.NORTH);

        JPanel panelNumeros = new JPanel(new GridLayout(1, 2, 20, 20));
        panelNumeros.setBackground(Color.WHITE);

        btnNum1 = crearBotonNumero();
        btnNum2 = crearBotonNumero();

        panelNumeros.add(btnNum1);
        panelNumeros.add(btnNum2);
        add(panelNumeros, BorderLayout.CENTER);

        JPanel panelContadores = new JPanel(new GridLayout(1, 2));
        lblAciertos = new Text_label("Aciertos: 0");
        lblAciertos.setForeground(Color.GREEN);
        lblErrores = new Text_label("Errores: 0");
        lblErrores.setForeground(Color.RED);
        panelContadores.add(lblAciertos);
        panelContadores.add(lblErrores);
        add(panelContadores, BorderLayout.SOUTH);

        JPanel panelMensajes = new JPanel();
        lblMensaje = new Text_label("Selecciona el número mayor");
        panelMensajes.add(lblMensaje);
        add(panelMensajes, BorderLayout.SOUTH);

        highlightButton();
        nuevoJuego();
    }

    private JButton crearBotonNumero() {
        JButton btn = new JButton("nada");
        btn.setPreferredSize(new Dimension(150, 150));
        btn.addActionListener(e -> verificarRespuesta(btn));
        return btn;
    }

    private void verificarRespuesta(JButton btnSeleccionado) {
        int seleccion = Integer.parseInt(btnSeleccionado.getText());
        int otroNumero = (btnSeleccionado == btnNum1) ? num2 : num1;

        if (seleccion > otroNumero) {
            aciertos++;
            lblAciertos.setText("Aciertos: " + aciertos);
            lblMensaje.setText("¡Correcto!");
            lblMensaje.setForeground(Color.GREEN);
        } else {
            errores++;
            lblErrores.setText("Errores: " + errores);
            lblMensaje.setText("Incorrecto. Intenta de nuevo");
            lblMensaje.setForeground(Color.RED);
        }

        rondaActual++;
        if (rondaActual <= TOTAL_RONDAS) {
            lblRonda.setText("Ronda: " + rondaActual + "/" + TOTAL_RONDAS);
            nuevoJuego();
        } else {
            guardarPartida();
            mostrarResultados();
        }
    }

    private void guardarPartida() {
        try {
            if (this.userId == null) {
                throw new Exception("Usuario no autenticado");
            }

            PuntajeDTO puntaje = new PuntajeDTO(this.userId, "", aciertos, errores);
            if (!juegoBL.guardarPuntaje(puntaje)) {
                throw new Exception("Error al guardar puntaje");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarResultados() {
        JOptionPane.showMessageDialog(this, 
                "Resultados:\n✅ Aciertos: " + aciertos + "\n❌ Errores: " + errores,
                "Fin de la Partida",
                JOptionPane.INFORMATION_MESSAGE);
        if (gameWindow != null) {
            gameWindow.dispose();
        }
    }

    private int generarNumeroAleatorio() {
        return (int) (Math.random() * 50) + 1;
    }

    private void nuevoJuego() {
        num1 = generarNumeroAleatorio();
        num2 = generarNumeroAleatorio();
        while (num1 == num2) num2 = generarNumeroAleatorio();

        btnNum1.setText(String.valueOf(num1));
        btnNum2.setText(String.valueOf(num2));
        lblMensaje.setText("Selecciona el número mayor");

        highlightButton();
    }

    private void setupSerial() {
        comPort = SerialPort.getCommPort("COM6"); 
        comPort.setBaudRate(115200);
        comPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
    
        if (!comPort.openPort()) {
            System.err.println("⚠️ No se pudo abrir el puerto.");
            return;
        }
        System.out.println("✅ Puerto abierto: " + comPort.getSystemPortName());
    
        new Thread(() -> {
            try {
                InputStream in = comPort.getInputStream();
                Scanner scanner = new Scanner(in);
                while (true) {
                    if (scanner.hasNextLine()) {
                        String data = scanner.nextLine().trim();
                        System.out.println("📩 Recibido: " + data);
                        SwingUtilities.invokeLater(() -> handleCommand(data));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
    
   

    private void handleCommand(String command) {
        switch (command) {
            case "UP":
                selectedIndex = (selectedIndex == 0) ? 1 : 0;
                break;
            case "DOWN":
                selectedIndex = (selectedIndex == 1) ? 0 : 1;
                break;
            case "SELECT":
                JButton selectedButton = (selectedIndex == 0) ? btnNum1 : btnNum2;
                verificarRespuesta(selectedButton);
                break;
            default:
                System.err.println("⚠️ Comando desconocido: " + command);
        }
        highlightButton();
    }   

    private void highlightButton() {
        btnNum1.setBackground(selectedIndex == 0 ? Color.YELLOW : null);
        btnNum2.setBackground(selectedIndex == 1 ? Color.YELLOW : null);
    }
}
