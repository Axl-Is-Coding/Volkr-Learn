package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.R;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: NotificationCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Bundle f990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private IconCompat f991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final p[] f992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final p[] f993d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f994e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f995f;
        private final int g;
        private final boolean h;

        @Deprecated
        public int i;
        public CharSequence j;
        public PendingIntent k;

        /* JADX INFO: renamed from: androidx.core.app.l$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: NotificationCompat.java */
        public static final class C0008a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final IconCompat f996a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final CharSequence f997b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final PendingIntent f998c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f999d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private final Bundle f1000e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private ArrayList<p> f1001f;
            private int g;
            private boolean h;
            private boolean i;

            public C0008a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i != 0 ? IconCompat.a(null, "", i) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false);
            }

            private void b() {
                if (this.i && this.f998c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public a a() {
                b();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<p> arrayList3 = this.f1001f;
                if (arrayList3 != null) {
                    for (p pVar : arrayList3) {
                        if (pVar.h()) {
                            arrayList.add(pVar);
                        } else {
                            arrayList2.add(pVar);
                        }
                    }
                }
                p[] pVarArr = arrayList.isEmpty() ? null : (p[]) arrayList.toArray(new p[arrayList.size()]);
                return new a(this.f996a, this.f997b, this.f998c, this.f1000e, arrayList2.isEmpty() ? null : (p[]) arrayList2.toArray(new p[arrayList2.size()]), pVarArr, this.f999d, this.g, this.h, this.i);
            }

            private C0008a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, p[] pVarArr, boolean z, int i, boolean z2, boolean z3) {
                this.f999d = true;
                this.h = true;
                this.f996a = iconCompat;
                this.f997b = e.a(charSequence);
                this.f998c = pendingIntent;
                this.f1000e = bundle;
                this.f1001f = pVarArr == null ? null : new ArrayList<>(Arrays.asList(pVarArr));
                this.f999d = z;
                this.g = i;
                this.h = z2;
                this.i = z3;
            }
        }

        public a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i != 0 ? IconCompat.a(null, "", i) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.k;
        }

        public boolean b() {
            return this.f994e;
        }

        public p[] c() {
            return this.f993d;
        }

        public Bundle d() {
            return this.f990a;
        }

        @Deprecated
        public int e() {
            return this.i;
        }

        public IconCompat f() {
            int i;
            if (this.f991b == null && (i = this.i) != 0) {
                this.f991b = IconCompat.a(null, "", i);
            }
            return this.f991b;
        }

        public p[] g() {
            return this.f992c;
        }

        public int h() {
            return this.g;
        }

        public boolean i() {
            return this.f995f;
        }

        public CharSequence j() {
            return this.j;
        }

        public boolean k() {
            return this.h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, p[] pVarArr, p[] pVarArr2, boolean z, int i, boolean z2, boolean z3) {
            this.f995f = true;
            this.f991b = iconCompat;
            if (iconCompat != null && iconCompat.c() == 2) {
                this.i = iconCompat.a();
            }
            this.j = e.a(charSequence);
            this.k = pendingIntent;
            this.f990a = bundle == null ? new Bundle() : bundle;
            this.f992c = pVarArr;
            this.f993d = pVarArr2;
            this.f994e = z;
            this.g = i;
            this.f995f = z2;
            this.h = z3;
        }
    }

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CharSequence f1004e;

        public c a(CharSequence charSequence) {
            this.f1004e = e.a(charSequence);
            return this;
        }

        @Override // androidx.core.app.l.f
        public void a(k kVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(kVar.a()).setBigContentTitle(this.f1012b).bigText(this.f1004e);
                if (this.f1014d) {
                    bigTextStyleBigText.setSummaryText(this.f1013c);
                }
            }
        }
    }

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static final class d {
        public static Notification.BubbleMetadata a(d dVar) {
            if (dVar == null) {
                return null;
            }
            new Notification.BubbleMetadata.Builder();
            dVar.a();
            throw null;
        }

        public boolean a() {
            throw null;
        }
    }

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static class e {
        String A;
        Bundle B;
        int C;
        int D;
        Notification E;
        RemoteViews F;
        RemoteViews G;
        RemoteViews H;
        String I;
        int J;
        String K;
        long L;
        int M;
        boolean N;
        d O;
        Notification P;

        @Deprecated
        public ArrayList<String> Q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f1005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<a> f1006b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ArrayList<a> f1007c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        CharSequence f1008d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        CharSequence f1009e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        PendingIntent f1010f;
        PendingIntent g;
        RemoteViews h;
        Bitmap i;
        CharSequence j;
        int k;
        int l;
        boolean m;
        boolean n;
        f o;
        CharSequence p;
        CharSequence[] q;
        int r;
        int s;
        boolean t;
        String u;
        boolean v;
        String w;
        boolean x;
        boolean y;
        boolean z;

        public e(Context context, String str) {
            this.f1006b = new ArrayList<>();
            this.f1007c = new ArrayList<>();
            this.m = true;
            this.x = false;
            this.C = 0;
            this.D = 0;
            this.J = 0;
            this.M = 0;
            this.P = new Notification();
            this.f1005a = context;
            this.I = str;
            this.P.when = System.currentTimeMillis();
            this.P.audioStreamType = -1;
            this.l = 0;
            this.Q = new ArrayList<>();
            this.N = true;
        }

        public e a(long j) {
            this.P.when = j;
            return this;
        }

        public e b(CharSequence charSequence) {
            this.f1009e = a(charSequence);
            return this;
        }

        public e c(CharSequence charSequence) {
            this.f1008d = a(charSequence);
            return this;
        }

        public e d(int i) {
            this.P.icon = i;
            return this;
        }

        public e a(int i, int i2, boolean z) {
            this.r = i;
            this.s = i2;
            this.t = z;
            return this;
        }

        public e b(PendingIntent pendingIntent) {
            this.P.deleteIntent = pendingIntent;
            return this;
        }

        public e c(int i) {
            this.l = i;
            return this;
        }

        public e d(CharSequence charSequence) {
            this.P.tickerText = a(charSequence);
            return this;
        }

        private Bitmap b(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f1005a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double d2 = dimensionPixelSize;
            double dMax = Math.max(1, bitmap.getWidth());
            Double.isNaN(d2);
            Double.isNaN(dMax);
            double d3 = d2 / dMax;
            double d4 = dimensionPixelSize2;
            double dMax2 = Math.max(1, bitmap.getHeight());
            Double.isNaN(d4);
            Double.isNaN(dMax2);
            double dMin = Math.min(d3, d4 / dMax2);
            double width = bitmap.getWidth();
            Double.isNaN(width);
            int iCeil = (int) Math.ceil(width * dMin);
            double height = bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, iCeil, (int) Math.ceil(height * dMin), true);
        }

        public e a(PendingIntent pendingIntent) {
            this.f1010f = pendingIntent;
            return this;
        }

        public e a(Bitmap bitmap) {
            this.i = b(bitmap);
            return this;
        }

        public e a(Uri uri) {
            Notification notification = this.P;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public e a(long[] jArr) {
            this.P.vibrate = jArr;
            return this;
        }

        public e a(boolean z) {
            a(16, z);
            return this;
        }

        private void a(int i, boolean z) {
            if (z) {
                Notification notification = this.P;
                notification.flags = i | notification.flags;
            } else {
                Notification notification2 = this.P;
                notification2.flags = (i ^ (-1)) & notification2.flags;
            }
        }

        public e b(boolean z) {
            this.x = z;
            return this;
        }

        public e b(int i) {
            Notification notification = this.P;
            notification.defaults = i;
            if ((i & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        @Deprecated
        public e(Context context) {
            this(context, null);
        }

        public e a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f1006b.add(new a(i, charSequence, pendingIntent));
            return this;
        }

        public e a(a aVar) {
            this.f1006b.add(aVar);
            return this;
        }

        public Bundle b() {
            if (this.B == null) {
                this.B = new Bundle();
            }
            return this.B;
        }

        public e a(f fVar) {
            if (this.o != fVar) {
                this.o = fVar;
                f fVar2 = this.o;
                if (fVar2 != null) {
                    fVar2.a(this);
                }
            }
            return this;
        }

        public e a(int i) {
            this.C = i;
            return this;
        }

        public e a(String str) {
            this.I = str;
            return this;
        }

        public Notification a() {
            return new m(this).b();
        }

        protected static CharSequence a(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }
    }

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected e f1011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        CharSequence f1012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        CharSequence f1013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1014d = false;

        public void a(Bundle bundle) {
        }

        public abstract void a(k kVar);

        public void a(e eVar) {
            if (this.f1011a != eVar) {
                this.f1011a = eVar;
                e eVar2 = this.f1011a;
                if (eVar2 != null) {
                    eVar2.a(this);
                }
            }
        }

        public RemoteViews b(k kVar) {
            return null;
        }

        public RemoteViews c(k kVar) {
            return null;
        }

        public RemoteViews d(k kVar) {
            return null;
        }
    }

    public static Bundle a(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return notification.extras;
        }
        if (i >= 16) {
            return n.a(notification);
        }
        return null;
    }

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static class b extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Bitmap f1002e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Bitmap f1003f;
        private boolean g;

        public b a(Bitmap bitmap) {
            this.f1003f = bitmap;
            this.g = true;
            return this;
        }

        public b b(Bitmap bitmap) {
            this.f1002e = bitmap;
            return this;
        }

        @Override // androidx.core.app.l.f
        public void a(k kVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigPictureStyle bigPictureStyleBigPicture = new Notification.BigPictureStyle(kVar.a()).setBigContentTitle(this.f1012b).bigPicture(this.f1002e);
                if (this.g) {
                    bigPictureStyleBigPicture.bigLargeIcon(this.f1003f);
                }
                if (this.f1014d) {
                    bigPictureStyleBigPicture.setSummaryText(this.f1013c);
                }
            }
        }
    }
}
