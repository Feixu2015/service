/**
 * 杭州云霁科技有限公司
 * http://www.idcos.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package org.feixu.service.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import groovy.json.JsonSlurper
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

/**
 * for bonita test data
 *
 * @author Biminli
 * @version $Id: BonitaController.java, v 0.1 2018/8/3 Biminli Exp $$
 */
@Controller
@RequestMapping('/bonita')
class BonitaController {

    @RequestMapping("/main")
    @ResponseBody
    Object getMain() {
        return new JsonSlurper().parseText("""
{
    "list":[{
        "name":"张三",
        "value":"zhangsan"
    },{
        "name":"李四",
        "value":"lisi"
    },{
        "name":"王五",
        "value":"wangwu"
    }]
}
""")
    }

    @RequestMapping("/main/related")
    @ResponseBody
    Object getRelated(@RequestParam String mainId) {
        def data = new JsonSlurper().parseText("""
{
    "list":[{
        "name":"玩具1-1",
        "value":"toy1-1",
        "mainId": "zhangsan"
    },{
        "name":"玩具1-2",
        "value":"toy1-2",
        "mainId": "zhangsan"
    },{
        "name":"玩具2-1",
        "value":"toy2-1",
        "mainId": "lisi"
    },{
        "name":"玩具2-2",
        "value":"toy2-2",
        "mainId": "lisi"
    },{
        "name":"玩具2-3",
        "value":"toy2-3",
        "mainId": "lisi"
    }]
}
""")
        return data.list.findAll{ it.mainId == mainId}
    }


}
