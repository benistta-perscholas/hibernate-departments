package model;
import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
public class Department {
    @Column(name = "DEPARTMENT_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String state;


    public Department() {
    }

    public Department(String name, String state) {
//        this.id = id;
        this.name = name;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

