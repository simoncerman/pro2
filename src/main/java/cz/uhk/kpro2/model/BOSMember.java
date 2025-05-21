package cz.uhk.kpro2.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bos_members")
public class BOSMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId() {
        return id != null ? id : -1L; // nebo null, ale to stejně může hodit chybu jinde
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
