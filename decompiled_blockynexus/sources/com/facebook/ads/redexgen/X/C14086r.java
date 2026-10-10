package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6r, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14086r {
    public int A00;
    public final Context A01;
    public final C13815p A02;
    public final InterfaceC14056o A03;
    public final InterfaceC14066p A04;
    public final Set<C6V> A05 = new HashSet();

    public C14086r(Context context, C13815p c13815p) {
        this.A02 = c13815p;
        this.A01 = context;
        this.A04 = c13815p.A0c();
        this.A03 = c13815p.A0b();
    }

    @Nullable
    private C14026l A00() {
        if (this.A02.A0a() == EnumC13936c.A0G) {
            return null;
        }
        Context context = this.A01;
        return new C14026l(context == null ? "" : context.getPackageName());
    }

    @SuppressLint({"CatchGeneralException"})
    private void A01(long j) {
        AbstractC14046n signalValueTypeDef;
        try {
            JSONObject jSONObject = new JSONObject();
            for (C6V c6v : this.A05) {
                C6Y c6yA01 = c6v.A01();
                if (c6yA01 == null) {
                    signalValueTypeDef = new WM(SystemClock.elapsedRealtime(), A00(), new C14016k(EnumC14006j.A04));
                } else {
                    try {
                        signalValueTypeDef = c6yA01.A58();
                    } catch (Throwable th) {
                        signalValueTypeDef = C14136w.A04(this.A01.getPackageName(), th);
                    }
                }
                jSONObject.put(Integer.toString(c6v.A00()), signalValueTypeDef.A0A(false));
            }
            throw null;
        } catch (Throwable t) {
            AnonymousClass61.A04(t);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    private void A02(long j) {
        try {
            this.A02.A0j().schedule(new Runnable() { // from class: com.facebook.ads.redexgen.X.6q
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    if (KL.A02(this)) {
                        return;
                    }
                    try {
                        this.A00.A03();
                    } catch (Throwable th) {
                        KL.A00(th, this);
                    }
                }
            }, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            AnonymousClass61.A04(th);
        }
    }

    @SuppressLint({"BadMethodUse-java.lang.System.currentTimeMillis"})
    public final void A03() {
        if (this.A02.A0W() <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.A04.getLastPeriodicCollectionTimeMs() >= this.A02.A0W()) {
            A01(jCurrentTimeMillis);
            A02(this.A02.A0W());
        } else {
            A02(Math.abs(jCurrentTimeMillis - (this.A04.getLastPeriodicCollectionTimeMs() + this.A02.A0W())));
        }
    }

    public final void A04(int i) {
        this.A00 = i;
    }

    public final void A05(C6V c6v) {
        this.A05.add(c6v);
    }
}
