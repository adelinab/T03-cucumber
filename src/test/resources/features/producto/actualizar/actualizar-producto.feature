Feature: Gestión Producto

	Scenario Outline: Validar actualización de producto con datos válidos e inválidos 
		Given cargo la página visor web
		And inicio sesión con el usuario <usuario> y clave <clave>
		When navego a la página de mantenimiento de producto
  		And hago click en el botón filtrar
	    And selecciono el producto que quiero editar de la tabla de resultados
	    And hago click en el botón editar
	    And ingreso el nombre <nombreproducto>
	    And selecciono la categoría <categoria>
	    And ingreso el precio <precio>
	    And hago click en el botón guardar
	    Then el aplicativo muestra el mensaje <mensajeEsperado>

	Examples:
		| usuario | clave | nombreproducto | categoria | precio | mensajeEsperado |
		|"admin"|"clave"| "" | "chocolates" | "2.5"|"Nombre: Error de validación: se necesita un valor."|
		
		
	Scenario Outline: Mostrar mensaje de error al hacer click en editar sin seleccionar un producto
    Given cargo la página visor web
    And inicio sesión con el usuario <usuario> y clave <clave>
    When navego a la página de mantenimiento de producto
    And hago click en el botón filtrar
    And hago click en el botón editar
    Then el aplicativo muestra el mensaje de error <mensajeEsperado>
    
    Examples:
		| usuario | clave | mensajeEsperado |
		|"admin"|"clave"| "No ha seleccionado un Producto"|