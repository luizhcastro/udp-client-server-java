## Projeto Cliente-Servidor UDP em Java com Docker
Este é um projeto acadêmico para a disciplina de Sistemas Distribuídos que demonstra a comunicação em tempo real, caractere por caractere, entre um cliente e um servidor utilizando o protocolo UDP.

Todo o ambiente é orquestrado com Docker, simulando a comunicação entre duas máquinas distintas em uma rede virtual isolada.

### Pré-requisitos:
- Docker instalado e em execução na sua máquina.

### Como executar:
- `docker-compose build`
- `docker-compose up -d server`
- `docker-compose run client`
- Digite qualquer texto e pressione `Enter`. A aplicação cliente enviará cada caractere ao servidor
- Verifique a Saída do Servidor com `docker-compose logs -f server`
