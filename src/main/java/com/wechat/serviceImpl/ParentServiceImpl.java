package com.wechat.serviceImpl;

import com.wechat.dao.ParentDao;
import com.wechat.entity.Parent;
import com.wechat.entity.ParentExample;
import com.wechat.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

	@Override
	public Parent getParentByOpenId(String openId) {
		ParentExample example = new ParentExample();
		example.or().andOpenidEqualTo(openId);

		List<Parent> list = parentMapper.selectByExample(example);
		if(list != null && list.size() != 0){
			return list.get(0);
		}
		return null;
	}
}
