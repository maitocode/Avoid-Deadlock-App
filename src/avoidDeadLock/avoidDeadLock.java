package avoidDeadLock;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Box;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Label;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.awt.event.ActionEvent;

public class avoidDeadLock extends JFrame {

	private JPanel contentPane;
	private JPanel panel1;
	private JPanel panel_1_2;
	private JLabel lbProgress01;
	private JLabel lbProgress02;
	private JLabel lbProgress03;
	private JLabel lbProgress04;
	private JLabel lbProgress05;
	private JLabel lbAllocation;
	private JLabel lbNeed;
	private JLabel lbSoTaiNguyen;
	private JTextField ttfSoTaiNguyen;
	private JLabel lbSoTienTrinh;
	private JTextField ttfSoTienTrinh;
	private JPanel panel_1_1;
	private Label lbTN01;
	private Label lbTN02;
	private Label lbTN03;
	private JTextField ttfTN02;
	private JTextField ttfTN03;
	private JTextField ttfTN01;
	private JPanel panel_1;
	private JLabel lbResuilt;
	private JButton btnInputFile;
	private JButton btnGetResuilt;
	private JButton btnRefresh;
	private JButton btnViewFile;
	private JTextField ttfAP02_A;
	private JTextField ttfAP02_B;
	private JTextField ttfAP02_C;
	private JTextField ttfNP01_A;
	private JTextField ttfNP01_B;
	private JTextField ttfNP01_C;
	private JTextField ttfNP02_A;
	private JTextField ttfNP02_B;
	private JTextField ttfNP02_C;
	private JTextField ttfAP03_A;
	private JTextField ttfAP03_B;
	private JTextField ttfAP03_C;
	private JTextField ttfNP03_A;
	private JTextField ttfNP03_B;
	private JTextField ttfNP03_C;
	private JTextField ttfAP04_A;
	private JTextField ttfAP04_B;
	private JTextField ttfAP04_C;
	private JTextField ttfNP04_A;
	private JTextField ttfNP04_B;
	private JTextField ttfNP04_C;
	private JTextField ttfAP05_A;
	private JTextField ttfAP05_B;
	private JTextField ttfAP05_C;
	private JTextField ttfNP05_A;
	private JTextField ttfNP05_B;
	private JTextField ttfNP05_C;
	private JTextField ttfAP01_A;
	private JTextField ttfAP01_B;
	private JTextField ttfAP01_C;
	private JPanel panel;
	private JPanel panel_2;
	
	private banker bk;
	private File file;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					avoidDeadLock frame = new avoidDeadLock();
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
	public avoidDeadLock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBorder(new TitledBorder(null, "INPUT", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel1.setBounds(20, 45, 564, 285);
		contentPane.add(panel1);
		
		panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(204, 255, 255));
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2.setBounds(188, 11, 367, 263);
		panel1.add(panel_1_2);
		
		lbProgress01 = new JLabel("Progress 01");
		lbProgress01.setBounds(6, 54, 84, 14);
		panel_1_2.add(lbProgress01);
		
		lbProgress02 = new JLabel("Progress 02");
		lbProgress02.setBounds(6, 101, 84, 14);
		panel_1_2.add(lbProgress02);
		
		lbProgress03 = new JLabel("Progress 03");
		lbProgress03.setBounds(6, 142, 84, 14);
		panel_1_2.add(lbProgress03);
		
		lbProgress04 = new JLabel("Progress 04");
		lbProgress04.setBounds(6, 183, 84, 14);
		panel_1_2.add(lbProgress04);
		
		lbProgress05 = new JLabel("Progress 05");
		lbProgress05.setBounds(6, 227, 84, 14);
		panel_1_2.add(lbProgress05);
		
		lbAllocation = new JLabel("Allocation");
		lbAllocation.setBounds(132, 16, 57, 14);
		panel_1_2.add(lbAllocation);
		
		lbNeed = new JLabel("Need");
		lbNeed.setBounds(288, 16, 32, 14);
		panel_1_2.add(lbNeed);
		
		panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setBounds(100, 54, 116, 187);
		panel_1_2.add(panel);
		panel.setLayout(null);
		
		ttfAP02_A = new JTextField();
		ttfAP02_A.setBounds(0, 41, 32, 20);
		panel.add(ttfAP02_A);
		ttfAP02_A.setHorizontalAlignment(SwingConstants.CENTER);
		ttfAP02_A.setEditable(false);
		ttfAP02_A.setColumns(10);
		
		ttfAP02_B = new JTextField();
		ttfAP02_B.setBounds(42, 41, 32, 20);
		panel.add(ttfAP02_B);
		ttfAP02_B.setHorizontalAlignment(SwingConstants.CENTER);
		ttfAP02_B.setEditable(false);
		ttfAP02_B.setColumns(10);
		
		ttfAP02_C = new JTextField();
		ttfAP02_C.setBounds(84, 41, 32, 20);
		panel.add(ttfAP02_C);
		ttfAP02_C.setHorizontalAlignment(SwingConstants.CENTER);
		ttfAP02_C.setEditable(false);
		ttfAP02_C.setColumns(10);
		
		ttfAP03_A = new JTextField();
		ttfAP03_A.setBounds(0, 82, 32, 20);
		panel.add(ttfAP03_A);
		ttfAP03_A.setHorizontalAlignment(SwingConstants.CENTER);
		ttfAP03_A.setEditable(false);
		ttfAP03_A.setColumns(10);
		
		ttfAP03_B = new JTextField();
		ttfAP03_B.setBounds(42, 82, 32, 20);
		panel.add(ttfAP03_B);
		ttfAP03_B.setHorizontalAlignment(SwingConstants.CENTER);
		ttfAP03_B.setEditable(false);
		ttfAP03_B.setColumns(10);
		
		ttfAP03_C = new JTextField();
		ttfAP03_C.setBounds(84, 82, 32, 20);
		panel.add(ttfAP03_C);
		ttfAP03_C.setHorizontalAlignment(SwingConstants.CENTER);
		ttfAP03_C.setEditable(false);
		ttfAP03_C.setColumns(10);
		
		ttfAP04_A = new JTextField();
		ttfAP04_A.setBounds(0, 123, 32, 20);
		panel.add(ttfAP04_A);
		ttfAP04_A.setHorizontalAlignment(SwingConstants.CENTER);
		ttfAP04_A.setEditable(false);
		ttfAP04_A.setColumns(10);
		
		ttfAP04_B = new JTextField();
		ttfAP04_B.setBounds(42, 123, 32, 20);
		panel.add(ttfAP04_B);
		ttfAP04_B.setHorizontalAlignment(SwingConstants.CENTER);
		ttfAP04_B.setEditable(false);
		ttfAP04_B.setColumns(10);
		
		ttfAP04_C = new JTextField();
		ttfAP04_C.setBounds(84, 123, 32, 20);
		panel.add(ttfAP04_C);
		ttfAP04_C.setHorizontalAlignment(SwingConstants.CENTER);
		ttfAP04_C.setEditable(false);
		ttfAP04_C.setColumns(10);
		
		ttfAP05_A = new JTextField();
		ttfAP05_A.setBounds(0, 167, 32, 20);
		panel.add(ttfAP05_A);
		ttfAP05_A.setHorizontalAlignment(SwingConstants.CENTER);
		ttfAP05_A.setEditable(false);
		ttfAP05_A.setColumns(10);
		
		ttfAP05_B = new JTextField();
		ttfAP05_B.setBounds(42, 167, 32, 20);
		panel.add(ttfAP05_B);
		ttfAP05_B.setHorizontalAlignment(SwingConstants.CENTER);
		ttfAP05_B.setEditable(false);
		ttfAP05_B.setColumns(10);
		
		ttfAP05_C = new JTextField();
		ttfAP05_C.setBounds(84, 167, 32, 20);
		panel.add(ttfAP05_C);
		ttfAP05_C.setHorizontalAlignment(SwingConstants.CENTER);
		ttfAP05_C.setEditable(false);
		ttfAP05_C.setColumns(10);
		
		ttfAP01_A = new JTextField();
		ttfAP01_A.setBounds(0, 0, 32, 20);
		panel.add(ttfAP01_A);
		ttfAP01_A.setHorizontalAlignment(SwingConstants.CENTER);
		ttfAP01_A.setEditable(false);
		ttfAP01_A.setColumns(10);
		
		ttfAP01_B = new JTextField();
		ttfAP01_B.setBounds(42, 0, 32, 20);
		panel.add(ttfAP01_B);
		ttfAP01_B.setHorizontalAlignment(SwingConstants.CENTER);
		ttfAP01_B.setEditable(false);
		ttfAP01_B.setColumns(10);
		
		ttfAP01_C = new JTextField();
		ttfAP01_C.setBounds(84, 0, 32, 20);
		panel.add(ttfAP01_C);
		ttfAP01_C.setHorizontalAlignment(SwingConstants.CENTER);
		ttfAP01_C.setEditable(false);
		ttfAP01_C.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(224, 255, 255));
		panel_2.setBounds(241, 54, 116, 187);
		panel_1_2.add(panel_2);
		panel_2.setLayout(null);
		
		ttfNP01_A = new JTextField();
		ttfNP01_A.setBounds(0, 0, 32, 20);
		panel_2.add(ttfNP01_A);
		ttfNP01_A.setHorizontalAlignment(SwingConstants.CENTER);
		ttfNP01_A.setEditable(false);
		ttfNP01_A.setColumns(10);
		
		ttfNP01_B = new JTextField();
		ttfNP01_B.setBounds(42, 0, 32, 20);
		panel_2.add(ttfNP01_B);
		ttfNP01_B.setHorizontalAlignment(SwingConstants.CENTER);
		ttfNP01_B.setEditable(false);
		ttfNP01_B.setColumns(10);
		
		ttfNP01_C = new JTextField();
		ttfNP01_C.setBounds(84, 0, 32, 20);
		panel_2.add(ttfNP01_C);
		ttfNP01_C.setHorizontalAlignment(SwingConstants.CENTER);
		ttfNP01_C.setEditable(false);
		ttfNP01_C.setColumns(10);
		
		ttfNP02_A = new JTextField();
		ttfNP02_A.setBounds(0, 41, 32, 20);
		panel_2.add(ttfNP02_A);
		ttfNP02_A.setHorizontalAlignment(SwingConstants.CENTER);
		ttfNP02_A.setEditable(false);
		ttfNP02_A.setColumns(10);
		
		ttfNP02_B = new JTextField();
		ttfNP02_B.setBounds(42, 41, 32, 20);
		panel_2.add(ttfNP02_B);
		ttfNP02_B.setHorizontalAlignment(SwingConstants.CENTER);
		ttfNP02_B.setEditable(false);
		ttfNP02_B.setColumns(10);
		
		ttfNP02_C = new JTextField();
		ttfNP02_C.setBounds(84, 41, 32, 20);
		panel_2.add(ttfNP02_C);
		ttfNP02_C.setHorizontalAlignment(SwingConstants.CENTER);
		ttfNP02_C.setEditable(false);
		ttfNP02_C.setColumns(10);
		
		ttfNP03_A = new JTextField();
		ttfNP03_A.setBounds(0, 82, 32, 20);
		panel_2.add(ttfNP03_A);
		ttfNP03_A.setHorizontalAlignment(SwingConstants.CENTER);
		ttfNP03_A.setEditable(false);
		ttfNP03_A.setColumns(10);
		
		ttfNP03_B = new JTextField();
		ttfNP03_B.setBounds(42, 82, 32, 20);
		panel_2.add(ttfNP03_B);
		ttfNP03_B.setHorizontalAlignment(SwingConstants.CENTER);
		ttfNP03_B.setEditable(false);
		ttfNP03_B.setColumns(10);
		
		ttfNP03_C = new JTextField();
		ttfNP03_C.setBounds(84, 82, 32, 20);
		panel_2.add(ttfNP03_C);
		ttfNP03_C.setHorizontalAlignment(SwingConstants.CENTER);
		ttfNP03_C.setEditable(false);
		ttfNP03_C.setColumns(10);
		
		ttfNP04_A = new JTextField();
		ttfNP04_A.setBounds(0, 123, 32, 20);
		panel_2.add(ttfNP04_A);
		ttfNP04_A.setHorizontalAlignment(SwingConstants.CENTER);
		ttfNP04_A.setEditable(false);
		ttfNP04_A.setColumns(10);
		
		ttfNP04_B = new JTextField();
		ttfNP04_B.setBounds(42, 123, 32, 20);
		panel_2.add(ttfNP04_B);
		ttfNP04_B.setHorizontalAlignment(SwingConstants.CENTER);
		ttfNP04_B.setEditable(false);
		ttfNP04_B.setColumns(10);
		
		ttfNP04_C = new JTextField();
		ttfNP04_C.setBounds(84, 123, 32, 20);
		panel_2.add(ttfNP04_C);
		ttfNP04_C.setHorizontalAlignment(SwingConstants.CENTER);
		ttfNP04_C.setEditable(false);
		ttfNP04_C.setColumns(10);
		
		ttfNP05_A = new JTextField();
		ttfNP05_A.setBounds(0, 167, 32, 20);
		panel_2.add(ttfNP05_A);
		ttfNP05_A.setHorizontalAlignment(SwingConstants.CENTER);
		ttfNP05_A.setEditable(false);
		ttfNP05_A.setColumns(10);
		
		ttfNP05_B = new JTextField();
		ttfNP05_B.setBounds(42, 167, 32, 20);
		panel_2.add(ttfNP05_B);
		ttfNP05_B.setHorizontalAlignment(SwingConstants.CENTER);
		ttfNP05_B.setEditable(false);
		ttfNP05_B.setColumns(10);
		
		ttfNP05_C = new JTextField();
		ttfNP05_C.setBounds(84, 167, 32, 20);
		panel_2.add(ttfNP05_C);
		ttfNP05_C.setHorizontalAlignment(SwingConstants.CENTER);
		ttfNP05_C.setEditable(false);
		ttfNP05_C.setColumns(10);
		
		lbSoTaiNguyen = new JLabel("S\u1ED1 T\u00E0i Nguy\u00EAn");
		lbSoTaiNguyen.setBounds(10, 42, 86, 14);
		panel1.add(lbSoTaiNguyen);
		
		ttfSoTaiNguyen = new JTextField();
		ttfSoTaiNguyen.setHorizontalAlignment(SwingConstants.CENTER);
		ttfSoTaiNguyen.setEditable(false);
		ttfSoTaiNguyen.setColumns(10);
		ttfSoTaiNguyen.setBounds(99, 39, 86, 20);
		panel1.add(ttfSoTaiNguyen);
		
		lbSoTienTrinh = new JLabel("S\u1ED1 Ti\u1EBFn Tr\u00ECnh");
		lbSoTienTrinh.setBounds(10, 75, 78, 14);
		panel1.add(lbSoTienTrinh);
		
		ttfSoTienTrinh = new JTextField();
		ttfSoTienTrinh.setHorizontalAlignment(SwingConstants.CENTER);
		ttfSoTienTrinh.setEditable(false);
		ttfSoTienTrinh.setColumns(10);
		ttfSoTienTrinh.setBounds(99, 72, 86, 20);
		panel1.add(ttfSoTienTrinh);
		
		panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(204, 255, 255));
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Capacity of each Resource", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(10, 106, 175, 147);
		panel1.add(panel_1_1);
		
		lbTN01 = new Label("TN 01");
		lbTN01.setBounds(10, 26, 42, 22);
		panel_1_1.add(lbTN01);
		
		lbTN02 = new Label("TN 02");
		lbTN02.setBounds(10, 67, 42, 22);
		panel_1_1.add(lbTN02);
		
		lbTN03 = new Label("TN 03");
		lbTN03.setBounds(10, 108, 42, 22);
		panel_1_1.add(lbTN03);
		
		ttfTN02 = new JTextField();
		ttfTN02.setHorizontalAlignment(SwingConstants.CENTER);
		ttfTN02.setEditable(false);
		ttfTN02.setColumns(10);
		ttfTN02.setBounds(68, 67, 86, 20);
		panel_1_1.add(ttfTN02);
		
		ttfTN03 = new JTextField();
		ttfTN03.setHorizontalAlignment(SwingConstants.CENTER);
		ttfTN03.setEditable(false);
		ttfTN03.setColumns(10);
		ttfTN03.setBounds(68, 108, 86, 20);
		panel_1_1.add(ttfTN03);
		
		ttfTN01 = new JTextField();
		ttfTN01.setHorizontalAlignment(SwingConstants.CENTER);
		ttfTN01.setEditable(false);
		ttfTN01.setColumns(10);
		ttfTN01.setBounds(68, 26, 86, 20);
		panel_1_1.add(ttfTN01);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resuilt", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(20, 341, 564, 49);
		contentPane.add(panel_1);
		
		lbResuilt = new JLabel("...");
		lbResuilt.setHorizontalAlignment(SwingConstants.CENTER);
		lbResuilt.setBounds(6, 16, 548, 22);
		panel_1.add(lbResuilt);
		
		btnInputFile = new JButton("Input File");
		btnInputFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("file text", "txt");
				fileChooser.setFileFilter(imageFilter);
				fileChooser.setMultiSelectionEnabled(false);
				fileChooser.setCurrentDirectory(new File("./"));
				int x = fileChooser.showDialog(getOwner(), "chon file");
				if (x == JFileChooser.APPROVE_OPTION)
					file = fileChooser.getSelectedFile();
				try {
					getFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnRefresh.setEnabled(true);
				btnGetResuilt.setEnabled(true);
				btnViewFile.setEnabled(true);
			}
		});
		btnInputFile.setBounds(20, 11, 89, 23);
		contentPane.add(btnInputFile);
		
		btnGetResuilt = new JButton("Get Resuilt");
		btnGetResuilt.setEnabled(false);
		btnGetResuilt.setBounds(473, 11, 111, 23);
		btnGetResuilt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefresh.doClick();
				lbResuilt.setText(bk.getSafeString());
			}
		});
		contentPane.add(btnGetResuilt);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(362, 11, 111, 23);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					getFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRefresh.setEnabled(false);
		contentPane.add(btnRefresh);
		
		btnViewFile = new JButton("View File");
		btnViewFile.setBounds(251, 11, 111, 23);
		btnViewFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Desktop.isDesktopSupported()) {
					System.out.println("Desktop is not supported");
					return;
				}
				
				Desktop desktop = Desktop.getDesktop();
				if (file.exists())
					try {
						desktop.open(file);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnViewFile.setEnabled(false);
		contentPane.add(btnViewFile);
		
		this.setResizable(false);
	}

	void getFile() throws IOException
	{
		System.out.println(file.getPath());
		bk = new banker(this.file.getPath());
		
		ttfSoTaiNguyen.setText(String.valueOf(bk.getSoTaiNguyen()));
		ttfSoTienTrinh.setText(String.valueOf(bk.getSotienTrinh()));
		ttfTN01.setText(String.valueOf(bk.getCapacity(1)));
		ttfTN02.setText(String.valueOf(bk.getCapacity(2)));
		ttfTN03.setText(String.valueOf(bk.getCapacity(3)));		
		ttfAP01_A.setText(String.valueOf(bk.getAllocation(1, 1)));
		ttfAP01_B.setText(String.valueOf(bk.getAllocation(1, 2)));
		ttfAP01_C.setText(String.valueOf(bk.getAllocation(1, 3)));
		ttfAP02_A.setText(String.valueOf(bk.getAllocation(2, 1)));
		ttfAP02_B.setText(String.valueOf(bk.getAllocation(2, 2)));
		ttfAP02_C.setText(String.valueOf(bk.getAllocation(2, 3)));
		ttfAP03_A.setText(String.valueOf(bk.getAllocation(3, 1)));
		ttfAP03_B.setText(String.valueOf(bk.getAllocation(3, 2)));
		ttfAP03_C.setText(String.valueOf(bk.getAllocation(3, 3)));
		ttfAP04_A.setText(String.valueOf(bk.getAllocation(4, 1)));
		ttfAP04_B.setText(String.valueOf(bk.getAllocation(4, 2)));
		ttfAP04_C.setText(String.valueOf(bk.getAllocation(4, 3)));
		ttfAP05_A.setText(String.valueOf(bk.getAllocation(5, 1)));
		ttfAP05_B.setText(String.valueOf(bk.getAllocation(5, 2)));
		ttfAP05_C.setText(String.valueOf(bk.getAllocation(5, 3)));
		ttfNP01_A.setText(String.valueOf(bk.getNeed(1, 1)));
		ttfNP01_B.setText(String.valueOf(bk.getNeed(1, 2)));
		ttfNP01_C.setText(String.valueOf(bk.getNeed(1, 3)));
		ttfNP02_A.setText(String.valueOf(bk.getNeed(2, 1)));
		ttfNP02_B.setText(String.valueOf(bk.getNeed(2, 2)));
		ttfNP02_C.setText(String.valueOf(bk.getNeed(2, 3)));
		ttfNP03_A.setText(String.valueOf(bk.getNeed(3, 1)));
		ttfNP03_B.setText(String.valueOf(bk.getNeed(3, 2)));
		ttfNP03_C.setText(String.valueOf(bk.getNeed(3, 3)));
		ttfNP04_A.setText(String.valueOf(bk.getNeed(4, 1)));
		ttfNP04_B.setText(String.valueOf(bk.getNeed(4, 2)));
		ttfNP04_C.setText(String.valueOf(bk.getNeed(4, 3)));
		ttfNP05_A.setText(String.valueOf(bk.getNeed(5, 1)));
		ttfNP05_B.setText(String.valueOf(bk.getNeed(5, 2)));
		ttfNP05_C.setText(String.valueOf(bk.getNeed(5, 3)));
	}
}
