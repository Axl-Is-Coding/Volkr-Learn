package com.sandboxol.gamedetail.c.a.a;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import com.sandboxol.center.web.error.GameOnError;
import com.sandboxol.common.R;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: GameDetailModel.java */
/* JADX INFO: loaded from: classes3.dex */
class Y extends OnResponseListener<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f17960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Z f17961b;

    Y(Z z, boolean z2) {
        this.f17961b = z;
        this.f17960a = z2;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GameOnError.showErrorTip(this.f17961b.f17962a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f17961b.f17962a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(String str) {
        TextView textView = (TextView) ((Activity) this.f17961b.f17962a).findViewById(R.id.tvTip);
        if (textView != null) {
            if (this.f17960a) {
                this.f17961b.a(0);
            }
            if (TextUtils.isEmpty(str)) {
                textView.setText(this.f17961b.f17962a.getString(com.sandboxol.gamedetail.R.string.gamedetail_ads_reward_tip));
            } else {
                textView.setText(this.f17961b.f17962a.getString(com.sandboxol.gamedetail.R.string.gamedetail_ads_get_reward, str));
            }
        }
    }
}
