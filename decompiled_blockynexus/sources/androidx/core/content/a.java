package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;

/* JADX INFO: compiled from: ContentResolverCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, androidx.core.os.a aVar) throws Exception {
        Object objB;
        if (Build.VERSION.SDK_INT < 16) {
            if (aVar != null) {
                aVar.d();
            }
            return contentResolver.query(uri, strArr, str, strArr2, str2);
        }
        if (aVar != null) {
            try {
                objB = aVar.b();
            } catch (Exception e2) {
                if (e2 instanceof OperationCanceledException) {
                    throw new androidx.core.os.OperationCanceledException();
                }
                throw e2;
            }
        } else {
            objB = null;
        }
        return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) objB);
    }
}
