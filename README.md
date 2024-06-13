# INTRODUÇÃO
    Prova pática para o processo seletivo Back-end da Studio Sol.
- O problema é determinar quantas diferentes maneiras existem para alcançar um determinado total de pontos 
   em um jogo de futebol americano.

## INFORMAÇOES DADAS
- Touchdown (6 pontos)
- Extra touchdown (2 pontos são obtidos somente após a marcação de um touchdown)
- Field goal (3 pontos)

# STACK
- Linguagem: Java 17
- Biblioteca usada: Spring Boot
- Biblioteca de Teste: jUnit e Mockito
- Containerização: Docker

# COMO EXECUTAR A APLICAÇÃO LOCALMENTE
JAVA JDK 17 INSTALADO
   - cd <pasta-onde-está-o-projeto>/israelpx
   - mvn spring-boot:run
     Abra seu postman e vá para http://localhost:8080/verify (ou a porta que você configurou, se for diferente).

# ATRAVES DO DOCKER
   - cd <pasta-onde-está-o-projeto>/israelpx
   - docker build -t teste-studiosol .
   - docker run -p 8080:8080 teste-studiosol -> sera executado na porta 8080
     Abra seu postman e vá para http://localhost:8080/verify (ou a porta que você configurou, se for diferente).

################################ PROCESSO DE DESENVOLVIMENTO ################################

# PROCESSO PARA CALCULAR AS COMBINAÇÕES
    QUEBREI O PROBLEMA EM 3 PARTES:
            1- Separei a string do score com o split "x" e peguei os valores da parte [0] e [1] e convertir para inteiro.
            2- Calculei as combinaçoes de cada time separadamente.
            3- Multipliquei as pontuaçoes dos 2 times para ter o total de possibilidades.






