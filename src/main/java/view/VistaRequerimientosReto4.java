package view;

import controller.ControladorRequerimientosReto4;

import model.vo.LideresProyectosEmblematicos;
import model.vo.MaterialRankeadoImportado;
import model.vo.LideresMayorSalario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class VistaRequerimientosReto4 extends JFrame {

    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();

    // Mitigar errores de instancias serializable
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textArea;

    public VistaRequerimientosReto4() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 200, 1000, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbltitulo = new JLabel("Mision TIC 2022 - UTP - Ciclo 2 - Reto 5 - Edwin Páez Alonso");
        lbltitulo.setBounds(28, 6, 400, 30);
        contentPane.add(lbltitulo);

        // Dimensiona el contenido dentro de la ventana
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 70, 600, 250);
        contentPane.add(scrollPane);

        // Proporciona una vista desplazable de un componente en una ventana grafica
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JButton btnConsuta1 = new JButton("Consulta 1");
        btnConsuta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento1();
            }
        });
        btnConsuta1.setBounds(700, 100, 133, 30);
        contentPane.add(btnConsuta1);

        JButton btnConsuta2 = new JButton("Consulta 2");
        btnConsuta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento2();
            }
        });
        btnConsuta2.setBounds(700, 150, 133, 30);
        contentPane.add(btnConsuta2);

        JButton btnConsuta3 = new JButton("Consulta 3");
        btnConsuta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento3();
            }
        });
        btnConsuta3.setBounds(700, 200, 133, 30);
        contentPane.add(btnConsuta3);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        btnLimpiar.setBounds(300, 350, 117, 30);
        contentPane.add(btnLimpiar);

    }

    public void requerimiento1() {
        try {
            ArrayList<LideresMayorSalario> rankingLideresMayorSalario = controlador.consultarLideresMayorSalarios();
            String salida = "*** Líderes con mayor salario en Barranquilla *** \n\nID_Lider\tNombre\tPrimer_Apellido\n\n";
            for (LideresMayorSalario lideresMayorSalario : rankingLideresMayorSalario) {
                salida += lideresMayorSalario.getIdLider();
                salida += "\t";
                salida += lideresMayorSalario.getNombre();
                salida += "\t";
                salida += lideresMayorSalario.getPrimerApellido();
                salida += "\n";

            }
            textArea.setText(salida);

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public void requerimiento2() {
        try {
            ArrayList<LideresProyectosEmblematicos> rankingProyectosEmblematicos = controlador.consultarLideresProyectosEmblematicos();
            String salida = "*** Proyectos Emblemáticos *** \n\nID_Lider\tId_Proyecto\tId_Tipo\n\n";
            for (LideresProyectosEmblematicos lideresProyectosEmblematicos : rankingProyectosEmblematicos) {
                salida += lideresProyectosEmblematicos.getIdLider();
                salida += "\t";
                salida += lideresProyectosEmblematicos.getIdProyecto();
                salida += "\t";
                salida += lideresProyectosEmblematicos.getIdTipo();
                salida += "\n";

            }
            textArea.setText(salida);

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public void requerimiento3() {
        try {
            ArrayList<MaterialRankeadoImportado> rankingMaterialesImportados = controlador.consultarMaterialesRankeadosImportados();
            String salida = "*** Ranking de Materiales Importados *** \n\n";
            for (MaterialRankeadoImportado materialRankeadoImportado : rankingMaterialesImportados) {
                salida += "El producto de ID "+materialRankeadoImportado.getIdMaterial()+" de descripción: "+materialRankeadoImportado.getNombreMaterial()+" de tipo importado(a), tiene un precio de "+materialRankeadoImportado.getPrecioUnidad();
                salida += "\n";

            }
            textArea.setText(salida);

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }
}