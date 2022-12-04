# Observer, eventos e listeners

Este módulo permite que seja possível transformar objetos em eventos publicáveis (extends Observable) e criar classes que Observam os eventos (extends Observer(T extends Observable)).

Além disso, já carrega uma configuração que habilita eventos assíncronos. Basta ir no main, e em cima de @SpringBootApplication colocar @EnableAsync. Além disso, é necessário ir no método onApplicationEvent no Observer gerado e anotar o método com @Async.
