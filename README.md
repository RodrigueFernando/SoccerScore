# SoccerScore 

Aplicativo Android desenvolvido em Kotlin utilizando Jetpack Compose e Navigation Compose para simular o placar de uma partida de futebol.

---

#  Funcionalidades

O aplicativo possui 3 telas:

## 1. Tela de Configuração
Permite informar:
- Nome do Time A
- Nome do Time B
- Gols do Time A
- Gols do Time B

### Validações
- Todos os campos obrigatórios
- Gols devem ser números inteiros maiores ou iguais a zero

---

## 2. Tela de Resumo
Exibe:
- Nome dos times
- Placar da partida

### Ações
- Confirmar Resultado
- Editar dados da partida

---

## 3. Tela de Resultado Final
Exibe:
- Time vencedor
- Ou empate da partida

### Regras
- Se golsA > golsB → "Time A venceu!"
- Se golsB > golsA → "Time B venceu!"
- Se empate → "Empate emocionante!"

### Ação
- Novo Jogo

---

#  Tecnologias utilizadas

- Kotlin
- Jetpack Compose
- Navigation Compose
- Material 3

---

#  Requisitos do projeto

| Requisito | Versão |
|---|---|
| Android mínimo | API 26 |
| Android Studio | Panda 1 |
| Kotlin | 2.2 |
| Gradle | 9.2.1 |
| AGP | 9.0.1 |

---

#  Estrutura do projeto

* MainActivity → Navegação entre as telas
* TelaConfiguracao → Tela 1
* TelaResumo → Tela 2
* TelaResultadoFinal → Tela 3

--
#  Objetivo

Desenvolver um aplicativo Android com 3 telas utilizando Jetpack Compose e Navigation Compose, permitindo cadastrar uma partida, visualizar o resumo do jogo e exibir o resultado final.


##  Autor

Fernando Rodrigues
