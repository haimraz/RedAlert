package enums;

public enum Professional {
	BOILERMAKER(0){
		@Override
		public String value() {
			return "Boilermaker";
		}
	},
	CARPENTER(1) {
		@Override
		public String value() {
			return "Carpenter";
		}
	},
	CARPET_LAYER(2) {
		@Override
		public String value() {
			return "Carpet layer";
		}
	},
	DREDGER(3) {
		@Override
		public String value() {
			return "Dredger";
		}
	},
	ELECTRICIAN(4) {
		@Override
		public String value() {
			return "Electrician";
		}
	},
	ELEVATOR_MECHANIC(5) {
		@Override
		public String value() {
			return "Elevator mechanic";
		}
	},
	FENCER(6) {
		@Override
		public String value() {
			return "Fencer";
		}
	},
	GLAZIER(7) {
		@Override
		public String value() {
			return "Glazier";
		}
	},
	HEAVY_EQUIPMENT_OPERATOR(8) {
		@Override
		public String value() {
			return "Heavy equipment operator";
		}
	},
	LABORER(9) {
		@Override
		public String value() {
			return "Laborer";
		}
	},
	LANDSCAPER(10) {
		@Override
		public String value() {
			return "Landscaper";
		}
	},
	MASON(11) {
		@Override
		public String value() {
			return "Mason";
		}
	},
	MILLWRIGHT(12) {
		@Override
		public String value() {
			return "Millwright";
		}
	},
	HOUSE_PAINTER_AND_DECORATOR(13) {
		@Override
		public String value() {
			return "House painter and decorator";
		}
	},
	PILE_DRIVER(14) {
		@Override
		public String value() {
			return "Pile driver";
		}
	},
	PLASTERER(15) {
		@Override
		public String value() {
			return "Plasterer";
		}
	},
	PLUMBER(16) {
		@Override
		public String value() {
			return "Plumber";
		}
	},
	PIPEFITTER(17) {
		@Override
		public String value() {
			return "Pipefitter";
		}
	},
	SHEET_METAL_WORKER(18) {
		@Override
		public String value() {
			return "Sheet metal worker";
		}
	},
	FIRE_SPRINKLER(19) {
		@Override
		public String value() {
			return "Fire sprinkler";
		}
	},
	SITE_MANAGER(20) {
		@Override
		public String value() {
			return "Site manager";
		}
	},
	STEEL_FIXER(21) {
		@Override
		public String value() {
			return "Steel fixer";
		}
	},
	WATERPROOFER(22) {
		@Override
		public String value() {
			return "Waterproofer";
		}
	},
	WELDER(23) {
		@Override
		public String value() {
			return "Welder";
		}
	};

	
	private int id;
	public abstract String value();

	private Professional(int id) {
		this.id = id;
	}
}
