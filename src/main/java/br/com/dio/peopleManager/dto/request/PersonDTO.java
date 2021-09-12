package br.com.dio.peopleManager.dto.request;

import br.com.dio.peopleManager.models.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
    @CPF
    private String cpf;

    private LocalDate birthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phonesList;

    public static PersonDTO toDTO(Person person){
        PersonDTO personDTO = new PersonDTO();

        personDTO.setId(person.getId());
        personDTO.setName(person.getName());
        personDTO.setSurname(person.getSurname());
        personDTO.setCpf(person.getCpf());
        personDTO.setBirthDate(person.getBirthDate());
        personDTO.setPhonesList(person.getPhonesList().stream()
                .map(PhoneDTO::toDTO).collect(Collectors.toList()));

        return  personDTO;
    }
}
