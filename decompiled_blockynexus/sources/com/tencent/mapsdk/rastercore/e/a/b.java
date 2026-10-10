package com.tencent.mapsdk.rastercore.e.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
final class b extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f19553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f19554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f19555c;

    public b(Context context, String str, String str2) {
        super(context);
        this.f19555c = context.getApplicationContext();
        setOrientation(1);
        if (str != null && !str.isEmpty()) {
            this.f19553a = new TextView(context);
            this.f19553a.setText(str);
            this.f19553a.setTextColor(-16777216);
            addView(this.f19553a);
        }
        if (str2 != null && !str2.isEmpty()) {
            this.f19554b = new TextView(context);
            this.f19554b.setTextColor(-16777216);
            this.f19554b.setText(str2);
            addView(this.f19554b);
        }
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = this.f19555c.getAssets().open("infowindow_bg.9.png");
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
            byte[] ninePatchChunk = bitmapDecodeStream.getNinePatchChunk();
            Rect rect = new Rect();
            rect.left = com.tencent.mapsdk.rastercore.c.a(ninePatchChunk, 12);
            rect.right = com.tencent.mapsdk.rastercore.c.a(ninePatchChunk, 16);
            rect.top = com.tencent.mapsdk.rastercore.c.a(ninePatchChunk, 20);
            rect.bottom = com.tencent.mapsdk.rastercore.c.a(ninePatchChunk, 24);
            setBackgroundDrawable(new NinePatchDrawable(this.f19555c.getResources(), bitmapDecodeStream, ninePatchChunk, rect, null));
        } catch (Exception unused) {
        } finally {
            com.tencent.mapsdk.rastercore.c.a((Closeable) inputStreamOpen);
        }
    }

    public final void a(String str, String str2) {
        if (str == null || str.isEmpty()) {
            TextView textView = this.f19553a;
            if (textView != null) {
                removeView(textView);
                this.f19553a = null;
            }
        } else {
            if (this.f19553a == null) {
                this.f19553a = new TextView(this.f19555c);
                this.f19553a.setText(str);
                this.f19553a.setTextColor(-16777216);
                addView(this.f19553a);
            }
            this.f19553a.setText(str);
        }
        if (str2 == null || str2.isEmpty()) {
            TextView textView2 = this.f19554b;
            if (textView2 != null) {
                removeView(textView2);
                this.f19554b = null;
                return;
            }
            return;
        }
        if (this.f19554b == null) {
            this.f19554b = new TextView(this.f19555c);
            this.f19554b.setTextColor(-16777216);
            this.f19554b.setText(str2);
            addView(this.f19554b);
        }
        this.f19554b.setText(str2);
    }
}
