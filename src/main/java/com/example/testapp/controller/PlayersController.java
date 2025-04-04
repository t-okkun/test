package com.example.testapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.testapp.entity.Players;
import com.example.testapp.service.PlayersService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PlayersController {
	
	/*DI*/
	private final PlayersService playersService;

   
	
	@GetMapping("/team")
	public String listPlayers(Model model) {
		List<String> team =playersService.findAllTeam();
		model.addAttribute("team", team);
		return "players/team";
	}
	@GetMapping("/players")
	public String listPlayer(Model model) {
	    List<Players> players = playersService.findAll(); // 適切なサービスメソッドを使用
	    model.addAttribute("players", players);
	    return "players/players";  // players.html に対応
	}

	
	 @GetMapping("/players/{team}")
	    public String listPlayersGroupdByPosition(@PathVariable String team, Model model) {
	        Map<String, List<String>> playersByPosition = playersService.findPlayersGroupedByPosition(team);
	        model.addAttribute("team", team);
	        model.addAttribute("playersByPosition", playersByPosition);
	        return "players/players";
	    }
	
	@GetMapping("/players/{team}/{position}")
	public String listPlayersByTeamAndPosition(@PathVariable ("team") String team, @PathVariable("position") String position,Model model) {
		List<Players> players =playersService.findPlayersByTeamAndPosition(team, position);
		model.addAttribute("team", team);
        model.addAttribute("position", position);
        model.addAttribute("players", players);
        return "players/players";
	}
	
	@GetMapping("/players/detail/{name}")
	public String getPlayerDetails(@PathVariable("name") String name, Model model) {
	    List<Players> players = playersService.findPlayersByNameLike("%"+name+"%");
	    
	    if (players.isEmpty()) {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "選手が見つかりません");
	    }
	    
	    // 単一の選手オブジェクトを渡す
	    model.addAttribute("player", players.get(0)); 
	    model.addAttribute("team", players.get(0).getTeam());
	    return "players/players-detail"; // players-detail.html へ
	}
	
	 // 選手登録ページの表示
    @GetMapping("/insert")
    public String showInsertForm(Model model) {
        model.addAttribute("player", new Players());  // 新しい選手オブジェクトをフォームに渡す
        return "insert";  // register.html テンプレートに遷移
    }

    // 登録処理
    @PostMapping("/insert")
    public String insertPlayers(@ModelAttribute Players player,
    							RedirectAttributes attributes) {
        playersService.insertPlayers(player);  // 選手情報をサービス経由で保存
        attributes.addFlashAttribute("message", "登録完了");
        return "redirect:/menu";  // 登録後にメニュー画面にリダイレクト
    }
    	

}
