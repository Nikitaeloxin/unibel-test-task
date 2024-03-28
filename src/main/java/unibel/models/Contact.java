package unibel.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="contacts")
@Data
public class Contact {
	
	@Column(name="contact_id")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;

	@Column(name="contact_type")
    private ContactType contactType;
	
	@Column(name="contact_value")
    private String contactValue;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
