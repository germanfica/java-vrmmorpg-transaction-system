package com.germafica.service;

import com.germafica.dto.*;
import com.germafica.entity.Account;
import com.germafica.entity.PlayerCharacter;
import com.germafica.repository.PlayerCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PlayerCharacterService {
    // == fields ==
    private PlayerCharacterRepository playerCharacterRepository;

    // == constructors ==
    @Autowired
    private PlayerCharacterService(PlayerCharacterRepository playerCharacterRepository) {
        this.playerCharacterRepository = playerCharacterRepository;
    }

    // == methods ==
    public PlayerCharacterDto addPlayerCharacter(PlayerCharacterOnly playerCharacterOnly) {
        // Create objects
        PlayerCharacter playerCharacter = new PlayerCharacter(
                playerCharacterOnly.getName(),
                playerCharacterOnly.getLevel(),
                playerCharacterOnly.getHealth(),
                playerCharacterOnly.getExperience(),
                playerCharacterOnly.getX(),
                playerCharacterOnly.getY(),
                playerCharacterOnly.getZ()
        );
        Account account = new Account();

        // Set values

        account.setId(playerCharacterOnly.getAccountId());
        playerCharacter.setAccount(account);
        System.out.println("ACCOUNT_ID: " + account.getId());

        return convertToDto(playerCharacterRepository.save(playerCharacter));
    }

    public PlayerCharacterDto updatePlayerCharacter(String id, PlayerCharacterOnly playerCharacterOnly) {
        PlayerCharacter playerCharacter = playerCharacterRepository.findById(id).get();
        PlayerCharacter newPlayerCharacter = new PlayerCharacter(
                playerCharacterOnly.getName(),
                playerCharacterOnly.getLevel(),
                playerCharacterOnly.getHealth(),
                playerCharacterOnly.getExperience(),
                playerCharacterOnly.getX(),
                playerCharacterOnly.getY(),
                playerCharacterOnly.getZ()
        );

        return convertToDto(playerCharacterRepository.save(playerCharacter.update(newPlayerCharacter)));
    }

    public Iterable<PlayerCharacterDto> getAllPlayerCharacters(String accountId) {
        if(!accountId.equals("-1")) {
            // This returns a JSON or XML with the attendances
            return convertToDto(playerCharacterRepository.findAllByAccountId(accountId));
        }else {
            // This returns a JSON or XML
            return convertToDto(playerCharacterRepository.findAll());
        }
    }

    public PlayerCharacterDto getPlayerCharacter(String id) {
        return convertToDto(playerCharacterRepository.findById(id).get());
    }

    public DeleteResponseMessage deletePlayerCharacter(String id) {
        PlayerCharacter playerCharacter = new PlayerCharacter();
        playerCharacter.setId(id);
        playerCharacterRepository.delete(playerCharacter); // Delete a player character from the DB

        return new DeleteResponseMessage(""+id, "player_character",true);
    }

    // == utils ==
    private Set<PlayerCharacterDto> convertToDto(Iterable<PlayerCharacter> playerCharacters) {
        Set<PlayerCharacterDto> playerCharactersDto = new HashSet<>();

        playerCharacters.forEach(item -> playerCharactersDto.add(convertToDto(item)));

        return playerCharactersDto;
    }

    private PlayerCharacterDto convertToDto(PlayerCharacter playerCharacter) {
        return new PlayerCharacterDto(
                playerCharacter.getId(),
                playerCharacter.getName(),
                playerCharacter.getLevel(),
                playerCharacter.getHealth(),
                playerCharacter.getExperience(),
                playerCharacter.getX(),
                playerCharacter.getY(),
                playerCharacter.getZ()
        );
    }
}
