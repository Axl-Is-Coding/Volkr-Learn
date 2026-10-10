package zlc.season.rxdownload4.a.a;

import java.net.MalformedURLException;
import java.net.URL;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: Task.kt */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f23850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f23851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f23852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f23853d;

    public a(String str, String str2, String str3, String str4) {
        i.b(str, "url");
        i.b(str2, "taskName");
        i.b(str3, "saveName");
        i.b(str4, "savePath");
        this.f23850a = str;
        this.f23851b = str2;
        this.f23852c = str3;
        this.f23853d = str4;
    }

    public final String a() {
        return this.f23852c;
    }

    public final String b() {
        return this.f23853d;
    }

    public final String c() {
        return this.f23851b;
    }

    public final String d() {
        return this.f23850a;
    }

    public boolean e() {
        if (this.f23851b.length() == 0) {
            return true;
        }
        if (this.f23852c.length() == 0) {
            return true;
        }
        return this.f23853d.length() == 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            return i.a((Object) f(), (Object) ((a) obj).f());
        }
        return false;
    }

    public String f() {
        try {
            return new URL(this.f23850a).getPath();
        } catch (MalformedURLException unused) {
            return this.f23850a;
        }
    }

    public int hashCode() {
        return f().hashCode();
    }

    public /* synthetic */ a(String str, String str2, String str3, String str4, int i, f fVar) {
        this(str, (i & 2) != 0 ? zlc.season.rxdownload4.download.utils.b.a(str) : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? zlc.season.rxdownload4.a.b.a() : str4);
    }

    public final void a(String str) {
        i.b(str, "<set-?>");
        this.f23852c = str;
    }

    public final void b(String str) {
        i.b(str, "<set-?>");
        this.f23853d = str;
    }

    public final void c(String str) {
        i.b(str, "<set-?>");
        this.f23851b = str;
    }
}
