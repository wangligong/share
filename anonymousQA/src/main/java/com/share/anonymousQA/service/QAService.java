package com.share.anonymousQA.service;

import com.share.anonymousQA.util.Result;

import java.util.List;

public interface QAService {

    /**
     * 新增一个问题
     */
    void addQuestion(String time, String question);

    /**
     * 当前月份的所有问题
     * @param currentTime
     * @return
     */
    Result questionsCurrentMonth(String currentTime);

    /**
     * 所有问题，按照月份分组
     * @return
     */
    Result totalQuestion();

    /**
     * 获取所有的QA 数量  今日&本月&总
     * @return
     */
    String[] getQACount();

    /**
     *
     * @param time
     * @return
     */
    List<String> getQuestion(String time);
}
