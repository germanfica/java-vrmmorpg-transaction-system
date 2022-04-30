package com.germafica.repository;

import com.germafica.entity.PlayerCharacter;
import org.springframework.data.repository.CrudRepository;

public interface PlayerCharacterRepository extends CrudRepository<PlayerCharacter, String> {
    Iterable<PlayerCharacter> findAllByAccountId(String accountId);
}
