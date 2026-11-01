package miApiHospi.ApiHospital.Modules.Ingresados.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import miApiHospi.ApiHospital.Modules.Ingresados.models.dto.IngresadoRequestDTO;
import miApiHospi.ApiHospital.Modules.Ingresados.models.dto.IngresadoResponseDTO;
import miApiHospi.ApiHospital.Modules.Ingresados.service.IngresadoService;
import miApiHospi.ApiHospital.Response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/ingresados")
public class IngresadoController {

    private final IngresadoService service;

    public IngresadoController(IngresadoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<IngresadoResponseDTO>>> obtenerDatos(){
        try{
            //Invocar el metodo del service que me permite obtener los datos
            List<IngresadoResponseDTO> dataRespuesta = service.getData();
            if(dataRespuesta != null && !dataRespuesta.isEmpty()){
                //Este proceso se ejecuta cuando hay datos en la base de datos
                ApiResponse<List<IngresadoResponseDTO>> respuesta = new ApiResponse<>(
                        true,
                        "Datos encontrados",
                        dataRespuesta);
                log.info("Se consultaron dtos de los ingresados");
                return ResponseEntity.ok(respuesta);
            }
            //Este proceso se ejecutara cuando no haya datos por mostrar
            ApiResponse<List<IngresadoResponseDTO>> respuesta = new ApiResponse<>(
                    true,
                    "No hay datos por mostrar");
            log.info("Se consultaron dtos de los ingresados, pero no hay registros");
            return ResponseEntity.ok(respuesta);
        }catch(Exception e){
            //Este proceso se ejecutara no la consulta haya dado error
            ApiResponse<List<IngresadoResponseDTO>> respuesta = new ApiResponse<>(
                    false,
                    "Ocurrio un error durante el proceso.");
            log.error("Ocurrio un error en el proceso de consulta.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<IngresadoResponseDTO>> agregarCliente(
            @Valid @RequestBody IngresadoRequestDTO resquestDTO){
        IngresadoResponseDTO data = service.ingresarDatos(resquestDTO);
        if(data != null){
            ApiResponse<IngresadoResponseDTO> respuesta = new ApiResponse<>(
                    true,
                    "Datos ingresados exitosamente",
                    data
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
        }
        ApiResponse<IngresadoResponseDTO> respuesta = new ApiResponse<>(
                false,
                "No se pudo realizar la insercion de datos");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }
}
