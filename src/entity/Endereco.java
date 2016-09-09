package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEndereco;
	
	@Column(length=40)
	private String rua;
	
	@Column(length=40)
	private String bairro;
	
	@OneToOne(mappedBy="endereco", cascade={CascadeType.ALL})
	private Cliente  cliente;
	

  public Endereco() {
		
	}


public Endereco(Integer idEndereco, String rua, String bairro, Cliente cliente) {
	super();
	this.idEndereco = idEndereco;
	this.rua = rua;
	this.bairro = bairro;
	this.cliente = cliente;
}


public Endereco(Integer idEndereco, String rua, String bairro) {
	super();
	this.idEndereco = idEndereco;
	this.rua = rua;
	this.bairro = bairro;
}


@Override
public String toString() {
	return "Endereco [idEndereco=" + idEndereco + ", rua=" + rua + ", bairro="
			+ bairro + "]";
}


public Integer getIdEndereco() {
	return idEndereco;
}


public void setIdEndereco(Integer idEndereco) {
	this.idEndereco = idEndereco;
}


public String getRua() {
	return rua;
}


public void setRua(String rua) {
	this.rua = rua;
}


public String getBairro() {
	return bairro;
}


public void setBairro(String bairro) {
	this.bairro = bairro;
}


public Cliente getCliente() {
	return cliente;
}


public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}
 
  


}
