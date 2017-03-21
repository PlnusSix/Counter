package com.plnus.puerility.counter.model.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Author: liuyanguo
 * Date: 2017/2/7
 * Time: 22:30
 * Description:
 */

@Entity
public class RouteEntity {
    @Id
    private Long id;
    @Property
    private String startPlace;
    @Property
    private String reachPlace;
    @Property
    private String startTime;
    @Property
    private String reachTime;
    @Generated(hash = 1864500391)
    public RouteEntity(Long id, String startPlace, String reachPlace,
            String startTime, String reachTime) {
        this.id = id;
        this.startPlace = startPlace;
        this.reachPlace = reachPlace;
        this.startTime = startTime;
        this.reachTime = reachTime;
    }
    @Generated(hash = 2061632751)
    public RouteEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStartPlace() {
        return this.startPlace;
    }
    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }
    public String getReachPlace() {
        return this.reachPlace;
    }
    public void setReachPlace(String reachPlace) {
        this.reachPlace = reachPlace;
    }
    public String getStartTime() {
        return this.startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getReachTime() {
        return this.reachTime;
    }
    public void setReachTime(String reachTime) {
        this.reachTime = reachTime;
    }
}
