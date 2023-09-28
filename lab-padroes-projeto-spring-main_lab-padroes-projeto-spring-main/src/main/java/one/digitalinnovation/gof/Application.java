package one.digitalinnovation.gof;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import one.digitalinnovation.gof.controller.ClienteRestController;
import one.digitalinnovation.gof.observer.NotificadorEmail;
import one.digitalinnovation.gof.observer.RegistroLog;

@SpringBootApplication
@EnableFeignClients
public class Application {

    @Autowired
    private ClienteRestController clienteRestController;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @PostConstruct
    public void registrarObservadores() {
        clienteRestController.adicionarObservador(new NotificadorEmail());
        clienteRestController.adicionarObservador(new RegistroLog());
    }
}

