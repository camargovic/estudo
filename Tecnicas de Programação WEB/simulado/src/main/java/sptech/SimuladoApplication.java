package sptech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimuladoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimuladoApplication.class, args);
	}

}


/* Questão única:
Crie um (1, um, só 1 e NÃO 2!!!) projeto Spring Boot que implemente uma API com as seguintes características:

a) (3pts) Tenha 2 recursos, com um conjunto de endpoints CRUD para cada. Ex: Um conjunto de endpoints CRUD para "/filmes" E outro para "/musicas"
(agora NÃO pode mais fazer desses 2, hein!). Por conjunto de CRUD será considerado:



a.1) (0,25pt) Um EndPoint para cadastrar um registro
a.2) (0,25pt) Um EndPoint para obter um registro pelo identificador
a.3) (0,25pt) Um EndPoint para excluir um registro pelo identificador
a.4) (0,25pt) Um EndPoint para obter todos os registros
a.5) (0,25pt) Um EndPoint para atualizar um registro
a.6) (0,25pt) Um EndPoint para obter apenas o total de registros cadastrados. Ele vai retornar só e somente um número (ex: 0 ou 3 ou 55 etc)
a.7) (1,5pt) Um EndPoint para obter um arquivo de texto simples (vulgo "download") que contém algo como um "relatório" de todos os registros do recurso em questão. Exemplo:
Relatório de Filmes
Filmes cadastrados: 3
Filme 1: O retorno dos que não foram, de 2009
Filme 29: Senhor das pulseiras, de 2002
Filme 76: Um sonho secular: o Mundial do Palmeiras, de 1951

Esse "relatório" pode ser do jeito que você quiser, contando que tenha pelo menos 2 campos de todos os registros

Ratificando: seu projeto (no singular, só 1, um, só 1 e NÃO 2!!!) terá um total de 14 endpoints, sendo 7 para cada recurso



b) (1pt) Cada recurso deve ter um campo de identificação com qualquer nome, mas seu tipo deve ser numérico inteiro e de valor autoincremento



c) (2pt) Cada recurso deve ter pelo menos 3 campos fora o campo de identificação, sendo que:

- Pelo menos um deve ser numérico (inteiro OU real, tanto faz)
- Pelo menos um deve ser data OU data e hora


d) (3pt) Use os verbos HTTP apropriados na programação das requisições e Retorne os status HTTP corpo de resposta apropriados para cada EndPoint



e) (1pt) Adote as boas práticas e convenções de:

- Nomes de classes, atributos, variáveis, parâmetros e métodos
- Organização do código em pacotes
- URIs dos EndPoints*/
