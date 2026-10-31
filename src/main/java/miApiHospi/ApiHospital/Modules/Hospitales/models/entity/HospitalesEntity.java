package miApiHospi.ApiHospital.Modules.Hospitales.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "HOSPITALES")
@Getter @Setter
public class HospitalesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDHOSPITALES")
    private Long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "CORREO", unique = true)
    private String correo;
    @Column(name = "CIUDAD")
    private String ciudad;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "NUMEROCAMAS")
    private String numeroCamas;
    @Column(name = "FECHAFUNDACION")
    private String fechaFundacion;
}
