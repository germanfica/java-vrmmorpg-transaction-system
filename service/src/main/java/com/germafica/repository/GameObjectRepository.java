package com.germafica.repository;

import com.germafica.entity.GameObject;
import org.springframework.data.repository.CrudRepository;

public interface GameObjectRepository extends CrudRepository<GameObject, Integer> {
}
