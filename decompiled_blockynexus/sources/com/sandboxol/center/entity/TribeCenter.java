package com.sandboxol.center.entity;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;
import com.sandboxol.center.R;
import com.sandboxol.common.base.app.BaseApplication;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class TribeCenter extends BaseObservable {
    private static TribeCenter instance;
    public ObservableField<Integer> tribeRole = new ObservableField<>(0);
    public ObservableField<Long> tribeClanId = new ObservableField<>(0L);
    public ObservableField<Long> tribeGolds = new ObservableField<>(0L);
    public ObservableField<String> tribeName = new ObservableField<>("");
    public ObservableField<String> tribeHead = new ObservableField<>("");
    public ObservableField<Integer> tribeLevel = new ObservableField<>(0);
    public ObservableField<Integer> verification = new ObservableField<>(0);
    public ObservableField<Long> experience = new ObservableField<>(0L);
    public ObservableField<Integer> currentCount = new ObservableField<>(0);
    public ObservableField<Integer> maxCount = new ObservableField<>(0);

    public static String getCurrentTotalCount(int i, int i2) {
        return i + "/" + i2;
    }

    public static TribeCenter newInstance() {
        if (instance == null) {
            instance = new TribeCenter();
        }
        return instance;
    }

    public String getTribeNameText() {
        return this.tribeName.get() + "(" + BaseApplication.getContext().getString(R.string.tribe_tab_name) + ")";
    }

    public void logout() {
        instance.setTribeClanId(0L);
        instance.setTribeRole(0);
        instance.setTribeGolds(0L);
        instance.setTribeName("");
        instance.setTribeHead("");
        instance.setTribeLevel(0);
        instance.setVerification(0);
        instance.setExperience(0L);
        instance.setCurrentCount(0);
        instance.setMaxCount(0);
    }

    public void setCurrentCount(int i) {
        this.currentCount.set(Integer.valueOf(i));
    }

    public void setExperience(long j) {
        this.experience.set(Long.valueOf(j));
    }

    public void setMaxCount(int i) {
        this.maxCount.set(Integer.valueOf(i));
    }

    public void setTribeClanId(long j) {
        this.tribeClanId.set(Long.valueOf(j));
    }

    public void setTribeGolds(long j) {
        this.tribeGolds.set(Long.valueOf(j));
    }

    public void setTribeHead(String str) {
        this.tribeHead.set(str);
    }

    public void setTribeLevel(int i) {
        this.tribeLevel.set(Integer.valueOf(i));
    }

    public void setTribeName(String str) {
        this.tribeName.set(str);
    }

    public void setTribeRole(int i) {
        this.tribeRole.set(Integer.valueOf(i));
    }

    public void setVerification(int i) {
        this.verification.set(Integer.valueOf(i));
    }

    public void updateBaseInfo(String str, String str2, int i, int i2, Action0 action0) {
        instance.setTribeName(str);
        instance.setTribeHead(str2);
        instance.setTribeLevel(i);
        instance.setVerification(i2);
        if (action0 != null) {
            action0.call();
        }
    }

    public void updateDetailInfo(TribeDetail tribeDetail) {
        instance.setTribeName(tribeDetail.getName());
        instance.setTribeHead(tribeDetail.getHeadPic());
        instance.setTribeLevel(tribeDetail.getLevel());
        instance.setVerification(tribeDetail.getFreeVerify());
        instance.setExperience(tribeDetail.getLongExperience());
        instance.setCurrentCount(tribeDetail.getCurrentCount());
        instance.setMaxCount(tribeDetail.getMaxCount());
    }
}
