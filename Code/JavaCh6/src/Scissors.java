
public class Scissors {
	private int Select;
	private String StrSelect;
	public Scissors(int Select) {
		this.Select=Select;
		this.setSelect(Select);
	}
	public void setSelect(int Select) {
		if(this.Select==1) this.StrSelect="����";
		else if(this.Select==2) this.StrSelect="����";
		else this.StrSelect="��";
	}
	public String getSelect() {
		return StrSelect;
	}
}
