package com.wujq.domain;

public class Menu {

    private Integer menu_id;
    private String menu_name;
    private String menu_url;

    @Override
    public String toString() {
        return "Menu{" +
                "menu_id=" + menu_id +
                ", menu_name='" + menu_name + '\'' +
                ", menu_url='" + menu_url + '\'' +
                ", father_menu=" + father_menu +
                '}';
    }

    private Integer father_menu;

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name == null ? null : menu_name.trim();
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url == null ? null : menu_url.trim();
    }

    public Integer getFather_menu() {
        return father_menu;
    }

    public void setFather_menu(Integer father_menu) {
        this.father_menu = father_menu;
    }
}