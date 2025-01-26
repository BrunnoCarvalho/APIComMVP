# Aplicativo com Padrão de Arquitetura MVP (Model-View-Presenter)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white) ![Android Studio](https://img.shields.io/badge/android%20studio-346ac1?style=for-the-badge&logo=android%20studio&logoColor=white)

Este projeto demonstra como implementar a arquitetura **MVP (Model-View-Presenter)** em um aplicativo Android. O objetivo principal é consumir postagens da API [JsonPlaceHolder](https://jsonplaceholder.typicode.com/) e organizar o código de forma clara e modular, seguindo os princípios dessa arquitetura.

## 🛠️ Estrutura do Projeto  

### 🟥 Model  
Responsável por:  
- Realizar chamadas à API para recuperar as postagens.  
- Processar e fornecer os dados ao **Presenter**.  

### 🟩 View  
Responsável por:  
- Exibir as informações para o usuário.  
- Definir métodos que o **Presenter** pode chamar para atualizar a interface.  

No projeto, a **View** é implementada pela `MainActivity`, que:  
- Apresenta os dados na interface do usuário.  
- Não realiza lógica de negócios, apenas cuida da exibição.  
- Chama o **Presenter** no método `onStart()` para iniciar o fluxo de dados.  

### 🟪 Presenter  
Responsável por:  
- Fazer a ponte entre o **Model** e a **View**.  
- Controlar o fluxo de dados da aplicação.  
- Solicitar os dados ao **Model** e enviá-los para a **View** exibi-los.

## Fluxo de Funcionamento  
1. A **View** (`MainActivity`) inicia o fluxo chamando o **Presenter** no método `onStart()`.  
2. O **Presenter** solicita os dados ao **Model**.  
3. O **Model** realiza a chamada à API e retorna os dados ao **Presenter**.  
4. O **Presenter** processa os dados e os passa para a **View**, que os exibe para o usuário.

## 📂 Organização dos Pacotes

- **`model`**: Contém classes responsáveis pela lógica de dados, como:
  - **Representações de Dados**: Classes como `Postagem`, que representam as entidades de dados que são manipuladas dentro do sistema.
  - **PostagemAPI**: Classe que faz a recuperação de postagens da API, fazendo chamadas configuradas no pacote `api`.

- **`api`**: Contém as configurações relacionadas ao acesso à API externa, como:
  - **RetrofitService**: Classe responsável por criar e fornecer instâncias de JsonPlaceAPI usando o cliente Retrofit, configurado com o URL base e o conversor Gson.
  - **JsonPlaceAPI**: Interface que define os endpoints e métodos de chamada para a API externa.

- **`view`**: Contém classes responsáveis pela interface com o usuário (UI), como a `MainActivity`.

- **`presenter`**:
- Contém o `PostagemPresenter`, que conecta o **Model** e a **View**.
- Contém **`IPostagemPresenter`**: Interface que a `MainActivity` deve implementar para receber dados do `PostagemPresenter`.

  
## 💡 **Vantagens do MVP em relação ao MVC**

1. **Desacoplamento entre View e Presenter:**
   - No MVP, a `View` (ex.: `MainActivity`) implementa uma interface (`IPostagemPresenter`) e o `Presenter` se comunica com a `View` através dela. Isso reduz o acoplamento entre as camadas, tornando o código mais modular e fácil de manter.

2. **Facilidade para Testes:**
   - Como o `Presenter` não depende diretamente da `View`, é possível realizar testes unitários simulando a interface da `View` com mocks. Isso melhora a testabilidade do código.

3. **Manutenção e Escalabilidade:**
   - Separar responsabilidades em diferentes camadas facilita a manutenção do código e torna mais simples adicionar novos recursos ou fazer alterações.

4. **Reutilização de Código:**
   - O `Presenter` é desacoplado da interface do usuário, permitindo sua reutilização em diferentes telas ou projetos. Como o `Presenter` interage com a interface e não com a implementação concreta da `View`, ele pode ser usado por outras `Activity` ou `Fragment` que implementem a mesma interface.

## 🚨 **Desvantagens do MVP**

1. **Controle do Ciclo de Vida:**
   - O `Presenter` precisa gerenciar explicitamente o ciclo de vida da `Activity`. Caso isso não aconteça, corrotinas ou dados armazenados podem continuar em execução, gerando **memory leaks**.
    
2. **Rotação de Tela:**
   - Quando a tela é rotacionada, a `Activity` é destruída e recriada, o que significa que o `Presenter` precisa controlar a persistência dos dados. Caso contrário, ele não manterá as informações, o que pode resultar na perda de dados ou comportamentos inesperados.

3. **Dependência Cíclica:**
No MVP, a `MainActivity` depende do `PostagemPresenter` para a lógica de negócios, e o `PostagemPresenter` depende da interface `IPostagemPresenter` para exibir os dados. Isso cria uma dependência mútua que pode dificultar a testabilidade isolada e aumentar a complexidade dos testes, já que é necessário mockar a interface. Além disso, essa dependência cíclica pode tornar o código mais difícil de entender e manter.

## 🧑‍💻 Contato
Entre em contato! 😁

**Bruno Vivian Carvalho**

[![Linkedin Badge](https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/bvcarvalho/)](https://www.linkedin.com/in/bvcarvalho/)


