package com.travelgo.user.dto.core;

import com.travelgo.user.entity.embeded.ContactNumber;
import com.travelgo.user.util.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TravelerDTO {
    private String nic;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private Date dob;
    private ContactNumber contactNumber;
    private String userName;
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private String nicImage1;
    private String nicImage2;
}
