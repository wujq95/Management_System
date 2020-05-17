/**
 * Menu.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2019-08-20 09:19:29
 **/
package com.wujq.domain;

/**
 * menu 类
 * @Description : 
 * 
 * @author 胖先生
 * @version 1.0 
 * 文件创建于: 2019-08-20 09:19:29
 **/
public class Menu {

    private Integer menu_id;
    private String menu_name;
    private String menu_url;
    private Integer father_menu;

    /**
     * 获取  字段:menu.menu_id
     *
     * @return  menu.menu_id
     */
    public Integer getMenu_id() {
        return menu_id;
    }

    /**
     * 设置  字段:menu.menu_id
     *
     * @param menu_id  menu.menu_id
     */
    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    /**
     * 获取  字段:menu.menu_name
     *
     * @return  menu.menu_name
     */
    public String getMenu_name() {
        return menu_name;
    }

    /**
     * 设置  字段:menu.menu_name
     *
     * @param menu_name  menu.menu_name
     */
    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name == null ? null : menu_name.trim();
    }

    /**
     * 获取  字段:menu.menu_url
     *
     * @return  menu.menu_url
     */
    public String getMenu_url() {
        return menu_url;
    }

    /**
     * 设置  字段:menu.menu_url
     *
     * @param menu_url  menu.menu_url
     */
    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url == null ? null : menu_url.trim();
    }

    /**
     * 获取  字段:menu.father_menu
     *
     * @return  menu.father_menu
     */
    public Integer getFather_menu() {
        return father_menu;
    }

    /**
     * 设置  字段:menu.father_menu
     *
     * @param father_menu  menu.father_menu
     */
    public void setFather_menu(Integer father_menu) {
        this.father_menu = father_menu;
    }
}