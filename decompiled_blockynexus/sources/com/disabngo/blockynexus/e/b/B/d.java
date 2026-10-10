package com.disabngo.blockynexus.e.b.B;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: GroupChatItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class d extends com.disabngo.blockynexus.adapter.e<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f9111a;

    d(e eVar) {
        this.f9111a = eVar;
    }

    @Override // com.disabngo.blockynexus.adapter.e
    public void a(Context context, ImageView imageView, String str) {
        if (TextUtils.isEmpty(str)) {
            com.bumptech.glide.c.c(context).mo53load(Integer.valueOf(R.mipmap.ic_head_default)).into(imageView);
        } else {
            com.bumptech.glide.c.c(context).mo55load(str).into(imageView);
        }
    }

    @Override // com.disabngo.blockynexus.adapter.e
    public ImageView a(Context context) {
        return super.a(context);
    }
}
