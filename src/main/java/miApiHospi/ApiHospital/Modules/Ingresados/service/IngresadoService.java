package miApiHospi.ApiHospital.Modules.Ingresados.service;

import jakarta.validation.Valid;
import miApiHospi.ApiHospital.Modules.Ingresados.models.dto.IngresadoRequestDTO;
import miApiHospi.ApiHospital.Modules.Ingresados.models.dto.IngresadoResponseDTO;
import miApiHospi.ApiHospital.Modules.Ingresados.models.entity.IngresadoEntity;
import miApiHospi.ApiHospital.Modules.Ingresados.repository.IngresadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngresadoService {

    private final IngresadoRepository repoIngresado;
    private final ModelMapper modelMapper;

    public IngresadoService(IngresadoRepository repoIngresado, ModelMapper modelMapper) {
        this.repoIngresado = repoIngresado;
        this.modelMapper = modelMapper;
    }

    public List<IngresadoResponseDTO> getData(){
        //1.Traer los datos de la base, los datos vienen en formato Entity
        List<IngresadoEntity> data = repoIngresado.findAll();
        //2. Retornar los datos encontrados convirtiendole los detos de Entity a ResponseDTO
        return data.stream()
                .map( IngresadoEntity -> modelMapper.map(IngresadoEntity, IngresadoResponseDTO.class))
                .toList();
    }

    public IngresadoResponseDTO ingresarDatos(@Valid IngresadoRequestDTO dtoRequest){
        IngresadoEntity datosGuardados = repoIngresado.save(modelMapper.map(dtoRequest, IngresadoEntity.class));
        return modelMapper.map(datosGuardados, IngresadoResponseDTO.class);
    }
}
