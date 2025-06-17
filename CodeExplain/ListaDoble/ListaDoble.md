# Explicación del Código `ListaDoble<T>`

Esta clase implementa una **lista doblemente enlazada genérica** en Java, donde cada elemento tiene referencias tanto al siguiente como al anterior nodo.

## Estructura Básica
```java
public class ListaDoble<T extends Comparable<T>> implements IListaEnlazada<T>
```
- `ListaDoble<T>` es una clase genérica donde `<T extends Comparable<T>>` significa que el tipo de dato debe ser comparable (necesario para el método `ordenar()`).
- Implementa la interfaz `IListaEnlazada<T>`, lo que sugiere que sigue un contrato definido para listas enlazadas.

## Campos Principales
```java
private NodoDoble<T> cabeza;  // Primer nodo de la lista
private NodoDoble<T> cola;    // Último nodo de la lista
private int tamanio;          // Cantidad de elementos
```

## Métodos Principales

### 1. `agregarAlInicio(T dato)`
- **Función**: Inserta un nuevo nodo al principio de la lista.
- **Lógica**:
  - Crea un nuevo nodo con el dato.
  - Si la lista está vacía, cabeza y cola apuntan al nuevo nodo.
  - Si no, el nuevo nodo se enlaza con la antigua cabeza y se convierte en la nueva cabeza.

### 2. `agregarAlFinal(T dato)`
- **Función**: Inserta un nuevo nodo al final de la lista.
- **Lógica**:
  - Similar a `agregarAlInicio`, pero trabaja con la cola.
  - Enlaza el nuevo nodo con la antigua cola y lo convierte en la nueva cola.

### 3. `suprimir(T dato)`
- **Función**: Elimina el primer nodo que contenga el dato especificado.
- **Lógica**:
  - Busca el nodo con el dato.
  - Reajusta los enlaces `anterior` y `siguiente` de los nodos vecinos.
  - Maneja casos especiales cuando se elimina la cabeza o la cola.

### 4. `ordenar()`
- **Función**: Ordena la lista usando el algoritmo Bubble Sort.
- **Lógica**:
  - Compara nodos adyacentes e intercambia sus datos si están en orden incorrecto.
  - Repite hasta que no haya más intercambios.

### 5. `listar()` y `listarInverso()`
- **Función**: Genera una representación en String de la lista.
- **`listar()`** recorre desde la cabeza hasta la cola.
- **`listarInverso()`** recorre desde la cola hasta la cabeza.

### 6. Operaciones Auxiliares
- `vaciar()`: Elimina todos los nodos.
- `getTamanio()`: Devuelve el número de elementos.
- `estaVacia()`: Verifica si la lista no tiene elementos.

## Características Clave
1. **Doble Enlace**: Cada nodo mantiene referencias al anterior y siguiente.
2. **Eficiencia**:
   - Inserción al inicio/final: O(1)
   - Eliminación: O(n) en el peor caso
   - Búsqueda: O(n)
3. **Recorrido Bidireccional**: Puede recorrerse en ambas direcciones.
4. **Ordenamiento**: Implementa Bubble Sort (no el más eficiente, pero simple).
