package miApiHospi.ApiHospital;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiHospitalApplication {

	public static void main(String[] args) {
		cargarEnv();
		SpringApplication.run(ApiHospitalApplication.class, args);
	}

	public static void cargarEnv(){
		//Cargar variables del .en v a System Properties
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey(), entry.getValue())
		);
	}
}
