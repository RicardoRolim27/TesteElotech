package elotech.teste.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import elotech.teste.dto.ContatoDTO;
import elotech.teste.entities.Contato;
import elotech.teste.repositories.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repository;
	
	@Transactional(readOnly = true)
	public List<ContatoDTO> findAll(){
		List<Contato> list = repository.findAllByOrderByNameAsc();
		
		return list.stream().map(x -> new ContatoDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public ContatoDTO insert(ContatoDTO dto) {
		Contato contato = new Contato(null, dto.getName(), dto.getPhone(), dto.getEmail());
		
		contato = repository.save(contato);
		
		return new ContatoDTO(contato);
	}

}
