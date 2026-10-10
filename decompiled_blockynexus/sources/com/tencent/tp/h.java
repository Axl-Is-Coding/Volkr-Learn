package com.tencent.tp;

import com.tencent.tp.n;

/* JADX INFO: loaded from: classes5.dex */
class h implements n.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f19699a;

    h(g gVar) {
        this.f19699a = gVar;
    }

    @Override // com.tencent.tp.n.a
    public void a(int i) {
        String str = this.f19699a.f19698c;
        if (this.f19699a.f19698c == null) {
            this.f19699a.f19698c = "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(q.a("hnb_wjs_ydnhdnn:ntn:"));
        sb.append(q.a("|hnb_wjs_dy=") + str);
        sb.append(q.a("|woi_dy=") + i);
        r.a(sb.toString());
    }
}
