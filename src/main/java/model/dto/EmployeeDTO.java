package model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class EmployeeDTO {
    private String id;
    private String name;
    private String nic;
    private String dob;
    private String position;
    private double salary;
    private String phone;
    private String address;
    private String joinedDate;
    private String status;
}
