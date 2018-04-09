package com.wechat.service;

import com.wechat.model.Menu;
import org.json.JSONException;

/**
 * @作者: jethro
 * @时间: 2018/4/9
 * @描述：
 */
public interface MenuService {
    int createMenu(Menu menu, String accessToken) throws JSONException;
}
