package com.store_v2.store.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FarmerRequestDTO {


    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "name must be between 2 to 50 character")
    private String name;

    @NotBlank(message = "Phone No. is required")
    @Pattern(regexp = "[0^9]{10}$", message = "phone no must be 10 digit")
    private String phone;

    @NotBlank(message = "Address is required")
    private String address;

    public @NotBlank(message = "Name is required") @Size(min = 2, max = 50, message = "name must be between 2 to 50 character") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is required") @Size(min = 2, max = 50, message = "name must be between 2 to 50 character") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Phone No. is required") @Pattern(regexp = "[0^9]{10}$", message = "phone no must be 10 digit") String getPhone() {
        return phone;
    }

    public void setPhone(@NotBlank(message = "Phone No. is required") @Pattern(regexp = "[0^9]{10}$", message = "phone no must be 10 digit") String phone) {
        this.phone = phone;
    }

    public @NotBlank(message = "Address is required") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "Address is required") String address) {
        this.address = address;
    }
}
