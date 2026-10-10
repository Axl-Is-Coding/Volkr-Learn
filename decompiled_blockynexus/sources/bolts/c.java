package bolts;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: AppLink.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f2821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<a> f2822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f2823c;

    /* JADX INFO: compiled from: AppLink.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f2824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f2825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f2826c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f2827d;

        public a(String str, String str2, Uri uri, String str3) {
            this.f2825b = str;
            this.f2826c = str2;
            this.f2824a = uri;
            this.f2827d = str3;
        }
    }

    public c(Uri uri, List<a> list, Uri uri2) {
        this.f2821a = uri;
        this.f2822b = list == null ? Collections.emptyList() : list;
        this.f2823c = uri2;
    }
}
