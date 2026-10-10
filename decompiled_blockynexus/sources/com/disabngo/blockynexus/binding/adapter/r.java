package com.disabngo.blockynexus.binding.adapter;

import com.disabngo.blockynexus.view.widget.SignInItemView;

/* JADX INFO: compiled from: SignInItemBindAdapters.java */
/* JADX INFO: loaded from: classes.dex */
public class r {
    public static void a(SignInItemView signInItemView, Integer num, int i, int i2, int i3) {
        if (i3 != 0) {
            signInItemView.setType(i3);
        }
        if (i2 != 0) {
            signInItemView.setGiftCount(i2);
        }
        if (i != 0) {
            signInItemView.setTitleText(i);
        }
        signInItemView.setState(num == null ? 0 : num.intValue());
    }
}
