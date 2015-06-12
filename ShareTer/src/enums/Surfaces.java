package enums;

public enum Surfaces {
	Acid_sulfate_soil(0),
	Acrisol(1),
	Akadama(2),
	Alfisol(3),
	Alkali_soil(4),
	Residual_sodium_carbonate_index(5),
	Alvar(6),
	Andisol(7),
	Andosol(8),
	Anthrepts(9),
	Anthrosol(10),
	Antigo(11),
	Aridisol(12),
	Bama(13),
	Bay_mud(14),
	Berkshire(15),
	Blandford(16),
	Bog(17),
	Brickearth(18),
	Brown_earth(19),
	Brown_podzolic(20),
	Calciorthid(21),
	Calcisol(22),
	Cambisol(23),
	Casa_grande(24),
	Cecil(25),
	Charlottetown_soil_series(26),
	Chernozem(27),
	Clay(28),
    Claypan(29),
	Downer(30),
	Drummer(31),
	Durisol(32),
	Entisol(33),
	Expansive_clay(34),
	Fill_dirt(35),
	Flatwood(36),
	Fluvisol(37),
	Fullers_earth(38),
	Gelisol(39),
	Gleysol(40),
	Greenwich(41),
	Guelph_soil(42),
	Gypsisols(43),
	Haplocambids(44),
	Hilo(45),
	Histosol(46),
	Houdek(47),
	Houston_black(48),
	Hume(49),
	Hydric_soil(50),
	Hydrophobic_soil(51),
	Inceptisol(52),
	Jory(53),
	Kalkaska_sand(54),
	Kastanozems(55),
	Latosol(56),
	Leptosol(57),
	List_of_bogs(58),
	Lixisol(59),
	Loam(60),
	Loess(61);

		private int id;
		
		public String value() {
			return this.toString();
		}
		
		private Surfaces(int id) {
			this.id = id;
		}
	
}
