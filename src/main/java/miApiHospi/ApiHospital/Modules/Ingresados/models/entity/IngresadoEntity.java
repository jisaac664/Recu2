package miApiHospi.ApiHospital.Modules.Ingresados.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "INGRESADOS")
@Getter
@Setter
public class IngresadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDINGRESADOS")
    private Long id;
    @Column(name = "CANTIDADINGRESADO")
    private String cantidadIngresado;
    @Column(name = "TRATAMIENTO")
    private String tratamiento;
}
