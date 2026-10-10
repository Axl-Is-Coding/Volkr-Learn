package com.sandboxol.imchat.server.network.async;

/* JADX INFO: loaded from: classes4.dex */
public class AsyncRequest {
    private String id;
    private boolean isCheckNetwork;
    private OnDataListener listener;
    private int requestCode;

    public AsyncRequest() {
    }

    public String getId() {
        return this.id;
    }

    public OnDataListener getListener() {
        return this.listener;
    }

    public int getRequestCode() {
        return this.requestCode;
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

    public AsyncRequest(int i, boolean z, OnDataListener onDataListener) {
        this.requestCode = i;
        this.isCheckNetwork = z;
        this.listener = onDataListener;
    }

    public AsyncRequest(String str, int i, boolean z, OnDataListener onDataListener) {
        this.requestCode = i;
        this.isCheckNetwork = z;
        this.listener = onDataListener;
        this.id = str;
    }
}
