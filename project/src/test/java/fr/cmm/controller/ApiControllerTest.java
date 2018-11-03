package fr.cmm.controller;

import fr.cmm.service.RecipeService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(classes = ApiControllerTestConfig.class)

@WebAppConfiguration

public class ApiControllerTest {
    @Inject
    RecipeService recipeService;

    @Inject
    WebApplicationContext wac;
    MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = webAppContextSetup(wac).build();
        Mockito.reset(recipeService);
    }

    @Test
    public void recetteParIdJSON() throws Exception {
        String id = "5bbef40877c84fd3e1046c1d";
        Mockito.when(recipeService.findById(id)).thenReturn(new Recipe());
        mockMvc.perform(get("/api/recipes/"+id))
                .andExpect(status().is(200));
    }

    @Test
    public void listeRecettesJSON() throws Exception {
        mockMvc.perform(get("/api/recipes/").contentType("application/json"))
                .andExpect(status().is(200));
}
