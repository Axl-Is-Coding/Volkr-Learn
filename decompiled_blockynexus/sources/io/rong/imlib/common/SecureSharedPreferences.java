package io.rong.imlib.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import io.rong.common.rlog.RLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class SecureSharedPreferences implements SharedPreferences {
    private static final String TAG = SharedPreferences.class.getName();
    private Context mContext;
    private SharedPreferences mSharedPreferences;

    public final class Editor implements SharedPreferences.Editor {
        private SharedPreferences.Editor mEditor;

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            this.mEditor.apply();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.mEditor.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return this.mEditor.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.mEditor.putString(str, SecureSharedPreferences.this.encryptPreference(Boolean.toString(z)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f2) {
            this.mEditor.putString(str, SecureSharedPreferences.this.encryptPreference(Float.toString(f2)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            this.mEditor.putString(str, SecureSharedPreferences.this.encryptPreference(Integer.toString(i)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            this.mEditor.putString(str, SecureSharedPreferences.this.encryptPreference(Long.toString(j)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            this.mEditor.putString(str, SecureSharedPreferences.this.encryptPreference(str2));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            HashSet hashSet = new HashSet();
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                hashSet.add(SecureSharedPreferences.this.encryptPreference(it.next()));
            }
            this.mEditor.putStringSet(str, hashSet);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.mEditor.remove(str);
            return this;
        }

        private Editor() {
            this.mEditor = SecureSharedPreferences.this.mSharedPreferences.edit();
        }
    }

    public SecureSharedPreferences(Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        if (this.mContext == null) {
            this.mContext = context;
        }
        if (TextUtils.isEmpty(str)) {
            this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        } else {
            this.mSharedPreferences = context.getSharedPreferences(str, i);
        }
    }

    private String decryptPreference(String str) {
        return EncryptUtil.getInstance(this.mContext).decrypt(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String encryptPreference(String str) {
        return EncryptUtil.getInstance(this.mContext).encrypt(str);
    }

    public static SecureSharedPreferences get(Context context, String str, int i) {
        return new SecureSharedPreferences(context, str, i);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.mSharedPreferences.contains(str);
    }

    @Override // android.content.SharedPreferences
    public Map<String, String> getAll() {
        Map<String, ?> all = this.mSharedPreferences.getAll();
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                map.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        try {
            String strDecryptPreference = decryptPreference(this.mSharedPreferences.getString(str, null));
            return strDecryptPreference == null ? z : Boolean.parseBoolean(strDecryptPreference);
        } catch (ClassCastException e2) {
            RLog.e(TAG, "getBoolean", e2);
            return z;
        }
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        try {
            String strDecryptPreference = decryptPreference(this.mSharedPreferences.getString(str, null));
            return strDecryptPreference == null ? f2 : Float.parseFloat(decryptPreference(strDecryptPreference));
        } catch (ClassCastException e2) {
            RLog.e(TAG, "getFloat", e2);
            return f2;
        }
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        try {
            String strDecryptPreference = decryptPreference(this.mSharedPreferences.getString(str, null));
            Log.d(TAG, "int:::key:" + str + ":" + strDecryptPreference);
            return strDecryptPreference == null ? i : Integer.parseInt(strDecryptPreference);
        } catch (ClassCastException e2) {
            RLog.e(TAG, "getInt", e2);
            return i;
        }
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        try {
            String strDecryptPreference = decryptPreference(this.mSharedPreferences.getString(str, null));
            return strDecryptPreference == null ? j : Long.parseLong(strDecryptPreference);
        } catch (ClassCastException e2) {
            RLog.e(TAG, "getLong", e2);
            return j;
        }
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        String strDecryptPreference = decryptPreference(this.mSharedPreferences.getString(str, null));
        return strDecryptPreference == null ? str2 : strDecryptPreference;
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> stringSet = this.mSharedPreferences.getStringSet(str, null);
        if (stringSet == null) {
            return set;
        }
        HashSet hashSet = new HashSet();
        Iterator<String> it = stringSet.iterator();
        while (it.hasNext()) {
            hashSet.add(decryptPreference(it.next()));
        }
        return hashSet;
    }

    public void handleTransition() {
        Map<String, ?> all = this.mSharedPreferences.getAll();
        HashMap map = new HashMap();
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            map.put(entry.getKey(), encryptPreference(entry.getValue().toString()));
        }
        SharedPreferences.Editor editorEdit = this.mSharedPreferences.edit();
        editorEdit.clear().apply();
        for (Map.Entry entry2 : map.entrySet()) {
            editorEdit.putString((String) entry2.getKey(), (String) entry2.getValue());
        }
        editorEdit.commit();
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mSharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mSharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public static SecureSharedPreferences get(Context context, String str) {
        return get(context, str, 0);
    }

    @Override // android.content.SharedPreferences
    public Editor edit() {
        return new Editor();
    }

    public static SecureSharedPreferences get(Context context) {
        return get(context, null, 0);
    }
}
