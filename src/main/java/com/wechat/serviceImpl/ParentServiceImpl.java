package com.wechat.serviceImpl;

import com.wechat.dao.ParentDao;
import com.wechat.entity.Parent;
import com.wechat.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zxc on 2018/5/17.
 */
@Service
public class ParentServiceImpl implements ParentService{
	@Autowired
	private ParentDao parentMapper;

	@Override
	public Parent addParent(Parent parent) {
		parentMapper.insertSelective(parent);
		return parent;
	}

	@Override
	public boolean updateParent(Parent parent) {
		if(parentMapper.updateByPrimaryKeySelective(parent) >= 1){
			return true;
		}
		return false;
	}
}
