package com.germafica.component;

import com.germafica.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestApp {
    // == fields ==
    private InventoryRepository inventoryRepository;

    // == constructors ==
    @Autowired
    public TestApp(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    // == events ==
    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("start() --> Container ready for use.");
        this.inventoryRepository.findAll();
    }
}
