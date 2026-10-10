package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes.dex */
class v implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f3830a;

    v(u uVar) {
        this.f3830a = uVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @Override // android.content.DialogInterface.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.content.DialogInterface r5, int r6) {
        /*
            r4 = this;
            if (r6 != 0) goto L92
            android.content.Intent r5 = new android.content.Intent
            java.lang.String r6 = "android.media.action.IMAGE_CAPTURE"
            r5.<init>(r6)
            java.io.File r6 = new java.io.File
            java.lang.String r0 = com.alibaba.sdk.android.feedback.util.j.f3722a
            r6.<init>(r0)
            boolean r0 = r6.exists()
            if (r0 != 0) goto L1a
        L16:
            r6.mkdirs()
            goto L24
        L1a:
            boolean r0 = r6.isDirectory()
            if (r0 != 0) goto L24
            r6.delete()
            goto L16
        L24:
            com.alibaba.sdk.android.feedback.xblink.f.a.u r6 = r4.f3830a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.alibaba.sdk.android.feedback.util.j.f3722a
            r0.append(r1)
            java.lang.String r1 = java.io.File.separator
            r0.append(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ""
            r1.append(r2)
            long r2 = java.lang.System.currentTimeMillis()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = com.alibaba.sdk.android.feedback.xblink.i.b.a(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.alibaba.sdk.android.feedback.xblink.f.a.u.a(r6, r0)
            java.io.File r6 = new java.io.File
            com.alibaba.sdk.android.feedback.xblink.f.a.u r0 = r4.f3830a
            java.lang.String r0 = com.alibaba.sdk.android.feedback.xblink.f.a.u.a(r0)
            r6.<init>(r0)
            android.net.Uri r6 = android.net.Uri.fromFile(r6)
            java.lang.String r0 = "output"
            r5.putExtra(r0, r6)
            com.alibaba.sdk.android.feedback.xblink.f.a.u r6 = r4.f3830a
            r0 = 0
            com.alibaba.sdk.android.feedback.xblink.f.a.u.a(r6, r0, r5)
            com.alibaba.sdk.android.feedback.xblink.f.a.u r6 = r4.f3830a
            android.content.Context r6 = com.alibaba.sdk.android.feedback.xblink.f.a.u.b(r6)
            boolean r6 = r6 instanceof android.app.Activity
            if (r6 == 0) goto Lb4
            com.alibaba.sdk.android.feedback.xblink.f.a.u r6 = r4.f3830a
            android.content.Context r6 = com.alibaba.sdk.android.feedback.xblink.f.a.u.c(r6)
            android.app.Activity r6 = (android.app.Activity) r6
            r0 = 4001(0xfa1, float:5.607E-42)
            r6.startActivityForResult(r5, r0)
            com.alibaba.sdk.android.feedback.xblink.f.a.u r5 = r4.f3830a
            com.alibaba.sdk.android.feedback.xblink.view.a r5 = com.alibaba.sdk.android.feedback.xblink.f.a.u.d(r5)
            if (r5 == 0) goto Lb4
            goto Lab
        L92:
            r5 = 1
            if (r6 != r5) goto Lb4
            android.content.Intent r6 = new android.content.Intent
            android.net.Uri r0 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            java.lang.String r1 = "android.intent.action.PICK"
            r6.<init>(r1, r0)
            com.alibaba.sdk.android.feedback.xblink.f.a.u r0 = r4.f3830a
            com.alibaba.sdk.android.feedback.xblink.f.a.u.a(r0, r5, r6)
            com.alibaba.sdk.android.feedback.xblink.f.a.u r5 = r4.f3830a
            com.alibaba.sdk.android.feedback.xblink.view.a r5 = com.alibaba.sdk.android.feedback.xblink.f.a.u.d(r5)
            if (r5 == 0) goto Lb4
        Lab:
            com.alibaba.sdk.android.feedback.xblink.f.a.u r5 = r4.f3830a
            com.alibaba.sdk.android.feedback.xblink.view.a r5 = com.alibaba.sdk.android.feedback.xblink.f.a.u.d(r5)
            r5.b()
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.a.v.onClick(android.content.DialogInterface, int):void");
    }
}
