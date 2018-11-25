package com.hackyeah.pkpservicemk.controllers;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hackyeah.pkpservicemk.mockEntities.Stop;
import com.hackyeah.pkpservicemk.mockEntities.Trip;

@Controller
public class TripDetailsController {

	List<String> allCities = new ArrayList<String>(Arrays.asList("Bialystok","Bielsko-Biala","Bydgoszcz","Bytom",
			"ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia","Gliwice",
			"GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce","Koszalin",
			"KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy",
			"Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala",
			"Bydgoszcz","Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia",
			"Gliwice","GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce",
			"Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy",
			"Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala",
			"Bydgoszcz","Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia",
			"Gliwice","GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce",
			"Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy",
			"Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala",
			"Bydgoszcz","Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia",
			"Gliwice","GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce",
			"Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy",
			"Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala",
			"Bydgoszcz","Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia",
			"Gliwice","GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce",
			"Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy",
			"Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala",
			"Bydgoszcz","Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia",
			"Gliwice","GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce",
			"Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy",
			"Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala",
			"Bydgoszcz","Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia",
			"Gliwice","GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce",
			"Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy",
			"Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala",
			"Bydgoszcz","Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia",
			"Gliwice","GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce",
			"Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy",
			"Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala",
			"Bydgoszcz","Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia",
			"Gliwice","GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce",
			"Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy",
			"Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bialystok",
			"Bielsko-Biala","Bielsko-Biala","Bydgoszcz","Bydgoszcz","Bytom","Bytom","ChorzĂłw","ChorzĂłw",
			"Czestochowa","Czestochowa","Dabrowa GĂłrnicza","Dabrowa GĂłrnicza","Elblag","Elblag",
			"Gdansk","Gdansk","Gdynia","Gdynia","Gliwice","Gliwice","GorzĂłw Wielkopolski",
			"GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Kalisz","Katowice","Katowice",
			"Kielce","Kielce","Koszalin","Koszalin","KrakĂłw","KrakĂłw","Legnica","Legnica","LĂłdz",
			"LĂłdz","Lublin","Lublin","Olsztyn","Olsztyn","Opole","Opole","Plock","Plock","Poznan",
			"Poznan","Radom","Radom","Ruda Slaska","Ruda Slaska","Rybnik","Rybnik","RzeszĂłw",
			"RzeszĂłw","Slupsk","Sosnowiec","Sosnowiec","Szczecin","Szczecin","TarnĂłw","TarnĂłw","Torun",
			"Torun","Tychy","Tychy","Walbrzych","Walbrzych","WARSZAWA","WARSZAWA","Wloclawek","Wloclawek",
			"Wroclaw","Wroclaw","Zabrze","Zabrze","Zielona GĂłra","Zielona GĂłra","Bialystok","Bialystok",
			"Bielsko-Biala","Bielsko-Biala","Bydgoszcz","Bydgoszcz","Bytom","Bytom","ChorzĂłw","ChorzĂłw",
			"Czestochowa","Czestochowa","Dabrowa GĂłrnicza","Dabrowa GĂłrnicza","Elblag","Elblag",
			"Gdansk","Gdansk","Gdynia","Gdynia","Gliwice","Gliwice","GorzĂłw Wielkopolski",
			"GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Kalisz","Katowice","Katowice",
			"Kielce","Kielce","Koszalin","Koszalin","KrakĂłw","KrakĂłw","Legnica","Legnica","LĂłdz",
			"LĂłdz","Lublin","Lublin","Olsztyn","Olsztyn","Opole","Opole","Plock","Plock","Poznan",
			"Poznan","Radom","Radom","Ruda Slaska","Ruda Slaska","Rybnik","Rybnik","RzeszĂłw",
			"RzeszĂłw","Slupsk","Sosnowiec","Sosnowiec","Szczecin","Szczecin","TarnĂłw","TarnĂłw","Torun",
			"Torun","Tychy","Tychy","Walbrzych","Walbrzych","WARSZAWA","WARSZAWA","Wloclawek","Wloclawek",
			"Wroclaw","Wroclaw","Zabrze","Zabrze","Zielona GĂłra","Zielona GĂłra","Bialystok","Bialystok",
			"Bielsko-Biala","Bielsko-Biala","Bydgoszcz","Bydgoszcz","Bytom","Bytom","ChorzĂłw","ChorzĂłw",
			"Czestochowa","Czestochowa","Dabrowa GĂłrnicza","Dabrowa GĂłrnicza","Elblag","Elblag",
			"Gdansk","Gdansk","Gdynia","Gdynia","Gliwice","Gliwice","GorzĂłw Wielkopolski",
			"GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Kalisz","Katowice","Katowice",
			"Kielce","Kielce","Koszalin","Koszalin","KrakĂłw","KrakĂłw","Legnica","Legnica","LĂłdz",
			"LĂłdz","Lublin","Lublin","Olsztyn","Olsztyn","Opole","Opole","Plock","Plock","Poznan",
			"Poznan","Radom","Radom","Ruda Slaska","Ruda Slaska","Rybnik","Rybnik","RzeszĂłw",
			"RzeszĂłw","Slupsk","Sosnowiec","Sosnowiec","Szczecin","Szczecin","TarnĂłw","TarnĂłw","Torun",
			"Torun","Tychy","Tychy","Walbrzych","Walbrzych","WARSZAWA","WARSZAWA","Wloclawek","Wloclawek",
			"Wroclaw","Wroclaw","Zabrze","Zabrze","Zielona GĂłra","Zielona GĂłra","Bialystok",
			"Bielsko-Biala","Bydgoszcz","Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag",
			"Gdansk","Gdynia","Gliwice","GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz",
			"Katowice","Kielce","Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole",
			"Plock","Poznan","Radom","Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin",
			"TarnĂłw","Torun","Tychy","Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra",
			"Bialystok","Bielsko-Biala","Bydgoszcz","Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza",
			"Elblag","Gdansk","Gdynia","Gliwice","GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj",
			"Kalisz","Katowice","Kielce","Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn",
			"Opole","Plock","Poznan","Radom","Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec",
			"Szczecin","TarnĂłw","Torun","Tychy","Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze",
			"Zielona GĂłra","Bialystok","Bielsko-Biala","Bydgoszcz","Bytom","ChorzĂłw","Czestochowa",
			"Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia","Gliwice","GorzĂłw Wielkopolski","Grudziadz",
			"Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce","Koszalin","KrakĂłw","Legnica","LĂłdz",
			"Lublin","Olsztyn","Opole","Plock","Poznan","Radom","Ruda Slaska","Rybnik","RzeszĂłw",
			"Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy","Walbrzych","WARSZAWA","Wloclawek",
			"Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala","Bydgoszcz","Bytom","ChorzĂłw",
			"Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia","Gliwice","GorzĂłw Wielkopolski",
			"Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce","Koszalin","KrakĂłw","Legnica",
			"LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom","Ruda Slaska","Rybnik",
			"RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy","Walbrzych","WARSZAWA",
			"Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala","Bydgoszcz","Bytom",
			"ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia","Gliwice",
			"GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce","Koszalin",
			"KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy",
			"Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala",
			"Bydgoszcz","Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia",
			"Gliwice","GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce",
			"Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy",
			"Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala",
			"Bydgoszcz","Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia",
			"Gliwice","GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce",
			"Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy",
			"Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala",
			"Bydgoszcz","Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia",
			"Gliwice","GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce",
			"Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy",
			"Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala",
			"Bydgoszcz","Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia",
			"Gliwice","GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce",
			"Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy",
			"Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bialystok",
			"Bielsko-Biala","Bielsko-Biala","Bydgoszcz","Bydgoszcz","Bytom","Bytom","ChorzĂłw","ChorzĂłw",
			"Czestochowa","Czestochowa","Dabrowa GĂłrnicza","Dabrowa GĂłrnicza","Elblag","Elblag",
			"Gdansk","Gdansk","Gdynia","Gdynia","Gliwice","Gliwice","GorzĂłw Wielkopolski",
			"GorzĂłw Wielkopolski","Kalisz","Kalisz","Katowice","Katowice","Kielce","Kielce","Koszalin",
			"Koszalin","KrakĂłw","KrakĂłw","Legnica","Legnica","LĂłdz","LĂłdz","Lublin","Lublin",
			"Olsztyn","Olsztyn","Opole","Opole","Plock","Plock","Poznan","Poznan","Radom","Radom",
			"Ruda Slaska","Ruda Slaska","Rybnik","Rybnik","RzeszĂłw","RzeszĂłw","Sosnowiec","Sosnowiec",
			"Szczecin","Szczecin","TarnĂłw","TarnĂłw","Torun","Torun","Tychy","Tychy","Walbrzych",
			"Walbrzych","WARSZAWA","WARSZAWA","Wloclawek","Wloclawek","Wroclaw","Wroclaw","Zabrze",
			"Zabrze","Zielona GĂłra","Zielona GĂłra","Bialystok","Bialystok","Bielsko-Biala","Bielsko-Biala",
			"Bydgoszcz","Bydgoszcz","Bytom","Bytom","ChorzĂłw","ChorzĂłw","Czestochowa","Czestochowa",
			"Dabrowa GĂłrnicza","Dabrowa GĂłrnicza","Elblag","Elblag","Gdansk","Gdansk","Gdynia",
			"Gdynia","Gliwice","Gliwice","GorzĂłw Wielkopolski","GorzĂłw Wielkopolski","Kalisz","Kalisz",
			"Katowice","Katowice","Kielce","Kielce","Koszalin","Koszalin","KrakĂłw","KrakĂłw","Legnica",
			"Legnica","LĂłdz","LĂłdz","Lublin","Lublin","Olsztyn","Olsztyn","Opole","Opole","Plock",
			"Plock","Poznan","Poznan","Radom","Radom","Ruda Slaska","Ruda Slaska","Rybnik","Rybnik",
			"RzeszĂłw","RzeszĂłw","Sosnowiec","Sosnowiec","Szczecin","Szczecin","TarnĂłw","TarnĂłw","Torun",
			"Torun","Tychy","Tychy","Walbrzych","Walbrzych","WARSZAWA","WARSZAWA","Wloclawek","Wloclawek",
			"Wroclaw","Wroclaw","Zabrze","Zabrze","Zielona GĂłra","Zielona GĂłra","Bialystok","Bialystok",
			"Bielsko-Biala","Bielsko-Biala","Bydgoszcz","Bydgoszcz","Bytom","Bytom","ChorzĂłw","ChorzĂłw",
			"Czestochowa","Czestochowa","Dabrowa GĂłrnicza","Dabrowa GĂłrnicza","Elblag","Elblag",
			"Gdansk","Gdansk","Gdynia","Gdynia","Gliwice","Gliwice","GorzĂłw Wielkopolski",
			"GorzĂłw Wielkopolski","Kalisz","Kalisz","Katowice","Katowice","Kielce","Kielce","Koszalin",
			"Koszalin","KrakĂłw","KrakĂłw","Legnica","Legnica","LĂłdz","LĂłdz","Lublin","Lublin",
			"Olsztyn","Olsztyn","Opole","Opole","Plock","Plock","Poznan","Poznan","Radom","Radom",
			"Ruda Slaska","Ruda Slaska","Rybnik","Rybnik","RzeszĂłw","RzeszĂłw","Sosnowiec","Sosnowiec",
			"Szczecin","Szczecin","TarnĂłw","TarnĂłw","Torun","Torun","Tychy","Tychy","Walbrzych",
			"Walbrzych","WARSZAWA","WARSZAWA","Wloclawek","Wloclawek","Wroclaw","Wroclaw","Zabrze",
			"Zabrze","Zielona GĂłra","Zielona GĂłra","Bialystok","Bielsko-Biala","Bydgoszcz","Bytom",
			"ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia","Gliwice",
			"GorzĂłw Wielkopolski","Kalisz","Katowice","Kielce","Koszalin","KrakĂłw","Legnica","LĂłdz",
			"Lublin","Olsztyn","Opole","Plock","Poznan","Radom","Ruda Slaska","Rybnik","RzeszĂłw",
			"Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy","Walbrzych","WARSZAWA","Wloclawek","Wroclaw",
			"Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala","Bydgoszcz","Bytom","ChorzĂłw","Czestochowa",
			"Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia","Gliwice","GorzĂłw Wielkopolski","Kalisz",
			"Katowice","Kielce","Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole",
			"Plock","Poznan","Radom","Ruda Slaska","Rybnik","RzeszĂłw","Sosnowiec","Szczecin","TarnĂłw",
			"Torun","Tychy","Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra",
			"Bialystok","Bielsko-Biala","Bydgoszcz","Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza",
			"Elblag","Gdansk","Gdynia","Gliwice","GorzĂłw Wielkopolski","Kalisz","Katowice","Kielce",
			"Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy","Walbrzych",
			"WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala","Bydgoszcz",
			"Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia","Gliwice",
			"GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce","Koszalin",
			"KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy",
			"Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala",
			"Bydgoszcz","Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia",
			"Gliwice","GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce",
			"Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy",
			"Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra","Bialystok","Bielsko-Biala",
			"Bydgoszcz","Bytom","ChorzĂłw","Czestochowa","Dabrowa GĂłrnicza","Elblag","Gdansk","Gdynia",
			"Gliwice","GorzĂłw Wielkopolski","Grudziadz","Jastrzebie-ZdrĂłj","Kalisz","Katowice","Kielce",
			"Koszalin","KrakĂłw","Legnica","LĂłdz","Lublin","Olsztyn","Opole","Plock","Poznan","Radom",
			"Ruda Slaska","Rybnik","RzeszĂłw","Slupsk","Sosnowiec","Szczecin","TarnĂłw","Torun","Tychy",
			"Walbrzych","WARSZAWA","Wloclawek","Wroclaw","Zabrze","Zielona GĂłra"));
	
	@CrossOrigin(origins ="*")
	@GetMapping("/getStops")
	@ResponseBody
	public ResponseEntity<Trip> getTripsFromTo(@RequestParam String from,@RequestParam String to){
		ArrayList<Stop> stops = new ArrayList<Stop>();
		Set<String> stopnames = new HashSet<String>();
		Random r = new Random();
		Integer result;
		
		for (int i = 1; i <= 10; i++) {
			result = r.nextInt(1000 - 1) + 1;
			Stop stop = new Stop();
			stop.setStationName(allCities.get(result));
			if(!stopnames.contains(stop.getStationName()) 
					&& !stop.getStationName().equalsIgnoreCase(to)
					&& !stop.getStationName().equalsIgnoreCase(from)) {
				stopnames.add(stop.getStationName());
				stops.add(stop);
			}
		}
		
		Trip trip = new Trip();
		trip.setSource(from);
		trip.setDestination(to);
		result = r.nextInt(1000 - 1) + 1;
		trip.setTrainName("EIC" + result.toString());
		trip.setPrice(r.nextInt(400 - 200) + 200);
		trip.setPriceSecondClass((r.nextInt(100 - 50) + 50));
		trip.setAvailableSeats(r.nextInt(100 - 1) + 1);

		final Random random = new Random();
		final int millisInDay = 24 * 60 * 60 * 1000;
		Time time = new Time((long) random.nextInt(millisInDay));
		trip.setDeparture(String.valueOf(time.getHours())+":"+String.valueOf(time.getMinutes()));
 		time.setHours(time.getHours()+2);	
 		trip.setArrival(String.valueOf(time.getHours())+":"+String.valueOf(time.getMinutes()));
		
		trip.setStops(stops);
		
		return ResponseEntity.status(HttpStatus.OK).body(trip);
		
	}

}
