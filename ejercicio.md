# Ejercicio sobre Spring Data JDBC

## Enunciado
Para la BBDD `Jardineria`, completar el proyecto en curso con estas funcionalidades:
* CRUD de clientes
* CRUD de pedidos (y sus líneas)
* CRUD de gamas de producto.

Se utilizará 
* Spring Data JDBC.
* Bootstrap 5.3.
* Thymeleaf
* PostgreSql

Teniendo en cuenta que:
1. Se utilizará **_borrado lógico_**
2. En los listados de cualquier tipo, no se incluirán los registros marcados como borrados.
3. Un cliente no se puede borrar si tiene pedidos.
4. Un pedido no se puede borrar si tiene productos vendidos.
5. Si se borra una gama, se debe borrar de todos los productos que la referencien.
6. El formulario de cliente (alta o modificación) presentará una lista con nombre y apellidos de los posibles 
representantes de ventas para poder seleccionar uno.
7. Un cliente puede haber realizado varios pedidos, pero un pedido sólo puede haber sido hecho por un cliente.
8. Un pedido puede incluir varios productos.
9. Cada producto vendido corresponderá a una línea del pedido. Es decir, no se repetiran líneas de pedido con el mismo 
producto.
10. NO ES NECESARIO CONTEMPLAR EL PROVEEDOR del producto (ignorar ese dato)
11. El pedido en pantalla debe presentar el total del importe desglosado; es decir, Base imponible, importe del IVA y 
total (suma de ambos);
12. El IVA se supone fijo al 21%.

## Hitos (entregables)
1. Listado de clientes.
2. Listado de gamas.
3. Listado de pedidos (sin las líneas) incluyendo la base imponible del pedido, la cantidad de IVA y el total.
4. Formulario de gamas (alta y modificación)
5. Borrado de gamas con confirmación del borrado por parte del usuario.
6. Formulario de clientes (alta y modificación)
7. Borrado de clientes (con confirmación).
8. Formulario de pedidos incluyendo las líneas. Cada una permitirá (mediante iconos de acción) editar sus datos o 
ser borrada.
9. Borrado de pedidos.

## Recursos
Para añadir nuevas filas a una tabla HTML de forma dinámica utilizando JavaScript, puedes manipular el 
Documento Object Model (DOM). Hay varias formas de hacer esto, pero aquí proponemos esta (se puede utilizar 
cualquiera otra).

Pasos a seguir:
1. Obtener la referencia de la tabla: Primero, necesitas una referencia al elemento `<table>` en tu HTML, usualmente 
obtenida a través de su id.
2. Insertar una nueva fila (`<tr>`): Utiliza el método `insertRow()` del elemento de la tabla. Este método crea y 
devuelve una referencia a la nueva fila (`HTMLTableRowElement`). Puedes pasarle un índice para indicar la posición; si usas -1 o el número total de filas, se añadirá al final.
3. Insertar celdas (<td>) en la fila: Sobre el objeto de la fila devuelto, llama al método `insertCell()` por cada celda 
que necesites crear. Este método devuelve una referencia a la nueva celda.
4. Añadir contenido a las celdas: Una vez creada la celda, puedes asignarle contenido utilizando la propiedad 
`textContent` o `innerHTML`, o creando y añadiendo un nodo de texto con `createTextNode()` y `appendChild()`.

Ejemplo de código

    <table border="1" id="miTabla">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Apellido</th>
            </tr>
        </thead>
        <tbody>
            <!-- Las nuevas filas se añadirán aquí -->
        </tbody>
    </table>
    
    <button onclick="agregarFila()">Agregar Fila</button>
    
    <script>
    function agregarFila() {
        // 1. Obtener la referencia de la tabla
        const tabla = document.getElementById("miTabla").getElementsByTagName('tbody')[0];
    
        // 2. Insertar una fila al final de la tabla
        const nuevaFila = tabla.insertRow(-1); // O tabla.insertRow(tabla.rows.length)
    
        // 3. Insertar celdas en la nueva fila
        const celda1 = nuevaFila.insertCell(0);
        const celda2 = nuevaFila.insertCell(1);
    
        // 4. Añadir contenido a las celdas
        celda1.textContent = 'Nuevo Nombre';
        celda2.textContent = 'Nuevo Apellido';
    }
    </script>

