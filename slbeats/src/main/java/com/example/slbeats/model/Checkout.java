package com.example.slbeats.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Checkout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome_completo", nullable = false)
	private String nomeCompleto;
	
	@Column(name = "email", nullable = true)
	private String email;
	
	@Column(name = "cidade", nullable = false)
	private String cidade;
	
	@Column(name = "endereco", nullable = false)
	private String endereco;
	
	@Column(name = "estado", nullable = true)
	private String estado;
	
	@Column(name = "cep", nullable = true)
	private String cep;
	
	@Column(name = "nome_cartao", nullable = true)
	private String nomeCartao;
	
	@Column(name = "numero_cartao", nullable = true)
	private String numeroCartao;
	
	@Column(name = "mes_vencimento", nullable = true)
	private String mesVencimento;
	
	@Column(name = "ano_vencimento", nullable = true)
	private String anoVencimento;
	
	@Column(name = "cvv", nullable = true)
	private String cvv;
	

}
