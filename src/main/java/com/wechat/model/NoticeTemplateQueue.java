package com.wechat.model;

import com.wechat.entity.NoticeBulletin;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;



public class NoticeTemplateQueue {
    private BlockingQueue<NoticeBulletin> templatePushQueue;

    private NoticeTemplateQueue(){
        templatePushQueue = new LinkedBlockingDeque<>();
    }

    private static NoticeTemplateQueue instance = null;

    public static synchronized NoticeTemplateQueue getInstance(){
        if(instance == null){
            instance = new NoticeTemplateQueue();
        }
        return instance;
    }

    public BlockingQueue<NoticeBulletin> getTemplateQueue() {
        return templatePushQueue;
    }

    public void addTemplate(NoticeBulletin registInfo){
        templatePushQueue.offer(registInfo);
    }
}
