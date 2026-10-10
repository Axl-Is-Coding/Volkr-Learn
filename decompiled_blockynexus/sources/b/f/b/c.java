package b.f.b;

import android.os.AsyncTask;
import android.util.Pair;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.ArrayList;

/* JADX INFO: compiled from: EventsSender.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends AsyncTask<Object, Void, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList f2607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f2608b;

    public c(e eVar) {
        this.f2608b = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        e eVar = this.f2608b;
        if (eVar != null) {
            eVar.a(this.f2607a, bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.AsyncTask
    public Boolean doInBackground(Object... objArr) {
        try {
            this.f2607a = (ArrayList) objArr[2];
            boolean z = true;
            String str = (String) objArr[1];
            String str2 = (String) objArr[0];
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair("Content-Type", AbstractSpiCall.ACCEPT_JSON_VALUE));
            arrayList.add(new Pair("Content-Length", String.valueOf(str2.length())));
            if (b.f.c.c.b(str, str2, arrayList).f2621a != 200) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception unused) {
            return false;
        }
    }
}
