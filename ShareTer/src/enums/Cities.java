package enums;

public enum Cities {
	Jerusalem(0),
	Tel_aviv(1),
	Haifa(2),
	Rishon_lezion(3),
	Ashdod(4),
	Petah_tikva(5),
	Beersheba(6),
	Netanya(7),
	Holon(8),
	Bnei_brak(9),
	Anthrosol(10);

		private int id;
		
		public String value() {
			return this.toString();
		}
		
		private Cities(int id) {
			this.id = id;
		}
}
