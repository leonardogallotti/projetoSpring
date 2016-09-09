<!DOCTYPE html>
<html>

<head>
	<link href="BootStrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="BootStrap/js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="BootStrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="BootStrap/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="BootStrap/js/dataTables.bootstrap.js"></script>
</head>
<jsp:useBean id="mb" class="manager.ManagerBean"/>
<%@page import="java.util.*, entity.*, persistence.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
        
    <div class="container">
      <h1 class="well well-lg" align="center">Consultar Cliente</h1>
       <a href="sistema.jsp" class="btn btn-primary"><span class="glyphicon glyphicon-home">HOME</span></a>     
     </div>
    
    
    <div class="container">
    <div class="row">
     <div class="col-sm-8 col-sm-offset-2">
      <div class="panel panel-primary">
       
       <div class="panel-heading">
        <div class="panel-title">Clientes Cadastrados</div>
       </div>
        
      
      <table class="table table-hover"> 
      
       <thead>
        <tr>         
         <th>Nome</th>
         <th>Sexo</th>
         <th>Rua</th>
         <th>Bairro</th>        
        </tr> 
       </thead>
      
       
       <tbody>        
        <c:forEach items="${mb.lista}" var="linha">
         <tr>
           <td class="hidden">${linha.idCliente}</td>
           <td>${linha.nome}</td> 
           <td>${linha.sexo}</td>
           <td>${linha.endereco.rua}</td>
           <td>${linha.endereco.bairro}</td> 
           <td><a class="btn btn-danger" href="Controle?cmd=deletar&cod=${linha.idCliente}"><span class="glyphicon glyphicon-trash"></span>-Remover</a></td>       
         </tr>
         </c:forEach>
       </tbody>
    
      
      </table>
      
      
      </div>
       
     
     
     </div>
    
    </div>
    
    
    
    
    </div><!-- container -->










</body>
</html>