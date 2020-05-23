package com.wujq.util;

import java.io.Serializable;
import java.util.List;

public class GetIds<T> implements Serializable {

    public List<T> getIds() {
        return ids;
    }

    public void setIds(List<T> ids) {
        this.ids = ids;
    }

    private List<T> ids;
}
