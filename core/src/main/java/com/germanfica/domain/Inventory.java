package com.germanfica.domain;

public interface Inventory {

    /**
     * Muestra el inventario
     */
    void show();

    /**
     * Agrega un GameObject al inventario.
     */
    void addGameObject(GameObject gameObject);
}
