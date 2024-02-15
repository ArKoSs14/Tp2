public enum Periode {
    MATIN,
    APRESMIDI,
    SOIREE;

    public String toString() {
	if (this == MATIN)
	    return "Matin";
	else if (this == APRESMIDI)
	    return "ApresMidi";
	else {
	    assert this == SOIREE;
	    return "Soiree";
	}
    }
}
