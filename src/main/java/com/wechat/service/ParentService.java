package com.wechat.service;

import com.wechat.entity.Parent;
import com.wechat.entity.Teacher;

/**
 * Created by zxc on 2018/5/31.
 */
public interface ParentService {
	Parent addParent(Parent parent);
	boolean updateParent(Parent parent);
	Parent getParentByOpenId(String openId);
}
