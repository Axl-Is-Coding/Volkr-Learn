package b.f.d.g;

import org.json.JSONObject;

/* JADX INFO: compiled from: OnOfferWallListener.java */
/* JADX INFO: loaded from: classes2.dex */
public interface e {
    void onGetOWCreditsFailed(String str);

    void onOWAdClosed();

    boolean onOWAdCredited(int i, int i2, boolean z);

    void onOWGeneric(String str, String str2);

    void onOWShowFail(String str);

    void onOWShowSuccess(String str);

    void onOfferwallEventNotificationReceived(String str, JSONObject jSONObject);

    void onOfferwallInitFail(String str);

    void onOfferwallInitSuccess();
}
