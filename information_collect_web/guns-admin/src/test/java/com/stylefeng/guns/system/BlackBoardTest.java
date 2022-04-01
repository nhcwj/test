package com.stylefeng.guns.system;

import com.stylefeng.guns.base.BaseJunit;
import com.stylefeng.guns.modular.system.dao.NoticeMapper;
import io.swagger.models.auth.In;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertTrue;

/**
 * 首页通知展示测试
 *
 * @author fengshuonan
 * @date 2017-05-21 15:02
 */
public class BlackBoardTest extends BaseJunit {

    @Autowired
    NoticeMapper noticeMapper;

    @Test
    public void blackBoardTest() throws InterruptedException {

    }
}
