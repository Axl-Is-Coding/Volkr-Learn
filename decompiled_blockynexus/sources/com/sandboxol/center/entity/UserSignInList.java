package com.sandboxol.center.entity;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class UserSignInList {
    private boolean isSelect;
    private int isSpecial;
    private List<SignInReward> rewards;
    private int signInId;
    private int status;

    public int getIsSpecial() {
        return this.isSpecial;
    }

    public List<SignInReward> getRewards() {
        return this.rewards;
    }

    public int getSignInId() {
        return this.signInId;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setIsSpecial(int i) {
        this.isSpecial = i;
    }

    public void setRewards(List<SignInReward> list) {
        this.rewards = list;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public void setSignInId(int i) {
        this.signInId = i;
    }

    public void setStatus(int i) {
        this.status = i;
    }
}
