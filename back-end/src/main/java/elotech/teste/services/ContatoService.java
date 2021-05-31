package elotech.teste.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import elotech.teste.dto.ContatoDTO;
import elotech.teste.entities.Contato;
import elotech.teste.entities.PessoaFisica;
import elotech.teste.repositories.ContatoRepository;
import elotech.teste.repositories.PessoaFisicaRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repository;
	
	private PessoaFisicaRepository pessoaRepo;
	
	@Transactional(readOnly = true)
	public List<ContatoDTO> findAll(){
		List<Contato> list = repository.findAllByOrderByNameAsc();
		
		return list.stream().map(x -> new ContatoDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public ContatoDTO insert(ContatoDTO dto, Long id) {
		
		Optional<PessoaFisica> pessoa = pessoaRepo.findById(id);
		
		if(pessoa.isPresent()) {
			System.out.println(pessoa);
		}
		
		Contato contato = new Contato(null, dto.getName(), dto.getPhone(), 
				dto.getEmail(), dto.getPessoaId());
		
		contato = repository.save(contato);
		
		/*pessoa.getContatos().add(contato);
		
		pessoa = pessoaRepo.save(pessoa);*/
		
		return new ContatoDTO(contato);
	}

}
