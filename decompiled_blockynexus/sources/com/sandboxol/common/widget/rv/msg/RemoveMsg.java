package com.sandboxol.common.widget.rv.msg;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RemoveMsg {
    private Object data;
    private int index;
    private REMOVE_MODE mode;

    public enum REMOVE_MODE {
        CLEAR,
        ITEM,
        LIST,
        INDEX
    }

    public static RemoveMsg create(Object obj, int i, REMOVE_MODE remove_mode) {
        RemoveMsg removeMsg = new RemoveMsg();
        removeMsg.setData(obj);
        removeMsg.setIndex(i);
        removeMsg.setMode(remove_mode);
        return removeMsg;
    }

    public static RemoveMsg createClear() {
        return create(null, 0, REMOVE_MODE.CLEAR);
    }

    public static RemoveMsg createIndex(int i) {
        return create(null, i, REMOVE_MODE.INDEX);
    }

    public static RemoveMsg createItem(Object obj) {
        return create(obj, 0, REMOVE_MODE.ITEM);
    }

    public static RemoveMsg createList(List<Object> list) {
        return create(list, 0, REMOVE_MODE.LIST);
    }

    public Object getData() {
        return this.data;
    }

    public int getIndex() {
        return this.index;
    }

    public REMOVE_MODE getMode() {
        return this.mode;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setMode(REMOVE_MODE remove_mode) {
        this.mode = remove_mode;
    }
}
