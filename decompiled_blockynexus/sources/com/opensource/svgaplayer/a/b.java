package com.opensource.svgaplayer.a;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.media.SoundPool;
import android.os.Build;
import android.text.BoringLayout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.opensource.svgaplayer.a.a;
import com.opensource.svgaplayer.d;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.q;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.k;
import kotlin.jvm.a.c;
import kotlin.jvm.a.e;
import kotlin.jvm.internal.i;
import kotlin.text.n;

/* JADX INFO: compiled from: SVGACanvasDrawer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.opensource.svgaplayer.a.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C0144b f15458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<String, Bitmap> f15459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f15460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Boolean[] f15461f;
    private Boolean[] g;
    private final float[] h;
    private final d i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(q qVar, d dVar) {
        super(qVar);
        i.b(qVar, "videoItem");
        i.b(dVar, "dynamicItem");
        this.i = dVar;
        this.f15458c = new C0144b();
        this.f15459d = new HashMap<>();
        this.f15460e = new a();
        this.h = new float[16];
    }

    private final boolean b(int i, List<a.C0143a> list) {
        Boolean bool;
        String strC;
        if (this.g == null) {
            Boolean[] boolArr = new Boolean[list.size()];
            int length = boolArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                boolArr[i2] = false;
            }
            int i3 = 0;
            for (Object obj : list) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    k.b();
                    throw null;
                }
                a.C0143a c0143a = (a.C0143a) obj;
                String strB = c0143a.b();
                if ((strB == null || !n.a(strB, ".matte", false, 2, null)) && (strC = c0143a.c()) != null && strC.length() > 0) {
                    if (i3 == list.size() - 1) {
                        boolArr[i3] = true;
                    } else {
                        a.C0143a c0143a2 = list.get(i4);
                        if (c0143a2 != null) {
                            if (c0143a2.c() == null || c0143a2.c().length() == 0) {
                                boolArr[i3] = true;
                            } else if (!i.a((Object) c0143a2.c(), (Object) c0143a.c())) {
                                boolArr[i3] = true;
                            }
                        }
                    }
                }
                i3 = i4;
            }
            this.g = boolArr;
        }
        Boolean[] boolArr2 = this.g;
        if (boolArr2 == null || (bool = boolArr2[i]) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b0  */
    @Override // com.opensource.svgaplayer.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.graphics.Canvas r21, int r22, android.widget.ImageView.ScaleType r23) {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opensource.svgaplayer.a.b.a(android.graphics.Canvas, int, android.widget.ImageView$ScaleType):void");
    }

    /* JADX INFO: renamed from: com.opensource.svgaplayer.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SVGACanvasDrawer.kt */
    public static final class C0144b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Paint f15465a = new Paint();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Path f15466b = new Path();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Path f15467c = new Path();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Matrix f15468d = new Matrix();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Matrix f15469e = new Matrix();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Paint f15470f = new Paint();
        private Canvas g;
        private Bitmap h;

        public final Paint a() {
            this.f15470f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            return this.f15470f;
        }

        public final Matrix b() {
            this.f15468d.reset();
            return this.f15468d;
        }

        public final Matrix c() {
            this.f15469e.reset();
            return this.f15469e;
        }

        public final Bitmap d() {
            Bitmap bitmap = this.h;
            if (bitmap != null) {
                return bitmap;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
        }

        public final Paint e() {
            this.f15465a.reset();
            return this.f15465a;
        }

        public final Path f() {
            this.f15466b.reset();
            return this.f15466b;
        }

        public final Path g() {
            this.f15467c.reset();
            return this.f15467c;
        }

        public final Canvas a(int i, int i2) {
            if (this.g == null) {
                this.h = Bitmap.createBitmap(i, i2, Bitmap.Config.ALPHA_8);
            }
            return new Canvas(this.h);
        }
    }

    /* JADX INFO: compiled from: SVGACanvasDrawer.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f15462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f15463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final HashMap<SVGAVideoShapeEntity, Path> f15464c = new HashMap<>();

        public final void a(Canvas canvas) {
            i.b(canvas, "canvas");
            if (this.f15462a != canvas.getWidth() || this.f15463b != canvas.getHeight()) {
                this.f15464c.clear();
            }
            this.f15462a = canvas.getWidth();
            this.f15463b = canvas.getHeight();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            i.b(sVGAVideoShapeEntity, "shape");
            if (!this.f15464c.containsKey(sVGAVideoShapeEntity)) {
                Path path = new Path();
                path.set(sVGAVideoShapeEntity.b());
                this.f15464c.put(sVGAVideoShapeEntity, path);
            }
            Path path2 = this.f15464c.get(sVGAVideoShapeEntity);
            if (path2 != null) {
                return path2;
            }
            i.a();
            throw null;
        }
    }

    private final void b(int i) {
        SoundPool soundPoolF;
        Integer numC;
        for (com.opensource.svgaplayer.entities.a aVar : b().b()) {
            if (aVar.d() == i && (soundPoolF = b().f()) != null && (numC = aVar.c()) != null) {
                aVar.a(Integer.valueOf(soundPoolF.play(numC.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
            }
            if (aVar.a() <= i) {
                Integer numB = aVar.b();
                if (numB != null) {
                    int iIntValue = numB.intValue();
                    SoundPool soundPoolF2 = b().f();
                    if (soundPoolF2 != null) {
                        soundPoolF2.stop(iIntValue);
                    }
                }
                aVar.a(null);
            }
        }
    }

    private final boolean a(int i, List<a.C0143a> list) {
        Boolean bool;
        String strC;
        a.C0143a c0143a;
        if (this.f15461f == null) {
            Boolean[] boolArr = new Boolean[list.size()];
            int length = boolArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                boolArr[i2] = false;
            }
            int i3 = 0;
            for (Object obj : list) {
                int i4 = i3 + 1;
                if (i3 >= 0) {
                    a.C0143a c0143a2 = (a.C0143a) obj;
                    String strB = c0143a2.b();
                    if ((strB == null || !n.a(strB, ".matte", false, 2, null)) && (strC = c0143a2.c()) != null && strC.length() > 0 && (c0143a = list.get(i3 - 1)) != null) {
                        if (c0143a.c() != null && c0143a.c().length() != 0) {
                            if (!i.a((Object) c0143a.c(), (Object) c0143a2.c())) {
                                boolArr[i3] = true;
                            }
                        } else {
                            boolArr[i3] = true;
                        }
                    }
                    i3 = i4;
                } else {
                    k.b();
                    throw null;
                }
            }
            this.f15461f = boolArr;
        }
        Boolean[] boolArr2 = this.f15461f;
        if (boolArr2 == null || (bool = boolArr2[i]) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private final Matrix b(Matrix matrix) {
        Matrix matrixB = this.f15458c.b();
        matrixB.postScale(a().b(), a().c());
        matrixB.postTranslate(a().d(), a().e());
        matrixB.preConcat(matrix);
        return matrixB;
    }

    private final void b(a.C0143a c0143a, Canvas canvas, int i) {
        a(c0143a, canvas);
        b(c0143a, canvas);
        a(c0143a, canvas, i);
    }

    private final void b(a.C0143a c0143a, Canvas canvas) {
        float[] fArrC;
        String strD;
        String strB;
        int iA;
        Matrix matrixB = b(c0143a.a().e());
        for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c0143a.a().d()) {
            sVGAVideoShapeEntity.a();
            if (sVGAVideoShapeEntity.b() != null) {
                Paint paintE = this.f15458c.e();
                paintE.reset();
                paintE.setAntiAlias(b().a());
                double dA = c0143a.a().a();
                double d2 = 255;
                Double.isNaN(d2);
                paintE.setAlpha((int) (dA * d2));
                Path pathF = this.f15458c.f();
                pathF.reset();
                pathF.addPath(this.f15460e.a(sVGAVideoShapeEntity));
                Matrix matrixC = this.f15458c.c();
                matrixC.reset();
                Matrix matrixD = sVGAVideoShapeEntity.d();
                if (matrixD != null) {
                    matrixC.postConcat(matrixD);
                }
                matrixC.postConcat(matrixB);
                pathF.transform(matrixC);
                SVGAVideoShapeEntity.a aVarC = sVGAVideoShapeEntity.c();
                if (aVarC != null && (iA = aVarC.a()) != 0) {
                    paintE.setStyle(Paint.Style.FILL);
                    paintE.setColor(iA);
                    double dA2 = c0143a.a().a();
                    Double.isNaN(d2);
                    paintE.setAlpha(Math.min(255, Math.max(0, (int) (dA2 * d2))));
                    if (c0143a.a().c() != null) {
                        canvas.save();
                    }
                    com.opensource.svgaplayer.entities.b bVarC = c0143a.a().c();
                    if (bVarC != null) {
                        Path pathG = this.f15458c.g();
                        bVarC.a(pathG);
                        pathG.transform(matrixB);
                        canvas.clipPath(pathG);
                    }
                    canvas.drawPath(pathF, paintE);
                    if (c0143a.a().c() != null) {
                        canvas.restore();
                    }
                }
                SVGAVideoShapeEntity.a aVarC2 = sVGAVideoShapeEntity.c();
                if (aVarC2 != null) {
                    float f2 = 0;
                    if (aVarC2.g() > f2) {
                        paintE.setStyle(Paint.Style.STROKE);
                        SVGAVideoShapeEntity.a aVarC3 = sVGAVideoShapeEntity.c();
                        if (aVarC3 != null) {
                            paintE.setColor(aVarC3.f());
                            double dA3 = c0143a.a().a();
                            Double.isNaN(d2);
                            paintE.setAlpha(Math.min(255, Math.max(0, (int) (dA3 * d2))));
                        }
                        float fA = a(matrixB);
                        SVGAVideoShapeEntity.a aVarC4 = sVGAVideoShapeEntity.c();
                        if (aVarC4 != null) {
                            paintE.setStrokeWidth(aVarC4.g() * fA);
                        }
                        SVGAVideoShapeEntity.a aVarC5 = sVGAVideoShapeEntity.c();
                        if (aVarC5 != null && (strB = aVarC5.b()) != null) {
                            if (n.b(strB, "butt", true)) {
                                paintE.setStrokeCap(Paint.Cap.BUTT);
                            } else if (n.b(strB, "round", true)) {
                                paintE.setStrokeCap(Paint.Cap.ROUND);
                            } else if (n.b(strB, MessengerShareContentUtility.IMAGE_RATIO_SQUARE, true)) {
                                paintE.setStrokeCap(Paint.Cap.SQUARE);
                            }
                        }
                        SVGAVideoShapeEntity.a aVarC6 = sVGAVideoShapeEntity.c();
                        if (aVarC6 != null && (strD = aVarC6.d()) != null) {
                            if (n.b(strD, "miter", true)) {
                                paintE.setStrokeJoin(Paint.Join.MITER);
                            } else if (n.b(strD, "round", true)) {
                                paintE.setStrokeJoin(Paint.Join.ROUND);
                            } else if (n.b(strD, "bevel", true)) {
                                paintE.setStrokeJoin(Paint.Join.BEVEL);
                            }
                        }
                        if (sVGAVideoShapeEntity.c() != null) {
                            paintE.setStrokeMiter(r6.e() * fA);
                        }
                        SVGAVideoShapeEntity.a aVarC7 = sVGAVideoShapeEntity.c();
                        if (aVarC7 != null && (fArrC = aVarC7.c()) != null && fArrC.length == 3 && (fArrC[0] > f2 || fArrC[1] > f2)) {
                            float[] fArr = new float[2];
                            fArr[0] = (fArrC[0] >= 1.0f ? fArrC[0] : 1.0f) * fA;
                            fArr[1] = (fArrC[1] >= 0.1f ? fArrC[1] : 0.1f) * fA;
                            paintE.setPathEffect(new DashPathEffect(fArr, fArrC[2] * fA));
                        }
                        if (c0143a.a().c() != null) {
                            canvas.save();
                        }
                        com.opensource.svgaplayer.entities.b bVarC2 = c0143a.a().c();
                        if (bVarC2 != null) {
                            Path pathG2 = this.f15458c.g();
                            bVarC2.a(pathG2);
                            pathG2.transform(matrixB);
                            canvas.clipPath(pathG2);
                        }
                        canvas.drawPath(pathF, paintE);
                        if (c0143a.a().c() != null) {
                            canvas.restore();
                        }
                    }
                }
            }
        }
    }

    private final void a(a.C0143a c0143a, Canvas canvas) {
        String strB = c0143a.b();
        if (strB == null || i.a((Object) this.i.d().get(strB), (Object) true)) {
            return;
        }
        String strA = n.a(strB, ".matte", "", false, 4, (Object) null);
        Bitmap bitmap = this.i.f().get(strA);
        if (bitmap == null) {
            bitmap = b().e().get(strA);
        }
        Bitmap bitmap2 = bitmap;
        if (bitmap2 != null) {
            Matrix matrixB = b(c0143a.a().e());
            Paint paintE = this.f15458c.e();
            paintE.setAntiAlias(b().a());
            paintE.setFilterBitmap(b().a());
            double dA = c0143a.a().a();
            double d2 = 255;
            Double.isNaN(d2);
            paintE.setAlpha((int) (dA * d2));
            if (c0143a.a().c() != null) {
                com.opensource.svgaplayer.entities.b bVarC = c0143a.a().c();
                if (bVarC == null) {
                    return;
                }
                canvas.save();
                Path pathF = this.f15458c.f();
                bVarC.a(pathF);
                pathF.transform(matrixB);
                canvas.clipPath(pathF);
                double dB = c0143a.a().b().b();
                double width = bitmap2.getWidth();
                Double.isNaN(width);
                double dB2 = c0143a.a().b().b();
                double width2 = bitmap2.getWidth();
                Double.isNaN(width2);
                matrixB.preScale((float) (dB / width), (float) (dB2 / width2));
                if (!bitmap2.isRecycled()) {
                    canvas.drawBitmap(bitmap2, matrixB, paintE);
                }
                canvas.restore();
            } else {
                double dB3 = c0143a.a().b().b();
                double width3 = bitmap2.getWidth();
                Double.isNaN(width3);
                double dB4 = c0143a.a().b().b();
                double width4 = bitmap2.getWidth();
                Double.isNaN(width4);
                matrixB.preScale((float) (dB3 / width3), (float) (dB4 / width4));
                if (!bitmap2.isRecycled()) {
                    canvas.drawBitmap(bitmap2, matrixB, paintE);
                }
            }
            com.opensource.svgaplayer.a aVar = this.i.e().get(strB);
            if (aVar != null) {
                float[] fArr = {WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL};
                matrixB.getValues(fArr);
                aVar.a(strB, (int) fArr[2], (int) fArr[5], (int) ((bitmap2.getWidth() * fArr[0]) + fArr[2]), (int) ((bitmap2.getHeight() * fArr[4]) + fArr[5]));
            }
            a(canvas, bitmap2, c0143a, matrixB);
        }
    }

    private final void a(Canvas canvas, Bitmap bitmap, a.C0143a c0143a, Matrix matrix) {
        int i;
        StaticLayout staticLayoutBuild;
        TextPaint textPaint;
        if (this.i.k()) {
            this.f15459d.clear();
            this.i.a(false);
        }
        String strB = c0143a.b();
        if (strB != null) {
            Bitmap bitmapCreateBitmap = null;
            String str = this.i.h().get(strB);
            if (str != null && (textPaint = this.i.i().get(strB)) != null && (bitmapCreateBitmap = this.f15459d.get(strB)) == null) {
                bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                i.a((Object) textPaint, "drawingTextPaint");
                textPaint.setAntiAlias(true);
                textPaint.setStyle(Paint.Style.FILL);
                textPaint.setTextAlign(Paint.Align.CENTER);
                Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
                float f2 = 2;
                canvas2.drawText(str, rect.centerX(), (rect.centerY() - (fontMetrics.top / f2)) - (fontMetrics.bottom / f2), textPaint);
                HashMap<String, Bitmap> map = this.f15459d;
                if (bitmapCreateBitmap == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
                map.put(strB, bitmapCreateBitmap);
            }
            BoringLayout boringLayout = this.i.a().get(strB);
            if (boringLayout != null && (bitmapCreateBitmap = this.f15459d.get(strB)) == null) {
                i.a((Object) boringLayout, "it");
                TextPaint paint = boringLayout.getPaint();
                i.a((Object) paint, "it.paint");
                paint.setAntiAlias(true);
                bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas3 = new Canvas(bitmapCreateBitmap);
                canvas3.translate(WheelView.DividerConfig.FILL, (bitmap.getHeight() - boringLayout.getHeight()) / 2);
                boringLayout.draw(canvas3);
                HashMap<String, Bitmap> map2 = this.f15459d;
                if (bitmapCreateBitmap == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
                map2.put(strB, bitmapCreateBitmap);
            }
            StaticLayout staticLayout = this.i.g().get(strB);
            if (staticLayout != null && (bitmapCreateBitmap = this.f15459d.get(strB)) == null) {
                i.a((Object) staticLayout, "it");
                TextPaint paint2 = staticLayout.getPaint();
                i.a((Object) paint2, "it.paint");
                paint2.setAntiAlias(true);
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        Field declaredField = StaticLayout.class.getDeclaredField("mMaximumVisibleLineCount");
                        i.a((Object) declaredField, "field");
                        declaredField.setAccessible(true);
                        i = declaredField.getInt(staticLayout);
                    } catch (Exception unused) {
                        i = Integer.MAX_VALUE;
                    }
                    staticLayoutBuild = StaticLayout.Builder.obtain(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), bitmap.getWidth()).setAlignment(staticLayout.getAlignment()).setMaxLines(i).setEllipsize(TextUtils.TruncateAt.END).build();
                } else {
                    staticLayoutBuild = new StaticLayout(staticLayout.getText(), 0, staticLayout.getText().length(), staticLayout.getPaint(), bitmap.getWidth(), staticLayout.getAlignment(), staticLayout.getSpacingMultiplier(), staticLayout.getSpacingAdd(), false);
                }
                bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas4 = new Canvas(bitmapCreateBitmap);
                int height = bitmap.getHeight();
                i.a((Object) staticLayoutBuild, "layout");
                canvas4.translate(WheelView.DividerConfig.FILL, (height - staticLayoutBuild.getHeight()) / 2);
                staticLayoutBuild.draw(canvas4);
                HashMap<String, Bitmap> map3 = this.f15459d;
                if (bitmapCreateBitmap == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                }
                map3.put(strB, bitmapCreateBitmap);
            }
            if (bitmapCreateBitmap != null) {
                Paint paintE = this.f15458c.e();
                paintE.setAntiAlias(b().a());
                double dA = c0143a.a().a();
                double d2 = 255;
                Double.isNaN(d2);
                paintE.setAlpha((int) (dA * d2));
                if (c0143a.a().c() != null) {
                    com.opensource.svgaplayer.entities.b bVarC = c0143a.a().c();
                    if (bVarC != null) {
                        canvas.save();
                        canvas.concat(matrix);
                        canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                        paintE.setShader(new BitmapShader(bitmapCreateBitmap, tileMode, tileMode));
                        Path pathF = this.f15458c.f();
                        bVarC.a(pathF);
                        canvas.drawPath(pathF, paintE);
                        canvas.restore();
                        return;
                    }
                    return;
                }
                paintE.setFilterBitmap(b().a());
                canvas.drawBitmap(bitmapCreateBitmap, matrix, paintE);
            }
        }
    }

    private final float a(Matrix matrix) {
        matrix.getValues(this.h);
        float[] fArr = this.h;
        if (fArr[0] == WheelView.DividerConfig.FILL) {
            return WheelView.DividerConfig.FILL;
        }
        double d2 = fArr[0];
        double d3 = fArr[3];
        double d4 = fArr[1];
        double d5 = fArr[4];
        Double.isNaN(d2);
        Double.isNaN(d5);
        double d6 = d2 * d5;
        Double.isNaN(d3);
        Double.isNaN(d4);
        if (d6 == d3 * d4) {
            return WheelView.DividerConfig.FILL;
        }
        Double.isNaN(d2);
        Double.isNaN(d2);
        Double.isNaN(d3);
        Double.isNaN(d3);
        double dSqrt = Math.sqrt((d2 * d2) + (d3 * d3));
        Double.isNaN(d2);
        double d7 = d2 / dSqrt;
        Double.isNaN(d3);
        double d8 = d3 / dSqrt;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double d9 = (d7 * d4) + (d8 * d5);
        Double.isNaN(d4);
        double d10 = d4 - (d7 * d9);
        Double.isNaN(d5);
        double d11 = d5 - (d9 * d8);
        double dSqrt2 = Math.sqrt((d10 * d10) + (d11 * d11));
        if (d7 * (d11 / dSqrt2) < d8 * (d10 / dSqrt2)) {
            dSqrt = -dSqrt;
        }
        return Math.abs(a().a() ? (float) dSqrt : (float) dSqrt2);
    }

    private final void a(a.C0143a c0143a, Canvas canvas, int i) {
        String strB = c0143a.b();
        if (strB != null) {
            c<Canvas, Integer, Boolean> cVar = this.i.b().get(strB);
            if (cVar != null) {
                Matrix matrixB = b(c0143a.a().e());
                canvas.save();
                canvas.concat(matrixB);
                cVar.invoke(canvas, Integer.valueOf(i));
                canvas.restore();
            }
            e<Canvas, Integer, Integer, Integer, Boolean> eVar = this.i.c().get(strB);
            if (eVar != null) {
                Matrix matrixB2 = b(c0143a.a().e());
                canvas.save();
                canvas.concat(matrixB2);
                eVar.a(canvas, Integer.valueOf(i), Integer.valueOf((int) c0143a.a().b().b()), Integer.valueOf((int) c0143a.a().b().a()));
                canvas.restore();
            }
        }
    }
}
