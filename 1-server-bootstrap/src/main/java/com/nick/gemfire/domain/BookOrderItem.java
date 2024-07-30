package com.nick.gemfire.domain;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class BookOrderItem implements Serializable {
    private static final long serialVersionUID = 4L;

    private int orderLine;
    private long itemNumber;
    @Builder.Default private int quantity = 1;
    @Builder.Default private float discount = 0f;

}
