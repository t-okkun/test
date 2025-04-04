package com.example.testapp.repositry;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.testapp.entity.Players;

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
	
	//チームごとに選手一覧を取得
	Map<String, List<Players>> selectByTeam(String team);
	
	//指定チームのポジション位置を取得
	List<String>selectPositionByTeam(String team);
	
	//チーム・ポジションごとに選手一覧
	List<Players> selectTeamAndPosition(@Param("team") String team,@Param("position") String position);

	List<Map<String, Object>> selectPlayersByTeamGroupedByPosition(String team);
	
	List<Players> selectByPosition(@Param("position") String position);

	

}
