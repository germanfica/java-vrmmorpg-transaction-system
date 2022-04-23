package com.germafica.entity.relationship.embeddable;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * This class represents a composite key between item storage and item.
 * Please keep your @Entity class separated from it's
 * JSON representation. Using Jackson annotations here
 * it's a bad practice.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ItemStorageItemId implements Serializable {
    private Integer itemStorageId; // corresponds to primary key type of Item Storage
    private Integer itemId; // corresponds to primary key type of Item
}
