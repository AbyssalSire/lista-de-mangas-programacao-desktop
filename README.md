# Lista de mangás para a disciplina de Programação Desktop
Atividade avaliativa da Disciplina de Programação Desktop (SO35A), turma ES51 da Universidade Tecnológica Federal do Paraná, curso Engenharia de Software.

Disciplina ministrada por Fabricio M. Lopes, cujo e-mail é fabricio@utfpr.edu.br .

##Proposta base da avaliação
Criaçã de um projeto que possua pelo menos três telas, organizado no modelo MVC (model, view, control), com a função de escrita e leitura de arquivos em memória (posteriormente em um banco de dados)

O programa tem como premissa a criação de uma lista de mangás (quadrinhos japoneses publicados em diversos volumes), a ideia veio de minha necessidade como alguém que coleciona de anotar as séries que estou acompanhando e quais volumes ainda preciso comprar de cada série, coisa muito comum já que muitas vezes os volumes que esgotam demoram muito tempo para serem impressos novamente.

A aplicação deve disponibilizar ao usuário as informações que foram cadastradas, permitindo que feche a aplicação e a execute novamente em um momento posterior. Essas informações devem ser armazenadas em um ou mais arquivos texto. A lógica de como implementar é livre, levando em consideração que as funcionalidades CRUD funcionem adequadamente.

Podem se basear nos códigos apresentados durante as aulas, ou seja códigos ensinados e apresentados em aula pelo professor.

## Descrição do projeto
As funcionalidades básicas são:

-> a criação da lista (feita automaticamente, iniciada vazia);

-> leitura (caso o arquivo já exista no sistema);

-> a adição de novos títulos (com a opção de uma descrição da série ou história);

-> a adição de números de volumes em cada título;

-> a remoção de volumes em cada título;

-> a exclusão de títulos;

-> O projeto cria e adiciona automaticamente 3 mangás caso não detecte o arquivo de texto que representa os dados no sistema

Existem 3 telas, a Janela_Main, onde o usuário pode pesquisar por título, procurar todos os títulos armazenados e adicionar um novo título. Ao se clicar no X no topo superior direito da janela a aplicação termina.

Ao se procurar um título específico você pode entar na Janela_Manga onde se encontrará as todas as informações de uma determinada série, como o Título, a Descrição e os volumes que deseja armazenar. Nesta página é possível alterar a descrição do mangá. Nesta página também é possível de se adicionar ou remover volumes por meio de uma pequena caixa de texto e de dois botões sendo eles "+" e "-". Os volumes adicionados são atualizados automaticamente. Também é possível remover por completo a série ao se clicar no botão vermelho "Remover mangá da lista", note que ao se clicar nessa opção a janela é fechada automaticamente e você retorna para a Janela_Main. Ao se clicar no X no topo superior direito a janela é fechada e se retorna para a Janela_Main.

Ao se clicar em "Mostrar todos os mangás" na Janela_Main será aberta a Janela_Mostrar_Todos onde o usuário poderá ver, em uma tabela, todos os mangás já adicionados na lista, incluindo sua descrição e volumes desejados. Ao se cliclar no X no topo superior página, a janela é fechada e se retorna para a Janela_Main.

## ENUNCIADO ATIVIDADE AVALIATIVA 1

>Implementação Leitura e Escrita em Arquivo Texto
>
>Desenvolver uma aplicação desktop (o tema é de livre escolha) que implemente pelo menos 3 janelas com o cadastramento de informações e as operações CRUD (Inserir, Alterar, Consultar e Excluir) em cada uma das janelas (interfaces gráficas). Podem se basear nos códigos apresentados durante as aulas. Sugestão de seguirem o padrão de projeto MVC (model, view, controller) apresentado em aula.
>
>A aplicação deve disponibilizar ao usuário as informações que foram cadastradas, permitindo que feche a aplicação e a execute novamente em um momento posterior. Essas informações devem ser armazenadas em um ou mais arquivos texto. A lógica de como implementar é livre, levando em consideração que as funcionalidades CRUD funcionem adequadamente.
>
>Por exemplo, para a implementação de uma janela Cliente é esperado que tenham três classes: JanelaCliente, ControllerCliente e a classe Cliente (model). Logo, é esperada a implementação para três conjuntos como esse e assim, conseguir generalizar a implementação. Uma sugestão é que sejam implementadas as ações do CRUD (incluir, alterar, excluir e consultar, usando um ArrayList), assim as informações podem ser trabalhadas em memória principal e persistidas em arquivo antes da finalização da aplicação.
>
>Crie os pacotes que julgar necessário e entregue a pasta "src" do seu projeto de forma compactada (i.e., todo o código fonte escrito que permita a execução de sua aplicação).
>
>Qualquer dúvida perguntem em aula, enviem e-mail, postem dúvidas no mural, etc.
>
>A implementação deve ser realizada individualmente, cópia recebe zero.
>
>Tenham todos um ótimo trabalho!

### NOTA: 100/100

## ENUNCIADO ATIVIDADE AVALIATIVA 2

>Implementação Leitura e Escrita em Arquivo Binário
>
>Desenvolver uma aplicação desktop, em continuidade com a atividade avaliativa 01, ou seja, acrescentar a funcionalidade do leitura e escrita em arquivos binários. Deverá implementar pelo menos 3 janelas com o cadastramento de informações e as operações CRUD (Inserir, Alterar, Consultar e Excluir) em cada uma das janelas (interfaces gráficas). Podem se basear nos códigos apresentados durante as aulas. Sugestão de seguirem o padrão de projeto MVC (model, view, controller) apresentado em aula.
>
>A aplicação deve disponibilizar ao usuário as informações que foram cadastradas, permitindo que feche a aplicação e a execute novamente em um momento posterior. Essas informações devem ser armazenadas em um ou mais arquivos binários. A lógica de como implementar é livre, levando em consideração que as funcionalidades CRUD funcionem adequadamente.
>
>Por exemplo, para a implementação de uma janela Cliente é esperado que tenham três classes: JanelaCliente, ControllerCliente e a classe Cliente (model). Logo, é esperada a implementação para três conjuntos como esse e assim, conseguir generalizar a implementação. Uma sugestão é que sejam implementadas as ações do CRUD (incluir, alterar, excluir e consultar, usando um ArrayList), assim as informações podem ser trabalhadas em memória principal e persistidas em arquivo antes da finalização da aplicação.
>
>Crie os pacotes que julgar necessário e entregue a pasta "src" do seu projeto de forma compactada (i.e., todo o código fonte escrito que permita a execução de sua aplicação).
>
>Qualquer dúvida perguntem em aula, enviem e-mail, postem dúvidas no mural, etc.
>
>A implementação deve ser realizada individualmente, cópia recebe zero.
>
>Tenham todos um ótimo trabalho!
