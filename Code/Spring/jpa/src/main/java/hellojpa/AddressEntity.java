package hellojpa;

import javax.persistence.*;

@Entity
@Table(name="ADDRESS")
public class AddressEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    Address address;

    public AddressEntity(String city, String street, String zipcode) {
        this.address = new Address(city, street, zipcode);
    }

    public AddressEntity(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
