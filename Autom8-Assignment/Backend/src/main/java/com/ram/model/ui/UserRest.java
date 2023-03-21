package com.ram.model.ui;

import com.ram.entity.RoleType;
import com.ram.entity.VMs;

import java.util.List;

public class UserRest
{
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile_no;
	private RoleType roleType;

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public List<VMs> getvMsList() {
		return vMsList;
	}

	public void setvMsList(List<VMs> vMsList) {
		this.vMsList = vMsList;
	}

	private List<VMs> vMsList;

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

}
