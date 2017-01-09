package ni.org.ics.zikapositivas.domain.audit;

public interface Auditable {
	
	public boolean isFieldAuditable(String fieldname);

}
