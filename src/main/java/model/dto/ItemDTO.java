package model.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ItemDTO {
    private String code;
    private String description;
    private String category;
    private int quantity;
    private double unitPrice;
}
