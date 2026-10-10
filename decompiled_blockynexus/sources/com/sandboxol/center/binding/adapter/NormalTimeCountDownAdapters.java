package com.sandboxol.center.binding.adapter;

import androidx.databinding.ObservableField;
import com.sandboxol.center.view.widget.counDownView.NormalCountDownTimer;
import com.sandboxol.center.view.widget.counDownView.NormalCountDownView;

/* JADX INFO: loaded from: classes3.dex */
public class NormalTimeCountDownAdapters {
    public static void initTime(NormalCountDownView normalCountDownView, int i, int i2, int i3, boolean z, NormalCountDownTimer normalCountDownTimer, ObservableField<Integer> observableField) {
        if (normalCountDownView != null) {
            normalCountDownView.bindFormat(i, i2, i3, z);
            normalCountDownView.onBindCountDownTimer(normalCountDownTimer);
        }
    }
}
