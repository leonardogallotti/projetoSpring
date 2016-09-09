package manager;

import java.util.Collections;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import persistence.ClienteDao;
import entity.Cliente;

public class ManagerBean {

	private List<Cliente>  lista;
	private ClienteDao     dao;
	
	
	public ManagerBean() {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		dao = (ClienteDao) context.getBean("clienteDao_spr");
	}


	public List<Cliente> getLista() {
		lista = dao.findAll();
		Collections.sort(lista);
		return lista;
	}


	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}
	
	
	
	
	
}
