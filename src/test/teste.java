package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import persistence.ClienteDao;
import entity.Cliente;
import entity.Endereco;

public class teste {
	
	
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
	    Cliente	cliente = (Cliente) context.getBean("cliente_spr");
	    Endereco     endereco = (Endereco) context.getBean("endereco_spr");
		ClienteDao   dao       = (ClienteDao)  context.getBean("clienteDao_spr");
		try {
			
//			cliente.setIdCliente(null);
//			cliente.setNome("Teste1");
//			cliente.setSexo("m");
//			endereco.setRua("Vera");
//			endereco.setBairro("cordovil");
//			dao.createCliEnd(cliente, endereco);
			
			System.out.println(dao.findByCod(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
