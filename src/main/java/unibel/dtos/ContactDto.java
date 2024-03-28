package unibel.dtos;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unibel.models.ContactType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
	Long contactId;
	ContactType contactType;
	String contactValue;
}
