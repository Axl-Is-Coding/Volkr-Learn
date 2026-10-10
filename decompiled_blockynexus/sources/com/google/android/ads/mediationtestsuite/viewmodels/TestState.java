package com.google.android.ads.mediationtestsuite.viewmodels;

import com.google.android.ads.mediationtestsuite.R;

/* JADX INFO: loaded from: classes.dex */
public enum TestState {
    ERROR(0, R.drawable.gmts_quantum_ic_error_white_24, R.color.gmts_error, R.color.gmts_error_bg, R.string.gmts_not_found),
    WARNING(1, R.drawable.gmts_quantum_ic_warning_white_24, R.color.gmts_warning, R.color.gmts_warning_bg, R.string.gmts_not_found),
    OK(2, R.drawable.gmts_quantum_ic_check_circle_white_24, R.color.gmts_ok, R.color.gmts_ok_bg, R.string.gmts_found);

    private final int backgroundColorResId;
    private final int drawableResourceId;
    private final int existenceMessageResId;
    private final int imageTintColorResId;
    private final int orderValue;

    TestState(int i, int i2, int i3, int i4, int i5) {
        this.drawableResourceId = i2;
        this.imageTintColorResId = i3;
        this.backgroundColorResId = i4;
        this.orderValue = i;
        this.existenceMessageResId = i5;
    }

    public int getBackgroundColorResId() {
        return this.backgroundColorResId;
    }

    public int getDrawableResourceId() {
        return this.drawableResourceId;
    }

    public int getExistenceMessageResId() {
        return this.existenceMessageResId;
    }

    public int getImageTintColorResId() {
        return this.imageTintColorResId;
    }

    public int getOrderValue() {
        return this.orderValue;
    }
}
