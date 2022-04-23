package com.germafica.controller;

import com.germafica.dto.ItemDto;
import com.germafica.dto.ItemOnly;
import com.germafica.service.ItemService;
import com.germafica.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController // This means that this class is a Controller
@RequestMapping(path = "/api") // This means URL's start with /api (after Application path)
@CrossOrigin
public class ApiController {
    // == fields ==
    private AccountService accountService;
    private ItemService gameObjectService;

    // == constructors ==
    @Autowired
    public ApiController(
            AccountService accountService,
            ItemService gameObjectService
    ) {
        this.accountService = accountService;
        this.gameObjectService = gameObjectService;
    }

    // == methods ==
    @PostConstruct // Do not use the @PostConstruct to get the data from the database
    void start() { }

    // == setters ==
    @ResponseBody
    @CrossOrigin
    @PostMapping(path="/game_objects") // Map ONLY POST Requests
    public ResponseEntity<ItemDto> addGameObject (@RequestBody ItemOnly gameObjectOnly){
        return ResponseEntity.ok(gameObjectService.addGameObject(gameObjectOnly));
    }

    //TODO: Add inventory set method

    //TODO: Add player set method

    //TODO: Add stores set method

    // == puts ==
    //TODO: Add game object put method

    //TODO: Add inventory put method

    //TODO: Add player put method

    //TODO: Add stores put method

    // == getters ==
    //TODO: Add game object getAll method
    //TODO: Add game object get method

    //TODO: Add inventory getAll method
    //TODO: Add inventory get method

    //TODO: Add player getAll method
    //TODO: Add player get method

    //TODO: Add stores getAll method
    //TODO: Add stores get method

    // == deletes ==
    //TODO: Add game object delete method

    //TODO: Add inventory delete method

    //TODO: Add player delete method

    //TODO: Add stores delete method
}
