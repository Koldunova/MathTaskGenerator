package by.koldunova.task.entity;

public class MyTask {
	private int num1;
	private int num2;
	private MathAct act;
	private int result;
	
	public int getNum1() {
		return num1;
	}
	
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	
	public int getNum2() {
		return num2;
	}
	
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	public MathAct getAct() {
		return act;
	}
	
	public void setAct(MathAct act) {
		this.act = act;
	}
	
	public int getResult() {
		return result;
	}
	
	public void setResult() {
		if (act == MathAct.addition) {
			result=num1 + num2;
		}
		if (act == MathAct.division) {
			if (num1==0) {
				int buf=num2;
				num2=num1;
				num1=buf;
			}
			result=num1 / num2;
		}
		if (act == MathAct.humiliation) {
			result=num1 * num2;
		}
		if (act == MathAct.subtraction) {
			if (num1<num2) {
				int buf=num2;
				num2=num1;
				num1=buf;
			}
			result=num1 - num2;
		}
	}

	@Override
	public String toString() {
		String task = num1+" ";
		
		if (act == MathAct.addition) {
			task +="+ ";
		}
		if (act == MathAct.division) {
			task +="/ ";
		}
		if (act == MathAct.humiliation) {
			task +="* ";
		}
		if (act == MathAct.subtraction) {
			task +="- ";
		}
		task += num2 + " = " + result;
		return task;
	}
	
	
	
}
