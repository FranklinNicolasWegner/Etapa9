/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.etapa9.controller;

import com.api.etapa9.data.ProdutosEntity;
import com.api.etapa9.service.ProdutosService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



/**
 *
 * @author Nicolas
 */

@Controller
public class ProdutosController {
    
    @Autowired
    ProdutosService produtosService;
    
    @GetMapping("/")
    public String viewHomePage(Model model){
        
        model.addAttribute("listarProdutos", produtosService.listarTodosProdutos());
        
        return "index";
    }

    
    @GetMapping("/deletarProduto/{id}")
    public String deletarProduto(@PathVariable(value="id")Integer id){
        
        produtosService.deletarProdutos(id);
        
        return "redirect:/";
    }

    @GetMapping("/criarProdutosForm")
    public String criarProdutosForm(Model model){
        ProdutosEntity prod = new ProdutosEntity();
        model.addAttribute("produto", prod);
        return "adicionar";
    }

    @PostMapping("/salvarProduto")
    public String salvarProduto(@Valid @ModelAttribute("produto") ProdutosEntity prod, BindingResult result){
        
        if(result.hasErrors()){
            return "adicionar";
        }
        
        if(prod.getId()==null){
            produtosService.criarProduto(prod);
        }else{
            produtosService.atualizarProduto(prod.getId(), prod);
        }
    
        return "redirect:/";
        
    }

    @GetMapping("/atualizarProdutosForm/{id}") 
    public String atualizarProdutoForm(@PathVariable(value = "id") Integer id, Model model) { 

      ProdutosEntity prod = produtosService.getProdutosId(id);

      model.addAttribute("produto", prod); 

      return "atualizar"; 
    } 
        

    @GetMapping("/venderProduto/{id}")
    public String venderProduto(@PathVariable(value="id")Integer id){
        
        produtosService.venderProduto(id);
        
        return "redirect:/";
    }
}
