# Explicación de la Interfaz `IListaEnlazada<T>`

Esta interfaz define el **contrato básico** que deben implementar todas las listas enlazadas en este proyecto. Es una interfaz genérica que establece las operaciones fundamentales que cualquier lista enlazada debe proporcionar.

## Características Clave

1. **Genéricidad** (`<T extends Comparable<T>>`):
   - Trabaja con cualquier tipo de dato `T`
   - El tipo `T` debe ser comparable (para permitir operaciones de ordenación)

2. **Operaciones estándar**:
   - Inserción (al inicio/final)
   - Eliminación
   - Ordenación
   - Recorrido/visualización
   - Gestión del estado

## Métodos Definidos

### 1. Operaciones de Inserción
```java
void agregarAlInicio(T dato);
void agregarAlFinal(T dato);
```
- **Propósito**: Añadir elementos en extremos opuestos de la lista
- **Uso típico**:
  - `agregarAlInicio` para implementar pilas (LIFO)
  - `agregarAlFinal` para implementar colas (FIFO)

### 2. Operación de Eliminación
```java
boolean suprimir(T dato);
```
- **Comportamiento**:
  - Busca y elimina la primera ocurrencia del dato
  - Retorna `true` si encontró y eliminó, `false` si no existía

### 3. Ordenación
```java
void ordenar();
```
- **Requisito**: El tipo `T` debe ser `Comparable`
- **Implementación típica**: Bubble Sort, Insertion Sort u otros algoritmos

### 4. Visualización
```java
String listar();
String listarInverso();
```
- **Salida**: Representación en String de los elementos
- `listarInverso()` muestra utilidad en listas doblemente enlazadas

### 5. Gestión de Estado
```java
void vaciar();
int getTamanio();
boolean estaVacia();
```
- **Control básico**:
  - `vaciar()` reinicia la lista
  - `getTamanio()` obtiene el conteo de elementos
  - `estaVacia()` verifica si hay elementos

## Propósito del Diseño

Esta interfaz permite:
1. **Uniformidad**: Todas las listas implementan los mismos métodos básicos
2. **Polimorfismo**: Permite tratar diferentes implementaciones de listas de la misma manera
3. **Extensibilidad**: Fácil añadir nuevos tipos de listas (simples, dobles, circulares)

## Ejemplo de Implementación
Las clases `ListaDoble` y `ListaCircularDoble` implementan esta interfaz, proporcionando distintas formas (doblemente enlazada vs circular) pero la misma interfaz pública.

## Relación con el Principio SOLID
- **Single Responsibility**: La interfaz solo define operaciones de lista
- **Open/Closed**: Abierta a extensiones (nuevas implementaciones), cerrada a modificaciones
- **Liskov Substitution**: Cualquier implementación puede sustituir a la interfaz
- **Interface Segregation**: Define solo métodos esenciales de listas
- **Dependency Inversion**: El código cliente depende de la abstracción (interfaz), no de implementaciones concretas

Esta interfaz es el cimiento que permite implementar diferentes variantes de listas enlazadas manteniendo consistencia en la API.