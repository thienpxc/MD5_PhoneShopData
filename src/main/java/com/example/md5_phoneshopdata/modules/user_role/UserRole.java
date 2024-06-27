package com.example.md5_phoneshopdata.modules.user_role;

import com.example.md5_phoneshopdata.modules.role.Role;
import com.example.md5_phoneshopdata.modules.users.Users;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.internal.build.AllowNonPortable;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllowNonPortable
@Setter
@Getter


public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userId;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleId;
    private Date created_at;
    private Date updated_at;
    private Boolean status;


}