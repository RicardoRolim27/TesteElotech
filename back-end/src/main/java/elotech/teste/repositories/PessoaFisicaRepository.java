package elotech.teste.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import elotech.teste.entities.PessoaFisica;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
	
	
	@Query("SELECT DISTINCT obj FROM PessoaFisica obj JOIN FETCH obj.contatos "
			+ " WHERE obj.id > 0 ORDER BY obj.name ASC")
	List<PessoaFisica> FindPessoaWithContatos();
	
	@Query(value = "SELECT * FROM PESSOA_FISICA ORDER BY PESSOA_FISICA.name ASC",
			nativeQuery = true)
	List<PessoaFisica> findAll();
	
	@Query(value = "SELECT * FROM PESSOA_FISICA WHERE PESSOA_FISICA.id = :pessoaId",
			nativeQuery = true)
	List<PessoaFisica> BuscaPorId(@Param("pessoaId") Long pessoaId);
	
	@Query(value = "SELECT * FROM PESSOA_FISICA WHERE PESSOA_FISICA.id = :pessoaId",
			nativeQuery = true)
	PessoaFisica PegaPorId(@Param("pessoaId") Long pessoaId);
		

}
