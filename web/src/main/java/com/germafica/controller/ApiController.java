package com.germafica.controller;

import com.germafica.dto.GameObjectDto;
import com.germafica.dto.GameObjectOnly;
import com.germafica.service.GameObjectService;
import com.germafica.service.InventoryService;
import com.germafica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController // This means that this class is a Controller
@RequestMapping(path = "/api") // This means URL's start with /api (after Application path)
@CrossOrigin
public class ApiController {
    // == fields ==
    private GameObjectService gameObjectService;
    private InventoryService inventoryService;
    private UserService userService;

    // == constructors ==
    @Autowired
    public ApiController(
            GameObjectService gameObjectService,
            InventoryService inventoryService,
            UserService userService
    ) {
        this.gameObjectService = gameObjectService;
        this.inventoryService = inventoryService;
        this.userService = userService;
    }

    // == methods ==
    @PostConstruct // Do not use the @PostConstruct to get the data from the database
    void start() { }

    // == setters ==
    @ResponseBody
    @CrossOrigin
    @PostMapping(path="/game_objects") // Map ONLY POST Requests
    public ResponseEntity<GameObjectDto> addGameObject (@RequestBody GameObjectOnly gameObjectOnly){
        return ResponseEntity.ok(gameObjectService.addGameObject(gameObjectOnly));
    }

    // == puts ==
    //TODO: Add game object put method

    // == getters ==
    //TODO: Add game object getAll method
    //TODO: Add game object get method

    // == deletes ==
    //TODO: Add game object delete method
}
