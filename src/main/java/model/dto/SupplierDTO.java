package model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class SupplierDTO {
    private String id;
    private String name;
    private String company;
    private String address;
    private String city;
    private String province;
    private String postal;
    private String phone;
    private String email;

}
