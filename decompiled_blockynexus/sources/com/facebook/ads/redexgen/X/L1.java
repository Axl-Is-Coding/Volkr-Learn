package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class L1 {
    public static void A00(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, @Nullable Context context) {
        if (context == null || !(context instanceof Activity)) {
            onClickListener.onClick(null, 0);
        } else {
            new AlertDialog.Builder(context).setTitle(C1693Iy.A0T(context)).setMessage(C1693Iy.A0R(context)).setPositiveButton(C1693Iy.A0S(context), new L0(onClickListener)).setNegativeButton(C1693Iy.A0Q(context), new DialogInterfaceOnClickListenerC1741Kz(onClickListener2)).show();
        }
    }
}
