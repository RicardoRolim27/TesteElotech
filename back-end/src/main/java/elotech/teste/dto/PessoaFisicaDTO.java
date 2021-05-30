package elotech.teste.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import elotech.teste.entities.PessoaFisica;

public class PessoaFisicaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String cpf;
	private Calendar dataNascimento;
	
	private List<ContatoDTO> contatos = new ArrayList<>();
	
	public PessoaFisicaDTO() {}

	public PessoaFisicaDTO(Long id, String name, String cpf, Calendar dataNascimento) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public PessoaFisicaDTO(PessoaFisica entity) {
		super();
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		dataNascimento = entity.getDataNascimento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<ContatoDTO> getContatos() {
		return contatos;
	}

	public void setContatos(List<ContatoDTO> contatos) {
		this.contatos = contatos;
	}
	
	
	
	

}
