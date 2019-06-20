
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class makeNew extends JFrame implements ActionListener {
	JFrame frame;
	Container contentPane;
	JRadioButton rd1, rd2;
	ButtonGroup groupRd;
	JPanel panel1, panel2;
	JPanel NewWindowContainer;
	JSpinner spinner;
	JTextField text1;
	JButton but1;

	makeNew() {

		setTitle("회원가입");
		setSize(300, 200);
		setLocation(500, 400);

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.setLayout(new GridLayout(3, 2));
		text1 = new JTextField();
		panel1.add(new JLabel("ID : "));
		panel1.add(text1);
		panel1.add(new JLabel("생년월일 : "));

		Calendar calendar = Calendar.getInstance();
		Date value = calendar.getTime();

		calendar.add(Calendar.YEAR, -50); // 50년 전의 날짜 얻기
		Date start = calendar.getTime(); // 50년 전의 날짜를 최소 날짜로 지정

		calendar.add(Calendar.YEAR, 100); // 50년 뒤의 날짜 얻기 +50하면 현재날짜가됨.
		Date end = calendar.getTime(); // 50년 뒤의 날짜를 최대 날짜로 지정

		SpinnerDateModel dateModel = new SpinnerDateModel(value, start, end, Calendar.YEAR);
		spinner = new JSpinner(dateModel);
		spinner.setEditor(new JSpinner.DateEditor(spinner, "yyyy/MM/dd")); // 날짜 편집기 지정

		panel1.add(spinner);

		panel1.add(new JLabel("성별"));

		rd1 = new JRadioButton("남");
		rd2 = new JRadioButton("여");

		groupRd = new ButtonGroup();

		groupRd.add(rd1);
		groupRd.add(rd2);

		panel2.add(rd1);
		panel2.add(rd2);
		panel1.add(panel2);

		rd1.setSelected(true);

		add(panel1);
		but1 = new JButton("완료");
		add(but1, BorderLayout.SOUTH);

		but1.addActionListener(this);

		setVisible(true);

	}

	@Override

	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub

		if (e.getSource() == but1) {

			String neid = text1.getText();
			String filename = neid + ".txt";

			File file = new File(filename);
			FileWriter writer = null;

			if (file.isFile()) {
				JOptionPane.showMessageDialog(null, "해당 아이디는 이미 존재 합니다.", "오류 메세지", JOptionPane.ERROR_MESSAGE);
			} 
			else {
				try {
					file.createNewFile();
				} catch (IOException ee) {
					ee.printStackTrace();
				}

				String gender = null;
				if (rd1.isSelected()) {
					gender = "man";
				} else if (rd2.isSelected()) {
					gender = "woman";
				}
				Object dayy;
				dayy = spinner.getValue();
				String time = null;
				if (dayy instanceof Date) {
					Date date = (Date) dayy;
					SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
					time = format.format(date);

				}
				System.out.println(neid + time + gender);

				try {
					writer = new FileWriter(file, true);
					//writer.write(neid + "\t" + gender + "\t" + time + "\n");
				} catch (IOException eee) {
					eee.printStackTrace();
				} finally {
					try {
						if (writer != null)
							writer.close();
					} catch (IOException eee) {
						eee.printStackTrace();
					}
				}
				
				dispose();
			}

		}

	}

}
