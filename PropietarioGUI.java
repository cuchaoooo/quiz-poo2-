import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PropietarioGUI extends JFrame {
    private JTextField txtNombre;
    private JButton btnRegistrar, btnListar, btnBuscar;
    private JTextArea txtArea;
    private ArrayList<Propietario> listaPropietarios;

    public PropietarioGUI() {
        super("Gestión de Propietarios");
        setLayout(new FlowLayout());

        txtNombre = new JTextField(10);
        btnRegistrar = new JButton("Registrar Propietario");
        btnListar = new JButton("Listar Propietarios");
        btnBuscar = new JButton("Buscar Propietario");
        txtArea = new JTextArea(30, 35);
        listaPropietarios = new ArrayList<>();

        add(txtNombre);
        add(btnRegistrar);
        add(btnListar);
        add(btnBuscar);
        add(new JScrollPane(txtArea));

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                if (!nombre.isEmpty()) {
                    listaPropietarios.add(new Propietario(nombre));
                    txtNombre.setText("");
                    txtArea.append("Propietario registrado.\n");
                }
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.setText("");
                for (Propietario propietario : listaPropietarios) {
                    txtArea.append(propietario.getNombre() + "\n");
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                for (Propietario propietario : listaPropietarios) {
                    if (propietario.getNombre().equals(nombre)) {
                        txtArea.setText("Propietario encontrado: " + nombre);
                        return;
                    }
                }
                txtArea.setText("Propietario no encontrado.");
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PropietarioGUI();
    }
}

class Propietario {
    private String nombre;

    public Propietario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

