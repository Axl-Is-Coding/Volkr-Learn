package zlc.season.rxdownload3.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import zlc.season.rxdownload3.database.DbActor;
import zlc.season.rxdownload3.extension.Extension;
import zlc.season.rxdownload3.http.OkHttpClientFactory;
import zlc.season.rxdownload3.http.OkHttpClientFactoryImpl;
import zlc.season.rxdownload3.notification.NotificationFactory;

/* JADX INFO: compiled from: DownloadConfig.kt */
/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"StaticFieldLeak"})
public final class DownloadConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f23660a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f23664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Context f23665f;
    private static int g;
    private static boolean h;
    private static boolean i;
    private static boolean j;
    public static DbActor k;
    private static MissionBox l;
    private static boolean m;
    private static long n;
    public static NotificationFactory o;
    private static OkHttpClientFactory p;
    private static List<Class<? extends Extension>> q;
    public static final DownloadConfig r = new DownloadConfig();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f23661b = 4194304;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f23662c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f23663d = Runtime.getRuntime().availableProcessors() + 1;

    /* JADX INFO: compiled from: DownloadConfig.kt */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f23666a = new Companion(null);

        /* JADX INFO: compiled from: DownloadConfig.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }
        }
    }

    static {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        i.a((Object) externalStoragePublicDirectory, "getExternalStoragePublic…tory(DIRECTORY_DOWNLOADS)");
        f23664e = externalStoragePublicDirectory.getPath();
        g = 30;
        i = true;
        l = new LocalMissionBox();
        n = 2L;
        p = new OkHttpClientFactoryImpl();
        q = new ArrayList();
    }

    private DownloadConfig() {
    }

    public final boolean a() {
        return h;
    }

    public final Context b() {
        return f23665f;
    }

    public final boolean c() {
        return f23660a;
    }

    public final DbActor d() {
        DbActor dbActor = k;
        if (dbActor != null) {
            return dbActor;
        }
        i.c("dbActor");
        throw null;
    }

    public final String e() {
        return f23664e;
    }

    public final boolean f() {
        return j;
    }

    public final boolean g() {
        return m;
    }

    public final List<Class<? extends Extension>> h() {
        return q;
    }

    public final int i() {
        return g;
    }

    public final int j() {
        return f23662c;
    }

    public final int k() {
        return f23663d;
    }

    public final MissionBox l() {
        return l;
    }

    public final NotificationFactory m() {
        NotificationFactory notificationFactory = o;
        if (notificationFactory != null) {
            return notificationFactory;
        }
        i.c("notificationFactory");
        throw null;
    }

    public final long n() {
        return n;
    }

    public final OkHttpClientFactory o() {
        return p;
    }

    public final long p() {
        return f23661b;
    }

    public final boolean q() {
        return i;
    }
}
