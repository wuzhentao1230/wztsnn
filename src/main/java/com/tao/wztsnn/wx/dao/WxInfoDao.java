package com.tao.wztsnn.wx.dao;

import com.tao.wztsnn.wx.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/***
 * -- 存在即更新，不存在就插入(根据ID)
 * insert into `vclb_mm_inventory` (`ID_`, `STOCK_ID_`, `ITEM_ID_`, `AMOUNT_`)
 * values ('489734716803514367', '仓库一', '水杯', 44)
 * ON DUPLICATE KEY UPDATE `AMOUNT_` = `AMOUNT_` + 44;
 *
 * -- 将物品名称与仓库名称修改为库存表中唯一索引
 * ALTER TABLE vclb_mm_inventory ADD unique(`STOCK_ID_` , `ITEM_ID_`);
 */
@Repository
public interface WxInfoDao {
//    @Insert("insert into person_information(openId ,name, phone, depart, menu) values(#{openId},#{name},#{phone},#{depart},#{menu})")
    @Insert("insert into `user_info` (`openid`, `nickName`, `avatarUrl`, `city`, `country`, `province`, `gender`, `language`)" +
            "values (#{openid},#{nickName},#{avatarUrl},#{city},#{country},#{province},#{gender},#{language}) " +
            "ON DUPLICATE KEY UPDATE `avatarUrl` = #{avatarUrl}")
    public int insertPersonInfo(UserInfo userInfo);
}
