package com.germafica.repository;

import com.germafica.entity.Character;
import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<Character, Integer> {
}
