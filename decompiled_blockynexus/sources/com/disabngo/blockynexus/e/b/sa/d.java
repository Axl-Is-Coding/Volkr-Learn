package com.disabngo.blockynexus.e.b.sa;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.web.TribeApi;

/* JADX INFO: compiled from: TribeSettingModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    public void a(Context context, int i, ObservableField<Boolean> observableField) {
        observableField.set(false);
        TribeApi.verification(context, i, new c(this, observableField, context));
    }
}
