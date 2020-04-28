package com.feng.design.model;

public class User extends BaseVo {
    private String id;
    private String name;
    private String password;
    private String roleId;

    public Boolean getState() {
        return state;
    }

    private Boolean state;

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    private String isDelete;
    public void setState(Boolean state) {
        this.state = state;
    }

    private String createTime;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", roleId='" + roleId + '\'' +
                ", state='" + state + '\'' +
                ", createTime='" + createTime + '\'' +
                ", createAt='" + createAt + '\'' +
                ", loginName='" + loginName + '\'' +
                ", modificationTime='" + modificationTime + '\'' +
                ", modifier='" + modifier + '\'' +
                '}';
    }

    private String createAt;
    private String loginName;
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }




    private String modificationTime;
    private String modifier;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }



    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(String modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }




}
