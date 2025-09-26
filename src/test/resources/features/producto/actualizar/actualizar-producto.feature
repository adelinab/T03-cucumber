Feature: Gestión Producto

	Scenario Outline: Actualización exitosa de un producto existente 
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
		|"admin"|"clave"| "inka" | "gaseosas" | "2.2"|"Se actualizó de manera correcta el Producto"|
		|"admin"|"clave"| "" | "chocolates" | "2.5"|"Nombre: Error de validación: se necesita un valor."|
		