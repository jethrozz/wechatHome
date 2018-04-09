package com.wechat.serviceImpl;

import com.wechat.model.Menu;
import com.wechat.service.MenuService;
import com.wechat.util.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.wechat.util.HttpUtil.httpRequest;

/**
 * @作者: jethro
 * @时间: 2018/4/9
 * @描述：
 */
@Service
public class MenuServiceImpl implements MenuService {
    private static Logger log = LoggerFactory.getLogger(MenuServiceImpl.class);
    @Value("${wechat.menuCreateUrl}")
    private String menu_create_url;

    @Override
    public int createMenu(Menu menu, String accessToken) throws JSONException {
        int result = 0;
        if(accessToken == null){
            return -1;
        }
        // 拼装创建菜单的url
        String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
        // 将菜单对象转换成json字符串
        String jsonMenu = JSONUtils.toJson(menu);
        // 调用接口创建菜单
        JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);

        if (null != jsonObject) {
            if (0 != jsonObject.getInt("errcode")) {
                result = jsonObject.getInt("errcode");
                log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
            }
        }

        return result;
    }
}
