/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.etapa9.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author Nicolas
 */
@Data
@Entity
@Table(name="produtos")
public class ProdutosEntity {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
@Size(min=1, message="Informe a marca do produto")
private String marca;

@Size(min=1, message="Informe o nome do produto")
private String nome;


private String status = "Á Venda";
private String preco;
   
   
    
}
