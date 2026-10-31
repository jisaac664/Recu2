package miApiHospi.ApiHospital.Modules.Hospitales.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import miApiHospi.ApiHospital.Modules.Hospitales.models.dto.HospitalesRequestDTO;
import miApiHospi.ApiHospital.Modules.Hospitales.models.dto.HospitalesResponseDTO;
import miApiHospi.ApiHospital.Modules.Hospitales.service.HospitalesService;
import miApiHospi.ApiHospital.Response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/hospitales")
public class HospitalesController {

    private final HospitalesService service;

    public HospitalesController(HospitalesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<HospitalesResponseDTO>>> obtenerDatos(){
        try{
            //Invocar el metodo del service que me permite obtener los datos
            List<HospitalesResponseDTO> dataRespuesta = service.getData();
            if(dataRespuesta != null && !dataRespuesta.isEmpty()){
                //Este proceso se ejecuta cuando hay datos en la base de datos
                ApiResponse<List<HospitalesResponseDTO>> respuesta = new ApiResponse<>(
                        true,
                        "Datos encontrados",
                        dataRespuesta);
                log.info("Se consultaron dtos de los hospitales");
                return ResponseEntity.ok(respuesta);
            }
            //Este proceso se ejecutara cuando no haya datos por mostrar
            ApiResponse<List<HospitalesResponseDTO>> respuesta = new ApiResponse<>(
                    true,
                    "No hay datos por mostrar");
            log.info("Se consultaron dtos de los hospitales, pero no hay registros");
            return ResponseEntity.ok(respuesta);
        }catch(Exception e){
            //Este proceso se ejecutara no la consulta haya dado error
            ApiResponse<List<HospitalesResponseDTO>> respuesta = new ApiResponse<>(
                    false,
                    "Ocurrio un error durante el proceso.");
            log.error("Ocurrio un error en el proceso de consulta.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<HospitalesResponseDTO>> agregarCliente(
            @Valid @RequestBody HospitalesRequestDTO resquestDTO){
        HospitalesResponseDTO data = service.ingresarDatos(resquestDTO);
        if(data != null){
            ApiResponse<HospitalesResponseDTO> respuesta = new ApiResponse<>(
                    true,
                    "Datos ingresados exitosamente",
                    data
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
        }
        ApiResponse<HospitalesResponseDTO> respuesta = new ApiResponse<>(
                false,
                "No se pudo realizar la insercion de datos");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }
}
