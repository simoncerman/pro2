package cz.uhk.kpro2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fuel_cells")
public class FuelCell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double height;
    private double width;
    private String quality;
    private double holeOffcenter;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public double getHoleOffcenter() {
        return holeOffcenter;
    }

    public void setHoleOffcenter(double holeOffcenter) {
        this.holeOffcenter = holeOffcenter;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
