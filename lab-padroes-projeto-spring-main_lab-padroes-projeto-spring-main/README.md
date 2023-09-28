# Explorando Padrões de Projetos na Prática com Java

Repositório com as implementações dos padrões de projeto explorados no Lab "Explorando Padrões de Projetos na Prática com Java". O projeto é baseado no que foi apresentado durante as aulas, porém com algumas implementações:

# Padrão de Projeto Observer:

O padrão Observer foi adicionado para permitir que observadores se inscrevam e recebam notificações quando um novo cliente é inserido no sistema. Agora a classe "ClienteRestController" possui métodos para adicionar, remover e notificar observadores. O intuito é criar uma estrutura flexível para notificar sobre eventos importantes no sistema, como a inserção de um novo cliente. Isso pode ser útil para log, auditoria, envio de notificações, ou qualquer outra ação que deve ser tomada quando um cliente é inserido.

# Padrão de Projeto Command:

O padrão Command foi implementado para encapsular as ações que devem ser executadas quando um cliente é inserido no sistema. Cada comando é criado e armazenado em um invocador, que pode executar todos os comandos em sequência. O intuito é separar a solicitação de uma ação (inserir cliente) do objeto que realiza a ação (comando). Ou seja, os comandos são usados para inserir clientes no sistema, permitindo a execução ordenada das ações necessárias.

# Padrão de Projeto Chain of Responsibility:

O padrão Chain of Responsibility foi implementado para validar os dados do cliente antes de inseri-lo no sistema. O intuito é criar uma corrente de manipuladores que podem processar uma solicitação (validação) em sequência.
