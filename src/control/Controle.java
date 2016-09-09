package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import persistence.ClienteDao;
import entity.Cliente;
import entity.Endereco;


@WebServlet("/Controle")
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ClienteDao  dao;
	Cliente     cliente;
	Endereco    endereco;
	
   
    public Controle() {
      ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
      cliente = (Cliente) context.getBean("cliente_spr");
      endereco = (Endereco) context.getBean("endereco_spr");
      dao = (ClienteDao)  context.getBean("clienteDao_spr");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String cmd = request.getParameter("cmd");
	     if(cmd.equalsIgnoreCase("deletar")){
	    	 deletar(request,response);
	     }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String cmd = request.getParameter("cmd");
	     if(cmd.equalsIgnoreCase("gravar")){
	    	 gravar(request,response);
	     }
		
	}

	
	
	protected void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		try {

//         FORMA 1			
//		 Cliente c = new Cliente(null, request.getParameter("nome"), request.getParameter("sexo"));
//		 Endereco e = new Endereco(null, request.getParameter("rua"), request.getParameter("bairro"));
//         dao.createCliEnd(c, e);
//        
        
		//FORMA 2	
		 cliente.setIdCliente(null);
         cliente.setNome(request.getParameter("nome"));
         cliente.setSexo(request.getParameter("sexo"));
         
         endereco.setRua(request.getParameter("rua"));
         endereco.setBairro(request.getParameter("bairro"));
         
         dao.createCliEnd(cliente, endereco);
         
         
         request.setAttribute("msg", "Dados Gravados");		 
		} catch (Exception e) {
			request.setAttribute("msg", "Error" + e.getMessage());	
		}finally{
			request.getRequestDispatcher("sistema.jsp").forward(request, response);
			
		}
	}
	
	
	protected void deletar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
         
			Integer cod = new Integer(request.getParameter("cod"));
			cliente.setIdCliente(cod);	
		    dao.remover(cliente);
         
         request.setAttribute("msg", "Dados Excluidos");		 
		} catch (Exception e) {
			request.setAttribute("msg", "Error" + e.getMessage());	
		}finally{
			request.getRequestDispatcher("consulta.jsp").forward(request, response);
		}
	}
	
	
	
	
	
}
