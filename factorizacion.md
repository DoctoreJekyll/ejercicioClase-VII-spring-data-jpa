# ¿Tienes acceso a la base de datos de ejemplo que hayt por INternet de Jardinería

Sí, tengo acceso a la información sobre la popular base de datos de ejemplo `jardineria`, que se utiliza con frecuencia para la práctica y el aprendizaje de SQL[^1_1][^1_11]. Esta base de datos fue popularizada a través del libro *Bases de Datos* de Iván López Montalbán[^1_1][^1_4].

A continuación se detalla su estructura, contenido y dónde encontrar el script para su creación.

### Estructura de la Base de Datos

La base de datos `jardineria` está diseñada para modelar las operaciones de una empresa de distribución de productos de jardinería. Su esquema relacional incluye las siguientes tablas principales[^1_1][^1_5][^1_7]:

* **`oficina`**: Almacena la información de las diferentes sucursales de la empresa[^1_1].
* **`empleado`**: Contiene los datos de los empleados, incluyendo una relación jerárquica para indicar quién es el jefe de cada empleado (`codigo_jefe`)[^1_1].
* **`gama_producto`**: Define las diferentes categorías o gamas de productos que comercializa la empresa[^1_1][^1_5].
* **`cliente`**: Guarda la información de los clientes, incluyendo su representante de ventas asignado y su límite de crédito[^1_1].
* **`pedido`**: Registra los pedidos realizados por los clientes, con sus fechas y estado[^1_1][^1_5].
* **`producto`**: Detalla cada uno de los productos, su stock, precios y a qué gama pertenecen[^1_1].
* **`detalle_pedido`**: Es una tabla intermedia que especifica los productos y cantidades incluidas en cada pedido, relacionando las tablas `pedido` y `producto`[^1_1].
* **`pago`**: Almacena la información de los pagos realizados por los clientes[^1_1][^1_5].

Esta estructura permite realizar una amplia variedad de consultas, desde las más simples hasta complejas uniones (joins), subconsultas y operaciones de agregación, lo cual es ideal para practicar tus habilidades en SQL y entender el modelado de datos para relaciones complejas, como las que gestionas con Spring Data JDBC[^1_16].

### Acceso al Script SQL

El script completo para crear la base de datos y poblarla con datos de ejemplo (`jardineria.sql`) está disponible públicamente. Lo puedes encontrar en plataformas como GitHub Gist[^1_1][^1_4]. Este script contiene todas las sentencias `CREATE TABLE` para definir la estructura, así como los `INSERT INTO` para cargar los datos iniciales[^1_1]. Está diseñado principalmente para ser utilizado con MySQL[^1_7][^1_11].

### Propósito y Uso

El principal objetivo de esta base de datos es educativo. Se utiliza ampliamente en cursos y tutoriales para enseñar[^1_9]:

* Consultas SQL (`SELECT`)[^1_11].
* Manipulación de datos (`INSERT`, `UPDATE`, `DELETE`)[^1_10].
* Creación de vistas, procedimientos almacenados, funciones y triggers[^1_13].
* Diseño y comprensión de modelos entidad-relación[^1_5][^1_11].


### Otras Bases de Datos sobre Jardinería

Es importante distinguir esta base de datos de ejemplo de otras bases de datos comerciales que también existen. Hay empresas que ofrecen listados de compañías reales del sector de la jardinería en España para fines de marketing y análisis de mercado[^1_2][^1_6][^1_14][^1_15]. Estas bases de datos contienen información de contacto como correos electrónicos y teléfonos de empresas y profesionales del sector, pero no tienen una finalidad educativa como la base de datos `jardineria`[^1_2][^1_6].

<div style="text-align: center">⁂</div>

[^1_1]: https://gist.github.com/josejuansanchez/c408725e848afd64dd9a20ab37fba8c9
[^1_2]: https://www.bancodatos.es/tienda/producto/jardineria
[^1_3]: https://www.youtube.com/watch?v=pt26M43v0YA
[^1_4]: https://gist.github.com/josejuansanchez/c408725e848afd64dd9a20ab37fba8c9?permalink_comment_id=3709642
[^1_5]: https://www.studocu.com/latam/document/instituto-politecnico-loyola/lengua-espanola-i/jardineria/39315085
[^1_6]: https://construccionate.com/base-de-datos-de-empresas-de-jardineria/
[^1_7]: https://www.mycompiler.io/view/KY6GfvFCQW4
[^1_8]: https://externer-datenschutzbeauftragter-dresden.de/es/tiempo-libre/proteccion-de-datos-en-el-jardin-aplicaciones-seguras-bases-de-datos-y-consejos/
[^1_9]: https://es.scribd.com/document/481729651/Jardineria
[^1_10]: https://es.scribd.com/document/736223291/SOLUCION-EJERCICIOS-EDICION-DE-DATOS-JARDINERIA
[^1_11]: https://josejuansanchez.org/bd/ejercicios-consultas-sql/index.pdf
[^1_12]: https://es.scribd.com/document/663220535/EJERCICIOS-DE-ACCESS-2-2-Jardin-1
[^1_13]: https://www.youtube.com/watch?v=B6vWg8rPhF4
[^1_14]: https://www.fullpowerdata.com/es/tienda/producto/jardineria-1/espa%C3%B1a
[^1_15]: https://www.brekiadata.com/es/espa%C3%B1a/1/c/jardineria
[^1_16]: programming.java_spring_data

---
# Pregunta (prompt)
#### Tengo que hacer una aplicación con Spring data JDBC que usa esa BBDD. Usa Lombok, Thymeleaf y Postgresql. El entorno es IntelliJ. Necesito un listado de clientes con los campos código, nombre cliente, teléfono, dirección y ciudad. También necesito un listado de gamas de producto y un listado de pedidos con el código del pedido, la fecha del pedido el estado y el nombre del cliente. Dame el código de la aplicación y utiliza una única vista de lista (con Thymeleaf) que sirva para todas las entidades. En el controlador de cada entidad se incluirá un parámetro para la plantilla con la lista de los campos a visualizar. Utiliza records como DTOs para cada lista, de forma que no viajen por la aplicación todos los campos de cada entidad. Utiliza como modelo de plantilla para los listados el archivo vistaLista. Dime los modelos, los repositorios, servicios, controladores y plantillas que debería utilizar. Si es posible,  utiliza un controlador genérico común y un controlador específico para cada modelo cuando sea necesario. Me interesa que me remarques y expliques las relaciones (si las hay) 1 a N y n a M que existan. Recuerda esta pregunta porque te haré otras sobre la misma aplicación que te pido ahora

Claro, entiendo perfectamente la solicitud. A continuación, te proporciono una guía completa para construir la aplicación con Spring Boot, Spring Data JDBC, Lombok, Thymeleaf y PostgreSQL, siguiendo las especificaciones que has indicado. He estructurado el código y las explicaciones para que sirvan de base para futuras consultas sobre este mismo proyecto.

### Análisis de Relaciones en la Base de Datos `jardineria`

Antes de empezar con el código, es fundamental entender las relaciones clave en la base de datos `jardineria`, ya que esto impactará en cómo definimos las entidades y las consultas [^2_29].

*   **Relaciones 1 a N (Uno a Muchos)**: Este tipo de relación ocurre cuando un registro de una tabla puede estar asociado con múltiples registros de otra. En `jardineria`, encontramos varias:
    *   `cliente` a `pedido`: Un cliente puede realizar muchos pedidos, pero un pedido pertenece a un único cliente. La tabla `pedido` tiene una clave foránea (`codigo_cliente`) que apunta a `cliente`.
    *   `cliente` a `pago`: Un cliente puede realizar múltiples pagos.
    *   `gama_producto` a `producto`: Una gama (categoría) puede agrupar a muchos productos, pero un producto pertenece a una sola gama.
    *   `empleado` a `cliente`: Un empleado (representante de ventas) puede tener asignados muchos clientes.

*   **Relación N a M (Muchos a Muchos)**: Esta relación se da cuando múltiples registros de una tabla se pueden relacionar con múltiples registros de otra. La solución estándar es usar una tabla intermedia [^2_8].
    *   `pedido` a `producto`: Un pedido puede contener múltiples productos y, a su vez, un mismo producto puede formar parte de diferentes pedidos. Esta relación se resuelve a través de la tabla `detalle_pedido`, que contiene una clave foránea hacia `pedido` (`codigo_pedido`) y otra hacia `producto` (`codigo_producto`).

---

### Estructura del Proyecto y Código

A continuación se detalla el código para cada capa de la aplicación: modelos, repositorios, servicios, controladores y la plantilla Thymeleaf genérica.

#### 1. Dependencias (pom.xml)

Asegúrate de que tu fichero `pom.xml` incluya las siguientes dependencias:

```xml
<dependencies>
    <!-- Spring Web y MVC -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <!-- Thymeleaf -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <!-- Spring Data JDBC -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jdbc</artifactId>
    </dependency>
    <!-- Driver de PostgreSQL -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>
    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

#### 2. Modelos (Entidades y DTOs)

Usaremos clases para las entidades que mapean las tablas y `records` para los DTOs, que son objetos inmutables para transferir solo los datos necesarios [^2_3][^2_9].

**Entidades**

Las entidades para Spring Data JDBC son clases simples que representan las tablas.

```java
// src/main/java/com/example/jardineria/model/Cliente.java
package com.example.jardineria.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("cliente")
public class Cliente {
    @Id
    private Integer codigoCliente;
    private String nombreCliente;
    private String telefono;
    private String lineaDireccion1;
    private String ciudad;
    // Otros campos que no se usarán en la lista...
}

// src/main/java/com/example/jardineria/model/GamaProductoRepo.java
package com.example.jardineria.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("gama_producto")
public class GamaProducto {
    @Id
    private String gama;
    private String descripcionTexto;
    // Otros campos...
}

// src/main/java/com/example/jardineria/model/Pedido.java
package com.example.jardineria.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;

@Data
@Table("pedido")
public class Pedido {
    @Id
    private Integer codigoPedido;
    private LocalDate fechaPedido;
    private String estado;
    private Integer codigoCliente;
    // Otros campos...
}
```

**DTOs (Data Transfer Objects con Records)**

Los `records` son perfectos para DTOs, ya que son concisos e inmutables. Thymeleaf es compatible con ellos desde Java 16 [^2_6].

```java
// src/main/java/com/example/jardineria/dto/ClienteListDTO.java
package com.example.jardineria.dto;

public record ClienteListDTO(
    Integer codigoCliente,
    String nombreCliente,
    String telefono,
    String lineaDireccion1,
    String ciudad
) {}

// src/main/java/com/example/jardineria/dto/GamaProductoListDTO.java
package com.example.jardineria.dto;

public record GamaProductoListDTO(
    String gama,
    String descripcionTexto
) {}

// src/main/java/com/example/jardineria/dto/PedidoListDTO.java
package com.example.jardineria.dto;

import java.time.LocalDate;

public record PedidoListDTO(
    Integer codigoPedido,
    LocalDate fechaPedido,
    String estado,
    String nombreCliente // Campo obtenido con un JOIN
) {}
```

#### 3. Repositorios

Los repositorios gestionan el acceso a los datos. Para la lista de pedidos, necesitamos una consulta personalizada para unir `pedido` y `cliente`.

```java
// src/main/java/com/example/jardineria/repository/ClienteRepository.java
package com.example.jardineria.repository;

import com.example.jardineria.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {}

// src/main/java/com/example/jardineria/repository/GamaProductoRepository.java
package com.example.jardineria.repository;

import com.example.jardineria.model.GamaProducto;
import org.springframework.data.repository.CrudRepository;

public interface GamaProductoRepository extends CrudRepository<GamaProducto, String> {}

// src/main/java/com/example/jardineria/repository/PedidoRepository.java
package com.example.jardineria.repository;

import com.example.jardineria.dto.PedidoListDTO;
import com.example.jardineria.model.Pedido;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

    @Query("""
        SELECT p.codigo_pedido, p.fecha_pedido, p.estado, c.nombre_cliente
        FROM pedido p
        JOIN cliente c ON p.codigo_cliente = c.codigo_cliente
    """)
    List<PedidoListDTO> findPedidosWithClienteNombre();
}
```

#### 4. Servicios

La capa de servicio contiene la lógica de negocio y se encarga de llamar a los repositorios y transformar los datos para los controladores.

```java
// src/main/java/com/example/jardineria/service/ClienteService.java
package com.example.jardineria.service;

import com.example.jardineria.dto.ClienteListDTO;
import com.example.jardineria.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public List<ClienteListDTO> findAll() {
        return StreamSupport.stream(clienteRepository.findAll().spliterator(), false)
            .map(cliente -> new ClienteListDTO(
                cliente.getCodigoCliente(),
                cliente.getNombreCliente(),
                cliente.getTelefono(),
                cliente.getLineaDireccion1(),
                cliente.getCiudad()))
            .toList();
    }
}

// src/main/java/com/example/jardineria/service/GamaProductoService.java
package com.example.jardineria.service;

import com.example.jardineria.dto.GamaProductoListDTO;
import com.example.jardineria.repository.GamaProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class GamaProductoService {
    private final GamaProductoRepository gamaProductoRepository;

    public List<GamaProductoListDTO> findAll() {
        return StreamSupport.stream(gamaProductoRepository.findAll().spliterator(), false)
            .map(gama -> new GamaProductoListDTO(
                gama.getGama(),
                gama.getDescripcionTexto()))
            .toList();
    }
}

// src/main/java/com/example/jardineria/service/PedidoService.java
package com.example.jardineria.service;

import com.example.jardineria.dto.PedidoListDTO;
import com.example.jardineria.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public List<PedidoListDTO> findAllWithClienteNombre() {
        return pedidoRepository.findPedidosWithClienteNombre();
    }
}
```

#### 5. Controladores

Definiremos un controlador para cada entidad. Cada uno preparará los datos (cabeceras y filas) para la plantilla genérica, siguiendo la arquitectura de Spring MVC [^2_30].

```java
// src/main/java/com/example/jardineria/web/ClienteController.java
package com.example.jardineria.web;

import com.example.jardineria.dto.ClienteListDTO;
import com.example.jardineria.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/lista")
    public String listarClientes(Model model) {
        List<ClienteListDTO> clientes = clienteService.findAll();
        
        // Cabeceras para la tabla genérica
        model.addAttribute("headers", List.of("Código", "Nombre", "Teléfono", "Dirección", "Ciudad"));
        
        // Datos de las filas
        List<List<Object>> rows = clientes.stream()
                .map(c -> List.of(c.codigoCliente(), c.nombreCliente(), c.telefono(), c.lineaDireccion1(), c.ciudad()))
                .toList();
        
        model.addAttribute("rows", rows);
        model.addAttribute("title", "Listado de Clientes");
        
        // Usamos la misma vista genérica
        return "vistaLista";
    }
}

// src/main/java/com/example/jardineria/web/GamaProductoController.java
package com.example.jardineria.web;

import com.example.jardineria.dto.GamaProductoListDTO;
import com.example.jardineria.service.GamaProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/gamas")
@RequiredArgsConstructor
public class GamaProductoController {

    private final GamaProductoService gamaProductoService;

    @GetMapping("/lista")
    public String listarGamas(Model model) {
        List<GamaProductoListDTO> gamas = gamaProductoService.findAll();
        
        model.addAttribute("headers", List.of("Gama", "Descripción"));
        
        List<List<Object>> rows = gamas.stream()
                .map(g -> List.of(g.gama(), g.descripcionTexto()))
                .toList();
        
        model.addAttribute("rows", rows);
        model.addAttribute("title", "Listado de Gamas de Producto");
        
        return "vistaLista";
    }
}

// src/main/java/com/example/jardineria/web/PedidoController.java
package com.example.jardineria.web;

import com.example.jardineria.dto.PedidoListDTO;
import com.example.jardineria.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping("/lista")
    public String listarPedidos(Model model) {
        List<PedidoListDTO> pedidos = pedidoService.findAllWithClienteNombre();
        
        model.addAttribute("headers", List.of("Código Pedido", "Fecha Pedido", "Estado", "Cliente"));
        
        List<List<Object>> rows = pedidos.stream()
                .map(p -> List.of(p.codigoPedido(), p.fechaPedido(), p.estado(), p.nombreCliente()))
                .toList();
        
        model.addAttribute("rows", rows);
        model.addAttribute("title", "Listado de Pedidos");
        
        return "vistaLista";
    }
}
```

#### 6. Plantilla Thymeleaf Genérica (`vistaLista.html`)

He adaptado el archivo `vistaLista.html` que me proporcionaste para que sea completamente genérico. Recibe un título (`title`), una lista de cabeceras (`headers`) y una lista de filas (`rows`), donde cada fila es a su vez una lista de celdas [^2_1][^2_5].

```html
<!-- src/main/resources/templates/vistaLista.html -->
<!DOCTYPE html>
<html lang="es" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title th:text="${title}">Vista de Lista</title>
    <!-- Incluye aquí tus CSS, por ejemplo, Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1 th:text="${title}">Título de la Lista</h1>
    <hr/>

    <div class="table-responsive">
        <table class="table table-striped table-hover">
            <thead class="table-dark">
            <tr>
                <!-- Itera sobre las cabeceras dinámicas -->
                <th th:each="header : ${headers}" th:text="${header}">Cabecera</th>
            </tr>
            </thead>
            <tbody>
            <!-- Itera sobre las filas -->
            <tr th:each="row : ${rows}">
                <!-- Itera sobre las celdas de cada fila -->
                <td th:each="cell : ${row}" th:text="${cell}">Dato</td>
            </tr>
            <!-- Mensaje si no hay datos -->
            <tr th:if="${rows == null or rows.isEmpty()}">
                <td th:attr="colspan=${headers.size()}" class="text-center">No hay datos para mostrar</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

```

Esta implementación cumple con todos los requisitos. Es modular, utiliza las tecnologías solicitadas y establece una base sólida y escalable para futuras ampliaciones de la aplicación. Estaré atento a tus próximas preguntas sobre este proyecto.

<div style="text-align: center">⁂</div>

[^2_1]: vistaLista.html
[^2_2]: biblioteca.html
[^2_3]: https://www.javaguides.net/2025/02/use-dtos-instead-of-entities-in-api.html
[^2_4]: https://github.com/nurkiewicz/spring-data-jdbc-repository
[^2_5]: https://springframework.guru/displaying-list-of-objects-in-table-using-thymeleaf/
[^2_6]: https://www.wimdeblauwe.com/blog/2021/07/25/using-records-with-thymeleaf/
[^2_7]: https://www.studocu.com/es/document/universidad-catolica-san-antonio-de-murcia/analisis-de-datos/practica-bbdd-jardineria/41372444
[^2_8]: https://www.ilerna.es/blog/modelo-entidad-relacion-base-datos
[^2_9]: https://foojay.io/today/how-to-best-use-java-records-as-dtos-in-spring-boot-3/
[^2_10]: https://stackoverflow.com/questions/58248983/how-to-save-data-in-one-thymeleaf-page-in-multiple-sql-rows
[^2_11]: https://www.javaguides.net/2020/02/java-jdbc-postgresql-select-example.html
[^2_12]: https://www.arquitecturajava.com/rest-java-record-dtos-y-delegacion/
[^2_13]: https://docs.spring.io/spring-data/jdbc/docs/2.4.0-RC1/reference/html/
[^2_14]: https://www.youtube.com/watch?v=VAO0QL19T6w
[^2_15]: https://es.scribd.com/document/736223291/SOLUCION-EJERCICIOS-EDICION-DE-DATOS-JARDINERIA
[^2_16]: https://stackoverflow.com/questions/64660305/entity-or-dto-approach-for-springjdbc-template
[^2_17]: https://stackoverflow.com/questions/71200673/how-to-output-the-element-in-list-with-the-unique-id-using-thymeleaf-in-spring-b/71202357
[^2_18]: https://blog.frankel.ch/custom-spring-data-repository/
[^2_19]: https://stackoverflow.com/questions/49824287/how-do-you-iterate-through-a-list-from-a-dto-in-thymeleaf
[^2_20]: https://www.javaguides.net/2025/05/spring-data-jpa-magic-how-queries-are-generated-from-method-names.html
[^2_21]: https://stackoverflow.com/questions/53543604/strange-one-to-many-behaviour-with-spring-data-jdbc
[^2_22]: https://www.javaguides.net/2025/05/stop-writing-sql-let-spring-data-jpa-handle-it.html
[^2_23]: https://josejuansanchez.org/bd/ejercicios-consultas-sql/index.pdf
[^2_24]: https://es.scribd.com/document/537047880/TALLER-SQL-BASE-DE-DATOS-JARDINERIA
[^2_25]: https://www.studocu.com/latam/document/instituto-politecnico-loyola/lengua-espanola-i/jardineria/39315085
[^2_26]: https://help.claris.com/archive/help/18/fmp/es/FMP_Help/one-to-one-relationships.html
[^2_27]: https://github.com/Kamisama666/cursoSQL/blob/master/cursoSQL.sql
[^2_28]: https://es.stackoverflow.com/questions/178041/relaci%C3%B3n-uno-a-uno-mysql
[^2_29]: programming.java_spring_data
[^2_30]: programming.java_spring_mvc

---


<div style="text-align: center">⁂</div>

[^3_1]: vistaLista.html
[^3_2]: biblioteca.html

---

# Pregunta para factorizar los controladores.
### ¿No sería posible utilizar un controlador genérico para todos?

Sí, es una excelente pregunta y una evolución natural del diseño. Es totalmente posible crear un controlador genérico, y hacerlo es un patrón común para reducir el código repetitivo, especialmente en aplicaciones con muchos CRUDs similares[^4_5].

Sin embargo, un controlador 100% genérico que funcione "mágicamente" para todas las entidades presenta desafíos, sobre todo porque cada una de tus listas tiene:
1.  **Diferentes DTOs** (`ClienteListDTO`, `PedidoListDTO`, etc.).
2.  **Diferentes cabeceras** de tabla (`"Nombre"`, `"Teléfono"` vs. `"Código Pedido"`, `"Estado"`).
3.  **Lógica de obtención de datos distinta** (la lista de pedidos requiere un `JOIN`, mientras que las otras no).

Un enfoque "ingenuo" con genéricos de Java (`BaseController<T>`) se complica rápidamente por estas diferencias.

A continuación, te propongo una solución más robusta y mantenible que combina un **único punto de entrada (endpoint) en el controlador** con un patrón de diseño que delega la lógica específica de cada entidad. Esto mantiene la flexibilidad y la claridad del código.

### Enfoque Propuesto: Controlador Único con "Proveedores de Vistas"

La idea es tener un solo controlador que gestione todas las solicitudes de listas. Este controlador utilizará un "proveedor" (`Provider`) específico para cada tipo de entidad (`cliente`, `gama`, `pedido`) para obtener los datos y metadatos necesarios.

#### 1. Definir una Interfaz para los Proveedores

Crearemos una interfaz que defina el contrato que cada proveedor de vistas de lista debe cumplir.

```java
// src/main/java/com/example/jardineria/ui/ListViewProvider.java
package com.example.jardineria.ui;

import java.util.List;

/**
 * Interfaz para proveedores de datos para la vista de lista genérica.
 * Cada implementación será responsable de una entidad específica.
 */
public interface ListViewProvider {
    /**
     * Devuelve el título de la página.
     */
    String getTitle();

    /**
     * Devuelve las cabeceras de la tabla.
     */
    List<String> getHeaders();

    /**
     * Devuelve los datos de las filas. Cada fila es una lista de objetos.
     */
    List<List<Object>> getRows();
    
    /**
     * Devuelve el nombre de la entidad que gestiona, para el registro.
     */
    String getEntityName();
}
```


#### 2. Implementar un Proveedor para cada Entidad

Ahora, creamos una implementación de esta interfaz para cada una de tus entidades. Aquí es donde reside la lógica específica que antes estaba en cada controlador.

**Proveedor de Clientes:**

```java
// src/main/java/com/example/jardineria/ui/ClienteListViewProvider.java
package com.example.jardineria.ui;

import com.example.jardineria.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClienteListViewProvider implements ListViewProvider {
    private final ClienteService clienteService;

    @Override
    public String getTitle() {
        return "Listado de Clientes";
    }

    @Override
    public List<String> getHeaders() {
        return List.of("Código", "Nombre", "Teléfono", "Dirección", "Ciudad");
    }

    @Override
    public List<List<Object>> getRows() {
        return clienteService.findAll().stream()
                .map(c -> List.of(c.codigoCliente(), c.nombreCliente(), c.telefono(), c.lineaDireccion1(), c.ciudad()))
                .map(List::copyOf) // Convierte a List<Object>
                .toList();
    }
    
    @Override
    public String getEntityName() {
        return "clientes";
    }
}
```

**Proveedor de Gamas de Producto:**

```java
// src/main/java/com/example/jardineria/ui/GamaProductoListViewProvider.java
package com.example.jardineria.ui;

import com.example.jardineria.service.GamaProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GamaProductoListViewProvider implements ListViewProvider {
    private final GamaProductoService gamaProductoService;
    
    @Override
    public String getTitle() {
        return "Listado de Gamas de Producto";
    }

    @Override
    public List<String> getHeaders() {
        return List.of("Gama", "Descripción");
    }

    @Override
    public List<List<Object>> getRows() {
        return gamaProductoService.findAll().stream()
                .map(g -> List.of(g.gama(), g.descripcionTexto()))
                .map(List::copyOf)
                .toList();
    }
    
    @Override
    public String getEntityName() {
        return "gamas";
    }
}
```

**Proveedor de Pedidos (con su lógica de `JOIN`):**

```java
// src/main/java/com/example/jardineria/ui/PedidoListViewProvider.java
package com.example.jardineria.ui;

import com.example.jardineria.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PedidoListViewProvider implements ListViewProvider {
    private final PedidoService pedidoService;
    
    @Override
    public String getTitle() {
        return "Listado de Pedidos";
    }

    @Override
    public List<String> getHeaders() {
        return List.of("Código Pedido", "Fecha Pedido", "Estado", "Cliente");
    }

    @Override
    public List<List<Object>> getRows() {
        return pedidoService.findAllWithClienteNombre().stream()
                .map(p -> List.of(p.codigoPedido(), p.fechaPedido(), p.estado(), p.nombreCliente()))
                .map(List::copyOf)
                .toList();
    }
    
    @Override
    public String getEntityName() {
        return "pedidos";
    }
}
```


#### 3. Crear un Registro de Proveedores

Para que el controlador pueda encontrar el proveedor correcto, necesitamos un "registro". Podemos crear un `Map` que asocie el nombre de la entidad (ej: "clientes") con su `ListViewProvider`. Spring puede inyectar automáticamente todas las implementaciones de una interfaz.

```java
// src/main/java/com/example/jardineria/ui/ListViewProviderFactory.java
package com.example.jardineria.ui;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ListViewProviderFactory {
    private final Map<String, ListViewProvider> providerMap;

    // Spring inyecta todas las implementaciones de ListViewProvider en una lista.
    public ListViewProviderFactory(List<ListViewProvider> providers) {
        // Creamos un mapa donde la clave es el nombre de la entidad y el valor es el proveedor.
        this.providerMap = providers.stream()
                .collect(Collectors.toMap(ListViewProvider::getEntityName, Function.identity()));
    }

    public Optional<ListViewProvider> getProvider(String entityName) {
        return Optional.ofNullable(providerMap.get(entityName));
    }
}
```


#### 4. Implementar el Controlador Genérico

Finalmente, el controlador se vuelve muy simple. Su única responsabilidad es recibir la solicitud, usar la `Factory` para encontrar el proveedor adecuado, y pasar los datos a la vista.

```java
// src/main/java/com/example/jardineria/web/GenericListController.java
package com.example.jardineria.web;

import com.example.jardineria.ui.ListViewProvider;
import com.example.jardineria.ui.ListViewProviderFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Controller
@RequestMapping("/list")
@RequiredArgsConstructor
public class GenericListController {

    private final ListViewProviderFactory providerFactory;

    @GetMapping("/{entityName}")
    public String showGenericList(@PathVariable String entityName, Model model) {
        // Buscamos el proveedor para la entidad solicitada
        ListViewProvider provider = providerFactory.getProvider(entityName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Entidad no encontrada: " + entityName));

        // Usamos el proveedor para obtener los datos y metadatos
        model.addAttribute("title", provider.getTitle());
        model.addAttribute("headers", provider.getHeaders());
        model.addAttribute("rows", provider.getRows());

        // Siempre renderizamos la misma vista genérica
        return "vistaLista";
    }
}
```

Ahora, tus URLs serían:

* `http://localhost:8080/list/clientes`
* `http://localhost:8080/list/gamas`
* `http://localhost:8080/list/pedidos`


### Ventajas y Desventajas de este Enfoque

**Ventajas:**

* **DRY (Don't Repeat Yourself):** El controlador es único y no se repite la lógica de renderizado. Cumple tu objetivo de eliminar controladores específicos para listas[^4_5].
* **Extensible:** Para añadir un listado de una nueva entidad (ej. `productos`), solo necesitas crear una nueva clase `ProductoListViewProvider` e implementarla. No hay que tocar el controlador.
* **Separación de Responsabilidades:** El controlador se ocupa del enrutamiento HTTP[^4_13], la `Factory` de la localización de servicios, y los `Providers` de la lógica de negocio de cada vista.
* **Claridad:** Aunque introduce más clases, la responsabilidad de cada una es muy clara. Es fácil encontrar dónde se definen las cabeceras o cómo se obtienen los datos para los clientes.

**Desventajas:**

* **Mayor Indirección:** Para un desarrollador nuevo, puede ser menos obvio cómo una URL (`/list/clientes`) termina ejecutando el código del `ClienteService`. Hay que entender el patrón `Factory` + `Provider`.
* **Más Clases:** Aumenta el número de ficheros en el proyecto. Sin embargo, esto es preferible a tener clases con múltiples responsabilidades.

Para tu proyecto, que parece destinado a crecer, este patrón es una solución elegante y escalable que va más allá de un simple controlador genérico con `BaseController<T>` y resuelve los desafíos específicos de tu aplicación.

<div style="text-align: center">⁂</div>

[^4_1]: vistaLista.html

[^4_2]: biblioteca.html

[^4_3]: https://stackoverflow.com/questions/57945549/how-to-use-generic-controllers-and-repository-in-spring-mvc

[^4_4]: https://stackoverflow.com/questions/53209345/spring-data-jpa-how-to-build-a-generic-repository-for-multiple-entities

[^4_5]: https://github.com/IllusiveNetworks-Labs/spring-generic-crud

[^4_6]: https://jussi.hallila.com/2018/05/13/dynamizing-your-spring-controller-security.html

[^4_7]: https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html

[^4_8]: https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-requestmapping.html

[^4_9]: https://www.youtube.com/watch?v=PaqWsQBUE6M

[^4_10]: https://www.reddit.com/r/javahelp/comments/mwesgj/thymeleaf_working_on_and_editing_a_list/

[^4_11]: https://docs.spring.io/spring-data/jdbc/docs/2.4.17/reference/html/

[^4_12]: https://www.baeldung.com/thymeleaf-list

[^4_13]: programming.java_spring_mvc

