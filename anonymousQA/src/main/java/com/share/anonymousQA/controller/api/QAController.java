package com.share.anonymousQA.controller.api;

import com.share.anonymousQA.enums.RES_STATUS;
import com.share.anonymousQA.service.QAService;
import com.share.anonymousQA.util.DateUtil;
import com.share.anonymousQA.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/qa")
@Slf4j
public class QAController {

    @Autowired
    private QAService qaService;

    /**
     * 新增新的匿名提问
     * @param question
     * @return
     */
    @RequestMapping("/newQuestion")
    public Result addNewQuestion(@RequestParam("question") String question){
        String currentTime = DateUtil.getDateTime();
        qaService.addQuestion(currentTime, question);
        return Result.success();
    }

    /**
     * 当天的提问
     * @return
     */
    @RequestMapping("/today")
    public Result today() {
        String time = DateUtil.getDateTime().substring(0,10);
        List<String> questions = qaService.getQuestion(time);
        return new Result(questions, RES_STATUS.SUCCESS);
    }

    /**
     * 当月提问
     * @return
     */
    @RequestMapping("/currentMonth")
    public Result currentMonth() {
        String time = DateUtil.getDateTime().substring(0,7);
        List<String> questions = qaService.getQuestion(time);
        return new Result(questions, RES_STATUS.SUCCESS);
    }

    /**
     * 总的提问数
     * @return
     */
    @RequestMapping("/total")
    public Result total() {
        String time = DateUtil.getDateTime().substring(0,1);
        List<String> questions = qaService.getQuestion(time);
        return new Result(questions, RES_STATUS.SUCCESS);
    }
}
