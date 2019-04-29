package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.VilleFrance;
import com.dao.VilleFranceDAO;

@RestController
public class MethodesController {
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<VilleFrance> get(
			@RequestParam(required = false, value = "codeCommuneINSEE") String codeCommuneINSEE,
			@RequestParam(required = false, value = "nomCommune") String nomCommune,
			@RequestParam(required = false, value = "codePostal") String codePostal,
			@RequestParam(required = false, value = "libelleAcheminement") String libelleAcheminement,
			@RequestParam(required = false, value = "ligne5") String ligne5,
			@RequestParam(required = false, value = "latitude") String latitude,
			@RequestParam(required = false, value = "longitude") String longitude) throws SQLException {
		System.out.println("Appel GET");

		ArrayList<VilleFrance> villes = new ArrayList<VilleFrance>();
		VilleFranceDAO villeFranceDAO = new VilleFranceDAO();

		VilleFrance ville = new VilleFrance();

		villes = villeFranceDAO.trouver(
				ville.map(codeCommuneINSEE, nomCommune, codePostal, libelleAcheminement, ligne5, latitude, longitude));

		return villes;
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	@ResponseBody
	public void post(@RequestParam(required = true, value = "codeCommuneINSEE") String codeCommuneINSEE,
			@RequestParam(required = true, value = "nomCommune") String nomCommune,
			@RequestParam(required = true, value = "codePostal") String codePostal,
			@RequestParam(required = true, value = "libelleAcheminement") String libelleAcheminement,
			@RequestParam(required = true, value = "ligne5") String ligne5,
			@RequestParam(required = true, value = "latitude") String latitude,
			@RequestParam(required = true, value = "longitude") String longitude) throws SQLException {
		System.out.println("Appel POST");

		VilleFrance ville = new VilleFrance();
		ville = ville.map(codeCommuneINSEE, nomCommune, codePostal, libelleAcheminement, ligne5, latitude, longitude);

		VilleFranceDAO villeFranceDAO = new VilleFranceDAO();
		villeFranceDAO.ajouter(ville);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@RequestParam(required = true, value = "codeCommuneINSEE") String codeCommuneINSEE)
			throws SQLException {
		System.out.println("Appel DELETE");

		VilleFranceDAO villeFranceDAO = new VilleFranceDAO();
		villeFranceDAO.effacer(codeCommuneINSEE);
	}

	@RequestMapping(value="/put", method=RequestMethod.PUT)
	@ResponseBody
	public void put(@RequestParam(required = false, value="codeCommuneINSEE") String codeCommuneINSEE,
					@RequestParam(required = false, value="nomCommune") String nomCommune,
					@RequestParam(required = false, value="codePostal") String codePostal,
					@RequestParam(required = false, value="libelleAcheminement") String libelleAcheminement,
					@RequestParam(required = false, value="ligne5") String ligne5,
					@RequestParam(required = false, value="latitude") String latitude,
					@RequestParam(required = false, value="longitude") String longitude) throws SQLException {
		System.out.println("Appel PUT");
		VilleFrance ville = new VilleFrance();
		ville = ville.map(codeCommuneINSEE, nomCommune, codePostal, libelleAcheminement, ligne5, latitude, longitude);
		VilleFranceDAO villeFranceDAO = new VilleFranceDAO();
		villeFranceDAO.modifier(ville);
	}
}
