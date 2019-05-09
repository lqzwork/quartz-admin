package com.ffxl.platform.util.eap;

public class DefaultIdGeneratorConfig implements IdGeneratorConfig {

    public String getSplitString() {
        return "";
    }

    public int getInitial() {
        return 1;
    }

    public String getPrefix() {
        return "";
    }

    public int getRollingInterval() {
        return 1;
    }

}
