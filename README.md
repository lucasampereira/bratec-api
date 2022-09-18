# Projeto Bratec - API

<h3> Sprint 4 do Challenge - Digital Business Enablement </h3>

<h2> Sobre o projeto </h2>

<p> O desafio proposto pela FIAP aos alunos de 2022 é uma parceria com as empresas Plusoft e CPQD, onde tivemos como tema o uso da inteligência artificial com interfaces de voz como diferencial no relacionamento entre pessoas nos canais
digitais.</p>
<p>A solução pensada pelo grupo é um aplicativo voltado à Shoppings e seus visitantes, onde um visitante poderá procurar por um local específico do shopping via texto ou voz, e receberá orientações sobre como chegar até o local, através de voz e representação gráfica do mapa.</p>
<p>Um visitante poderá se cadastrar na plataforma para receber notificações com descontos exclusivos e adicionar locais visitados aos seus favoritos. Todos os locais do Shopping que podem ser acessados pelos visitantes serão mapeados, além disso,
as lojas parceiras podem se cadastrar para se promoverem através de anúncios que aparecerão aos usuários cadastrados. Um visitante também poderá consultar através de uma lista todas as lojas disponíveis no shopping onde está no momento.</p>

<h2> EndPoints </h2>

<table border="1">
    <tr>
        <td>Método</td>
        <td>Função</td>
        <td>Usuário</td>
        <td>Local</td>
    </tr>
    <tr>
        <td>GET</td>
        <td>Listar todos</td>
        <td>https://localhost:8080/api/user</td>
        <td>https://localhost:8080/api/local</td>
    </tr>
    <tr>
        <td>GET</td>
        <td>Detalhar</td>
        <td>https://localhost:8080/api/user/**</td>
        <td>https://localhost:8080/api/local/**</td>
    </tr>
    <tr>
        <td>POST</td>
        <td>Cadastrar</td>
        <td>https://localhost:8080/api/user/</td>
        <td>https://localhost:8080/api/local/</td>
    </tr>
    <tr>
        <td>PUT</td>
        <td>Atualizar</td>
        <td>https://localhost:8080/api/user/**</td>
        <td>https://localhost:8080/api/local/**</td>
    </tr>
    <tr>
        <td>DELETE</td>
        <td>Remover</td>
        <td>https://localhost:8080/api/user/**</td>
        <td>https://localhost:8080/api/local/**</td>
    </tr>
</table>

<h2>Funcionalidades</h2>

<p>Dentre as funcionalidades do backend, podemos listar o cadastro de usuários e lojas parceiras, listagem e detalhamento dos mesmos, além de remover ou editar seus dados. </p>

<h4> Grupo </h4>
<ul>
  <li> Isabela Bianca Correa de Macedo - 88493 </li>
  <li> Jonatan Jacó Mascalhusk De Oliveira Souza - 88221 </li>
  <li> Lucas Amorim Marques Pereira - 84659 </li>
  <li> Rodrigo Gonzalo Barbosa Segura - 83954 </li>
</ul>
