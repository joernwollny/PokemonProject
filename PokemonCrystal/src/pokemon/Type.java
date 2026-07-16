package pokemon;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Type {
	NO_TYPE,
	NORMAL,
	FIRE,
	WATER,
	GRASS,
	ELECTRIC,
	ICE,
	FIGHTING,
	POISON,
	GROUND,
	FLYING,
	PSYCHIC,
	BUG,
	ROCK,
	GHOST,
	DRAGON,
	DARK,
	STEEL,
	FAIRY,
	TYPELESS;

	//Stellar
	//???
	//Shadow

	static final int TYPE_CHART_OFFSET = -1;
	static final double[][] typeChart = { // Gen6+
		    // Def:  Nor Fir Wat Gra Ele Ice Fig Poi Gro Fly Psy Bug Roc Gho Dra Dar Ste Fai Typeless
		    /*Nor*/ {1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  0.5,0,  1,  1,  0.5,1,  1},
		    /*Fir*/ {1,  0.5,0.5,2,  1,  2,  1,  1,  1,  1,  1,  2,  0.5,1,  0.5,1,  2,  1,  1},
		    /*Wat*/ {1,  2,  0.5,0.5,1,  1,  1,  1,  2,  1,  1,  1,  2,  1,  0.5,1,  1,  1,  1},
		    /*Gra*/ {1,  0.5,2,  0.5,1,  1,  1,  0.5,2,  0.5,1,  0.5,2,  1,  0.5,1,  0.5,1,  1},
		    /*Ele*/ {1,  1,  2,  0.5,0.5,1,  1,  1,  0,  2,  1,  1,  1,  1,  0.5,1,  1,  1,  1},
		    /*Ice*/ {1,  0.5,0.5,2,  1,  0.5,1,  1,  2,  2,  1,  1,  1,  1,  2,  1,  0.5,1,  1},
		    /*Fig*/ {2,  1,  1,  1,  1,  2,  1,  0.5,1,  0.5,0.5,0.5,2,  0,  1,  2,  2,  0.5,1},
		    /*Poi*/ {1,  1,  1,  2,  1,  1,  1,  0.5,0.5,1,  1,  0.5,0.5,0.5,1,  1,  0,  2,  1},
		    /*Gro*/ {1,  2,  1,  0.5,2,  1,  1,  2,  1,  0,  1,  0.5,2,  1,  1,  1,  2,  1,  1},
		    /*Fly*/ {1,  1,  1,  2,  0.5,1,  2,  1,  1,  1,  1,  2,  0.5,1,  1,  1,  0.5,1,  1},
		    /*Psy*/ {1,  1,  1,  1,  1,  1,  2,  2,  1,  1,  0.5,1,  1,  1,  1,  0,  0.5,1,  1},
		    /*Bug*/ {1,  0.5,1,  2,  1,  1,  0.5,0.5,1,  0.5,2,  1,  1,  0.5,1,  2,  0.5,0.5,1},
		    /*Roc*/ {1,  2,  1,  1,  1,  2,  0.5,1,  0.5,2,  1,  2,  1,  1,  1,  1,  0.5,1,  1},
		    /*Gho*/ {0,  1,  1,  1,  1,  1,  1,  1,  1,  1,  2,  1,  1,  2,  1,  0.5,1,  1,  1},
		    /*Dra*/ {1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  2,  1,  0.5,0,  1},
		    /*Dar*/ {1,  1,  1,  1,  1,  1,  0.5,1,  1,  1,  2,  1,  1,  2,  1,  0.5,1,  0.5,1},
		    /*Ste*/ {1,  0.5,0.5,1,  0.5,2,  1,  1,  1,  1,  1,  1,  2,  1,  1,  1,  0.5,2,  1},
		    /*Fai*/ {1,  0.5,1,  1,  1,  1,  2,  0.5,1,  1,  1,  1,  1,  1,  2,  2,  0.5,1,  1},
		    /*Tle*/ {1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1}
	};

	public double getAdvantage(Species species) {
		double advantage = typeChart[this.ordinal()+TYPE_CHART_OFFSET][species.getPrimaryType().ordinal()+TYPE_CHART_OFFSET];
		if (species.hasTwoTypes()) {
			advantage *= typeChart[this.ordinal()+TYPE_CHART_OFFSET][species.getSecondaryType().ordinal()+TYPE_CHART_OFFSET];
		}
		return advantage;
	}
	
	@Override
	public String toString() {
		String name = name().toLowerCase();
		return Character.toUpperCase(name.charAt(0)) + name.substring(1);
	}
	
	@JsonCreator
	public static Type fromString(String value) {
		return Type.valueOf(value.toUpperCase());
	}
}
