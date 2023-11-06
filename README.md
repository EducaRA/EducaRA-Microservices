# EducaRA-Microservices
EducaRA Microservices
Backend EducaRA APP e EducaRA Web

# Project Setup
Projeto Utiliza o framework Laravel/PHP, Postgresql e NGINX

composto por 3 microserviços

Inicialmente renomeie o arquivo `.env.example` presente na raiz do projeto para `.env`

Configure as propriedades desse arquivo de acordo a sua necessidade. Nele estão centralizados as variáveis de ambiente comuns aos microsserviços e que possuem importancia de ser separado nele;

Para a geração do JWT_SECRET execute `php artisan jwt:secret` e coloque em .env na raiz do projeto

Para iniciá-los execute:

```
docker-compose up
```

Na raiz do projeto

Para rebuild das tabelas do bando e recriar a seed (em caso de não funcionar):
```
php artisan migrate:fresh --seed
```
Outra forma de fazer:

```
php artisan migrate:fresh
php artisan db:seed
```
