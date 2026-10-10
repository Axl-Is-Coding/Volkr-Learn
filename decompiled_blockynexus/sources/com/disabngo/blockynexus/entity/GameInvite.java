package com.disabngo.blockynexus.entity;

/* JADX INFO: loaded from: classes2.dex */
public class GameInvite {
    private String gameType;
    private long inviterId;
    private String inviterName;

    public String getGameType() {
        return this.gameType;
    }

    public long getInviterId() {
        return this.inviterId;
    }

    public String getInviterName() {
        return this.inviterName;
    }

    public void setGameType(String str) {
        this.gameType = str;
    }

    public void setInviterId(long j) {
        this.inviterId = j;
    }

    public void setInviterName(String str) {
        this.inviterName = str;
    }
}
