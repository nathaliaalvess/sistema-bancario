## Sistema Bancario

#### Débitos técnicos por falta de tempo:
- implementação de fluxo de retry e dead-letter para as mensagens do kafka;
- criação de database separado por aplicação e criação de mecanismo de replicação para utilização do serviço de consulta;
- testes de integração com kafka e mongo;
- criação de bibliotecas compartilhadas para elementos comuns entre os serviços;


#### Arquitetura:
![alt text](https://github.com/nathaliaalvess/sistema-bancario/blob/develop/arquitetura.png?raw=true)


#### Start das aplicações:
- Na pasta principal existe um docker-compose que subirá localmente os serviços necessários para startar as aplicações;
- As aplicações estão configuradas para rodas nas portas:
	- cliente : 8080
	- consulta : 8084
	- conta : 8081
	- cheque-especial : 8082
	- cartao-credito : 8083
- Para testar os serviços basta acessar:
	- cliente : localhost:8080
	- consulta : localhost:8084 
