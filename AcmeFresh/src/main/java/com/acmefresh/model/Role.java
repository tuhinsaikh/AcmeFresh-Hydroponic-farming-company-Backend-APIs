package com.acmefresh.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	
	@Enumerated(EnumType.STRING)
	private RoleEnum name;

	
}
