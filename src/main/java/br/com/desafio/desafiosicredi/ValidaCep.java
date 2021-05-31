package br.com.desafio.desafiosicredi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;


public class ValidaCep {
	
	@Test
	public void TestaCepValido(){
		int statuscode = RestAssured.given()
				.when()
				.get("https://viacep.com.br/ws/96745000/json")
					.andReturn()
						.statusCode();		
		assertEquals(200, statuscode);
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://viacep.com.br/ws/96745000/json";
		ResponseEntity<Cep> response = restTemplate.getForEntity(url, Cep.class);
				
		if (200 == statuscode) {	
						
			System.out.println("Cep Valido");
			System.out.println(response.getBody().getCep());
			System.out.println(response.getBody().getLogradouro());
			System.out.println(response.getBody().getComplemento());
			System.out.println(response.getBody().getBairro());
			System.out.println(response.getBody().getLocalidade());
			System.out.println(response.getBody().getUf());
			System.out.println(response.getBody().getIbge());
			}
	}
	
	@Test
	public void TestaCepInexistente(){
		int statuscode = RestAssured.given()
				.when()
					.get("https://viacep.com.br/ws/96745000/json")
						.andReturn()
							.statusCode();
		assertEquals(200, statuscode);
		Response response = RestAssured.request(Method.GET, "https://viacep.com.br/ws/91745000/json");
		Assert.assertTrue(response.getBody().asString().contains("erro"));
		if (response.getBody().asString().contains("erro")) {				
			System.out.println("Cep inexistente");
		}
		
	}
		
	@Test
	public void TestaCepInvalido(){
		int statuscode = RestAssured.given().when().get("https://viacep.com.br/ws/967a5000/json")
		.andReturn().statusCode();
		
		assertEquals(400, statuscode);
		
			
		if (400 == statuscode) {
			System.out.println("Cep no formato Invalido: favor digitar no formato 99999-999 ou 99999999");
			}		
	}
		
}
