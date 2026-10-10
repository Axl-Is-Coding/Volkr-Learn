package com.android.volley.toolbox;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.android.volley.toolbox.l;

/* JADX INFO: loaded from: classes.dex */
public class NetworkImageView extends ImageView {
    private int mDefaultImageId;
    private int mErrorImageId;
    private l.a mImageContainer;
    private l mImageLoader;
    private String mUrl;

    public NetworkImageView(Context context) {
        this(context, null);
    }

    private void setDefaultImageOrNull() {
        int i = this.mDefaultImageId;
        if (i != 0) {
            setImageResource(i);
        } else {
            setImageBitmap(null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void loadImageIfNecessary(boolean r10) {
        /*
            r9 = this;
            int r0 = r9.getWidth()
            int r1 = r9.getHeight()
            android.widget.ImageView$ScaleType r7 = r9.getScaleType()
            android.view.ViewGroup$LayoutParams r2 = r9.getLayoutParams()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L2a
            android.view.ViewGroup$LayoutParams r2 = r9.getLayoutParams()
            int r2 = r2.width
            r5 = -2
            if (r2 != r5) goto L1f
            r2 = 1
            goto L20
        L1f:
            r2 = 0
        L20:
            android.view.ViewGroup$LayoutParams r6 = r9.getLayoutParams()
            int r6 = r6.height
            if (r6 != r5) goto L2b
            r5 = 1
            goto L2c
        L2a:
            r2 = 0
        L2b:
            r5 = 0
        L2c:
            if (r2 == 0) goto L31
            if (r5 == 0) goto L31
            goto L32
        L31:
            r3 = 0
        L32:
            if (r0 != 0) goto L39
            if (r1 != 0) goto L39
            if (r3 != 0) goto L39
            return
        L39:
            java.lang.String r3 = r9.mUrl
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            r8 = 0
            if (r3 == 0) goto L4e
            com.android.volley.toolbox.l$a r10 = r9.mImageContainer
            if (r10 != 0) goto L4a
            r9.setDefaultImageOrNull()
            return
        L4a:
            r10.a()
            throw r8
        L4e:
            com.android.volley.toolbox.l$a r3 = r9.mImageContainer
            if (r3 != 0) goto L68
            if (r2 == 0) goto L55
            r0 = 0
        L55:
            if (r5 == 0) goto L59
            r6 = 0
            goto L5a
        L59:
            r6 = r1
        L5a:
            com.android.volley.toolbox.l r2 = r9.mImageLoader
            java.lang.String r3 = r9.mUrl
            com.android.volley.toolbox.o r4 = new com.android.volley.toolbox.o
            r4.<init>(r9, r10)
            r5 = r0
            r2.a(r3, r4, r5, r6, r7)
            throw r8
        L68:
            r3.b()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.NetworkImageView.loadImageIfNecessary(boolean):void");
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        l.a aVar = this.mImageContainer;
        if (aVar == null) {
            super.onDetachedFromWindow();
        } else {
            aVar.a();
            throw null;
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        loadImageIfNecessary(true);
    }

    public void setDefaultImageResId(int i) {
        this.mDefaultImageId = i;
    }

    public void setErrorImageResId(int i) {
        this.mErrorImageId = i;
    }

    public void setImageUrl(String str, l lVar) {
        r.a();
        this.mUrl = str;
        this.mImageLoader = lVar;
        loadImageIfNecessary(false);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
