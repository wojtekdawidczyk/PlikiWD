package okno;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileNameExtensionFilter;

import klasy.ObslugaCSV;
import klasy.Student;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class OknoStudentow {

	private JFrame frmSortowanieStudenciakw;
	
	private List<Student> studenci;
	private JTextArea txtrStatus;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnWgWzrostuu;
	private JRadioButton rdbtnWgDaty;
	private JRadioButton rdbtnDomyslnie;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OknoStudentow window = new OknoStudentow();
					window.frmSortowanieStudenciakw.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public OknoStudentow() {
		initialize();
	}


	private void initialize() {
		frmSortowanieStudenciakw = new JFrame();
		frmSortowanieStudenciakw.setTitle("SORTOWANIE STUDENCIAKÓW");
		frmSortowanieStudenciakw.setBounds(100, 100, 711, 530);
		frmSortowanieStudenciakw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnWczytajStudentw = new JButton("wczytaj studentów");
		btnWczytajStudentw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				wczytajStudentow();
				
				
			}
		});
		btnWczytajStudentw.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		txtrStatus = new JTextArea();
		txtrStatus.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtrStatus.setText("status");
		
		JButton btnPosortuj = new JButton("Posortuj");
		btnPosortuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posortujStudentow();
			}
		});
		btnPosortuj.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		JButton btnZapisz = new JButton("Zapisz");
		btnZapisz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				zapiszStudentow();
				
			}
		});
		btnZapisz.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		rdbtnDomyslnie = new JRadioButton("domyslnie");
		buttonGroup.add(rdbtnDomyslnie);
		
		rdbtnWgWzrostuu = new JRadioButton("wg wzrostuu");
		buttonGroup.add(rdbtnWgWzrostuu);
		
		rdbtnWgDaty = new JRadioButton("wg daty");
		buttonGroup.add(rdbtnWgDaty);
		GroupLayout groupLayout = new GroupLayout(frmSortowanieStudenciakw.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnWczytajStudentw, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addGap(462))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(txtrStatus, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(214, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnZapisz, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPosortuj, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnDomyslnie)
						.addComponent(rdbtnWgWzrostuu, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnWgDaty, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(336, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(btnWczytajStudentw, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(txtrStatus, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnPosortuj, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnZapisz))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnDomyslnie)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnWgWzrostuu)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnWgDaty)))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		frmSortowanieStudenciakw.getContentPane().setLayout(groupLayout);
	}


	protected void posortujStudentow() {
		
		if(rdbtnDomyslnie.isSelected()) {
		Collections.sort(studenci);
		
		txtrStatus.append("POSORTOWANI");
		}
		if(rdbtnWgDaty.isSelected()) {
			
			studenci.sort( (a, b) -> a.getDataUrodzenia().compareTo(b.getDataUrodzenia()) );
		}
		if(rdbtnWgWzrostuu.isSelected()) {
			
			studenci.sort( (a, b) -> Double.compare(a.getWzrost(), b.getWzrost()));
		}
		
		
	}


	protected void zapiszStudentow() {
		
JFileChooser chooser = new JFileChooser(".");
		
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setFileFilter(new FileNameExtensionFilter("pliki CSV", "csv"));
		int coSieStalo = chooser.showOpenDialog(frmSortowanieStudenciakw);
		if(coSieStalo == JFileChooser.APPROVE_OPTION) {
			
			File plik = chooser.getSelectedFile();
			ObslugaCSV.zapiszStudentow(studenci, plik);
			txtrStatus.append("\nZapisano " + studenci.size() + " studentów");
		}else {
				txtrStatus.append("\nNie zapisano");
			
		}
		
	}


	protected void wczytajStudentow() {
		
		JFileChooser chooser = new JFileChooser(".");
		
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setFileFilter(new FileNameExtensionFilter("pliki CSV", "csv"));
		int coSieStalo = chooser.showOpenDialog(frmSortowanieStudenciakw);
		if(coSieStalo == JFileChooser.APPROVE_OPTION) {
			
			File plik = chooser.getSelectedFile();
			studenci = ObslugaCSV.wczytajStudentow(plik);
			txtrStatus.append("\nWczytano " + studenci.size() + " studentów");
		}else {
				txtrStatus.append("\n nie wczytano");
			
		}
	}
}
