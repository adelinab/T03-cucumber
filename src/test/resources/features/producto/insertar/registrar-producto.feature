Feature: Gestión Producto

	Scenario Outline: Registrar Producto
		Given cargo la página visor web
		And inicio sesión con el usuario <usuario> y clave <clave>
		When cargo la página registrar produto
		And registro el producto <nombreproducto> con la categoria <categoria> y con precio <precio>
		Then el aplicativo muestra el mensaje <mensajeEsperado>
		
		
	Examples:
		| usuario | clave | nombreproducto | categoria | precio | mensajeEsperado |
		|"admin"|"clave"| "glacitas" | "chocolates" | "3"|"Se guardó de manera correcta la Categoría"|
		|"admin"|"clave"| "dyfferent" | "galletas" | "2"|"Nombre: Validation Error: Value is required."|
		|"admin"|"clave"| "snack" | "gelatina" | "1"|"Se guardó de manera correcta la Categoría"|