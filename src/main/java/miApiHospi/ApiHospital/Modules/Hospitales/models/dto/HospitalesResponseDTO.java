package miApiHospi.ApiHospital.Modules.Hospitales.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospitalesResponseDTO {
    private Long id;
    private String nombre;
    private String direccion;
    private String correo;
    private String ciudad;
    private String telefono;
    private String numeroCamas;
    private String fechaFundacion;
}
