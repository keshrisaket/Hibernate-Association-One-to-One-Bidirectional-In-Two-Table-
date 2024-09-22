package beans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Student_Table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Student_Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Student_Course", nullable = false, length = 50)
    private String course;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Rank_ID",referencedColumnName = "id",unique = true,nullable = false)
    private Rank rank;

}
