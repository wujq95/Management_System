package com.wujq.domain;

public class Rlm {

    @Override
    public String toString() {
        return "Rlm{" +
                "rlm_id=" + rlm_id +
                ", fk_role_id=" + fk_role_id +
                ", fk_menu_id=" + fk_menu_id +
                ", menu=" + menu +
                '}';
    }

    private Integer rlm_id;
    private Integer fk_role_id;
    private Integer fk_menu_id;
    private Menu menu;
    public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

    public Integer getRlm_id() {
        return rlm_id;
    }

    public void setRlm_id(Integer rlm_id) {
        this.rlm_id = rlm_id;
    }

    public Integer getFk_role_id() {
        return fk_role_id;
    }

    public void setFk_role_id(Integer fk_role_id) {
        this.fk_role_id = fk_role_id;
    }

    public Integer getFk_menu_id() {
        return fk_menu_id;
    }

    public void setFk_menu_id(Integer fk_menu_id) {
        this.fk_menu_id = fk_menu_id;
    }
}