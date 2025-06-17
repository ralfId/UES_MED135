# Explicación del Código `NodoDoble<T>`

Este código define una clase genérica en Java que representa un nodo para una lista doblemente enlazada.

## Estructura Básica
```java
public class NodoDoble<T> {
    // Campos y métodos aquí
}
```
- `NodoDoble<T>` es una clase genérica donde `<T>` representa el tipo de dato que almacenará el nodo.
- Esto permite crear nodos que pueden contener cualquier tipo de objeto (Integer, String, objetos personalizados, etc.).

## Campos de la Clase
```java
public T dato;
public NodoDoble<T> siguiente;
public NodoDoble<T> anterior;
```
1. `dato`: Almacena la información que contiene el nodo (de tipo genérico T).
2. `siguiente`: Referencia al próximo nodo en la lista.
3. `anterior`: Referencia al nodo previo en la lista.

## Constructor
```java
public NodoDoble(T dato) {
    this.dato = dato;
    this.siguiente = null;
    this.anterior = null;
}
```
- Inicializa el nodo con el dato proporcionado.
- Establece ambos enlaces (`siguiente` y `anterior`) a `null`, indicando que inicialmente el nodo no está conectado a otros nodos.

## Características de una Lista Doblemente Enlazada
Este nodo permite construir listas donde:
- Cada nodo tiene un enlace al siguiente nodo (como en una lista simplemente enlazada).
- Cada nodo también tiene un enlace al nodo anterior.
- Esto permite recorrer la lista en ambas direcciones (adelante y atrás).
- Las operaciones de inserción y eliminación son más eficientes para ciertos casos que en listas simplemente enlazadas.
