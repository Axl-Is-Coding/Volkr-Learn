package com.disabngo.blockynexus.e.b.M;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

/* JADX INFO: compiled from: IncomeModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public boolean a(Context context, String str) {
        try {
            ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Label", str));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
