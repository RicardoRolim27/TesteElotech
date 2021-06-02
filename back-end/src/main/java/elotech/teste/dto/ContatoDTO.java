package elotech.teste.dto;

import java.io.Serializable;

import elotech.teste.entities.Contato;

public class ContatoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String phone;
	private String email;
	
	public ContatoDTO() {}

	public ContatoDTO(Long id, String name, String phone, 
			String email) {
		super();
		this.id 	= id;
		this.name 	= name;
		this.phone 	= phone;
		this.email 	= email;
	}

	public ContatoDTO(Contato entity) {
		super();
		id 		 = entity.getId();
		name 	 = entity.getName();
		phone 	 = entity.getPhone();
		email    = entity.getEmail();
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
