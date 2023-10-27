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
`flatc --java Common.fbs BankTransactions.fbs`<br>
`flatc --cpp Common.fbs BankTransactions.fbs`

### Ferramentas utilizadas

**Flatbuffers**<br>
- [flatc](https://github.com/google/flatbuffers/releases) version 23.5.26<br>

**Java**<br>
- [Apache Maven](https://maven.apache.org/) 3.9.4<br>
- [OpenJDK](https://adoptium.net/) Runtime Environment Temurin-11.0.20+8<br>

**C++**<br>
- [MinGW-W64](https://www.mingw-w64.org/) - GCC version 8.1.0<br>
- [cmake](https://cmake.org/) 3.23.1<br>

### Exemplo de uso

Este projeto contém uma classe chamada [BankTransactionWriter.java](https://github.com/renatocunha216/flatbuffers-bank/blob/main/java/src/main/java/br/com/rbcti/flatbuffers/BankTransactionWriter.java)
que cria um arquivo binário com os dados construídos pelo FlatBuffers.

Executando o método **main** da classe BankTransactionWriter temos o seguinte resultado.

**Maven** `mvn compile exec:java -Dexec.mainClass="br.com.rbcti.flatbuffers.BankTransactionWriter"`

**Processor:** Intel Core i7-3632QM CPU @ 2.20GHz<br>
**OS:** Windows 7 Professional 64 bits<br>
**JVM:** OpenJDK Runtime Environment Temurin-11.0.19+7 (build 11.0.19+7)<br>
**HDD:** 5400 rpm<br>

Com verificação dos dados.
```
Start test.
Check data        : true
Total transactions: 1.000.000
C:\Users\renato\bankTransaction.bin file was successfully created.
File lenght             : 90.400.040 bytes
Buffer build time       : 1635 ms
Read time and check time: 1302 ms
End test.
```
Sem a verificação dos dados.
```
Start test.
Check data        : false
Total transactions: 1.000.000
C:\Users\renato\bankTransaction.bin file was successfully created.
File lenght             : 90.400.144 bytes
Buffer build time       : 1622 ms
Reading time            : 539 ms
End test.
```

**Processor:** Intel(R) Core(TM) i7-12700H<br>
**OS:** Windows 11 Pro 22H2<br>
**JVM:** OpenJDK Runtime Environment Temurin-17.0.8+7 (build 17.0.8+7)<br>
**SSD:** NVMe

Com verificação dos dados.
```
Start test.
Check data        : true
Total transactions: 1.000.000
C:\Users\rbcun\bankTransaction.bin file was successfully created.
File lenght             : 90.399.976 bytes
Buffer build time       : 563 ms
Read time and check time: 385 ms
End test.
```
Sem a verificação dos dados.
```
Start test.
Check data        : false
Total transactions: 1.000.000
C:\Users\rbcun\bankTransaction.bin file was successfully created.
File lenght             : 90.400.112 bytes
Buffer build time       : 554 ms
Reading time            : 191 ms
End test.
```

Para propósito de comparação veja o exemplo [protobuf-bank](https://github.com/renatocunha216/protobuf-bank) que utiliza a bilbioteca Protocol Buffers.
