package com.tendcloud.tenddata;

import android.os.Parcel;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class s extends File {
    public final String content;

    /* JADX INFO: compiled from: td */
    static class a extends s {
        public ArrayList<b> groups;

        private a(String str) {
            super(str);
            try {
                this.groups = new ArrayList<>();
                for (String str2 : this.content.split(UMCustomLogInfoBuilder.LINE_SEP)) {
                    try {
                        this.groups.add(new b(str2));
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable unused2) {
            }
        }

        public static a get(int i) {
            try {
                return new a(String.format("/proc/%d/cgroup", Integer.valueOf(i)));
            } catch (Throwable unused) {
                return null;
            }
        }

        public b getGroup(String str) {
            try {
                for (b bVar : this.groups) {
                    for (String str2 : bVar.subsystems.split(",")) {
                        if (str2.equals(str)) {
                            return bVar;
                        }
                    }
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: td */
    static class d extends s {
        private d(String str) {
            super(str);
        }

        public static d get(int i) {
            try {
                return new d(String.format("/proc/%d/status", Integer.valueOf(i)));
            } catch (Throwable unused) {
                return null;
            }
        }

        public int getGid() {
            try {
                return Integer.parseInt(getValue("Gid").split("\\s+")[0]);
            } catch (Throwable unused) {
                return -1;
            }
        }

        public int getUid() {
            try {
                return Integer.parseInt(getValue("Uid").split("\\s+")[0]);
            } catch (Throwable unused) {
                return -1;
            }
        }

        public String getValue(String str) {
            try {
                for (String str2 : this.content.split(UMCustomLogInfoBuilder.LINE_SEP)) {
                    if (str2.startsWith(str + ":")) {
                        return str2.split(str + ":")[1].trim();
                    }
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        private d(Parcel parcel) {
            super(parcel);
        }
    }

    protected s(String str) {
        super(str);
        this.content = readFile(str);
    }

    public static String readFile(String str) throws Throwable {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(str));
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
            }
        } catch (Throwable unused) {
        }
        try {
            String str2 = "";
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                sb.append(str2);
                sb.append(line);
                str2 = UMCustomLogInfoBuilder.LINE_SEP;
                if (sb.length() > 104857600) {
                    throw new RuntimeException("Input stream more than 100 MB size limit");
                }
            }
            String string = sb.toString();
            try {
                bufferedReader.close();
            } catch (Throwable unused2) {
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused3) {
                }
            }
            throw th;
        }
    }

    @Override // java.io.File
    public long length() {
        return this.content.length();
    }

    /* JADX INFO: compiled from: td */
    public static class c extends s {
        private String[] fields;

        private c(String str) {
            super(str);
            this.fields = new String[0];
            try {
                this.fields = this.content.split("\\s+");
            } catch (Throwable unused) {
            }
        }

        public static c get(int i) {
            try {
                return new c(String.format("/proc/%d/stat", Integer.valueOf(i)));
            } catch (Throwable unused) {
                return null;
            }
        }

        public String getComm() {
            try {
                return this.fields[1].replace("(", "").replace(")", "");
            } catch (Throwable unused) {
                return "";
            }
        }

        public long startTime() {
            try {
                return Long.parseLong(this.fields[21]);
            } catch (Throwable unused) {
                return 0L;
            }
        }

        public char state() {
            try {
                return this.fields[2].charAt(0);
            } catch (Throwable unused) {
                return (char) 0;
            }
        }

        private c(Parcel parcel) {
            super(parcel);
            this.fields = new String[0];
            try {
                this.fields = parcel.createStringArray();
            } catch (Throwable unused) {
            }
        }
    }

    protected s(Parcel parcel) {
        super(parcel.readString());
        this.content = parcel.readString();
    }

    /* JADX INFO: compiled from: td */
    static class b {
        protected String group;
        protected int id;
        protected String subsystems;

        protected b(String str) {
            try {
                String[] strArrSplit = str.split(":");
                this.id = Integer.parseInt(strArrSplit[0]);
                this.subsystems = strArrSplit[1];
                this.group = strArrSplit[2];
            } catch (Throwable unused) {
            }
        }

        protected b(Parcel parcel) {
            try {
                this.id = parcel.readInt();
                this.subsystems = parcel.readString();
                this.group = parcel.readString();
            } catch (Throwable unused) {
            }
        }
    }
}
