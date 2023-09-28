package one.digitalinnovation.gof.service.invoker;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.command.Command;

@Service
public class ClienteServiceInvoker {

    private Queue<Command> comandos = new LinkedList<>();

    public void adicionarComando(Command comando) {
        comandos.add(comando);
    }

    public void executarComandos() {
        while (!comandos.isEmpty()) {
            Command comando = comandos.poll();
            comando.executar();
        }
    }
}

