package cz.uhk.kpro2.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "bos_member_id", nullable = true) // Ensure the foreign key column is correctly named
    private BOSMember bosMember;

    @ManyToMany
    @JoinTable(
        name = "course_members",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<User> members;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FuelCell> fuelCells;

    public BOSMember getBosMember() {
        return bosMember;
    }

    public void setBosMember(BOSMember bosMember) {
        this.bosMember = bosMember;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<FuelCell> getFuelCells() {
        return fuelCells;
    }

    public void setFuelCells(List<FuelCell> fuelCells) {
        this.fuelCells = fuelCells;
    }

    public long getId() {
        return id;
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
