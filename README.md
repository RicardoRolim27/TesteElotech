# TesteElotech

Infelizmente tive problemas para fazer o deploy no Heroku, segue abaixo o erro:

Build master 05c9d9e5
There was an issue deploying your app. View the build log for details.

-----> Building on the Heroku-20 stack
-----> Using buildpack: heroku/java
-----> App not compatible with buildpack: https://buildpack-registry.s3.amazonaws.com/buildpacks/heroku/java.tgz
       Could not find a pom.xml file! Please check that it exists and is committed to Git.
       More info: https://devcenter.heroku.com/articles/buildpacks#detection-failure
 !     Push failed

# Caso souber como corrigir favor entrar em contato comigo por email ricardorolim27@gmai.com

Dessa forma não continuei com o processo de configuração com o postgresql no Heroku

Mas consegui implementar alguns métodos para testes locais.

Usando o Postman.

* Inserir Contato método Post
Link: localhost:8080/contatos/1
Body > Raw > Json
{
   "name": "Maria",
   "phone": "999885563",
   "email": "maria@gmail.com",
   "pessoa": 1
}

* Inserir Pessoa método Post
localhost:8080/cadastro
{
    "name": "Joao",
    "cpf": "122.754.882-39",
    "dataNascimento": "1985-01-18"
}

* Atualizar Cadastro método Put
localhost:8080/cadastro/update/1/1
{
    "name": "Carlos",
    "cpf": "122.754.882-40",
    "dataNascimento": "2000-01-18"
}

* Delete Registro método Delete
localhost:8080/cadastro/1/delete

* Find All Pessoa método Get
localhost:8080/cadastro/all

* Find All Contatos método Get
localhost:8080/contatos
