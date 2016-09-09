package persistence;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import entity.Cliente;
import entity.Endereco;

public class ClienteDao implements IClienteDao<Cliente> {

	private HibernateTemplate hiber;
	
	
	
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
	  hiber = new HibernateTemplate(sessionFactory);	
		
	}

	@Override
	public void create(Cliente c) {
		hiber.save(c);		
	}

	
	public void createCliEnd(Cliente c, Endereco e) {
		hiber.save(e);
		c.setEndereco(e);
		hiber.save(c);
	}
	
	
	@Override
	public List<Cliente> findAll() {
		return hiber.find("from Cliente");
		
	}

	

	@Override
	public void remover(Cliente c) {
		hiber.delete(c);
		
	}

	@Override
	public Cliente findByCod(Integer cod) {
		return hiber.get(Cliente.class, cod);
	}

	
}
