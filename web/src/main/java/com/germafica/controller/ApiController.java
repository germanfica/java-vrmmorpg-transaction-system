package com.germafica.controller;

import com.germafica.dto.DeleteResponseMessage;
import com.germafica.dto.ItemDto;
import com.germafica.dto.ItemOnly;
import com.germafica.entity.PlayerCharacter;
import com.germafica.service.ItemService;
import com.germafica.service.AccountService;
import com.germafica.service.PlayerCharacterService;
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
    private ItemService itemService;
    private PlayerCharacterService playerCharacterService;

    // == constructors ==
    @Autowired
    public ApiController(
            AccountService accountService,
            ItemService itemService,
            PlayerCharacterService playerCharacterService
    ) {
        this.accountService = accountService;
        this.itemService = itemService;
        this.playerCharacterService = playerCharacterService;
    }

    // == methods ==
    @PostConstruct // Do not use the @PostConstruct to get the data from the database
    void start() { }

    // == setters ==
    @ResponseBody
    @CrossOrigin
    @PostMapping(path="/items") // Map ONLY POST Requests
    public ResponseEntity<ItemDto> addItem (@RequestBody ItemOnly itemOnly){
        return ResponseEntity.ok(itemService.addItem(itemOnly));
    }

    //TODO: Add item storage set method

    //TODO: Add player character set method

    // == puts ==
    @CrossOrigin
    @PutMapping(value = "/items/{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable("id") int id, @RequestBody ItemOnly itemOnly) {
        return ResponseEntity.ok(itemService.updateItem(id, itemOnly));
    }

    //TODO: Add item storage put method

    //TODO: Add player character put method

    // == getters ==
    @ResponseBody
    @CrossOrigin
    @GetMapping(path="/items")
    public Iterable<ItemDto> getAllItems(@RequestParam(defaultValue = "-1", required = false) int player_character_id) {
        return itemService.getAllItems(player_character_id);
    }

    @ResponseBody
    @CrossOrigin
    @GetMapping(value = "/items/{id}")
    public ResponseEntity<ItemDto> getItem(@PathVariable("id") int id) {
        return ResponseEntity.ok(itemService.getItem(id));
    }

    //TODO: Add item storage getAll method
    //TODO: Add item storage get method

    //TODO: Add player character getAll method
    //TODO: Add player character get method

    // == deletes ==
    @ResponseBody
    @CrossOrigin
    @DeleteMapping(value = "/items/{id}")
    public ResponseEntity<DeleteResponseMessage> deleteItem(@PathVariable("id") int id) {
        return ResponseEntity.ok(itemService.deleteItem(id));
    }

    //TODO: Add item storage delete method

    //TODO: Add player character delete method
}
