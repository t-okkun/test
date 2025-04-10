package com.example.testapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.testapp.entity.Players;
import com.example.testapp.entity.Position;
import com.example.testapp.entity.Subposition;
import com.example.testapp.entity.Team;
import com.example.testapp.service.PlayersService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PlayersController {
	
	/*DI*/
	private final PlayersService playersService;

   //全件検索
	@GetMapping("/players")
	public String listPlayer(Model model) {
	    List<Players> players = playersService.findAll(); // 適切なサービスメソッドを使用
	    model.addAttribute("players", players);
	    return "players/players";  // players.html に対応
	}
	
	//チーム名一覧
	@GetMapping("/team")
	public String listPlayers(Model model) {
		List<String> teams =playersService.findAllTeam();
		model.addAttribute("teams", teams);
		return "players/team";
	}
	
	//チーム内のポジションごとの選手一覧
	 @GetMapping("/players/{team}")
	    public String listPlayersGroupdByPosition(@PathVariable String team, Model model) {
	        Map<String, List<Players>> playersByPosition = playersService.findPlayersGroupedByPosition(team);
	        model.addAttribute("team", team);
	        model.addAttribute("playersByPosition", playersByPosition);
	        
	        System.out.println("playersByPosition: "+playersByPosition);
	        return "players/players";
	    }
	

	//選手詳細
	@GetMapping("/players/detail/{name}")
	public String getPlayerDetails(@PathVariable("name") String name, Model model) {
	    List<Players> players= playersService.findPlayersByNameLike("%"+name+"%");
	    System.out.println("Found players size: " + players.size());

//	    if (player.isEmpty()) {
//	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "選手が見つかりません");
//	    }
//	    
	 // playerがnullでないか確認
	    if (players == null) {
	        model.addAttribute("error", "選手が見つかりません");
	        return "error"; // error.html などエラーページに遷移
	    }
	    // 単一の選手オブジェクトを渡す
	    Players player = players.get(0); 
	    System.out.println("Found player: " + player.getName());
	    
	    model.addAttribute("player", player);
	   
	    return "players/players-detail"; // players-detail.html へ
	}
	  
	
	 // 選手登録ページの表示
    @GetMapping("/insert")
    public String showInsertForm(Model model) {
    	
    	List<Team> teams =playersService.getAllTeams();
    	List<Position> positions =playersService.getAllPositions();
    	model.addAttribute("player", new Players());  // 新しい選手オブジェクトをフォームに渡す
        model.addAttribute("teams",teams);
        model.addAttribute("positions",positions);
        model.addAttribute("subpositions", playersService.findAllSubpositions());  // サブポジションデータも追加
        return "insert";  // register.html テンプレートに遷移
    }

    // 登録処理
    @PostMapping("/players/insert")
    public String insert(@ModelAttribute Players player,
    							@RequestParam (value = "subpositions",required = false)List<Integer> subpositions,
//    							@RequestParam String positionName,
//    							@RequestParam String teamName,
//    							@RequestParam Integer team,
//    							@RequestParam Integer position,
    							RedirectAttributes attributes) {
//    	Position position = playersService.findPositionByName(positionName);
//    	Team teams = playersService.findTeamByName(teamName);
    
    	Team teams = playersService.findTeamById(player.getTeam().getId());
    	Position positions = playersService.findPositionById(player.getPosition().getId());
    	
    	player.setPosition(positions);
    	player.setTeam(teams);
    	
    	List<Subposition> subpositionList = playersService.findSubpositionsByIds(subpositions);
    	    // 各 Subposition に親 Player をセット（双方向マッピングのため）
    	    for (Subposition sp : subpositionList) {
    	    	sp.setPlayer(player);
    	    } 

    	    
    	player.setSubpositions(subpositionList);  // サブポジションを選手に設定

        playersService.insert(player);  // 選手情報をサービス経由で保存
        attributes.addFlashAttribute("message", "登録完了");
        return "redirect:/menu";  // 登録後にメニュー画面にリダイレクト
    }
    	
    
    
	 
	@GetMapping("/players/{team}/{position}")
	public String listPlayersByTeamAndPosition(@PathVariable ("team")String team, @PathVariable("position") String position,Model model) {
		Map<String,List<Players>> playersByPosition=playersService.findPlayersGroupedByPosition(team);
		model.addAttribute("team", team);
        model.addAttribute("playersByPosition", playersByPosition);
        return "players/players";
	}
}
