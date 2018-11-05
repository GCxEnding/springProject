package net.su.MVCstart.domain;

public class HomeVO {
		private int num=0;
		private String name;
		private String title;
		private String contents;
		private int sysdate=0;
		private int hit=0;
		private int fk=0;
		private int num_order=0;
		private int deps=0;
		
		public int getSysdate() {
			return sysdate;
		}
		public void setSysdate(int sysdate) {
			this.sysdate = sysdate;
		}
		public int getHit() {
			return hit;
		}
		public void setHit(int hit) {
			this.hit = hit;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContents() {
			return contents;
		}
		public void setContents(String contents) {
			this.contents = contents;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getFk() {
			return fk;
		}
		public void setFk(int fk) {
			this.fk = fk;
		}
		public int getNum_order() {
			return num_order;
		}
		public void setNum_order(int num_order) {
			this.num_order = num_order;
		}
		public int getDeps() {
			return deps;
		}
		public void setDeps(int deps) {
			this.deps = deps;
		}
		
}
