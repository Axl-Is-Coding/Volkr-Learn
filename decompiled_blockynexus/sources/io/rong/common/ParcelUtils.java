package io.rong.common;

import android.os.Parcel;
import android.os.Parcelable;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ParcelUtils {
    public static <T extends Parcelable> T bytesToParcelable(byte[] bArr, Class<T> cls) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        T t = (T) readFromParcel(parcelObtain, cls);
        parcelObtain.recycle();
        return t;
    }

    public static <T extends Parcelable> List<T> bytesToParcelableList(byte[] bArr, Class<T> cls) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        ArrayList listFromParcel = readListFromParcel(parcelObtain, cls);
        parcelObtain.recycle();
        return listFromParcel;
    }

    public static byte[] parcelableListToByte(List<? extends Parcelable> list) {
        if (list == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        writeListToParcel(parcelObtain, list);
        return parcelObtain.marshall();
    }

    public static byte[] parcelableToByte(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        writeToParcel(parcelObtain, parcelable);
        return parcelObtain.marshall();
    }

    public static Date readDateFromParcel(Parcel parcel) {
        long j = parcel.readLong();
        if (j != 0) {
            return new Date(j);
        }
        return null;
    }

    public static Double readDoubleFromParcel(Parcel parcel) {
        return Double.valueOf(parcel.readDouble());
    }

    public static Float readFloatFromParcel(Parcel parcel) {
        return Float.valueOf(parcel.readFloat());
    }

    public static String readFromParcel(Parcel parcel) {
        return parcel.readString();
    }

    public static Integer readIntFromParcel(Parcel parcel) {
        return Integer.valueOf(parcel.readInt());
    }

    public static <T> ArrayList<T> readListFromParcel(Parcel parcel, Class<T> cls) {
        return parcel.readArrayList(cls.getClassLoader());
    }

    public static Long readLongFromParcel(Parcel parcel) {
        return Long.valueOf(parcel.readLong());
    }

    public static Map readMapFromParcel(Parcel parcel) {
        return parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public static void writeListToParcel(Parcel parcel, List<?> list) {
        parcel.writeList(list);
    }

    public static void writeToParcel(Parcel parcel, String str) {
        parcel.writeString(str);
    }

    public static <T extends Parcelable> T readFromParcel(Parcel parcel, Class<T> cls) {
        return (T) parcel.readParcelable(cls.getClassLoader());
    }

    public static void writeToParcel(Parcel parcel, Long l) {
        parcel.writeLong(l != null ? l.longValue() : 0L);
    }

    public static void writeToParcel(Parcel parcel, Integer num) {
        parcel.writeInt(num != null ? num.intValue() : 0);
    }

    public static void writeToParcel(Parcel parcel, Float f2) {
        parcel.writeFloat(f2 != null ? f2.floatValue() : WheelView.DividerConfig.FILL);
    }

    public static void writeToParcel(Parcel parcel, Double d2) {
        parcel.writeDouble(d2 != null ? d2.doubleValue() : 0.0d);
    }

    public static void writeToParcel(Parcel parcel, Map map) {
        parcel.writeMap(map);
    }

    public static void writeToParcel(Parcel parcel, Date date) {
        parcel.writeLong(date != null ? date.getTime() : 0L);
    }

    public static <T extends Parcelable> void writeToParcel(Parcel parcel, T t) {
        parcel.writeParcelable(t, 0);
    }

    public static <T extends List<?>> void writeToParcel(Parcel parcel, T t) {
        parcel.writeList(t);
    }
}
