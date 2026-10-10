package zlc.season.rxdownload3.core;

import kotlin.TypeCastException;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: Mission.kt */
/* JADX INFO: loaded from: classes5.dex */
public class Mission {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f23688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f23689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Boolean f23690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f23691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f23692e;

    public Mission(String str) {
        i.b(str, "url");
        this.f23692e = str;
        this.f23688a = "";
        this.f23689b = "";
        this.f23691d = this.f23692e;
    }

    public final void a(String str) {
        i.b(str, "<set-?>");
        this.f23688a = str;
    }

    public final String b() {
        return this.f23688a;
    }

    public final String c() {
        return this.f23689b;
    }

    public final String d() {
        return this.f23691d;
    }

    public final String e() {
        return this.f23692e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            return !(i.a((Object) this.f23691d, (Object) ((Mission) obj).f23691d) ^ true);
        }
        throw new TypeCastException("null cannot be cast to non-null type zlc.season.rxdownload3.core.Mission");
    }

    public int hashCode() {
        return this.f23691d.hashCode();
    }

    public final Boolean a() {
        return this.f23690c;
    }

    public final void b(String str) {
        i.b(str, "<set-?>");
        this.f23689b = str;
    }

    public final void a(Boolean bool) {
        this.f23690c = bool;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Mission(String str, String str2, String str3, Boolean bool, String str4) {
        this(str);
        i.b(str, "url");
        i.b(str2, "saveName");
        i.b(str3, "savePath");
        i.b(str4, "tag");
        this.f23688a = str2;
        this.f23689b = str3;
        this.f23690c = bool;
        this.f23691d = str4;
    }
}
