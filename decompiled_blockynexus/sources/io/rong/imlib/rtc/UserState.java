package io.rong.imlib.rtc;

import android.os.Parcel;
import android.os.Parcelable;
import io.rong.common.ParcelUtils;

/* JADX INFO: loaded from: classes5.dex */
public class UserState implements Parcelable {
    public static final Parcelable.Creator<UserState> CREATOR = new Parcelable.Creator<UserState>() { // from class: io.rong.imlib.rtc.UserState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserState createFromParcel(Parcel parcel) {
            return new UserState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserState[] newArray(int i) {
            return new UserState[i];
        }
    };
    private State state;
    private String userId;

    public enum State {
        NONE(-1),
        JOIN(0),
        LEFT(1),
        OFFLINE(2);

        int value;

        State(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static State valueOf(int i) {
            for (State state : values()) {
                if (i == state.value) {
                    return state;
                }
            }
            return NONE;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public State getState() {
        return this.state;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.userId);
        parcel.writeInt(this.state.getValue());
    }

    public UserState() {
    }

    UserState(String str, State state) {
        this.userId = str;
        this.state = state;
    }

    private UserState(Parcel parcel) {
        setUserId(ParcelUtils.readFromParcel(parcel));
        setState(State.valueOf(ParcelUtils.readIntFromParcel(parcel).intValue()));
    }
}
