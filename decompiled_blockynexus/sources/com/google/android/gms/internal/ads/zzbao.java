package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbao {
    private static final zzbaq<Map<String, ?>> zzecz = new zzbar();

    public static List<String> zza(JSONArray jSONArray, List<String> list) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static Map<String, String> zzb(JsonReader jsonReader) throws IllegalStateException, IOException {
        HashMap map = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            map.put(jsonReader.nextName(), jsonReader.nextString());
        }
        jsonReader.endObject();
        return map;
    }

    public static JSONObject zzc(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException {
        JSONObject jSONObject = new JSONObject();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            JsonToken jsonTokenPeek = jsonReader.peek();
            if (JsonToken.BEGIN_ARRAY.equals(jsonTokenPeek)) {
                jSONObject.put(strNextName, zzd(jsonReader));
            } else if (JsonToken.BEGIN_OBJECT.equals(jsonTokenPeek)) {
                jSONObject.put(strNextName, zzc(jsonReader));
            } else if (JsonToken.BOOLEAN.equals(jsonTokenPeek)) {
                jSONObject.put(strNextName, jsonReader.nextBoolean());
            } else if (JsonToken.NUMBER.equals(jsonTokenPeek)) {
                jSONObject.put(strNextName, jsonReader.nextDouble());
            } else {
                if (!JsonToken.STRING.equals(jsonTokenPeek)) {
                    String strValueOf = String.valueOf(jsonTokenPeek);
                    StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 23);
                    sb.append("unexpected json token: ");
                    sb.append(strValueOf);
                    throw new IllegalStateException(sb.toString());
                }
                jSONObject.put(strNextName, jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return jSONObject;
    }

    public static JSONArray zzd(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException {
        JSONArray jSONArray = new JSONArray();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            JsonToken jsonTokenPeek = jsonReader.peek();
            if (JsonToken.BEGIN_ARRAY.equals(jsonTokenPeek)) {
                jSONArray.put(zzd(jsonReader));
            } else if (JsonToken.BEGIN_OBJECT.equals(jsonTokenPeek)) {
                jSONArray.put(zzc(jsonReader));
            } else if (JsonToken.BOOLEAN.equals(jsonTokenPeek)) {
                jSONArray.put(jsonReader.nextBoolean());
            } else if (JsonToken.NUMBER.equals(jsonTokenPeek)) {
                jSONArray.put(jsonReader.nextDouble());
            } else {
                if (!JsonToken.STRING.equals(jsonTokenPeek)) {
                    String strValueOf = String.valueOf(jsonTokenPeek);
                    StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 23);
                    sb.append("unexpected json token: ");
                    sb.append(strValueOf);
                    throw new IllegalStateException(sb.toString());
                }
                jSONArray.put(jsonReader.nextString());
            }
        }
        jsonReader.endArray();
        return jSONArray;
    }

    public static Bundle zzh(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> itKeys = jSONObject.keys();
        Bundle bundle = new Bundle();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (objOpt != null) {
                if (objOpt instanceof Boolean) {
                    bundle.putBoolean(next, ((Boolean) objOpt).booleanValue());
                } else if (objOpt instanceof Double) {
                    bundle.putDouble(next, ((Double) objOpt).doubleValue());
                } else if (objOpt instanceof Integer) {
                    bundle.putInt(next, ((Integer) objOpt).intValue());
                } else if (objOpt instanceof Long) {
                    bundle.putLong(next, ((Long) objOpt).longValue());
                } else if (objOpt instanceof String) {
                    bundle.putString(next, (String) objOpt);
                } else if (objOpt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) objOpt;
                    if (jSONArray != null && jSONArray.length() != 0) {
                        int length = jSONArray.length();
                        int i = 0;
                        Object objOpt2 = null;
                        for (int i2 = 0; objOpt2 == null && i2 < length; i2++) {
                            objOpt2 = !jSONArray.isNull(i2) ? jSONArray.opt(i2) : null;
                        }
                        if (objOpt2 == null) {
                            String strValueOf = String.valueOf(next);
                            zzbbq.zzfe(strValueOf.length() != 0 ? "Expected JSONArray with at least 1 non-null element for key:".concat(strValueOf) : new String("Expected JSONArray with at least 1 non-null element for key:"));
                        } else if (objOpt2 instanceof JSONObject) {
                            Bundle[] bundleArr = new Bundle[length];
                            while (i < length) {
                                bundleArr[i] = !jSONArray.isNull(i) ? zzh(jSONArray.optJSONObject(i)) : null;
                                i++;
                            }
                            bundle.putParcelableArray(next, bundleArr);
                        } else if (objOpt2 instanceof Number) {
                            double[] dArr = new double[jSONArray.length()];
                            while (i < length) {
                                dArr[i] = jSONArray.optDouble(i);
                                i++;
                            }
                            bundle.putDoubleArray(next, dArr);
                        } else if (objOpt2 instanceof CharSequence) {
                            String[] strArr = new String[length];
                            while (i < length) {
                                strArr[i] = !jSONArray.isNull(i) ? jSONArray.optString(i) : null;
                                i++;
                            }
                            bundle.putStringArray(next, strArr);
                        } else if (objOpt2 instanceof Boolean) {
                            boolean[] zArr = new boolean[length];
                            while (i < length) {
                                zArr[i] = jSONArray.optBoolean(i);
                                i++;
                            }
                            bundle.putBooleanArray(next, zArr);
                        } else {
                            zzbbq.zzfe(String.format("JSONArray with unsupported type %s for key:%s", objOpt2.getClass().getCanonicalName(), next));
                        }
                    }
                } else if (objOpt instanceof JSONObject) {
                    bundle.putBundle(next, zzh((JSONObject) objOpt));
                } else {
                    String strValueOf2 = String.valueOf(next);
                    zzbbq.zzfe(strValueOf2.length() != 0 ? "Unsupported type for key:".concat(strValueOf2) : new String("Unsupported type for key:"));
                }
            }
        }
        return bundle;
    }

    private static String zzk(Object obj) {
        if (obj == null) {
            return null;
        }
        StringWriter stringWriter = new StringWriter();
        try {
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            zza(jsonWriter, obj);
            jsonWriter.close();
            return stringWriter.toString();
        } catch (IOException e2) {
            zzbbq.zzc("Error when writing JSON.", e2);
            return null;
        }
    }

    public static List<String> zza(JsonReader jsonReader) throws IllegalStateException, IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(jsonReader.nextString());
        }
        jsonReader.endArray();
        return arrayList;
    }

    public static JSONObject zzb(JSONObject jSONObject, String str) throws JSONException {
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException unused) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, jSONObject2);
            return jSONObject2;
        }
    }

    public static String zza(zzbat zzbatVar) {
        return zzk(zzbatVar);
    }

    private static JSONObject zzb(JSONObject jSONObject, String[] strArr) {
        for (int i = 0; i < strArr.length - 1; i++) {
            if (jSONObject == null) {
                return null;
            }
            jSONObject = jSONObject.optJSONObject(strArr[i]);
        }
        return jSONObject;
    }

    public static void zza(JsonWriter jsonWriter, JSONObject jSONObject) throws IOException {
        try {
            jsonWriter.beginObject();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    jsonWriter.name(next).value((String) obj);
                } else if (obj instanceof Number) {
                    jsonWriter.name(next).value((Number) obj);
                } else if (obj instanceof Boolean) {
                    jsonWriter.name(next).value(((Boolean) obj).booleanValue());
                } else if (obj instanceof JSONObject) {
                    zza(jsonWriter.name(next), (JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    zza(jsonWriter.name(next), (JSONArray) obj);
                } else {
                    String strValueOf = String.valueOf(obj);
                    StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 23);
                    sb.append("unable to write field: ");
                    sb.append(strValueOf);
                    throw new JSONException(sb.toString());
                }
            }
            jsonWriter.endObject();
        } catch (JSONException e2) {
            throw new IOException(e2);
        }
    }

    private static void zza(JsonWriter jsonWriter, JSONArray jSONArray) throws IOException {
        try {
            jsonWriter.beginArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj = jSONArray.get(i);
                if (obj instanceof String) {
                    jsonWriter.value((String) obj);
                } else if (obj instanceof Number) {
                    jsonWriter.value((Number) obj);
                } else if (obj instanceof Boolean) {
                    jsonWriter.value(((Boolean) obj).booleanValue());
                } else if (obj instanceof JSONObject) {
                    zza(jsonWriter, (JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    zza(jsonWriter, (JSONArray) obj);
                } else {
                    String strValueOf = String.valueOf(obj);
                    StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 23);
                    sb.append("unable to write field: ");
                    sb.append(strValueOf);
                    throw new JSONException(sb.toString());
                }
            }
            jsonWriter.endArray();
        } catch (JSONException e2) {
            throw new IOException(e2);
        }
    }

    private static void zza(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return;
        }
        if (obj instanceof Boolean) {
            jsonWriter.value(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof String) {
            jsonWriter.value((String) obj);
            return;
        }
        if (obj instanceof zzbat) {
            ((zzbat) obj).zza(jsonWriter);
            return;
        }
        if (obj instanceof Map) {
            jsonWriter.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    zza(jsonWriter.name((String) key), entry.getValue());
                }
            }
            jsonWriter.endObject();
            return;
        }
        if (obj instanceof List) {
            jsonWriter.beginArray();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zza(jsonWriter, it.next());
            }
            jsonWriter.endArray();
            return;
        }
        jsonWriter.nullValue();
    }

    public static JSONObject zza(String str, Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(str, obj);
        return jSONObject;
    }

    public static JSONObject zza(JSONObject jSONObject, String... strArr) {
        JSONObject jSONObjectZzb = zzb(jSONObject, strArr);
        if (jSONObjectZzb == null) {
            return null;
        }
        return jSONObjectZzb.optJSONObject(strArr[strArr.length - 1]);
    }

    public static boolean zza(boolean z, JSONObject jSONObject, String... strArr) {
        JSONObject jSONObjectZzb = zzb(jSONObject, strArr);
        if (jSONObjectZzb == null) {
            return false;
        }
        return jSONObjectZzb.optBoolean(strArr[strArr.length - 1], false);
    }
}
