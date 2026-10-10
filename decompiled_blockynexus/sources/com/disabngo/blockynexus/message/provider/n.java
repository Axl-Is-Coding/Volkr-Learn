package com.disabngo.blockynexus.message.provider;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.message.provider.ScrapHelpProvider;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: compiled from: ScrapHelpProvider.java */
/* JADX INFO: loaded from: classes2.dex */
class n implements com.sandboxol.greendao.a.c<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ScrapHelpProvider.a f10482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f10483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f10484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ScrapHelpProvider f10485d;

    n(ScrapHelpProvider scrapHelpProvider, ScrapHelpProvider.a aVar, View view, long j) {
        this.f10485d = scrapHelpProvider;
        this.f10482a = aVar;
        this.f10483b = view;
        this.f10484c = j;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Friend friend) {
        if (friend == null) {
            this.f10482a.f10439c.setText(this.f10483b.getContext().getString(R.string.scrap_status_received_tips, this.f10483b.getContext().getString(R.string.scrap_friend_tips)));
            return;
        }
        TextView textView = this.f10482a.f10439c;
        Context context = this.f10483b.getContext();
        Object[] objArr = new Object[1];
        objArr[0] = friend.getNickName() == null ? String.valueOf(this.f10484c) : friend.getNickName();
        textView.setText(context.getString(R.string.scrap_status_received_tips, objArr));
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
