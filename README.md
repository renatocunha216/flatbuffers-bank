# flatbuffers-bank
[![en](https://github.com/renatocunha216/common/blob/main/images/lang-en.svg?raw=true)](https://github.com/renatocunha216/flatbuffers-bank/blob/main/README.en.md)
[![pt-br](https://github.com/renatocunha216/common/blob/main/images/lang-pt-br.svg?raw=true)](https://github.com/renatocunha216/flatbuffers-bank/blob/main/README.md)

Exemplo de uso da biblioteca [FlatBuffers](https://flatbuffers.dev/) para criar
um arquivo binário com dados simulados de transações bancárias.

FlatBuffers é uma biblioteca Open Source multi plataforma, criada pelo Google, para **serializar**
dados de forma eficiente e performática.

FlatBuffers suporta as seguintes linguagens de programação: C++, C#, C, Go, Java, Kotlin,
JavaScript, Lobster, Lua, TypeScript, PHP, Python, Rust and Swift.

FlatBuffers pode ser utilizado para trocar dados entre sistemas e/ou processos
em que o desempenho é um requisito crítico, seja devido ao volume de dados
ou ao tempo de resposta. Pode ser uma ótima opção aos formatos JSON e XML
princialmente para linguagens com tipagem estática como Java, C, C++, etc.<br>
Os dados serializados utilizando FlatBuffers podem ser utilizados em memória,
armazenados em arquivos, enviados através de uma rede, etc.

O formato dos dados é definido em um `schema` utilizando uma linguagem IDL (Interface Definition Language).

Abaixo um exemplo de um schema do FlatBuffers onde definimos um objeto do tipo
tabela chamado **Bank**.

```java
namespace br.com.rbcti.flatbuffers.tb;

table Bank {
    name: string;
    bank_code: int32;
}

root_type Bank;
```

Mais detalhes de como criar um schema acesse a documentação oficial.
[Writing a schema](https://flatbuffers.dev/flatbuffers_guide_writing_schema.html).

Neste projeto de exemplo também temos um exemplo mais completo no arquivo
[BankTransactions.fbs](https://github.com/renatocunha216/flatbuffers-bank/blob/main/idl/BankTransactions.fbs).

Uma vez definido o schema, utilize o compilador `flatc` para gerar os artefatos
que serão responsáveis pela escrita e leitura dos dados na linguagem de
programação de sua escolha.

Exemplo:<br>
`flatc --java Common.fbs BankTransactions.fbs`


### Exemplo de uso

Este projeto contém uma classe chamada [BankTransactionWriter.java](https://github.com/renatocunha216/flatbuffers-bank/blob/main/java/src/main/java/br/com/rbcti/flatbuffers/BankTransactionWriter.java)
que cria um arquivo binário com os dados construídos pelo FlatBuffers.

Executando o método **main** da classe BankTransactionWriter temos o seguinte resultado.

Com verificação dos dados.
```
Start test.
Check data        : true
Total transactions: 1.000.000
C:\Users\renato\bankTransaction.bin file was successfully created.
File lenght             : 90.400.040 bytes
Buffer build time       : 1241 ms
Read time and check time: 1274 ms
End test.
```
Sem a verificação dos dados.
```
Start test.
Check data        : false
Total transactions: 1.000.000
C:\Users\renato\bankTransaction.bin file was successfully created.
File lenght             : 90.400.040 bytes
Buffer build time       : 1249 ms
Reading time            : 532 ms
End test.

```
