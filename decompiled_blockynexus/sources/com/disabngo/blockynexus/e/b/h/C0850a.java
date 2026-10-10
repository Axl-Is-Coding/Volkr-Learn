package com.disabngo.blockynexus.e.b.h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.widget.rv.IListLayout;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.h.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CampaignIntegralRewardDataListLayout.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0850a implements IListLayout {
    @Override // com.sandboxol.common.widget.rv.IListLayout
    public ViewDataBinding bind(Context context, ViewGroup viewGroup, boolean z) {
        return e.a(LayoutInflater.from(context), R.layout.campaign_integral_reward_data_list_view, viewGroup, z);
    }
}
