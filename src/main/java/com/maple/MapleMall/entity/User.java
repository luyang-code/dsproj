package com.maple.MapleMall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer userId;//会员id
    private String userNum;//会员编号
    private String userName;//会员名称
    private String userPassword;//会员密码
    private int userDel;//会员删除标记
    private String userRE;

}
