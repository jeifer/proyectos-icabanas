<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!--c:redirect url="/catalogos/producto/alta" -->
<c:url value="/catalogos/producto/ejemplo1" var="urlEjemplo1" />

<html>
	<head>
		<title></title>
	</head>
	<body id="page-home"> 
	
		<div id="page">					
	        <div id="content">
				<a id="urlEjemplo1" href="${urlEjemplo1}">Ejemplo1</a>
			</div>			
		</div>
	</body>
</html>

