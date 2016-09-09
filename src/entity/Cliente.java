package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente implements Comparable<Cliente> {

	private static final String criterio="nome"; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer  idCliente;
	
	@Column(length=40)
	private String   nome;
	
	@Column(columnDefinition="enum('m','f')")
	private String  sexo;
	
	@OneToOne(fetch=FetchType.EAGER, cascade={CascadeType.ALL})
	@JoinColumn(name="ID_Endereco")
	private Endereco endereco;
	
	public Cliente() {
		
	}

	public Cliente(Integer idCliente, String nome, String sexo,
			Endereco endereco) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.sexo = sexo;
		this.endereco = endereco;
	}

	public Cliente(Integer idCliente, String nome, String sexo) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", sexo="
				+ sexo + ", endereco=" + endereco + "]";
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int compareTo(Cliente c) {
		return this.nome.compareTo(c.getNome()) ;
	}

	
	
	@Override
	public int hashCode() {
		if(criterio.equalsIgnoreCase("id")){
			return this.idCliente.hashCode();
		}else if(criterio.equalsIgnoreCase("nome")){
			return this.nome.hashCode();
		}else{
			return 0;	
		}
			
	}

	@Override
	public boolean equals(Object obj) {
		Cliente c = (Cliente) obj;
		if(criterio.equalsIgnoreCase("id")){
			return this.idCliente.equals(c.getIdCliente());
		}
		if(criterio.equalsIgnoreCase("nome")){
			return this.nome.equals(c.getNome());
		}		
		return false;
	}

	
	
	
	
	
	
	
	public static void main(String[] args) {
		try {
			Cliente c = new Cliente(1, "amanda", "m");
			Cliente c2 = new Cliente(2, "leo", "m");
		
		 System.out.println(c2.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
