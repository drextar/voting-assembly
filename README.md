# Assembleia de Votação

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

Para build do projeto de forma local é necessário instalar o gradle na máquina.

Neste link é possível aprender como fazer o build da aplicação com o Gradle no Windows
https://giordanolins.com/instalando-e-configurando-o-gradle-no-windows/

Fique a vontade para usar o cluster do mongodb que configurei em src/main/resourcer/application.properties

Caso queira usar uma outra instancia de mongodb lembre-se de alterar a uri, configurar o banco de dados e rodar o projeto.

# Rodando Localmente via terminal

# Clone this repository
$ git clone https://github.com/drextar/voting-assembly.git voting-assembly

# Go into the repository
$ cd voting-assembly

# Build application
$ gradle build install

# Run the application
$ gradle bootRun

Para testar o funcionamento basta acessar `http://localhost:5000/` ou acessar todos os end-points importados no API Cliente

Para testar a versao local basta importar do API Client de preferencia a versao correspondente ao sufixo {Local}

# Rodando Licalmente via IDEA

Utilizei o IntelliJ IDEA para desenvolvimento, basta importar, aguardar o download de todas as dependencias e executar.

Assim como via terminal, basta acessar `http://localhost:5000/` ou acessar todos os end-points importados no API Cliente

Para testar a versao local basta importar do API Client de preferencia a versao correspondente ao sufixo {Local}

# Documentação da API

A documentacao das APIs está disponibilizada via Swagger UI.

A forma de acesso ao Swagger varia de acordo com o metodo de deploy a ser testado no navegador:

Caso queira testar o deploy do Heroku basta acessar: https://voting-assembly.herokuapp.com/swagger-ui.html

Caso queira testar localmente e necessario iniciar a aplicacao e depois: http://localhost:8080/swagger-ui.html
