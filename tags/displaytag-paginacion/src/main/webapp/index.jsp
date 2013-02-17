<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:url value="/catalogos/producto/ejemplo1" var="urlEjemplo1" />
<c:url value="/catalogos/producto/ejemplo2" var="urlEjemplo2" />
<c:url value="/catalogos/producto/ordenacion" var="urlEjemplo3" />
<c:url value="/catalogos/producto/paginacion" var="urlEjemplo4" /> 

<html>
	<head>
		<title></title>
	</head>
	<body id="page-home"> 
	
		<div id="page">					
	        <div id="content">
				<a id="urlEjemplo1" href="${urlEjemplo1}">Ejemplo1</a>
				<a id="urlEjemplo2" href="${urlEjemplo2}">Ejemplo2</a>
				<a id="urlEjemplo3" href="${urlEjemplo3}">Ordenación</a>
				<a id="urlEjemplo4" href="${urlEjemplo4}">Paginación</a> 
			</div>			
		</div>
	</body>
</html>

