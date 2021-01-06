package UI;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import COMPONENTES.JLabelColor;
import COMPONENTES.Plantilla_Panel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import java.awt.Font;

public class Vista_Usuarios extends Plantilla_Panel{
	
	private JTable table;
	private JTextField textField;

	public Vista_Usuarios() {
		
		super();
		super.PanelTitulo.setTitle("  Modificar lista de usuarios");
		super.PanelTitulo.setIconImage(new ImageIcon("Imagenes/edit_User_R_N2.png"));
		
		PanelContent.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setSelectionForeground(new Color(0, 191, 255));
		table.setSelectionBackground(new Color(175, 238, 238));
		table.setRowHeight(25);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "CEDULA", "NOMBRES", "APELLIDOS", "DEPARTAMENTO"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(96);
		JScrollPane scrollPane = new JScrollPane(table);
		PanelContent.add(scrollPane, BorderLayout.CENTER);
		
		JPanel Barra = new JPanel();
		Barra.setBackground(Color.WHITE);
		PanelContent.add(Barra, BorderLayout.SOUTH);
		Barra.setLayout(new BorderLayout(0, 0));
		
		JLabel Espacio = new JLabel("      ");
		Barra.add(Espacio, BorderLayout.NORTH);
		
		JPanel Content_Barra = new JPanel();
		Barra.add(Content_Barra, BorderLayout.CENTER);
		Content_Barra.setLayout(new GridLayout(0, 3, 0, 0));
		
		textField = new JTextField();
		Content_Barra.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		Content_Barra.add(comboBox);
		
		JLabelColor lblNewLabel = new JLabelColor("New label");
		Content_Barra.add(lblNewLabel);
		
	}

}
