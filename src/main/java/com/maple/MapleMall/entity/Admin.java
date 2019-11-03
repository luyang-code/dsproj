package com.maple.MapleMall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Admin {
    private Integer adminId;//管理员id
    private String adminNum;//管理员编号
    private String adminName;//管理员名称
    private String adminPassword;//管理员密码
    private int adminDel;//管理员删除标记
    private String adminRE;
}
