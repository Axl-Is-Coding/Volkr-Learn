package com.sandboxol.common.binding.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes3.dex */
public class LinearLayoutBindingAdapters {
    public static void LongClick(LinearLayout linearLayout, final ReplyCommand replyCommand) {
        linearLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.sandboxol.common.binding.adapter.c
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return LinearLayoutBindingAdapters.a(replyCommand, view);
            }
        });
    }

    static /* synthetic */ boolean a(ReplyCommand replyCommand, View view) {
        replyCommand.execute();
        return true;
    }

    public static void onIndicator(LinearLayout linearLayout, int i, int i2, int i3, int i4) {
        linearLayout.removeAllViews();
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 == i4) {
                linearLayout.addView(LayoutInflater.from(linearLayout.getContext()).inflate(i, (ViewGroup) null, false));
            } else {
                linearLayout.addView(LayoutInflater.from(linearLayout.getContext()).inflate(i2, (ViewGroup) null, false));
            }
        }
    }
}
