package com.plnus.puerility.counter.model.entity;

/**
 * Author: liuyanguo
 * Date: 2017/3/3
 * Time: 10:37
 * Description:用来记录是否已经点击记录的状态实体类
 */

public class RecordCurrentInfo {

    private static RecordCurrentInfo sInstance;

    public static RecordCurrentInfo get() {
        if (null == sInstance) {
            synchronized (RecordCurrentInfo.class) {
                if (null == sInstance) {
                    sInstance = new RecordCurrentInfo();
                }
            }
        }
        return sInstance;
    }

    private boolean isRecord;
    private String startPlace;
    private String reachPlace;
    private String startTime;
    private String reachTime;

    public boolean isRecord() {
        return isRecord;
    }

    public void setRecord(boolean record) {
        isRecord = record;
    }

    public String getReachPlace() {
        return reachPlace;
    }

    public void setReachPlace(String reachPlace) {
        this.reachPlace = reachPlace;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getReachTime() {
        return reachTime;
    }

    public void setReachTime(String reachTime) {
        this.reachTime = reachTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
