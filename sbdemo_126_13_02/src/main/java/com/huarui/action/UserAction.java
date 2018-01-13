package com.huarui.action;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huarui.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api("这是UserAction")
public class UserAction {

	@ApiOperation(value="更新用户信息",response=User.class)			
    @ApiImplicitParams({			
        @ApiImplicitParam(paramType="body",name="user",required=true,value="要更新的用户",dataType="User"),			
        //@ApiImplicitParam(name="password",dataType="String",required=true,value="用户的密码",defaultValue="wangna")			
    })			
    @ApiResponses({			
        @ApiResponse(code=400,message="请求参数没填好"),			
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")			
        			
    })			
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public User getUser(@RequestBody User user) {
		return user;
	}

	@ApiOperation(value="登陆",response=User.class)			
    @ApiImplicitParams({			
        @ApiImplicitParam(paramType="query",name="username",required=true,value="用户名",dataType="string",defaultValue="zoukx"),			
        @ApiImplicitParam(paramType="query",name="password",required=true,value="密码",dataType="string",defaultValue="admin")			
    })			
    @ApiResponses({			
        @ApiResponse(code=400,message="请求参数没填好"),			
        @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")			
        			
    })	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public User login(@RequestParam String username, @RequestParam String password) {
		return new User(1, username,password);
	}

	@RequestMapping(value = "/finduser/{uid}", method = RequestMethod.GET)
	public User getUserByID(@PathVariable int uid) {
		return new User(uid, "admin","admin");
	}

}
