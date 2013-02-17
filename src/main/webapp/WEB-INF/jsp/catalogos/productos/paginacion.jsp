<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<html>
	<head> 
		<title>Ejemplo1</title>
		<link rel="stylesheet" type="text/css" href="/displaytag/css/displaytag/displaytag.css" /> 
	</head> 
	
	<body id="page-home"> 
	
		<div id="page">
							
	        <div id="content"> 	    		    		   	
					    		
				<div id="contentForm" class="frame tbar" >								
					
					<display:table name="productos" requestURI="/catalogos/producto/paginacion" pagesize="3"> 
                            <display:caption title="Listado de productos" />                                                 
                            <display:column property="nombre" title="Nombre" /> 
                            <display:column property="descripcion" title="Descripción" /> 
                    </display:table> 
					
				</div>    		
								
			</div>				
			<!-- FIN CONTENT -->
			
		</div>
	</body>
 
</html>
