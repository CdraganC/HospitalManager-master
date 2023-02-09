package com.siit.hospital_manager.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="admins")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@EqualsAndHashCode(callSuper = true)
public class Admin extends User {

}
