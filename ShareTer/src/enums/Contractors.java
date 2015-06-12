package enums;

public enum Contractors {
	
	Housing_and_construction(0),
	Africa_israel_investments(1),
	Electra(2),
	Danya(3),
	Ashtrom(4),
	Shafir(5);

	private int id;
	
	public String value() {
		return this.toString();
	}
	
	private Contractors(int id) {
		this.id = id;
	}

}
