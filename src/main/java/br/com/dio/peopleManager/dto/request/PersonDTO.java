package br.com.dio.peopleManager.dto.request;

import br.com.dio.peopleManager.models.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private long id;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String name;

    @Size(min = 2, max = 100)
    private String surname;

    @NotEmpty
    @Size(max = 14)
    private String cpf;

    private LocalDate birthDate;

    @Valid
    @NotEmpty
    private List<Phone> phonesList;
}
