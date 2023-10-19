package com.travelgo.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.travelgo.user.entity.embeded.ContactNumber;
import com.travelgo.user.util.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Traveler {
    @Id
    private String travelId;
    private String nic;
    private String firstName;
    private String lastName;
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dob;
    @Embedded
    private ContactNumber contactNumber;
    private String userName;
    private String password;
    @Column(columnDefinition ="TINYINT")
    private boolean isAccountNonExpired;
    @Column(columnDefinition ="TINYINT")
    private boolean isAccountNonLocked;
    @Column(columnDefinition ="TINYINT")
    private boolean isCredentialsNonExpired;
    @Column(columnDefinition ="TINYINT")
    private boolean isEnabled;
    private String nicImage1;
    private String nicImage2;
}
