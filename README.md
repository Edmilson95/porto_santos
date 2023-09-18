<h1 align="center"> Porto de Santos API </h1>

<h2>Descrição do Projeto</h2>
Este projeto é uma API desenvolvida em Java com o uso do framework Spring Boot 3. Ele permite gerenciar operações de movimentação de contêineres, com suporte para os recursos de CRUD de contêineres, CRUD de movimentações e relatórios de movimentação. A API utiliza tecnologias como Lombok, MySql, Flyway, JPA/Hibernate e Maven para facilitar o desenvolvimento e a persistência dos dados. Para testar as requisições, recomenda-se o uso do Insomnia.

![Porto com vários conteiners](https://s2-g1.glbimg.com/tJyofHaT7PknNkbBkYqTmt7YQOc=/0x0:796x529/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2020/C/V/bXc9JCTR2ZSaAvoJSkgA/porto.jpg)


![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)


<h3>Funcionalidades Principais</h3>
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

<h3>Tecnologias Utilizadas</h3>
Linguagem de Programação: Java
Framework: Spring Boot 3
Biblioteca: Lombok
Banco de Dados: MySql
Controle de Migrações: Flyway
ORM: JPA/Hibernate
Gerenciador de Dependências: Maven
Ferramenta de Teste de Requisições: Insomnia

<h3>Como Utilizar</h3>
Clone este repositório em sua máquina local.
Configure o ambiente de desenvolvimento com as dependências necessárias, incluindo a configuração do banco de dados MySql.
Execute o aplicativo Java para iniciar o servidor.
Utilize o Insomnia ou qualquer outra ferramenta similar para testar as requisições disponíveis na API, como os endpoints de CRUD de contêineres e movimentações.
Para gerar relatórios de movimentação, acesse os endpoints específicos e verifique o resultado retornado pela API.<br><br>



