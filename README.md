# Projeto-Maven-Backend REST-API 3.0 com integração com o banco de dados
**Crud Completo com Verbos HTTP:** 
* `GET`
* `POST`
* `PUT`
* `DELETE`

**Tipos de Colunas**
- Campos não podem ser nulos ou em brancos
- Limite de caracteres
- Tipo unico no sistema
- Email válido
- Datas com data e hora
- Datas com somente a data

**End-Points Personalizados**
- Aniversariantes do Mês

## Rodando o Projeto
### Pré-Requisitos Para rodar o projeto
- Git
- JDK 11+
- Maven 3.8.1

### Maven
**Lembrando que precisa do MySQL já esta rodando!**<br/>

Use o seguinte comando para iniciar o servidor:<br/>
<small>Obs: Esse comando deve ser executado na _raiz_ do projeto!</small>
```shell script
./mvnw clean compile quarkus:dev
```
