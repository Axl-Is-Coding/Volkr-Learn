package com.android.volley.toolbox;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.l;

/* JADX INFO: compiled from: NetworkImageView.java */
/* JADX INFO: loaded from: classes.dex */
class o implements l.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f4067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ NetworkImageView f4068b;

    o(NetworkImageView networkImageView, boolean z) {
        this.f4068b = networkImageView;
        this.f4067a = z;
    }

    @Override // com.android.volley.m.a
    public void onErrorResponse(VolleyError volleyError) {
        if (this.f4068b.mErrorImageId != 0) {
            NetworkImageView networkImageView = this.f4068b;
            networkImageView.setImageResource(networkImageView.mErrorImageId);
        }
    }
}
