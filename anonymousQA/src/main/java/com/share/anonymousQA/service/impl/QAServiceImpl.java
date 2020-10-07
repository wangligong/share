package com.share.anonymousQA.service.impl;

import com.share.anonymousQA.service.QAService;
import com.share.anonymousQA.util.DateUtil;
import com.share.anonymousQA.util.FileUtil;
import com.share.anonymousQA.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题与答案 Service
 */
@Service
@Slf4j
public class QAServiceImpl implements QAService {
    @Override
    public void addQuestion(String time, String question) {
        try{
            String questionTime = String.format("%s %s", time, question);
            FileUtil.writeToTxt(questionTime);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Result questionsCurrentMonth(String currentTime) {
        return null;
    }

    @Override
    public Result totalQuestion() {
        return null;
    }

    @Override
    public String[] getQACount() {
        List<String> questions = FileUtil.readFile();

        Integer today = 0;
        Integer month = 0;
        Integer total = 0;

        String currentTime = DateUtil.getDateTime();
        String todayTime = currentTime.substring(0,10);
        String monthTime = currentTime.substring(0,7);
        System.out.println(todayTime + "&&&&" + monthTime);
        if(questions.size() > 0) {
            for (String question : questions) {
                if(question.startsWith(todayTime)) {
                    today += 1;
                }
                if(question.startsWith(monthTime)) {
                    month += 1;
                }
                total += 1;
            }
        }
        return new String[]{today.toString(),month.toString(),total.toString()};
    }

    @Override
    public List<String> getQuestion(String time) {
        List<String> questions = FileUtil.readFile();
        List<String> returnQA = new ArrayList<>();
        if(questions.size() > 0) {
            for (String question : questions) {
                if(question.startsWith(time)) {
                    returnQA.add(question);
                }
            }
        }
        return returnQA;
    }
}
