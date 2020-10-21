package richjsf.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "coffee_type")
@Data
public class CoffeeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
