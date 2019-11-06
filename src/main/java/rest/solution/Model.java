package rest.solution;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
public class Model extends ModelID {
    @Column(name = "name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "payment")
    private int payment;
}

