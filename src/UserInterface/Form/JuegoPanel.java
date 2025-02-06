package UserInterface.Form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BusinessLogic.BL_USER.JuegoBL;
import Data_Access.DTO.PuntajeDTO;
// import BusinessLogic.JuegoBL;
// import DataAccess.DTO.PuntajeDTO;
// import UserInterface.CustomerControl.PoliButton;
// import UserInterface.CustomerControl.PoliLabel;
import UserInterface.Customer_control.Text_label;
import UserInterface.Form.Login_panel;

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
    //private Login_panel lp;
    private Integer userId;
    private JuegoBL juegoBL = new JuegoBL();

    public JuegoPanel(JFrame gameWindow, Integer id) {
        this.gameWindow = gameWindow; // Inicializar la referencia
        customizeComponent(gameWindow);
        this.userId = id;
    }


    private void customizeComponent(JFrame gameWindow) {
        this.gameWindow = gameWindow;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        // Panel Superior
        JPanel panelSuperior = new JPanel(new GridLayout(1, 2));
        Text_label lblTitulo = new Text_label("¿Cuál es Mayor?");
        //lblTitulo.setFont(PoliCursoStyle.FONT_BOLD.deriveFont(24f));
        lblRonda = new Text_label("Ronda: 1/" + TOTAL_RONDAS);
        //lblRonda.setFont(PoliCursoStyle.FONT_BOLD.deriveFont(18f));
        panelSuperior.add(lblTitulo);
        panelSuperior.add(lblRonda);
        add(panelSuperior, BorderLayout.NORTH);
        
        // Panel Central
        JPanel panelNumeros = new JPanel(new GridLayout(1, 2, 20, 20));
        panelNumeros.setBackground(Color.WHITE);
        
        btnNum1 = crearBotonNumero();
        btnNum2 = crearBotonNumero();
        
        panelNumeros.add(btnNum1);
        panelNumeros.add(btnNum2);
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
        lblMensaje = new Text_label("Selecciona el número mayor"); // Inicializa aquí
        //lblMensaje.setFont(PoliCursoStyle.FONT_BOLD.deriveFont(16f));
        panelMensajes.add(lblMensaje);
        add(panelMensajes, BorderLayout.SOUTH);
    
        nuevoJuego();
    }

    private JButton crearBotonNumero() {
        JButton btn = new JButton("nada");
        btn.setPreferredSize(new Dimension(150, 150));
        //btn.setFont(PoliCursoStyle.FONT_BOLD.deriveFont(48f));
        //btn.setCursor(PoliCursoStyle.CURSOR_HAND);
        btn.addActionListener(this::verificarRespuesta);
        return btn;
    }

    private void nuevoJuego() {
        num1 = generarNumeroAleatorio();
        num2 = generarNumeroAleatorio();
        while(num1 == num2) num2 = generarNumeroAleatorio();
        
        btnNum1.setText(String.valueOf(num1));
        btnNum2.setText(String.valueOf(num2));
        lblMensaje.setText("Selecciona el número mayor");
        //lblMensaje.setForeground(PoliCursoStyle.COLOR_FONT);
    }

    private void verificarRespuesta(ActionEvent e) {
        JButton btnSeleccionado = (JButton) e.getSource();
        int seleccion = Integer.parseInt(btnSeleccionado.getText());
        int otroNumero = (btnSeleccionado == btnNum1) ? num2 : num1;
        
        if(seleccion > otroNumero) {
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
                errores
            );
            
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

    // private void reiniciarJuego() {
    //     aciertos = 0;
    //     errores = 0;
    //     rondaActual = 1;
    //     lblPuntaje.setText("Puntaje: 0");
    //     lblRonda.setText("Ronda: 1/" + TOTAL_RONDAS);
    //     nuevoJuego();
    // }

    private int generarNumeroAleatorio() {
        return (int) (Math.random() * 50) + 1;
    }
}