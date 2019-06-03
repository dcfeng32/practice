package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Movie;

@Controller
@RequestMapping(value="movie")
public class IndexController {
	
	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	@RequestMapping("query")
	public String query(Model model) {//在括号里加String movieName（与index.html的name名字一致）
		Movie movie = new Movie();    //将“海神”改为movieName
		movie.setName("海神");          //可以实现浏览器输入的数据直接显示出来
		movie.setType("科幻");
		movie.setMoney("10亿");
		//固定写法
		model.addAttribute("movie",movie);
		return "movie";
	}
	
	@RequestMapping("getMovie")
	@ResponseBody
	public String getMovie() {
		return "死侍";
	}

}
