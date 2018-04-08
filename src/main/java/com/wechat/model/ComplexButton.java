package com.wechat.model;

import java.util.List;

/**
 * @作者: jethro
 * @时间: 2018/4/8
 * @描述：父级菜单按钮
 */
public class ComplexButton extends Button {
    private List<Button> sub_button;

    public List<Button> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<Button> sub_button) {
        this.sub_button = sub_button;
    }
}
