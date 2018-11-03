package fr.cmm.controller;

import com.sun.tools.javac.util.DefinedBy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.inject.Inject;
import javax.management.openmbean.CompositeData;

import java.util.Collections;
import java.util.Iterator;

import fr.cmm.domain.Recipe;
import fr.cmm.helper.PageQuery;
import fr.cmm.service.RecipeService;


@Controller
public class ApiController{

    @Inject
    private RecipeService recipeService;

    @RequestMapping(value = "/api/recipes", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Iterable<Recipe> listeRecettesJSON(){
        PageQuery pageQuery = new PageQuery();
        return recipeService.findByQuery(pageQuery);
    }

    @RequestMapping(value = "/api/recipes/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Recipe recetteParIdJSON(@PathVariable("id") String id){
        if (recipeService.findById(id) == null)
            throw new ResourceNotFoundException();
        else
            return recipeService.findById(id);
    }


}