<!DOCTYPE html>
<html>

<head>
	<link href="BootStrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="BootStrap/js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="BootStrap/js/bootstrap.js"></script>
</head>	

<jsp:useBean id="mb" class="manager.ManagerBean"/>
<%@page import="java.util.*, entity.*, persistence.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
      
     
     <div class="container">
      <h1 class="well well-lg" align="center">Cadastrar Cliente</h1>
       <a href="consulta.jsp" class="btn btn-warning"><span class="glyphicon glyphicon-search">Consultar</span></a>     
     </div>
    
    
    <div class="container">
     <div class="row">
      <div class="col-sm-8 col-sm-offset-2">
       <div class="panel panel-primary">
        
        <div class="panel-heading">
         <div class="panel-title" align="center">Formulario de Cadastro</div>        
        </div>
        
        <div class="panel-body">
         <form method="post" action="Controle?cmd=gravar">
         
          <div class="form-group">
           <label>Nome</label>
           <input type="text" name="nome" placeholder="Informe o nome" class="form-control">
          </div>
         
         <div class="form-group">
         <label>Sexo</label>
         <select name="sexo" class="form-control">
           <option label="Selecione" value="">
           <option label="Masculino" value="m">
           <option label="Feminino" value="f">  
          </select>
         </div>
         
         <div class="form-group">
           <label>Rua</label>
           <input type="text" name="rua" placeholder="Informe a rua" class="form-control">
          </div>
          
          <div class="form-group">
           <label>Bairro</label>
           <input type="text" name="bairro" placeholder="Informe o bairro" class="form-control">
          </div>
         
         <button type="submit" class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-floppy-disk">Gravar</span></button>
         
         <br/><br/>
         <strong>${msg}</strong>
         </form>       
        </div>       
       </div><!-- panel primary -->
    
    
    
    </div><!-- col -->
   </div><!-- row --> 
  </div><!-- container -->










</body>
</html>