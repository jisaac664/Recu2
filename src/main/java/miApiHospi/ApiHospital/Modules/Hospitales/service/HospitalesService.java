package miApiHospi.ApiHospital.Modules.Hospitales.service;


import jakarta.validation.Valid;
import miApiHospi.ApiHospital.Modules.Hospitales.models.dto.HospitalesRequestDTO;
import miApiHospi.ApiHospital.Modules.Hospitales.models.dto.HospitalesResponseDTO;
import miApiHospi.ApiHospital.Modules.Hospitales.models.entity.HospitalesEntity;
import miApiHospi.ApiHospital.Modules.Hospitales.repository.HospitalesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalesService {

    private final HospitalesRepository repoHospital;
    private final ModelMapper modelMapper;

    public HospitalesService(HospitalesRepository repoHospital, ModelMapper modelMapper) {
        this.repoHospital = repoHospital;
        this.modelMapper = modelMapper;
    }

    /***
     *
     * @return es una lista de objeto ResponseDTO
     */
    public List<HospitalesResponseDTO> getData(){
        //1.Traer los datos de la base, los datos vienen en formato Entity
        List<HospitalesEntity> data = repoHospital.findAll();
        //2. Retornar los datos encontrados convirtiendole los detos de Entity a ResponseDTO
        return data.stream()
                .map( HospitalesEntity -> modelMapper.map(HospitalesEntity, HospitalesResponseDTO.class))
                .toList();
    }

    public HospitalesResponseDTO ingresarDatos(@Valid HospitalesRequestDTO dtoRequest){
        //Validar si el correo ya existe en la base de datos
        HospitalesEntity data = repoHospital.findByCorreo(dtoRequest.getCorreo());
        if (data == null){
            HospitalesEntity datosGuardados = repoHospital.save(modelMapper.map(dtoRequest, HospitalesEntity.class));
            return modelMapper.map(datosGuardados, HospitalesResponseDTO.class);
        }
        return null;
    }
}
