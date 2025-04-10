package com.example.testapp.service.Impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.testapp.entity.Players;
import com.example.testapp.entity.Position;
import com.example.testapp.entity.Subposition;
import com.example.testapp.entity.Team;
import com.example.testapp.repositry.PlayersMapper;
import com.example.testapp.service.PlayersService;

import lombok.RequiredArgsConstructor;
@Service
@Transactional
@RequiredArgsConstructor
public  class PlayersServiceImpl implements PlayersService {

	private final PlayersMapper playersMapper;
	
	//チーム取得
	@Override
	public List<String> findAllTeam() {
		// TODO 自動生成されたメソッド・スタブ
		return playersMapper.selectAllTeam();
	}
	
	  //ポジション取得
    @Override
    public List<String> findAllPosition(){
    	return playersMapper.selectAllPosition();
    }
	
	//名前検索s
	@Override
	public List<Players> findPlayersByNameLike(String name) {
		// TODO 自動生成されたメソッド・スタブ
		return playersMapper.selectByNameLike("%"+name+"%");
	}
	
	//登録
	@Override
	public void insert(Players players) {
		// TODO 自動生成されたメソッド・スタブ
		playersMapper.insert(players);
	}

	//更新
	@Override
	public void update(Players players) {
		// TODO 自動生成されたメソッド・スタブ
		playersMapper.update(players);
	}
	
	//削除
	@Override
	public void delete(String name){
		// TODO 自動生成されたメソッド・スタブ
		playersMapper.deleteByName(name);
	}
	
	//全件検索
	@Override
	public List<Players> findAll() {
		// TODO 自動生成されたメソッド・スタブ
		return playersMapper.selectAll();
	}

	//ポジションごとの選手名
	@Override
	public Map<String, List<Players>> findPlayersGroupedByPosition(String teamName) {
	    List<Map<String, Object>> rawData = playersMapper.selectPlayersByTeamGroupedByPosition(teamName);
	    Map<String, List<Players>> groupedPlayers = new LinkedHashMap<>();

	    for (Map<String, Object> row : rawData) {
	        String position = (String) row.get("position");
	        String name = (String) row.get("name");

	        Players player = new Players();
	        player.setName(name);  // setName() できるようになってる前提！

	        groupedPlayers.putIfAbsent(position, new ArrayList<>());
	        groupedPlayers.get(position).add(player);
	    }

	    return groupedPlayers;
	}
    
	//指定ポジションの選手
    @Override
	public List<Players> findByPosition(String position){
		return playersMapper.selectByPosition(position);
	}

	@Override
	public List<Players> findAllSubpositions() {
		// TODO 自動生成されたメソッド・スタブ
		return playersMapper.selectAllSubposition();
	}

	@Override
	public List<Subposition> findSubpositionsByIds(List<Integer> ids) {
		// TODO 自動生成されたメソッド・スタブ
		if (ids == null || ids.isEmpty()) return new ArrayList<>();
		return playersMapper.selectSubpositionsByIds(ids);
	}

	@Override
	public Team findTeamByName(String name) {
		// TODO 自動生成されたメソッド・スタブ
		return playersMapper.selectTeamByName(name);
	}

	@Override
	public Position findPositionByName(String name) {
		// TODO 自動生成されたメソッド・スタブ
		return playersMapper.selectPositionByName(name);
	}

	@Override
	public List<Team> getAllTeams() {
		// TODO 自動生成されたメソッド・スタブ
		return playersMapper.setAllTeams();
	}
	@Override
    public Team findTeamById(Integer teamId) {
        return playersMapper.selectTeamById(teamId);  // Mapper メソッドを呼び出す
    }

	@Override
	public List<Position> getAllPositions() {
		// TODO 自動生成されたメソッド・スタブ
		return playersMapper.setAllPositions();
	}
	@Override
	public Position findPositionById(Integer positionId) {
		// TODO 自動生成されたメソッド・スタブ
		return playersMapper.selectPositionById(positionId);
	}
  
    
//	@Override
//	public Map<Integer, List<Players>> findPlayersByTeam(Integer teamId) {
//	    List<Players> playersList = playersMapper.selectByTeam(teamId);
//	    Map<Integer, List<Players>> resultMap = new LinkedHashMap<>();
//	    
//	    // ポジションごとに選手をグループ化
//	    for (Players player : playersList) {
//	        resultMap.putIfAbsent(player.getPositionId(), new ArrayList<>());
//	        resultMap.get(player.getPositionId()).add(player);
//	    }
//	    return resultMap;
//	}
//	
//	@Override
//	public List<Integer> findPositionsByTeam(Integer teamId) {
//		// TODO 自動生成されたメソッド・スタブ
//		return playersMapper.selectPositionByTeam(teamId);
//	}
//
//	@Override
//	public List<Players> findPlayersByTeamAndPosition(Integer teamId, Integer positionId) {
//		// TODO 自動生成されたメソッド・スタブ
//		List<Players> players=playersMapper.selectTeamAndPosition(teamId, positionId);
//		return players;
//	}
	
}
