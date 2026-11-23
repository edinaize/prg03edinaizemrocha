\# Auditoria SOLID



\## Os cinco princípios SOLID



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









