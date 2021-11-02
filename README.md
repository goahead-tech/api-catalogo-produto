# api-catalogo-produto

API para Cadastro de Produtos, Esse projeto tem um servidor de aplicações desenvolvido em Java + Spring Boot que será rodado localmente para
facilitar a consumo de uma API.

Para visualizar a aplicação funcionando deverá:

Fazer um fork desse projeto, criando um repositório na sua própria conta.
Instalar o Java 1.8 na sua máquina caso não esteja instalado;

Abra o terminal e rode os seguintes comandos:
Vá até na Pasta aonde o projeto foi baixado e a seguir de o Comando 

mvn clean install -DskipTests

Logo em seguida de um comando "ls" e vá até o diretório /target após esse comando de outra vez o comando "ls", 
logo em seguida certifique se o arquivo catalogo-produto.jar está dentro do diretório.

Após certificar de o comando:

java -jar catalogo-produto

Após a aplicação subir acesse: http://localhost:8089/swagger-ui.html para acessar o Swagger

Lembrando que o DB está configurado com H2 por esse motivo acessar o metodo POST para incluir alguns registro e assim utilizar os outros metodos.

Qualquer dúvida entre em contato pelo gitHub ou pelo https://www.linkedin.com/in/rodrigo-nunes-galvan-6852051a5/




