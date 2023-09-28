package one.digitalinnovation.gof.handler;

import one.digitalinnovation.gof.model.Cliente;

public class ValidacaoNomeHandler extends ValidacaoClienteHandler {
    @Override
    public void validar(Cliente cliente) {
    	

        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new IllegalArgumentException("O campo 'nome' é obrigatório.");
        }

        
        validarProximo(cliente);
    }
}
