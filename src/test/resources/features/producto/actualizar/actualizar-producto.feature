Feature: Gestión Producto

	Scenario Outline: Actualizar Producto
		Given cargo la página visor web
		And inicio sesión con el usuario <usuario> y clave <clave>
		When cargo la página registrar produto
		And hago click en el botón filtrar
		And selecciono una fila de la tabla de resultados
		Then hago click en el botón editar y la página de actualizar producto se abre
		And registro el producto con el nombre <nombreproducto> y selecciono la categoria <categoria> e ingreso el precio <precio>
		Then el aplicativo muestra el mensaje <mensajeEsperado>
		
		
	Examples:
		| usuario | clave | nombreproducto | categoria | mensajeEsperado |
		|"admin"|"clave"| "glacitas" | "CELULAR"|"Se guardó de manera correcta la Categoría"|
		|"admin"|"clave"| "dyfferent" | ""|"Nombre: Validation Error: Value is required."|
		|"admin"|"clave"| "snack" | "TABLET"|"Se guardó de manera correcta la Categoría"|