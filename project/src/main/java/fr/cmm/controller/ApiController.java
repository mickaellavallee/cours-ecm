package fr.cmm.controller;

import com.sun.tools.javac.util.DefinedBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fr.cmm.service.RecipeService;
import javax.inject.Inject;
import javax.management.openmbean.CompositeData;

@Controller
public class ApiController{

    @Inject
    private RecipeService recipeService;

    @RequestMapping("/api/recipes")
    public String liste(){
        return "Liste";
    }

    @RequestMapping("/api/recipes/{id}")
    public String recette(){
        return "Recette";
    }


}


