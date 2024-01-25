package q1.Q2;

import java.util.Objects;

public class Student {
	public int studentNum;
	public String name;

	public Student() {
	}

	public Student(int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student m = (Student) obj;
			return m.getStudentNum() == this.studentNum;
		} else
			return false;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
