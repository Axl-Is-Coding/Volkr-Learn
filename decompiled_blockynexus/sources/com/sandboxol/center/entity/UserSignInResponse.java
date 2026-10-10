package com.sandboxol.center.entity;

import android.content.Context;
import androidx.databinding.BaseObservable;
import com.sandboxol.center.R;
import com.sandboxol.common.base.app.BaseApplication;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class UserSignInResponse extends BaseObservable {
    private long remainingTime;
    private int signInStatus;
    private List<UserSignInList> userSignInList;

    public long getRemainingTime() {
        return this.remainingTime;
    }

    public int getSignInStatus() {
        return this.signInStatus;
    }

    public String getSignInStatusText() {
        Context context;
        int i;
        if (this.signInStatus == 0) {
            context = BaseApplication.getContext();
            i = R.string.sign_in_get;
        } else {
            context = BaseApplication.getContext();
            i = R.string.sign_in_has_get;
        }
        return context.getString(i);
    }

    public List<UserSignInList> getUserSignInList() {
        return this.userSignInList;
    }

    public void setRemainingTime(long j) {
        this.remainingTime = j;
    }

    public void setSignInStatus(int i) {
        this.signInStatus = i;
        notifyChange();
    }

    public void setUserSignInList(List<UserSignInList> list) {
        this.userSignInList = list;
    }
}
