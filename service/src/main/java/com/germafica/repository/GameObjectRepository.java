package com.germafica.repository;

import com.germafica.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface GameObjectRepository extends CrudRepository<Item, Integer> {
}
