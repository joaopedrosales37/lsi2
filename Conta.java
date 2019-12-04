package br.unifacisa.reposicao.sabado.lsi.AulaSabado;

import javax.persistence.Column;
//importar persistence no lugar do hibernate
//importado para usar o genérico
//melhor uso para futuras mudanças
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BB_CONTA")
@NoArgsConstructor
@Getter
@Setter
public class Conta {

	@Column(name = "AG", nullable = false)
	private int agencia;
	
	@Id 
	@GeneratedValue
	@Column(name = "NM_CONTA", nullable = false)
	private int numeroConta;
	
	@Column(name = "TIT", length = 100, nullable = false)
	private String titular;
	
	@Column(name = "SLD", scale = 2)
	private double saldo;
	
	@Column(name = "TP_CONTA")
	private TipoContaEnum tipoConta;
	
}