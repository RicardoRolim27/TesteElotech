package elotech.teste.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import elotech.teste.entities.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
	
	
	@Query("SELECT DISTINCT obj FROM PessoaFisica JOIN FETCH obj.contatos "
			+ " WHERE obj.id > 0 ORDER BY obj.name ASC")
	List<PessoaFisica> FindPessoaWithContatos();

}
