package COMPONENTES;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellRenderer;

public class EncabezadoTabla implements TableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable tabla, Object value, boolean selected, boolean arg3, int arg4,
			int arg5) {
		
		JComponent encabezado = null;
		
		if(value instanceof String) {
			
			encabezado = new JLabel((String) value);
			((JLabel) encabezado).setHorizontalAlignment(SwingConstants.CENTER);
			((JLabel) encabezado).setSize(encabezado.getWidth(), 30);
			
		}
		
		encabezado.setBackground(new Color(48, 180, 255));
		encabezado.setForeground(Color.white);
		encabezado.setFont(new Font("SansSerif", 1, 15));
		encabezado.setOpaque(true);
		
		return encabezado;
	}

}
