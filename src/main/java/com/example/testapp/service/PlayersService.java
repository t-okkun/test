package com.example.testapp.service;

import java.util.List;
import java.util.Map;

import com.example.testapp.entity.Players;

public interface PlayersService {
	List<String> findAllTeam();
	Map<String, List<Players>> findPlayersByTeam(String team);
	List<String> findPositionsByTeam(String team);
	List<Players> findPlayersByTeamAndPosition(String team, String position);
	List<Players>findAll();
	List<Players> findPlayersByNameLike(String name);
	void insertPlayers(Players players);
	void updatePlayers(Players players);
	void deletePlayers(String name);
	Map<String, List<String>> findPlayersGroupedByPosition(String team);
	List<Players> findByPosition(String position);

}
