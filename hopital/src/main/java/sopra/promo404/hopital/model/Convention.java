package sopra.promo404.hopital.model;

public enum Convention {
	s1("Secteur 1"), s2("Secteur 2"), s3("Secteur 3");

	private final String label;

	private Convention(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
