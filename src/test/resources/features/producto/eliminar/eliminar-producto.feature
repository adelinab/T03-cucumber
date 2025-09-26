Feature: Gestión Producto

	Scenario Outline: Validar eliminación exitosa de un producto 
		Given cargo la página visor web
		And inicio sesión con el usuario <usuario> y clave <clave>
		When navego a la página de mantenimiento de producto
  		And hago click en el botón filtrar
	    And selecciono el producto que quiero editar de la tabla de resultados
	    And hago click en el botón eliminar
	    And hago click en el botón sí
	    Then el aplicativo muestra el mensaje <mensajeEsperado>

	Examples:
		| usuario | clave | mensajeEsperado |
		|"admin"|"clave"| "Se eliminó de manera correcta el Producto"|
		
		
	Scenario Outline: Mostrar mensaje de error al hacer click en eliminar sin seleccionar un producto
   		Given cargo la página visor web
		And inicio sesión con el usuario <usuario> y clave <clave>
		When navego a la página de mantenimiento de producto
  		And hago click en el botón filtrar
	    And hago click en el botón eliminar
	    And hago click en el botón sí
	    Then el aplicativo muestra el mensaje <mensajeEsperado>
    
    Examples:
		| usuario | clave | mensajeEsperado |
		|"admin"|"clave"| "No ha seleccionado un Producto"|