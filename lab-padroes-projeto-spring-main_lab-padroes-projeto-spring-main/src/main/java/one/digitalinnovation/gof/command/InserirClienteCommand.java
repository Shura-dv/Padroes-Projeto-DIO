package one.digitalinnovation.gof.command;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.service.ClienteService;

public class InserirClienteCommand implements Command {
    private ClienteService clienteService;
    private Cliente cliente;

    public InserirClienteCommand(ClienteService clienteService, Cliente cliente) {
        this.clienteService = clienteService;
        this.cliente = cliente;
    }

    @Override
    public void executar() {
        clienteService.inserir(cliente);
    }
}
