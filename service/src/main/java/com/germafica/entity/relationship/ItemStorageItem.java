package com.germafica.entity.relationship;

import com.germafica.entity.Item;
import com.germafica.entity.ItemStorage;
import com.germafica.entity.relationship.embeddable.ItemStorageItemId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * This class represents the stores relationship.
 * Please keep your @Entity class separated from it's
 * JSON representation. Using Jackson annotations here
 * it's a bad practice.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "ItemStorageItem")
@Table(name = "stores")
public class ItemStorageItem {
    @EmbeddedId
    private ItemStorageItemId id;

    @Column( name = "slot", nullable = false)
    private int slot;

    @Getter(value = AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("itemStorageId")  //  maps the itemStorageId attribute of embedded id
    private ItemStorage itemStorage;

    @Getter(value = AccessLevel.NONE)
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("itemId")  //  maps the itemId attribute of embedded id
    private Item item;
}
