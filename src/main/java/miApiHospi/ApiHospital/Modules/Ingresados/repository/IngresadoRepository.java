package miApiHospi.ApiHospital.Modules.Ingresados.repository;

import miApiHospi.ApiHospital.Modules.Ingresados.models.entity.IngresadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngresadoRepository extends JpaRepository<IngresadoEntity, Long> {

}
