package com.example.slbeats.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.slbeats.DAO.ICheckout;
import com.example.slbeats.model.Checkout;
import com.example.slbeats.model.Usuario;

@RestController
@CrossOrigin("*")
@RequestMapping("/checkout")
public class CheckoutController {
	
	@Autowired
	private ICheckout dao;
	
	@GetMapping
	public List<Checkout> listaCheckout () {
		return (List<Checkout>) dao.findAll();
	
	}
	
	@PostMapping
	public Checkout criarCheckout (@RequestBody Checkout checkout) {
		Checkout checkoutNovo = dao.save(checkout);
		return checkoutNovo;
	}
	
	@PutMapping
	public Checkout editarCheckout (@RequestBody Checkout checkout) {
		Checkout checkoutNovo = dao.save(checkout);
		return checkoutNovo;
	}
	
	@DeleteMapping("/{id}")
	public Optional<Checkout> excluirUsuario (@PathVariable Long id) {
		Optional<Checkout> checkout = dao.findById(id);
		dao.deleteById(id);
		return checkout;
	}

}
