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

    /**
     * 获取  字段:user.user_id
     *
     * @return  user.user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * 设置  字段:user.user_id
     *
     * @param user_id  user.user_id
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * 获取  字段:user.user_name
     *
     * @return  user.user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * 设置  字段:user.user_name
     *
     * @param user_name  user.user_name
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    /**
     * 获取  字段:user.user_account
     *
     * @return  user.user_account
     */
    public String getUser_account() {
        return user_account;
    }

    /**
     * 设置  字段:user.user_account
     *
     * @param user_account  user.user_account
     */
    public void setUser_account(String user_account) {
        this.user_account = user_account == null ? null : user_account.trim();
    }

    /**
     * 获取  字段:user.user_password
     *
     * @return  user.user_password
     */
    public String getUser_password() {
        return user_password;
    }

    /**
     * 设置  字段:user.user_password
     *
     * @param user_password  user.user_password
     */
    public void setUser_password(String user_password) {
        this.user_password = user_password == null ? null : user_password.trim();
    }

    /**
     * 获取  字段:user.user_status
     *
     * @return  user.user_status
     */
    public Integer getUser_status() {
        return user_status;
    }

    /**
     * 设置  字段:user.user_status
     *
     * @param user_status  user.user_status
     */
    public void setUser_status(Integer user_status) {
        this.user_status = user_status;
    }

    /**
     * 获取  字段:user.fk_role_id
     *
     * @return  user.fk_role_id
     */
    public Integer getFk_role_id() {
        return fk_role_id;
    }

    /**
     * 设置  字段:user.fk_role_id
     *
     * @param fk_role_id  user.fk_role_id
     */
    public void setFk_role_id(Integer fk_role_id) {
        this.fk_role_id = fk_role_id;
    }

    /**
     * 获取  字段:user.user_img
     *
     * @return  user.user_img
     */
    public String getUser_img() {
        return user_img;
    }

    /**
     * 设置  字段:user.user_img
     *
     * @param user_img  user.user_img
     */
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