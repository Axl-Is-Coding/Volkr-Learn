package c.t.m.g;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.util.Locale;

/* JADX INFO: renamed from: c.t.m.g.db, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0420db implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ C0423eb f3117a;

    RunnableC0420db(C0423eb c0423eb) {
        this.f3117a = c0423eb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0423eb c0423eb = this.f3117a;
        try {
            Ya ya = c0423eb.f3148d;
            PackageInfo packageInfoH = c0423eb.h();
            ya.k = packageInfoH.versionCode;
            ya.j = packageInfoH.versionName;
            CharSequence charSequenceLoadLabel = c0423eb.f3147c.getApplicationInfo().loadLabel(c0423eb.g);
            ya.l = charSequenceLoadLabel != null ? charSequenceLoadLabel.toString() : "unknown";
            try {
                TelephonyManager telephonyManager = c0423eb.h;
                if (telephonyManager != null) {
                    ya.f3058b = telephonyManager.getPhoneType();
                    c0423eb.n = Ub.a(telephonyManager.getDeviceId(), Ub.f3020a).toUpperCase(Locale.ENGLISH);
                    String strA = Ub.a(telephonyManager.getSubscriberId(), Ub.f3021b);
                    String strA2 = Ub.a(telephonyManager.getLine1Number(), Ub.f3022c);
                    ya.f3059c = c0423eb.n;
                    ya.f3060d = strA;
                    ya.f3061e = strA2;
                }
            } catch (Throwable unused) {
            }
            ya.f3062f = Ub.a(c0423eb.i().replaceAll(":", "").toUpperCase(Locale.ENGLISH), Ub.f3023d);
            PackageManager packageManager = c0423eb.g;
            boolean zHasSystemFeature = packageManager.hasSystemFeature("android.hardware.location.gps");
            boolean zHasSystemFeature2 = packageManager.hasSystemFeature("android.hardware.wifi");
            boolean zHasSystemFeature3 = packageManager.hasSystemFeature("android.hardware.telephony");
            ya.x = zHasSystemFeature;
            ya.w = zHasSystemFeature2;
            ya.v = zHasSystemFeature3;
            StringBuilder sb = new StringBuilder("os:");
            sb.append(Build.MODEL);
            sb.append(" ");
            sb.append(Build.VERSION.RELEASE);
            sb.append(" ");
            sb.append(ya.a());
            sb.append("  app:");
            sb.append(packageInfoH.versionCode);
            sb.append(" ");
            sb.append(packageInfoH.versionName);
            sb.append(" sdk: ");
            sb.append(ya.d());
            sb.append(" ");
            sb.append(ya.e());
        } catch (Throwable unused2) {
        }
        this.f3117a.l.countDown();
    }
}
