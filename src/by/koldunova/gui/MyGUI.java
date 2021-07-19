package by.koldunova.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import by.koldunova.task.TaskGenerator;
import by.koldunova.task.entity.MyTask;

public class MyGUI extends JFrame {
	private JButton button = new JButton("���������");
	private JTextField input = new JTextField("",5);
	private JLabel labelRange = new JLabel("������������ �����:");
	private JCheckBox check�umiliation = new JCheckBox("���������", false);
	private JCheckBox checkDivision = new JCheckBox("�������", false);
	private JCheckBox checkAddition = new JCheckBox("��������", false);
	private JCheckBox checkSubtraction = new JCheckBox("���������", false);
	
	public MyGUI() {
		super("Main");
		this.setBounds(100,100,500,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(4,2,2,2));
		container.add(labelRange);
		container.add(input);
		
		container.add(check�umiliation);
		container.add(checkDivision);
		container.add(checkAddition);
		container.add(checkSubtraction);

		button.addActionListener(new ButtonEventListener());
		container.add(button);
	}
	
	
	public class ButtonEventListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				int range = Integer.parseInt(input.getText());
				if (check�umiliation.isSelected() || checkAddition.isSelected() ||
						checkDivision.isSelected() || checkSubtraction.isSelected()) {
					
					TaskGenerator taskGenerator = new TaskGenerator();
					taskGenerator.setAddition(checkAddition.isSelected());
					taskGenerator.setDivision(checkDivision.isSelected());
					taskGenerator.setHumiliation(check�umiliation.isSelected());
					taskGenerator.setSubtraction(checkSubtraction.isSelected());
					taskGenerator.setRange(range);
					
					ArrayList<MyTask> myTasks = new ArrayList<MyTask>();
					for (int i=0;i<10;i++) {
						myTasks.add(taskGenerator.generateTask());
					}
					
					String tassskk ="";
					
					for (MyTask myTask : myTasks) {
						tassskk += myTask+"\n";
					}
					
					JOptionPane.showMessageDialog(null, tassskk, "������", JOptionPane.PLAIN_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(null, "�������� �������������� ��������", "���������", JOptionPane.PLAIN_MESSAGE);
				}
			}catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "������� ���������� ������������ �����", "������", JOptionPane.PLAIN_MESSAGE);
			}
			
		}	
	}
	
}
