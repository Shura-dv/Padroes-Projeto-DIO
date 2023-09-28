package one.digitalinnovation.gof.handler;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.Endereco;

public class ValidacaoOutraRegraHandler extends ValidacaoClienteHandler {
    @Override
    public void validar(Cliente cliente) {
        
    
        Endereco endereco = cliente.getEndereco();

        if (!outraRegraEhAtendida(endereco)) {
            throw new IllegalArgumentException("A regra de validação do campo 'cep' falhou.");
        }
        
        validarProximo(cliente);
    }

    private boolean outraRegraEhAtendida(Endereco endereco) {
    	
        // Validação do campo CEP
        
        String cep = endereco.getCep();
        if (cep == null || cep.isEmpty()) {
            return false;
        }

        return true;
    }
}
