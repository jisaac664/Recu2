package miApiHospi.ApiHospital.Modules.Ingresados.models.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IngresadoRequestDTO {
    @NotBlank
    private String cantidadIngresado;
    @NotBlank
    private String tratamiento;

}
