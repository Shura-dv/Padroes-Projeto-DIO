package one.digitalinnovation.gof.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import one.digitalinnovation.gof.command.*;
import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.observer.ClienteObserver;
import one.digitalinnovation.gof.service.ClienteService;
import one.digitalinnovation.gof.handler.*;
import one.digitalinnovation.gof.service.invoker.ClienteServiceInvoker;


@RestController
@RequestMapping("clientes")
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;
	
	private List<ClienteObserver> observadores = new ArrayList<>();
	
	@Autowired
    private ClienteServiceInvoker clienteServiceInvoker;

	@GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(clienteService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<?> inserir(@RequestBody Cliente cliente) {
	    ValidacaoClienteHandler correnteDeValidacao = new ValidacaoNomeHandler();
	    correnteDeValidacao.setProximo(new ValidacaoOutraRegraHandler());

	    try {
	        correnteDeValidacao.validar(cliente);
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.badRequest().body("Erro de validação: " + e.getMessage());
	    }

	    Command inserirClienteCommand = new InserirClienteCommand(clienteService, cliente);
	    clienteServiceInvoker.adicionarComando(inserirClienteCommand);
	    clienteServiceInvoker.executarComandos();

	    notificarObservadores(cliente);
	    return ResponseEntity.ok(cliente);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		clienteService.atualizar(id, cliente);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		clienteService.deletar(id);
		return ResponseEntity.ok().build();
	}
	
	public void adicionarObservador(ClienteObserver observador) {
        observadores.add(observador);
    }

    public void removerObservador(ClienteObserver observador) {
        observadores.remove(observador);
    }

    private void notificarObservadores(Cliente cliente) {
        for (ClienteObserver observador : observadores) {
            observador.atualizar(cliente);
        }
    }
}
