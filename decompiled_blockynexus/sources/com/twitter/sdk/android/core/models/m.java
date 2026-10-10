package com.twitter.sdk.android.core.models;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;

/* JADX INFO: compiled from: Tweet.java */
/* JADX INFO: loaded from: classes5.dex */
public class m implements f {

    @com.google.gson.a.c(alternate = {"full_text"}, value = ViewHierarchyConstants.TEXT_KEY)
    public final String A;

    @com.google.gson.a.c("display_text_range")
    public final List<Integer> B;

    @com.google.gson.a.c("truncated")
    public final boolean C;

    @com.google.gson.a.c("user")
    public final User D;

    @com.google.gson.a.c("withheld_copyright")
    public final boolean E;

    @com.google.gson.a.c("withheld_in_countries")
    public final List<String> F;

    @com.google.gson.a.c("withheld_scope")
    public final String G;

    @com.google.gson.a.c("card")
    public final d H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.a.c("coordinates")
    public final e f20238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.a.c("created_at")
    public final String f20239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.a.c("current_user_retweet")
    public final Object f20240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.gson.a.c("entities")
    public final o f20241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.google.gson.a.c("extended_entities")
    public final o f20242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.gson.a.c("favorite_count")
    public final Integer f20243f;

    @com.google.gson.a.c("favorited")
    public final boolean g;

    @com.google.gson.a.c("filter_level")
    public final String h;

    @com.google.gson.a.c("id")
    public final long i;

    @com.google.gson.a.c("id_str")
    public final String j;

    @com.google.gson.a.c("in_reply_to_screen_name")
    public final String k;

    @com.google.gson.a.c("in_reply_to_status_id")
    public final long l;

    @com.google.gson.a.c("in_reply_to_status_id_str")
    public final String m;

    @com.google.gson.a.c("in_reply_to_user_id")
    public final long n;

    @com.google.gson.a.c("in_reply_to_user_id_str")
    public final String o;

    @com.google.gson.a.c("lang")
    public final String p;

    @com.google.gson.a.c("place")
    public final j q;

    @com.google.gson.a.c("possibly_sensitive")
    public final boolean r;

    @com.google.gson.a.c("scopes")
    public final Object s;

    @com.google.gson.a.c("quoted_status_id")
    public final long t;

    @com.google.gson.a.c("quoted_status_id_str")
    public final String u;

    @com.google.gson.a.c("quoted_status")
    public final m v;

    @com.google.gson.a.c("retweet_count")
    public final int w;

    @com.google.gson.a.c("retweeted")
    public final boolean x;

    @com.google.gson.a.c("retweeted_status")
    public final m y;

    @com.google.gson.a.c("source")
    public final String z;

    /* JADX WARN: Illegal instructions before constructor call */
    private m() {
        o oVar = o.f20250a;
        this(null, null, null, oVar, oVar, 0, false, null, 0L, "0", null, 0L, "0", 0L, "0", null, null, false, null, 0L, "0", null, 0, false, null, null, null, null, false, null, false, null, null, null);
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof m) && this.i == ((m) obj).i;
    }

    @Override // com.twitter.sdk.android.core.models.f
    public long getId() {
        return this.i;
    }

    public int hashCode() {
        return (int) this.i;
    }

    public m(e eVar, String str, Object obj, o oVar, o oVar2, Integer num, boolean z, String str2, long j, String str3, String str4, long j2, String str5, long j3, String str6, String str7, j jVar, boolean z2, Object obj2, long j4, String str8, m mVar, int i, boolean z3, m mVar2, String str9, String str10, List<Integer> list, boolean z4, User user, boolean z5, List<String> list2, String str11, d dVar) {
        this.f20238a = eVar;
        this.f20239b = str;
        this.f20240c = obj;
        this.f20241d = oVar == null ? o.f20250a : oVar;
        this.f20242e = oVar2 == null ? o.f20250a : oVar2;
        this.f20243f = num;
        this.g = z;
        this.h = str2;
        this.i = j;
        this.j = str3;
        this.k = str4;
        this.l = j2;
        this.m = str5;
        this.n = j3;
        this.o = str6;
        this.p = str7;
        this.q = jVar;
        this.r = z2;
        this.s = obj2;
        this.t = j4;
        this.u = str8;
        this.v = mVar;
        this.w = i;
        this.x = z3;
        this.y = mVar2;
        this.z = str9;
        this.A = str10;
        this.B = i.a(list);
        this.C = z4;
        this.D = user;
        this.E = z5;
        this.F = i.a(list2);
        this.G = str11;
        this.H = dVar;
    }
}
