package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.ThreadSafe;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@ThreadSafe
public final class TR implements InterfaceC13835r {
    public static String[] A06;
    public C6Z A00;
    public C14146x A01;
    public RunnableC14156y A02;
    public final C13815p A03;
    public final C6K A04;
    public final AtomicBoolean A05 = new AtomicBoolean();

    static {
        A04();
    }

    public static void A04() {
        A06 = new String[]{"9Omy7cax2OJ4", "ulOhDbnf", "JfFg1yjSSK9TQh7N867q1b7oOj16BTWR", "cs88erT1Nmdhof2Vlv4YHjmvLJ5hV6oE", "codoSKf0AAHHcDxXKaV5ItDp", "Lc71QfpBcjqOx3z6Bpry4MoTnJ3L2Amk", "Bxh30V7DNH8aSp9XNgBHezc1nItbXmG0", "iIuCBEGs"};
    }

    public TR(C13815p c13815p, C6K c6k) {
        this.A03 = c13815p;
        this.A04 = c6k;
    }

    private final synchronized void A05() {
        if (this.A02 != null && this.A05.get()) {
            this.A01.A01(this.A02);
            C14106t.A00().A05();
            this.A04.A02();
            this.A05.compareAndSet(true, false);
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.facebook.ads.redexgen.X.6y] */
    public final synchronized void A06(final C6Z c6z) {
        if (this.A05.get() || c6z == null) {
            return;
        }
        if (this.A03.A0k() && C14136w.A0F(c6z)) {
            this.A01 = new C14146x(C14106t.A00().A04().getLooper());
            this.A00 = c6z;
            final Runnable runnable = new Runnable(c6z) { // from class: com.facebook.ads.redexgen.X.5t
                public C6Z A00;

                {
                    this.A00 = c6z;
                }

                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    if (KL.A02(this)) {
                        return;
                    }
                    try {
                        this.A01.A04.A04(EnumC13926b.A03, this.A00, null);
                        this.A01.A01.A02(this.A01.A02, TimeUnit.SECONDS.toMillis(this.A01.A03.A0T()));
                    } catch (Throwable th) {
                        KL.A00(th, this);
                    }
                }
            };
            this.A02 = new Runnable(runnable) { // from class: com.facebook.ads.redexgen.X.6y
                public static String[] A01;
                public final Runnable A00;

                static {
                    A00();
                }

                public static void A00() {
                    A01 = new String[]{"z7DaAYMF8mD5H3Qw6B0df8iWMA5TwaAo", "i1Wz58ppkDzwzyk3vUo3iJD7WEPTUBrQ", "4oPzuaqB78YGGa8PxFst9tbpOvboFZdU", "DouWW69VsyGxi7cZQAT3hM5mkvCiYUWz", "5sMQ3NVw4qAuaNcVNLKcvGJPjeyRgc94", "cawbZ6x1RsnaWkC6S2Mb4x7gKiXWIBBw", "BT64P8yXTg3gcHo3v2kn4U06ifDkl76a", "4iKgaC96n3YCvkeVNFuu4kvW5LMIVzNy"};
                }

                {
                    this.A00 = runnable;
                }

                @Override // java.lang.Runnable
                @SuppressLint({"CatchGeneralException"})
                public final void run() throws Throwable {
                    if (KL.A02(this)) {
                        return;
                    }
                    try {
                        this.A00.run();
                    } catch (Throwable t) {
                        try {
                            AnonymousClass61.A04(t);
                        } catch (Throwable th) {
                            if (A01[0].charAt(29) != 'a') {
                                Throwable t2 = new RuntimeException();
                                throw t2;
                            }
                            String[] strArr = A01;
                            strArr[0] = "SMPhcSCea3djEKnuzKFzvQw1eCBqlauj";
                            strArr[0] = "SMPhcSCea3djEKnuzKFzvQw1eCBqlauj";
                            KL.A00(th, this);
                        }
                    }
                }
            };
            this.A04.A03(c6z);
            this.A01.A00(this.A02);
            this.A05.compareAndSet(false, true);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13835r
    public final synchronized void ADx(C6Z c6z) {
        if (this.A00 == c6z) {
            return;
        }
        this.A00 = c6z;
        if (c6z == C6Z.A04) {
            A05();
        } else {
            A06(c6z);
        }
        String[] strArr = A06;
        if (strArr[5].charAt(25) != strArr[3].charAt(25)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[6] = "6KXzTJPK6a3Rx51uMQDwScazunOB6mre";
        strArr2[6] = "6KXzTJPK6a3Rx51uMQDwScazunOB6mre";
    }
}
