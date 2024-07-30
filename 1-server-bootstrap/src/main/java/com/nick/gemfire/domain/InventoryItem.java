package com.nick.gemfire.domain;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
@ToString(of = {"itemNumber", "quantityInStock", "location"})
@AllArgsConstructor
@Builder
public class InventoryItem implements Serializable {

    private static final long serialVersionUID = 6L;

    private long itemNumber;
    private int quantityInStock;
    private float costToXYZ, priceToCustomer;
    private String vendor, location;

}