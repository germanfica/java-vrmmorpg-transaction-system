package com.germafica.controller;

import com.germafica.service.GameObjectService;
import com.germafica.service.InventoryService;
import com.germafica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // == puts ==

    // == getters ==

    // == deletes ==
}
