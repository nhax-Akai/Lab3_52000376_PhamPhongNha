package domain;

import java.io.Serializable;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "manufacture")
public class Manufacture implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "name", nullable = false, length = 128)
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "employee")
    private int employee;

    @OneToMany(mappedBy = "manufacture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones;

    // constructors, getters, and setters

    public Manufacture() {
        super();
    }

    public Manufacture(String id, String name, String location, int employee, List<Phone> phones) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.employee = employee;
        this.phones = phones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
