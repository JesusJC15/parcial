# Parcial 2do Tercio AREP - Jesús Jauregui

Aplicación desarrollada con **Spring Boot** que expone una API REST para ejecutar dos algoritmos clásicos de búsqueda sobre arreglos de enteros:

- **Búsqueda lineal**
- **Búsqueda binaria**

El proyecto permite enviar una lista de números y un valor objetivo, y devuelve un objeto JSON con la operación ejecutada, la lista de entrada, el valor buscado y la posición encontrada.

## Video de evidencia

[Ver video de evidencia](https://drive.google.com/file/d/18XBYouY0Q5febL3gZD39SHiY5tvRJON8/view?usp=sharing)

---

## Tabla de contenido

- [Descripción del proyecto](#descripción-del-proyecto)
- [Tecnologías utilizadas](#tecnologías-utilizadas)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Requisitos previos](#requisitos-previos)
- [Cómo ejecutar el proyecto](#cómo-ejecutar-el-proyecto)
- [Endpoints disponibles](#endpoints-disponibles)
  - [Búsqueda lineal](#1-búsqueda-lineal)
  - [Búsqueda binaria](#2-búsqueda-binaria)
- [Ejemplos de respuesta](#ejemplos-de-respuesta)
- [Pruebas](#pruebas)
- [Detalles de implementación](#detalles-de-implementación)

---

## Descripción del proyecto

Este proyecto implementa una API REST sencilla con Spring Boot para resolver búsquedas sobre listas de números enteros.

### Funcionalidades principales

- Recibir una lista de enteros por parámetro query.
- Recibir el valor a buscar.
- Ejecutar el algoritmo solicitado.
- Retornar una respuesta estructurada en formato JSON.
- Indicar con `output` el índice donde se encontró el valor.
- Retornar `-1` cuando el valor no existe dentro de la lista.

### Operaciones soportadas

- `linearSearch`: recorre la lista secuencialmente.
- `binarySearch`: divide la lista en mitades para encontrar el elemento más rápido.

> **Nota:** para que la búsqueda binaria funcione correctamente, la lista enviada debe estar ordenada de menor a mayor.

---

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot 4.0.4**
- **Spring Web MVC**
- **Maven**
- **JUnit 5**

---

## Estructura del proyecto

```bash
parcial/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/com/arep/parcial/
    │   │   ├── ParcialApplication.java
    │   │   ├── controller/
    │   │   │   └── MathController.java
    │   │   ├── model/
    │   │   │   ├── BinarySearch.java
    │   │   │   └── LinearSearch.java
    │   │   └── service/
    │   │       ├── BinarySearchService.java
    │   │       └── LinearSearchService.java
    │   └── resources/
    │       └── application.properties
    └── test/
        └── java/com/arep/parcial/
            └── ParcialApplicationTests.java
```

### Descripción de componentes

- **ParcialApplication**: clase principal que arranca la aplicación Spring Boot.
- **MathController**: expone los endpoints REST.
- **LinearSearchService**: contiene la lógica de búsqueda lineal.
- **BinarySearchService**: contiene la lógica de búsqueda binaria.
- **LinearSearch / BinarySearch**: modelos de respuesta.
- **ParcialApplicationTests**: prueba básica de carga del contexto.

---

## Requisitos previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- **Java 17** o superior
- **Maven 3.8+**
- Git

Puedes verificarlo con:

```bash
java -version
mvn -version
git --version
```

---

## Cómo ejecutar el proyecto

### 1. Clonar el repositorio

```bash
git clone https://github.com/JesusJC15/parcial.git
cd parcial
```

### 2. Compilar el proyecto

```bash
mvn clean install
```

### 3. Ejecutar la aplicación

```bash
mvn spring-boot:run
```

También puedes ejecutarla con:

```bash
mvn package
java -jar target/parcial-0.0.1-SNAPSHOT.jar
```

### 4. Acceder al servidor

Por defecto, Spring Boot se ejecuta en:

```bash
http://localhost:8080
```

---

## Endpoints disponibles

## 1. Búsqueda lineal

Realiza una búsqueda secuencial sobre la lista.

### Endpoint

```http
GET /linearsearch
```

### Parámetros

- `list`: arreglo de enteros
- `value`: valor entero a buscar

### Ejemplo de uso

```bash
http://localhost:8080/linearsearch?list=1,4,7,9,12&value=9
```

### Respuesta esperada

```json
{
  "operation": "linearSearch",
  "inputList": [1, 4, 7, 9, 12],
  "value": 9,
  "output": 3
}
```

---

## 2. Búsqueda binaria

Realiza una búsqueda binaria sobre una lista ordenada.

### Endpoint

```http
GET /binarysearch
```

### Parámetros

- `list`: arreglo de enteros ordenado
- `value`: valor entero a buscar

### Ejemplo de uso

```bash
http://localhost:8080/binarysearch?list=1,4,7,9,12,15,20&value=12
```

### Respuesta esperada

```json
{
  "operation": "binarySearch",
  "inputList": [1, 4, 7, 9, 12, 15, 20],
  "value": 12,
  "output": 4
}
```

---

## Ejemplos de respuesta

### Cuando el valor existe

```json
{
  "operation": "linearSearch",
  "inputList": [5, 10, 15, 20],
  "value": 15,
  "output": 2
}
```

### Cuando el valor no existe

```json
{
  "operation": "binarySearch",
  "inputList": [2, 4, 6, 8, 10],
  "value": 7,
  "output": -1
}
```

---

## Pruebas

El proyecto incluye una prueba básica para validar que el contexto de Spring Boot cargue correctamente.

### Ejecutar pruebas

```bash
mvn test
```

---

## Detalles de implementación

### Búsqueda lineal

La búsqueda lineal recorre la lista elemento por elemento hasta encontrar el valor solicitado.

- Si lo encuentra, retorna su índice.
- Si no lo encuentra, retorna `-1`.

### Búsqueda binaria

La búsqueda binaria funciona sobre listas ordenadas:

1. Toma el elemento central.
2. Compara con el valor buscado.
3. Si el valor es menor, continúa por la mitad izquierda.
4. Si el valor es mayor, continúa por la mitad derecha.
5. Si no se encuentra, retorna `-1`.

### Modelo de respuesta

Tanto `LinearSearch` como `BinarySearch` retornan:

- `operation`: nombre de la operación ejecutada.
- `inputList`: lista recibida.
- `value`: valor buscado.
- `output`: posición encontrada o `-1`.