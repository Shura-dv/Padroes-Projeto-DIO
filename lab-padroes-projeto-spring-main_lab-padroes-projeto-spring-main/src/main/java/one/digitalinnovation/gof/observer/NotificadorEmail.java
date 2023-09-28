package one.digitalinnovation.gof.observer;

import org.springframework.stereotype.Component;

import one.digitalinnovation.gof.model.Cliente;

@Component
public class NotificadorEmail implements ClienteObserver {

    @Override
    public void atualizar(Cliente cliente) {
        // Aqui pode ser implementado a lógica do envio da notificação por e-mail sobre a inserção do cliente, caso necessário
        System.out.println("Enviando e-mail de boas-vindas para " + cliente.getNome());
    }
}

