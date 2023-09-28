package one.digitalinnovation.gof.observer;

import one.digitalinnovation.gof.model.Cliente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class RegistroLog implements ClienteObserver {

    private static final Logger logger = LoggerFactory.getLogger(RegistroLog.class);

    public void atualizar(Cliente cliente) {
        // Implemente o código para registrar a inserção do cliente em um log.
        logger.info("Cliente {} foi inserido no log.", cliente.getNome());
    }
}


