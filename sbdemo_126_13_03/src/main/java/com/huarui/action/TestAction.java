package com.huarui.action;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestAction {

	@RequestMapping("/toindex")
	public String toindex(Map map) {
		map.put("name", "zoukx");
		return "index";
	}
}
