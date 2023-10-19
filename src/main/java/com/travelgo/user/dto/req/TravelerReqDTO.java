package com.travelgo.user.dto.req;

import com.travelgo.user.entity.embeded.ContactNumber;
import com.travelgo.user.util.enums.Gender;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.params.converter.ConvertWith;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TravelerReqDTO {
    private String nic;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private ContactNumber contactNumber;
    private String userName;
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
}
