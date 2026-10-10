package com.sandboxol.common.widget.rv.msg;

/* JADX INFO: loaded from: classes3.dex */
public class InsertMsg {
    private Object data;
    private int index = 0;
    private INSERT_MODE mode;

    public enum INSERT_MODE {
        FIRST,
        END,
        INDEX
    }

    private static InsertMsg create(Object obj, int i, INSERT_MODE insert_mode) {
        InsertMsg insertMsg = new InsertMsg();
        insertMsg.setData(obj);
        insertMsg.setIndex(i);
        insertMsg.setMode(insert_mode);
        return insertMsg;
    }

    public static InsertMsg createEnd(Object obj) {
        return create(obj, 0, INSERT_MODE.END);
    }

    public static InsertMsg createFirst(Object obj) {
        return create(obj, 0, INSERT_MODE.FIRST);
    }

    public static InsertMsg createIndex(Object obj, int i) {
        return create(obj, i, INSERT_MODE.INDEX);
    }

    public Object getData() {
        return this.data;
    }

    public int getIndex() {
        return this.index;
    }

    public INSERT_MODE getMode() {
        return this.mode;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setMode(INSERT_MODE insert_mode) {
        this.mode = insert_mode;
    }
}
