package com.sandboxol.halloween.a.a;

import android.view.View;
import androidx.core.content.b;
import com.sandboxol.halloween.R;

/* JADX INFO: compiled from: RewardItemAdapter.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static void a(View view, boolean z) {
        if (view != null) {
            try {
                view.setBackground(z ? b.c(view.getContext(), R.mipmap.halloween_bg_reward_item_check) : b.c(view.getContext(), R.mipmap.halloween_bg_reward_item_nor));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
