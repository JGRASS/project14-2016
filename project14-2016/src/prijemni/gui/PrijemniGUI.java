package prijemni.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrijemniGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JTextArea textAreaPitanja;
	private JButton btnUcitaj;
	private JTextField txtIme;
	private JLabel lblIme;
	private JLabel lblPrezime;
	private JTextField textPrezime;
	private JLabel lblJmbg;
	private JTextField txtJmbg;
	private JLabel lblBrojBodova;
	private JTextField textBodoviSS;
	private JButton btnPocetak;
	private JButton btnSacuvaj;
	private JRadioButton rdbtnA;
	private JRadioButton rdbtnB;
	private JRadioButton rdbtnC;
	private JRadioButton rdbtnD;
	private JRadioButton rdbtnN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrijemniGUI frame = new PrijemniGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrijemniGUI() {
		setTitle("Rezultati prijemnog");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getPanel_1(), BorderLayout.EAST);
			panel.add(getPanel_2(), BorderLayout.SOUTH);
			panel.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(105, 10));
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel_1.add(getBtnUcitaj());
			panel_1.add(getLblIme());
			panel_1.add(getTxtIme());
			panel_1.add(getLblPrezime());
			panel_1.add(getTextPrezime());
			panel_1.add(getLblJmbg());
			panel_1.add(getTxtJmbg());
			panel_1.add(getLblBrojBodova());
			panel_1.add(getTextBodoviSS());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setPreferredSize(new Dimension(10, 50));
			panel_2.setLayout(new MigLayout("", "[79px][65px][71px][][][][][][][][][][][][][][][][][][][][][][][][][][][][]", "[23px]"));
			panel_2.add(getBtnPocetak(), "cell 0 0,alignx left,aligny center");
			panel_2.add(getRdbtnA(), "cell 3 0");
			panel_2.add(getRdbtnB(), "cell 4 0");
			panel_2.add(getRdbtnC(), "cell 5 0");
			panel_2.add(getRdbtnD(), "cell 6 0");
			panel_2.add(getRdbtnN(), "cell 7 0");
			panel_2.add(getBtnSacuvaj(), "cell 29 0,alignx left,aligny top");
		}
		return panel_2;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextAreaPitanja());
		}
		return scrollPane;
	}
	private JTextArea getTextAreaPitanja() {
		if (textAreaPitanja == null) {
			textAreaPitanja = new JTextArea();
			textAreaPitanja.setEditable(false);
		}
		return textAreaPitanja;
	}
	private JButton getBtnUcitaj() {
		if (btnUcitaj == null) {
			btnUcitaj = new JButton("Ucitaj resenja");
		}
		return btnUcitaj;
	}
	private JTextField getTxtIme() {
		if (txtIme == null) {
			txtIme = new JTextField();
			txtIme.setColumns(10);
		}
		return txtIme;
	}
	private JLabel getLblIme() {
		if (lblIme == null) {
			lblIme = new JLabel("Ime");
		}
		return lblIme;
	}
	private JLabel getLblPrezime() {
		if (lblPrezime == null) {
			lblPrezime = new JLabel("Prezime");
		}
		return lblPrezime;
	}
	private JTextField getTextPrezime() {
		if (textPrezime == null) {
			textPrezime = new JTextField();
			textPrezime.setColumns(10);
		}
		return textPrezime;
	}
	private JLabel getLblJmbg() {
		if (lblJmbg == null) {
			lblJmbg = new JLabel("JMBG");
		}
		return lblJmbg;
	}
	private JTextField getTxtJmbg() {
		if (txtJmbg == null) {
			txtJmbg = new JTextField();
			txtJmbg.setColumns(10);
		}
		return txtJmbg;
	}
	private JLabel getLblBrojBodova() {
		if (lblBrojBodova == null) {
			lblBrojBodova = new JLabel("Bodovi iz skole");
		}
		return lblBrojBodova;
	}
	private JTextField getTextBodoviSS() {
		if (textBodoviSS == null) {
			textBodoviSS = new JTextField();
			textBodoviSS.setColumns(10);
		}
		return textBodoviSS;
	}
	private JButton getBtnPocetak() {
		if (btnPocetak == null) {
			btnPocetak = new JButton("Idi na pocetak");
		}
		return btnPocetak;
	}
	private JButton getBtnSacuvaj() {
		if (btnSacuvaj == null) {
			btnSacuvaj = new JButton("Sacuvaj");
		}
		return btnSacuvaj;
	}
	private JRadioButton getRdbtnA() {
		if (rdbtnA == null) {
			rdbtnA = new JRadioButton("A");
			rdbtnA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(rdbtnA.isSelected()){
						
					}
				}
			});
		}
		return rdbtnA;
	}
	private JRadioButton getRdbtnB() {
		if (rdbtnB == null) {
			rdbtnB = new JRadioButton("B");
		}
		return rdbtnB;
	}
	private JRadioButton getRdbtnC() {
		if (rdbtnC == null) {
			rdbtnC = new JRadioButton("C");
		}
		return rdbtnC;
	}
	private JRadioButton getRdbtnD() {
		if (rdbtnD == null) {
			rdbtnD = new JRadioButton("D");
		}
		return rdbtnD;
	}
	private JRadioButton getRdbtnN() {
		if (rdbtnN == null) {
			rdbtnN = new JRadioButton("N");
		}
		return rdbtnN;
	}
}
