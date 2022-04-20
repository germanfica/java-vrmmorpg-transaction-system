package com.germafica.service;

import com.germafica.dto.DeleteResponseMessage;
import com.germafica.dto.GameObjectDto;
import com.germafica.dto.GameObjectOnly;
import com.germafica.entity.Item;
import com.germafica.repository.GameObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class GameObjectService {
    // == fields ==
    private GameObjectRepository gameObjectRepository;

    // == constructors ==
    @Autowired
    private GameObjectService(GameObjectRepository gameObjectRepository) {
        this.gameObjectRepository = gameObjectRepository;
    }

    // == methods ==
    public GameObjectDto addGameObject(GameObjectOnly gameObjectOnly) {
        // Create objects
        Item bookmark = new Item(
                gameObjectOnly.getName(),
                gameObjectOnly.getLevel(),
                gameObjectOnly.getDescription(),
                gameObjectOnly.getTradable()
        );

        return convertToDto(gameObjectRepository.save(bookmark));
    }

    public Iterable<GameObjectDto> getAllGameObjects(int materialId) {
        // This returns a JSON or XML
        return convertToDto(gameObjectRepository.findAll());
    }

    public GameObjectDto getGameObject(int id) {
        return convertToDto(gameObjectRepository.findById(id).get());
    }

    public DeleteResponseMessage deleteGameObject(int id) {
        Item gameObject = new Item();
        gameObject.setId(id);
        gameObjectRepository.delete(gameObject); // Delete a block from the DB

        return new DeleteResponseMessage(""+id, "gameObject",true);
    }

    // == utils ==
    private Set<GameObjectDto> convertToDto(Iterable<Item> gameObjects) {
        Set<GameObjectDto> gameObjectsDto = new HashSet<>();

        gameObjects.forEach(gameObject -> gameObjectsDto.add(convertToDto(gameObject)));

        return gameObjectsDto;
    }

    private GameObjectDto convertToDto(Item gameObject) {
        return new GameObjectDto(
                gameObject.getId(),
                gameObject.getName(),
                gameObject.getLevel(),
                gameObject.getDescription(),
                gameObject.getTradable()
        );
    }
}
