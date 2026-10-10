package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: TaskStackBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Iterable<Intent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<Intent> f1036a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1037b;

    /* JADX INFO: compiled from: TaskStackBuilder.java */
    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private r(Context context) {
        this.f1037b = context;
    }

    public static r a(Context context) {
        return new r(context);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1036a.iterator();
    }

    public r a(Intent intent) {
        this.f1036a.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r a(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = j.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f1037b.getPackageManager());
            }
            a(component);
            a(supportParentActivityIntent);
        }
        return this;
    }

    public r a(ComponentName componentName) {
        int size = this.f1036a.size();
        try {
            Intent intentA = j.a(this.f1037b, componentName);
            while (intentA != null) {
                this.f1036a.add(size, intentA);
                intentA = j.a(this.f1037b, intentA.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    public void a() {
        a((Bundle) null);
    }

    public void a(Bundle bundle) {
        if (!this.f1036a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f1036a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (androidx.core.content.b.a(this.f1037b, intentArr, bundle)) {
                return;
            }
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f1037b.startActivity(intent);
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
