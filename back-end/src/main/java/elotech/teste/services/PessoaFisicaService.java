package elotech.teste.services;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import elotech.teste.dto.ContatoDTO;
import elotech.teste.dto.PessoaFisicaDTO;
import elotech.teste.entities.Contato;
import elotech.teste.entities.PessoaFisica;
import elotech.teste.repositories.ContatoRepository;
import elotech.teste.repositories.PessoaFisicaRepository;

@Service
public class PessoaFisicaService {
	
	@Autowired
	private PessoaFisicaRepository pessoaRepository;
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Transactional(readOnly = true)
	public List<PessoaFisicaDTO> findAllPessoaWithContatos(){
		
		List<PessoaFisica> list = pessoaRepository.FindPessoaWithContatos();
		
		return list.stream().map(x -> new PessoaFisicaDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<PessoaFisicaDTO> findAll(){
		
		List<PessoaFisica> list = pessoaRepository.findAll();
		
		return list.stream().map(x -> new PessoaFisicaDTO(x)).collect(Collectors.toList());
	}
	
	
	@Transactional
	public PessoaFisicaDTO insert(PessoaFisicaDTO dto) {
		
		PessoaFisica pessoa = new PessoaFisica(null, dto.getName(), dto.getCpf(), dto.getDataNascimento());
		
		for(ContatoDTO p: dto.getContatos()) {
			Contato contato = contatoRepository.getById(p.getId());
			pessoa.getContatos().add(contato);
		}
		
		pessoa = pessoaRepository.save(pessoa);
		
		
		return new PessoaFisicaDTO(pessoa);
	}
	
	@Transactional
	public PessoaFisicaDTO update(Long id, String name, String cpf, Calendar dataNascimento) {
		PessoaFisica pessoa = pessoaRepository.getById(id);
		pessoa.setName(name);
		pessoa.setCpf(cpf);
		pessoa.setDataNascimento(dataNascimento);
		pessoa = pessoaRepository.save(pessoa);
		
		return new PessoaFisicaDTO(pessoa);
	}
	
	public PessoaFisicaDTO updateRegister(Long id, PessoaFisicaDTO dto) {

        if (pessoaRepository.findById(id).isPresent()){
            PessoaFisica existingPessoa = pessoaRepository.findById(id).get();

            existingPessoa.setName(dto.getName());
            existingPessoa.setCpf(dto.getCpf());
            existingPessoa.setDataNascimento(dto.getDataNascimento());

            PessoaFisica updatedPessoa = pessoaRepository.save(existingPessoa);

            return new PessoaFisicaDTO(updatedPessoa.getId(), updatedPessoa.getName(),
                    updatedPessoa.getCpf(), updatedPessoa.getDataNascimento());
        }else{
            return null;
        }
    }
	
	@Transactional
	public void delete(Long id) {
		pessoaRepository.deleteById(id);
		
		
	}
	
	

}
