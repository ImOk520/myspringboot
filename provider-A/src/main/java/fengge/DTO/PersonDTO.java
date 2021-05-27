package fengge.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
public class PersonDTO {
    private Integer id;

    private String sexCode;

    private String name;

    public void setName(String name) {
        this.name = this.sexCode;
    }
}