package com.fmc.model;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="usertab")
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="uid")
	private Integer userId;
	@Column(name="uname")
	private String userName;
	@Column(name="umail")
	private String userEmail;
	@Column(name="upwd")
	private String userPwd;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="roles_tab",joinColumns = @JoinColumn(name="uid"))
	private Set<String> userRole;
	
}
