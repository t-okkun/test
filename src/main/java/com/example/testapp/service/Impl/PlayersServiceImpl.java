package com.example.testapp.service.Impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.testapp.entity.Players;
import com.example.testapp.repositry.PlayersMapper;
import com.example.testapp.service.PlayersService;

import lombok.RequiredArgsConstructor;
@Service
@Transactional
@RequiredArgsConstructor
public  class PlayersServiceImpl implements PlayersService {

	private final PlayersMapper playersMapper;
	
	@Override
	public List<String> findAllTeam() {
		// TODO 自動生成されたメソッド・スタブ
		return playersMapper.selectAllTeam();
	}

	@Override
	public Map<String, List<Players>> findPlayersByTeam(String team) {
		// TODO 自動生成されたメソッド・スタブ
		return playersMapper.selectByTeam(team);
	}

	@Override
	public List<String> findPositionsByTeam(String team) {
		// TODO 自動生成されたメソッド・スタブ
		return playersMapper.selectPositionByTeam(team);
	}

	@Override
	public List<Players> findPlayersByTeamAndPosition(String team, String position) {
		// TODO 自動生成されたメソッド・スタブ
		List<Players> players=playersMapper.selectTeamAndPosition(team, position);
		return players;
	}
    @Override
    public Map<String, List<String>> findPlayersGroupedByPosition(String team) {
        List<Map<String, Object>> rawData = playersMapper.selectPlayersByTeamGroupedByPosition(team);
        Map<String, List<String>> groupedPlayers = new LinkedHashMap<>();

        for (Map<String, Object> row : rawData) {
            String position = (String) row.get("position");
            String name = (String) row.get("name");

            groupedPlayers.putIfAbsent(position, new ArrayList<>());
            groupedPlayers.get(position).add(name);
        }
        
        return groupedPlayers;
    }

	@Override
	public List<Players> findAll() {
		// TODO 自動生成されたメソッド・スタブ
		return playersMapper.selectAll();
	}





	@Override
	public void insertPlayers(Players players) {
		// TODO 自動生成されたメソッド・スタブ
		playersMapper.insert(players);

	}

	@Override
	public void updatePlayers(Players players) {
		// TODO 自動生成されたメソッド・スタブ
		playersMapper.update(players);

	}
	@Override
	public void deletePlayers(String name){
		// TODO 自動生成されたメソッド・スタブ
		playersMapper.deleteByName(name);

	}

	@Override
	public List<Players> findPlayersByNameLike(String name) {
		// TODO 自動生成されたメソッド・スタブ
		return playersMapper.selectByNameLike("%"+name+"%");
	}
	@Override
	public List<Players> findByPosition(String position){
		return playersMapper.selectByPosition(position);
	}

}
