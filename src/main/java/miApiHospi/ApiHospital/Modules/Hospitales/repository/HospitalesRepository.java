package miApiHospi.ApiHospital.Modules.Hospitales.repository;

import miApiHospi.ApiHospital.Modules.Hospitales.models.entity.HospitalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalesRepository extends JpaRepository<HospitalesEntity, Long> {
    HospitalesEntity findByCorreo(String correo);
}
