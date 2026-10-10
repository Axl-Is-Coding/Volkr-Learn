package com.sandboxol.center.entity;

import com.sandboxol.center.R;
import com.sandboxol.common.base.app.BaseApplication;

/* JADX INFO: loaded from: classes3.dex */
public class TribeClanMembersBean {
    private String headPic;
    private int role;
    private long userId;

    public int getColor() {
        return this.role == 20 ? -16711936 : -65536;
    }

    public String getHeadPic() {
        return this.headPic;
    }

    public int getRole() {
        return this.role;
    }

    public String getStringRole() {
        int i = this.role;
        return i == 20 ? BaseApplication.getContext().getString(R.string.tribe_chief) : i == 10 ? BaseApplication.getContext().getString(R.string.tribe_elder) : BaseApplication.getContext().getString(R.string.tribe_member);
    }

    public long getUserId() {
        return this.userId;
    }

    public void setHeadPic(String str) {
        this.headPic = str;
    }

    public void setRole(int i) {
        this.role = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
