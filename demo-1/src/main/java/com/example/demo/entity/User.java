package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;

public class User extends BaseEntity implements Serializable{

	private Integer uid;
	private String username;
	private String password;
	private String salt;
	private String nickname;
	private String email;
	private Integer isDelete;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(email, isDelete, nickname, password, salt, uid, username);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(isDelete, other.isDelete)
				&& Objects.equals(nickname, other.nickname) && Objects.equals(password, other.password)
				&& Objects.equals(salt, other.salt) && Objects.equals(uid, other.uid)
				&& Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", salt=" + salt
				+ ", nickname=" + nickname + ", email=" + email + ", isDelete=" + isDelete + "]";
	}
	
	
	
	
}
