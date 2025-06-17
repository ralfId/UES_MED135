# Explicación del Código `ListaCircularDoble<T>`

Esta clase implementa una **lista circular doblemente enlazada** genérica en Java, una estructura de datos avanzada donde:

## Características Principales
1. **Circularidad**: El último nodo apunta al primero y viceversa
2. **Doble enlace**: Cada nodo tiene referencias `anterior` y `siguiente`
3. **Genéricos**: Trabaja con cualquier tipo de dato `T` que sea comparable

## Estructura Básica
```java
public class ListaCircularDoble<T extends Comparable<T>> implements IListaEnlazada<T>
```
- Implementa la interfaz `IListaEnlazada<T>` (mismos métodos que la lista doble normal)
- El tipo `T` debe ser comparable para permitir ordenamiento

## Campos Clave
```java
private NodoDoble<T> cabeza;  // Punto de entrada a la lista
private int tamanio;          // Contador de elementos
```

## Métodos Principales

### 1. `agregarAlInicio(T dato)`
- **Comportamiento**: Inserta al principio manteniendo la circularidad
- **Casos**:
  - Lista vacía: Crea un nodo que se apunta a sí mismo
  - Lista con elementos: Inserta antes de la cabeza actual y actualiza enlaces

### 2. `agregarAlFinal(T dato)`
- **Comportamiento**: Inserta al final (que en realidad es antes de la cabeza)
- **Implementación**: Similar a agregar al inicio pero sin cambiar la cabeza

### 3. `suprimir(T dato)`
- **Comportamiento**: Busca y elimina el nodo con el dato
- **Casos especiales**:
  - Único nodo: Elimina y deja lista vacía
  - Eliminar cabeza: Actualiza la referencia de cabeza

### 4. `ordenar()`
- **Algoritmo**: Bubble Sort adaptado para lista circular
- **Detalle**: Compara nodos adyacentes intercambiando datos (no nodos)

### 5. `listar()` y `listarInverso()`
- **Recorrido**:
  - `listar()`: Avanza usando `siguiente` hasta volver a la cabeza
  - `listarInverso()`: Retrocede usando `anterior` hasta el inicio
- **Formato**: Muestra "A <-> B <-> C <-> (circular)"

### 6. Operaciones Auxiliares
- `vaciar()`: Elimina todos los referencias
- `getTamanio()`/`estaVacia()`: Consultan estado actual

## Diferencias con Lista Doble Normal
1. **No necesita nodo 'cola'**: El último nodo es `cabeza.anterior`
2. **Bucles circulares**: Todos los recorridos deben verificar `actual != cabeza`
3. **Inserción más compleja**: Requiere actualizar más enlaces



## Ventajas
- Recorrido bidireccional infinito (útil para playlists, buffers)
- Inserción/eliminación eficiente en extremos (O(1))
- Útil para algoritmos round-robin y problemas circulares

Esta implementación es particularmente útil cuando necesitas ciclos continuos o acceso bidireccional constante.