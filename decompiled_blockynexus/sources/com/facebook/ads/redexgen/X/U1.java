package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.SystemClock;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class U1 extends C6P {
    public final Context A00;
    public final ApplicationInfo A01;
    public final C13815p A02;
    public final C14096s A03;

    public U1(Context context, C13815p c13815p) {
        super(context, c13815p);
        this.A01 = context.getApplicationInfo();
        this.A00 = context;
        this.A02 = c13815p;
        this.A03 = C14096s.A00(this.A00, this.A02.A0a(), this.A02.A0g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"Nullable Dereference"})
    public AbstractC14046n A05(HashMap<Integer, U0> map) {
        return new WS(SystemClock.elapsedRealtime(), A03(), map, EnumC14036m.A06);
    }

    public final C6Y A0H() {
        return new C1963Tq(this);
    }

    public final C6Y A0I() {
        return new C1961To(this);
    }

    public final C6Y A0J() {
        return new C1960Tn(this);
    }

    public final C6Y A0K() {
        return new C1956Tj(this);
    }

    public final C6Y A0L() {
        return new C1968Tv(this);
    }

    public final C6Y A0M() {
        return new C1971Ty(this);
    }

    public final C6Y A0N() {
        return new C1964Tr(this);
    }

    public final C6Y A0O() {
        return new C1965Ts(this);
    }

    public final C6Y A0P() {
        return new C1969Tw(this);
    }

    public final C6Y A0Q() {
        return new C1972Tz(this);
    }

    public final C6Y A0R() {
        return new C1970Tx(this);
    }

    public final C6Y A0S() {
        return new C1967Tu(this);
    }

    public final C6Y A0T() {
        return new C1966Tt(this);
    }

    public final C6Y A0U() {
        return new C1954Th(this);
    }

    public final C6Y A0V() {
        return new C1955Ti(this);
    }

    public final C6Y A0W() {
        return new C1957Tk(this);
    }

    public final C6Y A0X() {
        return new C1958Tl(this);
    }

    public final C6Y A0Y() {
        return new C1959Tm(this);
    }

    public final C6Y A0Z() {
        return new C1962Tp(this);
    }
}
