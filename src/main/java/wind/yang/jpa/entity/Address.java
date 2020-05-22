package wind.yang.jpa.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String zipCode;
}
