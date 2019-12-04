package br.unifacisa.reposicao.sabado.lsi.AulaSabado;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "conta", path = "conta")
public interface ContaRepository extends PagingAndSortingRepository<Conta, Integer>{

	List<Conta> findByTitular(String titular);
	
	@Query("SELECT c FROM Conta c WHERE c.titular = ?1")
	List<Conta> findByAgenciaAndTitularJPQL(int agencia, String titular);

	@Query(value = "SELECT C.* FROM BB_CONTA C WHERE C.AG = ?1 AND C.TIT = ?2", nativeQuery = true)
	List<Conta> findByAgenciaAndTitularQueryNative(int agencia, String titular);
	
	List<Conta> findByAgenciaAndTitular(int agencia, String titular);

	//?* Espera o parâmetro
	@Query("SELECT c FROM Conta c WHERE c.titular = ?1")
	List<Conta> findSaldoByTitular(String titular);

	@Query(value = "select C.SLD from BB_CONTA C where C.TIT = ?1", nativeQuery = true)
	List<Conta> findSaldoByTitularQueryNative(String titular);
}
