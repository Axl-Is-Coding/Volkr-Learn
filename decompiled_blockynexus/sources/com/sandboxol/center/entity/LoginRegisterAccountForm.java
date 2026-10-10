package com.sandboxol.center.entity;

import android.content.Context;
import android.os.Build;
import com.sandboxol.common.config.CommonSharedConstant;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.SharedUtils;

/* JADX INFO: loaded from: classes3.dex */
public class LoginRegisterAccountForm implements Cloneable {
    private String appType;
    private String confirmPassword;
    private String deviceId;
    private boolean hasPassword;
    private String imei;
    private int needReward;
    private String os;
    private String password;
    private String platform;
    private String uid;

    public LoginRegisterAccountForm() {
        this.appType = "android";
        this.needReward = 0;
        this.hasPassword = true;
    }

    public String getAppType() {
        return this.appType;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getImei() {
        return this.imei;
    }

    public int getNeedReward() {
        return this.needReward;
    }

    public String getOs() {
        return this.os;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getUid() {
        return this.uid;
    }

    public boolean isHasPassword() {
        return this.hasPassword;
    }

    public int isNeedReward() {
        return this.needReward;
    }

    public void setAppType(String str) {
        this.appType = str;
    }

    public void setConfirmPassword(String str) {
        this.confirmPassword = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setHasPassword(boolean z) {
        this.hasPassword = z;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setNeedReward(int i) {
        this.needReward = i;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LoginRegisterAccountForm m82clone() {
        try {
            return (LoginRegisterAccountForm) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return this;
        }
    }

    public LoginRegisterAccountForm(Context context) throws Throwable {
        this.appType = "android";
        this.needReward = 0;
        this.hasPassword = true;
        String uUId = CommonHelper.getUUId(context);
        if (uUId == null) {
            setImei(CommonHelper.createUUId(context));
        } else if ("".equals(uUId)) {
            setImei(SharedUtils.getString(context, CommonSharedConstant.APP_VISITOR_UUID));
        } else {
            setImei(uUId);
        }
        setOs(Build.VERSION.RELEASE);
        setDeviceId("Android:" + Build.MODEL);
    }

    public LoginRegisterAccountForm(int i) {
        this.appType = "android";
        this.needReward = 0;
        this.hasPassword = true;
        this.needReward = i;
    }
}
