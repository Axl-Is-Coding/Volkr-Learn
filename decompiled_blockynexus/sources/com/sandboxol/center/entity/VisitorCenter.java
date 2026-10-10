package com.sandboxol.center.entity;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;
import com.google.gson.j;
import com.sandboxol.center.utils.AppSharedUtils;
import com.sandboxol.greendao.entity.Visitor;

/* JADX INFO: loaded from: classes3.dex */
public class VisitorCenter extends BaseObservable {
    private static VisitorCenter instance;
    public ObservableField<Long> userId = new ObservableField<>(0L);
    public ObservableField<String> token = new ObservableField<>("");
    public ObservableField<String> nickName = new ObservableField<>("");

    public static void getVisitorInfo() {
        AppSharedUtils.newInstance().getVisitorInfo();
    }

    public static VisitorCenter newInstance() {
        if (instance == null) {
            instance = new VisitorCenter();
        }
        return instance;
    }

    public static synchronized void putVisitorInfo() {
        if (instance != null) {
            AppSharedUtils.newInstance().putVisitorInfo(new j().a(instance));
        } else {
            AppSharedUtils.newInstance().putVisitorInfo(null);
        }
    }

    public static void setInstance(VisitorCenter visitorCenter) {
        instance = visitorCenter;
    }

    public static void updateVisitorInfo(Visitor visitor) {
        instance.setUserId(visitor.getId());
        instance.setToken(visitor.getAccessToken());
        instance.setNickName(visitor.getNickName());
        putVisitorInfo();
    }

    public void setNickName(String str) {
        this.nickName.set(str);
    }

    public void setToken(String str) {
        this.token.set(str);
    }

    public void setUserId(long j) {
        this.userId.set(Long.valueOf(j));
    }
}
