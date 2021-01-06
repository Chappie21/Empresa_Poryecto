package COMPONENTES;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Window.Type;

public class JMessage extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JMessage dialog = new JMessage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JMessage() {
		setTitle("ATENCION");
		setBounds(100, 100, 362, 162);
		getContentPane().setLayout(new BorderLayout());
		this.setResizable(false);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel Icon = new JLabel("");
			Icon.setIcon(new ImageIcon(""));
			contentPanel.add(Icon, BorderLayout.WEST);
		}
		{
			JLabel Message = new JLabel("USUARIO YA EXISTENTE");
			Message.setHorizontalAlignment(SwingConstants.CENTER);
			Message.setForeground(new Color(0, 0, 0));
			Message.setFont(new Font("Arial", Font.BOLD, 14));
			contentPanel.add(Message, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
			{
				JButton okButton = new JButton("ACEPTAR");
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setFont(new Font("Arial", Font.BOLD, 14));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(0, 191, 255));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JLabel lblNewLabel = new JLabel("    ");
				buttonPane.add(lblNewLabel, BorderLayout.WEST);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("    ");
				buttonPane.add(lblNewLabel_1, BorderLayout.EAST);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("    ");
				buttonPane.add(lblNewLabel_2, BorderLayout.SOUTH);
			}
		}
	}

}
