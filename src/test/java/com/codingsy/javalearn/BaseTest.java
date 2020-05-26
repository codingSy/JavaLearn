/*
 * Copyright (C) 2018 112798381@qq.com All rights reserved.
 *
 * Created by 112798381@qq.com on 2019/11/29.
 */

package com.codingsy.javalearn;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 描述类的功能.
 *
 * @author 112798381@qq.com
 */
@SpringBootTest(classes = BaseTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan({"com.codingsy.javalearn"})
public class BaseTest {

}
