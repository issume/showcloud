package com.showcloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class SysUser implements Serializable {
    
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String username;
	
	private String password;
	
	private String sex;
	
	private Timestamp birthday;
	
	private String email;
	
	private String contact;
	
	private String onlineState;
	
	private Timestamp lastLoginTime;
	
	private Timestamp lastLogoutTime;
	
	private String userState;
	
	private String salt;
	
	private String createUser;
	
	private Timestamp createDatetime;
	
	private String modifyUser;
	
	private Timestamp modifyDatetimie;

	private String deleteFlag;

}
