
package acme.entities.auditRecords;

public enum Mark {

	A_PLUS("A+"), A("A"), B("B"), C("C"), F("F"), F_MINUS("F-");


	private final String markValue;


	Mark(final String markValue) {
		this.markValue = markValue;
	}

	public String getMarkValue() {
		return this.markValue;
	}
}
