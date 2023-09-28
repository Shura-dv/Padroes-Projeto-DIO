package one.digitalinnovation.gof.handler;

import one.digitalinnovation.gof.model.Cliente;

public abstract class ValidacaoClienteHandler {
    private ValidacaoClienteHandler proximo;

    public ValidacaoClienteHandler getProximo() {
        return proximo;
    }

    public void setProximo(ValidacaoClienteHandler proximo) {
        this.proximo = proximo;
    }

    public abstract void validar(Cliente cliente);

    protected void validarProximo(Cliente cliente) {
        if (proximo != null) {
            proximo.validar(cliente);
        }
    }
}
