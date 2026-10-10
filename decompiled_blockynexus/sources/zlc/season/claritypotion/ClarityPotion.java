package zlc.season.claritypotion;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import kotlin.TypeCastException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: ClarityPotion.kt */
/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"StaticFieldLeak"})
public final class ClarityPotion extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f23644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f23645b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f23647d = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f23646c = new c();

    /* JADX INFO: compiled from: ClarityPotion.kt */
    public static final class a {
        private a() {
        }

        public final Context a() {
            Context context = ClarityPotion.f23644a;
            if (context != null) {
                return context;
            }
            i.c("clarityPotion");
            throw null;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        i.b(uri, ShareConstants.MEDIA_URI);
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        i.b(uri, ShareConstants.MEDIA_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        i.b(uri, ShareConstants.MEDIA_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            i.a();
            throw null;
        }
        f23644a = context;
        Context context2 = f23644a;
        if (context2 == null) {
            i.c("clarityPotion");
            throw null;
        }
        Context applicationContext = context2.getApplicationContext();
        if (applicationContext == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
        }
        f23645b = (Application) applicationContext;
        c cVar = f23646c;
        Application application = f23645b;
        if (application != null) {
            cVar.a(application);
            return true;
        }
        i.c("healingSalve");
        throw null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        i.b(uri, ShareConstants.MEDIA_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        i.b(uri, ShareConstants.MEDIA_URI);
        return 0;
    }
}
