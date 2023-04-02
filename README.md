               AAA               XXXXXXX       XXXXXXX     OOOOOOOOO     NNNNNNNN        NNNNNNNN
              A:::A              X:::::X       X:::::X   OO:::::::::OO   N:::::::N       N::::::N
             A:::::A             X:::::X       X:::::X OO:::::::::::::OO N::::::::N      N::::::N
            A:::::::A            X::::::X     X::::::XO:::::::OOO:::::::ON:::::::::N     N::::::N
           A:::::::::A           XXX:::::X   X:::::XXXO::::::O   O::::::ON::::::::::N    N::::::N
          A:::::A:::::A             X:::::X X:::::X   O:::::O     O:::::ON:::::::::::N   N::::::N
         A:::::A A:::::A             X:::::X:::::X    O:::::O     O:::::ON:::::::N::::N  N::::::N
        A:::::A   A:::::A             X:::::::::X     O:::::O     O:::::ON::::::N N::::N N::::::N
       A:::::A     A:::::A            X:::::::::X     O:::::O     O:::::ON::::::N  N::::N:::::::N
      A:::::AAAAAAAAA:::::A          X:::::X:::::X    O:::::O     O:::::ON::::::N   N:::::::::::N
     A:::::::::::::::::::::A        X:::::X X:::::X   O:::::O     O:::::ON::::::N    N::::::::::N
    A:::::AAAAAAAAAAAAA:::::A    XXX:::::X   X:::::XXXO::::::O   O::::::ON::::::N     N:::::::::N
    A:::::A             A:::::A   X::::::X     X::::::XO:::::::OOO:::::::ON::::::N      N::::::::N
    A:::::A               A:::::A  X:::::X       X:::::X OO:::::::::::::OO N::::::N       N:::::::N
    A:::::A                 A:::::A X:::::X       X:::::X   OO:::::::::OO   N::::::N        N::::::N
    AAAAAAA                   AAAAAAAXXXXXXX       XXXXXXX     OOOOOOOOO     NNNNNNNN         NNNNNNN
# Spring Boot Axon CQRS & Event-Sourcing Tutorial

___

## GitHub Repository

click on it => [Spring-Boot-Event-Sourcing-Cqrs-Axon](https://github.com/BabakBazghale/spring-boot-event-sourcing-cqrs-axon)

___

## Access To H2 Console

http://localhost:8080/h2-console

* `username:bob` - h2 console username
* `password:hello bob` - h2 console password
* `JDBC URL:jdbc:h2:mem:bobdb` - h2 console jdbc url

___

## Access To Swagger UI

http://localhost:8080/swagger-ui.html

___


### REST APIS CURLS 

wallet-creation
```bash
curl --location --request POST 'http://localhost:8080/wallet/creation' \
--header 'Content-Type: application/json' \
--data-raw '{
"isMemoRequired":"false",
"token":"bnb",
"blockchainNetwork":"bsc"
}'
````

receive-crypto
```bash
curl --location --request POST 'http://localhost:8080/wallet/receive/{address}' \
--header 'Content-Type: application/json' \
--data-raw '{
"receivedAmount":"200",
"token":"bnb",
"blockchainNetwork":"bsc"
}'
````

transfer-crypto
```bash
curl --location --request POST 'http://localhost:8080/wallet/transfer/{address}' \
--header 'Content-Type: application/json' \
--data-raw '{
"transferAmount":"20",
"token":"bnb",
"blockchainNetwork":"bsc"
}'
```

freeze-crypto
```bash
curl --location --request POST 'http://localhost:8080/wallet/freeze/{address}' \
--header 'Content-Type: application/json' \
--data-raw '{
"freezeAmount":"20",
"token":"bnb",
"blockchainNetwork":"bsc"
}'
```

get-wallet-detail
```bash
curl --location --request GET 'http://localhost:8080/wallet/{address}'
```

get-wallet-events
```bash
curl --location --request GET 'http://localhost:8080/wallet/{address}/events'
```