package com.example.testapp.repositry;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.testapp.entity.Players;
import com.example.testapp.entity.Position;
import com.example.testapp.entity.Subposition;
import com.example.testapp.entity.Team;

/**
 * Players:リポジトリ
 */
@Mapper
public interface PlayersMapper {
	List<Players> selectAll();
	//選手名で検索
	List<Players> selectByNameLike(@Param("name") String name);
	
	void insert(Players players);
	
	void update(Players players);
	void deleteByName(@Param("name") String name);
	
	//チームの取得
	List<String> selectAllTeam();
	
	//ポジションの取得
	List<String> selectAllPosition();

	//チームごとに選手一覧を取得
	List<Players> selectByTeam(@Param("teamId") Integer teamId);
	
	//指定チームのポジション位置を取得
	List<Integer>selectPositionByTeam(Integer teamId);
	
	//チーム・ポジションごとに選手一覧
	List<Players> selectTeamAndPosition(@Param("teamId") Integer teamId,@Param("positionId") String positionName);

	List<Map<String, Object>> selectPlayersByTeamGroupedByPosition(@Param("teamName") String teamName);
	
	List<Players> selectByPosition(String position);
	Integer selectTeamIdByName(String teamName);
	
	List<Players> selectAllSubposition();

	List<Subposition> selectSubpositionsByIds(@Param("ids") List<Integer> ids);
	
	Team selectTeamByName(String name);
	
	Position selectPositionByName(String name);
	
	List<Team> setAllTeams();
	   // チームIDに基づいてチーム情報を取得
    Team selectTeamById(Integer teamId);  // id はチームのIDを示す
    
    List<Position> setAllPositions();
    
    Position selectPositionById(Integer positionId);
}
