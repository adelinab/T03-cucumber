Feature: Gestión Producto

	Scenario Outline: Validar filtrado de productos exitoso 
		Given cargo la página visor web
		And inicio sesión con el usuario <usuario> y clave <clave>
		When navego a la página de mantenimiento de producto
		And ingreso el nombre de producto <nombreproducto> en el filtro de búsqueda
  		And hago click en el botón filtrar
	    Then valido que la tabla de resultados devuelva mínimo un registro

	Examples:
		| usuario | clave | nombreproducto |
		|"admin"|"clave"| "sublime" |
		
		
	Scenario Outline: Mostrar mensaje cuando no se encontraron registros que coincidan con la búsqueda 
    	Given cargo la página visor web
		And inicio sesión con el usuario <usuario> y clave <clave>
		When navego a la página de mantenimiento de producto
		And ingreso el nombre de producto <nombreproducto> en el filtro de búsqueda
  		And hago click en el botón filtrar
	    Then el aplicativo muestra el mensaje <mensajeEsperado>
    
    Examples:
		| usuario | clave | nombreproducto | mensajeEsperado |
		|"admin"|"clave"| "nohay" |  "No existe registros para la consulta"|