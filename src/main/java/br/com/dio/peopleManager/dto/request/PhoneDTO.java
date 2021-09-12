package br.com.dio.peopleManager.dto.request;

import br.com.dio.peopleManager.enums.PhoneTypes;
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
    @Size(min = 14, max = 15)
    private String number;

    @Enumerated(EnumType.STRING)
    private PhoneTypes type;
}
