package objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Contact {

    private String salutation;
    private String contactName;
    private String contactLastName;
    private String accountContactName;
    private String description;
    private String contactPhone;
    private String contactEmail;
}
