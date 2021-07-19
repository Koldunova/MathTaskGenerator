package by.koldunova.task;

import java.util.ArrayList;

import by.koldunova.task.entity.MathAct;
import by.koldunova.task.entity.MyTask;

public class TaskGenerator {
	private int range;
	private boolean humiliation;
	private boolean division;
	private boolean addition;
	private boolean subtraction;
		
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public boolean isHumiliation() {
		return humiliation;
	}
	public void setHumiliation(boolean humiliation) {
		this.humiliation = humiliation;
	}
	public boolean isDivision() {
		return division;
	}
	public void setDivision(boolean division) {
		this.division = division;
	}
	public boolean isAddition() {
		return addition;
	}
	public void setAddition(boolean addition) {
		this.addition = addition;
	}
	public boolean isSubtraction() {
		return subtraction;
	}
	public void setSubtraction(boolean subtraction) {
		this.subtraction = subtraction;
	}

	private int generateNumber() {
		return 1 + (int) (Math.random() * range);
	}
	
	private MathAct generateOperation() {
		ArrayList<MathAct> list = new ArrayList<MathAct>();
		if (division) {list.add(MathAct.division);}
		if (addition) {list.add(MathAct.addition);}
		if (subtraction) {list.add(MathAct.subtraction);}
		if (humiliation) {list.add(MathAct.humiliation);}	
		
		final int first = 0;
		final int last = list.size()-1;

		return list.get(first + (int)(Math.random()* last));
	}
	
	public MyTask generateTask() {
		MyTask myTask = new  MyTask();
		
		myTask.setNum1(generateNumber());
		myTask.setNum2(generateNumber());		
		myTask.setAct(generateOperation()); 
		myTask.setResult();
		
		return myTask;
	}
}
