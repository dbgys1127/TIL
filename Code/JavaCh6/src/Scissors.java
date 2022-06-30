
public class Scissors {
	private int Select;
	private String StrSelect;
	public Scissors(int Select) {
		this.Select=Select;
		this.setSelect(Select);
	}
	public void setSelect(int Select) {
		if(this.Select==1) this.StrSelect="가위";
		else if(this.Select==2) this.StrSelect="바위";
		else this.StrSelect="보";
	}
	public String getSelect() {
		return StrSelect;
	}
}
