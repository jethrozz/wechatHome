package com.wechat.serviceImpl;

import com.wechat.dao.ParentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zxc on 2018/5/17.
 */
@Service
public class ParentServiceImpl {
	@Autowired
	private ParentDao parentMapper;
}
