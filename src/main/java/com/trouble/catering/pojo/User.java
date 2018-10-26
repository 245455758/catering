package com.trouble.catering.pojo;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String telephone;

    private String role;

    private Integer isvalidate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public Integer getIsvalidate() {
        return isvalidate;
    }

    public void setIsvalidate(Integer isvalidate) {
        this.isvalidate = isvalidate;
    }

	public User(String username, String password, String telephone, String role, Integer isvalidate) {
		super();
		this.username = username;
		this.password = password;
		this.telephone = telephone;
		this.role = role;
		this.isvalidate = isvalidate;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", telephone=" + telephone
				+ ", role=" + role + ", isvalidate=" + isvalidate + "]";
	}
    
    
}