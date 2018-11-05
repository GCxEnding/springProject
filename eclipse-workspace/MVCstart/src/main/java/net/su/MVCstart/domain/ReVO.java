package net.su.MVCstart.domain;

public class ReVO {
	private int re_num=0;
	private String re_name;
	private String re_contents;
	private String re_date;
	private int fk=0;
	
	public int getRe_num() {
		return re_num;
	}
	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	public String getRe_name() {
		return re_name;
	}
	public void setRe_name(String re_name) {
		this.re_name = re_name;
	}
	public String getRe_contents() {
		return re_contents;
	}
	public void setRe_contents(String re_contents) {
		this.re_contents = re_contents;
	}
	public String getRe_date() {
		return re_date;
	}
	public void setRe_date(String re_date) {
		this.re_date = re_date;
	}
	public int getFk() {
		return fk;
	}
	public void setFk(int fk) {
		this.fk = fk;
	}
}