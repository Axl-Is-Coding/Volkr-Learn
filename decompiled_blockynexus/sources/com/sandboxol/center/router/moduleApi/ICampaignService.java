package com.sandboxol.center.router.moduleApi;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.common.interfaces.OnDataListener;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public interface ICampaignService extends IBaseService {
    void getActivitySignUp(Context context, boolean z);

    void isCampaignHasRedPoint(Context context, ObservableField<Integer> observableField);

    void isGoCampaignRefresh(Context context, ObservableField<Integer> observableField);

    void isShowCampaign(Context context, ObservableField<Boolean> observableField);

    void onGoCampaign(Context context, String str);

    void showResultDialog(Context context, Serializable serializable, OnDataListener onDataListener);
}
