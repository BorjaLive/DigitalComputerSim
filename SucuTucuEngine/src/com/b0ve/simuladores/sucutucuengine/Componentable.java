package com.b0ve.simuladores.sucutucuengine;

/**
 * Interfaz que define las operaciones qe puede realizar un componente
 */
public interface Componentable {

    /**
     * Obtener la ID única que identifica al componente dentro de un 
     * @return ID
     */
    public long getId();

    /**
     * Amplicar la lista de pines de entrada que expone el componente
     * @param entrada Nombre de la entrada a agregar
     */
    public void addEntrada(String entrada);

    /**
     * Reducir la lista de pines de entrada que expone el componente
     * @param entrada Nombre de la entrada a eliminar
     */
    public void removeEntrada(String entrada);

    /**
     * Amplicar la lista de pines de salida que expone el componente
     * @param salida Nombre de la salida a agregar
     */
    public void addSalida(String salida);

    /**
     * Reducir la lista de pines de salida que expone el componente
     * @param salida Nombre de la salida a eliminar
     */
    public void removeSalida(String salida);

    /**
     * Devuelve el pin de salida al que está conectada una entrada del componente. Null si no está conectado
     * @param entrada Nombre de la entrada del componente
     * @return Pin de salida al que esta conectada al entrada
     */
    public Pin getEntrada(String entrada);

    /**
     * Devuelve el estado de una salida de un componente. Null si no está definida
     * @param salida Nombre de la salida del componente
     * @return Estado de la salida del componente
     */
    public Boolean getSalida(String salida);

    /**
     * Conecta un pinde entrada del componente a un pin de salida de otro componente
     * @param salida Pin de salida que se conecta a la entrada
     * @param nombreEntrada Nombrede la entrada a la que se conecta el pin de salida
     */
    public void setEntrada(Pin salida, String nombreEntrada);

    /**
     * Devuelve las entradas expuestas del componente
     * @return Entradas expuestas
     */
    public String[] getNombreEntradas();

    /**
     * Devuelve las salidas expuestas del componente
     * @return Salidas expuestas
     */
    public String[] getNombreSalidas();

    /**
     * Intenta determinar las salidas del componente. Si alguna de las entradas está indeterminada, no puede calcular las salidas. Si una entrada está desconectada se tomará como valor bajo.
     * @return Verdadero si se ha podido calcular, falso si no se ha podido
     */
    public boolean calcular();

    /**
     * Marca como indefinidas todas las salidas del componente
     */
    public void limpiar();
}
