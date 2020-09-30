package agenda.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.management.StringValueExp;

@Getter
@AllArgsConstructor
public enum Sex {
    female("female"),
    male("male");

    private String value;
}
