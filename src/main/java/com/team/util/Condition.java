package com.team.util;

/**
 * @Author ZzHh
 * @Classname Condition
 * @Description TODO
 * @Date: Created in 2020/2/6 18:38
 * @Create By IntelliJ IDEA
 **/

public class Condition extends PageParameter {
    private String softwarename; //名称
    private Long status; //状态
    private Long flatformid;  //所属平台
    private Long categorylevel1; //类别1
    private Long categorylevel2; //类别2
    private Long categorylevel3; //类别3

    //添加开发者的用户id条件
    private Long devid;

    public Long getDevid() {
        return devid;
    }

    public void setDevid(Long devid) {
        this.devid = devid;
    }

    public String getSoftwarename() {
        return softwarename;
    }

    public void setSoftwarename(String softwarename) {
        this.softwarename = softwarename;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getFlatformid() {
        return flatformid;
    }

    public void setFlatformid(Long flatformid) {
        this.flatformid = flatformid;
    }

    public Long getCategorylevel1() {
        return categorylevel1;
    }

    public void setCategorylevel1(Long categorylevel1) {
        this.categorylevel1 = categorylevel1;
    }

    public Long getCategorylevel2() {
        return categorylevel2;
    }

    public void setCategorylevel2(Long categorylevel2) {
        this.categorylevel2 = categorylevel2;
    }

    public Long getCategorylevel3() {
        return categorylevel3;
    }

    public void setCategorylevel3(Long categorylevel3) {
        this.categorylevel3 = categorylevel3;
    }
}
