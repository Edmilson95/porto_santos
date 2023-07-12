# Porto de Santos API

> Status do projeto: Em desenvolvimento

<h1>Descrição do Projeto</h1>
Este projeto é uma API desenvolvida em Java com o uso do framework Spring Boot 3. Ele permite gerenciar operações de movimentação de contêineres, com suporte para os recursos de CRUD de contêineres, CRUD de movimentações e relatórios de movimentação. A API utiliza tecnologias como Lombok, MySql, Flyway, JPA/Hibernate e Maven para facilitar o desenvolvimento e a persistência dos dados. Para testar as requisições, recomenda-se o uso do Insomnia.

<h1>Funcionalidades Principais</h1>
***Contêineres***: Permite criar, ler, atualizar e excluir informações de contêineres. Cada contêiner possui os seguintes atributos:

Cliente
Número do contêiner (4 letras e 7 números, por exemplo: TEST1234567)
Tipo (20 / 40)
Status (Cheio / Vazio)
Categoria (Importação / Exportação)<br><br>
#Movimentação de Contêineres#: Permite registrar as movimentações de contêineres, incluindo as seguintes informações:

Tipo de Movimentação (embarque, descarga, gate in, gate out, reposicionamento, pesagem, scanner)
Data e Hora do Início
Data e Hora do Fim
Relatório de Movimentações: A API gera relatórios com o total de movimentações agrupadas por cliente e tipo de movimentação. No final do relatório, é apresentado um sumário com o total de importação/exportação.

<h1>Tecnologias Utilizadas</h1>
Linguagem de Programação: Java
Framework: Spring Boot 3
Biblioteca: Lombok
Banco de Dados: MySql
Controle de Migrações: Flyway
ORM: JPA/Hibernate
Gerenciador de Dependências: Maven
Ferramenta de Teste de Requisições: Insomnia

<h1>Como Utilizar</h1>
Clone este repositório em sua máquina local.
Configure o ambiente de desenvolvimento com as dependências necessárias, incluindo a configuração do banco de dados MySql.
Execute o aplicativo Java para iniciar o servidor.
Utilize o Insomnia ou qualquer outra ferramenta similar para testar as requisições disponíveis na API, como os endpoints de CRUD de contêineres e movimentações.
Para gerar relatórios de movimentação, acesse os endpoints específicos e verifique o resultado retornado pela API.

Link do Youtube demonstrando parte do [processo do desenvolvimento](https://youtu.be/4SXlMr3HTPM) <- (tempo limite de 1 hora de vídeo)

Link do Youtube mostrando [CRUD finalizado](https://youtu.be/1Vg4cvO07mk)

