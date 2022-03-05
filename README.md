# Assembleia de Votação

#### Sistema para Assembleia de Votação

A aplicação aqui disponibilizada é minha implementação de um desafio técnico para uma oportunidade de Java Software Developer.

#### Descritivo
No cooperativismo, cada associado possui um voto e as decisões são tomadas em assembleias, por votação. A partir disso, você precisa criar uma solução back-end para gerenciar essas sessões de votação. Essa solução deve ser executada na nuvem e promover as seguintes funcionalidades através de uma API REST:

- Cadastrar uma nova pauta;

- Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por um tempo determinado na chamada de abertura ou 1 minuto por default);

- Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associado é identificado por um id único e pode votar apenas uma vez por pauta);

- Contabilizar os votos e dar o resultado da votação na pauta

# Configuração para teste

Foi adicionado dois arquivos exportado do Isomnia e Postman contendo todas as chamadas de endpoins, assim   
será mais fácil testar a API

Optei por adicionar dois arquivos localizados na raiz do projeto para serem usados no API Client de sua preferencia: Insomnia_Assembleia e Postman_Assembleia

Caso opte pelo Postman: Workspace -> Import -> File -> Upload -> Import

Caso opte pelo Insomnia: Create -> File -> Import

# Deploy no Heroku

Optei por realizar o deploy na plataforma do Heroku.

La deixei ja configurado variaveis de acesso.

O banco de dados utilizado foi o MongoDB e utilizei um cluster rodando no servidor.

O cluster foi criado de forma exclusiva para o desenvolvimento desse teste por isso removi autenticação para qualquer um poder acessar os recursos persistidos.

Para testar a versão do Heroku basta importar o arquivo com sufixo do API Client de preferencia. Ex: Postman_Assemblea_Heroku

# Testando localmente

Para realizar o buil e executar o projeto localmente via terminal **é necessário ter o gradle instalado na máquina**.

Neste link é possível aprender como fazer o build da aplicação com o Gradle no Windows  
https://giordanolins.com/instalando-e-configurando-o-gradle-no-windows/

Fique a vontade para usar o cluster do mongodb que configurei em src/main/resourcer/application.properties.

Caso queira usar uma outra instancia de mongodb lembre-se de alterar a URI, configurar o banco de dados e executar o projeto.

# Excutando aplicação Localmente via terminal

### Clone this repository
``` clone https://github.com/drextar/voting-assembly.git voting-assembly```

### Go into the repository
```cd voting-assembly```

### Build application
```gradle build install```

### Run the application
```gradle bootRun```

Para testar o funcionamento basta acessar `http://localhost:5000/{resource}` ou acessar todos os end-points importados no API Cliente.

Para testar a versao local basta importar o arquivo do API Client escolhido com sufixo {Local} .

# Excutando aplicação Localmente via IDE

Utilizei o IntelliJ IDEA para desenvolvimento.
https://www.jetbrains.com/pt-br/idea/download/

Clone o projeto como demonstrado na sessão anterior, importe o projeto no IntelliJ, aguarde o download de todas as dependencias e execute a aplicação.

Assim como via terminal, basta acessar `http://localhost:5000/{resource}` ou acessar todos os end-points importados no API Cliente.

Para testar a versao local basta importar o arquivo do API Client escolhido com sufixo {Local} .

# Documentação da API

A documentacao das APIs está disponibilizada via Swagger UI.

A forma de acesso ao Swagger varia de acordo com o metodo de deploy a ser testado **no navegador** de sua preferência:

Caso queira testar o deploy do Heroku basta acessar:

``` https://voting-assembly.herokuapp.com/swagger-ui.html ```

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

***Observação***: No desenvolvimento da integração com sistema externo percebi que a API disponibilizada no enunciado do teste `https://user-info.herokuapp.com/users/{cpf}` tem bastante instabilidade e por vezes retorna falsos negativos mesmo passando CPFs válidos. Não sabia se poderia usar uma outra API para fazer isso então preferi seguir com a fornecida e evidenciar aqui.

Pretendia utilizar mensageria com RabbitMQ mas não havia mais tempo para a conclusão do desafio.
