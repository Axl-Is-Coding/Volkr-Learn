package com.disabngo.blockynexus.entity;

/* JADX INFO: loaded from: classes2.dex */
public class RequestJoinTribe {
    private int clanId;
    private String msg;

    public RequestJoinTribe(int i, String str) {
        this.clanId = i;
        this.msg = str;
    }

    public int getClanId() {
        return this.clanId;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setClanId(int i) {
        this.clanId = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
