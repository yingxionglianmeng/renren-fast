package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.WcsMckeyEntity;
import io.renren.modules.generator.service.WcsMckeyService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * Mckey生成
 *
 * @author yxq
 * @email yxq@163.com
 * @date 2019-12-27 12:11:12
 */
@RestController
@RequestMapping("generator/wcsmckey")
public class WcsMckeyController {
    @Autowired
    private WcsMckeyService wcsMckeyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:wcsmckey:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = wcsMckeyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:wcsmckey:info")
    public R info(@PathVariable("id") Integer id){
		WcsMckeyEntity wcsMckey = wcsMckeyService.getById(id);

        return R.ok().put("wcsMckey", wcsMckey);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:wcsmckey:save")
    public R save(@RequestBody WcsMckeyEntity wcsMckey){
		wcsMckeyService.save(wcsMckey);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:wcsmckey:update")
    public R update(@RequestBody WcsMckeyEntity wcsMckey){
		wcsMckeyService.updateById(wcsMckey);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:wcsmckey:delete")
    public R delete(@RequestBody Integer[] ids){
		wcsMckeyService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
