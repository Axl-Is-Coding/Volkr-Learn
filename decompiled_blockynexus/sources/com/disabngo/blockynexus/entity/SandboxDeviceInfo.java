package com.disabngo.blockynexus.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class SandboxDeviceInfo implements Serializable {
    private String cpu;
    private String name;
    private String ram;
    private String rom;
    private String version;

    public String getCpu() {
        return this.cpu;
    }

    public String getName() {
        return this.name;
    }

    public String getRam() {
        return this.ram;
    }

    public String getRom() {
        return this.rom;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCpu(String str) {
        this.cpu = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRam(String str) {
        this.ram = str;
    }

    public void setRom(String str) {
        this.rom = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
