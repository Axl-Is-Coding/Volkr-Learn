package com.facebook.ads.internal.androidx.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import com.facebook.ads.internal.androidx.support.v4.view.AbsSavedState;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView$SavedState;
import com.facebook.ads.redexgen.X.C4E;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RecyclerView$SavedState extends AbsSavedState {
    public static final Parcelable.Creator<RecyclerView$SavedState> CREATOR = new Parcelable.ClassLoaderCreator<RecyclerView$SavedState>() { // from class: com.facebook.ads.redexgen.X.4O
        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final RecyclerView$SavedState createFromParcel(Parcel parcel) {
            return new RecyclerView$SavedState(parcel, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
        public final RecyclerView$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new RecyclerView$SavedState(parcel, classLoader);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
        public final RecyclerView$SavedState[] newArray(int i) {
            return new RecyclerView$SavedState[i];
        }
    };
    public Parcelable A00;

    public RecyclerView$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.A00 = parcel.readParcelable(classLoader == null ? C4E.class.getClassLoader() : classLoader);
    }

    public RecyclerView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public final void A03(RecyclerView$SavedState recyclerView$SavedState) {
        this.A00 = recyclerView$SavedState.A00;
    }

    @Override // com.facebook.ads.internal.androidx.support.v4.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.A00, 0);
    }
}
