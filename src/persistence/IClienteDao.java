package persistence;

import java.util.List;

import org.hibernate.SessionFactory;

public interface IClienteDao<Classe> {

	public void setSessionFactory(SessionFactory sessionFactory);
	public void create(Classe c);
	public void remover(Classe c);
	public List<Classe> findAll();
	public Classe findByCod(Integer cod);
	
}
