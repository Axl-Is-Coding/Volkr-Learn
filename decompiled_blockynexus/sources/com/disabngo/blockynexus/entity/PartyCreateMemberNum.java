package com.disabngo.blockynexus.entity;

import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.app.BaseApplication;

/* JADX INFO: loaded from: classes2.dex */
public class PartyCreateMemberNum {
    private boolean isVip;
    private int memberNum;

    public PartyCreateMemberNum(int i, boolean z) {
        this.memberNum = i;
        this.isVip = z;
    }

    public int getMemberNum() {
        return this.memberNum;
    }

    public String getPartyMemberNum() {
        return BaseApplication.getContext().getString(R.string.party_create_party_room_member_num, Integer.valueOf(this.memberNum));
    }

    public boolean isVip() {
        return this.isVip;
    }

    public void setMemberNum(int i) {
        this.memberNum = i;
    }

    public void setVip(boolean z) {
        this.isVip = z;
    }
}
