package com.sandboxol.imchat.server.network.async;

/* JADX INFO: loaded from: classes4.dex */
public class AsyncResult {
    private boolean isCheckNetwork;
    private OnDataListener listener;
    private int requestCode;
    private Object result;
    private int state;

    public AsyncResult() {
    }

    public OnDataListener getListener() {
        return this.listener;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public Object getResult() {
        return this.result;
    }

    public int getState() {
        return this.state;
    }

    public boolean isCheckNetwork() {
        return this.isCheckNetwork;
    }

    public void setCheckNetwork(boolean z) {
        this.isCheckNetwork = z;
    }

    public void setListener(OnDataListener onDataListener) {
        this.listener = onDataListener;
    }

    public void setRequestCode(int i) {
        this.requestCode = i;
    }

    public void setResult(Object obj) {
        this.result = obj;
    }

    public void setState(int i) {
        this.state = i;
    }

    public AsyncResult(int i, boolean z, OnDataListener onDataListener) {
        this.requestCode = i;
        this.isCheckNetwork = z;
        this.listener = onDataListener;
    }
}
