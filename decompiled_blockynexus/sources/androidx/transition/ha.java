package androidx.transition;

import android.view.View;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: TransitionValues.java */
/* JADX INFO: loaded from: classes.dex */
public class ha {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f2247b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f2246a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList<Transition> f2248c = new ArrayList<>();

    @Deprecated
    public ha() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ha)) {
            return false;
        }
        ha haVar = (ha) obj;
        return this.f2247b == haVar.f2247b && this.f2246a.equals(haVar.f2246a);
    }

    public int hashCode() {
        return (this.f2247b.hashCode() * 31) + this.f2246a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f2247b + UMCustomLogInfoBuilder.LINE_SEP) + "    values:";
        for (String str2 : this.f2246a.keySet()) {
            str = str + "    " + str2 + ": " + this.f2246a.get(str2) + UMCustomLogInfoBuilder.LINE_SEP;
        }
        return str;
    }

    public ha(View view) {
        this.f2247b = view;
    }
}
