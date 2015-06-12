package enums;

public enum Faults {
	INSECT(0) {
		@Override
		public String value() {
			return "insect";
		}
	},
	FIRE_DAMEGE(1) {
		@Override
		public String value() {
			return "fire damege";
		}
	},
	LARGE_TREES_CLOSE_TO_BUILDING(2) {
		@Override
		public String value() {
			return "large trees close to building";
		}
	},
	ELECTRICAL_SYSTEM(3) {
		@Override
		public String value() {
			return "electrical system ";
		}
	},
	EXTERIOR_DEFECTS(4) {
		@Override
		public String value() {
			return "exterior defects";
		}
	},
	EXTERIOR_STRUCTURAL_DEFECTS(5) {
		@Override
		public String value() {
			return "exterior structural defects";
		}
	},
	HEAT_BOILER_GAS_DEFECTS(6) {
		@Override
		public String value() {
			return "heat boiler gas defects";
		}
	},
	PLUMBING_DWV_DEFECTS(7) {
		@Override
		public String value() {
			return "plumbing dwv defects ";
		}
	},
	PLUMBING_FIXTURE_DEFECTS(8) {
		@Override
		public String value() {
			return "plumbing fixture defects ";
		}
	},
	PLUMBING_SUPPLY_PIPE_DEFECTS(9) {
		@Override
		public String value() {
			return "plumbing supply pipe defects ";
		}
	},
	ROOF_FLASHING_DEFECTS(10) {
		@Override
		public String value() {
			return "roof flashing defects ";
		}
	},
	ROOF_LOW_SLOPE_DEFECTS(11) {
		@Override
		public String value() {
			return "roof low slope defects";
		}
	},
	ROOF_STEEP_SLOPE_DEFECTS(12) {
		@Override
		public String value() {
			return "roof steep slope defects ";
		}
	},
	SITE_DRAINAGE_DEFECTS_(13) {
		@Override
		public String value() {
			return " site drainage defects";
		}
	},
	STRUCTURE_FLOOR_DEFECTS(14) {
		@Override
		public String value() {
			return "structure, floor defects";
		}
	},
	STRUCTURE_FOUNDATION_DEFECTS(15) {
		@Override
		public String value() {
			return "structure, foundation defects";
		}
	},
	STRUCTURE_ROOF_DEFECTS(16) {
		@Override
		public String value() {
			return "structure, roof defects";
		}
	},
	STRUCTURE_WALL_DEFECTS(17) {
		@Override
		public String value() {
			return "structure, wall defects";
		}
	};

	private int id;
	public abstract String value();
	
	private Faults(int id) {
		this.id = id;
	}
}
