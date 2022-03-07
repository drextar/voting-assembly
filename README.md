
# Assembleia de Votação  

#### Sistema para Assembleia de Votação

A aplicação aqui disponibilizada é minha implementação de um desafio técnico para uma oportunidade de atuação como Java Software Developer.

#### Descritivo
No cooperativismo, cada associado possui um voto e as decisões são tomadas em assembleias, por votação. A partir disso, você precisa criar uma solução back-end para gerenciar essas sessões de votação. Essa solução deve ser executada na nuvem e promover as seguintes funcionalidades através de uma API REST:  
  
- Cadastrar uma nova pauta;  
  
- Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por um tempo determinado na chamada de abertura ou 1 minuto por default);  
  
- Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associado é identificado por um id único e pode votar apenas uma vez por pauta);  
  
- Contabilizar os votos e dar o resultado da votação na pauta  
  
# Configuração para teste  
  
Foi adicionado dois arquivos exportado do Isomnia e Postman contendo todas as chamadas de endpoins, assim   
será mais fácil testar a API  
  
Decidi adicionar dois arquivos localizados na raiz do diretório para serem usados no API Client de sua preferencia: Insomnia_Assembleia e Postman_Assembleia  
  
Caso opte pelo Postman: Abra o Postman -> Workspace -> Import -> File -> Upload -> Import  
  
Caso opte pelo Insomnia: Abra o Insomnia -> Create -> File -> Import
  
# Deploy no Heroku  
  
Optei por realizar o deploy em ambiente PaaS na plataforma do Heroku, configurando deploy a partir da branch main.
  
Deixei já configurado variáveis de acesso.  
  
O banco de dados utilizado foi o MongoDB e utilizei um cluster rodando no servidor.  
  
O cluster foi criado de forma exclusiva para o desenvolvimento desse teste por isso removi autenticação, qualquer um poder acessar os recursos persistidos.
  
Para testar a versão do Heroku basta importar o arquivo com sufixo do API Client de preferencia. Ex: Postman_Assemblea_Heroku

***Observação***: A aplicação está rodando em free tier do Heroku, ou seja, caso não haja interação com a aplicação num período de 30 minutos ela automaticamente entrará em um estado de suspensão. Basta executar qualquer requisição ao domínio que a plataforma automaticamente irá buildar e executar a aplicação e retornar ao cliente. A primeira requisição irá demorar bem mais que as outras mas depois disso todas serão respondidas rapidamente.
  
# Testando localmente  

Para realizar o build e executar o projeto localmente via terminal **é necessário ter o gradle instalado na máquina**.

Neste link é possível aprender como fazer o build da aplicação com o Gradle no Windows  
https://giordanolins.com/instalando-e-configurando-o-gradle-no-windows/  
  
Fique à vontade para usar o cluster do MongoDB que configurei em src/main/resourcer/application.properties.
  
Caso queira usar uma outra instância de MongoDB lembre-se de alterar a URI, configurar o banco de dados e executar o projeto.

# Excutando aplicação Localmente via terminal 

### Clone this repository  
``` 
clone https://github.com/drextar/voting-assembly.git voting-assembly
```
  
### Go into the repository  
```
cd voting-assembly
```
  
### Build application  
```
gradle build install
```
  
### Run the application  
```
gradle bootRun
```
 
Para testar o funcionamento basta acessar `http://localhost:5000/{resource}` ou acessar todos os end-points importados no API Cliente.

Para testar a versao local basta importar o arquivo do API Client escolhido com sufixo {Local} .
  
# Excutando aplicação Localmente via IDE  
  
Utilizei o IntelliJ IDEA para desenvolvimento.
Link para download do IntelliJ: https://www.jetbrains.com/pt-br/idea/download/

Clone o projeto como demonstrado na sessão anterior, importe o projeto no IntelliJ, aguarde o download de todas as dependencias e execute a aplicação.
  
Assim como via terminal, basta acessar `http://localhost:5000/{resource}` ou acessar todos os end-points importados no API Client.
  
Para testar a versao local basta importar o arquivo do API Client escolhido com sufixo {Local} .
  
# Documentação da API  
  
A documentacao das APIs está disponibilizada via Swagger UI.  
  
A forma de acesso ao Swagger varia de acordo com o método de deploy a ser testado **no navegador** de sua preferência:  

Caso queira testar o deploy do Heroku basta acessar: ``` https://voting-assembly.herokuapp.com/swagger-ui.html ```

Caso queira testar localmente é necessário iniciar a aplicacao e depois acessar: `http://localhost:5000/swagger-ui.html`

# Features
### Objetivo
- [x] Cadastro de pauta 
- [x] Abrir sessão de votação 
- [x] Recebimento de votos
- [x] Persistência dos votos

### Bônus
- [x] Integração com sistema externo
- [x] Performance
- [x] Versionamento de API
- [ ] Mensageria

Gostaria de ter implementado o bônus de mensageria utilizando RabbitMQ mas não havia mais tempo para a conclusão do desafio.

# Performance

Foi realizado um teste de carga nas APIs utilizando Apache JMeter.

#### Configuração do grupo de usuário para teste:
- Threads: 10.
- Inicialização: 1
- Contador: 10.

Para acessar o resultado abra os arquivos "LoadTestData" localizados na raíz do repositório.

Dentro dela encontratá dois arquivos: .csv e .xlsx

- O .csv é o resultado separado por vírgulas da forma que o JMeter fornece.

- O .xlsx é um arquivo já formatado no Excel, facilitando a leitura.

# Quality Gate

A aplicação foi submetida no SonarQube e o resultado se encontra abaixo:

![SonarQube Quality Gate](https://i.ibb.co/ZK5Bdhk/Quality-Gate-Sonar.png)
