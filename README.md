# INTRODUÇÃO
    Prova pática para o processo seletivo Back-end da Studio Sol.
- O problema é determinar quantas diferentes maneiras existem para alcançar um determinado total de pontos 
   em um jogo de futebol americano.

# STACK
- Linguagem: Java 17
- Biblioteca usada: Spring Boot
- Biblioteca de Teste: jUnit e Mockito
- Containerização: Docker

# COMO EXECUTAR A APLICAÇÃO LOCALMENTE
JAVA JDK 17 INSTALADO
   - cd <pasta-onde-está-o-projeto>/TesteSol-main
   - mvn spring-boot:run
     Abra seu postman e vá para http://localhost:8080/verify (ou a porta que você configurou, se for diferente).

# ATRAVES DO DOCKER
   - cd <pasta-onde-está-o-projeto>/TesteSol-main
   - docker build -t teste-studiosol .
   - docker run -p 8080:8080 teste-studiosol 
     Abra seu postman e vá para http://localhost:8080/verify (ou a porta que você configurou, se for diferente).

### PROCESSO DE DESENVOLVIMENTO ###

# PROCESSO PARA CALCULAR AS COMBINAÇÕES
    QUEBREI O PROBLEMA EM 3 PARTES:
            1- Separei a string do score com o split "x" e peguei os valores da parte [0] e [1] e convertir para inteiro.
            2- Calculei as combinaçoes de cada time separadamente.
            3- Multipliquei as pontuaçoes dos 2 times para ter o total de possibilidades.

# EXPLICAÇÃO DETALHADA:

- CALCULO DAS COMBINAÇOES DOS TIMES:

    1- Análise das Jogadas:
        Primeiramente, identifiquei as jogadas que resultam em pontos: Touchdown (6 pontos), Touchdown com extra 
        (7 ou 8 pontos), e Field Goal (3 pontos).
    2- Combinaçoes de Jogadas:
        Para determinar quantas combinações de jogadas resultam em uma pontuação total, começamos subtraindo os pontos 
        de cada jogada possível da pontuação alvo. Por exemplo, para uma pontuação total de 15 pontos, começamos subtraindo 
        3 pontos (um field goal). Isso nos deixa com 12 pontos. 
        Em seguida, analisamos todas as combinações de jogadas que podem resultar em 12 pontos.
    3- Construção da Árvore de Combinações:
        Ao subtrair uma jogada específica da pontuação total, obtemos uma sub-pontuação. 
        Repetimos o processo para essa sub-pontuação, considerando novamente todas as jogadas possíveis. 
        Continuamos essa decomposição recursiva até que a sub-pontuação chegue a zero (indicando uma combinação válida) 
        ou a um valor negativo (indicando uma combinação inválida).
    4- Combinações Impossíveis:
        Se ao subtrair uma jogada da pontuação total, obtemos uma pontuação que não é válida no futebol americano 
        (por exemplo, subtrair 3 pontos de uma pontuação total de 5 nos deixa com 2 pontos, o que não é possível), 
        sabemos que essa combinação não pode resultar na pontuação desejada.
    OBS: A lógica é repetida para todas as pontuaçoes do mais baixo, ao valor marcado pelo time, assim os valores podem ser 
    reutilizados e nao aconteça a repetição dos mesmo calculos.

- MULTIPLICAR A PONTUAÇÃO DOS TIMES
    1 - Após encontrar quantas combinaçoes possiveis de cada time, basta multiplicar os seus respectivos valores 
        para obter o número total de possibilidades.
    OBS: Se algum dos times tiver pontuação 0, o resultado tambem sera 0, assim mostrando que é um score impossivel.


## OTIMIZAÇÃO DO ALGORITMO 
    O algoritmo atualmente possui uma complexidade de tempo linear, O(n), onde 'n' é a pontuação fornecida. 
    Apesar de partidas de futebol americano geralmente não resultarem em placares muito altos, ainda é possível 
    otimizar o algoritmo para evitar recalculos desnecessários entre requisições.

    Implementei um cache para armazenar os cálculos de combinações previamente feitos entre requisições para melhorar 
    ainda mais a eficiência do algoritmo transformando em um tempo constante O(1). Isso significa que se uma pontuação 
    já foi calculada anteriormente, ao invés de recalculá-la, podemos simplesmente recuperar o resultado do cache, 
    reduzindo assim o tempo de processamento.
    
    Essa abordagem é útil mesmo em cenários onde as pontuações são baixas, pois evita a repetição de cálculos e melhora a 
    resposta do sistema, especialmente em ambientes com múltiplas requisições.

- OS 3 PASSOS USADOS PARA CALCULAR A COMPLEXIDADE
        1- Considerar apenas as repetiçoes do codigo.
        2- Verificar a complexidade das funçoes metodos proprios da linguagem(Se utilizado)
        3- Ignorar as contastens e utilizar o termo de maior grau
[TesteSol-main.zip](..%2F..%2F..%2F..%2F..%2FIsrael%2FDownloads%2FTesteSol-main.zip)