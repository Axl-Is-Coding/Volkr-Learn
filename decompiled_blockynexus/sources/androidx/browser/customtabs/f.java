package androidx.browser.customtabs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: compiled from: CustomTabsIntent.java */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f774b;

    /* JADX INFO: compiled from: CustomTabsIntent.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Intent f775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList<Bundle> f776b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bundle f777c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ArrayList<Bundle> f778d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f779e;

        public a() {
            this(null);
        }

        public f a() {
            ArrayList<Bundle> arrayList = this.f776b;
            if (arrayList != null) {
                this.f775a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f778d;
            if (arrayList2 != null) {
                this.f775a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f775a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f779e);
            return new f(this.f775a, this.f777c);
        }

        public a(i iVar) {
            this.f775a = new Intent("android.intent.action.VIEW");
            this.f776b = null;
            this.f777c = null;
            this.f778d = null;
            this.f779e = true;
            if (iVar != null) {
                Intent intent = this.f775a;
                iVar.b();
                throw null;
            }
            Bundle bundle = new Bundle();
            if (iVar != null) {
                iVar.a();
                throw null;
            }
            androidx.core.app.i.a(bundle, "android.support.customtabs.extra.SESSION", null);
            this.f775a.putExtras(bundle);
        }
    }

    f(Intent intent, Bundle bundle) {
        this.f773a = intent;
        this.f774b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f773a.setData(uri);
        androidx.core.content.b.a(context, this.f773a, this.f774b);
    }
}
