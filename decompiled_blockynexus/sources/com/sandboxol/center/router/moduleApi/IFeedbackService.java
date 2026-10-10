package com.sandboxol.center.router.moduleApi;

import androidx.databinding.ObservableField;

/* JADX INFO: loaded from: classes3.dex */
public interface IFeedbackService extends IBaseService {
    void getUnReadCount();

    ObservableField<Integer> getUnReadCountFiled();

    void openFeedbackActivity();

    void setUI(int i, String str, String str2);
}
