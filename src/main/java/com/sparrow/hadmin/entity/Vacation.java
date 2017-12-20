package com.sparrow.hadmin.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.sparrow.hadmin.entity.support.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * 请假表
 * <p>
 * Created by peng.tan on 17/12/20.
 */
@Entity @Table(name = "tb_vacation") public class Vacation extends BaseEntity {

    /**
     * 请假表的主键
     */
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "id", nullable = false) private Integer id;

    /**
     * 关联的用户id
     */
    @ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY) @JoinTable(name = "tb_user_relation", joinColumns = {
            @JoinColumn(name = "vacation_id") }, inverseJoinColumns = { @JoinColumn(name = "id") }) private User user;

    /**
     * 请假开始时间
     */
    @JSONField(format = "yyyy-MM-dd") private Date vacation_start;

    /**
     * 请假结束时间
     */
    @JSONField(format = "yyyy-MM-dd") private Date vacation_end;

    /**
     * 请假原因
     */
    private String description;

    /**
     * 假期联系电话
     */
    private String homeNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getVacation_start() {
        return vacation_start;
    }

    public void setVacation_start(Date vacation_start) {
        this.vacation_start = vacation_start;
    }

    public Date getVacation_end() {
        return vacation_end;
    }

    public void setVacation_end(Date vacation_end) {
        this.vacation_end = vacation_end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHomeNum() {
        return homeNum;
    }

    public void setHomeNum(String homeNum) {
        this.homeNum = homeNum;
    }

}
