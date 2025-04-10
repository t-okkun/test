package com.example.testapp.service;

import java.util.List;
import java.util.Map;

import com.example.testapp.entity.Players;
import com.example.testapp.entity.Position;
import com.example.testapp.entity.Subposition;
import com.example.testapp.entity.Team;

public interface PlayersService {
	//全件検索
	List<Players>findAll();
	//名前検索	
	List<Players> findPlayersByNameLike(String name);
	//登録
	void insert(Players players);
	//更新
	void update(Players players);
	//削除
	void delete(String name);
	//チーム取得
	List<String> findAllTeam();
	//チーム名をidから
	Team findTeamByName(String name);
	//ポジション取得
	List<String> findAllPosition();
	//ポジションをidから
	Position findPositionByName(String name);
	//ポジションと選手名の取得
	Map<String, List<Players>> findPlayersGroupedByPosition(String team);
	//指定ポジションの選手
	List<Players> findByPosition(String position);
	//サブポジションを取得
	List<Players> findAllSubpositions();
	//サブポジションをidからString型に
	List<Subposition> findSubpositionsByIds(List<Integer> ids);
	
	
	List<Team> getAllTeams();
    // チームIDに基づいてチーム情報を取得
    Team findTeamById(Integer teamId);
    
    List<Position> getAllPositions();
    Position findPositionById(Integer positionId);

    
}
	//	Map<Integer, List<Players>> findPlayersByTeam(Integer teamId);
//	List<Integer> findPositionsByTeam(Integer teamId);
//	List<Players> findPlayersByTeamAndPosition(Integer teamId, Integer positionId);
	
