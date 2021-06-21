## Desafio Sicredi 
Desafio de Automação de Testes de API
 
 <b>Nesse desafio, os objetivos são desenvolver testes baseados nos cenários abaixo, utilizando o serviço que está no link:</b>
 
URL: https://viacep.com.br/ws/91060900/json/ 
Cenário: Consulta CEP valido

Dado que o usuário inseri um CEP válido
Quando o serviço é consultado
Então é retornado o CEP, logradouro, complemento, bairro, localidade, uf e ibge.


Cenário: Consulta CEP inexistente 
Dado que o usuário inseri um CEP que não exista na base dos Correios
Quando o serviço é consultado  
Então é retornada um atributo erro 


Cenário: Consulta CEP com formato inválido 
Dado que o usuário inseri um CEP com formato inválido
Quando o serviço é consultado 
Então é retornado uma mensagem de erro
