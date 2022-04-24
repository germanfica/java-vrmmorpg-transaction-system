package com.germafica.service;

import com.germafica.dto.DeleteResponseMessage;
import com.germafica.dto.ItemDto;
import com.germafica.dto.ItemOnly;
import com.germafica.entity.Item;
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
                itemOnly.getDescription(),
                itemOnly.getTradable()
        );

        return convertToDto(itemRepository.save(item));
    }

    public ItemDto updateItem(int id, ItemOnly itemOnly) {
        Item item = itemRepository.findById(id).get();
        Item newItem = new Item(itemOnly.getName(), itemOnly.getLevel(), itemOnly.getDescription(), itemOnly.getTradable());

        return convertToDto(itemRepository.save(item.update(newItem)));
    }

    public Iterable<ItemDto> getAllItems(int playerCharacterId) {
        // This returns a JSON or XML
        return convertToDto(itemRepository.findAll());
    }

    public ItemDto getItem(int id) {
        return convertToDto(itemRepository.findById(id).get());
    }

    public DeleteResponseMessage deleteItem(int id) {
        Item item = new Item();
        item.setId(id);
        itemRepository.delete(item); // Delete a block from the DB

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
                item.getDescription(),
                item.getTradable()
        );
    }
}
