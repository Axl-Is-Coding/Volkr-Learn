package com.sandboxol.common.binding.adapter;

import androidx.databinding.ObservableField;
import com.sandboxol.common.widget.TimeCountDownView;

/* JADX INFO: loaded from: classes3.dex */
public class TimeCountDownAdapters {
    public static void initTime(TimeCountDownView timeCountDownView, ObservableField<Long> observableField, int i, int i2, int i3, boolean z, TimeCountDownView.OnTimeOver onTimeOver) {
        if (timeCountDownView == null || observableField.get().longValue() == -1) {
            return;
        }
        timeCountDownView.setTime(observableField.get().longValue(), i, i2, i3, z, onTimeOver);
    }
}
