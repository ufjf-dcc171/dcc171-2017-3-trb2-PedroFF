# ufjf-dcc171-2017-3-trb1-PedroFF
ufjf-dcc171-2017-3-trb1-PedroFF created by GitHub Classroom


Nome: Pedro Fernandes Freitas 

Matrícula: 201576039

2. Cenário do sistema:
  O sistema foi pensado para suprir a demanda de uma casa de shows. Na casa, podem existir várias mesas e nas mesas nós
podemos ter mais de um pedido por dois motivos: 1- Uma família podia estar na mesa 1. Quando ela for embora, o pedido será
fechado e outras pessoas podem ocupar a mesa 1. O que permite que tenhamos um pedido fechado e um aberto. 2- Suponhamos que
alguns colegas vão sentar juntos, mas cada um terá sua comanda, o que permite ter mais de um pedido aberto ao mesmo tempo.
  Assim que o pedido é criado, ele já guarda a hora de abertura. Pode ser adicionado novos itens ao pedido, toda vez que é
adicionado, ele calcula o valor parcial e quando o pedido for fechado, ele mostra o valor final total do pedido e também a hora 
que o pedido foi fechado. Após o pedido ser fechado se torna impossível adicionar mais itens.
  O sistema também possui uma função de cardápio, no qual aparece a lista de produtos disponíveis e seu respectivos preços.

3. Modelo de dados:
  O modelo de dados foi feito na ferramenta Astah e está disponível no link abaixo:
https://drive.google.com/open?id=0B5pA2JYfU-fbT0dLTW85N0lIVTg

4. Campos necessários para construção das telas:
  Foram necessários JTextFields modificados para só receberem números, JLabels para disponibilizar informações, JPanel para poder organizar melhor a tela dentro dos layouts disponíveis e  JButton para a criação de botões.
  
5. Descrição de pontos importantes:
  O sistema começa com Itens pré-definidos e uma mesa aberta. O sistema permite a criação de mais de um pedido por mes e assim 
que o pedido é feito, aparece na tela ao lado a descrição desse pedido e o valor parcial da conta. Assim que o pedido for 
fechado, não é  mais possível adicionar itens ao mesmo e também não é permitido excluir a mesa na qual o pedido se localiza
pois se não os detalhes do pedido seriam perdidos.

6. Pontos de maior dificuldade:
  Os pontos que mais tive dificuldade na implementação foram as trocas de mensagens entre janelas e também a implementação de
estruturas dinâmicas para criação de itens.

7. Futuras Melhorias:
  Bom, o sistema está muito estático, ele funciona baseado no conjunto de produtos pré-definidos. Atende os requisitos do
tabalho, porém seria muito melhor evoluir o sistema para que o Funcionário pudesse adicionar, alterar e excluir itens do 
cardápio. Acredito que essa seja a maior funcionalidade que falta no sistema. É claro que ele também é ainda bem cru, sem
estilizações para que antenda os requisitos de interação Humano Computador(IHC). A união desse sistema com Banco de Dados é
também mais uma melhoria a ser feita.
