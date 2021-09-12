package br.com.dio.peopleManager.dto.request;

import br.com.dio.peopleManager.enums.PhoneTypes;
import br.com.dio.peopleManager.models.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    private long id;

    @NotEmpty
    @Size(min = 14, max = 16)
    private String number;

    @Enumerated(EnumType.STRING)
    private PhoneTypes type;

    public static PhoneDTO toDTO(Phone phone){
        PhoneDTO phoneDTO = new PhoneDTO();

        phoneDTO.setId(phone.getId());
        phoneDTO.setNumber(phone.getNumber());
        phoneDTO.setType(phone.getType());

        return phoneDTO;
    }
}
