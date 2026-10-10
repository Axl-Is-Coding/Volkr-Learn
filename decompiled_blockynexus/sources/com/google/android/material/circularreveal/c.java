package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.circularreveal.e;

/* JADX INFO: compiled from: CircularRevealHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f13260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f13261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f13262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Path f13263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Paint f13264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Paint f13265f;
    private e.d g;
    private Drawable h;
    private boolean i;
    private boolean j;

    /* JADX INFO: compiled from: CircularRevealHelper.java */
    public interface a {
        void actualDraw(Canvas canvas);

        boolean actualIsOpaque();
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            f13260a = 2;
        } else if (i >= 18) {
            f13260a = 1;
        } else {
            f13260a = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(a aVar) {
        this.f13261b = aVar;
        this.f13262c = (View) aVar;
        this.f13262c.setWillNotDraw(false);
        this.f13263d = new Path();
        this.f13264e = new Paint(7);
        this.f13265f = new Paint(1);
        this.f13265f.setColor(0);
    }

    private void g() {
        if (f13260a == 1) {
            this.f13263d.rewind();
            e.d dVar = this.g;
            if (dVar != null) {
                this.f13263d.addCircle(dVar.f13270a, dVar.f13271b, dVar.f13272c, Path.Direction.CW);
            }
        }
        this.f13262c.invalidate();
    }

    private boolean h() {
        e.d dVar = this.g;
        boolean z = dVar == null || dVar.a();
        return f13260a == 0 ? !z && this.j : !z;
    }

    private boolean i() {
        return (this.i || this.h == null || this.g == null) ? false : true;
    }

    private boolean j() {
        return (this.i || Color.alpha(this.f13265f.getColor()) == 0) ? false : true;
    }

    public void a() {
        if (f13260a == 0) {
            this.i = true;
            this.j = false;
            this.f13262c.buildDrawingCache();
            Bitmap drawingCache = this.f13262c.getDrawingCache();
            if (drawingCache == null && this.f13262c.getWidth() != 0 && this.f13262c.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.f13262c.getWidth(), this.f13262c.getHeight(), Bitmap.Config.ARGB_8888);
                this.f13262c.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f13264e;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.i = false;
            this.j = true;
        }
    }

    public void b() {
        if (f13260a == 0) {
            this.j = false;
            this.f13262c.destroyDrawingCache();
            this.f13264e.setShader(null);
            this.f13262c.invalidate();
        }
    }

    public Drawable c() {
        return this.h;
    }

    public int d() {
        return this.f13265f.getColor();
    }

    public e.d e() {
        e.d dVar = this.g;
        if (dVar == null) {
            return null;
        }
        e.d dVar2 = new e.d(dVar);
        if (dVar2.a()) {
            dVar2.f13272c = b(dVar2);
        }
        return dVar2;
    }

    public boolean f() {
        return this.f13261b.actualIsOpaque() && !h();
    }

    private float b(e.d dVar) {
        return com.google.android.material.h.a.a(dVar.f13270a, dVar.f13271b, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, this.f13262c.getWidth(), this.f13262c.getHeight());
    }

    private void b(Canvas canvas) {
        if (i()) {
            Rect bounds = this.h.getBounds();
            float fWidth = this.g.f13270a - (bounds.width() / 2.0f);
            float fHeight = this.g.f13271b - (bounds.height() / 2.0f);
            canvas.translate(fWidth, fHeight);
            this.h.draw(canvas);
            canvas.translate(-fWidth, -fHeight);
        }
    }

    public void a(e.d dVar) {
        if (dVar == null) {
            this.g = null;
        } else {
            e.d dVar2 = this.g;
            if (dVar2 == null) {
                this.g = new e.d(dVar);
            } else {
                dVar2.a(dVar);
            }
            if (com.google.android.material.h.a.a(dVar.f13272c, b(dVar), 1.0E-4f)) {
                this.g.f13272c = Float.MAX_VALUE;
            }
        }
        g();
    }

    public void a(int i) {
        this.f13265f.setColor(i);
        this.f13262c.invalidate();
    }

    public void a(Drawable drawable) {
        this.h = drawable;
        this.f13262c.invalidate();
    }

    public void a(Canvas canvas) {
        if (h()) {
            int i = f13260a;
            if (i == 0) {
                e.d dVar = this.g;
                canvas.drawCircle(dVar.f13270a, dVar.f13271b, dVar.f13272c, this.f13264e);
                if (j()) {
                    e.d dVar2 = this.g;
                    canvas.drawCircle(dVar2.f13270a, dVar2.f13271b, dVar2.f13272c, this.f13265f);
                }
            } else if (i == 1) {
                int iSave = canvas.save();
                canvas.clipPath(this.f13263d);
                this.f13261b.actualDraw(canvas);
                if (j()) {
                    canvas.drawRect(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, this.f13262c.getWidth(), this.f13262c.getHeight(), this.f13265f);
                }
                canvas.restoreToCount(iSave);
            } else if (i == 2) {
                this.f13261b.actualDraw(canvas);
                if (j()) {
                    canvas.drawRect(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, this.f13262c.getWidth(), this.f13262c.getHeight(), this.f13265f);
                }
            } else {
                throw new IllegalStateException("Unsupported strategy " + f13260a);
            }
        } else {
            this.f13261b.actualDraw(canvas);
            if (j()) {
                canvas.drawRect(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, this.f13262c.getWidth(), this.f13262c.getHeight(), this.f13265f);
            }
        }
        b(canvas);
    }
}
