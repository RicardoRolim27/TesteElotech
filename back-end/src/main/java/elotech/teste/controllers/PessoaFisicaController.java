package elotech.teste.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import elotech.teste.dto.PessoaFisicaDTO;
import elotech.teste.services.PessoaFisicaService;

@RestController
@RequestMapping(value = "/cadastro")
public class PessoaFisicaController {

	@Autowired
	private PessoaFisicaService service;

	@GetMapping("/contatos")
	public ResponseEntity<List<PessoaFisicaDTO>> findAllContatos() {
		List<PessoaFisicaDTO> list = service.findAllPessoaWithContatos();

		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<PessoaFisicaDTO>> findAll() {
		List<PessoaFisicaDTO> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	

	@PostMapping
	public ResponseEntity<PessoaFisicaDTO> insert(@RequestBody PessoaFisicaDTO dto) {
		dto = service.insert(dto);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PessoaFisicaDTO> updateRegister(@PathVariable Long id, 
			@RequestBody PessoaFisicaDTO dto) {
		

		return new ResponseEntity<>(service.updateRegister(id, dto), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Long> deleteRegister(@PathVariable Long id) {

		service.delete(id);

		return new ResponseEntity<>(id, HttpStatus.OK);

	}

}
