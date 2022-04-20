package com.germafica.repository;

import com.germafica.entity.ItemStorage;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<ItemStorage, Integer> {
}
