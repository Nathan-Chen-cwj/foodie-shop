package net.seehope.foodie_shop.pojo;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author vessel
 */
@Table(name = "`admin_table`")
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    @Column(name = "`id`")
    private String id;

    @Column(name = "`username`")
    private String username;

    @Column(name = "`password`")
    private String password;

    @Column(name = "`mobile`")
    private String mobile;

    @Column(name = "`created_time`")
    private Date createTime;

    @Column(name = "`updated_time`")
    private Date updateTime;

    @Column(name = "`power`")
    private Integer power;


    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }


    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }


    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }


    public String getMobile() {
      return mobile;
    }

    public void setMobile(String mobile) {
      this.mobile = mobile;
    }


    public Date getCreateTime() {
      return createTime;
    }

    public void setCreateTime(Date createTime) {
      this.createTime = createTime;
    }


    public Date getUpdateTime() {
      return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
      this.updateTime = updateTime;
    }


    public Integer getPower() {
      return power;
    }

    public void setPower(Integer power) {
      this.power = power;
    }

}
