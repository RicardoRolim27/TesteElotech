package elotech.teste.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import elotech.teste.dto.ContatoDTO;
import elotech.teste.services.ContatoService;

@RestController
@RequestMapping(value="/contatos")
public class ContatoController {
	
	@Autowired
	private ContatoService service;
	
	@GetMapping
	public ResponseEntity<List<ContatoDTO>> findAll(){
		List<ContatoDTO> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping("/insert/{pessoaId}")
	public ResponseEntity<ContatoDTO> insert(@RequestBody ContatoDTO dto, @PathVariable Long pessoaID) {
		dto = service.insert(dto, pessoaID);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId(), pessoaID).toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}

}
