package com.germafica.service;

import com.germafica.dto.DeleteResponseMessage;
import com.germafica.dto.ItemDto;
import com.germafica.dto.ItemOnly;
import com.germafica.entity.Item;
import com.germafica.entity.PlayerCharacter;
import com.germafica.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ItemService {
    // == fields ==
    private ItemRepository itemRepository;

    // == constructors ==
    @Autowired
    private ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // == methods ==
    public ItemDto addItem(ItemOnly itemOnly) {
        // Create objects
        Item item = new Item(
                itemOnly.getName(),
                itemOnly.getLevel(),
                itemOnly.getDurability()
        );
        PlayerCharacter playerCharacter = new PlayerCharacter();

        // Set values
        playerCharacter.setId(itemOnly.getPlayerCharacterId());
        item.setPlayerCharacter(playerCharacter);

        return convertToDto(itemRepository.save(item));
    }

    public ItemDto updateItem(String id, ItemOnly itemOnly) {
        Item item = itemRepository.findById(id).get();
        Item newItem = new Item(itemOnly.getName(), itemOnly.getLevel(), itemOnly.getDurability());

        return convertToDto(itemRepository.save(item.update(newItem)));
    }

    public Iterable<ItemDto> getAllItems(String playerCharacterId) {
        // This returns a JSON or XML
        return convertToDto(itemRepository.findAll());
    }

    public ItemDto getItem(String id) {
        return convertToDto(itemRepository.findById(id).get());
    }

    public DeleteResponseMessage deleteItem(String id) {
        Item item = new Item();
        item.setId(id);
        itemRepository.delete(item); // Delete an item from the DB

        return new DeleteResponseMessage(""+id, "item",true);
    }

    // == utils ==
    private Set<ItemDto> convertToDto(Iterable<Item> items) {
        Set<ItemDto> itemDto = new HashSet<>();

        items.forEach(item -> itemDto.add(convertToDto(item)));

        return itemDto;
    }

    private ItemDto convertToDto(Item item) {
        return new ItemDto(
                item.getId(),
                item.getName(),
                item.getLevel(),
                item.getDurability()
        );
    }
}
