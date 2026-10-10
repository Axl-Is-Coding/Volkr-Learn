package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class x implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f3832a;

    x(u uVar) {
        this.f3832a = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.f3832a.h[0].equals(view.getTag())) {
            if (!this.f3832a.h[1].equals(view.getTag())) {
                com.alibaba.sdk.android.feedback.xblink.i.g.e("WXPhoto", "take photo cancel, and callback.");
                this.f3832a.f3828e.b(new com.alibaba.sdk.android.feedback.xblink.f.m());
                return;
            }
            com.alibaba.sdk.android.feedback.xblink.i.g.a("WXPhoto", "start to pick photo from system album.");
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (((com.alibaba.sdk.android.feedback.xblink.f.a) this.f3832a).f3802a instanceof Activity) {
                ((Activity) ((com.alibaba.sdk.android.feedback.xblink.f.a) this.f3832a).f3802a).startActivityForResult(intent, 4002);
            }
            if (this.f3832a.g != null) {
                this.f3832a.g.b();
                return;
            }
            return;
        }
        com.alibaba.sdk.android.feedback.xblink.i.g.a("WXPhoto", "start to open system camera.");
        if (androidx.core.content.b.a(com.alibaba.sdk.android.feedback.a.b.n(), "android.permission.CAMERA") != 0) {
            Toast.makeText(com.alibaba.sdk.android.feedback.a.b.n(), "Camera Permission Denied", 0).show();
            return;
        }
        Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
        File file = new File(com.alibaba.sdk.android.feedback.util.j.f3722a);
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
        u uVar = this.f3832a;
        StringBuilder sb = new StringBuilder();
        sb.append(com.alibaba.sdk.android.feedback.util.j.f3722a);
        sb.append(File.separator);
        sb.append(com.alibaba.sdk.android.feedback.xblink.i.b.a("" + System.currentTimeMillis()));
        uVar.f3829f = sb.toString();
        intent2.putExtra("output", u.a(((com.alibaba.sdk.android.feedback.xblink.f.a) this.f3832a).f3802a, new File(this.f3832a.f3829f)));
        if (((com.alibaba.sdk.android.feedback.xblink.f.a) this.f3832a).f3802a instanceof Activity) {
            ((Activity) ((com.alibaba.sdk.android.feedback.xblink.f.a) this.f3832a).f3802a).startActivityForResult(intent2, 4001);
            if (this.f3832a.g != null) {
                this.f3832a.g.b();
            }
        }
    }
}
