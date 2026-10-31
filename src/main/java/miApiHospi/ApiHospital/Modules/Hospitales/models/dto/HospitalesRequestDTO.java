package miApiHospi.ApiHospital.Modules.Hospitales.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospitalesRequestDTO {
    @NotBlank
    private String nombre;
    @NotBlank
    private String direccion;
    @NotBlank @Email
    private String correo;
    @NotBlank
    private String ciudad;
    @NotBlank
    private String telefono;
    @NotBlank
    private String numeroCamas;
    @NotBlank
    private String fechaFundacion;
}
