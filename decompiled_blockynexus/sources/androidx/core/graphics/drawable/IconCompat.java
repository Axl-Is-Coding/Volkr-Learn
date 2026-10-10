package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import cn.qqtheme.framework.widget.WheelView;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final PorterDuff.Mode f1160a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f1162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f1163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Parcelable f1164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1165f;
    public int g;
    public ColorStateList h;
    PorterDuff.Mode i;
    public String j;

    public IconCompat() {
        this.f1161b = -1;
        this.f1163d = null;
        this.f1164e = null;
        this.f1165f = 0;
        this.g = 0;
        this.h = null;
        this.i = f1160a;
        this.j = null;
    }

    public static IconCompat a(Resources resources, String str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("Package must not be null.");
        }
        if (i == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f1165f = i;
        if (resources != null) {
            try {
                iconCompat.f1162c = resources.getResourceName(i);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f1162c = str;
        }
        return iconCompat;
    }

    private static String a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "UNKNOWN" : "BITMAP_MASKABLE" : "URI" : "DATA" : "RESOURCE" : "BITMAP";
    }

    public String b() {
        if (this.f1161b == -1 && Build.VERSION.SDK_INT >= 23) {
            return b((Icon) this.f1162c);
        }
        if (this.f1161b == 2) {
            return ((String) this.f1162c).split(":", -1)[0];
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int c() {
        return (this.f1161b != -1 || Build.VERSION.SDK_INT < 23) ? this.f1161b : c((Icon) this.f1162c);
    }

    public void d() {
        this.i = PorterDuff.Mode.valueOf(this.j);
        int i = this.f1161b;
        if (i == -1) {
            Parcelable parcelable = this.f1164e;
            if (parcelable == null) {
                throw new IllegalArgumentException("Invalid icon");
            }
            this.f1162c = parcelable;
            return;
        }
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.f1162c = this.f1163d;
                    return;
                } else if (i != 4) {
                    if (i != 5) {
                        return;
                    }
                }
            }
            this.f1162c = new String(this.f1163d, Charset.forName("UTF-16"));
            return;
        }
        Parcelable parcelable2 = this.f1164e;
        if (parcelable2 != null) {
            this.f1162c = parcelable2;
            return;
        }
        byte[] bArr = this.f1163d;
        this.f1162c = bArr;
        this.f1161b = 3;
        this.f1165f = 0;
        this.g = bArr.length;
    }

    public Icon e() {
        Icon iconCreateWithBitmap;
        int i = this.f1161b;
        if (i == -1) {
            return (Icon) this.f1162c;
        }
        if (i == 1) {
            iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) this.f1162c);
        } else if (i == 2) {
            iconCreateWithBitmap = Icon.createWithResource(b(), this.f1165f);
        } else if (i == 3) {
            iconCreateWithBitmap = Icon.createWithData((byte[]) this.f1162c, this.f1165f, this.g);
        } else if (i == 4) {
            iconCreateWithBitmap = Icon.createWithContentUri((String) this.f1162c);
        } else {
            if (i != 5) {
                throw new IllegalArgumentException("Unknown type");
            }
            iconCreateWithBitmap = Build.VERSION.SDK_INT >= 26 ? Icon.createWithAdaptiveBitmap((Bitmap) this.f1162c) : Icon.createWithBitmap(a((Bitmap) this.f1162c, false));
        }
        ColorStateList colorStateList = this.h;
        if (colorStateList != null) {
            iconCreateWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.i;
        if (mode != f1160a) {
            iconCreateWithBitmap.setTintMode(mode);
        }
        return iconCreateWithBitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r4 = this;
            int r0 = r4.f1161b
            r1 = -1
            if (r0 != r1) goto Lc
            java.lang.Object r0 = r4.f1162c
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        Lc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Icon(typ="
            r0.<init>(r1)
            int r1 = r4.f1161b
            java.lang.String r1 = a(r1)
            r0.append(r1)
            int r1 = r4.f1161b
            r2 = 1
            if (r1 == r2) goto L7a
            r3 = 2
            if (r1 == r3) goto L52
            r2 = 3
            if (r1 == r2) goto L39
            r2 = 4
            if (r1 == r2) goto L2e
            r2 = 5
            if (r1 == r2) goto L7a
            goto L9a
        L2e:
            java.lang.String r1 = " uri="
            r0.append(r1)
            java.lang.Object r1 = r4.f1162c
            r0.append(r1)
            goto L9a
        L39:
            java.lang.String r1 = " len="
            r0.append(r1)
            int r1 = r4.f1165f
            r0.append(r1)
            int r1 = r4.g
            if (r1 == 0) goto L9a
            java.lang.String r1 = " off="
            r0.append(r1)
            int r1 = r4.g
            r0.append(r1)
            goto L9a
        L52:
            java.lang.String r1 = " pkg="
            r0.append(r1)
            java.lang.String r1 = r4.b()
            r0.append(r1)
            java.lang.String r1 = " id="
            r0.append(r1)
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r2 = 0
            int r3 = r4.a()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            java.lang.String r2 = "0x%08x"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.append(r1)
            goto L9a
        L7a:
            java.lang.String r1 = " size="
            r0.append(r1)
            java.lang.Object r1 = r4.f1162c
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getWidth()
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            java.lang.Object r1 = r4.f1162c
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getHeight()
            r0.append(r1)
        L9a:
            android.content.res.ColorStateList r1 = r4.h
            if (r1 == 0) goto La8
            java.lang.String r1 = " tint="
            r0.append(r1)
            android.content.res.ColorStateList r1 = r4.h
            r0.append(r1)
        La8:
            android.graphics.PorterDuff$Mode r1 = r4.i
            android.graphics.PorterDuff$Mode r2 = androidx.core.graphics.drawable.IconCompat.f1160a
            if (r1 == r2) goto Lb8
            java.lang.String r1 = " mode="
            r0.append(r1)
            android.graphics.PorterDuff$Mode r1 = r4.i
            r0.append(r1)
        Lb8:
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.toString():java.lang.String");
    }

    private static int c(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e2);
            return -1;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e3);
            return -1;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e4);
            return -1;
        }
    }

    private static String b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon package", e4);
            return null;
        }
    }

    public int a() {
        if (this.f1161b == -1 && Build.VERSION.SDK_INT >= 23) {
            return a((Icon) this.f1162c);
        }
        if (this.f1161b == 2) {
            return this.f1165f;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    private IconCompat(int i) {
        this.f1161b = -1;
        this.f1163d = null;
        this.f1164e = null;
        this.f1165f = 0;
        this.g = 0;
        this.h = null;
        this.i = f1160a;
        this.j = null;
        this.f1161b = i;
    }

    public void a(boolean z) {
        this.j = this.i.name();
        int i = this.f1161b;
        if (i == -1) {
            if (!z) {
                this.f1164e = (Parcelable) this.f1162c;
                return;
            }
            throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
        }
        if (i != 1) {
            if (i == 2) {
                this.f1163d = ((String) this.f1162c).getBytes(Charset.forName("UTF-16"));
                return;
            }
            if (i == 3) {
                this.f1163d = (byte[]) this.f1162c;
                return;
            } else if (i == 4) {
                this.f1163d = this.f1162c.toString().getBytes(Charset.forName("UTF-16"));
                return;
            } else if (i != 5) {
                return;
            }
        }
        if (z) {
            Bitmap bitmap = (Bitmap) this.f1162c;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
            this.f1163d = byteArrayOutputStream.toByteArray();
            return;
        }
        this.f1164e = (Parcelable) this.f1162c;
    }

    private static int a(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon resource", e4);
            return 0;
        }
    }

    static Bitmap a(Bitmap bitmap, boolean z) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f2 = iMin;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, WheelView.DividerConfig.FILL, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2, (-(bitmap.getHeight() - iMin)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }
}
