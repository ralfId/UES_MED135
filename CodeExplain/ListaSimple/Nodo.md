# Explicación del Código de la Clase Nodo

Esta clase implementa un nodo básico para estructuras de datos enlazadas.

## Declaración de la clase
```java
public class Nodo<T> {
```
- Define una clase genérica `Nodo` que puede almacenar cualquier tipo de dato `T`
- El `<T>` indica que es una clase genérica (se puede trabajar con diferentes tipos de datos)

## Variables de instancia (campos públicos)
```java
public T dato;
public Nodo<T> siguiente;
```
- `dato`: Almacena la información que contendrá el nodo (de tipo genérico T)
- `siguiente`: Es una referencia al siguiente nodo en la estructura enlazada
- Ambos campos son `public` para facilitar el acceso directo desde las clases que usen estos nodos

## Constructor
```java
public Nodo(T dato) {
    this.dato = dato;
    this.siguiente = null;
}
```
- `public Nodo(T dato)`: Constructor que recibe el dato a almacenar
- `this.dato = dato`: Asigna el valor recibido al campo `dato` del nodo
- `this.siguiente = null`: Inicializa el puntero al siguiente nodo como nulo (indicando que no hay nodo siguiente por defecto)

## Comportamiento general
Esta clase es muy simple pero fundamental para estructuras enlazadas. Cada nodo:
1. Almacena un dato de cualquier tipo (T)
2. Mantiene una referencia al siguiente nodo en la secuencia
3. Cuando se crea, el puntero `siguiente` siempre empieza como null
