package agenda.entity;

import agenda.enuns.Sex;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Setter
@Getter
@Entity(name = "PERSON")
public class PersonEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String birthDate;
    private String sex;
}
