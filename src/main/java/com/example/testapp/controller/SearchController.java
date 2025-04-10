package com.example.testapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.testapp.entity.Players;
import com.example.testapp.service.PlayersService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {
	
	private final PlayersService playersService;
	
	// 選手名 & 守備位置の検索を統合
	@GetMapping
	public String showSearchPage(
	    @RequestParam(required = false) String playerName, 
	    @RequestParam(required = false) String position, 
	    Model model) {		 
		 
	    if (playerName != null && !playerName.isEmpty()) {
	        // 選手名で検索
	        List<Players> playersByName = playersService.findPlayersByNameLike(playerName);
	        if (!playersByName.isEmpty()) {
	            model.addAttribute("players", playersByName);
	        } else {
	            model.addAttribute("message", "選手が見つかりません");
	        }
	    } else if (position != null && !position.isEmpty()) {
	        // 守備位置で検索
	        List<Players> playersByPosition = playersService.findByPosition(position);
	        if (!playersByPosition.isEmpty()) {
	            model.addAttribute("players", playersByPosition);
	        } else {
	            model.addAttribute("message", "指定されたポジションの選手が見つかりません");
	        }
	    }
	    
	    return "search"; // search.html を表示
	}
}
