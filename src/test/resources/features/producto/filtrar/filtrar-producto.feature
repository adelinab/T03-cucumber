Feature: Gestión Producto

	Scenario Outline: Registrar Producto
		Given cargo la página visor web
		And inicio sesión con el usuario <usuario> y clave <clave>
		When navego a la página de mantenimiento de producto
  		And ingreso el nombre de producto <nombreproducto> a buscar 
	    And hago click en el botón filtrar
	    Then el aplicativo muestra el mensaje <mensajeEsperado>
		
		
	Examples:
		| usuario | clave | nombreproducto | mensajeEsperado |
		|"admin"|"clave"| "inka" | "No existe registros para la consulta"|
		|"admin"|"clave"| "no" | ""|