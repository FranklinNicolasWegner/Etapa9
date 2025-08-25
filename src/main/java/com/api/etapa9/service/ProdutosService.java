/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.etapa9.service;

import com.api.etapa9.data.ProdutosEntity;
import com.api.etapa9.data.ProdutosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nicolas
 */
@Service
public class ProdutosService {
    
    @Autowired
    
    ProdutosRepository produtosRepository;
    
    public ProdutosEntity criarProduto(ProdutosEntity prod){
        
        prod.setId(null);
        
        produtosRepository.save(prod);
        
        return prod;
    }

   public ProdutosEntity atualizarProduto(Integer prodId, ProdutosEntity produtosRequest){
       
       ProdutosEntity prod = getProdutosId(prodId);
       
       prod.setNome(produtosRequest.getNome());
       prod.setMarca(produtosRequest.getMarca());
       prod.setPreco(produtosRequest.getPreco());
       prod.setStatus(produtosRequest.getStatus());
       
       produtosRepository.save(prod);
       
       return prod;
   }

   public ProdutosEntity getProdutosId(Integer prodId){
       return produtosRepository.findById(prodId).orElse(null);
   }
   
   public List<ProdutosEntity> listarTodosProdutos(){
       return produtosRepository.findAll();
   }
   
   public void deletarProdutos(Integer prodId){
       ProdutosEntity prod = getProdutosId(prodId);
       
       produtosRepository.deleteById(prod.getId());
   }
   
   public ProdutosEntity venderProduto(Integer prodId){
       
       ProdutosEntity prod = getProdutosId(prodId);
       
       prod.setStatus("Vendido");
       
       produtosRepository.save(prod);
       
       return prod;
   }
   
}
