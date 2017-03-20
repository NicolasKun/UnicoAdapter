package com.nicolaskun.unicoadapter.bean;

/**
 * Created by unicolas on 2017/3/20.
 */

public class TestBean {
    private long zan;
    private String name;
    private String signture;

    public TestBean() {
    }

    public TestBean(long zan, String name, String signture) {
        this.zan = zan;
        this.name = name;
        this.signture = signture;
    }

    public long getZan() {
        return zan;
    }

    public void setZan(long zan) {
        this.zan = zan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignture() {
        return signture;
    }

    public void setSignture(String signture) {
        this.signture = signture;
    }
}
