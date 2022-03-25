package com.germanfica.domain;

public interface TradeInventory extends Inventory {

    /**
     * Determina si una transacción fue exitosa.
     * @return boolean en verdadero si la transación fue exitosa.
     */
    boolean isTransactionSuccessful();

}
