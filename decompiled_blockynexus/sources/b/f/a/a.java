package b.f.a;

import android.util.Pair;
import io.grpc.internal.GrpcUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: EventsConfiguration.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f2584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f2585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<Pair<String, String>> f2586f;

    /* JADX INFO: renamed from: b.f.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EventsConfiguration.java */
    public static class C0041a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2587a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private e f2590d;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2588b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f2589c = GrpcUtil.HTTP_METHOD;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f2591e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ArrayList<Pair<String, String>> f2592f = new ArrayList<>();

        public C0041a(String str) {
            this.f2587a = "";
            if (str == null || str.isEmpty()) {
                return;
            }
            this.f2587a = str;
        }

        public C0041a a(e eVar) {
            this.f2590d = eVar;
            return this;
        }

        public C0041a b(boolean z) {
            this.f2588b = z;
            return this;
        }

        public C0041a a(List<Pair<String, String>> list) {
            this.f2592f.addAll(list);
            return this;
        }

        public C0041a b() {
            this.f2589c = "GET";
            return this;
        }

        public C0041a a(boolean z) {
            this.f2591e = z;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }

    a(C0041a c0041a) {
        this.f2585e = false;
        this.f2581a = c0041a.f2587a;
        this.f2582b = c0041a.f2588b;
        this.f2583c = c0041a.f2589c;
        this.f2584d = c0041a.f2590d;
        this.f2585e = c0041a.f2591e;
        if (c0041a.f2592f != null) {
            this.f2586f = new ArrayList<>(c0041a.f2592f);
        }
    }

    public boolean a() {
        return this.f2582b;
    }

    public String b() {
        return this.f2581a;
    }

    public e c() {
        return this.f2584d;
    }

    public ArrayList<Pair<String, String>> d() {
        return new ArrayList<>(this.f2586f);
    }

    public String e() {
        return this.f2583c;
    }

    public boolean f() {
        return this.f2585e;
    }
}
