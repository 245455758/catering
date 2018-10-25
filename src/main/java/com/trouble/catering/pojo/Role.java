package com.trouble.catering.pojo;

import java.io.Serializable;

public class Role  implements Serializable{
    private Integer id;

    private String name;

    private String desc;

    private String rights;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights == null ? null : rights.trim();
    }

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", desc=" + desc + ", rights=" + rights + "]";
	}

	public Role(String name, String desc, String rights) {
		super();
		this.name = name;
		this.desc = desc;
		this.rights = rights;
	}

	public Role() {
		super();
	}
    
    
}