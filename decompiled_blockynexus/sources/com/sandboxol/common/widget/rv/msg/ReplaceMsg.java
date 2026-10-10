package com.sandboxol.common.widget.rv.msg;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ReplaceMsg {
    private Object data;

    public static ReplaceMsg create(Object obj) {
        ReplaceMsg replaceMsg = new ReplaceMsg();
        replaceMsg.setData(obj);
        return replaceMsg;
    }

    public List<Object> getData() {
        Object obj = this.data;
        return obj instanceof List ? (List) obj : new ArrayList();
    }

    public void setData(Object obj) {
        if (obj instanceof Iterable) {
            this.data = obj;
        } else {
            this.data = new ArrayList();
        }
    }
}
