package by.koldunova.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import by.koldunova.task.TaskGenerator;
import by.koldunova.task.entity.MyTask;

public class MyGUI extends JFrame {
	private JButton button = new JButton("Применить");
	private JTextField input = new JTextField("",5);
	private JLabel labelRange = new JLabel("Максимальное число:");
	private JCheckBox checkНumiliation = new JCheckBox("Умножение", false);
	private JCheckBox checkDivision = new JCheckBox("Деление", false);
	private JCheckBox checkAddition = new JCheckBox("Сложение", false);
	private JCheckBox checkSubtraction = new JCheckBox("Вычитание", false);
	
	public MyGUI() {
		super("Main");
		this.setBounds(100,100,500,150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(4,2,2,2));
		container.add(labelRange);
		container.add(input);
		
		container.add(checkНumiliation);
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
				if (checkНumiliation.isSelected() || checkAddition.isSelected() ||
						checkDivision.isSelected() || checkSubtraction.isSelected()) {
					
					TaskGenerator taskGenerator = new TaskGenerator();
					taskGenerator.setAddition(checkAddition.isSelected());
					taskGenerator.setDivision(checkDivision.isSelected());
					taskGenerator.setHumiliation(checkНumiliation.isSelected());
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
					
					JOptionPane.showMessageDialog(null, tassskk, "Ошибка", JOptionPane.PLAIN_MESSAGE);
					
				}else {
					JOptionPane.showMessageDialog(null, "Выберите математические операции", "Сообщение", JOptionPane.PLAIN_MESSAGE);
				}
			}catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Введите корректное максимальное число", "Ошибка", JOptionPane.PLAIN_MESSAGE);
			}
			
		}	
	}
	
}
