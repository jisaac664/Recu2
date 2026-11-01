package miApiHospi.ApiHospital.Modules.Ingresados.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IngresadoResponseDTO {
    private Long id;
    private String cantidadIngresado;
    private String tratamiento;
}
