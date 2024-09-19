package br.com.bookvault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@Controller
@OpenAPIDefinition(
	info = @Info(
		title = "BookVault API",
		version =  "1.0.0",
		description = "API Rest do Projeto BookVault: Biblioteca Online",
		contact = @Contact(name = "Guilherme Matos, Gustavo Godoi", url = "https://github.com/guicarm/BookVault-API")	
	)
)
public class BookVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookVaultApplication.class, args);
	}

	@RequestMapping
	@ResponseBody
	public String home(){
		return "Bem-vindo a sua Book Vault, uma biblioteca online.";
	}

}
