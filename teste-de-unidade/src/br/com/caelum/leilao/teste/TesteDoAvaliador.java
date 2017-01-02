package br.com.caelum.leilao.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class TesteDoAvaliador {

	@Test
	public void shouldUnderstandLanceInCrescentOrder() {
		//parte1: cenario
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao ("PS3");

		leilao.propoe(new Lance(joao, 250));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400.0));
		//acao
		Avaliador xesus = new Avaliador();
		xesus.avalia(leilao);
		double menorEsperado = 250;
		double maiorEsperado = 400;
		//validacao
		Assert.assertEquals(maiorEsperado, xesus.getMaiorLance(), 0.000001);
		Assert.assertEquals(menorEsperado, xesus.getMenorLance(), 0.000001);

	}
}
