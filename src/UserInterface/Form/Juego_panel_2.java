package UserInterface.Form;

import BusinessLogic.BL_USER.JuegoBL;
import Data_Access.DTO.PuntajeDTO;
import UserInterface.Customer_control.Text_label;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Juego_panel_2 extends JPanel {
    private JButton btnNum1, btnNum2, btnNum3, btnNum4, btnNum5;
    private Text_label lblAciertos, lblErrores;
    private Text_label lblMensaje, lblRonda;
    private int num1, num2, num3, num4, num5, num6, num7, num8, num9, num10;
    private int aciertos = 0;
    private int errores = 0;
    private int rondaActual = 1;
    private final int TOTAL_RONDAS = 10;
    private JFrame gameWindow;
    private final Integer userId;
    private final JuegoBL juegoBL = new JuegoBL();

    public Juego_panel_2(JFrame gameWindow, Integer id) {
        this.gameWindow = gameWindow; // Inicializar la referencia
        this.userId = id;
        customizeComponent();
    }

    private void customizeComponent() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Panel Superior
        JPanel panelSuperior = new JPanel(new GridLayout(1, 2));
        Text_label lblTitulo = new Text_label("¿Cuál resta es mayor?");
        lblRonda = new Text_label("Ronda: 1/" + TOTAL_RONDAS);
        panelSuperior.add(lblTitulo);
        panelSuperior.add(lblRonda);
        add(panelSuperior, BorderLayout.NORTH);

        // Panel Central
        JPanel panelNumeros = new JPanel(new GridLayout(1, 5, 20, 20));
        panelNumeros.setBackground(Color.WHITE);

        btnNum1 = crearBotonNumero();
        btnNum2 = crearBotonNumero();
        btnNum3 = crearBotonNumero();
        btnNum4 = crearBotonNumero();
        btnNum5 = crearBotonNumero();

        panelNumeros.add(btnNum1);
        panelNumeros.add(btnNum2);
        panelNumeros.add(btnNum3);
        panelNumeros.add(btnNum4);
        panelNumeros.add(btnNum5);
        add(panelNumeros, BorderLayout.CENTER);

        // Panel Inferior
        JPanel panelContadores = new JPanel(new GridLayout(1, 2));

        lblAciertos = new Text_label("Aciertos: 0");
        lblAciertos.setForeground(Color.GREEN); // Color verde

        lblErrores = new Text_label("Errores: 0");
        lblErrores.setForeground(Color.RED); // Color rojo

        panelContadores.add(lblAciertos);
        panelContadores.add(lblErrores);

        add(panelContadores, BorderLayout.SOUTH); // Reemplazar el panelInfo

        // Panel Inferior (Mensajes)
        JPanel panelMensajes = new JPanel();
        lblMensaje = new Text_label("Selecciona la resta mayor"); // Inicializa aquí
        panelMensajes.add(lblMensaje);
        add(panelMensajes, BorderLayout.SOUTH);

        nuevoJuego();
    }

    private JButton crearBotonNumero() {
        JButton btn = new JButton("nada");
        btn.setPreferredSize(new Dimension(150, 150));
        btn.addActionListener(this::verificarRespuesta);
        return btn;
    }

    private void nuevoJuego() {
        num1 = generarNumeroAleatorio();
        num2 = generarNumeroAleatorio();
        num3 = generarNumeroAleatorio();
        num4 = generarNumeroAleatorio();
        num5 = generarNumeroAleatorio();
        num6 = generarNumeroAleatorio();
        num7 = generarNumeroAleatorio();
        num8 = generarNumeroAleatorio();
        num9 = generarNumeroAleatorio();
        num10 = generarNumeroAleatorio();

        btnNum1.setText(num1 + "-" + num2);
        btnNum2.setText(num3 + "-" + num4);
        btnNum3.setText(num5 + "-" + num6);
        btnNum4.setText(num7 + "-" + num8);
        btnNum5.setText(num9 + "-" + num10);
        lblMensaje.setText("Selecciona la resta mayor");
    }

    private void verificarRespuesta(ActionEvent e) {
        JButton btnSeleccionado = (JButton) e.getSource();
        String[] partes = btnSeleccionado.getText().split("-");
        int seleccion = Integer.parseInt(partes[0]) - Integer.parseInt(partes[1]);
        int resta1 = num1 - num2;
        int resta2 = num3 - num4;
        int resta3 = num5 - num6;
        int resta4 = num7 - num8;
        int resta5 = num9 - num10;
        int mayorResta = Math.max(Math.max(Math.max(resta1, resta2), Math.max(resta3, resta4)), resta5);

        boolean esCorrecta = seleccion == mayorResta;
        if (esCorrecta) {
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

        rondaActual++; // Incrementar la ronda aquí

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

            PuntajeDTO puntaje = new PuntajeDTO(
                    this.userId,
                    "",
                    aciertos,
                    errores);

            if (!juegoBL.guardarPuntaje(puntaje)) {
                throw new Exception("Error al guardar puntaje");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarResultados() {
        JOptionPane.showMessageDialog(this,
            "Resultados:\n" +
            "✅ Aciertos: " + aciertos + "\n" +
            "❌ Errores: " + errores,
            "Fin de la Partida",
            JOptionPane.INFORMATION_MESSAGE);

        if (gameWindow != null) {
            gameWindow.dispose(); // Cerrar solo la ventana del juego
        }
    }

    private int generarNumeroAleatorio() {
        return (int) (Math.random() * 50) + 1;
    }
}
