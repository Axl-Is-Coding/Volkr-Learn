package com.ironsource.mediationsdk.model;

/* JADX INFO: compiled from: PlacementAvailabilitySettings.java */
/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f14921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PlacementCappingType f14924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14926f;

    /* JADX INFO: compiled from: PlacementAvailabilitySettings.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f14927a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f14928b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f14929c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private PlacementCappingType f14930d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f14931e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f14932f = 0;

        public a a(boolean z) {
            this.f14927a = z;
            return this;
        }

        public a a(boolean z, PlacementCappingType placementCappingType, int i) {
            this.f14928b = z;
            if (placementCappingType == null) {
                placementCappingType = PlacementCappingType.PER_DAY;
            }
            this.f14930d = placementCappingType;
            this.f14931e = i;
            return this;
        }

        public a a(boolean z, int i) {
            this.f14929c = z;
            this.f14932f = i;
            return this;
        }

        public n a() {
            return new n(this.f14927a, this.f14928b, this.f14929c, this.f14930d, this.f14931e, this.f14932f);
        }
    }

    public PlacementCappingType a() {
        return this.f14924d;
    }

    public int b() {
        return this.f14925e;
    }

    public int c() {
        return this.f14926f;
    }

    public boolean d() {
        return this.f14922b;
    }

    public boolean e() {
        return this.f14921a;
    }

    public boolean f() {
        return this.f14923c;
    }

    private n(boolean z, boolean z2, boolean z3, PlacementCappingType placementCappingType, int i, int i2) {
        this.f14921a = z;
        this.f14922b = z2;
        this.f14923c = z3;
        this.f14924d = placementCappingType;
        this.f14925e = i;
        this.f14926f = i2;
    }
}
