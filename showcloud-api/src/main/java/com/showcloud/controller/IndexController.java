package com.showcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.showcloud.entity.SysUser;
import com.showcloud.result.ApiResult;
import com.showcloud.result.ResultEnum;
import com.showcloud.service.SysUserService;
import com.showcloud.utils.MD5Encode;
import com.showcloud.utils.UUIDUtils;

@RestController
public class IndexController {

	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("/info")
    public ApiResult info(){
    	return new ApiResult(1,"success");
    }
	
	@PostMapping("/user")
	public ApiResult saveSysUser(){
		SysUser sysUser=new SysUser();
		sysUser.setId(UUIDUtils.getUUID32());
		sysUser.setUsername("issume");
		sysUser.setPassword(MD5Encode.encode("123456", "md5"));
		sysUser=sysUserService.save(sysUser);
		return new ApiResult(ResultEnum.SUCCESS.getCode(),sysUser );
	}
}
