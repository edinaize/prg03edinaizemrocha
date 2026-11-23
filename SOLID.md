\# Auditoria SOLID



\## Task1: Os cinco princípios SOLID



\### SRP: Single Responsibility Principle

\- \*\*Arquivo:\*\* `br/com/ifba/artista/validar/ValidadorArtista.java`

\- \*\*Trecho:\*\* método `estiloValido(String estilo)`, linha 14

\- \*\*Por quê:\*\* a classe tem uma única razão para mudar: a regra de validação

&#x20; do estilo do artista. Ela não acessa banco, não monta tela e não conhece o

&#x20; service. O mesmo vale para `ValidadorUsuario`, para `ValidadorObra` e para

&#x20; `ValidadorPerfil`.



\### OCP: Open/Closed Principle

\- \*\*Arquivo:\*\* `br/com/ifba/infrastructure/dao/GenericDao.java`

\- \*\*Trecho:\*\* classe `GenericDao<Entity>`, linha 18

\- \*\*Por quê:\*\* o CRUD (`save`, `update`, `delete`, `findById`, `findAll`) está

&#x20; fechado para modificação. Para suportar uma nova entidade, estende-se a

&#x20; classe, sem editá-la. `ArtistaDao`, `UsuarioDao`, `ObraDao` e `PerfilDao`

&#x20; fazem isso e só acrescentam suas consultas específicas, como `pesquisar` e

&#x20; `findByLogin`.



\### LSP: Liskov Substitution Principle

\- \*\*Arquivo:\*\* `br/com/ifba/artista/service/ArtistaService.java`

\- \*\*Trecho:\*\* método `validar(Artista artista)`, chamada

&#x20; `usuarioService.validar(artista)`, linha 30

\- \*\*Por quê:\*\* `validar` espera um `Usuario` e recebe um `Artista`, que é

&#x20; subclasse, sem precisar de cast nem de tratamento especial. O mesmo ocorre

&#x20; em `TelaCadastroUsuario.jButton1ActionPerformed`, onde a variável

&#x20; `Usuario usuario` recebe um `new Artista(...)` e segue pelo mesmo fluxo.



\### ISP: Interface Segregation Principle

\- \*\*Arquivo:\*\* `br/com/ifba/usuario/interfaces/Autenticavel.java`

\- \*\*Trecho:\*\* interface inteira, linha 13

\- \*\*Por quê:\*\* a interface tem um único método (`autenticar`). Quem precisa

&#x20; autenticar, como `TelaLogin.processar(Autenticavel, ...)`, depende só disso,

&#x20; e não do `Usuario` inteiro com seus getters e setters.



\### DIP: Dependency Inversion Principle

\- \*\*Arquivo:\*\* `br/com/ifba/artista/service/ArtistaService.java`

\- \*\*Trecho:\*\* construtor `ArtistaService(ArtistaIDao dao, UsuarioIService usuarioService)`, linha 23

\- \*\*Por quê:\*\* o service depende de interfaces (`ArtistaIDao`,

&#x20; `UsuarioIService`), não de `ArtistaDao` ou `UsuarioService`. As

&#x20; implementações concretas são escolhidas e injetadas no `Main.java`

&#x20; (método `main`, linha 34). As telas também recebem `UsuarioIController` e

&#x20; `ArtistaIController` por construtor.







\## Task 02: violações encontradas



\### V1: SRP violado em `TelaCadastroUsuario.jButton1ActionPerformed`

\- \*\*Arquivo:\*\* `br/com/ifba/usuario/view/TelaCadastroUsuario.java`, linhas 246 a 341

\- \*\*Princípio violado:\*\* Single Responsibility

\- \*\*Por quê:\*\* um único método da tela faz seis coisas: lê os campos, valida

&#x20; (gênero e senhas), decide qual entidade criar (`Artista` ou `Usuario`),

&#x20; preenche a entidade, chama o controller (`save`, `update` ou `validar`) e

&#x20; navega para outra tela. A tela muda por motivos de interface, de regra de

&#x20; cadastro e de fluxo de navegação, o que são três razões para mudar.



\### V2: LSP violado em `Artista.autenticar`

\- \*\*Arquivo:\*\* `br/com/ifba/artista/entity/Artista.java`, linhas 94 a 100

\- \*\*Princípio violado:\*\* Liskov Substitution

\- \*\*Por quê:\*\* `Usuario.autenticar` retorna `true` quando login e senha batem.

&#x20; `Artista.autenticar` acrescenta uma condição (`estilo` não pode estar em

&#x20; branco) e retorna `false` para as mesmas credenciais corretas. Um código

&#x20; que recebe um `Usuario` e autentica passa a ter comportamento diferente

&#x20; conforme o objeto seja um `Artista`, e a subclasse não pode substituir a

&#x20; superclasse com segurança. O estilo é regra de cadastro, e não de

&#x20; autenticação.



\### V3: DIP violado em `TelaLogin.btnEntrarActionPerformed`

\- \*\*Arquivo:\*\* `br/com/ifba/login/view/TelaLogin.java`, linhas 171 a 177

\- \*\*Princípio violado:\*\* Dependency Inversion

\- \*\*Por quê:\*\* a tela instancia `new Usuario()` com login e senha fixos

&#x20;  e autentica contra ele, em vez de depender de uma

&#x20; abstração (`UsuarioIController.findByLogin`). O `usuarioController` é

&#x20; recebido no construtor, mas não é usado no login. A regra de acesso fica

&#x20; presa a um objeto concreto criado dentro da própria tela.



\### V4: OCP violado em `TelaCadastroUsuario`

\- \*\*Arquivo:\*\* `br/com/ifba/usuario/view/TelaCadastroUsuario.java`, linhas 50, 282, 284 e 297

&#x20; (`if (tipoPerfil.equals("Artista"))` e o ternário no construtor de edição)

\- \*\*Princípio violado:\*\* Open/Closed

\- \*\*Por quê:\*\* a escolha do tipo é feita com comparação de String e `if/else`.

&#x20; Para criar um novo tipo de perfil (por exemplo, "Curador"), é preciso

&#x20; modificar esse método, o combo, o ternário `"Artista" : "Espectador"` e o

&#x20; `instanceof Artista`. O código deveria permitir a extensão sem editar essa

&#x20; lógica.



\### V5: DIP violado em `ObraService` e `GenericDao`

\- \*\*Arquivos:\*\* `br/com/ifba/obra/service/ObraService.java` (import de

&#x20; `ObraDao`, linha 7) e `br/com/ifba/infrastructure/dao/GenericDao.java`

&#x20; (`criarEntityManager`, linha 27)

\- \*\*Princípio violado:\*\* Dependency Inversion

\- \*\*Por quê:\*\* `ObraService` importa a implementação concreta `ObraDao`, embora

&#x20; só use `ObraIDao`. Esse import é desnecessário e cria dependência de uma

&#x20; classe de baixo nível. Já o `GenericDao` chama `JPAUtil.getEntityManager()`

&#x20; (estático e concreto), o que impede trocar ou simular a fonte de

&#x20; `EntityManager` em testes.







