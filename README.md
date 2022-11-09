# MVC

## Model

Customer
email
firstName
lastName

## View

JSON/REST

## Controller

CustomerResource

## Business Logic

CustomerResource

# Domain Driven Design

## Aggregate

Customer
Business Logic

## Repositories
CustomerRepository

## Value Objects

CustomerRecord

## Services

CustomerService

## Hexagonal Architecture

KafkaResource

```
kcat -b localhost:55004 -t customers-in -P
{"firstName":"FIRST_NAME","lastName":"LAST_NAME","email":"EMAIL_ADDRESS"}
```
Enter
Ctrl-D