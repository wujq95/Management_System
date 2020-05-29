package com.wujq.domain;

public class User {

    private Integer user_id;
    private String user_name;
    private String user_account;
    private String user_password;
    private Integer user_status;
    private Integer fk_role_id;
    private String user_img;
    private Role role;
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account == null ? null : user_account.trim();
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password == null ? null : user_password.trim();
    }

    public Integer getUser_status() {
        return user_status;
    }

    public void setUser_status(Integer user_status) {
        this.user_status = user_status;
    }

    public Integer getFk_role_id() {
        return fk_role_id;
    }

    public void setFk_role_id(Integer fk_role_id) {
        this.fk_role_id = fk_role_id;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img == null ? null : user_img.trim();
    }

    @Override
    public String toString() {
        return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_account=" + user_account
                + ", user_password=" + user_password + ", user_status=" + user_status + ", fk_role_id=" + fk_role_id
                + ", user_img=" + user_img + "]";
    }
}