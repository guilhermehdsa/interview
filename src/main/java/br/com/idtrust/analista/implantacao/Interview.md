
### Usando o conceito de lógica de programação, sem se importar muito com a sintaxe correta, faça os exercícios a seguir:
---

##### 1 - Monte a estrutura condicional if/else para as regras abaixo e no final o que será mostrado para cada valores:

    Regras:
	- homens a partir de 65 anos, escrever APOSENTADO;
	- mulheres a partir de 60 anos, escrever APOSENTADA;
	- pessoas entre 13 que 18 anos, escrever ADOLESCENTE;
	- pessoas menores que 13 anos, escrever CRIANÇAS;
	- todos os outros, escrever ADULTO;

Lista de valores para o teste: sexo;idade
	
	a) masculino;74
	b) feminino;4
	c) feminino;13
	d) masculino;60
	e) masculino;19
	f) feminino;60
	
	String sexo = "feminino";
        Integer idade = 60;

        if (sexo == "masculino" && idade >= 65) {
               System.out.println("APOSENTADO");
        } else if (sexo == "feminino" && idade >= 60) {
               System.out.println("APOSENTADA");
        } else if (idade >= 13 && idade <= 18) {
               System.out.println("ADOLESCENTE");
        } else if (idade < 13) {
               System.out.println("CRIANÇAS");
        } else {
               System.out.println("ADULTO");
        }

---

##### 2 - De acordo com o algoritmo a seguir, escolha uma das alternativas abaixo.
```
contador :=  3
soma  := 57
for (contador <= 10 ) {
	if (contador < 5 || contador == 8 ) {
		soma := soma - contador
    } else {
            soma = soma + contador
    }
	contador++
} 
print(“O valor da soma é ” + soma)
```

	a) O valor da soma é 57
	b) O valor da soma é 69
	c) O valor da soma é 79 xx
	d) O valor da soma é 93

