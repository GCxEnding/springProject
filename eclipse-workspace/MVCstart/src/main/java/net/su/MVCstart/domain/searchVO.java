package net.su.MVCstart.domain;

public class searchVO {
	private String String;
	private String word;
	private int first = 0;
	private int sec = 0;
	
	
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getSec() {
		return sec;
	}
	public void setSec(int sec) {
		this.sec = sec;
	}
	public String getString() {
		return String;
	}
	public void setString(String string) {
		String = string;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}

}
