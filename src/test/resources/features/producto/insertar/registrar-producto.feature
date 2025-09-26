Feature: Gestión Producto

	Scenario Outline: Registrar Producto
		Given cargo la página visor web
		And inicio sesión con el usuario <usuario> y clave <clave>
		When cargo la página registrar producto
		And registro el producto <nombreproducto> con la categoria <categoria> y con precio <precio>
		Then el aplicativo muestra el mensaje <mensajeEsperado>
		
		
	Examples:
		| usuario | clave | nombreproducto | categoria | precio | mensajeEsperado |
		|"admin"|"clave"| "inka" | "gaseosas" | "2.2"|"Se guardó de manera correcta el Producto"|
		|"admin"|"clave"| "" | "chocolates" | "2.5"|"Nombre: Error de validación: se necesita un valor."|
		|"admin"|"clave"| "rellenitas" | "galletas" | "1.5"|"Se guardó de manera correcta el Producto"|
