package com.tencent.mapsdk.rastercore.g;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.view.View;
import com.tencent.mapsdk.rastercore.d.f;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f19609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bitmap f19610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f19611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f19612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19614f;
    private final int g;
    private int h;
    private int i;
    private float j;
    private float k;

    public b(f fVar) {
        super(f.a());
        this.f19611c = new Paint();
        this.f19612d = 0;
        this.f19613e = 10;
        this.f19614f = 10;
        this.h = 0;
        this.i = 0;
        this.j = Float.MIN_VALUE;
        this.k = 1.0f;
        this.f19609a = fVar;
        this.k = getResources().getDisplayMetrics().density;
        fVar.f().b();
        this.f19611c.setAntiAlias(true);
        this.f19611c.setColor(-16777216);
        this.f19611c.setStyle(Paint.Style.STROKE);
        this.g = (int) (this.k * 3.0f);
        int i = this.g;
        this.i = i;
        this.h = i;
    }

    public final void a() {
        Bitmap bitmap = this.f19610b;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    public final void a(float f2) {
        if (f2 < 0.7f) {
            f2 = 0.7f;
        }
        if (f2 > 1.3f) {
            f2 = 1.3f;
        }
        this.j = f2;
    }

    public final void a(int i) {
        this.f19612d = i;
    }

    public final void a(Bitmap bitmap) {
        if (bitmap == null) {
            setVisibility(0);
            return;
        }
        Bitmap bitmapA = com.tencent.mapsdk.rastercore.f.b.a(bitmap, this.k / 3.0f);
        if (bitmapA == null) {
            return;
        }
        this.f19610b = bitmapA;
        setVisibility(0);
        invalidate();
    }

    public final void a(int[] iArr) {
        this.f19612d = 1;
        if (iArr == null || iArr.length < 2) {
            return;
        }
        this.h = iArr[0] < 0 ? this.g : iArr[0];
        this.i = iArr[1] < 0 ? this.g : iArr[1];
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDraw(android.graphics.Canvas r9) {
        /*
            r8 = this;
            android.graphics.Bitmap r0 = r8.f19610b
            float r1 = r8.j
            r2 = 1
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto Ld
            android.graphics.Bitmap r0 = com.tencent.mapsdk.rastercore.f.b.a(r0, r1)
        Ld:
            if (r0 == 0) goto Lae
            boolean r1 = r0.isRecycled()
            if (r1 == 0) goto L17
            goto Lae
        L17:
            int r1 = r0.getWidth()
            int r2 = r0.getHeight()
            int r3 = r8.f19612d
            com.tencent.mapsdk.rastercore.d.f r4 = r8.f19609a
            com.tencent.mapsdk.rastercore.d.b r4 = r4.c()
            int r4 = r4.getWidth()
            com.tencent.mapsdk.rastercore.d.f r5 = r8.f19609a
            com.tencent.mapsdk.rastercore.d.b r5 = r5.c()
            int r5 = r5.getHeight()
            r6 = 2
            if (r3 == 0) goto L7f
            r7 = 1
            if (r3 == r7) goto L63
            if (r3 == r6) goto L5a
            r7 = 3
            if (r3 == r7) goto L55
            r7 = 4
            if (r3 == r7) goto L4d
            int r4 = r4 - r1
            int r1 = r8.g
            int r4 = r4 - r1
            int r4 = r4 / r6
            r8.f19613e = r4
        L4a:
            r8.f19614f = r1
            goto L89
        L4d:
            int r4 = r4 - r1
            int r1 = r8.g
            int r4 = r4 - r1
            int r4 = r4 / r6
            r8.f19613e = r4
            goto L85
        L55:
            int r1 = r8.g
            r8.f19613e = r1
            goto L4a
        L5a:
            int r2 = r8.g
            int r1 = r1 + r2
            int r4 = r4 - r1
            r8.f19613e = r4
            r8.f19614f = r2
            goto L89
        L63:
            int r3 = r8.i
            int r7 = r3 + r1
            if (r7 <= r4) goto L6e
            int r4 = r4 - r1
            int r1 = r8.g
            int r4 = r4 - r1
            goto L70
        L6e:
            int r4 = r4 - r1
            int r4 = r4 - r3
        L70:
            r8.f19613e = r4
            int r1 = r8.h
            int r3 = r1 + r2
            if (r3 <= r5) goto L7c
            int r5 = r5 - r2
            int r1 = r8.g
            goto L7d
        L7c:
            int r5 = r5 - r2
        L7d:
            int r5 = r5 - r1
            goto L87
        L7f:
            r1 = 10
            r8.f19613e = r1
            int r1 = r8.g
        L85:
            int r2 = r2 + r1
            int r5 = r5 - r2
        L87:
            r8.f19614f = r5
        L89:
            com.tencent.mapsdk.rastercore.d.f r1 = r8.f19609a
            com.tencent.mapsdk.rastercore.d.a$1 r1 = r1.f()
            com.tencent.mapsdk.rastercore.tile.MapTile$MapSource r1 = r1.c()
            com.tencent.mapsdk.rastercore.tile.MapTile$MapSource r2 = com.tencent.mapsdk.rastercore.tile.MapTile.MapSource.WORLD
            if (r1 != r2) goto L9b
            int r1 = r8.f19614f
            int r1 = r1 - r6
            goto L9f
        L9b:
            int r1 = r8.f19614f
            int r1 = r1 + (-8)
        L9f:
            r8.f19614f = r1
            int r1 = r8.f19613e
            int r1 = r1 + (-5)
            float r1 = (float) r1
            int r2 = r8.f19614f
            float r2 = (float) r2
            android.graphics.Paint r3 = r8.f19611c
            r9.drawBitmap(r0, r1, r2, r3)
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.rastercore.g.b.onDraw(android.graphics.Canvas):void");
    }
}
