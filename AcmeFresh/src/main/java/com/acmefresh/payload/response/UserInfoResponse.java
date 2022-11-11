package com.acmefresh.payload.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInfoResponse {
	
	private Integer id;
	private String username;
	private String email;
	private List<String> roles;
		

}
