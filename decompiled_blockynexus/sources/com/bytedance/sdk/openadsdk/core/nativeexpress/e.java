package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.d.d;
import com.bytedance.sdk.openadsdk.utils.ac;

/* JADX INFO: compiled from: ExpressClickListener.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends com.bytedance.sdk.openadsdk.core.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.d.f f6303a;

    public e(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, int i) {
        super(context, hVar, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.b
    protected com.bytedance.sdk.openadsdk.core.d.d a(int i, int i2, int i3, int i4, long j, long j2, View view, View view2) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int i5;
        int i6;
        long j3;
        long j4;
        this.x = 1;
        this.y = 0;
        this.z = 0;
        int[] iArrA = ac.a(view);
        if (iArrA == null || iArrA.length != 2) {
            iA = i;
            iA2 = i2;
            iA3 = i3;
            iA4 = i4;
            i5 = 0;
            i6 = 0;
        } else {
            i5 = iArrA[0];
            i6 = iArrA[1];
            iA = ((int) ac.a(this.f6003c, i)) + i5;
            iA2 = ((int) ac.a(this.f6003c, i2)) + i6;
            iA3 = ((int) ac.a(this.f6003c, i3)) + i5;
            iA4 = ((int) ac.a(this.f6003c, i4)) + i6;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        com.bytedance.sdk.openadsdk.core.d.f fVar = this.f6303a;
        if (fVar != null) {
            j3 = fVar.f6092e;
            j4 = fVar.f6093f;
            iArr[0] = ((int) ac.a(this.f6003c, fVar.g)) + i5;
            iArr[1] = ((int) ac.a(this.f6003c, this.f6303a.h)) + i6;
            int iA5 = (int) ac.a(this.f6003c, this.f6303a.i);
            int iA6 = (int) ac.a(this.f6003c, this.f6303a.j);
            iArr2[0] = iA5;
            iArr2[1] = iA6;
        } else {
            j3 = j;
            j4 = j2;
        }
        return new d.a().d(iA).c(iA2).b(iA3).a(iA4).b(j3).a(j4).b(iArrA).a(iArr).c(ac.c(view)).d(iArr2).e(this.x).f(this.y).g(this.z).a();
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.f fVar) {
        this.f6303a = fVar;
    }
}
