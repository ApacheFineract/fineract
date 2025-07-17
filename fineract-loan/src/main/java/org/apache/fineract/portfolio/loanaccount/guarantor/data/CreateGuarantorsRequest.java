package org.apache.fineract.portfolio.loanaccount.guarantor.data;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@FieldNameConstants
public class CreateGuarantorsRequest implements Serializable {
    private static final long serialVersionUID = 1L;

//    private Long loanId;
//    private GuarantorsRequest request;

    private String locale;
    private String dateFormat; // "dd MMMM yyyy"

    /*** Fields for capturing relationship of Guarantor with customer **/
    private Long clientRelationshipTypeId;

    /*** Fields for current customers serving as guarantors **/
    private Integer guarantorTypeId;
    private Long entityId;

    /*** Fields for external persons serving as guarantors ***/
    private String firstname;
    private String lastname;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String mobileNumber;
    private String housePhoneNumber;
    private String comment;
    private String dob;
    private Long savingsId;
    private BigDecimal amount;

}
